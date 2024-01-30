package report_main.reportHandler.types.parsedExcel.reportExcel.link

import report_main.reportHandler.excel.Cell
import Link.LinkIdentifier
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.ConceptOrLinkMetadata

case class LinkMainInfo(linkIdentifier: LinkIdentifier,
                        linkCells: List[Cell],
                        metadata: ConceptOrLinkMetadata)
