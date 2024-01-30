//package utils.controller
//
//import caliban.{GraphQLRequest, GraphQLResponse, InputValue}
//import com.google.inject.Inject
//import net.logstash.logback.marker.LogstashMarker
//import play.api.libs.json.Format.GenericFormat
//import play.api.libs.json.JsResult.Exception
//import play.api.libs.json.OFormat.oFormatFromReadsAndOWrites
//import play.api.libs.json.{JsError, JsObject, Json}
//import ru.ispras.auth.AuthClient
//import ru.ispras.auth.config.AuthorizationConfig
//import sttp.model.Part
//import sttp.monad.MonadError
//import sttp.tapir.model.ServerRequest
//import sttp.tapir.server.ServerEndpoint
//import sttp.tapir.server.interceptor._
//import sttp.tapir.server.interpreter.BodyListener
//import sttp.tapir.server.model.ServerResponse
//
//import scala.concurrent.{ExecutionContext, Future}
//import scala.util.{Failure, Success, Try}
//
//case class ControllerInterceptor @Inject()()(implicit val executionContext: ExecutionContext,
//                                             authorizationConfig: AuthorizationConfig) extends RequestInterceptor[Future] with ControllerLogger {
//    override def apply[R, B](
//                                responder: Responder[Future, B],
//                                requestHandler: EndpointInterceptor[Future] => RequestHandler[Future, R, B]
//                            ): RequestHandler[Future, R, B] = {
//        val delegate = (marker: LogstashMarker) => requestHandler(ControllerEndpointInterceptor(marker))
//
//        new RequestHandler[Future, R, B] {
//            override def apply(request: ServerRequest, endpoints: List[ServerEndpoint[R, Future]])(implicit monad: MonadError[Future]): Future[RequestResult[B]] = {
//                val marker = initMarker(request)
//                delegate(marker).apply(request, endpoints)
//            }
//        }
//    }
//}
//
//private case class ControllerEndpointInterceptor @Inject()(marker: LogstashMarker)
//                                                          (implicit val executionContext: ExecutionContext,
//                                                           authorizationConfig: AuthorizationConfig) extends EndpointInterceptor[Future] with ControllerLogger {
//
//    override def apply[B](responder: Responder[Future, B], decodeHandler: EndpointHandler[Future, B]): EndpointHandler[Future, B] = {
//
//        new EndpointHandler[Future, B] {
//            override def onDecodeSuccess[A, U, I](ctx: DecodeSuccessContext[Future, A, U, I])
//                                                 (implicit monad: MonadError[Future], bodyListener: BodyListener[Future, B]): Future[ServerResponse[B]] = {
//                val token = ctx.request.header("X-Auth-Token").getOrElse("")
//
//                for {
//                    user <- AuthClient.getCurrentUser(token).map(Some(_)).recoverWith { case _ => Future.successful(None) }
//                    result <- decodeHandler
//                        .onDecodeSuccess(ctx)
//                        .flatMap { response =>
//                            for {
//                                graphqlRequest <- ctx.input match {
//                                    case (req: GraphQLRequest, _: ServerRequest) => Future.successful(req)
//                                    case (parts: Seq[Part[Array[Byte]]], _: ServerRequest) =>
//                                        val jsObject = Json.parse(parts.head.body.map(_.toChar).mkString)
//                                        val converter = (jsObject: JsObject) => jsObject.value.map { case (k, v) => (k, InputValue.VariableValue(v.toString()).asInstanceOf[InputValue]) }
//
//                                        val variables = (jsObject \ "variables").asOpt[JsObject].map(converter).map(_.toMap)
//                                        val extensions = (jsObject \ "extensions").asOpt[JsObject].map(converter).map(_.toMap)
//                                        Future.successful(GraphQLRequest(
//                                            query = (jsObject \ "query").asOpt[String],
//                                            operationName = (jsObject \ "operationName").asOpt[String],
//                                            variables = variables,
//                                            extensions = extensions
//                                        ))
//                                    case _ => Future.failed(Exception(JsError(s"Graphql input ${ctx.input} not defined")))
//                                }
//                                _ = addRequestInfo(graphqlRequest.query, graphqlRequest.variables.map(variables => Json.toJson(variables.map(v => (v._1, v._2.toInputString))).as[JsObject]), user)(marker)
//                                _ = addOperationInfo(graphqlRequest.query, graphqlRequest.operationName)(marker)
//
//                                graphqlResponse <- Try(response.source.get.value.asInstanceOf[GraphQLResponse[Throwable]]) match {
//                                    case Failure(exception) => Future.failed(exception)
//                                    case Success(value) => Future.successful(value)
//                                }
//                                _ = if (graphqlResponse.errors.nonEmpty) logError(graphqlResponse.errors.mkString(", "))(marker)
//                                else logSuccess(graphqlRequest.operationName, Json.toJson(graphqlResponse.toResponseValue.toString))(marker)
//                            } yield response
//                        }
//                } yield result
//
//            }
//
//            override def onSecurityFailure[A](ctx: SecurityFailureContext[Future, A])
//                                             (implicit monad: MonadError[Future], bodyListener: BodyListener[Future, B]): Future[ServerResponse[B]] = {
//                decodeHandler.onSecurityFailure(ctx)
//            }
//
//            override def onDecodeFailure(ctx: DecodeFailureContext)
//                                        (implicit monad: MonadError[Future], bodyListener: BodyListener[Future, B]): Future[Option[ServerResponse[B]]] = {
//                decodeHandler.onDecodeFailure(ctx)
//            }
//        }
//    }
//}
