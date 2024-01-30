package report_main.reportHandler.types.parsedExcel.metadataExcel.metadata

import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.metadata.Metadata

case class DocumentMetadata(maybeMetadataExternalUrl: Option[Metadata[String]],
                            maybeMetadataPublicationDate: Option[Metadata[DateTimeValueInput]],
                            maybeMetadataPublicationAuthor: Option[Metadata[String]],
                            maybeMetadataDescription: Option[Metadata[String]]) {
    lazy val cells: List[Cell] = List(maybeMetadataExternalUrl, maybeMetadataPublicationDate, maybeMetadataPublicationAuthor, maybeMetadataDescription)
        .flatMap(_.map(_.cells)).flatten
    val noCommentCells: List[Cell] = cells.filter(_.maybeParsedComment.isEmpty)
    val needToUpdate: Boolean = noCommentCells.nonEmpty
}
