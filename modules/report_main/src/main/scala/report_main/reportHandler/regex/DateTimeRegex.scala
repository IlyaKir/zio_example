package report_main.reportHandler.regex

import report_main.generated.kb_api.graphql.{DateInput, DateTimeValueInput}

import scala.util.matching.Regex

object DateTimeRegex {
    object DayMonthYearRegex {
        private val regexPattern: Regex = "\\A([1-9]|0[1-9]|1[0-9]|2[0-9]|3[0-1])\\.([1-9]|0[1-9]|1[0-2])\\.(\\d{4})\\Z".r
        private val dayPatternGroup: Int = 1
        private val monthPatternGroup: Int = 2
        private val yearPatternGroup: Int = 3

        def tryMatch(trimmedCellValue: String): Option[DateTimeValueInput] =
            tryGetDateTimeValueInput(trimmedCellValue, regexPattern, yearPatternGroup, Some(monthPatternGroup), Some(dayPatternGroup))
    }

    object MonthYearRegex {
        private val regexPattern: Regex = "\\A([1-9]|0[1-9]|1[0-2])\\.(\\d{4})\\Z".r
        private val monthPatternGroup: Int = 1
        private val yearPatternGroup: Int = 2

        def tryMatch(trimmedCellValue: String): Option[DateTimeValueInput] =
            tryGetDateTimeValueInput(trimmedCellValue, regexPattern, yearPatternGroup, Some(monthPatternGroup))
    }

    object YearRegex {
        private val regexPattern: Regex = "\\A(\\d{4})(\\.0)?\\Z".r
        private val yearPatternGroup: Int = 1

        def tryMatch(trimmedCellValue: String): Option[DateTimeValueInput] =
            tryGetDateTimeValueInput(trimmedCellValue, regexPattern, yearPatternGroup)
    }

    private def tryGetDateTimeValueInput(trimmedCellValue: String,
                                         regex: Regex,
                                         yearGroup: Int,
                                         maybeMonthGroup: Option[Int] = None,
                                         maybeDayGroup: Option[Int] = None): Option[DateTimeValueInput] = {
        regex.findFirstMatchIn(trimmedCellValue).flatMap { patternMatch =>
            patternMatch.groupCount match {
                case i if i >= yearGroup =>
                    val year = patternMatch.group(yearGroup).toInt
                    val maybeMonth = maybeMonthGroup.map(monthGroup => patternMatch.group(monthGroup).toInt)
                    val maybeDay = maybeDayGroup.map(dayGroup => patternMatch.group(dayGroup).toInt)
                    Some(DateTimeValueInput(date = DateInput(Some(year), maybeMonth, maybeDay)))
                case _ => None
            }
        }
    }
}
