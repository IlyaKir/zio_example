package report_main.reportHandler.actors

import me.tongfei.progressbar.ProgressBar
import report_main.reportHandler.actors.state.LinkActorState
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.{ReportHttpRequestSender, ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.utils.{ConceptId, DocumentId}
import common.types.ID
import zio.actors.Actor.Stateful
import zio.actors.{ActorRef, Context}
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, UIO, URIO, ZIO}

case class LinkActor(initialState: LinkActorState,
                     linkPropertyActorRef: ActorRef[Message],
                     maybeDocxKBId: Option[ID],
                     maybeAccessLevelId: Option[ID],
                     maybeProgressBar: Option[ProgressBar],
                     maybeDocProgressBar: Option[ProgressBar]) {

    import report_main.reportHandler.sideEffects.actors.{LinkActorSE => SE}

    val actor: Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], LinkActorState, Message] =
        new Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], LinkActorState, Message] {
            override def receive[A](state: LinkActorState, msg: Message[A], context: Context): RIO[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], (LinkActorState, A)] = {
                (msg match {
                    case _: HandleExistedLinks => SE.handleExistedLinksMessage *> handleExistedLinksMessage(state)
                    case _: CreateLinksForExistedConcepts =>
                        for {
                            _ <- SE.handleCreateLinksForExistedConceptsMessage
                            createdLinks <- handleCreateLinksForExistedConceptsMessage(state)
                            _ <- ZIO.foreach_(createdLinks) { linkCreated =>
                                ZIO.collectAllSuccessesPar(Seq(linkPropertyActorRef ! linkCreated))
                            }
                        } yield ()
                    case concept: ConceptCreated =>
                        for {
                            _ <- SE.conceptCreatedMessage(concept)
                            createdLinks <- handleConceptCreatedMessage(state, concept)
                            _ <- ZIO.foreach_(createdLinks) { linkCreated =>
                                ZIO.collectAllSuccessesPar(Seq(linkPropertyActorRef ! linkCreated))
                            }
                        } yield ()
                    case document: DocumentCreated =>
                        maybeDocProgressBar.foreach(_.step())
                        SE.documentCreatedMessage(document) *> handleDocumentCreatedMessage(state, document).unit
                    case _: HandleExistedDocuments => handleExistedDocumentsMessage(state).unit
                    case ReadyToShutdown =>
                        SE.readyShutdownMessage *> (linkPropertyActorRef ? ReadyToShutdown).unit
                    case _ => SE.unexpectedMessage
                }).map { unit => (state, unit.asInstanceOf[A]) }
                    .injectSome[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            }
        }

    private def handleExistedLinksMessage(state: LinkActorState): URIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(state.links.filter(_.linkId.isKBId).map { link =>
            val kbId = link.linkId.maybeKBId.get
            maybeProgressBar.foreach(_.step())
            for {
                _ <- SE.linkAlreadyExists(link)
                _ <- (ReportHttpRequestSender.updateObject(KBMutations.updateConceptLink(kbId, link.mainInfo.metadata, maybeAccessLevelId)).flatMap { succeed =>
                    if (succeed) SE.metadataUpdatedSuccessfully(link, kbId)
                    else SE.metadataUpdateFailed(link)
                }).when(link.mainInfo.metadata.needToUpdate)
            } yield ()
        }).unit
    }

    private def handleCreateLinksForExistedConceptsMessage(state: LinkActorState): URIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Iterable[LinkCreated]] = {
        ZIO.collectAllSuccesses(state.linkId2Link.map { case (linkId, link) =>
            if (linkId.isUUID) tryCreateLink(link, state)
            else RIO.none
        }).map(_.flatten.toSeq)
    }

    private def handleConceptCreatedMessage(state: LinkActorState, conceptCreated: ConceptCreated): URIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], List[LinkCreated]] = {
        val conceptId = ConceptId(conceptCreated.uuid)

        val linksForConceptFrom = state.conceptFromId2Links.getOrElse(conceptId, List.empty)
        val linksForConceptTo = state.conceptToId2Links.getOrElse(conceptId, List.empty)

        // update LinkBuilder.conceptFromKBId
        linksForConceptFrom.foreach { link =>
            link.linkId.id.foreach { uuid =>
                state.linkId2LinkBuilder(link.linkId).maybeConceptFromKBId = Some(conceptCreated.kbId)
            }
        }
        // update LinkBuilder.conceptToKBId
        linksForConceptTo.foreach { link =>
            link.linkId.id.foreach { uuid =>
                state.linkId2LinkBuilder(link.linkId).maybeConceptToKBId = Some(conceptCreated.kbId)
            }
        }

        ZIO.collectAllSuccesses((linksForConceptFrom ++ linksForConceptTo).distinct.map { link =>
            tryCreateLink(link, state)
        }).map(_.flatten)
    }

    private def handleExistedDocumentsMessage(state: LinkActorState): URIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        ZIO.collectAllSuccesses(state.documentId2Links.filter { case (documentId, _) => documentId.isKBId }.map { case (documentId, links) =>
            maybeDocProgressBar.foreach(_.step())
            ZIO.fromOption(documentId.id.left.toOption).flatMap { documentKBId =>
                ZIO.collectAllSuccesses(links.map { link =>
                    state.tryGetNewLinkKBId(link.linkId) match {
                        case Some(linkKBId) =>
                            val (conceptFromKBId, conceptToKBId) = state.linkKBId2ConceptKBIds(linkKBId)
                            addFacts(linkKBId, conceptFromKBId, conceptToKBId, List(documentKBId))
                        case _ => ZIO.unit
                    }
                })
        }}).unit
    }

    private def handleDocumentCreatedMessage(state: LinkActorState, document: DocumentCreated): URIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        state.documentId2Links.get(DocumentId(document.uuid)) match {
            case Some(links) =>
                ZIO.collectAllSuccesses(links.map { link =>
                    state.tryGetOldAndNewLinkKBId(link.linkId) match {
                        case Some(linkKBId) =>
                            val (conceptFromKBId, conceptToKBId) = state.linkKBId2ConceptKBIds(linkKBId)
                            addFacts(linkKBId, conceptFromKBId, conceptToKBId, List(document.kbId))
                        case _ => SE.unableAddDocument(document, link)
                    }
                }).unit
            case None => ZIO.unit
        }
    }

    private def tryCreateLink(link: Link, state: LinkActorState): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Option[LinkCreated]] = {
        val linkBuilder = state.linkId2LinkBuilder(link.linkId)
        link.linkId.id match {
            case Left(kbId) => SE.linkCreatedFailedBecauseAlreadyExists(kbId) *> ZIO.fail(new Throwable)
            case Right(uuid) => (linkBuilder.maybeConceptFromKBId, linkBuilder.maybeConceptToKBId, linkBuilder.documentKBIds) match {
                case (Some(conceptFromKBId), Some(conceptToKBId), documentKBIds) =>
                    val linkKBIdEffect = for {
                        linkKBId <- ReportHttpRequestSender.addObject(KBMutations.addConceptLink(link.mainInfo, conceptFromKBId, conceptToKBId, None, maybeAccessLevelId))
                        // update state
                        _ = state.updateStateOnCreatedLink(link.linkId, linkKBId, conceptFromKBId = conceptFromKBId, conceptToKBId = conceptToKBId)
                        // add facts
                        _ <- addDocxFact(maybeDocxKBId, linkKBId)
                        _ <- addFacts(linkKBId = linkKBId, conceptFromKBId = conceptFromKBId, conceptToKBId = conceptToKBId, documentKBIds = documentKBIds)
                    } yield linkKBId

                    linkKBIdEffect.either.flatMap {
                        case Left(exception) =>
                            SE.linkCreationFailed(link, conceptFromKBId, conceptToKBId, exception).as(None)
                        case Right(kbId) =>
                            maybeProgressBar.foreach(_.step())
                            SE.linkCreatedSuccessfully(link, kbId).as(Some(LinkCreated(uuid = uuid, kbId = kbId)))
                    }
                case _ => ZIO.none
            }
        }
    }

    private def addDocxFact(maybeDocxKBId: Option[ID], linkKBId: ID) = {
        maybeDocxKBId match {
            case Some(kbId) => ReportHttpRequestSender.addObjectFact(KBMutations.addConceptLinkFact(linkKBId, kbId))
            case None => UIO.succeed(false)
        }
    }

    private def addFacts(linkKBId: ID,
                         conceptFromKBId: ID,
                         conceptToKBId: ID,
                         documentKBIds: List[ID]): URIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        ZIO.foreach_(documentKBIds) { documentKBId =>
            for {
                addLinkFact <- ReportHttpRequestSender.addObjectFact(KBMutations.addConceptLinkFact(linkKBId, documentKBId))
                addConceptsFacts <- (ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptFromKBId, documentKBId)) *>
                    ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptToKBId, documentKBId))).when(addLinkFact)
            } yield ()
        }
    }
}
