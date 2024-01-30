package resolvers

import caliban.uploads.{Upload, Uploads}
import org.apache.commons.io.FileUtils
import report_main.ReportHttpRequestSenderLive
import report_main.AutoUpdatableKeycloakToken
import report_main.reportHandler.ReportHandler
import report_main.reportHandler.layers.{ReportDocumentUploader, ReportHttpRequestSender}
import report_main.zipReader.AutodetectEncodingZipReader
import common.types.TrustLevel.enumToFloat
import common.types.{ID, TrustLevel}
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend
import utils.S3Utils
import zio.blocking.Blocking
import zio.clock.Clock
import zio.logging.{Logging, log}
import zio.random.Random
import zio.stream.ZSink
import zio.{Fiber, Has, RIO, ULayer, URIO, ZIO}

import java.io.File
import java.nio.file.Paths
import scala.concurrent.ExecutionContext

case class ReportResolver(
                             taskId: ID,
                             topic: String,
                             maybeAccessLevelId: Option[ID],
                             trustLevel: Option[TrustLevel]
                         )(implicit val ec: ExecutionContext) {
    private val mockedUserId = "userId"

    private def trySaveEnrichedReport(fileName: String, enrichedReport: Array[Byte]): URIO[Logging, Boolean] = {
        // TODO
        S3Utils.saveToS3(enrichedReport, fileName, mockedUserId, None, maybeAccessLevelId, trustLevel.map(enumToFloat), None)
            .fold(_ => false, _ => true)
    }

    def resolveFromUpload(file: Upload): RIO[Blocking with Clock with Random with Uploads with Has[ReportDocumentUploader] with Logging, Fiber[Throwable, Unit]] = {
        for {
            fileName <- file.meta.map(_.get.fileName)
            _ <- Uploads.stream(file.name).run(ZSink.fromFile(Paths.get(fileName)))
            reportHandlerFiber <- resolveFromFileSystem(fileName)
        } yield reportHandlerFiber
    }

    def resolveFromFileSystem(fileName: String): URIO[Logging with Clock with Random with Has[ReportDocumentUploader], Fiber.Runtime[Throwable, Unit]] = {
        AutodetectEncodingZipReader(fileName).readZip.use { zipFileWithEntries =>
            (for {
                reportHttpRequestSenderLiveLayer <- getReportHttpRequestSenderLiveLayer

                reportHandlerResult <- ReportHandler(zipFileWithEntries, mockedUserId, topic, taskId, maybeAccessLevelId).handle
                    .provideSomeLayer[Logging with Clock with Random with Has[ReportDocumentUploader]](reportHttpRequestSenderLiveLayer)

                _ <- log.info("Report handler fiber succeed") *>
                    trySaveEnrichedReport(reportHandlerResult.reportWorkbookResult.fileName, reportHandlerResult.reportWorkbookResult.newReportByteArray)
            } yield ())
                .ensuring(ZIO.succeed(FileUtils.deleteQuietly(new File(fileName))))
        }.forkDaemon
    }

    private def getReportHttpRequestSenderLiveLayer: RIO[Logging with Clock, ULayer[Has[ReportHttpRequestSender]]] = {
        for {
            client <- AsyncHttpClientZioBackend()
            (keycloakToken, _) <- AutoUpdatableKeycloakToken(client)
        } yield ReportHttpRequestSenderLive.getLayer(keycloakToken, client)
    }
}
