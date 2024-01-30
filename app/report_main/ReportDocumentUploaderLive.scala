package report_main

import resolvers.UploadDocumentsResolver
import report_main.reportHandler.layers.ReportDocumentUploader
import common.types.{ID, MessagePriority}
import zio.{Function0ToLayerSyntax, Has, UIO, ULayer}

import java.io.InputStream
import java.util.UUID

case class ReportDocumentUploaderLive() extends ReportDocumentUploader {
    override def uploadSingleDocument(path: String,
                                      documentInputStream: InputStream,
                                      userId: String,
                                      topic: String,
                                      taskId: ID,
                                      accessLevel: Option[ID]): UIO[(String, UUID)] = {
        val uuid = UploadDocumentsResolver.uploadByteArrayDocument(file = documentInputStream.readAllBytes(),
            fileName = path.split('/').last,
            userId = userId,
            topic = topic,
            messagePriority = MessagePriority.Normal,
            taskId = taskId.toLong,
            accessLevel = accessLevel,
            trustLevel = None)
        UIO.succeed(path -> UUID.fromString(uuid))
    }
}

object ReportDocumentUploaderLive {
    val layer: ULayer[Has[ReportDocumentUploader]] =
        Function0ToLayerSyntax(() => ReportDocumentUploaderLive()).toLayer
}
