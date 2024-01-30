package report_main.reportHandler.types.parsedExcel.reportExcel.headers

import report_main.reportHandler.types.columnHeaders.kb._

case class SheetKBHeaders(kbConceptType: KBConceptType,
                          columnId2KBType: Map[Int, KBType],
                          sheetHeaders: ReportSheetHeaders) {
    lazy val columnId2KBLinkType: Map[Int, KBLinkType] = columnId2KBType
        .collect{ case (columnId, kbType) if kbType.objectType == KBObjectType.link =>
            val kbLinkType = kbType.asInstanceOf[KBLinkType]
            columnId -> kbLinkType
        }
    lazy val columnId2KBConceptPropertyType: Map[Int, KBPropertyType] = columnId2KBType
        .collect{ case (columnId, kbType) if (kbType.objectType == KBObjectType.property) && sheetHeaders.conceptPropertyColumnIds.contains(columnId) =>
            val kbPropertyType = kbType.asInstanceOf[KBPropertyType]
            columnId -> kbPropertyType
        }
    lazy val columnId2KBLinkPropertyType: Map[Int, KBPropertyType] = columnId2KBType
        .collect{ case (columnId, kbType) if (kbType.objectType == KBObjectType.property) && sheetHeaders.linkPropertyColumnIds.contains(columnId) =>
            val kbPropertyType = kbType.asInstanceOf[KBPropertyType]
            columnId -> kbPropertyType
        }

    /**
     * returns link KBPropertyTypes for specific linkColumn
     * @return columnId -> KBLinkPropertyType
     */
    def getKBLinkPropertyTypesByLinkColumnId(linkColumnId: Int): Map[Int, KBPropertyType] = {
        val linkPropertyColumnIds = sheetHeaders.linkColumnId2LinkPropertyColumnHeaders.getOrElse(linkColumnId, List()).map(_.cell.getColumnIndex)
        columnId2KBLinkPropertyType.filter { case (columnId, _) => linkPropertyColumnIds.contains(columnId) }
    }
}
