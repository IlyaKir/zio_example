package common.types

import caliban.schema.Schema
import play.api.libs.json._
import common.types.NativeOrdered

sealed trait MessagePriority extends NativeOrdered[MessagePriority]

object MessagePriority {
    case object Background extends MessagePriority

    case object Normal extends MessagePriority

    case object High extends MessagePriority

    case object VeryHigh extends MessagePriority

    implicit val schema: Schema[Any, MessagePriority] = Schema.gen

    implicit val format: Format[MessagePriority] = Format(
        Reads {
            json =>
                val value = JsPath.read[String].reads(json)
                value.fold(
                    _ => JsError("Message priority undefined or incorrect"),
                    {
                        case "Background" => JsSuccess(MessagePriority.Background)
                        case "Normal" => JsSuccess(MessagePriority.Normal)
                        case "High" => JsSuccess(MessagePriority.High)
                        case "VeryHigh" => JsSuccess(MessagePriority.VeryHigh)
                    }
                )
        },
        Writes {
            case Background => JsString("Background")
            case Normal => JsString("Normal")
            case High => JsString("High")
            case VeryHigh => JsString("VeryHigh")
        }
    )
}
