package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import zio.logging._
import zio.{Has, RIO}

object MetadataMainHeaderReader {
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleNonEmptyStringCellValue
    import report_main.reportHandler.regex.headers.MetadataColumnHeaders.DocumentPath
    import report_main.reportHandler.sideEffects.headers.{MetadataHeadersReaderSE => SE}
    /** @return metadataNameColumnId */
    def getDocumentPathColumnId(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], Int] = {
        for {
            cellValue <- getSingleNonEmptyStringCellValue(cell)
            _ <- DocumentPath.tryMatch(cellValue) match {
                case Some(_) => RIO.unit
                case None => SE.unableParseDocumentPathColumn(cellValue, cell) *> RIO.fail(new Throwable)
            }
        } yield cell.getColumnIndex
    }
}
