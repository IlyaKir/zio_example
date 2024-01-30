package model.graphql

import caliban.uploads.Uploads
import report_main.reportHandler.layers.ReportDocumentUploader
import zio.logging.Logging
import zio.{Has, ZEnv}

object Dependencies {
    type Dependencies = Uploads with ZEnv with Has[ReportDocumentUploader] with Logging
}
