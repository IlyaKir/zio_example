package report_main.reportHandler.types.parsedExcel.reportExcel.concept

import Concept.ConceptIdentifier
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.ConceptOrLinkMetadata

case class ConceptMainInfo(conceptIdentifier: ConceptIdentifier,
                           metadataNameCells: List[Cell],
                           linkCells: List[Cell],
                           metadata: ConceptOrLinkMetadata)
