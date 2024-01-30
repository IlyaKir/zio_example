package report_main.reportHandler.http.gqlQueryResponses

import caliban.client.SelectionBuilder
import report_main.generated.kb_api.graphql.{ConceptLinkType, ConceptPropertyType}

case class LiveResponseLinkType(id: String,
                                name: String,
                                conceptFromType: ResponseConceptType,
                                conceptToType: ResponseConceptType,
                                linkPropertyTypes: List[ResponsePropertyType]) extends ResponseLinkType

object LiveResponseLinkType {
    val select: SelectionBuilder[ConceptLinkType, LiveResponseLinkType] =
        (ConceptLinkType.id ~ ConceptLinkType.name ~ ConceptLinkType.conceptFromType(LiveResponseConceptType.select) ~ ConceptLinkType.conceptToType(LiveResponseConceptType.select) ~
            ConceptLinkType.listConceptLinkPropertyType(LiveResponsePropertyType.select))
            .map { case (id, name, conceptFromType, conceptToType, linkPropertyTypes) => LiveResponseLinkType(id, name, conceptFromType, conceptToType, linkPropertyTypes.flatten) }
}
