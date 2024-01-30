package report_main.reportHandler.sideEffects

import zio.URIO
import zio.logging._

object MainFilesGetterSE {
    def gettingPath(mainFileName: String): URIO[Logging, Unit] = log.info(s"Getting $mainFileName path")

    def mainFileNotFound(mainFileName: String): URIO[Logging, Unit] = log.warn(s"$mainFileName not found")

    def unableGetRootPath: URIO[Logging, Unit] = log.error("Unable to get root path")

    def unableGetInputStream(mainFileName: String): URIO[Logging, Unit] = log.error(s"Unable to get $mainFileName InputStream")

    def unableOpenFile(mainFileName: String): URIO[Logging, Unit] = log.error(s"Unable to open $mainFileName file")

    def gettingWorkbook(mainFileName: String): URIO[Logging, Unit] = log.info(s"Getting $mainFileName workbook")
}
