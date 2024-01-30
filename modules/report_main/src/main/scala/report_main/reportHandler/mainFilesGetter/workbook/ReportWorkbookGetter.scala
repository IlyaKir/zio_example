package report_main.reportHandler.mainFilesGetter.workbook

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import report_main.reportHandler.types.mainFiles.ReportWorkbook
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import zio.RIO
import zio.logging._

object ReportWorkbookGetter {
    import report_main.reportHandler.regex.ZipEntryRegex.ReportExcel.tryMatch
    import report_main.reportHandler.mainFilesGetter.utils.MainFilesGetterUtils.{getPath, getWorkbook, extractFileNameFromPath}
    private val reportString: String = "report *.xlsx"

    def getReportWorkbook(zipFileWithEntries: ZipFileWithEntries): RIO[Logging, ReportWorkbook] = {
        val getWorkbookPath: RIO[Logging, String] = {
            val allMatchedPaths: List[String] = zipFileWithEntries.zipEntryNames.flatMap(tryMatch)
            getPath(allMatchedPaths, reportString)
        }
        val getReportWorkbook: String => RIO[Logging, XSSFWorkbook] = { workbookPath =>
            getWorkbook(zipFileWithEntries, workbookPath, reportString)
        }

        for {
            reportPath <- getWorkbookPath
            reportWorkbook <- getReportWorkbook(reportPath)
        } yield ReportWorkbook(reportWorkbook, reportPath, extractFileNameFromPath(reportPath))
    }
}
