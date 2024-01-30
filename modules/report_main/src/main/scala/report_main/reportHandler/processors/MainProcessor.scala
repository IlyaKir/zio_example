package report_main.reportHandler.processors

import report_main.generated.kb_api.graphql.{DocumentAddInputInput, ResearchMapContentAddInput}
import report_main.reportHandler.actors.init.ActorsInitializerResult
import report_main.reportHandler.actors._
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus._
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportHttpRequestSender, ReportWorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.MetadataExcelDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelDocument
import report_main.reportHandler.utils.DocumentId
import common.types.ID
import zio.clock.Clock
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.random.Random
import zio.{Has, RIO, URIO, ZIO}

import java.util.UUID

case class MainProcessor(actors: ActorsInitializerResult,
                         documentId2ReportExcelDocument: Map[DocumentId, ReportExcelDocument],
                         documentId2MetadataExcelDocument: Map[DocumentId, MetadataExcelDocument],
                         researchMapId: ID) extends Processor {
    import report_main.reportHandler.sideEffects.{ProcessorSE => SE}

    def startProcessing: RIO[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater] with Random with Clock, Unit] = {
        for {
            _ <- (actors.actorRefs.conceptPropertyActor ? HandleExistedConceptProperties()) *> (actors.actorRefs.conceptPropertyActor ? CreatePropertiesForExistedConcepts())
            _ <- (actors.actorRefs.linkPropertyActor ? HandleExistedLinkProperties()) *> (actors.actorRefs.linkPropertyActor ? CreatePropertiesForExistedLinks())
            _ <- actors.actorRefs.linkActor ? HandleExistedLinks()
            _ <- actors.actorRefs.conceptActor ? HandleExistedConcepts()
            _ <- actors.actorRefs.linkActor ? CreateLinksForExistedConcepts()
            _ <- actors.actorRefs.conceptActor ? CreateConcepts()
            _ <- actors.actorRefs.documentMetadataActor ? HandleExistedDocuments()
            _ <- askDocuments
        } yield ()
    }

    private def askDocuments: URIO[Logging with Has[ReportHttpRequestSender] with Has[MetadataWorkbookUpdater] with Has[ReportWorkbookUpdater] with Random with Clock, Unit] = {
        ZIO.collectAllSuccesses(actors.documentId2ActorRefs.filter { case (documentId, _) => documentId.isUUID }.map { case (documentId, actorRefs) =>
            val documentUUID = documentId.maybeUUID.get
            repeatAskIsDocumentHandled(documentUUID).flatMap {
                case (MessageOk | MessageDuplicate, Some(documentKBId)) =>
                    for {
                        _ <- onDocumentSucceed(documentId, documentKBId)
                        _ <- ZIO.collectAllSuccesses(actorRefs.map(actorRef => actorRef ! DocumentCreated(documentUUID, documentKBId))).unit
                    } yield documentKBId
                case (MessageFailed | MessageUnknown, _) => onDocumentFailed(documentId, documentUUID)
                case (_, _) => onUnexpectedBehaviour(documentId, documentUUID)
            }
        }).flatMap { documentKBIds =>
            val documentInputs = documentKBIds.map(kbId => DocumentAddInputInput(documentId = kbId.toString)).toList
            val groupedConceptInputs = documentInputs.grouped(1000).toList
            ZIO.collectAllSuccesses {
                groupedConceptInputs.map { groupDocumentInputs =>
                    ReportHttpRequestSender.addContentOnResearchMap(
                        KBMutations.addContentOnResearchMap(researchMapId, ResearchMapContentAddInput(documents = Some(groupDocumentInputs))))
                }
            }.when(documentInputs.nonEmpty)
        }
    }

    private def onDocumentSucceed(documentId: DocumentId,
                                  documentKBId: ID): URIO[Has[MetadataWorkbookUpdater] with Has[ReportWorkbookUpdater], Unit] = {
        for {
            _ <- SE.documentHandlingSucceed(documentId2ReportExcelDocument(documentId), documentKBId)
                .injectSome[Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            _ <- documentId2MetadataExcelDocument.get(documentId) match {
                case Some(metadataExcelDocument) => SE.documentHandlingSucceed(metadataExcelDocument, documentKBId)
                    .injectSome[Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
                case None => URIO.unit
            }
        } yield ()
    }

    private def onDocumentFailed(documentId: DocumentId,
                                 documentUUID: UUID): URIO[Logging with Has[MetadataWorkbookUpdater] with Has[ReportWorkbookUpdater], Unit] = {
        for {
            _ <- SE.documentHandlingFailed(documentId2ReportExcelDocument(documentId), documentUUID)
                .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            _ <- documentId2MetadataExcelDocument.get(documentId) match {
                case Some(metadataExcelDocument) => SE.documentHandlingFailed(metadataExcelDocument, documentUUID)
                    .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
                case None => URIO.unit
            }
        } yield ()
    }

    private def onUnexpectedBehaviour(documentId: DocumentId,
                                      documentUUID: UUID): URIO[Logging with Has[MetadataWorkbookUpdater] with Has[ReportWorkbookUpdater], Unit] = {
        for {
            _ <- SE.documentHandlingUnexpectedBehaviour(documentId2ReportExcelDocument(documentId), documentUUID)
                .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            _ <- documentId2MetadataExcelDocument.get(documentId) match {
                case Some(metadataExcelDocument) => SE.documentHandlingUnexpectedBehaviour(metadataExcelDocument, documentUUID)
                    .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
                case None => URIO.unit
            }
        } yield ()
    }
}
