package report_main.reportHandler.http.gqlQueryResponses

import caliban.client.SelectionBuilder
import report_main.generated.kb_api.graphql.ResearchMap

case class ResponseResearchMap(id: String, name: String)

object ResponseResearchMap {
    val select: SelectionBuilder[ResearchMap, ResponseResearchMap] =
        (ResearchMap.id ~ ResearchMap.name).mapN((id, name) => ResponseResearchMap(id, name))
}
