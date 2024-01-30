package report_main.reportHandler.sideEffects

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.layers.WorkbookUpdater
import zio.{Has, URIO, ZIO}
import zio.logging._

object DocumentUploaderSE {
    def gettingPathDependencies: URIO[Logging, Unit] = log.info("Getting document paths dependencies")

    def uploadingDocuments: URIO[Logging, Unit] = log.info("Uploading documents")

    def gettingDocumentIdDependencies: URIO[Logging, Unit] = log.info("Getting documentId dependencies")


    private def incorrectPaths(message: String, incorrectExcelPathsWithCells: Map[String, List[XSSFCell]]): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        log.error(s"$message").when(incorrectExcelPathsWithCells.nonEmpty) *>
            ZIO.collectAllSuccesses(incorrectExcelPathsWithCells.map { case (incorrectPath, cells) =>
                log.error(s"\t$incorrectPath") *> ZIO.collectAllSuccesses(cells.map(WorkbookUpdater.colorCellGrey))
            }).unit
    }

    def incorrectReportExcelDocumentPaths(incorrectExcelPathsWithCells: Map[String, List[XSSFCell]]): URIO[Logging with Has[WorkbookUpdater], Unit] =
        incorrectPaths(message = "Incorrect report excel document paths:", incorrectExcelPathsWithCells)

    def incorrectMetadataExcelDocumentPaths(incorrectExcelPathsWithCells: Map[String, List[XSSFCell]]): URIO[Logging with Has[WorkbookUpdater], Unit] =
        incorrectPaths(message = "Incorrect metadata excel document paths:", incorrectExcelPathsWithCells)
}
