package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.DocumentCreated
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept.ConceptIdentifier
import common.types.ID
import zio.logging._
import zio.{Has, URIO, ZIO}

object ConceptActorSE extends ActorsCommonSE {
    self =>
    private val actorName = "ConceptActor"

    def handleExistedConcepts: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleExistedConcepts")

    def createConceptsMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message CreateConcepts")

    def documentCreatedMessage(document: DocumentCreated): URIO[Logging, Unit] = self.documentCreatedMessage(document, actorName)

    def readyShutdownMessage: URIO[Logging, Unit] = self.readyShutdownMessage(actorName)

    def unexpectedMessage: URIO[Logging, Unit] = self.unexpectedMessage(actorName)

    def unableAddDocument(documentCreatedMessage: DocumentCreated, conceptIdentifier: ConceptIdentifier): URIO[Logging, Unit] =
        log.error(s"Unable to add document $documentCreatedMessage because $conceptIdentifier wasn't created successfully")

    def unableAddAvatar(documentCreatedMessage: DocumentCreated, conceptIdentifier: ConceptIdentifier): URIO[Logging, Unit] =
        log.error(s"Unable to add avatar $documentCreatedMessage because $conceptIdentifier wasn't created successfully")


    private def colorAndAddCommentToNoCommentCells(concept: Concept, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(concept.noCommentMetadataNameCells.map(_.xssfCell).map(WorkbookUpdater.colorCellGreen)).unit
            _ <- ZIO.collectAllSuccesses(concept.noCommentMetadataNameCells.map(cell => WorkbookUpdater.addKBIdComment(cell.xssfCell, kbId)))

            _ <- ZIO.collectAllSuccesses(concept.noCommentLinkCells.filter(_.maybeParsedComment.isEmpty)
                .map(cell => WorkbookUpdater.addLinkCellConceptKBIdComment(cell.xssfCell, kbId)))
        } yield ()
    }

    private def colorAndAddCommentToMetadataNoCommentCells(concept: Concept, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(concept.mainInfo.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellGreen)).unit
            _ <- ZIO.collectAllSuccesses(concept.mainInfo.metadata.noCommentCells.map(cell => WorkbookUpdater.addKBIdComment(cell.xssfCell, kbId)))
        } yield ()
    }

    def metadataUpdatedSuccessfully(concept: Concept, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = colorAndAddCommentToMetadataNoCommentCells(concept, kbId)

    def metadataUpdateFailed(concept: Concept): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        log.error(s"Failed to update concept ${concept.conceptId.maybeKBId} metadata") *>
            ZIO.collectAllSuccesses(concept.mainInfo.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)).unit
    }

    def conceptAlreadyExists(concept: Concept): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        concept.conceptId.id match {
            case Left(kbId) => colorAndAddCommentToNoCommentCells(concept, kbId)
            case Right(uuid) => log.error("Trying to color and addComment to cells of concept that wasn't created").unit
        }
    }

    def conceptCreationSucceed(concept: Concept, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- colorAndAddCommentToNoCommentCells(concept, kbId)
            _ <- colorAndAddCommentToMetadataNoCommentCells(concept, kbId)
        } yield ()
    }

    def conceptCreationFailed(concept: Concept): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Concept <${concept.mainInfo.conceptIdentifier.name}> with conceptTypeId <${concept.mainInfo.conceptIdentifier.kbType.id}> creation failed") *>
            ZIO.collectAllSuccesses(concept.mainInfo.metadataNameCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)).unit
}
