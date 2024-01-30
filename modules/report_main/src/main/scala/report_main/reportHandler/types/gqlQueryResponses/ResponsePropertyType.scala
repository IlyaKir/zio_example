package report_main.reportHandler.http.gqlQueryResponses

import report_main.generated.kb_api.graphql.ValueType

trait ResponsePropertyType {
    val id: String
    val name: String
    val valueType: ValueType
}
