package report_main.reportHandler.types.parsedExcel.reportExcel.headers

import org.apache.poi.xssf.usermodel.XSSFSheet
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.MetadataSheetHeaders.MetadataColumnIds

case class MetadataSheetHeaders(sheet: XSSFSheet,
                                documentPathColumnId: Int,
                                metadataColumnIds: MetadataColumnIds) extends SheetHeaders

object MetadataSheetHeaders {
    case class MetadataColumnIds(metadataExternalUrl: Option[Int],
                                 metadataPublicationDate: Option[Int],
                                 metadataPublicationAuthor: Option[Int],
                                 metadataDescription: Option[Int])
}
