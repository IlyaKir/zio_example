package report_main.reportHandler.fake

import report_main.reportHandler.http.gqlQueryResponses.ResponseLinkType
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder, jsonField}

case class MockResponseLinkType(id: String,
                                name: String,
                                conceptFromType: MockResponseConceptFromToType,
                                conceptToType: MockResponseConceptFromToType,
                                @jsonField("listConceptLinkPropertyType")linkPropertyTypes: List[MockResponsePropertyType]) extends ResponseLinkType

object MockResponseLinkType {
    implicit val encoder: JsonEncoder[MockResponseLinkType] = DeriveJsonEncoder.gen[MockResponseLinkType]
    implicit val decoder: JsonDecoder[MockResponseLinkType] = DeriveJsonDecoder.gen[MockResponseLinkType]
}


