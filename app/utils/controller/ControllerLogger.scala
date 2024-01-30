//package utils.controller
//
//import net.logstash.logback.marker.LogstashMarker
//import net.logstash.logback.marker.Markers.append
//import play.api.Logger
//import play.api.libs.json.{JsObject, JsValue, Json}
//import ru.ispras.auth.model.user.User
//import sttp.tapir.model.ServerRequest
//
//import java.time.Instant
//import java.util.UUID
//
//trait ControllerLogger {
//
//    private val logger = Logger("Controller")
//
//    def initMarker(serverRequest: ServerRequest): LogstashMarker = {
//        append("request.id", UUID.randomUUID.toString).and(
//            append("request.host", serverRequest.header("Host")).and(
//                append("request.path", serverRequest.pathSegments.headOption).and(
//                    append("request.uuid", UUID.randomUUID.toString).and(
//                        append("request.start_time", Instant.now().toString)
//                    )
//                )
//            )
//        )
//    }
//
//    def addRequestInfo(query: Option[String], variables: Option[JsObject], maybeUser: Option[User])(implicit marker: LogstashMarker): Unit = {
//        if (query.isDefined) marker.add(append("request.query", query.get))
//        if (variables.isDefined) marker.add(append("request.variables", variables.map(Json.stringify)))
//        if (maybeUser.isDefined) marker.add(append("request.user", maybeUser.get.name))
//    }
//
//    def addOperationInfo(query: Option[String], operationName: Option[String])(implicit marker: LogstashMarker): Unit = {
//        val regex = "^(query|mutation|subscription)".r
//
//        val operationType = query match {
//            case Some(value) => regex.findAllMatchIn(value).map(_.group(1)).toSeq.headOption
//            case None => None
//        }
//
//        if (operationType.isDefined) append("request.type", operationType)
//        if (operationName.isDefined) append("request.name", operationName)
//    }
//
//    def logSuccess(operationName: Option[String], response: JsValue)(implicit marker: LogstashMarker): Unit = {
//        def helper(): Unit = {
//            marker.add(append("response", Json.stringify(response)))
//            marker.add(append("request.end_time", Instant.now().toString))
//            (response \ "errors").asOpt[JsValue] match {
//                case Some(errors) => logWarn(errors)(marker)
//                case None => logger.debug(s"Response successful")(marker)
//            }
//        }
//
//        operationName match {
//            case Some(value) => if (value != "IntrospectionQuery") helper()
//            case None => helper()
//        }
//    }
//
//    private def logWarn(errors: JsValue)(implicit marker: LogstashMarker): Unit = {
//        errors \\ "extensions" match {
//            case extensions :: _ => marker.add(
//                append("extensions.params", Json.stringify((extensions \ "params").as[JsValue])).and(
//                    append("extensions.level", (extensions \ "level").as[String]).and(
//                        append("extensions.field", (extensions \ "field").as[String]))))
//            case _ =>
//        }
//        logger.warn((errors \\ "message").head.as[String])(marker)
//    }
//
//    def logError(error: String)(implicit marker: LogstashMarker): Unit = {
//        logger.error(error)(marker)
//    }
//
//}
