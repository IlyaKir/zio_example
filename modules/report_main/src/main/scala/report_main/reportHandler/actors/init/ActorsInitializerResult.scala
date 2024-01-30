package report_main.reportHandler.actors.init

import report_main.reportHandler.actors.Message
import report_main.reportHandler.actors.progressBar.ProgressBars
import report_main.reportHandler.utils.DocumentId
import zio.actors.ActorRef

import java.util.UUID

case class ActorsInitializerResult(actorStateInfo: ActorStateInfo,
                                   actorRefs: ActorRefs,
                                   progressBars: ProgressBars,
                                   documentId2ActorRefs: Map[DocumentId, Seq[ActorRef[Message]]])
