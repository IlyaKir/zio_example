package report_main.reportHandler.types.parsedExcel.reportExcel.concept

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.columnHeaders.kb.KBConceptType
import report_main.reportHandler.utils.ConceptId

case class Concept(conceptId: ConceptId,
                   mainInfo: ConceptMainInfo,
                   dependencyInfo: ConceptDependencyInfo) {
    def thereAreParsedCommentCells: Boolean = mainInfo.metadataNameCells.exists(_.maybeParsedComment.nonEmpty)

    val noCommentMetadataNameCells: List[Cell] = mainInfo.metadataNameCells.filter(_.maybeParsedComment.isEmpty)
    val noCommentLinkCells: List[Cell] = mainInfo.linkCells.filter(_.maybeParsedComment.isEmpty)
//    lazy val avatarsChanged: Boolean = dependencyInfo.maybeAvatar.exists(_.sendToActor)
//    lazy val documentsChanged: Boolean = dependencyInfo.documents.map(_.sendToActor).foldLeft(false)(_ || _)

    //private def isMetadataNameCellsChanged: Boolean = mainInfo.metadataNameCells.map(_.commentKBId).exists(_.isEmpty)
    //private def isLinkCellsChanged: Boolean = mainInfo.linkCells.map(_.commentKBId).exists(_.isEmpty)

    //def isConceptChanged: Boolean = isMetadataNameCellsChanged || isLinkCellsChanged
}

object Concept {
    case class ConceptIdentifier(name: String, kbType: KBConceptType)
}
