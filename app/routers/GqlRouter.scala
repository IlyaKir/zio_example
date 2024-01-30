package routers

import akka.stream.Materializer
import caliban.uploads._
import com.google.inject.Inject
import model.graphql.RootSchema.apiSchema
import model.graphql.context._
import play.api.mvc.ControllerComponents
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import report_main.ReportDocumentUploaderLive
import report_main.reportHandler.layers.ReportDocumentUploader
import zio.internal.Platform
import zio.logging.Logging
import zio.magic._
import zio.{FiberRef, Has, Runtime, ZEnv, ZLayer}

class GqlRouter @Inject()(
                             cc: ControllerComponents,
                             mat: Materializer
                         ) extends SimpleRouter {

    private val initLayer = ZLayer.wire[Uploads with ExecContext with ZEnv with Has[ReportDocumentUploader] with Logging](
        Uploads.empty,
        FiberRef.make(cc.executionContext).toLayer,
        ZEnv.live,
        ReportDocumentUploaderLive.layer,
        Logging.console()
    )

    implicit val runtime: Runtime[Uploads with ExecContext with ZEnv with Has[ReportDocumentUploader] with Logging] =
        Runtime.unsafeFromLayer(initLayer, Platform.default)

    private val interpreter = runtime.unsafeRun(apiSchema.interpreter)
    private val gqlRouter = TalismanGqlPlayRouter(interpreter, cc)(runtime, mat)

    override def routes: Routes = gqlRouter.routes
}
