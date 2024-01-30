package report_main.reportHandler.actors.state

import report_main.reportHandler.types.parsedExcel.metadataExcel.document.MetadataExcelDocument
import report_main.reportHandler.utils.DocumentId

case class DocumentMetadataActorState(documentId2Document: Map[DocumentId, MetadataExcelDocument])
