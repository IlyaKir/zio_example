package report_main.reportHandler.excel.colorRemover

import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.mainFiles.{ExcelWorkbook, MainFiles}
import zio.logging._
import zio.{Has, RIO, ZIO}
import zio.magic._

object WorkbookColorRemover {
    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.getSingleXSSFCell

    def removeColors(mainFiles: MainFiles): RIO[Logging with Has[ReportWorkbookUpdater] with Has[MetadataWorkbookUpdater], Unit] = {
        for {
            _ <- remove(mainFiles.reportWorkbook)
                .injectSome[Logging with Has[ReportWorkbookUpdater]](ReportWorkbookUpdater.workbookUpdaterLayer)
            _ <- remove(mainFiles.maybeMetadataWorkbook.get).when(mainFiles.maybeMetadataWorkbook.nonEmpty)
                .injectSome[Logging with Has[MetadataWorkbookUpdater]](MetadataWorkbookUpdater.workbookUpdaterLayer)
        } yield ()
    }

    private def remove(excelWorkbook: ExcelWorkbook): RIO[Logging with Has[WorkbookUpdater], Unit] = {
        val xssfWorkbook = excelWorkbook.workbook
        ZIO.collectAllSuccesses(List.range(0, xssfWorkbook.getNumberOfSheets).map(xssfWorkbook.getSheetAt).flatMap { sheet =>
            List.range(sheet.getFirstRowNum, sheet.getLastRowNum + 1).flatMap(rowNum => Option(sheet.getRow(rowNum))).flatMap { row =>
                List.range(row.getFirstCellNum, row.getLastCellNum).map { cellId =>
                    getSingleXSSFCell(row, cellId).flatMap(WorkbookUpdater.colorCellWhite)
                }
            }
        }).unit
    }
}
