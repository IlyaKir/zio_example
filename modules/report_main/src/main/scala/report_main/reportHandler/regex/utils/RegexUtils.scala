package report_main.reportHandler.regex.utils

import scala.util.matching.Regex

object RegexUtils {
    def tryMatch(trimmedCellValue: String, regexPattern: Regex, regexPatternGroup: Int = 0): Option[String] = {
        regexPattern.findFirstMatchIn(trimmedCellValue).flatMap { patternMatch =>
            patternMatch.groupCount match {
                case i if i >= regexPatternGroup => Option(patternMatch.group(regexPatternGroup))
                case _ => None
            }
        }
    }
}
