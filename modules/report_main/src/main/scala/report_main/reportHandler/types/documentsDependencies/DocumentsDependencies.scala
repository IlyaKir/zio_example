package report_main.reportHandler.types.documentsDependencies

import report_main.reportHandler.utils.DocumentId

case class DocumentsDependencies(documentPath2Id: Map[String, DocumentId],
                                 reportDocumentsDependencies: ReportDocumentsDependencies,
                                 metadataDocumentsDependencies: MetadataDocumentsDependencies)
