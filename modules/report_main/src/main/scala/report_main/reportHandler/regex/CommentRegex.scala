package report_main.reportHandler.regex

import common.types.ID
import scala.util.matching.Regex
import report_main.reportHandler.regex.utils.RegexUtils

object CommentRegex {
    object SingleKBId {
        private val regexPattern: Regex = "\\A(ОК-\\d*)\\Z".r
        private val patternGroup: Int = 1

        def tryMatch(trimmedCellValue: String): Option[ID] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, patternGroup).map(ID(_))
    }

    object LinkCell {
        private val regexPattern: Regex = "\\A(ОК-\\d*)?\\s*\\{(ОК-\\d*)?\\}\\Z".r
        private val linkKBIdPatternGroup: Int = 1
        private val conceptToKBIdPatternGroup: Int = 2

        def tryMatchLinkKBId(trimmedCellValue: String): Option[ID] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, linkKBIdPatternGroup).map(ID(_))

        def tryMatchConceptKBId(trimmedCellValue: String): Option[ID] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, conceptToKBIdPatternGroup).map(ID(_))
    }
}
