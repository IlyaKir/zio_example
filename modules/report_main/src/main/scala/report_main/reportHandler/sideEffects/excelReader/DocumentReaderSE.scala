package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.sideEffects.SideEffectsUtils
import report_main.reportHandler.utils.ColorPalette
import zio.logging._
import zio.{Has, URIO, ZIO}

object DocumentReaderSE extends SideEffectsUtils {
    def documentPathsAndCommentParsedSuccessfully(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = {
        Option(cell.getCellStyle.getFillForegroundXSSFColor) match {
            case Some(ColorPalette.greyXSSFColor) | Some(ColorPalette.redXSSFColor) => WorkbookUpdater.colorCellWhite(cell)
            case _ => URIO.unit
        }
    }

    def unableParseCellValueOrComment(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to parse document cell value or comment:${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)

    def commentUnfit(cell: XSSFCell, numberOfValues: Int): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Document cell comment unfit to values:${getCellAddress(cell)}")

    def addSemicolonsComment(cell: XSSFCell, n: Int): URIO[Has[WorkbookUpdater], Unit] = WorkbookUpdater.addSemicolons(cell, n)
}
