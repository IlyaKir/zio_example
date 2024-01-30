package report_main.reportHandler.types.columnHeaders.report

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.types.columnHeaders.report.ReportColumnHeaderType.ReportColumnHeaderType

case class LinkProperty(propertyTypeName: String, linkColumnId: Int, cell: XSSFCell) extends Property {
    val columnType: ReportColumnHeaderType = ReportColumnHeaderType.linkProperty
}
