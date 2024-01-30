package report_main.reportHandler.actors

import me.tongfei.progressbar.ProgressBar
import report_main.reportHandler.actors.state.ConceptPropertyActorState
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.{ReportHttpRequestSender, ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import report_main.reportHandler.utils.{ConceptId, DocumentId}
import common.types.ID
import zio.actors.Actor.Stateful
import zio.actors.Context
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, UIO, ZIO}

case class ConceptPropertyActor(initialState: ConceptPropertyActorState,
                                maybeDocxKBId: Option[ID],
                                maybeAccessLevelId: Option[ID],
                                maybeProgressBar: Option[ProgressBar],
                                maybeDocProgressBar: Option[ProgressBar]) {

    import report_main.reportHandler.sideEffects.actors.{ConceptPropertyActorSE => SE}

    val actor: Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], ConceptPropertyActorState, Message] = new Stateful[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], ConceptPropertyActorState, Message] {
        override def receive[A](state: ConceptPropertyActorState, msg: Message[A], context: Context): RIO[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater], (ConceptPropertyActorState, A)] = {
            (msg match {
                // 1
                case _: HandleExistedConceptProperties =>
                    SE.handleExistedConceptPropertiesMessage *> handleExistedConceptPropertiesMessage(state)
                // 2
                case _: CreatePropertiesForExistedConcepts =>
                    SE.createPropertiesForExistedConceptsMessage *> createPropertiesForExistedConceptsMessage(state)
                case concept: ConceptCreated =>
                    SE.conceptCreatedMessage(concept) *> handleConceptCreatedMessage(state, concept)
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

    private def handleExistedConceptPropertiesMessage(state: ConceptPropertyActorState): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(state.properties.filter(_.propertyId.isKBId).map { property =>
            val kbId = property.propertyId.maybeKBId.get
            maybeProgressBar.foreach(_.step())
            for {
                _ <- SE.propertyAlreadyExists(property)
                _ <- (ReportHttpRequestSender.updateObject(KBMutations.updateConceptProperty(kbId, property.mainInfo, maybeAccessLevelId)).flatMap { succeed =>
                    if (succeed) SE.metadataUpdatedSuccessfully(property, kbId)
                    else SE.metadataUpdateFailed(property)
                }).when(property.mainInfo.metadata.needToUpdate)
            } yield ()
        }).unit
    }

    private def createPropertiesForExistedConceptsMessage(state: ConceptPropertyActorState): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        ZIO.collectAllSuccesses(state.propertyId2PropertyBuilder.map { case (propertyId, _) =>
            if (propertyId.isUUID && state.tryGetNewPropertyKBId(propertyId).isEmpty) {
                val property = state.propertyId2Property(propertyId)
                tryCreateProperty(property, state)
            } else RIO.none
        }).unit
    }

    /**
     * if property wasn't created yet then update propertyBuilder and try create property
     */
    private def handleConceptCreatedMessage(state: ConceptPropertyActorState, conceptCreated: ConceptCreated): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Unit] = {
        val conceptId = ConceptId(conceptCreated.uuid)

        val propertiesForConcept = state.conceptId2Properties.getOrElse(conceptId, List.empty)

        // update PropertyBuilder.conceptKBId
        propertiesForConcept.foreach { property =>
            property.propertyId.id.foreach { uuid =>
                state.propertyId2PropertyBuilder(property.propertyId).maybeConceptKBId = Some(conceptCreated.kbId)
            }
        }

        ZIO.collectAllSuccesses(propertiesForConcept.distinct.filter(_.propertyId.isUUID).map { property =>
            tryCreateProperty(property, state)
        }).map(_.flatten)
    }

    /**
     * Handle documents that were handled at previous runs (that have KBId in comment)
     * addPropertyFact for newKBIds (for properties that were created at this run)
     */
    private def handleExistedDocumentsMessage(state: ConceptPropertyActorState): RIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        ZIO.collectAllSuccesses(state.documentId2Properties.filter { case (documentId, _) => documentId.isKBId }.map { case (documentId, properties) =>
            maybeDocProgressBar.foreach(_.step())
            ZIO.fromOption(documentId.id.left.toOption).flatMap { documentKBId =>
                ZIO.collectAllSuccesses(properties.map { property =>
                    state.tryGetNewPropertyKBId(property.propertyId) match {
                        case Some(propertyKBId) =>
                            val conceptKBId = state.propertyKBId2ConceptKBId(propertyKBId)
                            addFacts(propertyKBId = propertyKBId, conceptKBId = conceptKBId, documentKBIds = List(documentKBId))
                        case None => ZIO.unit
                    }
                })
            }
        }).unit
    }

    /**
     * handle documents that were handled at this run (no KBId in comment)
     * addPropertyFact (for properties that were created at this run and the previous ones)
     */
    private def handleDocumentCreatedMessage(state: ConceptPropertyActorState, document: DocumentCreated): RIO[Logging with Has[ReportHttpRequestSender], Unit] = {
        state.documentId2Properties.get(DocumentId(document.uuid)) match {
            case Some(properties) =>
                ZIO.collectAllSuccesses(properties.map { property =>
                    state.tryGetOldAndNewPropertyKBId(property.propertyId) match {
                        case Some(propertyKBId) =>
                            val conceptKBId = state.propertyKBId2ConceptKBId(propertyKBId)
                            addFacts(propertyKBId = propertyKBId, conceptKBId = conceptKBId, documentKBIds = List(document.kbId))
                        case None => SE.unableAddDocument(document, property.mainInfo.propertyIdentifier)
                    }
                }).unit
            case None => ZIO.unit
        }
    }

    /**
     * addConceptProperty
     *
     * update state.propertyUUID2KBId
     *
     * addConceptPropertyFact with docxKBId
     *
     * addConceptPropertyFacts with other related documents
     */
    private def tryCreateProperty(property: Property, state: ConceptPropertyActorState): RIO[Logging with Has[ReportHttpRequestSender] with Has[WorkbookUpdater], Option[ID]] = {
        val propertyBuilder = state.propertyId2PropertyBuilder(property.propertyId)
        (propertyBuilder.maybeConceptKBId, propertyBuilder.documentKBIds) match {
            case (Some(conceptKBId), documentKBIds) =>
                val propertyKBIdEffect = for {
                    propertyKBId <- ReportHttpRequestSender.addObject(KBMutations.addConceptProperty(property.mainInfo, conceptKBId, None))
                    // update state
                    _ = state.updateStateOnCreatedProperty(property.propertyId, propertyKBId = propertyKBId, conceptKBId = conceptKBId)
                    // add facts
                    _ <- addDocxFact(maybeDocxKBId, propertyKBId)
                    _ <- addFacts(propertyKBId = propertyKBId, conceptKBId = conceptKBId, documentKBIds = documentKBIds)
                } yield propertyKBId

                propertyKBIdEffect.either.flatMap {
                    case Left(_) =>
                        SE.propertyCreationFailed(property).as(None)
                    case Right(kbId) =>
                        maybeProgressBar.foreach(_.step())
                        SE.propertyCreationSucceed(property, kbId).as(Some(kbId))
                }
            case _ => ZIO.none
        }
    }

    private def addDocxFact(maybeDocxKBId: Option[ID], propertyKBId: ID) = {
        maybeDocxKBId match {
            case Some(kbId) => ReportHttpRequestSender.addObjectFact(KBMutations.addConceptPropertyFact(propertyKBId, kbId))
            case None => UIO.succeed(false)
        }
    }

    private def addFacts(propertyKBId: ID, conceptKBId: ID, documentKBIds: List[ID]) = {
        ZIO.foreach_(documentKBIds) { documentKBId =>
            for {
                addConceptPropertyFact <- ReportHttpRequestSender.addObjectFact(KBMutations.addConceptPropertyFact(propertyKBId, documentKBId))
                addConceptFact <- ReportHttpRequestSender.addObjectFact(KBMutations.addConceptFact(conceptKBId, documentKBId)).when(addConceptPropertyFact)
            } yield ()
        }
    }
}
