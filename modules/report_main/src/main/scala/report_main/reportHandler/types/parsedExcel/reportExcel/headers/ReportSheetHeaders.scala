package report_main.reportHandler.types.parsedExcel.reportExcel.headers

import org.apache.poi.xssf.usermodel.XSSFSheet
import report_main.reportHandler.types.columnHeaders.report._
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.ReportSheetHeaders.MetadataColumnIds

import scala.util.matching.Regex

case class ReportSheetHeaders(sheet: XSSFSheet,
                              conceptTypeName: String,
                              metadataNameColumnId: Int,
                              metadataColumnIds: MetadataColumnIds,
                              columnId2columnHeader: Map[Int, ReportColumnHeader]) extends SheetHeaders {
    private lazy val metadataFromColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.metadataFrom => columnId }.toSet
    private lazy val metadataToColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.metadataTo => columnId }.toSet
    private lazy val metadataNotesColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.metadataNotes => columnId }.toSet
    private lazy val metadataIsMainColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.metadataIsMain => columnId }.toSet

    private lazy val metadataFromColumnHeaders: List[MetadataFrom] = metadataFromColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[MetadataFrom]).toList
    private lazy val metadataToColumnHeaders: List[MetadataTo] = metadataToColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[MetadataTo]).toList
    private lazy val metadataNotesColumnHeaders: List[MetadataNotes] = metadataNotesColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[MetadataNotes]).toList
    private lazy val metadataIsMainColumnHeaders: List[MetadataIsMain] = metadataIsMainColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[MetadataIsMain]).toList

    lazy val objectColumnId2MetadataFromColumnHeader: Map[Int, MetadataFrom] = metadataFromColumnHeaders
        .map(metadataFromColumnHeader => metadataFromColumnHeader.objectColumnId -> metadataFromColumnHeader).toMap
    lazy val objectColumnId2MetadataToColumnHeader: Map[Int, MetadataTo] = metadataToColumnHeaders
        .map(metadataToColumnHeader => metadataToColumnHeader.objectColumnId -> metadataToColumnHeader).toMap
    lazy val objectColumnId2MetadataNotesColumnHeader: Map[Int, MetadataNotes] = metadataNotesColumnHeaders
        .map(metadataNotesColumnHeader => metadataNotesColumnHeader.objectColumnId -> metadataNotesColumnHeader).toMap
    lazy val propertyColumnId2MetadataIsMainColumnHeader: Map[Int, MetadataIsMain] = metadataIsMainColumnHeaders
        .map(metadataIsMainColumnHeader => metadataIsMainColumnHeader.objectColumnId -> metadataIsMainColumnHeader).toMap

    lazy val documentColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (_, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.document =>
            columnHeader.cell.getColumnIndex
        }.toSet
    lazy val conceptPropertyColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.conceptProperty => columnId }.toSet
    lazy val conceptPropertyColumnHeaders: List[ConceptProperty] = conceptPropertyColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[ConceptProperty]).toList

    lazy val linkColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.link => columnId }.toSet
    lazy val linkColumnHeaders: List[Link] = linkColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[Link]).toList

    lazy val linkPropertyColumnIds: Set[Int] = columnId2columnHeader
        .collect { case (columnId, columnHeader) if columnHeader.columnType == ReportColumnHeaderType.linkProperty => columnId }.toSet
    lazy val linkPropertyColumnHeaders: List[LinkProperty] = linkPropertyColumnIds
        .map(id => columnId2columnHeader(id).asInstanceOf[LinkProperty]).toList

    lazy val linkColumnId2LinkPropertyColumnHeaders: Map[Int, List[LinkProperty]] = linkPropertyColumnHeaders
        .groupBy(_.linkColumnId).view.mapValues(_.toList).toMap
}

object ReportSheetHeaders {
    val regexPattern: Regex = "\\A([^(]*)\\((.*)\\)".r
    val regexPatternGroup: Int = 2

    case class MetadataColumnIds(metadataNotes: Option[Int],
                                 metadataFrom: Option[Int],
                                 metadataTo: Option[Int],
                                 metadataAvatar: Option[Int])
}
