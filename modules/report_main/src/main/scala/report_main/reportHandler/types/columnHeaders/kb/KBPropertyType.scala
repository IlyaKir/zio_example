package report_main.reportHandler.types.columnHeaders.kb

import report_main.generated.kb_api.graphql.ValueType
import report_main.reportHandler.types.columnHeaders.kb.KBObjectType.KBObjectType
import report_main.reportHandler.types.columnHeaders.report.Property
import common.types.ID

case class KBPropertyType(id: ID, valueType: ValueType, columnHeader: Property) extends KBType {
    val objectType: KBObjectType = KBObjectType.property
}
