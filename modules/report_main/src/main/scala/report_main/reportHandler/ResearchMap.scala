package report_main.reportHandler

import report_main.generated.kb_api.graphql.ResearchMapUpdateInput
import report_main.reportHandler.http.KBMutations
import report_main.reportHandler.layers.ReportHttpRequestSender
import report_main.utils.ZipReaderUtils.ZipFileWithEntries
import common.types.ID
import zio.logging._
import zio.{Has, RIO, ZIO}

object ResearchMap {

    import report_main.reportHandler.sideEffects.{ResearchMapSE => SE}

    /**
     * @return researchMapId
     */
    def getOrCreateResearchMap(zipFileWithEntries: ZipFileWithEntries,
                               maybeAccessLevelId: Option[ID]): RIO[Logging with Has[ReportHttpRequestSender], ID] = {
        val researchMapName = zipFileWithEntries.fileNameWithoutExt

        ReportHttpRequestSender.getPaginationResearchMap(researchMapName)
            .tapError(SE.getPaginationResearchMapError)
            .flatMap { responseResearchMap =>
                responseResearchMap.find(_.name == researchMapName) match {
                    case Some(responseResearchMap) =>
                        SE.researchMapAlreadyExists(id = responseResearchMap.id, name = researchMapName).as(ID(responseResearchMap.id))
                    case None =>
                        for {
                            researchMapId <- ReportHttpRequestSender
                                .addResearchMap(KBMutations.addResearchMap(zipFileWithEntries.fileNameWithoutExt))
                                .tapError(SE.addResearchMapRequestFailed)
                            _ <- maybeAccessLevelId.map { accessLevelId =>
                                ReportHttpRequestSender
                                    .updateResearchMap(KBMutations.updateResearchMap(researchMapId, ResearchMapUpdateInput(name = zipFileWithEntries.fileNameWithoutExt, accessLevelId = accessLevelId.id)))
                                    .tapError(SE.updateResearchMapRequestFailed).unit
                            }.getOrElse(ZIO.unit)
                        } yield researchMapId
                }
            }
    }
}
