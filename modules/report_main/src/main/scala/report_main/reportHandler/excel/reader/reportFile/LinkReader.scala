package report_main.reportHandler.excel.reader.reportFile

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.excel.merger.LinkMerger
import report_main.reportHandler.layers.{ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.columnHeaders.kb.{KBLinkType, KBPropertyType}
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.SheetKBHeaders
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link.LinkIdentifier
import report_main.reportHandler.types.parsedExcel.reportExcel.link.{Link, SingleSheetLink}
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, URIO, ZIO}

import scala.annotation.tailrec

case class LinkReader(concepts: List[Concept], kbHeaders: List[SheetKBHeaders]) {
    import report_main.reportHandler.excel.reader.CommentReader.getLinkKBIds
    import report_main.reportHandler.excel.reader.DocumentReader.readDocumentCells
    import report_main.reportHandler.excel.reader.MetadataReader.{readMetadataFromCells, readMetadataNoteCells, readMetadataToCells}
    import report_main.reportHandler.excel.reader.PropertyReader.getLinkProperties
    import report_main.reportHandler.excel.reader.utils.ReaderUtils.getConceptIdentifier2Cells
    import report_main.reportHandler.sideEffects.excelReader.{LinkReaderSE => SE}

    private lazy val conceptIdentifier2Concept = concepts.map(concept => concept.mainInfo.conceptIdentifier -> concept).toMap

    def read: URIO[Logging with Has[ReportWorkbookUpdater], List[Link]] = {
        (for {
            _ <- SE.gettingLinks
            singleSheetLinks <- foldLeft(URIO.succeed(List.empty), kbHeaders)
            links <- ZIO.collectAllSuccesses(singleSheetLinks.map(LinkMerger(_).merge))
        } yield links)
            .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
    }

    @tailrec
    private def foldLeft(acc: URIO[Logging with Has[WorkbookUpdater], List[SingleSheetLink]], tailSheetsKBHeadersInfo: List[SheetKBHeaders])
    : URIO[Logging with Has[WorkbookUpdater], List[SingleSheetLink]] = {
        tailSheetsKBHeadersInfo match {
            case Nil => acc
            case ::(sheetKBHeaders, tl) =>
                val accLinks = for {
                    _ <- SE.readSheet(sheetKBHeaders.sheetHeaders.sheetName)
                    prevLinks <- acc
                    currLinks <- SingleSheetLinksReader(sheetKBHeaders).getSingleSheetLinks
                } yield prevLinks ++ currLinks
                foldLeft(accLinks, tl)
        }
    }

    private case class SingleSheetLinksReader(sheetKBHeadersInfo: SheetKBHeaders) {
        private val sheetName = sheetKBHeadersInfo.sheetHeaders.sheetName

        // находим все conceptFrom на этом листе
        private val sheetConcept2MetadataNameCells = concepts
            .map(concept => concept -> concept.mainInfo.metadataNameCells.filter(metadataCell =>
                (metadataCell.getSheetName == sheetName) && (metadataCell.xssfCell.getColumnIndex == sheetKBHeadersInfo.sheetHeaders.metadataNameColumnId)))
            .filter { case (_, metadataNameExcelCoordinates) => metadataNameExcelCoordinates.nonEmpty }
            .toMap

        // находим все колонки со связями
        def getSingleSheetLinks: URIO[Logging with Has[WorkbookUpdater], List[SingleSheetLink]] = {
            ZIO.collectAllSuccesses(sheetConcept2MetadataNameCells.flatMap { conceptFrom2Cells =>
                sheetKBHeadersInfo.columnId2KBLinkType.map { linkColumnId2KBLinkType =>
                    // для каждого концепта и колонки создаём SingleSheetLinkInfo
                    LinksReader(sheetKBHeadersInfo, conceptFrom2Cells, linkColumnId2KBLinkType).read
                }
            }).map(_.flatten.toList)
        }

        /**
         * This class is used to get LinkCellValues for single conceptFrom and single linkColumn
         */
        private case class LinksReader(sheetKBHeaders: SheetKBHeaders,
                                       conceptFrom2Cells: (Concept, List[Cell]),
                                       linkColumnId2KBLinkType: (Int, KBLinkType)) {
            private val (conceptFrom, conceptFromCells) = conceptFrom2Cells
            private val (linkColumnId, kbLinkType) = linkColumnId2KBLinkType

            private lazy val maybeDocumentColumnId = sheetKBHeaders.sheetHeaders.documentColumnIds.find(_ == linkColumnId + 1)
            private lazy val maybeMetadataNotesColumnId = sheetKBHeaders.sheetHeaders.objectColumnId2MetadataNotesColumnHeader.get(linkColumnId).map(_.cell.getColumnIndex)
            private lazy val maybeMetadataFromColumnId = sheetKBHeaders.sheetHeaders.objectColumnId2MetadataFromColumnHeader.get(linkColumnId).map(_.cell.getColumnIndex)
            private lazy val maybeMetadataToColumnId = sheetKBHeaders.sheetHeaders.objectColumnId2MetadataToColumnHeader.get(linkColumnId).map(_.cell.getColumnIndex)

            private val getConceptToIdentifier2Cells = {
                val (columnId, kbLinkType) = linkColumnId2KBLinkType
                val kbConceptToType = if (sheetKBHeaders.kbConceptType == kbLinkType.kbConceptFromType) kbLinkType.kbConceptToType else kbLinkType.kbConceptFromType

                getConceptIdentifier2Cells(conceptRows = conceptFromCells.map(_.getRow), columnId = columnId, kbConceptType = kbConceptToType)
            }

            private lazy val isLinkDirectionFromTo: Boolean = kbLinkType.kbConceptFromType == conceptFrom.mainInfo.conceptIdentifier.kbType
            // link property types for linkColumnId
            private lazy val columnId2KBLinkPropertyType: Map[Int, KBPropertyType] = sheetKBHeaders.getKBLinkPropertyTypesByLinkColumnId(linkColumnId)

            def read: URIO[Logging with Has[WorkbookUpdater], List[SingleSheetLink]] = {
                (for {
                    conceptToIdentifier2Cells <- getConceptToIdentifier2Cells
                    linksInfo <- ZIO.collectAllSuccesses(conceptToIdentifier2Cells.map { case (conceptToIdentifier, linkCells) =>
                        for {
                            linkCellPositions <- ZIO.foreach(linkCells) { cell =>
                                getLinkKBIds(cell).map(maybeLinkKBIds => Cell(xssfCell = cell, maybeParsedComment = maybeLinkKBIds.flatMap(_.linkKBId)))
                            }

                            linkRows = linkCells.map(_.getRow)
                            metadataNotes <- readMetadataNoteCells(linkRows, maybeMetadataNotesColumnId)
                            metadataFrom <- readMetadataFromCells(linkRows, maybeMetadataFromColumnId)
                            metadataTo <- readMetadataToCells(linkRows, maybeMetadataToColumnId)

                            conceptTo = conceptIdentifier2Concept(conceptToIdentifier)
                            (directedConceptFrom, directedConceptTo) = if (isLinkDirectionFromTo) (conceptFrom, conceptTo) else (conceptTo, conceptFrom)
                            linkIdentifier = LinkIdentifier(conceptFrom = directedConceptFrom, conceptTo = directedConceptTo, kbLinkType = kbLinkType)

                            documentCells <- readDocumentCells(linkRows, maybeDocumentColumnId)
                            propertyInfo <- ZIO.collectAllSuccesses(columnId2KBLinkPropertyType.map { row =>
                                getLinkProperties(linkRows, sheetKBHeaders, row)
                            }).map(_.flatten.toList)
                        } yield SingleSheetLink(
                            linkIdentifier = linkIdentifier,
                            linkCells = linkCellPositions,
                            metadataNotes = metadataNotes,
                            metadataFrom = metadataFrom,
                            metadataTo = metadataTo,
                            documents = documentCells,
                            properties = propertyInfo)
                    })
                } yield linksInfo.toList)
            }
        }
    }
}
