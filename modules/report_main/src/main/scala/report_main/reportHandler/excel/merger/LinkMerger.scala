package report_main.reportHandler.excel.merger

import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.link.{Link, LinkDependencyInfo, LinkMainInfo, SingleSheetLink}
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.ConceptOrLinkMetadata
import report_main.reportHandler.utils.LinkId
import zio.{Has, URIO}
import zio.logging.Logging

import java.util.UUID

case class LinkMerger(link: SingleSheetLink) {
    import report_main.reportHandler.excel.merger.MergerUtils._

    def merge: URIO[Logging with Has[WorkbookUpdater], Link] = {
        for {
            maybeMetadataNotes <- mergeMetadata(link.metadataNotes)
            maybeMetadataFrom <- mergeMetadata(link.metadataFrom)
            maybeMetadataTo <- mergeMetadata(link.metadataTo)
            metadata = ConceptOrLinkMetadata(maybeMetadataNotes = maybeMetadataNotes, maybeMetadataFrom = maybeMetadataFrom, maybeMetadataTo = maybeMetadataTo)

            documents <- mergeDocuments2ReportExcelDocuments(link.documents)
            properties <- URIO.collectAllSuccesses(link.properties.map(PropertyMerger(_).merge))

            mainInfo = LinkMainInfo(linkIdentifier = link.linkIdentifier, linkCells = link.linkCells, metadata = metadata)
            id = {
                val maybeKBId = mainInfo.linkCells.flatMap(_.maybeParsedComment).headOption
                maybeKBId.map(LinkId(_)).getOrElse(LinkId(UUID.randomUUID()))
            }
            dependencyInfo = LinkDependencyInfo(properties = properties, documents = documents)
        } yield Link(id, mainInfo, dependencyInfo)
    }
}
