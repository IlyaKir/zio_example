package report_main.reportHandler.sideEffects.excelReader

import zio.URIO
import zio.logging._

object LinkReaderSE {
    def gettingLinks: URIO[Logging, Unit] = log.info("Getting full info about links from excel")

    def readSheet(sheetName: String): URIO[Logging, Unit] = log.info(s"\tSheet: $sheetName")
}
