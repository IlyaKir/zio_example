package report_main.reportHandler.sideEffects.headers

import org.apache.poi.xssf.usermodel.XSSFSheet
import report_main.reportHandler.layers.WorkbookUpdater
import zio.{Has, URIO}
import zio.logging.{Logging, log}

trait HeadersReaderCommonSE {
    protected def gettingHeaders(excelName: String): URIO[Logging, Unit] =
        log.info(s"Getting $excelName headers info")

    protected def unableParseName(sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.warn(s"Unable to parse sheet's name: <${sheet.getSheetName}>") *> WorkbookUpdater.colorTabGrey(sheet)

    protected def unableParseHeader(cellValue: String, sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.warn(s"Unable to parse columnHeader: <$cellValue>") *> WorkbookUpdater.colorTabGrey(sheet)
}
