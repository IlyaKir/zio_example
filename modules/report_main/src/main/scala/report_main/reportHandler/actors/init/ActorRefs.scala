package report_main.reportHandler.actors.init

import report_main.reportHandler.actors.Message
import zio.actors.{ActorRef, ActorSystem}

case class ActorRefs(actorSystem: ActorSystem,
                     conceptActor: ActorRef[Message],
                     conceptPropertyActor: ActorRef[Message],
                     linkActor: ActorRef[Message],
                     linkPropertyActor: ActorRef[Message],
                     documentMetadataActor: ActorRef[Message])
