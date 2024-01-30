//package model.graphql.types
//
//import caliban.CalibanError.ExecutionError
//import caliban.Value.IntValue
//import caliban.schema.{ArgBuilder, Schema}
//import play.api.libs.json._
//import zio.Runtime
//import zio.logging.log
//
//import java.time.Instant
//import scala.util.Try
//
//case class UnixTime(time: Long) {
//    def toLong: Long = time
//
//    def isAfter(other: UnixTime): Boolean = toInstant.isAfter(other.toInstant)
//
//    def toInstant: Instant = Instant.ofEpochSecond(time)
//}
//
//object UnixTime {
//
//    val unixTimeReads: Reads[UnixTime] = JsPath.read[Long].map(timestamp => UnixTime(timestamp))
//    implicit val unixTimeWrites: Writes[UnixTime] = (unixTime: UnixTime) => JsNumber(unixTime.time)
//    implicit val UnixTimeFormat: Format[UnixTime] = Format(unixTimeReads, unixTimeWrites)
//
//    implicit val unixTimeSchema: Schema[Any, UnixTime] = Schema.scalarSchema[UnixTime](name = "UnixTime", None, None, elem => IntValue(elem.time))
//    implicit val unixTimeArgBuilder: ArgBuilder[UnixTime] = {
//        ArgBuilder.long.flatMap(
//            value => Try(value)
//                .fold(ex => {
//                    // .provideLayer(logLayer)
//                    Runtime.default.unsafeRun(log.throwable("Failure UnixTime arg build", ex))
//                    Left(ExecutionError(s"Can't parse $value into a UnixTime", innerThrowable = Some(ex)))
//                }, elem => Right(UnixTime(elem)))
//        )
//    }
//}
//
//
