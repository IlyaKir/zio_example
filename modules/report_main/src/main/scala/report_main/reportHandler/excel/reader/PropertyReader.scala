package report_main.reportHandler.excel.reader

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFRow}
import _root_.report_main.generated.kb_api.graphql.{ValueInput, ValueType}
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.columnHeaders.kb.KBPropertyType
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.SheetKBHeaders
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property.PropertyIdentifier
import report_main.reportHandler.types.parsedExcel.reportExcel.property.{PropertyEnrichment, SingleSheetProperty}
import common.types.ID
import zio.logging.Logging
import zio.{Has, RIO, URIO, ZIO}

object PropertyReader {

    import report_main.reportHandler.excel.reader.CommentReader.getMultipleKBIds
    import report_main.reportHandler.excel.reader.DocumentReader.readDocumentCells
    import report_main.reportHandler.excel.reader.MetadataReader.{readMetadataFromCells, readMetadataIsMainCells, readMetadataNoteCells, readMetadataToCells}
    import report_main.reportHandler.excel.reader.ValueInputReader._
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getMultipleXSSFCells
    import report_main.reportHandler.sideEffects.excelReader.{PropertyReaderSE => SE}

    def getConceptProperties(conceptRows: List[XSSFRow],
                             kbHeaders: SheetKBHeaders): URIO[Logging with Has[WorkbookUpdater], List[SingleSheetProperty]] = {
        getProperties(conceptRows, kbHeaders, kbHeaders.columnId2KBConceptPropertyType)
    }

    def getLinkProperties(linkRows: List[XSSFRow],
                          kbHeaders: SheetKBHeaders,
                          columnId2KBPropertyType: (Int, KBPropertyType)): URIO[Logging with Has[WorkbookUpdater], List[SingleSheetProperty]] = {
        getProperties(linkRows, kbHeaders, Map(columnId2KBPropertyType))
    }

    /** get ValueInputs separated by ';' */
    private def getPropertyCellValues(cell: XSSFCell, kbPropertyType: ValueType): RIO[Logging with Has[WorkbookUpdater], List[ValueInput]] = {
        kbPropertyType.value match {
            case ValueType.String.value => tryGetStringValueInput(cell).map(_.map(value => ValueInput(stringValueInput = Some(value))))
            case ValueType.StringLocale.value => tryGetStringLocaleValueInput(cell).map(_.map(value => ValueInput(stringLocaleValueInput = Some(value))))
            case ValueType.Link.value => tryGetLinkValueInput(cell).map(_.map(value => ValueInput(linkValueInput = Some(value))))
            case ValueType.Geo.value => tryGetGeoValueInput(cell).map(value => List(ValueInput(geoPointValueInput = Some(value))))
            case ValueType.Int.value => tryGetIntValueInput(cell).map(_.map(value => ValueInput(intValueInput = Some(value))))
            case ValueType.Double.value => tryGetDoubleValueInput(cell).map(_.map(value => ValueInput(doubleValueInput = Some(value))))
            case ValueType.Date.value => tryGetDateTimeValueInput(cell).map(_.map(value => ValueInput(dateTimeValueInput = Some(value))))
            case _ => SE.kbPropertyTypeDoesntMatch(cell) *> ZIO.fail(new Throwable)
        }
    }

    private def handleValuesWithComments(cell: XSSFCell, propertyValues: List[ValueInput], maybeKBIds: List[Option[ID]])
    : URIO[Logging with Has[WorkbookUpdater], Map[ValueInput, List[Cell]]] = {
        (if (propertyValues.length == maybeKBIds.length)
            ZIO.succeed(propertyValues.zip(maybeKBIds).zipWithIndex.flatMap { case ((propertyValue, maybeKBId), index) =>
                Some(propertyValue, Cell(cell, index, maybeKBId))
            })
        else {
            SE.commentUnfit(cell).when(maybeKBIds.nonEmpty) *>
                SE.addSemicolonsComment(cell, propertyValues.length).when(propertyValues.length > 1)
                    .as(propertyValues.zipWithIndex.flatMap { case (propertyValue, index) => Some(propertyValue, Cell(cell, index)) })
        }).map(_.groupBy { case (value, _) => value }.view.mapValues(_.map { case (_, cell) => cell }).toMap)
    }

