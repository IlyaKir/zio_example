package report_main.reportHandler.types.columnHeaders.metadata

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.types.columnHeaders.metadata.MetadataColumnHeaderType.MetadataColumnHeaderType

case class MetadataPublicationDate(objectColumnId: Int, cell: XSSFCell) extends MetadataColumnHeader {
    val columnType: MetadataColumnHeaderType = MetadataColumnHeaderType.metadataPublicationDate
}
