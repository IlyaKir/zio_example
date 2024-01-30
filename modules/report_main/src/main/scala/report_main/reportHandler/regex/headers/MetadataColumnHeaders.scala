package report_main.reportHandler.regex.headers

import scala.util.matching.Regex

object MetadataColumnHeaders {
    import report_main.reportHandler.regex.utils.RegexUtils

    object DocumentPath {
        private val regexPattern: Regex = "\\A[Нн]азвани[ея]\\s*[Фф]айл[а|ов]\\s*\\Z".r
        def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
    }

    object Metadata {
        object ExternalUrl {
            private val regexPattern: Regex = "\\A\\s*[Ии]сточник\\s*\\Z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }
        object PublicationDate {
            private val regexPattern: Regex = "\\A\\s*[Дд]ата\\s*[Пп]убликации\\s*\\Z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }
        object PublicationAuthor {
            private val regexPattern: Regex = "\\A\\s*[Аа]втор\\s*[Пп]убликации\\s*\\Z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }
        object Description {
            private val regexPattern: Regex = "\\A\\s*[Оо]писани[ея]\\s*\\Z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }
    }
}
