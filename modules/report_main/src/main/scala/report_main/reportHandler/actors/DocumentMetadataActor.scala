package report_main.reportHandler.actors

import me.tongfei.progressbar.ProgressBar
import report_main.generated.kb_api.graphql.DocumentUpdateInput
import report_main.reportHandler.actors.state.DocumentMetadataActorState
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportHttpRequestSender, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.MetadataExcelDocument
import report_main.reportHandler.utils.DateTimeUtils.convertDateInputToMillis
import report_main.reportHandler.utils.DocumentId
import common.types.ID
import zio._
import zio.actors.Actor._
import zio.actors._
import zio.logging._
import zio.magic.ZioProvideMagicOps

case class DocumentMetadataActor(initialState: DocumentMetadataActorState,
                                 maybeProgressBar: Option[ProgressBar]) {

    import report_main.reportHandler.sideEffects.actors.{DocumentMetadataActorSE => SE}

    val actor: Stateful[Logging with Has[ReportHttpRequestSender] with Has[MetadataWorkbookUpdater], DocumentMetadataActorState, Message] =
        new Stateful[Logging with Has[ReportHttpRequestSender] with Has[MetadataWorkbookUpdater], DocumentMetadataActorState, Message] {
            override def receive[A](state: DocumentMetadataActorState, msg: Message[A], context: Context): URIO[Logging with Has[ReportHttpRequestSender] with Has[MetadataWorkbookUpdater], (DocumentMetadataActorState, A)] = {
                (msg match {
                    // те документы которые не отправлялись в кафку
                    case _: HandleExistedDocuments =>
                        maybeProgressBar.foreach(_.step())
                        SE.handleExistedDocumentsMessage *> handleExistedDocumentsMessage(state)
                    // кафка: дупликат или обработано
                    case document: DocumentCreated =>
                        maybeProgressBar.foreach(_.step())
                        SE.documentCreatedMessage(document) *> handleDocumentCreatedMessage(state, document)
                    case ReadyToShutdown => SE.readyShutdownMessage
                    case _ => SE.unexpectedMessage
                }).map { unit => (state, unit.asInstanceOf[A]) }
                    .injectSome[Logging with Has[ReportHttpRequestSender] with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
            }
        }

    private def handleExistedDocumentsMessage(state: DocumentMetadataActorState): URIO[Logging with Has[WorkbookUpdater] with Has[ReportHttpRequestSender], Unit] = {
        ZIO.collectAllSuccesses(state.documentId2Document.filter { case (documentId, _) => documentId.isKBId }.map { case (documentId, document) =>
            ZIO.fromOption(documentId.id.left.toOption).flatMap { documentKBId =>
                SE.documentAlreadyExists(document) *>
                (for {
                    isSucceed <- updateMetadata(documentKBId, document)
                    _ <- if (isSucceed) SE.metadataUpdatedSuccessfully(document, documentKBId)
                    else SE.metadataUpdateFailed(document)
                } yield ()).when(document.metadata.needToUpdate)
            }}).unit
    }


    private def handleDocumentCreatedMessage(state: DocumentMetadataActorState, documentCreated: DocumentCreated): URIO[Logging with Has[WorkbookUpdater] with Has[ReportHttpRequestSender], Unit] = {
        state.documentId2Document.get(DocumentId(documentCreated.uuid)) match {
            case Some(docMetadata) =>
                for {
                    isSucceed <- updateMetadata(documentCreated.kbId, docMetadata)
                    _ <- if (isSucceed) SE.metadataUpdatedSuccessfully(docMetadata, documentCreated.kbId)
                    else SE.metadataUpdateFailed(docMetadata)
                } yield ()
            case None => ZIO.unit
        }
    }

    private def updateMetadata(kbId: ID, docMetadata: MetadataExcelDocument): URIO[Logging with Has[ReportHttpRequestSender], Boolean] = {
        for {
            documentKBInfo <- ReportHttpRequestSender.getDocument(kbId.toString)
            isSucceed <- ReportHttpRequestSender.updateDocument(KBMutations.updateDocument(DocumentUpdateInput(
                id = kbId.toString,
                title = documentKBInfo.flatMap(_.title),
                externalUrl = docMetadata.metadata.maybeMetadataExternalUrl.map(_.value)
                    .orElse(documentKBInfo.flatMap(_.externalUrl)),
                publicationDate = docMetadata.metadata.maybeMetadataPublicationDate
                    .flatMap { metadataPublicationDate => convertDateInputToMillis(metadataPublicationDate.value.date) }
                    .orElse(documentKBInfo.flatMap(_.publicationDate.map(_.toLong))),
                publicationAuthor = docMetadata.metadata.maybeMetadataPublicationAuthor.map(_.value)
                    .orElse(documentKBInfo.flatMap(_.publicationAuthor)),
                notes = docMetadata.metadata.maybeMetadataDescription.map(_.value)
                    .orElse(documentKBInfo.flatMap(_.notes)),
                markers = documentKBInfo.map(_.markers)
            )))
        } yield isSucceed
    }
}

