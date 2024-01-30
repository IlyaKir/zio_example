package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.{XSSFRow, XSSFSheet}
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.columnHeaders.metadata._
import report_main.reportHandler.types.mainFiles.MetadataWorkbook
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.MetadataSheetHeaders
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.MetadataSheetHeaders.MetadataColumnIds
import zio.logging.Logging
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, UIO, URIO, ZIO}

object MetadataHeadersReader {
    import MetadataMainHeaderReader.getDocumentPathColumnId
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleXSSFCell
    import report_main.reportHandler.sideEffects.headers.{MetadataHeadersReaderSE => SE}
    import report_main.reportHandler.excel.reader.headers.HeadersReaderUtils._

    def readHeaders(maybeMetadataWorkbook: Option[MetadataWorkbook]): RIO[Logging with Has[MetadataWorkbookUpdater], List[MetadataSheetHeaders]] = {
        (for {
            _ <- SE.gettingMetadataHeaders
            sheetHeaders <- ZIO.collectAllSuccesses(maybeMetadataWorkbook.map { metadataWorkbook =>
                metadataWorkbook.getSheets.map(getSingleSheetHeadersInfo)
            }.getOrElse(List.empty))
        } yield sheetHeaders)
            .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
    }

    private def getSingleSheetHeadersInfo(sheet: XSSFSheet): RIO[Logging with Has[WorkbookUpdater], MetadataSheetHeaders] = {
        for {
            headerCellsInfo <- getHeaderCellsInfo(sheet)
            documentPathColumnId <- getDocumentPathColumnId(headerCellsInfo.headCell)

            cellId2ColumnHeader <- getColumnId2ColumnHeader(headerCellsInfo.headCell.getRow, headerCellsInfo.cellIds.drop(1), documentPathColumnId)
            metadataColumnIds <- getMetadataColumnIds(cellId2ColumnHeader, documentPathColumnId)
        } yield MetadataSheetHeaders(sheet = sheet,
            documentPathColumnId = documentPathColumnId,
            metadataColumnIds = metadataColumnIds)
    }

    private def getColumnId2ColumnHeader(row: XSSFRow,
                                         columnIds: List[Int],
                                         documentPathColumnId: Int): URIO[Logging with Has[WorkbookUpdater], Map[Int, MetadataColumnHeader]] = {
        ZIO.collectAllSuccesses(columnIds.map { columnId => getSingleXSSFCell(row, columnId) })
            .flatMap(cells => MetadataOtherHeadersReader.readHeaders(cells, documentPathColumnId))
    }

    private def getMetadataColumnIds(cellId2ColumnHeader: Map[Int, MetadataColumnHeader],
                                     metadataNameColumnId: Int): UIO[MetadataColumnIds] = {
        val maybeExternalUrlColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == MetadataColumnHeaderType.metadataExternalUrl }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataExternalUrl] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        val maybePublicationDateColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == MetadataColumnHeaderType.metadataPublicationDate }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataPublicationDate] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        val maybePublicationAuthorColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == MetadataColumnHeaderType.metadataPublicationAuthor }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataPublicationAuthor] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        val maybeDescriptionColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == MetadataColumnHeaderType.metadataDescription }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataDescription] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        UIO.succeed(MetadataColumnIds(
            metadataExternalUrl = maybeExternalUrlColumnId,
            metadataPublicationDate = maybePublicationDateColumnId,
            metadataPublicationAuthor = maybePublicationAuthorColumnId,
            metadataDescription = maybeDescriptionColumnId))
    }
}
