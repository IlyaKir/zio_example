package report_main.reportHandler.excel.reader

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFRow}
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getMultipleXSSFCells
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.document.SingleCellDocument
import common.types.ID
import zio.{Has, RIO, URIO, ZIO}
import zio.logging.Logging

object DocumentReader {
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getMultipleNonEmptyStringCellValues
    import report_main.reportHandler.excel.reader.CommentReader.getMultipleKBIds
    import report_main.reportHandler.sideEffects.excelReader.{DocumentReaderSE => SE}

    /**
     * cells with types != string will be colored red
     *
     * if documentPaths.length != maybeKBIds.length then create Document objects with maybeKBId = None
     *
     * @return documentCellValues
     */
    def readDocumentCells(rows: List[XSSFRow], maybeDocumentColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellDocument]] = {
        val getDocumentCells: Int => URIO[Logging with Has[WorkbookUpdater], List[SingleCellDocument]] = { documentColumnId =>
            for {
                cells <- getMultipleXSSFCells(rows, documentColumnId)
                documents <- ZIO.collectAllSuccesses(cells.map(cell => getSingleCellDocuments(cell))).map(_.flatten)
            } yield documents
        }

        maybeDocumentColumnId.map(getDocumentCells)
            .getOrElse(ZIO.succeed(List.empty))
    }

    private def getSingleCellDocuments(cell: XSSFCell): RIO[Has[WorkbookUpdater] with Logging, List[SingleCellDocument]] = {
        (for {
            documentPaths <- getDocumentCellValues(cell)
            maybeKBIds <- getMultipleKBIds(cell)
            singleCellDocuments <- handleValuesWithComments(cell, documentPaths, maybeKBIds)
            _ <- SE.documentPathsAndCommentParsedSuccessfully(cell)
        } yield singleCellDocuments)
            .catchAll(_ => SE.unableParseCellValueOrComment(cell).as(List.empty))
    }

    private def handleValuesWithComments(cell: XSSFCell, documentPaths: List[String], maybeKBIds: List[Option[ID]]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellDocument]] = {
        (documentPaths, maybeKBIds) match {
            case (documentPaths, maybeKBIds) if documentPaths.length == maybeKBIds.length =>
                val documentPath2MaybeKBId = documentPaths.zip(maybeKBIds).zipWithIndex
                ZIO.succeed(documentPath2MaybeKBId.map { case ((path, maybeKBId), position) =>
                    SingleCellDocument(path, cell = Cell(cell, position, maybeKBId))
                })
            case (documentPaths, maybeKBIds) =>
                SE.commentUnfit(cell, documentPaths.length).when(maybeKBIds.nonEmpty) *>
                    SE.addSemicolonsComment(cell, documentPaths.length).when(documentPaths.length > 1)
                        .as(documentPaths.zipWithIndex.map { case (path, position) => SingleCellDocument(path, cell = Cell(cell, position)) })
        }
    }

    /**
     * get normalized(NFC) documentPaths separated by ';'
     *
     * Returns ONLY NONEMPTY VALUES
     *
     * symbols '\' replace by '/'
     *
     * if path starts with '\' then drop this symbol
     */
    private def getDocumentCellValues(cell: XSSFCell): RIO[Logging, List[String]] = {
        getMultipleNonEmptyStringCellValues(cell).map(_.map { documentPath =>
            (if (documentPath.startsWith("\\") || documentPath.startsWith("/")) documentPath.drop(1) else documentPath)
                .replace('\\', '/')
        })
    }
}
