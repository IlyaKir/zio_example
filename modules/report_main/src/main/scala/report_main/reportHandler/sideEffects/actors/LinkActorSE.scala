package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.{ConceptCreated, DocumentCreated}
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import common.types.ID
import zio.logging._
import zio.{Has, URIO, ZIO}

object LinkActorSE extends ActorsCommonSE {
    self =>
    private val actorName = "LinkActor"

    def handleExistedLinksMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleExistedLinks")

    def handleCreateLinksForExistedConceptsMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleCreateLinksForExistedConcepts")

    def conceptCreatedMessage(concept: ConceptCreated): URIO[Logging, Unit] = self.conceptCreatedMessage(concept, actorName)

    def documentCreatedMessage(document: DocumentCreated): URIO[Logging, Unit] = self.documentCreatedMessage(document, actorName)

    def readyShutdownMessage: URIO[Logging, Unit] = self.readyShutdownMessage(actorName)

    def unexpectedMessage: URIO[Logging, Unit] = self.unexpectedMessage(actorName)

    def unableAddDocument(document: DocumentCreated, link: Link): URIO[Logging, Unit] =
        log.error(s"Unable to addFact(${document}) to Link because Link wasn't created successfully\n" +
            s"LinkTypeId: ${link.mainInfo.linkIdentifier.kbLinkType.id}\n" +
            s"Concepts: ${link.mainInfo.linkIdentifier.conceptFrom.conceptId.maybeKBId} -> ${link.mainInfo.linkIdentifier.conceptTo.conceptId.maybeKBId}")


    def linkAlreadyExists(link: Link): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        link.linkId.id match {
            case Left(kbId) => colorAndAddCommentToNoCommentCells(link, kbId) *> colorAndAddCommentToMetadataNoCommentCells(link, kbId)
            case Right(uuid) => log.error("Trying to color and addComment to cells of link that wasn't created").unit
        }
    }

    def linkCreatedSuccessfully(link: Link, kbId: ID): URIO[Has[WorkbookUpdater], Unit] =
        for {
            _ <- colorAndAddCommentToNoCommentCells(link, kbId)
            _ <- colorAndAddCommentToMetadataNoCommentCells(link, kbId)
        } yield ()

    def linkCreationFailed(link: Link, conceptFromKBId: ID, conceptToKBId: ID, exception: Throwable): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        val message = s"Link creation failed\n" +
            s"LinkTypeId: ${link.mainInfo.linkIdentifier.kbLinkType.id}\n" +
            s"Concepts: ${conceptFromKBId} -> ${conceptToKBId}\n" +
            s"Message: ${exception.getMessage}"
        log.error(message) *> ZIO.collectAllSuccesses(link.mainInfo.linkCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)).unit
    }

    def linkCreatedFailedBecauseAlreadyExists(linkId: ID): URIO[Logging, Unit] = {
        val message = s"Link creation failed because already exists\n" +
            s"LinkId: $linkId"
        log.error(message)
    }


    def metadataUpdatedSuccessfully(link: Link, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = colorAndAddCommentToMetadataNoCommentCells(link, kbId)

    def metadataUpdateFailed(link: Link): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Failed to update concept ${link.linkId.maybeKBId} metadata") *>
            ZIO.collectAllSuccesses(link.mainInfo.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)).unit


    private def colorAndAddCommentToNoCommentCells(link: Link, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(link.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellGreen)).unit
            _ <- ZIO.collectAllSuccesses(link.noCommentCells.map(cell => WorkbookUpdater.addLinkCellLinkKBIdComment(cell.xssfCell, kbId))).unit
        } yield ()
    }

    private def colorAndAddCommentToMetadataNoCommentCells(link: Link, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(link.mainInfo.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellGreen)).unit
            _ <- ZIO.collectAllSuccesses(link.mainInfo.metadata.noCommentCells.map(cell => WorkbookUpdater.addKBIdComment(cell.xssfCell, kbId))).unit
        } yield ()
    }
}
