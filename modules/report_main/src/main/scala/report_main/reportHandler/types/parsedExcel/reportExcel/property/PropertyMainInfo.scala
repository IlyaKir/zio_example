package report_main.reportHandler.types.parsedExcel.reportExcel.property

import report_main.generated.kb_api.graphql.ValueInput
import report_main.reportHandler.excel.Cell
import Property.PropertyIdentifier
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.PropertyMetadata

case class PropertyMainInfo(propertyIdentifier: PropertyIdentifier,
                            propertyCells: List[Cell],
                            metadata: PropertyMetadata) {
    def getValueInputString: String = {
        propertyIdentifier.valueInput match {
            case ValueInput(Some(stringValueInput), None, None, None, None, None, None) => stringValueInput.value
            case ValueInput(None, Some(stringLocaleValueInput), None, None, None, None, None) => stringLocaleValueInput.value
            case ValueInput(None, None, Some(intValueInput), None, None, None, None) => intValueInput.value.toString
            case ValueInput(None, None, None, Some(doubleValueInput), None, None, None) => doubleValueInput.value.toString
            case ValueInput(None, None, None, None, Some(geoPointValueInput), None, None) => geoPointValueInput.point.toString + "; " + geoPointValueInput.name.toString
            case ValueInput(None, None, None, None, None, Some(dateTimeValueInput), None) => dateTimeValueInput.date.toString + "; " + dateTimeValueInput.time.toString
            case ValueInput(None, None, None, None, None, None, Some(linkValueInput)) => linkValueInput.link
        }
    }
}
