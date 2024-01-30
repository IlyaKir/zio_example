package report_main.reportHandler.sideEffects

import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.common.ExcelDocument
import report_main.reportHandler.utils.ColorPalette
import common.types.ID
import zio.logging._
import zio.{Has, URIO, ZIO}

import java.util.UUID

object ProcessorSE {
    def waitingDocx(docxUUID: String): URIO[Logging, Unit] = log.info(s"Waiting docx {${docxUUID}} to be handled")

    def docxHandlingSucceed(docxKBId: ID): URIO[Logging, Unit] = log.info(s"Docx file handling succeed: ${docxKBId}")

    def docxHandlingFailed: URIO[Logging, Unit] = log.error("Docx file handling failed")

    def docxHandlingUnexpectedBehaviour: URIO[Logging, Unit] = log.error("Docx file handling unexpected behaviour")


    def documentHandlingSucceed(document: ExcelDocument, documentKBId: ID): URIO[Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(document.documentPathCells.map { cell =>
            WorkbookUpdater.updateMultipleKBIdsComment(cell, documentKBId) *> {
                val needToColor = Option(cell.xssfCell.getCellStyle.getFillBackgroundColorColor) match {
                    case Some(ColorPalette.greyXSSFColor) | Some(ColorPalette.redXSSFColor) | Some(ColorPalette.greenXSSFColor) => false
                    case _ => true
                }
                WorkbookUpdater.colorCellGreen(cell.xssfCell).when(needToColor)
            }
        }).unit
    }

    def documentHandlingFailed(document: ExcelDocument, uuid: UUID): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        log.error(s"Document (UUID: ${uuid.toString}) handling failed\nPath(s): ${document.documentPaths.mkString("\n\t\t ")}") *>
            colorRedIfNecessary(document)
    }

    def documentHandlingUnexpectedBehaviour(document: ExcelDocument, uuid: UUID): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        log.error(s"Document (UUID: ${uuid.toString}) handling unexpected behaviour\nPath(s): ${document.documentPaths.mkString("\n\t\t ")}") *>
            colorRedIfNecessary(document)
    }

    private def colorRedIfNecessary(document: ExcelDocument) = {
        ZIO.collectAllSuccesses(document.documentPathCells.map { cell =>
            val needToColor = Option(cell.xssfCell.getCellStyle.getFillBackgroundColorColor) match {
                case Some(ColorPalette.greyXSSFColor) | Some(ColorPalette.redXSSFColor) => false
                case _ => true
            }
            WorkbookUpdater.colorCellRed(cell.xssfCell).when(needToColor)
        }).unit
    }
}
