package report_main.reportHandler.actors

import me.tongfei.progressbar.ProgressBar
import report_main.reportHandler.actors.state.LinkPropertyActorState
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.{ReportHttpRequestSender, ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import report_main.reportHandler.utils.{DocumentId, LinkId}
import common.types.ID
import zio.actors.Actor.Stateful
import zio.actors.Context
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, UIO, ZIO}

case class LinkPropertyActor(initialState: LinkPropertyActorState,
                             maybeDocxKBId: Option[ID],
                             maybeAccessLevelId: Option[ID],
                             maybeProgressBar: Option[ProgressBar],
                             maybeDocProgressBar: Option[ProgressBar]) {

    import report_main.reportHandler.sideEffects.actors.{LinkPropertyActorSE => SE}

    val actor: Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], LinkPropertyActorState, Message] = new Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], LinkPropertyActorState, Message] {
        override def receive[A](state: LinkPropertyActorState, msg: Message[A], context: Context): RIO[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], (LinkPropertyActorState, A)] = {
            (msg match {
                // 1
                case _: HandleExistedLinkProperties => SE.handleExistedLinkPropertiesMessage *> handleExistedLinkPropertiesMessage(state)
                // 2
                case _: CreatePropertiesForExistedLinks =>
                    SE.createPropertiesForExistedLinksMessage *> handleCreatePropertiesForExistedLinksMessage(state)
                case link: LinkCreated =>
                    SE.linkCreatedMessage(link) *> handleLinkCreatedMessage(state, link)
                case document: DocumentCreated =>
                    maybeDocProgressBar.foreach(_.step())
                    SE.documentCreatedMessage(document) *> handleDocumentCreatedMessage(state, document)
                case _: HandleExistedDocuments => handleExistedDocumentsMessage(state)
                case ReadyToShutdown => SE.readyShutdownMessage
                case _ => SE.unexpectedMessage
            }).map { unit => (state, unit.asInstanceOf[A]) }
                .injectSome[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
        }
    }

    private def handleExistedLinkPropertiesMessage(state: LinkPropertyActorState) = {
        ZIO.collectAllSuccesses(state.properties.filter(_.propertyId.isKBId).map { property =>
            val kbId = property.propertyId.maybeKBId.get
            maybeProgressBar.foreach(_.step())
            for {
                _ <- SE.propertyAlreadyExists(property)
                _ <- (ReportHttpRequestSender.updateObject(KBMutations.updateLinkProperty(kbId, property.mainInfo, maybeAccessLevelId)).flatMap { succeed =>
                    if (succeed) SE.metadataUpdatedSuccessfully(property, kbId)
                    else SE.metadataUpdateFailed(property)
                }).when(property.mainInfo.metadata.needToUpdate)
            } yield ()
        }).unit
    }

    private def handleCreatePropertiesForExistedLinksMessage(state: LinkPropertyActorState): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(state.propertyId2PropertyBuilder.map { case (propertyId, _) =>
            if (propertyId.isUUID) {
                val property = state.propertyId2Property(propertyId)
                tryCreateProperty(property, state)
            } else RIO.none
        }).unit
    }

    /**
     * if property wasn't created yet then update propertyBuilder and try create property
     */
    private def handleLinkCreatedMessage(state: LinkPropertyActorState, linkCreated: LinkCreated): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        val linkId = LinkId(linkCreated.uuid)

        val propertiesForConcept = state.linkId2Properties.getOrElse(linkId, List.empty)

        // update PropertyBuilder.conceptKBId
        propertiesForConcept.foreach { property =>
            property.propertyId.id.foreach { uuid =>
                state.propertyId2PropertyBuilder(property.propertyId).maybeLinkKBId = Some(linkCreated.kbId)
            }
        }

        ZIO.collectAllSuccesses(propertiesForConcept.distinct.filter(_.propertyId.isUUID).map { property =>
            tryCreateProperty(property, state)
        }).map(_.flatten)
    }

    /**
     * Handle documents that were handled at previous runs (that have KBId in comment)
     *
     * addPropertyFact for newKBIds (for properties that were created at this run)
     */
    private def handleExistedDocumentsMessage(state: LinkPropertyActorState): RIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        ZIO.collectAllSuccesses(state.documentId2Properties.filter { case (documentId, _) => documentId.isKBId }.map { case (documentId, properties) =>
            maybeDocProgressBar.foreach(_.step())
            ZIO.fromOption(documentId.id.left.toOption).flatMap { documentKBId =>
                ZIO.collectAllSuccesses(properties.map { property =>
                    state.tryGetNewPropertyKBId(property.propertyId) match {
                        case Some(propertyKBId) =>
                            val linkKBId = state.propertyKBId2LinkKBId(propertyKBId)
                            addFacts(propertyKBId = propertyKBId, linkKBId = linkKBId, List(documentKBId))
                        case _ => ZIO.unit
                    }
                })
            }
        }).unit
    }

    /**
     * Handle documents that were handled at this run (no KBId in comment)
     *
     * addPropertyFact (for properties that were created at this run and the previous ones)
     */
    private def handleDocumentCreatedMessage(state: LinkPropertyActorState, document: DocumentCreated): RIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        state.documentId2Properties.get(DocumentId(document.uuid)) match {
            case Some(properties) =>
                ZIO.collectAllSuccesses(properties.map { property =>
                    state.tryGetOldAndNewPropertyKBId(property.propertyId) match {
                        case Some(propertyKBId) =>
                            val linkKBId = state.propertyKBId2LinkKBId(propertyKBId)
                            addFacts(propertyKBId = propertyKBId, linkKBId = linkKBId, List(document.kbId))
                        case _ => SE.unableAddDocument(document, property.mainInfo.propertyIdentifier)
                    }
                }).unit
            case _ => ZIO.unit
        }
    }

    private def tryCreateProperty(property: Property, state: LinkPropertyActorState)
    : RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Option[ID]] = {
        val propertyBuilder = state.propertyId2PropertyBuilder(property.propertyId)
        (propertyBuilder.maybeLinkKBId, propertyBuilder.documentCreatedMessages) match {
            case (Some(linkKBId), documents) =>
                val propertyKBIdEffect = for {
                    propertyKBId <- ReportHttpRequestSender.addObject(KBMutations.addConceptLinkProperty(property.mainInfo, linkKBId, None))
                    // update state
                    _ = state.updateStateOnCreatedProperty(property.propertyId, propertyKBId = propertyKBId, linkKBId = linkKBId)
                    // add doc facts
                    _ <- addDocxFact(maybeDocxKBId, propertyKBId)
                    _ <- addFacts(propertyKBId = propertyKBId, linkKBId = linkKBId, documentKBIds = documents.map(_.kbId))
                } yield propertyKBId

                propertyKBIdEffect.either.flatMap {
                    case Left(_) => SE.propertyCreationFailed(property).as(None)
                    case Right(kbId) =>
                        maybeProgressBar.foreach(_.step())
                        SE.propertyCreationSucceed(property, kbId).as(Some(kbId))
                }
            case _ => ZIO.none
        }
    }

    private def addDocxFact(maybeDocxKBId: Option[ID], propertyKBId: ID) = {
        maybeDocxKBId match {
            case Some(kbId) => ReportHttpRequestSender.addObjectFact(KBMutations.addConceptLinkPropertyFact(propertyKBId, kbId))
            case None => UIO.succeed(false)
        }
    }

    private def addFacts(propertyKBId: ID, linkKBId: ID, documentKBIds: List[ID]) = {
        ZIO.foreach_(documentKBIds) { documentKBId =>
            for {
                addLinkPropertyFact <- ReportHttpRequestSender.addObjectFact(KBMutations.addConceptLinkPropertyFact(propertyKBId, documentKBId))
                addConceptFact <- ReportHttpRequestSender.addObjectFact(KBMutations.addConceptLinkFact(linkKBId, documentKBId)).when(addLinkPropertyFact)
            } yield ()
        }
    }
}
