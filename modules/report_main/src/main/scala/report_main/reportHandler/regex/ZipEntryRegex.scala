package report_main.reportHandler.regex

import report_main.reportHandler.regex.utils.RegexUtils

import scala.util.matching.Regex

object ZipEntryRegex {
    object Root {
        private val regexPattern: Regex = "(.*/)[^/]*".r
        private val patternGroup: Int = 1

        def tryMatch(reportPath: String): Option[String] = RegexUtils.tryMatch(reportPath, regexPattern, patternGroup)
    }

    object ReportExcel {
        private val regexPattern: Regex = ".*[Rr][Ee][Pp][Oo][Rr][Tt][^/]*.xlsx\\z".r

        def tryMatch(path: String): Option[String] = RegexUtils.tryMatch(path, regexPattern)
    }

    object Docx {
        def tryMatch(rootPath: String, path: String): Option[String] = {
            val regexPattern: Regex = (s"\\Q${rootPath}\\E" + "[^/]*.docx\\z").r
            RegexUtils.tryMatch(path, regexPattern)
        }
    }

    object MetadataExcel {
        private val regexPattern: Regex = ".*[Mm][Ee][Tt][Aa][Dd][Aa][Tt][Aa][^/]*.xlsx\\z".r

        def tryMatch(trimmedCellValue: String): Option[String] =
            RegexUtils.tryMatch(trimmedCellValue, regexPattern)
    }
}
