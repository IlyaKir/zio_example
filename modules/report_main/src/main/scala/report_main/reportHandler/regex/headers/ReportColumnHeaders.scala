package report_main.reportHandler.regex.headers

import scala.util.matching.Regex

object ReportColumnHeaders {
    import report_main.reportHandler.regex.utils.RegexUtils

    object Document {
        private val regexPattern: Regex = "\\A[Пп]одтверждающи[йе]\\s*[Дд]окументы?".r
        def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
    }

    object ConceptProperty {
        private val regexPattern: Regex = "\\A[Хх]арактеристика\\s*:\\s*(.*)".r
        private val patternGroup: Int = 1

        def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, patternGroup)
    }

    object Link {
        private val regexPattern: Regex = "\\A[СсCc]вязь\\s*:\\s*([^{]*)\\{?([^}]*)".r
        private val linkTypePatternGroup: Int = 1
        private val conceptTypePatternGroup: Int = 2

        def tryMatchLinkType(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, linkTypePatternGroup)
        def tryMatchConceptType(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, conceptTypePatternGroup)

    }

    object LinkProperty {
        private val regexPattern: Regex = "\\A[Хх]арактеристика\\s*[Сс]вязи\\s*:\\s*(.*)".r
        private val patternGroup: Int = 1

        def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern, patternGroup)
    }

    object Metadata {
        object Name {
            private val regexPattern: Regex = "\\A\\s*[Мм]етадата\\s*:\\s*[Нн]азвание\\s*\\Z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }

        object Avatar {
            private val regexPattern: Regex = "\\A[Мм]етадата\\s*:\\s*[Аа]ватар\\s*\\z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }

        object From {
            private val regexPattern: Regex = "\\A[Мм]етадата\\s*:\\s*[СсCc]\\s*\\z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }

        object To {
            private val regexPattern: Regex = "\\A[Мм]етадата\\s*:\\s*[Пп][Оо]\\s*\\z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }

        object IsMain {
            private val regexPattern: Regex = "\\A[Мм]етадата\\s*:\\s*[Оо]сновн[аы][яе]\\s*[Хх]арактеристик[аи]\\s*\\z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }

        object Notes {
            private val regexPattern: Regex = "\\A[Мм]етадата\\s*:\\s*[Зз]аметк[иа]\\s*\\z".r
            def tryMatch(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, regexPattern)
        }
    }
}
