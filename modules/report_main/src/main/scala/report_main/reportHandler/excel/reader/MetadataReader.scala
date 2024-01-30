package report_main.reportHandler.excel.reader

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFRow}
import report_main.generated.kb_api.graphql.DateTimeValueInput
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleNonEmptyStringOrNumericCellValue
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.common.metadata.SingleCellMetadata
import zio.logging._
import zio.{Has, RIO, URIO, ZIO}

object MetadataReader {
    import report_main.reportHandler.excel.reader.CommentReader.getSingleKBId
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.{getMultipleXSSFCells, getSingleNonEmptyStringCellValue}
    import report_main.reportHandler.excel.reader.ValueInputReader.{tryGetDateTimeValueInput, tryGetBooleanValueInput, tryGetSingleValueInput}
    import report_main.reportHandler.sideEffects.excelReader.{MetadataReaderSE => SE}


    private val emptyListEffect = ZIO.succeed(List.empty)

    def readMetadataExternalUrlCells(rows: List[XSSFRow], maybeMetadataExternalUrlColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[String]]] = {
        maybeMetadataExternalUrlColumnId.map(metadataColumnId => readStringMetadata(rows, metadataColumnId))
            .getOrElse(emptyListEffect)
    }

    def readMetadataPublicationDateCells(rows: List[XSSFRow], maybeMetadataPublicationDateColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[DateTimeValueInput]]] = {
        maybeMetadataPublicationDateColumnId.map(metadataColumnId => readValueInputMetadata(rows, metadataColumnId, getValueInput = tryGetDateTimeValueInput))
            .getOrElse(emptyListEffect)
    }

    def readMetadataPublicationAuthorCells(rows: List[XSSFRow], maybeMetadataPublicationAuthorColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[String]]] = {
        maybeMetadataPublicationAuthorColumnId.map(metadataColumnId => readStringMetadata(rows, metadataColumnId))
            .getOrElse(emptyListEffect)
    }

    def readMetadataDescriptionCells(rows: List[XSSFRow], maybeMetadataDescriptionColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[String]]] = {
        maybeMetadataDescriptionColumnId.map(metadataColumnId => readStringMetadata(rows, metadataColumnId))
            .getOrElse(emptyListEffect)
    }

    def readMetadataNoteCells(rows: List[XSSFRow], maybeMetadataColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[String]]] = {
        maybeMetadataColumnId.map(metadataColumnId => readStringOrNumericMetadata(rows, metadataColumnId))
            .getOrElse(emptyListEffect)
    }

    def readMetadataFromCells(rows: List[XSSFRow], maybeMetadataColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[DateTimeValueInput]]] = {
        maybeMetadataColumnId.map(metadataColumnId => readValueInputMetadata(rows, metadataColumnId, getValueInput = tryGetDateTimeValueInput))
            .getOrElse(emptyListEffect)
    }

    def readMetadataToCells(rows: List[XSSFRow], maybeMetadataColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[DateTimeValueInput]]] = {
        maybeMetadataColumnId.map(metadataColumnId => readValueInputMetadata(rows, metadataColumnId, getValueInput = tryGetDateTimeValueInput))
            .getOrElse(emptyListEffect)
    }

    def readMetadataIsMainCells(rows: List[XSSFRow], maybeMetadataColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[Boolean]]] = {
        maybeMetadataColumnId.map(metadataColumnId => readValueInputMetadata(rows, metadataColumnId, getValueInput = tryGetBooleanValueInput))
            .getOrElse(emptyListEffect)
    }

    private def readStringMetadata(rows: List[XSSFRow], metadataColumnId: Int): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[String]]] = {
        for {
            xssfCells <- getMultipleXSSFCells(rows, metadataColumnId)
            singleCellMetadatas <- ZIO.collectAllSuccesses(xssfCells.map { xssfCell =>
                for {
                    maybeKBId <- getSingleKBId(xssfCell)
                    value <- getSingleNonEmptyStringCellValue(xssfCell).tapError(_ => SE.unableReadMetadata(xssfCell))
                } yield SingleCellMetadata(value, Cell(xssfCell, maybeParsedComment = maybeKBId))
            })
        } yield singleCellMetadatas
    }

    private def readStringOrNumericMetadata(rows: List[XSSFRow], metadataColumnId: Int): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[String]]] = {
        for {
            xssfCells <- getMultipleXSSFCells(rows, metadataColumnId)
            singleCellMetadatas <- ZIO.collectAllSuccesses(xssfCells.map { xssfCell =>
                for {
                    maybeKBId <- getSingleKBId(xssfCell)
                    value <- getSingleNonEmptyStringOrNumericCellValue(xssfCell).tapError(_ => SE.unableReadMetadata(xssfCell))
                } yield SingleCellMetadata(value, Cell(xssfCell, maybeParsedComment = maybeKBId))
            })
        } yield singleCellMetadatas
    }

    private def readValueInputMetadata[T](rows: List[XSSFRow], metadataColumnId: Int,
                                          getValueInput: XSSFCell => RIO[Logging with Has[WorkbookUpdater], List[T]]): URIO[Logging with Has[WorkbookUpdater], List[SingleCellMetadata[T]]] = {
        for {
            xssfCells <- getMultipleXSSFCells(rows, metadataColumnId)
            singleCellMetadatas <- ZIO.collectAllSuccesses(xssfCells.map { xssfCell =>
                for {
                    maybeKBId <- getSingleKBId(xssfCell)
                    maybeValue <- tryGetSingleValueInput(xssfCell, getValueInput).tapError(_ => SE.unableReadMetadata(xssfCell))
                } yield maybeValue.map(value => SingleCellMetadata(value, Cell(xssfCell, maybeParsedComment = maybeKBId)))
            }).map(_.flatten)
        } yield singleCellMetadatas
    }
}
