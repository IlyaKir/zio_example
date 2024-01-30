package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.sideEffects.SideEffectsUtils
import report_main.reportHandler.utils.ColorPalette
import zio.logging._
import zio.{Has, URIO}

object PropertyReaderSE extends SideEffectsUtils {
    def kbPropertyTypeDoesntMatch(cell: XSSFCell): URIO[Logging, Unit] =
        log.error(s"KbPropertyType (ValueType) doesn't match :${getCellAddress(cell)}")

    def commentUnfit(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Property cell comment unfit to values:${getCellAddress(cell)}")

    def addSemicolonsComment(cell: XSSFCell, n: Int): URIO[Has[WorkbookUpdater], Unit] = WorkbookUpdater.addSemicolons(cell, n)

    def cellValueAndCommentParsedSuccessfully(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = {
        Option(cell.getCellStyle.getFillForegroundXSSFColor) match {
            case Some(ColorPalette.greyXSSFColor) | Some(ColorPalette.redXSSFColor) => WorkbookUpdater.colorCellWhite(cell)
            case _ => URIO.unit
        }
    }

    def unableParseCellValueOrComment(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to parse property cell value or comment:${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)
}
