package report_main.reportHandler.types.columnHeaders.kb

import report_main.reportHandler.types.columnHeaders.kb.KBObjectType.KBObjectType
import common.types.ID

trait KBType {
    val id: ID
    val objectType: KBObjectType
}
