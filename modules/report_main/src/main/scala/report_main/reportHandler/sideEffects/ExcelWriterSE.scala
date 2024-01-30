package report_main.reportHandler.sideEffects

import zio.URIO
import zio.logging._

object ExcelWriterSE {
    def writingEnrichedExcel(fileName: String): URIO[Logging, Unit] = log.info(s"Writing enriched excel: $fileName")

    def enrichedExcelWritingSucceed(fileName: String): URIO[Logging, Unit] = log.info(s"Enriched excel writing succeed: $fileName")

    def enrichedExcelWritingFailed(fileName: String): URIO[Logging, Unit] = log.info(s"Enriched excel writing failed: $fileName")
}
