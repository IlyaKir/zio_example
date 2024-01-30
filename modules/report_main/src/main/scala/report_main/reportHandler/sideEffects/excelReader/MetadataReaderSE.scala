package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.sideEffects.SideEffectsUtils
import zio.logging._
import zio.{Has, URIO}

object MetadataReaderSE extends SideEffectsUtils {
    def unableParseMetadataNameColumn(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to parse metadataName column ${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)

    def unableReadMetadata(cell: XSSFCell): URIO[Logging with Has[WorkbookUpdater], Unit] =
        log.error(s"Unable to read metadata value ${getCellAddress(cell)}") *> WorkbookUpdater.colorCellGrey(cell)
}
