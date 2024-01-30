package resolvers

import caliban.uploads.Uploads
import model.graphql.types.input.task.{AddReportFromFileTaskInput, AddReportTaskInput}
import report_main.reportHandler.layers.ReportDocumentUploader
import common.types._
import utils.S3Utils
import utils.tcontroller.TControllerClient
import zio.blocking.Blocking
import zio.clock.Clock
import zio.logging.Logging
import zio.random.Random
import zio._

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object UploadDocumentsResolver {
    implicit val ec: ExecutionContextExecutor = ExecutionContext.global

    private def getCurrentTimeStampInSec = System.currentTimeMillis / 1000

    def uploadByteArrayDocument(
                                   file: Array[Byte],
                                   fileName: String,
                                   userId: String,
                                   topic: String,
                                   messagePriority: MessagePriority,
                                   taskId: Long,
                                   accessLevel: Option[ID],
                                   trustLevel: Option[TrustLevel]
                               ): String = {
        val timestamp = getCurrentTimeStampInSec

        Runtime.default.unsafeRun(
            (for {
                fileJson <- S3Utils.saveToS3(file, fileName, userId, None, accessLevel, trustLevel.map(TrustLevel.enumToFloat), None)
                uuid <- TControllerClient.saveToTController(
                    taskId = taskId,
                    timestamp = timestamp,
                    topic = topic,
                    messagePriority = messagePriority,
                    fileJson = Some(fileJson),
                    relatedConceptId = None,
                    researchMapId = None
                )
            } yield uuid).provideLayer(Logging.console()))
    }

    private def uploadReportFromGql(input: AddReportTaskInput)(implicit ec: ExecutionContext) = {
        ZIO.collectAllSuccesses(input.files.map { file =>
            // TODO GENERATE TASKID
            for {
                taskId <- ZIO.succeed(ID("1"))
                _ <- ReportResolver(taskId, input.topic, input.accessLevel, input.trustLevel).resolveFromUpload(file)
            } yield taskId
        })
    }


    def uploadReportFromFile(input: AddReportFromFileTaskInput): ZIO[Logging with Random with Clock with Has[ReportDocumentUploader], Throwable, ID] = {
        implicit val ec: ExecutionContextExecutor = ExecutionContext.global
        for {
            // TODO GENERATE TASKID
            taskId <- ZIO.succeed(ID("1"))
            _ <- ReportResolver(taskId, input.topic, input.accessLevel, input.trustLevel).resolveFromFileSystem(input.fileName)
        } yield taskId
    }

    def uploadDocuments(input: AddReportTaskInput): ZIO[Blocking with Clock with Random with Uploads with Has[ReportDocumentUploader] with Logging, Throwable, Seq[ID]] =
        uploadReportFromGql(input)
}
