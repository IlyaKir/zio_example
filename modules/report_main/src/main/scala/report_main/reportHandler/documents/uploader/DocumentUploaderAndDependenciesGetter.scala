package report_main.reportHandler.documents.uploader

import report_main.reportHandler.excel.merger.DocumentMetadataMerger
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportDocumentUploader, ReportWorkbookUpdater}
import report_main.reportHandler.types.documentsDependencies.{DocumentPathDependencies, DocumentsDependencies, MetadataDocumentsDependencies}
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.SingleSheetDocumentMetadataInfo
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.utils.DocumentId
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import common.types.ID
import zio.logging.Logging
import zio.magic.ZioProvideMagicOps
import zio.{Has, URIO, ZIO, ZManaged}

import java.io.ByteArrayInputStream
import java.util.zip.ZipEntry

case class DocumentUploaderAndDependenciesGetter(zipFileWithEntries: ZipFileWithEntries,
                                                 documentsMetadataInfo: List[SingleSheetDocumentMetadataInfo],
                                                 concepts: List[Concept],
                                                 links: List[Link],
                                                 userId: String,
                                                 topic: String,
                                                 taskId: ID,
                                                 maybeAccessLevelId: Option[ID]) {

    import report_main.reportHandler.documents.dependenciesGetter.DocumentIdDependenciesGetter.getReportDependencies
    import report_main.reportHandler.documents.dependenciesGetter.PathsDependenciesGetter.getReportDocumentPathsDependencies
    import report_main.reportHandler.sideEffects.{DocumentUploaderSE => SE}

    def uploadAndGetDependencies: URIO[Logging with Has[ReportDocumentUploader] with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater], DocumentsDependencies] = {
        for {
            reportExcelDocumentDependencies <- getReportExcelDocDependencies
            path2Id <- upload(reportExcelDocumentDependencies)

            id2SheetsDocumentsMetadata <- getId2SheetsDocMetadata(documentsMetadataInfo, path2Id)
            documentId2Metadata <- DocumentMetadataMerger(id2SheetsDocumentsMetadata, path2Id).merge

            reportDependencies <- getReportDependencies(reportExcelDocumentDependencies.pathDependencies, path2Id)
            metadataDependencies = MetadataDocumentsDependencies(documentId2Metadata)
        } yield DocumentsDependencies(path2Id, reportDependencies, metadataDependencies)
    }

    private def getId2SheetsDocMetadata(documents: List[SingleSheetDocumentMetadataInfo],
                                        path2Id: Map[String, DocumentId]): URIO[Logging with Has[MetadataWorkbookUpdater], Map[DocumentId, List[SingleSheetDocumentMetadataInfo]]] = {
        val (id2DocsMetadataInfo, docsWithoutId) = {
            val (documentsWithId, documentsWithoutUUID) = documents.map(document => document.documentPath -> document)
                .map { case (path, document) => path2Id.get(path) -> document }
                .partition(_._1.isDefined)
            (documentsWithId.map(row => row._1.get -> row._2).groupBy(_._1).view.mapValues(_.map(_._2)).toMap,
                documentsWithoutUUID.map(_._2))
        }

        val path2Cells = docsWithoutId.groupBy(_.documentPath).view.mapValues(_.flatMap(_.documentPathCells.map(_.xssfCell))).toMap
        (SE.incorrectMetadataExcelDocumentPaths(path2Cells).as(id2DocsMetadataInfo))
            .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
    }

    private case class ReportExcelDocumentDependencies(pathDependencies: DocumentPathDependencies, excelDocumentPath2ZipEntry: Map[String, ZipEntry])

    private def getReportExcelDocDependencies: URIO[Logging with Has[ReportWorkbookUpdater], ReportExcelDocumentDependencies] = {
        for {
            reportDocumentPathDependencies <- getReportDocumentPathsDependencies(concepts, links)

            (correctExcelPaths, incorrectExcelPaths) = {
                val allExcelDocumentPaths = reportDocumentPathDependencies.documentPath2Documents.keys.toSet
                val zipEntryDocumentPaths = allExcelDocumentPaths
                    .flatMap { documentPath => zipFileWithEntries.zipEntryName2ZipEntry.find(_._1 == documentPath) }.map(_._1)
                allExcelDocumentPaths.partition(zipEntryDocumentPaths.contains)
            }
            _ <- HandleIncorrectPaths(reportDocumentPathDependencies, incorrectExcelPaths)
            excelDocumentPath2ZipEntry = correctExcelPaths.flatMap { documentPath =>
                zipFileWithEntries.zipEntryName2ZipEntry.find(_._1 == documentPath)
            }.toMap
        } yield ReportExcelDocumentDependencies(reportDocumentPathDependencies, excelDocumentPath2ZipEntry)
    }

    private def upload(reportExcelDocumentDependencies: ReportExcelDocumentDependencies): URIO[Has[ReportDocumentUploader] with Logging, Map[String, DocumentId]] = {
        for {
            _ <- SE.uploadingDocuments
            path2Id <- ZIO.collectAllSuccesses(reportExcelDocumentDependencies.excelDocumentPath2ZipEntry.map { case (path, zipEntry) =>
                reportExcelDocumentDependencies.pathDependencies.tryGetKBId(path) match {
                    case Some(kbId) => URIO.succeed(path -> DocumentId(Left(kbId)))
                    case None => ZManaged.fromAutoCloseable(ZIO.effect(zipFileWithEntries.zipFile.getInputStream(zipEntry)))
                        .use { documentInputStream =>
                            val array = documentInputStream.readAllBytes()
                            ReportDocumentUploader.uploadSingleDocument(path, new ByteArrayInputStream(array), userId, topic, taskId, maybeAccessLevelId)
                        }.map { case (path, uuid) => path -> DocumentId(Right(uuid)) }
                }
            }).map(_.toMap)
        } yield path2Id
    }

    private def HandleIncorrectPaths(documentPathDependencies: DocumentPathDependencies, incorrectExcelPaths: Set[String]): URIO[Logging with Has[ReportWorkbookUpdater], Unit] = {
        val incorrectExcelPathsWithCells = documentPathDependencies.documentPath2Documents
            .filter { case (documentPath, _) => incorrectExcelPaths.contains(documentPath) }
            .map { case (documentPath, document) =>
                val cells = document.flatMap(_.documentPathCells.map(_.xssfCell))
                (documentPath, cells)
            }
        SE.incorrectReportExcelDocumentPaths(incorrectExcelPathsWithCells)
            .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
    }
}
