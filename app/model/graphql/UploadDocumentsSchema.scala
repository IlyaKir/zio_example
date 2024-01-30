package model.graphql

import caliban.schema.Annotations.GQLDescription
import caliban.uploads._
import common.types.ID
import model.graphql.types.input.task.{AddReportFromFileTaskInput, AddReportTaskInput}
import report_main.reportHandler.layers.ReportDocumentUploader
import resolvers.UploadDocumentsResolver
import zio.blocking.Blocking
import zio.clock.Clock
import zio.logging.Logging
import zio.random.Random
import zio.{Has, UIO, ZIO}

case class UploadDocumentsQueries(test: UIO[String])

case class UploadDocumentsMutations(
                                       uploadReport: AddReportTaskInput =>
                                           ZIO[Blocking with Clock with Random with Uploads with Has[ReportDocumentUploader] with Logging, Throwable, Seq[ID]],
                                       uploadReportFromFile: AddReportFromFileTaskInput =>
                                           ZIO[Blocking with Clock with Random with Has[ReportDocumentUploader] with Logging, Throwable, ID]
                                   )

object UploadDocumentsSchema {
    val uploadDocumentsQueries: UploadDocumentsQueries = UploadDocumentsQueries(test = ZIO.succeed("Hello, world!"))
    val uploadDocumentsMutations: UploadDocumentsMutations = UploadDocumentsMutations(
        uploadReport = input =>
            UploadDocumentsResolver.uploadDocuments(input),
        uploadReportFromFile = input =>
            UploadDocumentsResolver.uploadReportFromFile(input)
    )
}
