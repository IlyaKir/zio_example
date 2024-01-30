package report_main.reportHandler.types.parsedExcel.reportExcel.property

import report_main.reportHandler.excel.Cell
import Property.PropertyIdentifier

case class SingleSheetProperty(propertyIdentifier: PropertyIdentifier,
                               propertyCells: List[Cell],
                               enrichment: PropertyEnrichment)
