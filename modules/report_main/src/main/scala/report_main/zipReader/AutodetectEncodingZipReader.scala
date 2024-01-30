package report_main.zipReader

import org.apache.commons.io.IOUtils
import org.mozilla.universalchardet.UniversalDetector
import report_main.utils.ZipReaderUtils.{ZipFileWithEntries, getZipEntriesNames}
import zio.logging.Logging
import zio.{RManaged, Task, ZIO, ZManaged}

import java.nio.charset.Charset
import java.util.zip.ZipFile
import scala.collection.mutable
import scala.jdk.CollectionConverters._

case class AutodetectEncodingZipReader(fileName: String) {
    private val defaultEncodings = Seq("CP437", "UTF8", "UTF16", "UTF32")

    def readZip: RManaged[Logging, ZipFileWithEntries] = {
        val zipFileWithEntries = detectEncoding(defaultEncodings).flatMap { encoding =>
            ZIO.effect(new ZipFile(fileName, Charset.forName(encoding)))
        }.map(getZipFileWithEntries)

        ZManaged.fromAutoCloseable(zipFileWithEntries)
    }

    private def getZipFileWithEntries(zipFile: ZipFile): ZipFileWithEntries =
        ZipFileWithEntries(zipFile, zipFile.entries().asScala.toList)

    private def detectEncoding(encodings: Seq[String]): Task[String] = {
        if (encodings.isEmpty) ZIO.fail(new Throwable())
        else {
            ZManaged
                .fromAutoCloseable(ZIO.effect(new ZipFile(fileName, Charset.forName(encodings.head))))
                .use { zipFile =>
                    val entryNames = getZipEntriesNames(getZipFileWithEntries(zipFile).zipEntries)
                    val allZipFileNames = new mutable.StringBuilder("")
                    entryNames.foreach { name => allZipFileNames ++= s"$name\n" }
                    ZManaged.fromAutoCloseable(ZIO.effect(IOUtils.toInputStream(allZipFileNames, encodings.head)))
                        .flatMap { allZipFileNamesInputStream =>
                            val charset = UniversalDetector.detectCharset(allZipFileNamesInputStream)
                            ZManaged.fromEffect {
                                ZIO.fromOption(Option(charset)).orElseFail(new Exception("Undetermined"))
                            }
                        }.useNow
                }
                .orElse(detectEncoding(encodings.drop(1)))
        }
    }
}
