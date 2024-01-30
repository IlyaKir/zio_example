package report_main.reportHandler.types.parsedExcel.common

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.utils.DocumentId

trait ExcelDocument {
    val documentId: DocumentId
    val documentPaths: Seq[String]
    val documentPathCells: Seq[Cell]
}
