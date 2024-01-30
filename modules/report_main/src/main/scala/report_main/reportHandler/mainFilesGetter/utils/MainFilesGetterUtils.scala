package report_main.reportHandler.mainFilesGetter.utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import zio.logging._
import zio.{RIO, Task, ZIO}

import java.io.InputStream
import scala.util.{Failure, Success, Try}

object MainFilesGetterUtils {
    import report_main.reportHandler.sideEffects.{MainFilesGetterSE => SE}

    def getPath(allMatchedPaths: List[String], mainFileType: String): RIO[Logging, String] = {
        lazy val getPath = tryGetShortestPath(allMatchedPaths) match {
            case Some(reportPath) => RIO.succeed(reportPath)
            case None => SE.mainFileNotFound(mainFileType) *> ZIO.fail(new Throwable)
        }
        SE.gettingPath(mainFileType) *> getPath
    }

    def getWorkbook(zipFileWithEntries: ZipFileWithEntries, workbookPath: String, workbookTypeName: String): RIO[Logging, XSSFWorkbook] = {
        val zipFile = zipFileWithEntries.zipEntryName2ZipEntry(workbookPath)

        val getInputStream = Try(zipFileWithEntries.zipFile.getInputStream(zipFile)) match {
            case Success(inputStream) => Task.succeed(inputStream)
            case Failure(exception) => SE.unableGetInputStream(workbookTypeName) *> Task.fail(exception)
        }
        val getWorkbook: InputStream => RIO[Logging, XSSFWorkbook] = { reportInputStream =>
            Try(new XSSFWorkbook(reportInputStream)) match {
                case Success(workbook) => Task.succeed(workbook)
                case Failure(exception) => SE.unableOpenFile(workbookTypeName) *> Task.fail(exception)
            }
        }

        SE.gettingWorkbook(workbookTypeName) *>
            (for {
                inputStream <- getInputStream
                workbook <- getWorkbook(inputStream)
            } yield workbook)
    }

    private def tryGetShortestPath(paths: List[String]): Option[String] = paths.sortBy(_.split('/').length).headOption

    def extractFileNameFromPath(path: String): String = path.split('/').last
}
