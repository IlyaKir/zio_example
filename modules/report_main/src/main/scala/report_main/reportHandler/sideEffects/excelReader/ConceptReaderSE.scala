package report_main.reportHandler.sideEffects.excelReader

import zio.URIO
import zio.logging._

object ConceptReaderSE {
    def gettingConcepts: URIO[Logging, Unit] = log.info("Getting full info about concepts from excel")

    def readSheet(sheetName: String): URIO[Logging, Unit] = log.info(s"\tSheet: $sheetName")
}
