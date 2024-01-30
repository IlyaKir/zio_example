package report_main.reportHandler.fake

import caliban.client.__Value.__StringValue
import report_main.generated.kb_api.graphql.ValueType
import report_main.reportHandler.http.gqlQueryResponses.ResponsePropertyType
import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder, jsonField}

case class MockResponsePropertyType(id: String,
                                    name: String,
                                    @jsonField("valueType")wrappedValueType: WrappedValueType) extends ResponsePropertyType {
    val valueType: ValueType = wrappedValueType.valueType
}
object MockResponsePropertyType {
    implicit val encoder: JsonEncoder[MockResponsePropertyType] = DeriveJsonEncoder.gen[MockResponsePropertyType]
    implicit val decoder: JsonDecoder[MockResponsePropertyType] = DeriveJsonDecoder.gen[MockResponsePropertyType]
}

case class WrappedValueType(valueType: ValueType)
object WrappedValueType {
    implicit val valueTypeEncoder: JsonEncoder[ValueType] = JsonEncoder[String].contramap(_.value)
    implicit val ValueTypeDecoder: JsonDecoder[ValueType] = JsonDecoder[String].map { value =>
        ValueType.decoder.decode(__StringValue(value)).right.get
    }
    implicit val encoder: JsonEncoder[WrappedValueType] = DeriveJsonEncoder.gen[WrappedValueType]
    implicit val decoder: JsonDecoder[WrappedValueType] = DeriveJsonDecoder.gen[WrappedValueType]
}
