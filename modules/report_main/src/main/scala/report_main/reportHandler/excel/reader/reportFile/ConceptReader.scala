package report_main.reportHandler.excel.reader.reportFile

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.excel.merger.ConceptMerger
import report_main.reportHandler.layers.{ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept.ConceptIdentifier
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.{Concept, SingleSheetConcept}
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.SheetKBHeaders
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, URIO, ZIO}

case class ConceptReader(sheetsKBHeaders: List[SheetKBHeaders]) {

    import report_main.reportHandler.excel.reader.CommentReader.{getLinkKBIds, getSingleKBId}
    import report_main.reportHandler.excel.reader.DocumentReader.readDocumentCells
    import report_main.reportHandler.excel.reader.MetadataReader.{readMetadataFromCells, readMetadataNoteCells, readMetadataToCells}
    import report_main.reportHandler.excel.reader.PropertyReader.getConceptProperties
    import report_main.reportHandler.excel.reader.utils.ReaderUtils.getConceptIdentifier2Cells
    import report_main.reportHandler.sideEffects.excelReader.{ConceptReaderSE => SE}

    def read: URIO[Logging with Has[ReportWorkbookUpdater], List[Concept]] = {
        (for {
            _ <- SE.gettingConcepts
            concepts <- URIO.collectAllSuccesses(sheetsKBHeaders.map { singleSheetKBHeadersInfo =>
                SE.readSheet(singleSheetKBHeadersInfo.sheetHeaders.sheetName) *> SingleSheetConceptsReader(singleSheetKBHeadersInfo).read
            }).map(_.flatten)
            mergedConcepts <- ConceptMerger(concepts).merge
        } yield mergedConcepts)
            .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
    }

    private case class SingleSheetConceptsReader(kbHeaders: SheetKBHeaders) {
        def read: URIO[Logging with Has[WorkbookUpdater], List[SingleSheetConcept]] = {
            for {
                conceptFromIdentifier2ConceptCells <- getConceptFromIdentifier2Cells(kbHeaders)
                conceptToIdentifier2ConceptCells <- getConceptToIdentifier2Cells(kbHeaders)

                conceptIdentifier2ConceptCells = (conceptFromIdentifier2ConceptCells.toList ++ conceptToIdentifier2ConceptCells.toList)
                    .groupBy { case (conceptIdentifier, _) => conceptIdentifier }
                    .mapValues(_.flatMap { case (_, cells) => cells })
                result <- ZIO.collectAllSuccesses(conceptIdentifier2ConceptCells.map { case (conceptIdentifier, cells) =>
                    SingleConceptReader(conceptIdentifier, cells).read
                }).map(_.toList)
            } yield result
        }

        private def getConceptFromIdentifier2Cells(sheetKBHeaders: SheetKBHeaders): URIO[Logging, Map[ConceptIdentifier, List[XSSFCell]]] = {
            val columnId = sheetKBHeaders.sheetHeaders.metadataNameColumnId
            getConceptIdentifier2Cells(kbHeaders.sheetHeaders.sheetRows, columnId, sheetKBHeaders.kbConceptType)
        }

        private def getConceptToIdentifier2Cells(sheetKBHeaders: SheetKBHeaders): URIO[Logging, Map[ConceptIdentifier, List[XSSFCell]]] = {
            ZIO.collectAllSuccesses(sheetKBHeaders.columnId2KBLinkType.map { case (columnId, kbLinkType) =>
                val kbConceptType = if (sheetKBHeaders.kbConceptType == kbLinkType.kbConceptFromType) kbLinkType.kbConceptToType else kbLinkType.kbConceptFromType
                getConceptIdentifier2Cells(kbHeaders.sheetHeaders.sheetRows, columnId, kbConceptType)
            }).map(_.flatten.groupBy { case (conceptIdentifier, _) => conceptIdentifier }.view.mapValues(_.flatMap(_._2).toList).toMap)
        }

        /**
         * This class is used to get Concept for single ConceptIdentifier
         */
        private case class SingleConceptReader(conceptIdentifier: ConceptIdentifier, conceptCells: List[XSSFCell]) {
            private val (metadataNameCells, linkCells) = conceptCells.partition(_.getColumnIndex == kbHeaders.sheetHeaders.metadataNameColumnId)
            private val metadataNameRows = metadataNameCells.map(_.getRow)

            private val getMetadataNameCellsWithComments = ZIO.foreach(metadataNameCells) { cell =>
                getSingleKBId(cell).map(maybeKBId => Cell(xssfCell = cell, maybeParsedComment = maybeKBId))
            }
            private val getLinkCellsWithComments = ZIO.foreach(linkCells) { cell =>
                getLinkKBIds(cell).map(maybeLinkKBIds => Cell(xssfCell = cell, maybeParsedComment = maybeLinkKBIds.map(_.conceptKBId)))
            }

            def read: RIO[Logging with Has[WorkbookUpdater], SingleSheetConcept] = {
                for {
                    metadataNotes <- readMetadataNoteCells(metadataNameRows, kbHeaders.sheetHeaders.metadataColumnIds.metadataNotes)
                    metadataFrom <- readMetadataFromCells(metadataNameRows, kbHeaders.sheetHeaders.metadataColumnIds.metadataFrom)
                    metadataTo <- readMetadataToCells(metadataNameRows, kbHeaders.sheetHeaders.metadataColumnIds.metadataTo)

                    maybeDocumentColumnId = kbHeaders.sheetHeaders.documentColumnIds.find(_ == kbHeaders.sheetHeaders.metadataNameColumnId + 1)

                    avatars <- readDocumentCells(metadataNameRows, kbHeaders.sheetHeaders.metadataColumnIds.metadataAvatar)
                    documents <- readDocumentCells(metadataNameRows, maybeDocumentColumnId)
                    properties <- getConceptProperties(metadataNameRows, kbHeaders)

                    metadataNameCells <- getMetadataNameCellsWithComments
                    linkCells <- getLinkCellsWithComments
                } yield SingleSheetConcept(
                    conceptIdentifier = conceptIdentifier,
                    metadataNameCells = metadataNameCells,
                    linkCells = linkCells,
                    metadataNotes = metadataNotes,
                    metadataFrom = metadataFrom,
                    metadataTo = metadataTo,
                    avatars = avatars,
                    documents = documents,
                    properties = properties
                )
            }
        }
    }
}
