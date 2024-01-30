package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.DocumentCreated
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.MetadataExcelDocument
import common.types.ID
import zio.logging._
import zio.{Has, URIO, ZIO}

object DocumentMetadataActorSE extends ActorsCommonSE {
    self =>
    private val actorName = "DocumentMetadataActor"
    private val metadataExcelString = "MetadataExcel:"

    def handleExistedDocumentsMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleExistedDocuments")

    def documentCreatedMessage(document: DocumentCreated): URIO[Logging, Unit] = self.documentCreatedMessage(document, actorName)

    def readyShutdownMessage: URIO[Logging, Unit] = self.readyShutdownMessage(actorName)

    def unexpectedMessage: URIO[Logging, Unit] = self.unexpectedMessage(actorName)

    def documentAlreadyExists(document: MetadataExcelDocument): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        document.documentId.id match {
            case Left(kbId) => colorAndAddCommentToNoCommentDocumentPathCells(document, kbId)
            case Right(uuid) =>
                val message = s"$metadataExcelString\n" +
                    "\tTrying to color and addComment to cells of document that wasn't created"
                log.error(message).unit
        }
    }

    private def colorAndAddCommentToNoCommentDocumentPathCells(document: MetadataExcelDocument, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(document.noCommentDocumentPathCells.map(_.xssfCell).map(WorkbookUpdater.colorCellGreen)).unit
            _ <- ZIO.collectAllSuccesses(document.noCommentDocumentPathCells.map(cell => WorkbookUpdater.addKBIdComment(cell.xssfCell, kbId)))
        } yield ()
    }

    def metadataUpdatedSuccessfully(metadataExcelDocument: MetadataExcelDocument, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(metadataExcelDocument.metadata.noCommentCells.map(cell => WorkbookUpdater.addKBIdComment(cell.xssfCell, kbId)))
            _ <- ZIO.collectAllSuccesses(metadataExcelDocument.metadata.noCommentCells.map(cell => WorkbookUpdater.colorCellGreen(cell.xssfCell)))
        } yield ()
    }

    def metadataUpdateFailed(metadataExcelDocument: MetadataExcelDocument): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        val message = s"$metadataExcelString\n" +
            s"Failed to update document metadata. Document path: ${metadataExcelDocument.documentPaths}"
        log.error(message) *>
            ZIO.collectAllSuccesses(metadataExcelDocument.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)).unit
    }
}
