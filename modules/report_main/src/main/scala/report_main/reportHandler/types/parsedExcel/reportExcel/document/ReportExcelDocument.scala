package report_main.reportHandler.types.parsedExcel.reportExcel.document

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.common.ExcelDocument
import report_main.reportHandler.utils.DocumentId

case class ReportExcelDocument(documentId: DocumentId,
                               documentPaths: Seq[String],
                               documentPathCells: Seq[Cell]) extends ExcelDocument
