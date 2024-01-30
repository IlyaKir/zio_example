package report_main.reportHandler.fake

import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder, jsonField}

case class FakeKBTypes(@jsonField("listConceptType")enrichedConceptPropertyTypes: List[MockResponseConceptType])

object FakeKBTypes {
    implicit val encoder: JsonEncoder[FakeKBTypes] = DeriveJsonEncoder.gen[FakeKBTypes]
    implicit val decoder: JsonDecoder[FakeKBTypes] = DeriveJsonDecoder.gen[FakeKBTypes]
}
