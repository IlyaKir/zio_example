package report_main.reportHandler.fake

import report_main.reportHandler.http.gqlQueryResponses.ResponseConceptType
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder, jsonField}

case class MockResponseConceptFromToType(@jsonField("id")id: String,
                                         @jsonField("name")name: String) extends ResponseConceptType

object MockResponseConceptFromToType {
    implicit val encoder: JsonEncoder[MockResponseConceptFromToType] = DeriveJsonEncoder.gen[MockResponseConceptFromToType]
    implicit val decoder: JsonDecoder[MockResponseConceptFromToType] = DeriveJsonDecoder.gen[MockResponseConceptFromToType]
}
