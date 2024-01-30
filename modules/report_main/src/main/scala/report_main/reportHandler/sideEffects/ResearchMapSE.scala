package report_main.reportHandler.sideEffects

import zio.URIO
import zio.logging._

object ResearchMapSE {
    def getPaginationResearchMapError(error: Throwable): URIO[Logging, Unit] =
        log.error(s"Error occurred while getPaginationResearchMap request: ${error.getMessage}")

    def researchMapAlreadyExists(id: String, name: String): URIO[Logging, Unit] =
        log.debug(s"ResearchMap $name already exists in KB with id $id")

    def addResearchMapRequestFailed(error: Throwable): URIO[Logging, Unit] =
        log.error(s"Error occurred while addResearchMap request: ${error.getMessage}")

    def updateResearchMapRequestFailed(error: Throwable): URIO[Logging, Unit] =
        log.error(s"Error occurred while updateResearchMap request: ${error.getMessage}")
}
