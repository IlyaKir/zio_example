package report_main.reportHandler.regex

import report_main.generated.kb_api.graphql.{CoordinatesInput, GeoPointInput}
import report_main.reportHandler.regex.utils.RegexUtils

object PropertyRegex {
    object MainProperty {
        private val isMainRegexPattern = "\\A\\s*[Дд][Аа]\\s*\\Z".r
        private val notMainRegexPattern = "\\A\\s*[Нн][Ее][Тт]\\s*\\Z".r

        def tryMatchIsMain(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, isMainRegexPattern)
        def tryMatchNotMain(trimmedCellValue: String): Option[String] = RegexUtils.tryMatch(trimmedCellValue, notMainRegexPattern)
    }

    object GeoProperty {
        private val nameRegex = "[^{]*".r
        private val geoRegexPattern = s"\\A\\s*($nameRegex)?\\s*(\\{(.*)\\})?\\s*\\Z".r
        private val namePatternGroup = 1
        private val bracesPatternGroup = 3

        private val coordinateRegex = "[+-]?\\d+([.]\\d+)?".r
        private val pointRegex = s"\\A\\s*($coordinateRegex)\\s*;\\s*($coordinateRegex)\\s*\\Z".r
        private val latitudePatternGroup = 1
        private val longitudePatternGroup = 3

        def tryMatchGeoName(value: String): Option[String] =
            RegexUtils.tryMatch(value, geoRegexPattern, namePatternGroup)
        def tryMatchBraces(value: String): Option[String] = {
            RegexUtils.tryMatch(value, geoRegexPattern, bracesPatternGroup)
        }
        def tryMatchCoordinates(value: String): Option[CoordinatesInput] = {
            RegexUtils.tryMatch(value, pointRegex, latitudePatternGroup).flatMap { latitude =>
                RegexUtils.tryMatch(value, pointRegex, longitudePatternGroup).map { longitude =>
                    CoordinatesInput(latitude = latitude.toDouble, longitude = longitude.toDouble)
                }
            }
        }
    }
}
