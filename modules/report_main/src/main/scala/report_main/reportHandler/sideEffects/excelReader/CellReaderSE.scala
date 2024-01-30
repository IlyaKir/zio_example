package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.sideEffects.SideEffectsUtils
import zio.URIO
import zio.logging.{Logging, log}

object CellReaderSE extends SideEffectsUtils {

    def unableGetSingleNonEmptyStringCellValue(cell: XSSFCell): URIO[Logging, Unit] =
        log.error(s"Unable to read cell value (expected single non-empty string)${getCellAddress(cell)}")

    def unableGetSingleNonEmptyStringOrNumericCellValue(cell: XSSFCell): URIO[Logging, Unit] =
        log.error(s"Unable to read cell value (expected single non-empty string or numeric)${getCellAddress(cell)}")

    def unableGetMultipleNonEmptyStringCellValues(cell: XSSFCell): URIO[Logging, Unit] =
        log.error(s"Unable to read cell value (expected multiple non-empty strings)${getCellAddress(cell)}")
}
