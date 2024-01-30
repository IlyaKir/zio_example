package report_main.reportHandler.types.parsedExcel.reportExcel.link

import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.excel.Cell
import Link.LinkIdentifier
import Link.LinkIdentifier
import report_main.reportHandler.types.parsedExcel.common.metadata.SingleCellMetadata
import report_main.reportHandler.types.parsedExcel.reportExcel.document.SingleCellDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.property.SingleSheetProperty

case class SingleSheetLink(linkIdentifier: LinkIdentifier,
                           linkCells: List[Cell],
                           metadataNotes: List[SingleCellMetadata[String]],
                           metadataFrom: List[SingleCellMetadata[DateTimeValueInput]],
                           metadataTo: List[SingleCellMetadata[DateTimeValueInput]],
                           documents: List[SingleCellDocument],
                           properties: List[SingleSheetProperty])
