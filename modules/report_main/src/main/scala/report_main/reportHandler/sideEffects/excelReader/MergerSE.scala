package report_main.reportHandler.sideEffects.excelReader

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.sideEffects.SideEffectsUtils
import zio.logging._
import zio.{Has, URIO}

object MergerSE extends SideEffectsUtils {
    private def unable2Merge(cells: List[XSSFCell], valuesName: String) = {
        log.error(s"Unable to merge different $valuesName") *>
            URIO.collectAllSuccesses(cells.map { cell =>
                log.error(getCellAddress(cell)) *> WorkbookUpdater.colorCellRed(cell)
            }).unit
    }

    def unable2MergeDiffMetadata(cells: List[Cell]): URIO[Logging with Has[WorkbookUpdater], Unit] =
        unable2Merge(cells.map(_.xssfCell), valuesName = "metadata values")

    def unable2MergeDiffAvatars(cells: List[Cell]): URIO[Logging with Has[WorkbookUpdater], Unit] =
        unable2Merge(cells.map(_.xssfCell), valuesName = "avatars")

    def unable2MergeCells(cells: List[Cell]): URIO[Logging with Has[WorkbookUpdater], Unit] =
        unable2Merge(cells.map(_.xssfCell), "cells")
}
