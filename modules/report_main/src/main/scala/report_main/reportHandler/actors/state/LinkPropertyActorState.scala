package report_main.reportHandler.actors.state

import report_main.reportHandler.actors.DocumentCreated
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import report_main.reportHandler.utils.{DocumentId, LinkId, PropertyId}
import common.types.ID

import scala.collection.mutable

/**
 * linkProperty can be created (according to business-logic) when link and document(at least one) created
 * we use this class to store info of what was already created
 */
case class LinkPropertyBuilder(var maybeLinkKBId: Option[ID] = None,
                               var documentCreatedMessages: List[DocumentCreated] = List.empty)

/**
 * @param documentId2Properties for creating linkProperties when document is created
 * @param linkId2Properties     for creating linkProperties when link is created
 * @param links                 list of all links
 */
case class LinkPropertyActorState(documentId2Properties: Map[DocumentId, List[Property]],
                                  linkId2Properties: Map[LinkId, List[Property]],
                                  private val links: List[Link]) {
    val properties: List[Property] = links.flatMap(_.dependencyInfo.properties).distinct
    val propertyId2Property: Map[PropertyId, Property] = properties.map(property => property.propertyId -> property).toMap

    val propertyId2PropertyBuilder: Map[PropertyId, LinkPropertyBuilder] = {
        val propertyId2PropertyBuilder = (documentId2Properties.values.flatten.toSet ++ linkId2Properties.values.flatten.toSet)
            .map(_.propertyId -> LinkPropertyBuilder()).toMap
        //update LinkPropertyBuilder.maybeLinkKBId
        linkId2Properties.foreach { case (linkId, properties) => properties.foreach { property =>
            propertyId2PropertyBuilder(property.propertyId).maybeLinkKBId = linkId.maybeKBId
        }
        }
        propertyId2PropertyBuilder
    }

    /**
     * Mutable map used to store kbIds of created linkProperties
     *
     * Initialized by kbIds from linkProperties comments
     */
    private val propertyId2KBId: mutable.Map[PropertyId, ID] = mutable.Map(
        properties.flatMap(property => property.propertyId.maybeKBId.map { kbId => property.propertyId -> kbId }): _*
    )


    def tryGetOldAndNewPropertyKBId(propertyId: PropertyId): Option[ID] = propertyId2KBId.get(propertyId)

    def tryGetNewPropertyKBId(propertyId: PropertyId): Option[ID] = tryGetOldAndNewPropertyKBId(propertyId) match {
        case Some(kbId) if propertyId.isUUID => Some(kbId)
        case _ => None
    }

    def updateStateOnCreatedProperty(propertyId: PropertyId, propertyKBId: ID, linkKBId: ID): Unit = {
        propertyId2KBId += (propertyId -> propertyKBId)
        propertyKBId2LinkKBId += (propertyKBId -> linkKBId)
    }

    /**
     * Mutable map used to store which link belongs to which linkProperty
     *
     * It is used when documentCreated message comes and we need to add fact to linkProperty and to link
     *
     * For getting linkProperties we use documentId2Properties, but for getting links we use this val
     */
    val propertyKBId2LinkKBId: mutable.Map[ID, ID] = mutable.Map(links.collect { case link if link.linkId.isKBId =>
        link.linkId.maybeKBId.get -> link.dependencyInfo.properties.collect { case property if property.propertyId.isKBId => property.propertyId.maybeKBId.get }
    }.flatMap { case (linkKBId, propertyKBIds) => propertyKBIds.map(propertyKBId => propertyKBId -> linkKBId) }: _*)
}
