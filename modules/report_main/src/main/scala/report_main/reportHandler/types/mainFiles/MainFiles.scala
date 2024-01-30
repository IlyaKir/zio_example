package report_main.reportHandler.types.mainFiles

import java.util.zip.ZipEntry

case class MainFiles(reportWorkbook: ReportWorkbook,
                     maybeMetadataWorkbook: Option[MetadataWorkbook],
                     docxZipEntry: ZipEntry)
