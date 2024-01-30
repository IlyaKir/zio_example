package report_main.reportHandler.excel.reader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import common.types.ID
import zio.logging.Logging
import zio.{Has, RIO, Task, ZIO}

object CommentReader {
    import report_main.reportHandler.regex.CommentRegex.LinkCell._
    import report_main.reportHandler.regex.CommentRegex.SingleKBId
    import report_main.reportHandler.sideEffects.excelReader.{CommentReaderSE => SE}

    /** @return maybeKBId */
    def getSingleKBId(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], Option[ID]] = {
        getNonEmptyCommentValue(cell).either.flatMap {
            case Left(_) => ZIO.none
            case Right(commentValue) => parseComment(commentValue).tapError(_ => // TODO remove cellComment or color cell ?
                SE.unableParseSingleValueComment(cell)).map(Some(_))
        }
    }

    /** Try get KBIds separated by `;`
     *
     * If comment doesn't exists or empty then return List.empty
     *
     * If value nonEmpty then return List of these values parsed
     *
     * If at least one nonEmpty value failed while parsing then return Throwable
     */
    def getMultipleKBIds(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[Option[ID]]] = {
        getNonEmptyCommentValue(cell).either.flatMap {
            case Left(_) => ZIO.succeed(List.empty)
            case Right(commentValue) =>
                val trimmedValues = commentValue.split(';').map(_.trim).toList
                ZIO.foreach(trimmedValues) { value =>
                    if (value.isEmpty) ZIO.none
                    else parseComment(value).tapError(_ => SE.unableParseMultipleValueComment(cell)).map(Some(_))
                }
        }
    }

    def getLinkKBIds(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], Option[LinkCellComment]] = {
        getNonEmptyCommentValue(cell).either.flatMap {
            case Left(_) => ZIO.none
            case Right(commentValue) => tryParseLinkComment(commentValue)
                .tapError(_ => SE.unableParseLinkCellComment(cell)).map(Some(_))
        }
    }

    case class LinkCellComment(conceptKBId: ID, linkKBId: Option[ID])

    private def tryParseLinkComment(trimmedCellValue: String): Task[LinkCellComment] = {
        ZIO.fromOption(tryMatchConceptKBId(trimmedCellValue).map { conceptKBId =>
            val maybeLinkKBId = tryMatchLinkKBId(trimmedCellValue)
            LinkCellComment(conceptKBId, maybeLinkKBId)
        }).orElseFail(new Throwable)
    }

    private def getNonEmptyCommentValue(cell: XSSFCell): RIO[Has[WorkbookUpdater], String] = {
        Option(cell.getCellComment).flatMap(comment => Option(comment.getString.getString).map(_.trim)) match {
            case Some(value) => SE.emptyComment(cell).when(value.isEmpty).as(value)
            case None => ZIO.fail(new Throwable)
        }
    }

    private def parseComment(commentValue: String): Task[ID] =
        ZIO.fromOption(SingleKBId.tryMatch(commentValue)).orElseFail(new Throwable)
}
