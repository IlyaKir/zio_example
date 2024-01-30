package report_main.reportHandler.types.parsedExcel.reportExcel.property

import report_main.generated.kb_api.graphql.ValueInput
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.columnHeaders.kb.KBPropertyType
import report_main.reportHandler.utils.PropertyId

case class Property(propertyId: PropertyId,
                    mainInfo: PropertyMainInfo,
                    dependencyInfo: PropertyDependencyInfo) {
    //private def isPropertyCellsChanged: Boolean = mainInfo.propertyCells.map(_.commentKBId).exists(_.isEmpty)

    //def isPropertyChanged: Boolean = isPropertyCellsChanged
    val noCommentPropertyCells: List[Cell] = mainInfo.propertyCells.filter(_.maybeParsedComment.isEmpty)
}

object Property {
    case class PropertyIdentifier(valueInput: ValueInput, kbPropertyType: KBPropertyType)
}
