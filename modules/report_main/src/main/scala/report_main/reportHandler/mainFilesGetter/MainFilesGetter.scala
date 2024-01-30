package report_main.reportHandler.mainFilesGetter

import report_main.reportHandler.mainFilesGetter.docx.DocxZipEntryGetter
import report_main.reportHandler.mainFilesGetter.workbook.{MetadataWorkbookGetter, ReportWorkbookGetter}
import report_main.reportHandler.types.mainFiles.MainFiles
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import zio.RIO
import zio.logging._

object MainFilesGetter {
    def getMainFiles(zipFileWithEntries: ZipFileWithEntries): RIO[Logging, MainFiles] = {
        for {
            reportWorkbook <- ReportWorkbookGetter.getReportWorkbook(zipFileWithEntries)
            maybeMetadataWorkbook <- MetadataWorkbookGetter.getMetadataWorkbook(zipFileWithEntries).option
            docxZipEntry <- DocxZipEntryGetter.getDocxZipEntry(reportWorkbook.path, zipFileWithEntries)
        } yield MainFiles(reportWorkbook, maybeMetadataWorkbook, docxZipEntry)
    }
}
