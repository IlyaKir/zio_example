package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.LinkCreated
import zio.URIO
import zio.logging._

object LinkPropertyActorSE extends PropertyActorSE {
    override val actorName: String = "LinkPropertyActor"

    def handleExistedLinkPropertiesMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleExistedLinkProperties")
    def createPropertiesForExistedLinksMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleCreatePropertiesForExistedLinks")
    def linkCreatedMessage(link: LinkCreated): URIO[Logging, Unit] = log.debug(s"$actorName actor received a message $link")
}
