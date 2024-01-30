package report_main.reportHandler.actors.state

import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.utils.{ConceptId, DocumentId, LinkId}
import common.types.ID

import scala.collection.mutable

/**
 * link can be created (according to business-logic) when conceptFrom, conceptTo and document(at least one) created
 * we use this class to store info of what was already created
 */
case class LinkBuilder(var maybeConceptFromKBId: Option[ID] = None,
                       var maybeConceptToKBId: Option[ID] = None,
                       var documentKBIds: List[ID] = List.empty)

/**
 * @param documentId2Links    for creating links when document is created
 * @param conceptFromId2Links for creating links when conceptFrom is created
 * @param conceptToId2Links   for creating links when conceptTo is created
 * @param links               list of all links
 */
case class LinkActorState(documentId2Links: Map[DocumentId, List[Link]],
                          conceptFromId2Links: Map[ConceptId, List[Link]],
                          conceptToId2Links: Map[ConceptId, List[Link]],
                          links: List[Link]) {
    val linkId2Link: Map[LinkId, Link] = links.map(link => link.linkId -> link).toMap

    val linkId2LinkBuilder: Map[LinkId, LinkBuilder] = {
        val linkId2LinkBuilder = (documentId2Links.values.flatten.toSet ++ conceptFromId2Links.values.flatten.toSet ++ conceptToId2Links.values.flatten.toSet)
            .map(_.linkId -> LinkBuilder()).toMap
        //update LinkBuilders conceptFromKBId
        conceptFromId2Links.foreach { case (conceptId, links) => links.foreach { link =>
            linkId2LinkBuilder(link.linkId).maybeConceptFromKBId = conceptId.maybeKBId
        }
        }
        //update LinkBuilders conceptToKBId
        conceptToId2Links.foreach { case (conceptId, links) => links.foreach { link =>
            linkId2LinkBuilder(link.linkId).maybeConceptToKBId = conceptId.maybeKBId
        }
        }
        linkId2LinkBuilder
    }

    /**
     * mutable map used to store kbIds
     *
     * initialized by kbIds from links comments
     */
    private val linkId2KBId: mutable.Map[LinkId, ID] = mutable.Map(
        links.flatMap(link => link.linkId.maybeKBId.map { kbId => link.linkId -> kbId }): _*
    )

    def tryGetOldAndNewLinkKBId(linkId: LinkId): Option[ID] = linkId2KBId.get(linkId)

    def tryGetNewLinkKBId(linkId: LinkId): Option[ID] = tryGetOldAndNewLinkKBId(linkId) match {
        case Some(kbId) if linkId.isUUID => Some(kbId)
        case _ => None
    }

    def updateStateOnCreatedLink(linkId: LinkId, kbId: ID, conceptFromKBId: ID, conceptToKBId: ID): Unit = {
        linkId2KBId += (linkId -> kbId)
        linkKBId2ConceptKBIds += (kbId -> (conceptFromKBId, conceptToKBId))
    }

    /**
     * Mutable map used to store which concepts belongs to which links
     *
     * It is used when documentCreated message comes and we need to add fact to link and to concepts (from, to);
     * for getting links we use documentUUID2Links, but for getting concepts we use this val
     *
     * @return linkKBId -> (conceptFromKBId, conceptToKBId)
     */
    val linkKBId2ConceptKBIds: mutable.Map[ID, (ID, ID)] = mutable.Map(links.map { link =>
        (link.linkId.id, link.mainInfo.linkIdentifier.conceptFrom.conceptId.id, link.mainInfo.linkIdentifier.conceptTo.conceptId.id)
    }
        .collect { case (Left(linkKBId), Left(conceptFromKBId), Left(conceptToKBId)) => linkKBId -> (conceptFromKBId, conceptToKBId) }: _*
    )
}
