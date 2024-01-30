import report_main.reportHandler.{ReportHandler, ReportMultiplier}
import report_main.reportHandler.fake.{ReportDocumentUploaderFakeLive, ReportHttpRequestSenderFakeLive}
import report_main.zipReader.AutodetectEncodingZipReader
import report_main.Counter
import common.types.ID
import zio._
import zio.clock.Clock
import zio.console.{Console, getStrLn}
import zio.logging.{LogLevel, Logging, log}
import zio.magic._
import zio.random.Random

import java.nio.file.{Files, Paths}

object Main extends App {
    def run(args: List[String]): URIO[ZEnv, ExitCode] = {
        val loggingLayer = Logging.console(logLevel = LogLevel.Info)

        def getPathToZip: URIO[Console with Logging, (String, Boolean)] = {
            (for {
                _ <- log.info("Print path to *.zip")
                maybePath <- getStrLn.option
                isExists = maybePath.exists(path => Files.exists(Paths.get(path)))
                _ <- if (!isExists) log.info("*.zip doesn't exist at this path") else log.info("Path is correct")
            } yield (maybePath.get, isExists)).repeatWhile(!_._2)
        }

        def handle(path: String) = {
            AutodetectEncodingZipReader(path).readZip.use { zipFileWithEntries =>
                //ReportMultiplier(zipFileWithEntries, n = 17).multiply
                ReportHandler(zipFileWithEntries, "userId", "topic", ID(id = "0"), None).handle
            }
        }

        (for {
            (path, _) <- getPathToZip
            _ <- handle(path)
        } yield ())
            .inject(Random.live, Clock.live, Console.live, Counter.live, loggingLayer,
                ReportHttpRequestSenderFakeLive.layer, ReportDocumentUploaderFakeLive.layer)
            .exitCode
    }
}
