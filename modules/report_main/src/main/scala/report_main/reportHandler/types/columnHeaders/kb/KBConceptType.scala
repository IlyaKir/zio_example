package report_main.reportHandler.types.columnHeaders.kb

import report_main.reportHandler.types.columnHeaders.kb.KBObjectType.KBObjectType
import common.types.ID

case class KBConceptType(id: ID, name: String) extends KBType {
    val objectType: KBObjectType = KBObjectType.concept
}
