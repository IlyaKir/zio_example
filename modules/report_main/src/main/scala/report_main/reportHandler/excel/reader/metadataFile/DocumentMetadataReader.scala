package report_main.reportHandler.excel.reader.metadataFile

import report_main.reportHandler.excel.reader.MetadataReader.{readMetadataDescriptionCells, readMetadataExternalUrlCells, readMetadataPublicationAuthorCells, readMetadataPublicationDateCells}
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.metadataExcel.document.SingleSheetDocumentMetadataInfo
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.MetadataSheetHeaders
import zio.logging.Logging
import zio.magic.ZioProvideMagicOps
import zio.{Has, URIO, ZIO}

case class DocumentMetadataReader(sheetHeaders: List[MetadataSheetHeaders]) {
    import report_main.reportHandler.excel.reader.DocumentReader.readDocumentCells

    /**
     * @return documentPath -> DocumentMetadata
     */
    def read: URIO[Logging with Has[MetadataWorkbookUpdater], List[SingleSheetDocumentMetadataInfo]] = {
        getSheetsDocumentsInfo
            .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
    }

    private def getSheetsDocumentsInfo: URIO[Logging with Has[WorkbookUpdater], List[SingleSheetDocumentMetadataInfo]] = {
        ZIO.collectAllSuccesses(sheetHeaders.map { singleSheetHeadersInfo =>
            for {
                documentCells <- readDocumentCells(singleSheetHeadersInfo.sheetRows, Some(singleSheetHeadersInfo.documentPathColumnId))
                documentPath2SingleCellDocuments = documentCells.groupBy(_.pathToFile)
                result <- ZIO.collectAllSuccesses(documentPath2SingleCellDocuments.map { case (documentPath, cells) =>
                    val rows = cells.map(_.cell.xssfCell.getRow)
                    for {
                        metadataExternalUrl <- readMetadataExternalUrlCells(rows, singleSheetHeadersInfo.metadataColumnIds.metadataExternalUrl)
                        metadataPublicationDate <- readMetadataPublicationDateCells(rows, singleSheetHeadersInfo.metadataColumnIds.metadataPublicationDate)
                        metadataPublicationAuthor <- readMetadataPublicationAuthorCells(rows, singleSheetHeadersInfo.metadataColumnIds.metadataPublicationAuthor)
                        metadataDescription <- readMetadataDescriptionCells(rows, singleSheetHeadersInfo.metadataColumnIds.metadataDescription)
                    } yield SingleSheetDocumentMetadataInfo(
                        documentPath = documentPath,
                        documentPathCells = cells.map(_.cell),
                        metadataExternalUrl = metadataExternalUrl,
                        metadataPublicationDate = metadataPublicationDate,
                        metadataPublicationAuthor = metadataPublicationAuthor,
                        metadataDescription = metadataDescription)
                }).map(_.toList)
            } yield result
        }).map(_.flatten)
    }
}
