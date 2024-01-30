package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.DocumentCreated
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property.PropertyIdentifier
import common.types.ID
import report_main.reportHandler.utils.ColorPalette
import zio.{Has, URIO, ZIO}
import zio.logging._

trait PropertyActorSE extends ActorsCommonSE {
    self =>
    val actorName: String

    def documentCreatedMessage(document: DocumentCreated): URIO[Logging, Unit] = self.documentCreatedMessage(document, actorName)

    def readyShutdownMessage: URIO[Logging, Unit] = self.readyShutdownMessage(actorName)

    def unexpectedMessage: URIO[Logging, Unit] = self.unexpectedMessage(actorName)

    def unableAddDocument(documentCreatedMessage: DocumentCreated, propertyIdentifier: PropertyIdentifier): URIO[Logging, Unit] =
        log.error(s"Unable to add document $documentCreatedMessage because $propertyIdentifier wasn't created successfully")

    def metadataUpdatedSuccessfully(property: Property, kbId: ID): URIO[Has[WorkbookUpdater], Unit] =
        colorAndAddCommentToMetadataNoCommentCells(property, kbId)

    def metadataUpdateFailed(property: Property): URIO[Has[WorkbookUpdater], Unit] = ZIO.collectAllSuccesses(
        property.mainInfo.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)).unit

    def propertyAlreadyExists(property: Property): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        property.propertyId.id match {
            case Left(kbId) => colorAndAddCommentToNoCommentCells(property, kbId)
            case Right(uuid) => log.error("Unexpected behaviour: trying to color and addComment to cells of property that wasn't created").unit
        }
    }

    def propertyCreationSucceed(property: Property, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- colorAndAddCommentToNoCommentCells(property, kbId)
            _ <- colorAndAddCommentToMetadataNoCommentCells(property, kbId)
        } yield ()
    }

    def propertyCreationFailed(property: Property): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(property.mainInfo.propertyCells.map(_.xssfCell).map(WorkbookUpdater.colorCellRed)) *>
            log.error(s"$actorName (${property.mainInfo.propertyIdentifier.valueInput}) creation failed").unit
    }

    private def colorAndAddCommentToMetadataNoCommentCells(property: Property, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(property.mainInfo.metadata.noCommentCells.map(_.xssfCell).map(WorkbookUpdater.colorCellGreen)).unit
            _ <- ZIO.collectAllSuccesses(property.mainInfo.metadata.noCommentCells.map(cell => WorkbookUpdater.updateMultipleKBIdsComment(cell, kbId)))
        } yield ()
    }

    private def colorAndAddCommentToNoCommentCells(property: Property, kbId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        for {
            _ <- ZIO.collectAllSuccesses(property.noCommentPropertyCells.map(_.xssfCell).map { xssfCell =>
                val needToColor = Option(xssfCell.getCellStyle.getFillForegroundXSSFColor) match {
                    case Some(ColorPalette.greyXSSFColor) | Some(ColorPalette.redXSSFColor) | Some(ColorPalette.greenXSSFColor) => false
                    case _ => true
                }
                WorkbookUpdater.colorCellGreen(xssfCell).when(needToColor)
            }).unit
            _ <- ZIO.collectAllSuccesses(property.noCommentPropertyCells.map(cell => WorkbookUpdater.updateMultipleKBIdsComment(cell, kbId)))
        } yield ()
    }
}
