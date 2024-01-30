package report_main.reportHandler.types.columnHeaders.kb

import report_main.reportHandler.types.columnHeaders.kb.KBObjectType.KBObjectType
import report_main.reportHandler.types.columnHeaders.report.Link
import common.types.ID

case class KBLinkType(id: ID,
                      kbConceptFromType: KBConceptType,
                      kbConceptToType: KBConceptType,
                      columnHeader: Link,
                      isSwapped: Boolean = false) extends KBType {
    val objectType: KBObjectType = KBObjectType.link
}
