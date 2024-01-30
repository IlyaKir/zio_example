package report_main.reportHandler.documents.uploader

import report_main.reportHandler.layers.ReportDocumentUploader
import report_main.reportHandler.types.mainFiles.MainFiles
import report_main.reportHandler.utils.StringNormalizer
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import common.types.ID
import zio.{Has, RIO, ZIO, ZManaged}

import java.util.UUID

object DocxUploader {
    def upload(zipFileWithEntries: ZipFileWithEntries,
               mainFiles: MainFiles,
               userId: String,
               topic: String,
               taskId: ID,
               maybeAccessLevelId: Option[ID]): RIO[Has[ReportDocumentUploader], UUID] = {
        ZManaged.fromAutoCloseable(ZIO.effect(zipFileWithEntries.zipFile.getInputStream(mainFiles.docxZipEntry)))
            .use { docxInputStream =>
                ReportDocumentUploader.uploadSingleDocument(StringNormalizer.normalize(mainFiles.docxZipEntry.getName),
                    docxInputStream, userId, topic, taskId, maybeAccessLevelId).map(_._2)
            }
    }
}
