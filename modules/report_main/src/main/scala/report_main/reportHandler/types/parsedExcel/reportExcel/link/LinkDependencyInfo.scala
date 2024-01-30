package report_main.reportHandler.types.parsedExcel.reportExcel.link

import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelSinglePathDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property

case class LinkDependencyInfo(properties: List[Property],
                              documents: List[ReportExcelSinglePathDocument])
