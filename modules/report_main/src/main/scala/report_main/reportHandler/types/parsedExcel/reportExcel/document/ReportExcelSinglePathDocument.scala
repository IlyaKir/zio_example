package report_main.reportHandler.types.parsedExcel.reportExcel.document

import report_main.reportHandler.excel.Cell
import common.types.ID

case class ReportExcelSinglePathDocument(documentPath: String,
                                         documentPathCells: List[Cell]) {
    lazy val kbId: Option[ID] = documentPathCells.flatMap(_.maybeParsedComment).headOption
}

object ReportExcelSinglePathDocument {
    def apply(input: (String, List[Cell])): ReportExcelSinglePathDocument = ReportExcelSinglePathDocument(input._1, input._2)
}
