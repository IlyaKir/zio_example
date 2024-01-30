package report_main.reportHandler.types.columnHeaders.metadata

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.types.columnHeaders.metadata.MetadataColumnHeaderType.MetadataColumnHeaderType

trait MetadataColumnHeader {
    val columnType: MetadataColumnHeaderType
    val cell: XSSFCell
}
