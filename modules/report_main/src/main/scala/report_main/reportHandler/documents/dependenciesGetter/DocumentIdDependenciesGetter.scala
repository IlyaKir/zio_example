package report_main.reportHandler.documents.dependenciesGetter

import report_main.reportHandler.types.documentsDependencies.{DocumentPathDependencies, ReportDocumentsDependencies}
import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelDocument
import report_main.reportHandler.utils.DocumentId
import zio.URIO
import zio.logging.Logging

object DocumentIdDependenciesGetter {

    import report_main.reportHandler.sideEffects.{DocumentUploaderSE => SE}

    def getReportDependencies(reportDocumentPathDependencies: DocumentPathDependencies,
                              path2Id: Map[String, DocumentId]): URIO[Logging, ReportDocumentsDependencies] = {
        val avatarId2Concepts = reportDocumentPathDependencies.avatarPath2Concepts.toList
            .map { case (path, concept) => path2Id.find { case (fileSystemPath, _) => path == fileSystemPath }
                .map { case (_, documentId) => documentId -> concept }
            }
            .collect { case Some(row) => row }
            .groupBy { case (documentId, _) => documentId }
            .view
            .mapValues(_.flatMap(_._2))
            .toMap

        val documentId2ReportExcelDocument = path2Id
            .groupBy { case (_, documentId) => documentId }
            .view
            .mapValues(_.keys.toList)
            .toMap
            .map { case (documentId, paths) => documentId -> paths.flatMap(reportDocumentPathDependencies.documentPath2Documents) }
            .map { case (documentId, singlePathDocuments) =>
                documentId -> ReportExcelDocument(documentId, singlePathDocuments.map(_.documentPath).distinct, singlePathDocuments.flatMap(_.documentPathCells))
            }

        val documentId2Concepts = reportDocumentPathDependencies.documentPath2Concepts.toList
            .collect { case (path, concepts) if path2Id.contains(path) => path2Id(path) -> concepts }
            .groupBy { case (documentId, _) => documentId }
            .view.mapValues(_.flatMap { case (_, concepts) => concepts })
            .toMap
        val documentId2ConceptProperties = reportDocumentPathDependencies.documentPath2ConceptProperties.toList
            .collect { case (path, properties) if path2Id.contains(path) => path2Id(path) -> properties }
            .groupBy { case (documentId, _) => documentId }
            .view.mapValues(_.flatMap { case (_, properties) => properties })
            .toMap
        val documentId2Links = reportDocumentPathDependencies.documentPath2Links.toList
            .collect { case (path, links) if path2Id.contains(path) => path2Id(path) -> links }
            .groupBy { case (documentId, _) => documentId }
            .view.mapValues(_.flatMap { case (_, links) => links })
            .toMap
        val documentId2LinkProperties = reportDocumentPathDependencies.documentPath2LinkProperties.toList
            .collect { case (path, linkProperties) if path2Id.contains(path) => path2Id(path) -> linkProperties }
            .groupBy { case (documentId, _) => documentId }
            .view.mapValues(_.flatMap { case (_, properties) => properties })
            .toMap

        SE.gettingDocumentIdDependencies.as {
            ReportDocumentsDependencies(avatarId2Concepts = avatarId2Concepts,
                documentId2Concepts = documentId2Concepts,
                documentId2ConceptProperties = documentId2ConceptProperties,
                documentId2Links = documentId2Links,
                documentId2LinkProperties = documentId2LinkProperties,
                documentId2Documents = documentId2ReportExcelDocument)
        }
    }
}
