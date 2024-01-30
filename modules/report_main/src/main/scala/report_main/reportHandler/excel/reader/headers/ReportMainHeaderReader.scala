package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.regex.headers.ReportColumnHeaders.Metadata
import zio.logging._
import zio.{Has, RIO}

object ReportMainHeaderReader {
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleNonEmptyStringCellValue
    import report_main.reportHandler.sideEffects.excelReader.{MetadataReaderSE => SE}
    /** @return metadataNameColumnId */
    def getMetadataNameColumnId(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], Int] = {
        for {
            cellValue <- getSingleNonEmptyStringCellValue(cell)
            _ <- Metadata.Name.tryMatch(cellValue) match {
                case Some(_) => RIO.unit
                case None => SE.unableParseMetadataNameColumn(cell) *> RIO.fail(new Throwable)
            }
        } yield cell.getColumnIndex
    }
}
