package report_main.reportHandler.types.parsedExcel.reportExcel.metadata

import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.metadata.Metadata

trait CommonMetadata {
    val maybeMetadataNotes: Option[Metadata[String]]
    val maybeMetadataFrom: Option[Metadata[DateTimeValueInput]]
    val maybeMetadataTo: Option[Metadata[DateTimeValueInput]]

    val cells: List[Cell]
}