    /**
     * get properties for single object (rows)
     *
     * @param rows      single metadataName or single MetadataToName(linkColumn)
     * @param kbHeaders kb headers
     * @return properties
     */
    private def getProperties(rows: List[XSSFRow], kbHeaders: SheetKBHeaders,
                              columnId2KBPropertyType: Map[Int, KBPropertyType]): URIO[Logging with Has[WorkbookUpdater], List[SingleSheetProperty]] = {
        ZIO.collectAllSuccesses(columnId2KBPropertyType.map { case (propertyColumnId, kbPropertyType) =>
            for {
                cells <- getMultipleXSSFCells(rows, propertyColumnId)
                singleSheetProperties <- ZIO.collectAllSuccesses(cells.map { cell =>
                    (for {
                        propertyValues <- getPropertyCellValues(cell, kbPropertyType.valueType)
                        maybeKBIds <- getMultipleKBIds(cell)
                        getValueInput2Cells <- handleValuesWithComments(cell, propertyValues, maybeKBIds)

                        properties <- ZIO.collectAllSuccesses(getValueInput2Cells.map { case (valueInput, cells) =>
                            val rows = cells.map(_.xssfCell.getRow)
                            PropertyEnrichmentGetter(kbHeaders, rows, propertyColumnId).get.map { enrichment =>
                                SingleSheetProperty(
                                    propertyIdentifier = PropertyIdentifier(valueInput, kbPropertyType),
                                    propertyCells = cells,
                                    enrichment = enrichment)
                            }
                        })
                        _ <- SE.cellValueAndCommentParsedSuccessfully(cell)
                    } yield properties).catchAll(_ => SE.unableParseCellValueOrComment(cell).as(List.empty))
                }).map(_.flatten)
            } yield singleSheetProperties
        }).map(_.flatten.toList)
    }

    private case class PropertyEnrichmentGetter(kbHeaders: SheetKBHeaders, rows: List[XSSFRow], propertyColumnId: Int) {
        private lazy val maybeDocumentColumnId: Option[Int] = kbHeaders.sheetHeaders.documentColumnIds.find(_ == propertyColumnId + 1)
        private lazy val maybeMetadataNotesColumnId: Option[Int] = kbHeaders.sheetHeaders.objectColumnId2MetadataNotesColumnHeader.get(propertyColumnId).map(_.cell.getColumnIndex)
        private lazy val maybeMetadataFromColumnId: Option[Int] = kbHeaders.sheetHeaders.objectColumnId2MetadataFromColumnHeader.get(propertyColumnId).map(_.cell.getColumnIndex)
        private lazy val maybeMetadataToColumnId: Option[Int] = kbHeaders.sheetHeaders.objectColumnId2MetadataToColumnHeader.get(propertyColumnId).map(_.cell.getColumnIndex)
        private lazy val maybeMetadataIsMainColumnId: Option[Int] = kbHeaders.sheetHeaders.propertyColumnId2MetadataIsMainColumnHeader.get(propertyColumnId).map(_.cell.getColumnIndex)

        def get: URIO[Logging with Has[WorkbookUpdater], PropertyEnrichment] = {
            for {
                metadataNoteCells <- readMetadataNoteCells(rows, maybeMetadataNotesColumnId)
                metadataFromCells <- readMetadataFromCells(rows, maybeMetadataFromColumnId)
                metadataToCells <- readMetadataToCells(rows, maybeMetadataToColumnId)
                metadataIsMainCells <- readMetadataIsMainCells(rows, maybeMetadataIsMainColumnId)
                documents <- readDocumentCells(rows, maybeDocumentColumnId)
            } yield PropertyEnrichment(
                metadataNoteCells = metadataNoteCells,
                metadataFromCells = metadataFromCells,
                metadataToCells = metadataToCells,
                metadataIsMainCells = metadataIsMainCells,
                documents = documents
            )
        }
    }
}

