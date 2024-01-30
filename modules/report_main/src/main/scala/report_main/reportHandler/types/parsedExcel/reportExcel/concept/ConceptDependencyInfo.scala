package report_main.reportHandler.types.parsedExcel.reportExcel.concept

import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelSinglePathDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property

case class ConceptDependencyInfo(maybeAvatar: Option[ReportExcelSinglePathDocument],
                                 documents: List[ReportExcelSinglePathDocument],
                                 properties: List[Property])
