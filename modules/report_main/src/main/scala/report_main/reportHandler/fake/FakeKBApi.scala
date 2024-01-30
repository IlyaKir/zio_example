package report_main.reportHandler.fake

import zio.{Task, ZIO, ZManaged}
import zio.json._

trait FakeKBApi {
    // TODO get path from sbt ?
    private val folder = "modules/report_main/src/main/scala/report_main/reportHandler/fake/"
    private val fakeKBTypes = folder + "fakeKBTypes.json"
    private val fakeTypesForValueTypeTesting = folder + "fakeKBTypesForValueTypeTesting.json"

    def read(path: String): Task[String] = {
        import java.nio.charset.CodingErrorAction
        import scala.io.{Codec, Source}

        lazy val decoder = Codec.UTF8.decoder.onMalformedInput(CodingErrorAction.IGNORE)
        ZManaged.fromAutoCloseable(ZIO.effect(Source.fromFile(path)(decoder))).use { bufferedSource =>
            ZIO.succeed(bufferedSource.getLines().mkString("\n"))
        }
    }

    def getFakeKBTypes: Task[FakeKBTypes] = {
        for {
            content <- read(s"$fakeKBTypes")
            conceptTypes <- ZIO.fromEither(content.fromJson[FakeKBTypes]).mapError(new Exception(_))
            contentValueTypes <- read(s"$fakeTypesForValueTypeTesting")
            conceptTypesForTestingValueTypes <- ZIO.fromEither(contentValueTypes.fromJson[FakeKBTypes]).mapError(new Exception(_))
        } yield FakeKBTypes(conceptTypes.enrichedConceptPropertyTypes ++ conceptTypesForTestingValueTypes.enrichedConceptPropertyTypes)
    }
}
