package report_main.reportHandler.mainFilesGetter.docx

import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import zio.{RIO, ZIO}
import zio.logging._

import java.util.zip.ZipEntry

object DocxZipEntryGetter {
    import report_main.reportHandler.regex.ZipEntryRegex.Root
    import report_main.reportHandler.regex.ZipEntryRegex.Docx
    import report_main.reportHandler.mainFilesGetter.utils.MainFilesGetterUtils.getPath
    import report_main.reportHandler.sideEffects.MainFilesGetterSE

    private val docxString = "*.docx"

    def getDocxZipEntry(reportPath: String, zipFileWithEntries: ZipFileWithEntries): RIO[Logging, ZipEntry] = {
        lazy val getRootPath: String => RIO[Logging, String] = { reportPath =>
            for {
                _ <- MainFilesGetterSE.gettingPath(docxString)
                rootPath <- ZIO.fromOption(Root.tryMatch(reportPath))
                    .tapError(_ => MainFilesGetterSE.unableGetRootPath)
                    .orElseFail(new Throwable)
            } yield rootPath
        }

        lazy val getDocxZipEntry: String => RIO[Logging, ZipEntry] = { rootPath =>
            val allMatchedPaths: List[String] = zipFileWithEntries.zipEntryNames.flatMap(zipEntryName => Docx.tryMatch(rootPath, zipEntryName))
            getPath(allMatchedPaths, docxString).tapError(_ => MainFilesGetterSE.mainFileNotFound(docxString))
                .map(zipFileWithEntries.zipEntryName2ZipEntry)
        }

        for {
            rootPath <- getRootPath(reportPath)
            docxZipEntry <- getDocxZipEntry(rootPath)
        } yield docxZipEntry
    }
}
