package report_main.reportHandler.excel.merger

import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.{Concept, ConceptDependencyInfo, ConceptMainInfo, SingleSheetConcept}
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.ConceptOrLinkMetadata
import report_main.reportHandler.utils.ConceptId
import zio.{Has, URIO, ZIO}
import zio.logging.Logging

import java.util.UUID

case class ConceptMerger(concepts: List[SingleSheetConcept]) {
    import report_main.reportHandler.excel.merger.MergerUtils._
    /**
     * merge concepts with the same conceptIdentifier
     *
     * @return mergedConcepts
     */
    def merge: URIO[Logging with Has[WorkbookUpdater], List[Concept]] = {
        val conceptIdentifier2Concepts = concepts.groupBy(_.conceptIdentifier).mapValues(_.toList)
        ZIO.collectAllSuccesses(conceptIdentifier2Concepts.map { case (conceptIdentifier, concepts) =>
            for {
                maybeMetadataNotes <- mergeMetadata(concepts.flatMap(_.metadataNotes))
                maybeMetadataFrom <- mergeMetadata(concepts.flatMap(_.metadataFrom))
                maybeMetadataTo <- mergeMetadata(concepts.flatMap(_.metadataTo))
                metadata = ConceptOrLinkMetadata(maybeMetadataNotes = maybeMetadataNotes,
                    maybeMetadataFrom = maybeMetadataFrom, maybeMetadataTo = maybeMetadataTo)

                maybeAvatar <- mergeAvatars(concepts.flatMap(_.avatars))
                documents <- mergeDocuments2ReportExcelDocuments(concepts.flatMap(_.documents))
                properties <- ZIO.collectAllSuccesses(concepts.flatMap(_.properties).map(PropertyMerger(_).merge))

                mainInfo = ConceptMainInfo(conceptIdentifier = conceptIdentifier, metadataNameCells = concepts.flatMap(_.metadataNameCells),
                    linkCells = concepts.flatMap(_.linkCells), metadata = metadata)
                id = {
                    val maybeKBId = mainInfo.metadataNameCells.flatMap(_.maybeParsedComment).headOption match {
                        case Some(kbId) => Some(kbId)
                        case None => mainInfo.linkCells.flatMap(_.maybeParsedComment).headOption
                    }
                    maybeKBId.map(ConceptId(_)).getOrElse(ConceptId(UUID.randomUUID()))
                }
                dependencyInfo = ConceptDependencyInfo(maybeAvatar = maybeAvatar, documents = documents, properties = properties)
            } yield Concept(id, mainInfo, dependencyInfo)
        }.toList)
    }
}
