package report_main.reportHandler.sideEffects.actors

import report_main.reportHandler.actors.ConceptCreated
import zio.URIO
import zio.logging._

object ConceptPropertyActorSE extends PropertyActorSE {
    self =>
    override val actorName: String = "ConceptPropertyActor"

    def handleExistedConceptPropertiesMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleExistedConceptProperties")

    def createPropertiesForExistedConceptsMessage: URIO[Logging, Unit] = log.debug(s"$actorName actor received a message HandleCreatePropertiesForExistedConcepts")

    def conceptCreatedMessage(concept: ConceptCreated): URIO[Logging, Unit] = self.conceptCreatedMessage(concept, actorName)
}
