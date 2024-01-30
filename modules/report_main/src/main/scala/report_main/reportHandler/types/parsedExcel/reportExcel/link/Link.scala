package report_main.reportHandler.types.parsedExcel.reportExcel.link

import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.columnHeaders.kb.KBLinkType
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.utils.LinkId

case class Link(linkId: LinkId,
                mainInfo: LinkMainInfo,
                dependencyInfo: LinkDependencyInfo) {
    val noCommentCells: List[Cell] = mainInfo.linkCells.filter(_.maybeParsedComment.isEmpty)
}

object Link {
    case class LinkIdentifier(conceptFrom: Concept,
                              conceptTo: Concept,
                              kbLinkType: KBLinkType) {
        override def toString: String = s"LinkIdentifier(${conceptFrom.mainInfo.conceptIdentifier.name} -> ${conceptTo.mainInfo.conceptIdentifier.name})"
    }
}
