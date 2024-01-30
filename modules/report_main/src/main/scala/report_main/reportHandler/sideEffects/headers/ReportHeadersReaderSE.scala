package report_main.reportHandler.sideEffects.headers

import org.apache.poi.xssf.usermodel.XSSFSheet
import report_main.reportHandler.layers.WorkbookUpdater
import zio.logging._
import zio.{Has, URIO}

object ReportHeadersReaderSE extends HeadersReaderCommonSE { self =>
    private val excelName = "report.xlsx"
    def gettingReportHeaders: URIO[Logging, Unit] = self.gettingHeaders(excelName)

    def sheetWithoutRows(sheetName: String): URIO[Logging, Unit] = log.warn(s"Sheet <${sheetName}> doesn't have any rows")

    def unableParseSheetName(sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        self.unableParseName(sheet)

    def unableParseColumnHeader(cellValue: String, sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        self.unableParseHeader(cellValue, sheet)
}
