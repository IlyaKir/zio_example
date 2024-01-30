package report_main.reportHandler.types.columnHeaders.report

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.types.columnHeaders.report.ReportColumnHeaderType.ReportColumnHeaderType

case class MetadataIsMain(objectColumnId: Int, cell: XSSFCell) extends ReportColumnHeader {
    val columnType: ReportColumnHeaderType = ReportColumnHeaderType.metadataIsMain
}
