package report_main.reportHandler.excel.reader

import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.generated.kb_api.graphql.{DateTimeValueInput, DoubleValueInput, GeoPointInput, IntValueInput, LinkValueInput, Locale, StringLocaleValueInput, StringValueInput}
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.regex.PropertyRegex.GeoProperty
import report_main.reportHandler.utils.StringNormalizer
import zio.logging.Logging
import zio.{Has, RIO, Task, UIO, ZIO}

import scala.util.Try

object ValueInputReader {
    import report_main.reportHandler.regex.DateTimeRegex._
    import report_main.reportHandler.regex.PropertyRegex.MainProperty._
    import report_main.reportHandler.sideEffects.excelReader.{ValueInputReaderSE => SE}

    private def splitAndTrim(str: String): List[String] =
        str.split(";").map(_.trim).filter(_.nonEmpty).toList

    private def getDoublePlainString(value: String) = {
        val bdString = BigDecimal.decimal(value.toDouble).bigDecimal.toPlainString
        val splitValues = bdString.split('.').toList
        if (splitValues.length == 2 && splitValues(1).toInt == 0) splitValues.head
        else bdString
    }

    def tryGetStringValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[StringValueInput]] = {
        val getStringValues: List[String] => RIO[Logging, List[StringValueInput]] = { stringValues =>
            ZIO.succeed(stringValues.map(stringValue => StringValueInput(StringNormalizer.normalize(stringValue))))
        }
        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty =>
                getStringValues(splitAndTrim(cell.getStringCellValue))
            case CellType.NUMERIC => getStringValues(splitAndTrim(cell.getNumericCellValue.toString).map(getDoublePlainString))
            case _ => SE.unableGetStringValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetStringLocaleValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[StringLocaleValueInput]] = {
        val getStringLocalValues: List[String] => RIO[Logging, List[StringLocaleValueInput]] = { stringValues =>
            ZIO.succeed(stringValues.map(stringValue => StringLocaleValueInput(value = StringNormalizer.normalize(stringValue), locale = Locale.other)))
        }
        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty => getStringLocalValues(splitAndTrim(cell.getStringCellValue))
            case CellType.NUMERIC => getStringLocalValues(splitAndTrim(cell.getNumericCellValue.toString).map(getDoublePlainString))
            case _ => SE.unableGetStringLocaleValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetLinkValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[LinkValueInput]] = {
        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty =>
                ZIO.succeed(splitAndTrim(cell.getStringCellValue).map(value => LinkValueInput(StringNormalizer.normalize(value))))
            case _ => SE.unableGetLinkValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetDateTimeValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[DateTimeValueInput]] = {
        lazy val tryParseDateTimeCellValue: String => Option[DateTimeValueInput] = { value =>
            YearRegex.tryMatch(value).orElse {
                MonthYearRegex.tryMatch(value).orElse {
                    DayMonthYearRegex.tryMatch(value)
                }
            }
        }

        val parseStringDates: List[String] => RIO[Logging, List[DateTimeValueInput]] = { dates =>
            val dateTimeValueInputs = dates.map(tryParseDateTimeCellValue)
            if (dateTimeValueInputs.exists(_.isEmpty)) RIO.fail(new Throwable)
            else RIO.succeed(dateTimeValueInputs.flatten)
        }

        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty => parseStringDates(splitAndTrim(cell.getStringCellValue))
                .tapError(_ => SE.unableParseDateTimeValue(cell))
            case CellType.NUMERIC => parseStringDates(splitAndTrim(cell.getNumericCellValue.toString))
                .tapError(_ => SE.unableParseDateTimeValue(cell))
            case _ => SE.unableGetDateTimeValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetGeoValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], GeoPointInput] = {
        def tryParseGeoCellValue(value: String): Task[GeoPointInput] = {
            val maybeName = GeoProperty.tryMatchGeoName(value).map(_.trim).filter(_.nonEmpty).map(StringNormalizer.normalize)
            val maybeInsideBraces = GeoProperty.tryMatchBraces(value)
            val maybePoint = maybeInsideBraces.flatMap(GeoProperty.tryMatchCoordinates)
            if (maybePoint.isEmpty && (maybeName.isEmpty || maybeInsideBraces.isDefined)) ZIO.fail(new Throwable)
            else UIO.succeed(GeoPointInput(name = maybeName, point = maybePoint))
        }


        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty =>
                tryParseGeoCellValue(cell.getStringCellValue).tapError(_ => SE.unableParseGeo(cell))
            case _ => SE.unableGetGeoValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetIntValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[IntValueInput]] = {
        val getIntValues: List[String] => RIO[Logging, List[IntValueInput]] = { stringValues =>
            val maybeIntValues = stringValues.map { stringValue =>
                if (stringValue.forall(_.isDigit)) Some(IntValueInput(stringValue.toInt))
                else None
            }
            if (maybeIntValues.exists(_.isEmpty)) RIO.fail(new Throwable)
            else RIO.succeed(maybeIntValues.flatten)
        }

        cell.getCellType match {
            case CellType.NUMERIC if cell.getNumericCellValue.isValidInt => RIO.succeed(List(IntValueInput(cell.getNumericCellValue.toInt)))
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty => getIntValues(splitAndTrim(cell.getStringCellValue))
                .tapError(_ => SE.unableParseInt(cell))
            case _ => SE.unableGetIntValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetDoubleValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[DoubleValueInput]] = {
        val getDoubleValues: List[String] => RIO[Logging, List[DoubleValueInput]] = { stringValues =>
            val maybeDoubleValues = stringValues.map(stringValue => Try(stringValue.toDouble).toOption.map(DoubleValueInput(_)))
            if (maybeDoubleValues.exists(_.isEmpty)) RIO.fail(new Throwable)
            else RIO.succeed(maybeDoubleValues.flatten)
        }
        cell.getCellType match {
            case CellType.NUMERIC => RIO.succeed(List(DoubleValueInput(cell.getNumericCellValue)))
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty => getDoubleValues(splitAndTrim(cell.getStringCellValue))
                .tapError(_ => SE.unableParseDouble(cell))
            case _ => SE.unableGetDoubleValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetBooleanValueInput(cell: XSSFCell): RIO[Logging with Has[WorkbookUpdater], List[Boolean]] = {
        def tryGetBoolean(stringValue: String): Option[Boolean] = {
            tryMatchIsMain(stringValue).map(_ => true).orElse {
                tryMatchNotMain(stringValue).map(_ => false)
            }
        }

        lazy val getBooleanValues: List[String] => RIO[Logging, List[Boolean]] = { stringValues =>
            val maybeBooleanValues = stringValues.map(tryGetBoolean)
            if (maybeBooleanValues.exists(_.isEmpty)) RIO.fail(new Throwable)
            else RIO.succeed(maybeBooleanValues.flatten)
        }

        cell.getCellType match {
            case CellType.STRING if cell.getStringCellValue.trim.nonEmpty => getBooleanValues(splitAndTrim(cell.getStringCellValue))
                .tapError(_ => SE.unableParseBoolean(cell))
            case _ => SE.unableGetBooleanValueInput(cell) *> RIO.fail(new Throwable)
        }
    }

    def tryGetSingleValueInput[T](cell: XSSFCell, getValueInput: XSSFCell => RIO[Logging with Has[WorkbookUpdater], List[T]]): RIO[Logging with Has[WorkbookUpdater], Option[T]] = {
        getValueInput(cell).flatMap {
            case Nil => RIO.none
            case ::(head, tl) if tl.isEmpty => RIO.some(head)
            case ::(_, tl) if tl.nonEmpty => SE.severalValues(cell) *> ZIO.fail(new Throwable)
        }
    }
}
