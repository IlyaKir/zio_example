package report_main.reportHandler.http.gqlQueryResponses

import caliban.client.SelectionBuilder
import report_main.generated.kb_api.graphql.ConceptType

case class LiveResponseConceptType(id: String, name: String) extends ResponseConceptType

object LiveResponseConceptType {
    val select: SelectionBuilder[ConceptType, LiveResponseConceptType] =
        (ConceptType.id ~ ConceptType.name).mapN((id, name) => LiveResponseConceptType(id, name))
}
