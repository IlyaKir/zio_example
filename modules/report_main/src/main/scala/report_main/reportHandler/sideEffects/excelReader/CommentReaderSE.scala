package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.sideEffects.SideEffectsUtils
import zio.logging._
import zio.{Has, URIO}

object CommentReaderSE extends SideEffectsUtils {
    def emptyComment(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = WorkbookUpdater.removeComment(cell)

    def unableParseSingleValueComment(cell: XSSFCell): URIO[Logging, Unit] =
        log.error(s"Unable to parse single value comment:${getCellAddress(cell)}")

    def unableParseMultipleValueComment(cell: XSSFCell): URIO[Logging, Unit] =
        log.error(s"Unable to parse multiple value comment:${getCellAddress(cell)}")

    def unableParseLinkCellComment(cell: XSSFCell): URIO[Logging, Unit] = {
        log.error(s"Unable to parse link cell comment:${getCellAddress(cell)}")
    }
}
