package report_main.reportHandler.sideEffects.headers

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}
import report_main.reportHandler.layers.WorkbookUpdater
import zio.logging._
import zio.{Has, URIO}

object KBHeaderSE {
    def gettingKBReportHeaders: URIO[Logging, Unit] = log.info("Getting kb headers (object type ids from kb-api)")

    def conceptTypeFound(sheet: XSSFSheet): URIO[Has[WorkbookUpdater], Unit] = WorkbookUpdater.colorTabGreen(sheet)

    def conceptTypeNotFound(conceptTypeName: String, sheet: XSSFSheet): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.warn(s"ConceptType $conceptTypeName not found in kb") *> WorkbookUpdater.colorTabRed(sheet)

    def KBTypeFound(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = WorkbookUpdater.colorCellGreen(cell)

    def KBTypeNotFound(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = WorkbookUpdater.colorCellRed(cell)
}
