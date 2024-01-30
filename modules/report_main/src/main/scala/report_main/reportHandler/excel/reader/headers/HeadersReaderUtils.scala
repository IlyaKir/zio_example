package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}
import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleXSSFCell
import zio.{RIO, ZIO}
import zio.logging.Logging

object HeadersReaderUtils {
    import report_main.reportHandler.sideEffects.headers.{ReportHeadersReaderSE => SE}

    def getHeaderCellsInfo(sheet: XSSFSheet): RIO[Logging, HeaderCellsInfo] = {
        for {
            headRow <- ZIO.fromOption(Option(sheet.getRow(0)))
                .tapError { _ => SE.sheetWithoutRows(sheet.getSheetName) }
                .orElseFail(new Throwable)
            cellIds = List.range(headRow.getFirstCellNum, headRow.getLastCellNum).map(_.toInt)
            headCell <- ZIO.fromOption(cellIds.headOption).orElseFail(new Throwable)
                .flatMap(headCellId => getSingleXSSFCell(headRow, headCellId))
        } yield HeaderCellsInfo(headCell = headCell, cellIds = cellIds)
    }

    case class HeaderCellsInfo(headCell: XSSFCell, cellIds: List[Int])
}
