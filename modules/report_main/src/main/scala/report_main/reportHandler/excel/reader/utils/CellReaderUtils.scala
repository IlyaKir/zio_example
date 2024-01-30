package report_main.reportHandler.excel.reader.utils

import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy
import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFRow}
import report_main.reportHandler.utils.StringNormalizer
import zio.logging.Logging
import zio.{RIO, Task, UIO, ZIO}

object CellReaderUtils {
    import report_main.reportHandler.sideEffects.excelReader.{CellReaderSE => SE}

    def getSingleXSSFCell(row: XSSFRow, columnId: Int): Task[XSSFCell] = ZIO.fromOption(tryGetCell(row, columnId)).orElseFail(new Throwable)

    def getMultipleXSSFCells(rows: List[XSSFRow], columnId: Int): UIO[List[XSSFCell]] = ZIO.collectAllSuccesses(rows.map(row => getSingleXSSFCell(row, columnId)))

    /** @return maybeCell
     *
     * RETURN_BLANK_AS_NULL - Even if the cell exists but has a cell type of "blank", return null.
     * */
    private def tryGetCell(row: XSSFRow, columnId: Int, missingCellPolicy: MissingCellPolicy = MissingCellPolicy.RETURN_BLANK_AS_NULL): Option[XSSFCell] = {
        Option(row.getCell(columnId, missingCellPolicy))
    }

    /** Get single nonEmpty string value */
    def getSingleNonEmptyStringCellValue(cell: XSSFCell): RIO[Logging, String] = {
        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty =>
                ZIO.succeed(StringNormalizer.normalize(cell.getStringCellValue.trim))
            case _ => SE.unableGetSingleNonEmptyStringCellValue(cell) *> RIO.fail(new Throwable)
        }
    }

    def getSingleNonEmptyStringOrNumericCellValue(cell: XSSFCell): RIO[Logging, String] = {
        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty =>
                ZIO.succeed(StringNormalizer.normalize(cell.getStringCellValue.trim))
            case CellType.NUMERIC if cell.getNumericCellValue.toString.nonEmpty =>
                ZIO.succeed(StringNormalizer.normalize(cell.getNumericCellValue.toString.trim))
            case _ => SE.unableGetSingleNonEmptyStringOrNumericCellValue(cell) *> RIO.fail(new Throwable)
        }
    }

    /** Get multiple nonEmpty string values separated by ';' */
    def getMultipleNonEmptyStringCellValues(cell: XSSFCell): RIO[Logging, List[String]] = {
        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty =>
                ZIO.succeed(splitAndTrim(cell.getStringCellValue).map(value => StringNormalizer.normalize(value)))
            case _ => SE.unableGetMultipleNonEmptyStringCellValues(cell) *> RIO.fail(new Throwable)
        }
    }

    /** @return trimmed non empty strings split by ';'. List can be empty */
    private def splitAndTrim(str: String): List[String] =
        str.split(";").map(_.trim).filter(_.nonEmpty).toList
}
