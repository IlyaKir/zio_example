package report_main.reportHandler.mainFilesGetter.workbook

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import report_main.reportHandler.types.mainFiles.MetadataWorkbook
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import zio._
import zio.logging._

object MetadataWorkbookGetter {
    import report_main.reportHandler.regex.ZipEntryRegex.MetadataExcel.tryMatch
    import report_main.reportHandler.mainFilesGetter.utils.MainFilesGetterUtils.{getPath, getWorkbook, extractFileNameFromPath}
    private val metadataString: String = "metadata *.xlsx"

    def getMetadataWorkbook(zipFileWithEntries: ZipFileWithEntries): RIO[Logging, MetadataWorkbook] = {
        val getWorkbookPath: RIO[Logging, String] = {
            val allMatchedPaths: List[String] = zipFileWithEntries.zipEntryNames.flatMap(tryMatch)
            getPath(allMatchedPaths, metadataString)
        }
        val getMetadataWorkbook: String => RIO[Logging, XSSFWorkbook] = { workbookPath =>
            getWorkbook(zipFileWithEntries, workbookPath, metadataString)
        }

        for {
            metadataPath <- getWorkbookPath
            metadataWorkbook <- getMetadataWorkbook(metadataPath)
        } yield MetadataWorkbook(metadataWorkbook, extractFileNameFromPath(metadataPath))
    }
}
