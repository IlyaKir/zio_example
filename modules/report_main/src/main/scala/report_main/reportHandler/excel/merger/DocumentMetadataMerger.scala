package report_main.reportHandler.excel.merger

import report_main.reportHandler.layers.MetadataWorkbookUpdater
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.{MetadataExcelDocument, SingleSheetDocumentMetadataInfo}
import report_main.reportHandler.types.parsedExcel.metadataExcel.metadata.DocumentMetadata
import report_main.reportHandler.utils.DocumentId
import zio.{Has, URIO}
import zio.logging.Logging
import zio.magic.ZioProvideMagicOps

case class DocumentMetadataMerger(documentId2Metadata: Map[DocumentId, List[SingleSheetDocumentMetadataInfo]], path2Id: Map[String, DocumentId]) {
    import report_main.reportHandler.excel.merger.MergerUtils._

    def merge: URIO[Logging with Has[MetadataWorkbookUpdater], Map[DocumentId, MetadataExcelDocument]] = {
        (URIO.collectAllSuccesses(documentId2Metadata.map { case (documentId, metadataExcelDocument) =>
            for {
                maybeMetadataExternalUrl <- mergeMetadata(metadataExcelDocument.flatMap(_.metadataExternalUrl))
                maybeMetadataPublicationDate <- mergeMetadata(metadataExcelDocument.flatMap(_.metadataPublicationDate))
                maybeMetadataPublicationAuthor <- mergeMetadata(metadataExcelDocument.flatMap(_.metadataPublicationAuthor))
                maybeMetadataDescription <- mergeMetadata(metadataExcelDocument.flatMap(_.metadataDescription))
                documentMetadata = DocumentMetadata(maybeMetadataExternalUrl = maybeMetadataExternalUrl,
                    maybeMetadataPublicationDate = maybeMetadataPublicationDate,
                    maybeMetadataPublicationAuthor = maybeMetadataPublicationAuthor,
                    maybeMetadataDescription = maybeMetadataDescription)
            } yield (documentId -> MetadataExcelDocument(
                documentId = documentId,
                documentPaths = metadataExcelDocument.map(_.documentPath).distinct,
                documentPathCells = metadataExcelDocument.flatMap(_.documentPathCells),
                metadata = documentMetadata))
        }).map(_.toMap))
            .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
    }
}
