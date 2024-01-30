package report_main.reportHandler.types.documentsDependencies

import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelSinglePathDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import common.types.ID

case class DocumentPathDependencies(avatarPath2Concepts: Map[String, List[Concept]],
                                    documentPath2Concepts: Map[String, List[Concept]],
                                    documentPath2ConceptProperties: Map[String, List[Property]],
                                    documentPath2Links: Map[String, List[Link]],
                                    documentPath2LinkProperties: Map[String, List[Property]],
                                    documentPath2Documents: Map[String, List[ReportExcelSinglePathDocument]]) {
    def tryGetKBId(documentPath: String): Option[ID] = {
        documentPath2Documents.get(documentPath).flatMap(_.map(_.kbId).find(_.isDefined).flatten)
    }
}
