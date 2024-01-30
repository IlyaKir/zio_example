package report_main.reportHandler.excel.reader.headers

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.columnHeaders.metadata._
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.ReportSheetHeaders
import zio.logging._
import zio.{Has, RIO, URIO, ZIO}

import scala.annotation.tailrec

object MetadataOtherHeadersReader {
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleNonEmptyStringCellValue
  import report_main.reportHandler.regex.headers.MetadataColumnHeaders
  import report_main.reportHandler.regex.utils.RegexUtils.tryMatch
    import report_main.reportHandler.sideEffects.headers.{MetadataHeadersReaderSE => SE}

    def readHeaders(cells: List[XSSFCell], documentPathColumnId: Int): URIO[Logging with Has[WorkbookUpdater], Map[Int, MetadataColumnHeader]] = {
        val initialState = State(columnId2Header = Map.empty)
        foldLeft(acc = URIO.succeed(initialState), documentPathColumnId = documentPathColumnId, tailCells = cells)
            .map(_.columnId2Header)
    }

    def tryParseSheetName(sheet: XSSFSheet): RIO[Logging with Has[WorkbookUpdater], String] = {
        ZIO.fromOption(tryMatch(sheet.getSheetName, ReportSheetHeaders.regexPattern, ReportSheetHeaders.regexPatternGroup))
            .tapError(_ => SE.unableParseSheetName(sheet))
            .orElseFail(new Throwable)
    }

    @tailrec
    private def foldLeft(acc: URIO[Logging with Has[WorkbookUpdater], State],
                         documentPathColumnId: Int,
                         tailCells: List[XSSFCell])
    : URIO[Logging with Has[WorkbookUpdater], State] = {
        tailCells match {
            case Nil => acc
            case ::(cell, tl) =>
                val newAcc = for {
                    prevState <- acc
                    newState <- getNewState(cell, documentPathColumnId)
                } yield prevState.merge(newState)
                foldLeft(newAcc, documentPathColumnId, tl)
        }
    }

    private case class State(columnId2Header: Map[Int, MetadataColumnHeader]) { self =>
        def merge(newState: State): State = State(columnId2Header = this.columnId2Header ++ newState.columnId2Header)
    }

    private def getNewState(cell: XSSFCell,
                            documentPathColumnId: Int): URIO[Logging with Has[WorkbookUpdater], State] = {
        (for {
            value <- getSingleNonEmptyStringCellValue(cell)
            state <- ZIO.fromOption(parseHeader(cell, value, documentPathColumnId))
                .mapBoth(
                    _ => new Throwable,
                    columnHeader => State(columnId2Header = Map(cell.getColumnIndex -> columnHeader))
                ).tapError(_ => SE.unableParseColumnHeader(value, cell.getSheet))
        } yield state)
            .catchAll(_ => ZIO.succeed(State(Map.empty)))
    }

    private def parseHeader(cell: XSSFCell,
                            cellValue: String,
                            documentPathColumnId: Int): Option[MetadataColumnHeader] = {
        val trimmedCellValue = cellValue.trim
        MetadataColumnHeaders.Metadata.ExternalUrl.tryMatch(trimmedCellValue).map(_ => return Some(MetadataExternalUrl(documentPathColumnId, cell)))
        MetadataColumnHeaders.Metadata.PublicationDate.tryMatch(trimmedCellValue).map(_ => return Some(MetadataPublicationDate(documentPathColumnId, cell)))
        MetadataColumnHeaders.Metadata.PublicationAuthor.tryMatch(trimmedCellValue).map(_ => return Some(MetadataPublicationAuthor(documentPathColumnId, cell)))
        MetadataColumnHeaders.Metadata.Description.tryMatch(trimmedCellValue).map(_ => return Some(MetadataDescription(documentPathColumnId, cell)))
        None
    }
}

