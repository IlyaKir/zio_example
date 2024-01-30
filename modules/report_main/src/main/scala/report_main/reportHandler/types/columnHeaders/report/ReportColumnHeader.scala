package report_main.reportHandler.types.columnHeaders.report

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.types.columnHeaders.report.ReportColumnHeaderType.ReportColumnHeaderType

trait ReportColumnHeader {
    val columnType: ReportColumnHeaderType
    val cell: XSSFCell
}
