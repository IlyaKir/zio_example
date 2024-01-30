package report_main.reportHandler.fake

import report_main.reportHandler.http.gqlQueryResponses.ResponseConceptType
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder, jsonField}

case class MockResponseConceptType(id: String,
                                   name: String,
                                   @jsonField("listConceptPropertyType")propertyTypes: List[MockResponsePropertyType],
                                   @jsonField("listConceptLinkType")linkTypes: List[MockResponseLinkType]
                                  ) extends ResponseConceptType

object MockResponseConceptType {
    implicit val encoder: JsonEncoder[MockResponseConceptType] = DeriveJsonEncoder.gen[MockResponseConceptType]
    implicit val decoder: JsonDecoder[MockResponseConceptType] = DeriveJsonDecoder.gen[MockResponseConceptType]
}
