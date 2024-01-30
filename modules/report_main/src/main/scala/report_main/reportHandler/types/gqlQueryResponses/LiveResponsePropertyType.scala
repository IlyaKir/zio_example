package report_main.reportHandler.http.gqlQueryResponses

import caliban.client.SelectionBuilder
import report_main.generated.kb_api.graphql.{ConceptPropertyType, ConceptPropertyValueType, ValueType}

case class LiveResponsePropertyType(id: String, name: String, valueType: ValueType) extends ResponsePropertyType

object LiveResponsePropertyType {
    val select: SelectionBuilder[ConceptPropertyType, Option[LiveResponsePropertyType]] =
        (ConceptPropertyType.id ~ ConceptPropertyType.name ~
            ConceptPropertyType.valueType(
                onCompositePropertyValueTemplate = SelectionBuilder.__typename.map(_ => None),
                onConceptPropertyValueType = ConceptPropertyValueType.valueType.map(Some(_))
            )
        ).map{ case (id, name, maybeValueType) => maybeValueType.map(valueType => LiveResponsePropertyType(id, name, valueType)) }
}
