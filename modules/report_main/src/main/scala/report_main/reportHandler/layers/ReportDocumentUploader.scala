package report_main.reportHandler.layers

import common.types.ID
import zio.{Has, UIO, URIO, ZIO}

import java.io.InputStream
import java.util.UUID

trait ReportDocumentUploader {
    def uploadSingleDocument(path: String,
                             documentInputStream: InputStream,
                             userId: String,
                             topic: String,
                             taskId: ID,
                             accessLevel: Option[ID]): UIO[(String, UUID)]
}

object ReportDocumentUploader {
    def uploadSingleDocument(path: String,
                             documentInputStream: InputStream,
                             userId: String,
                             topic: String,
                             taskId: ID,
                             accessLevel: Option[ID]): URIO[Has[ReportDocumentUploader], (String, UUID)] = {
        ZIO.serviceWith[ReportDocumentUploader](_.uploadSingleDocument(path, documentInputStream, userId, topic, taskId, accessLevel))
    }
}
