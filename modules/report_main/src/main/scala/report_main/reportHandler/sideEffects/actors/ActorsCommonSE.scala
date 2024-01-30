package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.{ConceptCreated, DocumentCreated}
import zio.URIO
import zio.logging._

trait ActorsCommonSE {
    protected def conceptCreatedMessage(concept: ConceptCreated, actorName: String): URIO[Logging, Unit] = log.debug(s"$actorName actor received a message ${concept}")

    protected def documentCreatedMessage(document: DocumentCreated, actorName: String): URIO[Logging, Unit] = log.debug(s"$actorName actor received a message ${document}")

    protected def readyShutdownMessage(actorName: String): URIO[Logging, Unit] = log.info(s"$actorName received a message ReadyToShutdown")

    protected def unexpectedMessage(actorName: String): URIO[Logging, Unit] = log.warn(s"$actorName received unexpected message")
}
