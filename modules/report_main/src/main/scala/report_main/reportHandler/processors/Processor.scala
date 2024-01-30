package report_main.reportHandler.processors

import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus._
import report_main.reportHandler.layers.ReportHttpRequestSender
import common.types.ID
import zio.clock.Clock
import zio.duration._
import zio.logging._
import zio.random.Random
import zio.{Has, RIO, Schedule, Task}

import java.util.UUID

trait Processor {
    def repeatAskIsDocumentHandled(uuid: UUID): RIO[Random with Clock with Logging with Has[ReportHttpRequestSender], (MessageStatus, Option[ID])] = {
        Task(ReportHttpRequestSender.isDocumentHandled(uuid.toString)).flatten
            .repeat(Schedule.spaced(90.seconds).jittered && Schedule.recurWhile {
                case (MessageStatus.MessageInProgress, _) => true
                case (MessageStatus.MessageNotHandled, _) => true
                case _ => false
            })
            .map(_._2)
    }
}
