package report_main.reportHandler.actors.state

import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.utils.{ConceptId, DocumentId}
import common.types.ID

import scala.collection.mutable


/**
 * @param documentId2Concepts for creating concepts when document is created
 * @param avatarId2Concepts   for adding avatars to concepts
 * @param concepts            list of all concepts
 */
case class ConceptActorState(documentId2Concepts: Map[DocumentId, List[Concept]],
                             avatarId2Concepts: Map[DocumentId, List[Concept]],
                             concepts: List[Concept]) {
    /**
     * mutable map used to store kbIds
     *
     * initialized by kbIds from concepts comments
     */
    private val conceptId2KBId: mutable.Map[ConceptId, ID] = mutable.Map(
        concepts.flatMap(concept => concept.conceptId.maybeKBId.map { kbId => concept.conceptId -> kbId }): _*
    )

    def tryGetOldAndNewConceptKBId(conceptId: ConceptId): Option[ID] = conceptId2KBId.get(conceptId)

    def tryGetNewConceptKBId(conceptId: ConceptId): Option[ID] = conceptId2KBId.get(conceptId) match {
        case Some(kbId) if conceptId.isUUID => Some(kbId)
        case _ => None
    }

    def updateStateOnCreatedConcept(conceptId: ConceptId, kbId: ID): Unit = conceptId2KBId += (conceptId -> kbId)

    def getNewConceptKBIds: List[ID] = conceptId2KBId.filter(_._1.isUUID).values.toList

    //    /**
    //     * mutable map used to store avatarKBIds of concepts that wasn't created yet
    //     *
    //     * initialized by all concepts with defined avatarKBIds
    //     */
    //    val conceptUUID2AvatarKBId: mutable.Map[String, String] = mutable.Map(
    //        concepts.collect { case concept if concept.dependencyInfo.maybeAvatar.flatMap(_.kbId).isDefined =>
    //            concept.uuid -> concept.dependencyInfo.maybeAvatar.flatMap(_.kbId).get
    //        }:_*)
    //
    //    val conceptUUID2Concept: immutable.Map[String, Concept] = concepts.map(concept => concept.uuid -> concept).toMap
}
