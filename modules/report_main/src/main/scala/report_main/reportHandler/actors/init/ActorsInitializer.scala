package report_main.reportHandler.actors.init

import report_main.reportHandler.actors._
import report_main.reportHandler.actors.progressBar.ProgressBars
import report_main.reportHandler.actors.state._
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportHttpRequestSender, ReportWorkbookUpdater}
import report_main.reportHandler.types.documentsDependencies.{DocumentsDependencies, ReportDocumentsDependencies}
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.utils.DocumentId
import common.types.ID
import zio.actors.{ActorRef, ActorSystem, Supervisor}
import zio.clock.Clock
import zio.logging._
import zio.{Has, RIO, Schedule, UIO}

import javax.inject.Inject

case class ActorsInitializer @Inject()(concepts: List[Concept],
                                       links: List[Link],
                                       documentsDependencies: DocumentsDependencies,
                                       maybeDocxKBId: Option[ID],
                                       researchMapId: ID,
                                       maybeAccessLevelId: Option[ID]) {

    import report_main.reportHandler.sideEffects.actors.{ActorsInitializerSE => SE}

    private val reportDocumentsDependencies: ReportDocumentsDependencies = documentsDependencies.reportDocumentsDependencies

    def init: RIO[Logging with Clock with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater], ActorsInitializerResult] = {
        for {
            actorsStateInfo <- getActorsStateInfo
            progressBars = ProgressBars.createNonePBs
            //            progressBars = ProgressBars.createSomePBs(actorsStateInfo)
            actorRefs <- createActors(actorsStateInfo, progressBars)
            documentId2ActorRefs = getDocumentId2ActorRefs(actorRefs)
        } yield ActorsInitializerResult(actorsStateInfo, actorRefs, progressBars, documentId2ActorRefs)
    }

    private def getActorsStateInfo: RIO[Logging, ActorStateInfo] = {
        SE.gettingActorsState *> {
            val conceptActorState = ConceptActorState(reportDocumentsDependencies.documentId2Concepts, reportDocumentsDependencies.avatarId2Concepts, concepts)

            val conceptPropertyActorState = ConceptPropertyActorState(reportDocumentsDependencies.documentId2ConceptProperties,
                concepts.map(concept => concept.conceptId -> concept.dependencyInfo.properties).toMap, concepts)

            val linkActorState = LinkActorState(reportDocumentsDependencies.documentId2Links,
                links.map(link => link.mainInfo.linkIdentifier.conceptFrom.conceptId -> link).groupBy(_._1).view.mapValues(_.map(_._2)).toMap,
                links.map(link => link.mainInfo.linkIdentifier.conceptTo.conceptId -> link).groupBy(_._1).view.mapValues(_.map(_._2)).toMap,
                links)
            val linkPropertyActorState = LinkPropertyActorState(reportDocumentsDependencies.documentId2LinkProperties,
                links.map(link => link.linkId -> link.dependencyInfo.properties).toMap, links)

            val documentMetadataActorState = DocumentMetadataActorState(documentsDependencies.metadataDocumentsDependencies.documentId2Metadata)

            UIO.succeed(ActorStateInfo(conceptActorState, conceptPropertyActorState, linkActorState, linkPropertyActorState, documentMetadataActorState))
        }
    }

    private def createActors(actorStateInfo: ActorStateInfo, progressBars: ProgressBars)
    : RIO[Logging with Clock with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater], ActorRefs] = {
        def getSupervisor(actorName: String) =
            Supervisor.retryOrElse[Logging, Long](Schedule.recurs(8), (e, _) => SE.failedRecoverActor(actorName))

        for {
            actorSystem <- ActorSystem("ReportActorSystem")
            linkPropertyActorRef <- {
                val actorName = "LinkPropertyActor"
                val linkPropertyActor = LinkPropertyActor(actorStateInfo.linkPropertyActorState, maybeDocxKBId, maybeAccessLevelId,
                    maybeProgressBar = progressBars.linkPropertyActorDocsPB, maybeDocProgressBar = progressBars.linkPropertyActorDocsPB).actor
                actorSystem.make(actorName, getSupervisor(actorName), actorStateInfo.linkPropertyActorState, linkPropertyActor)
            }
            linkActorRef <- {
                val actorName = "LinkActor"
                val linkActor = LinkActor(actorStateInfo.linkActorState, linkPropertyActorRef, maybeDocxKBId, maybeAccessLevelId,
                    maybeProgressBar = progressBars.linkActorPB, maybeDocProgressBar = progressBars.linkActorDocsPB).actor
                actorSystem.make(actorName, getSupervisor(actorName), actorStateInfo.linkActorState, linkActor)
            }
            conceptPropertyActorRef <- {
                val actorName = "ConceptPropertyActor"
                val conceptPropertyActor = ConceptPropertyActor(actorStateInfo.conceptPropertyActorState, maybeDocxKBId, maybeAccessLevelId,
                    maybeProgressBar = progressBars.conceptPropertyActorPB, maybeDocProgressBar = progressBars.conceptPropertyActorDocsPB).actor
                actorSystem.make(actorName, getSupervisor(actorName), actorStateInfo.conceptPropertyActorState, conceptPropertyActor)
            }
            conceptActorRef <- {
                val actorName = "ConceptActor"
                val conceptActor = ConceptActor(actorStateInfo.conceptActorState, conceptPropertyActorRef, linkActorRef, maybeDocxKBId, researchMapId, maybeAccessLevelId,
                    maybeProgressBar = progressBars.conceptActorPB, maybeDocProgressBar = progressBars.conceptActorDocsPB).actor
                actorSystem.make(actorName, getSupervisor(actorName), actorStateInfo.conceptActorState, conceptActor)
            }
            documentMetadataActorRef <- {
                val actorName = "DocumentMetadataActor"
                val documentMetadataActor = DocumentMetadataActor(actorStateInfo.documentMetadataActorState, maybeProgressBar = progressBars.documentMetadataActorPB).actor
                actorSystem.make(actorName, getSupervisor(actorName), actorStateInfo.documentMetadataActorState, documentMetadataActor)
            }
        } yield ActorRefs(actorSystem, conceptActorRef, conceptPropertyActorRef, linkActorRef, linkPropertyActorRef, documentMetadataActorRef)
    }

    private def getDocumentId2ActorRefs(actorRefs: ActorRefs): Map[DocumentId, Seq[ActorRef[Message]]] = {
        val documentId2ConceptActorRef = (reportDocumentsDependencies.avatarId2Concepts ++ reportDocumentsDependencies.documentId2Concepts)
            .map(_._1 -> actorRefs.conceptActor).toSeq
        val documentId2ConceptPropertyActorRef = reportDocumentsDependencies.documentId2ConceptProperties.map(_._1 -> actorRefs.conceptPropertyActor).toSeq
        val documentId2LinkActorRef = reportDocumentsDependencies.documentId2Links.map(_._1 -> actorRefs.linkActor).toSeq
        val documentId2LinkPropertyActorRef = reportDocumentsDependencies.documentId2LinkProperties.map(_._1 -> actorRefs.linkPropertyActor).toSeq
        val documentId2DocumentMetadataActorRef = documentsDependencies.metadataDocumentsDependencies.documentId2Metadata.map(_._1 -> actorRefs.documentMetadataActor).toSeq

        (documentId2ConceptActorRef ++ documentId2ConceptPropertyActorRef ++ documentId2LinkActorRef ++ documentId2LinkPropertyActorRef ++ documentId2DocumentMetadataActorRef)
            .groupBy(_._1).view.mapValues(_.map(_._2)).toMap
    }
}
