package report_main.reportHandler.types.parsedExcel.metadataExcel.document

import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.metadata.SingleCellMetadata

case class SingleSheetDocumentMetadataInfo(documentPath: String,
                                           documentPathCells: List[Cell],
                                           metadataExternalUrl: List[SingleCellMetadata[String]],
                                           metadataPublicationDate: List[SingleCellMetadata[DateTimeValueInput]],
                                           metadataPublicationAuthor: List[SingleCellMetadata[String]],
                                           metadataDescription: List[SingleCellMetadata[String]])
