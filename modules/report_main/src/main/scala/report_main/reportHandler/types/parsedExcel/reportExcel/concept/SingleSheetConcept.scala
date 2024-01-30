package report_main.reportHandler.types.parsedExcel.reportExcel.concept

import report_main.generated.kb_api.graphql.DateTimeValueInput
import Concept.ConceptIdentifier
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.metadata.SingleCellMetadata
import report_main.reportHandler.types.parsedExcel.reportExcel.document.SingleCellDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.property.SingleSheetProperty

case class SingleSheetConcept(conceptIdentifier: ConceptIdentifier,
                              metadataNameCells: List[Cell],
                              linkCells: List[Cell],
                              metadataNotes: List[SingleCellMetadata[String]],
                              metadataFrom: List[SingleCellMetadata[DateTimeValueInput]],
                              metadataTo: List[SingleCellMetadata[DateTimeValueInput]],
                              avatars: List[SingleCellDocument],
                              documents: List[SingleCellDocument],
                              properties: List[SingleSheetProperty])
