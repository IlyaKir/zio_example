package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.sideEffects.SideEffectsUtils
import zio.logging._
import zio.{Has, URIO}

object ValueInputReaderSE extends SideEffectsUtils {
    private def unableGetValueInput(cell: XSSFCell, valueInputName: String): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to get $valueInputName:${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)

    private def unableParseValue(cell: XSSFCell, valueName: String): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to parse $valueName:${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)

    def unableGetStringValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "StringValueInput")
    def unableGetStringLocaleValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "StringLocaleValueInput")
    def unableGetLinkValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "LinkValueInput")
    def unableGetDateTimeValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "DateTimeValueInput")
    def unableGetGeoValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "GeoValueInput")
    def unableGetIntValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "IntValueInput")
    def unableGetDoubleValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "DoubleValueInput")
    def unableGetBooleanValueInput(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableGetValueInput(cell, valueInputName = "BooleanValueInput")

    def unableParseDateTimeValue(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableParseValue(cell, "DateTime")
    def unableParseInt(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableParseValue(cell, "Int")
    def unableParseDouble(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableParseValue(cell, "Double")
    def unableParseBoolean(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableParseValue(cell, "Boolean")
    def unableParseGeo(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] = unableParseValue(cell, "Geo")
    def severalValues(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"There are several values (but expected one):${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)
}
