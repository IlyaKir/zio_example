package report_main.reportHandler

import org.apache.poi.ss.usermodel.CellCopyPolicy
import report_main.reportHandler.KBHeadersGetter._
import report_main.reportHandler.excel.colorRemover.WorkbookColorRemover.removeColors
import report_main.reportHandler.excel.reader.headers.ReportHeadersReader
import report_main.reportHandler.excel.writer.ExcelWriter
import report_main.reportHandler.layers.{MetadataWorkbookUpdater, ReportDocumentUploader, ReportHttpRequestSender, ReportWorkbookUpdater}
import report_main.reportHandler.mainFilesGetter.MainFilesGetter.getMainFiles
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.SheetKBHeaders
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import zio.clock.Clock
import zio.logging._
import zio.magic._
import zio.random.Random
import zio.{Has, RIO, Semaphore, ZIO, ZLayer}

case class ReportMultiplier(zipFileWithEntries: ZipFileWithEntries, n: Int = 2) {
    private val reportUpdateThreads: Int = 1
    private val metadataUpdateThreads: Int = 1

    def multiply: RIO[Logging with Random with Clock with Has[ReportHttpRequestSender] with Has[ReportDocumentUploader], ReportHandlerResult] = {
        for {
            mainFiles <- getMainFiles(zipFileWithEntries)

            reportWorkbookUpdaterSemaphore <- Semaphore.make(permits = reportUpdateThreads)
            reportWorkbookUpdaterLayer = (ZLayer.succeed(mainFiles.reportWorkbook) ++ ZLayer.succeed(reportWorkbookUpdaterSemaphore)) >>>
                ReportWorkbookUpdater.layer

            metadataWorkbookUpdaterSemaphore <- Semaphore.make(permits = metadataUpdateThreads)
            metadataWorkbookUpdaterLayer = (ZLayer.succeed(mainFiles.maybeMetadataWorkbook) ++ ZLayer.succeed(metadataWorkbookUpdaterSemaphore)) >>>
                MetadataWorkbookUpdater.layer

            resultAction = for {
                headers <- ReportHeadersReader.readHeaders(mainFiles.reportWorkbook)
                kbHeaders <- getKBHeaders(headers)

                _ <- removeColors(mainFiles)
                _ = copyCells(kbHeaders)

                reportWorkbookResult <- ExcelWriter(mainFiles.reportWorkbook).write.map { case (name, byteArray) => ReportWorkbookResult(name, byteArray) }
                maybeMetadataWorkbookResult <- (mainFiles.maybeMetadataWorkbook match {
                    case Some(metadataWorkbook) => ExcelWriter(metadataWorkbook).write.map(Some(_))
                    case None => ZIO.none
                }).map(_.map { case (name, byteArray) => MetadataWorkbookResult(name, byteArray) })
            } yield ReportHandlerResult(reportWorkbookResult = reportWorkbookResult, maybeMetadataWorkbookResult = maybeMetadataWorkbookResult)

            result <- resultAction
                .injectSome[Logging with Random with Clock with Has[ReportHttpRequestSender] with Has[ReportDocumentUploader]](reportWorkbookUpdaterLayer, metadataWorkbookUpdaterLayer)
        } yield result
    }

    private def copyCells(sheetsKBHeaders: Seq[SheetKBHeaders]): Unit = {
        sheetsKBHeaders.foreach { sheetKBHeaders =>
            val sheet = sheetKBHeaders.sheetHeaders.sheet
            val lastRowNum = sheet.getLastRowNum
            if (lastRowNum > 0) {
                val metadataNameAndLinkColumnIds: Set[Int] = (sheetKBHeaders.columnId2KBLinkType.keys.toSeq :+ sheetKBHeaders.sheetHeaders.metadataNameColumnId).toSet
                val lastColumnNum = (sheetKBHeaders.sheetHeaders.columnId2columnHeader.keys.toSeq :+ -1).max
                if (lastColumnNum >= 0) {
                    val cellCopyPolicy = new CellCopyPolicy()
                    val originalRows = Seq.range(1, lastRowNum + 1).flatMap(row => Option(sheet.getRow(row)))

                    Seq.range(2, n + 1).foreach { n =>
                        val newLastRowNum = sheet.getLastRowNum
                        val originalAndNewRows = originalRows.map { row =>
                            val shift = newLastRowNum + 2
                            (row, sheet.createRow(row.getRowNum + shift))
                        }
                        val originalAndNewCells = originalAndNewRows.flatMap { case (originalRow, newRow) =>
                            Seq.range(0, lastColumnNum + 1).flatMap { columnNum =>
                                Option(originalRow.getCell(columnNum)).map(originalCell => (originalCell, newRow.createCell(columnNum)))
                            }
                        }
                        originalAndNewCells.foreach { case (originalCell, newCell) =>
                            newCell.copyCellFrom(originalCell, cellCopyPolicy)
                            if (metadataNameAndLinkColumnIds.contains(newCell.getColumnIndex)) {
                                val value = newCell.getStringCellValue
                                if (value.trim.nonEmpty) {
                                    newCell.setCellValue(value + s"_$n")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
