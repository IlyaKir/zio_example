package routers

import akka.stream.Materializer
import caliban.CalibanError.{ExecutionError, ParsingError, ValidationError}
import caliban.ResponseValue.ObjectValue
import caliban.Value.StringValue
import caliban.execution.QueryExecution
import caliban.interop.tapir.RequestInterceptor
import caliban.{CalibanError, GraphQLInterpreter, PlayAdapter}
import model.common.errors.TalismanConnectorError
import play.api.mvc._
import play.api.routing.Router.Routes
import play.api.routing.sird._
import play.api.routing.{Router, SimpleRouter}
import sttp.tapir.server.play.PlayServerOptions
import zio.Runtime
import zio.blocking.Blocking
import zio.duration.Duration
import zio.random.Random

import scala.concurrent.ExecutionContext

case class TalismanGqlPlayRouter[R <: Blocking with Random, E](interpreter: GraphQLInterpreter[R, CalibanError],
                                                               controllerComponents: ControllerComponents,
                                                               playground: Boolean = true,
                                                               allowGETRequests: Boolean = true,
                                                               subscriptions: Boolean = true,
                                                               skipValidation: Boolean = false,
                                                               enableIntrospection: Boolean = true,
                                                               keepAliveTime: Option[Duration] = None,
                                                               requestInterceptor: RequestInterceptor[R] = RequestInterceptor.empty,
                                                               queryExecution: QueryExecution = QueryExecution.Parallel
                                                              )(implicit runtime: Runtime[R with Random],
                                                                mat: Materializer
                                                              ) extends SimpleRouter {

    implicit val ec: ExecutionContext = controllerComponents.executionContext
    private val actionBuilder: ActionBuilder[Request, AnyContent] = controllerComponents.actionBuilder
    private val parse: PlayBodyParsers = controllerComponents.parsers
    private val playAdapter: PlayAdapter = PlayAdapter(options =
        PlayServerOptions.default.copy(
            defaultActionBuilder = actionBuilder,
            playBodyParsers = parse
        ))
    // .appendInterceptor(new ControllerInterceptor)

    override def routes: Routes = Router.from {
        case req@POST(p"/graphql") if req.headers.get("Content-Type").exists(value => value.contains("multipart/form-data")) =>
            playAdapter.makeHttpUploadService(withErrorCodeExtensions(interpreter), skipValidation, enableIntrospection, queryExecution, requestInterceptor)(runtime, mat).apply(req)
        case req@POST(p"/graphql") =>
            playAdapter.makeHttpService(withErrorCodeExtensions(interpreter), skipValidation, enableIntrospection, queryExecution, requestInterceptor)(runtime, mat).apply(req)
        case _@GET(p"/graphql") if playground => actionBuilder(Results.Ok(views.html.graphiql()))
    }.routes


    private def withErrorCodeExtensions(interpreter: GraphQLInterpreter[R, CalibanError]): GraphQLInterpreter[R, CalibanError] =
        interpreter.mapError {
            case err@ExecutionError(_, _, _, Some(serverError: TalismanConnectorError), _) =>
                err.copy(
                    extensions = Some(ObjectValue(List(
                        ("params", ObjectValue(serverError.getParams.map { case (key, value) => (key, StringValue(value)) }.toList)),
                    ))),
                    msg = serverError.getMessage
                )
            case err: ExecutionError =>
                err.copy(extensions = Some(ObjectValue(List(("errorCode", StringValue("EXECUTION_ERROR"))))))
            case err: ValidationError =>
                err.copy(extensions = Some(ObjectValue(List(("errorCode", StringValue("VALIDATION_ERROR"))))))
            case err: ParsingError =>
                err.copy(extensions = Some(ObjectValue(List(("errorCode", StringValue("PARSING_ERROR"))))))
        }
}
