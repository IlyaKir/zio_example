package report_main.reportHandler.types.parsedExcel.metadataExcel.document

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.ExcelDocument
import report_main.reportHandler.types.parsedExcel.metadataExcel.metadata.DocumentMetadata
import report_main.reportHandler.utils.DocumentId
import common.types.ID

case class MetadataExcelDocument(documentId: DocumentId,
                                 documentPaths: Seq[String],
                                 documentPathCells: Seq[Cell],
                                 metadata: DocumentMetadata) extends ExcelDocument {
    def tryGetKBId: Seq[ID] = documentPathCells.flatMap(_.maybeParsedComment)

    val noCommentDocumentPathCells: Seq[Cell] = documentPathCells.filter(_.maybeParsedComment.isEmpty)
}
