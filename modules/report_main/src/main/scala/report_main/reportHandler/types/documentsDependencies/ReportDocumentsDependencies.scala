package report_main.reportHandler.types.documentsDependencies

import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.document.ReportExcelDocument
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import report_main.reportHandler.utils.DocumentId

case class ReportDocumentsDependencies(avatarId2Concepts: Map[DocumentId, List[Concept]],
                                       documentId2Concepts: Map[DocumentId, List[Concept]],
                                       documentId2ConceptProperties: Map[DocumentId, List[Property]],
                                       documentId2Links: Map[DocumentId, List[Link]],
                                       documentId2LinkProperties: Map[DocumentId, List[Property]],
                                       documentId2Documents: Map[DocumentId, ReportExcelDocument])
