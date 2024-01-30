package report_main.reportHandler.types.parsedExcel.reportExcel.property

import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.types.parsedExcel.common.metadata.SingleCellMetadata
import report_main.reportHandler.types.parsedExcel.reportExcel.document.SingleCellDocument

case class PropertyEnrichment(metadataNoteCells: List[SingleCellMetadata[String]],
                              metadataFromCells: List[SingleCellMetadata[DateTimeValueInput]],
                              metadataToCells: List[SingleCellMetadata[DateTimeValueInput]],
                              metadataIsMainCells: List[SingleCellMetadata[Boolean]],
                              documents: List[SingleCellDocument])
