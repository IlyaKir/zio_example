import java.nio.charset.CodingErrorAction
import scala.io.{Codec, Source}

object FileReader {
    private val decoder = Codec.UTF8.decoder.onMalformedInput(CodingErrorAction.IGNORE)

    def read(path: String): String = {
        val input = Source.fromFile(path)(decoder)
        val result = input.getLines().mkString("\n")
        input.close()
        result
    }
}
