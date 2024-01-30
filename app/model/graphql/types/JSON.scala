package model.graphql.types

import caliban.CalibanError.ExecutionError
import caliban.Value.StringValue
import caliban.schema.{ArgBuilder, Schema}
import play.api.libs.json._

import scala.util.Try

case class JSON(jsValue: JsValue) {
    override def toString: String = jsValue.toString

}

object JSON {
    def apply(jsonString: String): JSON = JSON(jsValue = Json.parse(jsonString))

    implicit val schema: Schema[Any, JSON] = Schema.scalarSchema[JSON](name = "JSON", None, None, elem => StringValue(elem.toString))

    private val JSONReads: Reads[JSON] = JsPath.read[String].map(JSON(_))
    implicit val JSONWrites: Writes[JSON] = (json: JSON) => JsString(json.toString)
    implicit val JSONFormat: Format[JSON] = Format(JSONReads, JSONWrites)

    implicit val JSONArgBuilder: ArgBuilder[JSON] = {
        ArgBuilder.string.flatMap(
            value => Try(Json.parse(value)).fold(ex => Left(ExecutionError(s"Can't parse $value into a JSON", innerThrowable = Some(ex))), elem => Right(JSON(elem)))
        )
    }

}
