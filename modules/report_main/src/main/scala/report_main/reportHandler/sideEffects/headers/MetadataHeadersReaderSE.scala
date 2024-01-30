package report_main.reportHandler.sideEffects.headers

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}
import report_main.reportHandler.layers.WorkbookUpdater
import zio.logging._
import zio.{Has, URIO}

object MetadataHeadersReaderSE extends HeadersReaderCommonSE { self =>
    private val excelName = "metadata.xlsx"
    def gettingMetadataHeaders: URIO[Logging, Unit] = self.gettingHeaders(excelName)

    def unableParseSheetName(sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        self.unableParseName(sheet)

    def unableParseColumnHeader(cellValue: String, sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        self.unableParseHeader(cellValue, sheet)

    def unableParseDocumentPathColumn(cellValue: String, cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to parse documentPath column: <$cellValue>") *> WorkbookUpdater.colorCellGrey(cell)
}
