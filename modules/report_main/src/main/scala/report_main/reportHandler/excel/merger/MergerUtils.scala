package report_main.reportHandler.excel.merger

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.common.metadata.{Metadata, SingleCellMetadata}
import report_main.reportHandler.types.parsedExcel.reportExcel.document.{ReportExcelSinglePathDocument, SingleCellDocument}
import zio.{Has, UIO, URIO}
import zio.logging.Logging

object MergerUtils {
    import report_main.reportHandler.sideEffects.excelReader.{MergerSE => SE}

    def mergeMetadata[T](metadataCells: List[SingleCellMetadata[T]]): URIO[Logging with Has[WorkbookUpdater], Option[Metadata[T]]] = {
        val metadataValue2Cells = metadataCells
            .groupBy(_.value)
            .mapValues(_.map(_.cell))
        if (metadataValue2Cells.size > 1) SE.unable2MergeDiffMetadata(metadataValue2Cells.values.flatten.toList).as(None)
        else URIO.succeed(metadataValue2Cells.headOption.map(Metadata(_)))
    }

    def mergeAvatars(avatarCells: List[SingleCellDocument]): URIO[Logging with Has[WorkbookUpdater], Option[ReportExcelSinglePathDocument]] = {
        val avatarCellValue2Cells = avatarCells
            .groupBy(_.pathToFile)
            .mapValues(_.map(_.cell))
        if (avatarCellValue2Cells.size > 1) SE.unable2MergeDiffAvatars(avatarCellValue2Cells.values.flatten.toList).as(None)
        else URIO.succeed(avatarCellValue2Cells.headOption.map(ReportExcelSinglePathDocument(_)))
    }

    def mergeDocuments2ReportExcelDocuments(documentCells: List[SingleCellDocument]): UIO[List[ReportExcelSinglePathDocument]] = {
        UIO.succeed(documentCells.groupBy(_.pathToFile).map { case (pathToFile, documents) =>
            val distinctCells = documents.map(_.cell).distinct
            ReportExcelSinglePathDocument(pathToFile, documentPathCells = distinctCells)
        }.toList)
    }

//    def mergeDocuments2MetadataExcelDocuments(cells: List[SingleCellDocument]): UIO[Logging with Has[WorkbookUpdater], List[Cell]] = {
//        val distinctCommentKBIds = cells.map(_.cell.maybeParsedComment).filter(_.isDefined).distinct
//        if (distinctCommentKBIds.length > 1)
//        else UIO.succeed()
//    }

}
