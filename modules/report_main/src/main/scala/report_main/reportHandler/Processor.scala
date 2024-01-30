package report_main.reportHandler

import report_main.generated.kb_api.graphql.{DocumentAddInputInput, ResearchMapContentAddInput}
import report_main.reportHandler.actors.{DocumentCreated, Message}
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus.{MessageDuplicate, MessageFailed, MessageOk, MessageStatus, MessageUnknown}
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportHttpRequestSender, ReportWorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.MetadataExcelDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelDocument
import report_main.reportHandler.utils.DocumentId
import common.types.ID
import zio.actors.ActorRef
import zio.clock.Clock
import zio.duration._
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.random.Random
import zio.{Has, RIO, Schedule, Task, URIO, ZIO}

import java.util.UUID

object Processor {

    import report_main.reportHandler.sideEffects.{ProcessorSE => SE}

    def startProcessing(documentId2ActorRefs: Map[DocumentId, Seq[ActorRef[Message]]],
                        documentId2ReportExcelDocument: Map[DocumentId, ReportExcelDocument],
                        documentId2MetadataExcelDocument: Map[DocumentId, MetadataExcelDocument],
                        researchMapId: ID)
    : RIO[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater] with Random with Clock, Unit] = {
        ZIO.collectAllSuccessesPar(documentId2ActorRefs.filter { case (documentId, _) => documentId.isUUID }.map { case (documentId, actorRefs) =>
            val documentUUID = documentId.maybeUUID.get
            repeatAskIsDocumentHandled(documentUUID).flatMap {
                case (MessageOk | MessageDuplicate, Some(documentKBId)) =>
                    for {
                        _ <- onDocumentSucceed(documentId2ReportExcelDocument, documentId2MetadataExcelDocument, documentId, documentKBId)
                        _ <- ZIO.collectAllSuccesses(actorRefs.map(actorRef => actorRef ! DocumentCreated(documentUUID, documentKBId))).unit
                    } yield documentKBId
                case (MessageFailed | MessageUnknown, _) =>
                    onDocumentFailed(documentId2ReportExcelDocument, documentId2MetadataExcelDocument, documentId, documentUUID)
                case (_, _) => SE.documentHandlingUnexpectedBehaviour(documentId2ReportExcelDocument(documentId), documentUUID)
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
            .injectSome[Logging with Has[ReportHttpRequestSender] with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater] with Random with Clock](ReportWorkbookUpdater.workbookUpdaterLayer)
    }

    private def onDocumentSucceed(documentId2ReportExcelDocument: Map[DocumentId, ReportExcelDocument],
                                  documentId2MetadataExcelDocument: Map[DocumentId, MetadataExcelDocument],
                                  documentId: DocumentId,
                                  documentKBId: ID): URIO[Has[MetadataWorkbookUpdater] with Has[ReportWorkbookUpdater], Unit] = {
        for {
            _ <- SE.documentHandlingSucceed(documentId2ReportExcelDocument(documentId), documentKBId)
                .injectSome[Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            _ <- (SE.documentHandlingSucceed(documentId2MetadataExcelDocument(documentId), documentKBId).when(documentId2MetadataExcelDocument.contains(documentId)))
                .injectSome[Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
        } yield ()
    }

    private def onDocumentFailed(documentId2ReportExcelDocument: Map[DocumentId, ReportExcelDocument],
                                 documentId2MetadataExcelDocument: Map[DocumentId, MetadataExcelDocument],
                                 documentId: DocumentId,
                                 documentUUID: UUID): URIO[Logging with Has[MetadataWorkbookUpdater] with Has[ReportWorkbookUpdater], Unit] = {
        for {
            _ <- SE.documentHandlingFailed(documentId2ReportExcelDocument(documentId), documentUUID)
                .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            _ <- SE.documentHandlingFailed(documentId2MetadataExcelDocument(documentId), documentUUID).when(documentId2MetadataExcelDocument.contains(documentId))
                .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
        } yield ()
    }

    def tryGetDocxKBId(docxUUID: UUID): RIO[Logging with Random with Clock with Has[ReportHttpRequestSender], Option[ID]] = {
        SE.waitingDocx(docxUUID.toString) *>
            repeatAskIsDocumentHandled(docxUUID).flatMap {
                case (MessageOk | MessageDuplicate, Some(docxKBId)) => SE.docxHandlingSucceed(docxKBId).as(Some(docxKBId))
                case (MessageFailed | MessageUnknown, _) => SE.docxHandlingFailed.as(None)
                case (_, _) => SE.docxHandlingUnexpectedBehaviour.as(None)
            }
    }


    private def repeatAskIsDocumentHandled(uuid: UUID): RIO[Random with Clock with Logging with Has[ReportHttpRequestSender], (MessageStatus, Option[ID])] = {
        Task(ReportHttpRequestSender.isDocumentHandled(uuid.toString)).flatten
            .repeat(Schedule.spaced(90.seconds).jittered && Schedule.recurWhile {
                case (MessageStatus.MessageInProgress, _) => true
                case (MessageStatus.MessageNotHandled, _) => true
                case _ => false
            })
            .map(_._2)
    }
}
