package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.columnHeaders.report._
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.ReportSheetHeaders
import zio.logging._
import zio.{Has, RIO, URIO, ZIO}

import scala.annotation.tailrec

object ReportOtherHeadersReader {
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleNonEmptyStringCellValue
  import report_main.reportHandler.regex.headers.ReportColumnHeaders
  import report_main.reportHandler.regex.utils.RegexUtils.tryMatch
    import report_main.reportHandler.sideEffects.headers.{ReportHeadersReaderSE => SE}

    def readHeaders(cells: List[XSSFCell], metadataNameColumnId: Int): URIO[Logging with Has[WorkbookUpdater], Map[Int, ReportColumnHeader]] = {
        val initialState = State(columnId2Header = Map.empty, maybeLastLinkColumnId = None, maybeLastPropertyColumnId = None)

        foldLeft(acc = URIO.succeed(initialState), metadataNameColumnId = metadataNameColumnId, tailCells = cells)
            .map(_.columnId2Header)
    }

    def tryParseSheetName(sheet: XSSFSheet): RIO[Logging with Has[WorkbookUpdater], String] = {
        val sheetName = sheet.getSheetName
        ZIO.fromOption(tryMatch(sheetName, ReportSheetHeaders.regexPattern, ReportSheetHeaders.regexPatternGroup))
            .tapError(_ => SE.unableParseSheetName(sheet))
            .orElseFail(new Throwable)
    }

    @tailrec
    private def foldLeft(acc: URIO[Logging with Has[WorkbookUpdater], State],
                         metadataNameColumnId: Int,
                         tailCells: List[XSSFCell])
    : URIO[Logging with Has[WorkbookUpdater], State] = {
        tailCells match {
            case Nil => acc
            case ::(cell, tl) =>
                val newAcc = for {
                    prevState <- acc
                    newState <- getNewState(cell, metadataNameColumnId,
                        maybeLastLinkColumnId = prevState.maybeLastLinkColumnId, maybeLastPropertyColumnId = prevState.maybeLastPropertyColumnId)
                } yield prevState.merge(newState)
                foldLeft(newAcc, metadataNameColumnId, tl)
        }
    }

    private case class State(columnId2Header: Map[Int, ReportColumnHeader],
                             maybeLastLinkColumnId: Option[Int] = None,
                             maybeLastPropertyColumnId: Option[Int] = None) { self =>
        def merge(newState: State): State = {
            State(columnId2Header = this.columnId2Header ++ newState.columnId2Header,
                maybeLastLinkColumnId = if (newState.maybeLastLinkColumnId.isDefined) newState.maybeLastLinkColumnId else self.maybeLastLinkColumnId,
                maybeLastPropertyColumnId = if (newState.maybeLastPropertyColumnId.isDefined) newState.maybeLastPropertyColumnId else self.maybeLastPropertyColumnId)
        }
    }

    /** Read columns from left to right and storage lastLinkColumnId and lastPropertyColumnId (may be conceptProperty or linkProperty)
     *
     * Every link property relates to the nearest left(last) linkColumnId
     *
     * Every Metadata isMain relates to the nearest left(last) propertyColumnId
    */
    private def getNewState(cell: XSSFCell,
                  metadataNameColumnId: Int,
                  maybeLastLinkColumnId: Option[Int],
                  maybeLastPropertyColumnId: Option[Int]): URIO[Logging with Has[WorkbookUpdater], State] = {
        (for {
            value <- getSingleNonEmptyStringCellValue(cell)
            state <- ZIO.fromOption(parseHeader(cell, value, metadataNameColumnId, maybeLastLinkColumnId, maybeLastPropertyColumnId))
                .mapBoth(
                    _ => new Throwable,
                    columnHeader => {
                        val columnIndex = cell.getColumnIndex
                        columnHeader.columnType match {
                            case ReportColumnHeaderType.link =>
                                State(columnId2Header = Map(columnIndex -> columnHeader), maybeLastLinkColumnId = Some(columnIndex))
                            case ReportColumnHeaderType.conceptProperty | ReportColumnHeaderType.linkProperty =>
                                State(columnId2Header = Map(columnIndex -> columnHeader), maybeLastPropertyColumnId = Some(columnIndex))
                            case _ => State(columnId2Header = Map(columnIndex -> columnHeader))
                        }
                    }
                ).tapError(_ => SE.unableParseColumnHeader(value, cell.getSheet))
        } yield state)
            .catchAll(_ => ZIO.succeed(State(Map.empty, None, None)))
    }


    private def parseHeader(cell: XSSFCell,
                            cellValue: String,
                            metadataNameColumnId: Int,
                            maybeLastLinkColumnId: Option[Int],
                            maybeLastPropertyColumnId: Option[Int]): Option[ReportColumnHeader] = {
        // last object (conceptProperty, link or linkProperty) columnId
        lazy val maybeLastObjectColumnId = List(maybeLastLinkColumnId, maybeLastPropertyColumnId).max
        val trimmedCellValue = cellValue.trim

        ReportColumnHeaders.Document.tryMatch(trimmedCellValue).map(_ => return Some(Document(cell)))
        ReportColumnHeaders.ConceptProperty.tryMatch(trimmedCellValue).map { propertyTypeName =>
            if (propertyTypeName == "Альтернативное название") return Some(ConceptProperty("Название", cell))
            else return Some(ConceptProperty(propertyTypeName.trim, cell))
        }
        ReportColumnHeaders.Link.tryMatchLinkType(trimmedCellValue).map { linkType =>
            ReportColumnHeaders.Link.tryMatchConceptType(trimmedCellValue) match {
                case Some(conceptType) if conceptType.trim.nonEmpty => return Some(Link(linkType.trim, Some(conceptType.trim), cell))
                case _ => return Some(Link(linkType, None, cell))
            }
        }
        ReportColumnHeaders.LinkProperty.tryMatch(trimmedCellValue)
            .flatMap(linkPropertyType => maybeLastLinkColumnId.map(lastLinkColumnId => return Some(LinkProperty(linkPropertyType.trim, lastLinkColumnId, cell))))
        ReportColumnHeaders.Metadata.From.tryMatch(trimmedCellValue)
            .flatMap(_ => maybeLastObjectColumnId match {
                case Some(lastObjectColumnId) => return Some(MetadataFrom(lastObjectColumnId, cell))
                case None => return Some(MetadataFrom(metadataNameColumnId, cell))
            })
        ReportColumnHeaders.Metadata.To.tryMatch(trimmedCellValue)
            .flatMap(_ => maybeLastObjectColumnId match {
                case Some(lastObjectColumnId) => return Some(MetadataTo(lastObjectColumnId, cell))
                case None => return Some(MetadataTo(metadataNameColumnId, cell))
            })
        ReportColumnHeaders.Metadata.Notes.tryMatch(trimmedCellValue)
            .flatMap(_ => maybeLastObjectColumnId match {
                case Some(lastObjectColumnId) => return Some(MetadataNotes(lastObjectColumnId, cell))
                case None => return Some(MetadataNotes(metadataNameColumnId, cell))
            })
        ReportColumnHeaders.Metadata.Avatar.tryMatch(trimmedCellValue)
            .flatMap(_ => return Some(MetadataAvatar(cell)))
        ReportColumnHeaders.Metadata.IsMain.tryMatch(trimmedCellValue)
            .flatMap(_ => maybeLastPropertyColumnId.map(lastPropertyColumnId => return Some(MetadataIsMain(lastPropertyColumnId, cell))))

        None
    }
}
