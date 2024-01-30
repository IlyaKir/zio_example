package report_main.reportHandler.actors

import me.tongfei.progressbar.ProgressBar
import report_main.generated.kb_api.graphql.{ConceptAddInputInput, ResearchMapContentAddInput}
import report_main.reportHandler.actors.state.ConceptActorState
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.{ReportHttpRequestSender, ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.utils.DocumentId
import common.types.ID
import zio._
import zio.actors.Actor._
import zio.actors._
import zio.logging._
import zio.magic.ZioProvideMagicOps

import java.util.UUID

case class ConceptActor(initialState: ConceptActorState,
                        conceptPropertyActorRef: ActorRef[Message],
                        linkActorRef: ActorRef[Message],
                        maybeDocxKBId: Option[ID],
                        researchMapId: ID,
                        maybeAccessLevelId: Option[ID],
                        maybeProgressBar: Option[ProgressBar],
                        maybeDocProgressBar: Option[ProgressBar]) {

    import report_main.reportHandler.sideEffects.actors.{ConceptActorSE => SE}

    val actor: Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], ConceptActorState, Message] =
        new Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], ConceptActorState, Message] {
            override def receive[A](state: ConceptActorState, msg: Message[A], context: Context): RIO[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], (ConceptActorState, A)] = {
                (msg match {
                    case _: HandleExistedConcepts => SE.handleExistedConcepts *> handleExistedConceptsMessage(state)
                    case _: CreateConcepts =>
                        for {
                            _ <- SE.createConceptsMessage
                            conceptsCreated <- handleCreateConceptsMessage(state)
                            _ <- ZIO.foreach_(conceptsCreated)(conceptCreated => ZIO.collectAllSuccessesPar(List(conceptPropertyActorRef ? conceptCreated, linkActorRef ? conceptCreated)))
                        } yield ()
                    case document: DocumentCreated =>
                        maybeDocProgressBar.foreach(_.step())
                        SE.documentCreatedMessage(document) *> handleDocumentCreatedMessage(state, document)
                    case _: HandleExistedDocuments => handleExistedDocumentsMessage(state)
                    case ReadyToShutdown =>
                        for {
                            _ <- SE.readyShutdownMessage
                            _ <- addConceptsToResearchMap(state)
                            _ <- ZIO.collectAllSuccessesPar(List(conceptPropertyActorRef ? ReadyToShutdown, linkActorRef ? ReadyToShutdown)).unit
                        } yield ()
                    case _ => SE.unexpectedMessage
                }).map { unit => (state, unit.asInstanceOf[A]) }
                    .injectSome[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            }
        }

    private def handleExistedConceptsMessage(state: ConceptActorState): URIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(state.concepts.filter(_.conceptId.isKBId).map { concept =>
            val kbId = concept.conceptId.maybeKBId.get
            maybeProgressBar.foreach(_.step())
            for {
                _ <- SE.conceptAlreadyExists(concept)
                _ <- (ReportHttpRequestSender.updateObject(KBMutations.updateConcept(kbId, concept.mainInfo, maybeAccessLevelId)).flatMap { succeed =>
                    if (succeed) SE.metadataUpdatedSuccessfully(concept, kbId)
                    else SE.metadataUpdateFailed(concept)
                }).when(concept.mainInfo.metadata.needToUpdate)
            } yield ()
        }).unit
    }

    private def handleCreateConceptsMessage(state: ConceptActorState): URIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], List[ConceptCreated]] = {
        ZIO.collectAllSuccesses(state.concepts.filter(_.conceptId.isUUID).map { concept =>
            val uuid = concept.conceptId.maybeUUID.get
            maybeProgressBar.foreach(_.step())
            createConcept(uuid, concept, state)
        })
    }

    /**
     * Handle documents that were handled at previous runs (that have KBId in comment)
     * addConceptFact for newKBIds (for concepts that were created at this run)
     */
    private def handleExistedDocumentsMessage(state: ConceptActorState): URIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        val handleDocuments = ZIO.collectAllSuccesses(state.documentId2Concepts.filter { case (documentId, _) => documentId.isKBId }.map { case (documentId, concepts) =>
            maybeDocProgressBar.foreach(_.step())
            ZIO.fromOption(documentId.id.left.toOption).flatMap { documentKBId =>
                ZIO.collectAllSuccesses(concepts.map { concept =>
                    state.tryGetNewConceptKBId(concept.conceptId) match {
                        case Some(conceptKBId) => ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptKBId, documentKBId)).unit
                        case None => ZIO.unit
                    }
                })
            }
        }).unit
        val handleAvatars = ZIO.collectAllSuccesses(state.avatarId2Concepts.filter { case (documentId, _) => documentId.isKBId }.map { case (documentId, concepts) =>
            maybeDocProgressBar.foreach(_.step())
            ZIO.fromOption(documentId.id.left.toOption).flatMap { documentKBId =>
                ZIO.collectAllSuccesses(concepts.map { concept =>
                    state.tryGetNewConceptKBId(concept.conceptId) match {
                        case Some(conceptKBId) => ReportHttpRequestSender.updateConceptAvatar(KBMutations.updateConceptAvatar(conceptKBId, documentKBId)) *>
                            ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptKBId, documentKBId))
                        case None => ZIO.unit
                    }
                })
            }}).unit
        handleDocuments *> handleAvatars
    }

    /**
     * Handle documents that were handled at this run (no KBId in comment)
     *
     * addConceptFact and updateConceptAvatar (for concepts that were created at this run and the previous ones)
     */
    private def handleDocumentCreatedMessage(state: ConceptActorState, document: DocumentCreated): URIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        val documentUUID = DocumentId(document.uuid)
        val handleDocument = state.documentId2Concepts.get(documentUUID) match {
            case Some(concepts) => ZIO.collectAllSuccesses(concepts.map { concept =>
                state.tryGetOldAndNewConceptKBId(concept.conceptId) match {
                    case Some(conceptKBId) => ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptKBId, document.kbId)).unit
                    case None => SE.unableAddDocument(document, concept.mainInfo.conceptIdentifier)
                }
            }).unit
            case None => ZIO.unit
        }
        val handleAvatar = state.avatarId2Concepts.get(documentUUID) match {
            case Some(concepts) => ZIO.collectAllSuccesses(concepts.map { concept =>
                state.tryGetOldAndNewConceptKBId(concept.conceptId) match {
                    case Some(conceptKBId) =>
                        ReportHttpRequestSender.updateConceptAvatar(KBMutations.updateConceptAvatar(conceptKBId, document.kbId)) *>
                            ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptKBId, document.kbId))
                    case None => SE.unableAddAvatar(document, concept.mainInfo.conceptIdentifier)
                }
            }).unit
            case None => ZIO.unit
        }
        handleDocument *> handleAvatar
    }

    private def createConcept(conceptUUID: UUID,
                              concept: Concept,
                              state: ConceptActorState,
                              documentKBId: Option[ID] = None): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], ConceptCreated] = {
        val createConcept = for {
            conceptKBId <- ReportHttpRequestSender.addObject(KBMutations.addConcept(concept.mainInfo, documentKBId, maybeAccessLevelId))
            _ = state.updateStateOnCreatedConcept(concept.conceptId, conceptKBId)
            _ <- addDocxFact(maybeDocxKBId, conceptKBId)
        } yield conceptKBId
        createConcept.either.flatMap {
            case Left(exception) =>
                SE.conceptCreationFailed(concept) *> ZIO.fail(exception)
            case Right(kbId) =>
                SE.conceptCreationSucceed(concept, kbId).as(ConceptCreated(uuid = conceptUUID, kbId = kbId))
        }
    }

    private def addDocxFact(maybeDocxKBId: Option[ID], conceptKBId: ID) = {
        maybeDocxKBId match {
            case Some(docxKBId) => ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptKBId, docxKBId))
            case None => UIO.succeed(false)
        }
    }

    private def addConceptsToResearchMap(state: ConceptActorState) = {
        val conceptInputs = state.getNewConceptKBIds.map(kbId => ConceptAddInputInput(conceptId = kbId.toString))
        val groupedConceptInputs = conceptInputs.grouped(1000).toList
        ZIO.collectAllSuccesses {
            groupedConceptInputs.map { groupConceptInputs =>
                ReportHttpRequestSender.addContentOnResearchMap(
                    KBMutations.addContentOnResearchMap(researchMapId, ResearchMapContentAddInput(concepts = Some(groupConceptInputs))))
            }
        }.when(conceptInputs.nonEmpty)
    }
}
