package report_main.reportHandler.sideEffects.actors

import zio.URIO
import zio.logging._

object ActorsInitializerSE {
    def gettingActorsState: URIO[Logging, Unit] = log.info("Getting actors state info")

    def failedRecoverActor(actorName: String): URIO[Logging, Unit] = log.error(s"Failed to recover ${actorName}")
}
