package report_main.reportHandler.fake

import report_main.reportHandler.layers.ReportDocumentUploader
import common.types.ID
import zio.{Function0ToLayerSyntax, Has, UIO, ULayer}

import java.io.InputStream
import java.util.UUID

case class ReportDocumentUploaderFakeLive() extends ReportDocumentUploader {
    override def uploadSingleDocument(path: String,
                                      documentInputStream: InputStream,
                                      userId: String,
                                      topic: String,
                                      taskId: ID,
                                      accessLevel: Option[ID]): UIO[(String, UUID)] =
        UIO.succeed(path -> UUID.randomUUID())
}

object ReportDocumentUploaderFakeLive {
    val layer: ULayer[Has[ReportDocumentUploader]] =
        Function0ToLayerSyntax(() => ReportDocumentUploaderFakeLive()).toLayer
}
