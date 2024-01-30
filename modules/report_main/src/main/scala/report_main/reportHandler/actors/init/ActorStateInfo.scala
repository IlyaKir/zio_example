package report_main.reportHandler.actors.init

import report_main.reportHandler.actors.state.{ConceptActorState, ConceptPropertyActorState, DocumentMetadataActorState, LinkActorState, LinkPropertyActorState}

case class ActorStateInfo(conceptActorState: ConceptActorState,
                          conceptPropertyActorState: ConceptPropertyActorState,
                          linkActorState: LinkActorState,
                          linkPropertyActorState: LinkPropertyActorState,
                          documentMetadataActorState: DocumentMetadataActorState)
