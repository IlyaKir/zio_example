package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.{XSSFRow, XSSFSheet}
import report_main.reportHandler.layers.{ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.columnHeaders.report._
import report_main.reportHandler.types.mainFiles.ReportWorkbook
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.ReportSheetHeaders
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.ReportSheetHeaders.MetadataColumnIds
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, UIO, URIO, ZIO}

object ReportHeadersReader {
    import ReportMainHeaderReader.getMetadataNameColumnId
    import ReportOtherHeadersReader.tryParseSheetName
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleXSSFCell
    import report_main.reportHandler.sideEffects.headers.{ReportHeadersReaderSE => SE}
    import report_main.reportHandler.excel.reader.headers.HeadersReaderUtils._

    /** get info about types (columns and sheets) */
    def readHeaders(reportWorkbook: ReportWorkbook): RIO[Logging with Has[ReportWorkbookUpdater], List[ReportSheetHeaders]] = {
        (for {
            _ <- SE.gettingReportHeaders
            sheetHeaders <- ZIO.collectAllSuccesses(reportWorkbook.getSheets.map(getSingleSheetHeadersInfo))
        } yield sheetHeaders)
            .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
    }

    private def getSingleSheetHeadersInfo(sheet: XSSFSheet): RIO[Logging with Has[WorkbookUpdater], ReportSheetHeaders] = {
        for {
            conceptTypeName <- tryParseSheetName(sheet)

            headerCellsInfo <- getHeaderCellsInfo(sheet)
            metadataNameColumnId <- getMetadataNameColumnId(headerCellsInfo.headCell)

            cellId2ColumnHeader <- getColumnId2ColumnHeader(headerCellsInfo.headCell.getRow, headerCellsInfo.cellIds.drop(1), metadataNameColumnId)
            metadataColumnIds <- getMetadataColumnIds(cellId2ColumnHeader, metadataNameColumnId)
        } yield ReportSheetHeaders(sheet = sheet,
            conceptTypeName = conceptTypeName,
            metadataNameColumnId = metadataNameColumnId,
            metadataColumnIds = metadataColumnIds,
            columnId2columnHeader = cellId2ColumnHeader)
    }

    private def getColumnId2ColumnHeader(row: XSSFRow,
                                         columnIds: List[Int],
                                         metadataNameColumnId: Int): URIO[Logging with Has[WorkbookUpdater], Map[Int, ReportColumnHeader]] = {
        ZIO.collectAllSuccesses(columnIds.map { columnId => getSingleXSSFCell(row, columnId)})
            .flatMap(cells => ReportOtherHeadersReader.readHeaders(cells, metadataNameColumnId))
    }

    private def getMetadataColumnIds(cellId2ColumnHeader: Map[Int, ReportColumnHeader],
                                     metadataNameColumnId: Int): UIO[MetadataColumnIds] = {
        val maybeMetadataAvatarColumnId = cellId2ColumnHeader.find(_._2.columnType == ReportColumnHeaderType.metadataAvatar).map(_._1)
        val maybeMetadataNotesColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == ReportColumnHeaderType.metadataNotes }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataNotes] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        val maybeMetadataFromColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == ReportColumnHeaderType.metadataFrom }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataFrom] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        val maybeMetadataToColumnId = cellId2ColumnHeader
            .find { case (_, columnHeader) => columnHeader.columnType == ReportColumnHeaderType.metadataTo }
            .map { case (cellId, columnHeader) => cellId -> columnHeader.asInstanceOf[MetadataTo] }
            .find { case (_, columnHeader) => columnHeader.objectColumnId == metadataNameColumnId }
            .map { case (cellId, _) => cellId }
        UIO.succeed(MetadataColumnIds(
            metadataNotes = maybeMetadataNotesColumnId,
            metadataFrom = maybeMetadataFromColumnId,
            metadataTo = maybeMetadataToColumnId,
            metadataAvatar = maybeMetadataAvatarColumnId))
    }
}
