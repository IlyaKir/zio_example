package report_main.utils

import report_main.reportHandler.utils.StringNormalizer

import java.util.zip.{ZipEntry, ZipFile}
import scala.annotation.tailrec

object ZipReaderUtils {
    @tailrec
    def getZipEntriesNames(zipEntries: List[ZipEntry], zipEntryNames: List[String] = List.empty): List[String] = {
        zipEntries.headOption match {
            case Some(zipEntry) => getZipEntriesNames(zipEntries.drop(1), zipEntryNames :+ StringNormalizer.normalize(zipEntry.getName))
            case None => zipEntryNames
        }
    }

    case class ZipFileWithEntries(zipFile: ZipFile, zipEntries: List[ZipEntry]) extends AutoCloseable {
        override def close(): Unit = zipFile.close()

        val fileNameWithoutExt: String = {
            val splitted = zipFile.getName.split("\\.").toList
            (if (splitted.length > 1) splitted.dropRight(1) else splitted).mkString(".")
        }
        lazy val zipEntryName2ZipEntry: Map[String, ZipEntry] = zipEntries.map { zipEntry =>
            (StringNormalizer.normalize(zipEntry.getName), zipEntry)
        }.toMap

        lazy val zipEntryNames: List[String] = zipEntryName2ZipEntry.keys.toList
    }
}
