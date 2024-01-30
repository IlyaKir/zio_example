package report_main.reportHandler.sideEffects

import zio.URIO
import zio.logging._

object ReportHandlerSE {
    def allActorsMessagesProcessedSuccessfully: URIO[Logging, Unit] = log.info("All actor messages processed successfully")
    def unprocessedActorsMessages(n: Int): URIO[Logging, Unit] = log.error(s"Number of unprocessed actors messages: $n}")
}
