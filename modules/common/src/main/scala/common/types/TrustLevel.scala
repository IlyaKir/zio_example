package common.types

import caliban.schema.Annotations.GQLName
import caliban.schema.Schema
import play.api.libs.json._

sealed trait TrustLevel

object TrustLevel {
    implicit val trustLevelSchema: Schema[Any, TrustLevel] = Schema.genMacro[TrustLevel].schema

    implicit val format: Format[TrustLevel] = Format[TrustLevel](
        Reads { js =>
            val value = JsPath.read[String].reads(js)
            value.fold(
                _ => JsError("trust level undefined or incorrect"),
                {
                    case "Low" => JsSuccess(TrustLevel.Low)
                    case "Medium" => JsSuccess(TrustLevel.Medium)
                    case "High" => JsSuccess(TrustLevel.High)
                }
            )
        },
        Writes {
            case TrustLevel.Low => JsString("Low")
            case TrustLevel.Medium => JsString("Medium")
            case TrustLevel.High => JsString("High")
        }
    )


    @GQLName("low")
    case object Low extends TrustLevel

    @GQLName("medium")
    case object Medium extends TrustLevel

    @GQLName("high")
    case object High extends TrustLevel

    def floatToEnum(value: Float): TrustLevel = {
        value match {
            case v if v >= 0 && v < 0.3 => Low
            case v if v >= 0.3 && v < 0.7 => Medium
            case v if v >= 0.7 && v <= 1 => High
        }
    }

    def enumToFloat(value: TrustLevel): Float = {
        value match {
            case Low => 0F
            case Medium => 0.5F
            case High => 1F
        }
    }
}
