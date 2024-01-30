package common.types

import caliban.CalibanError.ExecutionError
import caliban.Value.StringValue
import caliban.schema.{ArgBuilder, Schema}
import play.api.libs.json.{Json, OFormat}

import java.util.UUID
import scala.util.Try

case class ID(id: String) {
    def toLong: Long = id.toLong

    def toUUID: UUID = UUID.fromString(id)

    override def toString: String = id
}

object ID {
    implicit val idSchema: Schema[Any, ID] = Schema.scalarSchema[ID](name = "ID", None, None, elem => StringValue(elem.id))
    implicit val format: OFormat[ID] = Json.format[ID]
    implicit val idArgBuilder: ArgBuilder[ID] = {
        ArgBuilder.string.flatMap(
            value => Try(value).fold(
                ex => Left(ExecutionError(s"Can't parse $value into a ID", innerThrowable = Some(ex))),
                elem => Right(ID(elem))
            )
        )
    }
}
