package report_main.reportHandler.types.parsedExcel.reportExcel.metadata

import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.metadata.Metadata

case class PropertyMetadata(maybeMetadataNotes: Option[Metadata[String]],
                            maybeMetadataFrom: Option[Metadata[DateTimeValueInput]],
                            maybeMetadataTo: Option[Metadata[DateTimeValueInput]],
                            maybeMetadataIsMain: Option[Metadata[Boolean]]) extends CommonMetadata {
    val cells: List[Cell] = List(maybeMetadataNotes, maybeMetadataFrom, maybeMetadataTo, maybeMetadataIsMain)
        .flatMap(_.map(_.cells)).flatten
    val noCommentCells: List[Cell] = cells.filter(_.maybeParsedComment.isEmpty)
    val needToUpdate: Boolean = noCommentCells.nonEmpty
}
