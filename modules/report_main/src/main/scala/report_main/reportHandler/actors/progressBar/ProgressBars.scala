package report_main.reportHandler.actors.progressBar

import me.tongfei.progressbar.{ProgressBar, ProgressBarBuilder, ProgressBarStyle}
import report_main.reportHandler.actors.init.ActorStateInfo

case class ProgressBars(conceptActorPB: Option[ProgressBar], conceptActorDocsPB: Option[ProgressBar],
                        linkActorPB: Option[ProgressBar], linkActorDocsPB: Option[ProgressBar],
                        conceptPropertyActorPB: Option[ProgressBar], conceptPropertyActorDocsPB: Option[ProgressBar],
                        linkPropertyActorPB: Option[ProgressBar], linkPropertyActorDocsPB: Option[ProgressBar],
                        documentMetadataActorPB: Option[ProgressBar])

object ProgressBars {
    def createSomePBs(actorStateInfo: ActorStateInfo): ProgressBars = {
        val create: (String, Long) => Option[ProgressBar] = (name, initialMax) =>
            Some(new ProgressBarBuilder()
                .setUpdateIntervalMillis(1000)
                .setTaskName(name)
                .setInitialMax(initialMax)
                .setStyle(ProgressBarStyle.ASCII)
                .build())

        val conceptActorPB = create("ConceptActor", actorStateInfo.conceptActorState.concepts.length)
        val conceptActorDocsPB = create("ConceptActor docs", actorStateInfo.conceptActorState.documentId2Concepts.size + actorStateInfo.conceptActorState.avatarId2Concepts.size)

        val linkActorPB = create("LinkActor", actorStateInfo.linkActorState.links.length)
        val linkActorDocsPB = create("LinkActor docs", actorStateInfo.linkActorState.documentId2Links.size)

        val conceptPropertyActorPB = create("ConceptPropertyActor", actorStateInfo.conceptPropertyActorState.propertyId2PropertyBuilder.keys.size)
        val conceptPropertyActorDocsPB = create("ConceptPropertyActor docs", actorStateInfo.conceptPropertyActorState.documentId2Properties.size)

        val linkPropertyActorPB = create("LinkPropertyActor", actorStateInfo.linkPropertyActorState.propertyId2PropertyBuilder.size)
        val linkPropertyActorDocsPB = create("LinkPropertyActor docs", actorStateInfo.linkPropertyActorState.documentId2Properties.size)

        val documentMetadataActorPB = create("DocumentMetadataActor", actorStateInfo.documentMetadataActorState.documentId2Document.size)

        ProgressBars(conceptActorPB = conceptActorPB, conceptActorDocsPB = conceptActorDocsPB,
            linkActorPB = linkActorPB, linkActorDocsPB = linkActorDocsPB,
            conceptPropertyActorPB = conceptPropertyActorPB, conceptPropertyActorDocsPB = conceptPropertyActorDocsPB,
            linkPropertyActorPB = linkPropertyActorPB, linkPropertyActorDocsPB = linkPropertyActorDocsPB,
            documentMetadataActorPB = documentMetadataActorPB)
    }

    def createNonePBs: ProgressBars = {
        ProgressBars(conceptActorPB = None, conceptActorDocsPB = None,
            linkActorPB = None, linkActorDocsPB = None,
            conceptPropertyActorPB = None, conceptPropertyActorDocsPB = None,
            linkPropertyActorPB = None, linkPropertyActorDocsPB = None,
            documentMetadataActorPB = None)
    }
}
