package report_main.reportHandler.http.gqlQueryResponses

trait ResponseLinkType {
    val id: String
    val name: String
    val conceptFromType: ResponseConceptType
    val conceptToType: ResponseConceptType
    val linkPropertyTypes: List[ResponsePropertyType]
}

