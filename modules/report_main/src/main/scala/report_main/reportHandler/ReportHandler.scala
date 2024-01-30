package report_main.reportHandler

import report_main.reportHandler.KBHeadersGetter._
import report_main.reportHandler.ResearchMap.getOrCreateResearchMap
import report_main.reportHandler.actors._
import report_main.reportHandler.actors.init.ActorsInitializer
import report_main.reportHandler.documents.uploader.{DocumentUploaderAndDependenciesGetter, DocxUploader}
import report_main.reportHandler.excel.colorRemover.WorkbookColorRemover.removeColors
import report_main.reportHandler.excel.reader.headers.{MetadataHeadersReader, ReportHeadersReader}
import report_main.reportHandler.excel.reader.metadataFile.DocumentMetadataReader
import report_main.reportHandler.excel.reader.reportFile.{ConceptReader, LinkReader}
import report_main.reportHandler.excel.writer.ExcelWriter
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportDocumentUploader, ReportHttpRequestSender, ReportWorkbookUpdater}
import report_main.reportHandler.mainFilesGetter.MainFilesGetter.getMainFiles
import report_main.reportHandler.processors.{DocxProcessor, MainProcessor}
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import common.types.ID
import zio.clock.Clock
import zio.logging._
import zio.magic._
import zio.random.Random
import zio.{Has, RIO, Semaphore, ZIO, ZLayer}


case class ReportHandler(zipFileWithEntries: ZipFileWithEntries,
                         userId: String,
                         topic: String,
                         taskId: ID,
                         maybeAccessLevelId: Option[ID]) {
    import report_main.reportHandler.sideEffects.{ReportHandlerSE => SE}
    private val reportUpdateThreads: Int = 1
    private val metadataUpdateThreads: Int = 1

    def handle: RIO[Logging with Random with Clock with Has[ReportHttpRequestSender] with Has[ReportDocumentUploader], ReportHandlerResult] = {
        for {
            mainFiles <- getMainFiles(zipFileWithEntries)

            reportWorkbookUpdaterSemaphore <- Semaphore.make(permits = reportUpdateThreads)
            reportWorkbookUpdaterLayer = (ZLayer.succeed(mainFiles.reportWorkbook) ++ ZLayer.succeed(reportWorkbookUpdaterSemaphore)) >>>
                ReportWorkbookUpdater.layer

            metadataWorkbookUpdaterSemaphore <- Semaphore.make(permits = metadataUpdateThreads)
            metadataWorkbookUpdaterLayer = (ZLayer.succeed(mainFiles.maybeMetadataWorkbook) ++ ZLayer.succeed(metadataWorkbookUpdaterSemaphore)) >>>
                MetadataWorkbookUpdater.layer

            result <- (for {
                docxUUID <- DocxUploader.upload(zipFileWithEntries, mainFiles, userId, topic, taskId, maybeAccessLevelId)
                headers <- ReportHeadersReader.readHeaders(mainFiles.reportWorkbook)
                researchMapId <- getOrCreateResearchMap(zipFileWithEntries, maybeAccessLevelId)

                maybeDocxKBId <- DocxProcessor(docxUUID).tryGetDocxKBId

                kbHeaders <- getKBHeaders(headers)

                concepts <- ConceptReader(kbHeaders).read
                links <- LinkReader(concepts, kbHeaders).read

                _ <- removeColors(mainFiles).when(!concepts.exists(_.thereAreParsedCommentCells))

                documentsMetadata <- MetadataHeadersReader.readHeaders(mainFiles.maybeMetadataWorkbook).flatMap(DocumentMetadataReader(_).read)
                documentsDependencies <- DocumentUploaderAndDependenciesGetter(zipFileWithEntries, documentsMetadata, concepts, links, userId, topic, taskId, maybeAccessLevelId).uploadAndGetDependencies

                actors <- ActorsInitializer(concepts, links, documentsDependencies, maybeDocxKBId, researchMapId, maybeAccessLevelId).init

                _ <- MainProcessor(actors, documentsDependencies.reportDocumentsDependencies.documentId2Documents,
                    documentsDependencies.metadataDocumentsDependencies.documentId2Metadata, researchMapId).startProcessing
                _ <- ZIO.collectAllSuccesses(Seq(actors.actorRefs.conceptActor, actors.actorRefs.linkActor, actors.actorRefs.conceptPropertyActor, actors.actorRefs.linkPropertyActor)
                    .map(actorRef => actorRef ? HandleExistedDocuments()))
                _ <- actors.actorRefs.conceptActor ? ReadyToShutdown

                unprocessedMessages <- actors.actorRefs.actorSystem.shutdown
                _ <- if (unprocessedMessages.isEmpty) SE.allActorsMessagesProcessedSuccessfully else SE.unprocessedActorsMessages(unprocessedMessages.length)

                reportWorkbookResult <- ExcelWriter(mainFiles.reportWorkbook).write.map { case (name, byteArray) => ReportWorkbookResult(name, byteArray) }
                maybeMetadataWorkbookResult <- (mainFiles.maybeMetadataWorkbook match {
                    case Some(metadataWorkbook) => ExcelWriter(metadataWorkbook).write.map(Some(_))
                    case None => ZIO.none
                }).map(_.map { case (name, byteArray) => MetadataWorkbookResult(name, byteArray) })
            } yield ReportHandlerResult(reportWorkbookResult = reportWorkbookResult, maybeMetadataWorkbookResult = maybeMetadataWorkbookResult))
                .injectSome[Logging with Random with Clock with Has[ReportHttpRequestSender] with Has[ReportDocumentUploader]](reportWorkbookUpdaterLayer, metadataWorkbookUpdaterLayer)
        } yield result
    }
}

case class ReportHandlerResult(reportWorkbookResult: ReportWorkbookResult,
                               maybeMetadataWorkbookResult: Option[MetadataWorkbookResult])

case class ReportWorkbookResult(fileName: String, newReportByteArray: Array[Byte])

case class MetadataWorkbookResult(fileName: String, newReportByteArray: Array[Byte])
