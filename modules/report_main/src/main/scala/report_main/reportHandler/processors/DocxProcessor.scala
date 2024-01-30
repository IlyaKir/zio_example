package report_main.reportHandler.processors

import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus._
import report_main.reportHandler.layers.ReportHttpRequestSender
import common.types.ID
import zio.clock.Clock
import zio.logging._
import zio.random.Random
import zio.{Has, RIO}

import java.util.UUID

case class DocxProcessor(docxUUID: UUID) extends Processor {
    import report_main.reportHandler.sideEffects.{ProcessorSE => SE}

    def tryGetDocxKBId: RIO[Logging with Random with Clock with Has[ReportHttpRequestSender], Option[ID]] = {
        SE.waitingDocx(docxUUID.toString) *>
            repeatAskIsDocumentHandled(docxUUID).flatMap {
                case (MessageOk | MessageDuplicate, Some(docxKBId)) => SE.docxHandlingSucceed(docxKBId).as(Some(docxKBId))
                case (MessageFailed | MessageUnknown, _) => SE.docxHandlingFailed.as(None)
                case (_, _) => SE.docxHandlingUnexpectedBehaviour.as(None)
            }
    }
}
