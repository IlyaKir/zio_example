package report_main.reportHandler.actors.state

import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.property.Property
import report_main.reportHandler.utils.{ConceptId, DocumentId, PropertyId}
import common.types.ID

import scala.collection.mutable

/**
 * Property can be created (according to business-logic) when both concept and document(at least one) created
 *
 * We use this class to store info of what was already created
 */
case class ConceptPropertyBuilder(var maybeConceptKBId: Option[ID] = None,
                                  var documentKBIds: List[ID] = List.empty)

/**
 * @param documentId2Properties for creating properties when document is created
 * @param conceptId2Properties  for creating properties when concept is created
 * @param concepts              list of all concepts
 */
case class ConceptPropertyActorState(documentId2Properties: Map[DocumentId, List[Property]],
                                     conceptId2Properties: Map[ConceptId, List[Property]],
                                     private val concepts: List[Concept]) {
    val properties: List[Property] = concepts.flatMap(_.dependencyInfo.properties).distinct
    val propertyId2Property: Map[PropertyId, Property] = properties.map(property => property.propertyId -> property).toMap

    val propertyId2PropertyBuilder: Map[PropertyId, ConceptPropertyBuilder] = {
        val propertyId2PropertyBuilder = (documentId2Properties.values.flatten.toSet ++ conceptId2Properties.values.flatten.toSet)
            .map(_.propertyId -> ConceptPropertyBuilder()).toMap
        //update ConceptPropertyBuilder.maybeConceptFromKBId
        conceptId2Properties.foreach { case (conceptId, properties) => properties.foreach { property =>
            propertyId2PropertyBuilder(property.propertyId).maybeConceptKBId = conceptId.maybeKBId
        }
        }
        propertyId2PropertyBuilder
    }

    /**
     * Mutable map used to store kbIds
     *
     * Initialized by kbIds from properties comments
     */
    private val propertyId2KBId: mutable.Map[PropertyId, ID] = mutable.Map(
        properties.flatMap(property => property.propertyId.maybeKBId.map { kbId => property.propertyId -> kbId }): _*
    )

    def tryGetOldAndNewPropertyKBId(propertyId: PropertyId): Option[ID] = propertyId2KBId.get(propertyId)

    def tryGetNewPropertyKBId(propertyId: PropertyId): Option[ID] = tryGetOldAndNewPropertyKBId(propertyId) match {
        case Some(kbId) if propertyId.isUUID => Some(kbId)
        case _ => None
    }

    def updateStateOnCreatedProperty(propertyId: PropertyId, propertyKBId: ID, conceptKBId: ID): Unit = {
        propertyId2KBId += (propertyId -> propertyKBId)
        propertyKBId2ConceptKBId += (propertyKBId -> conceptKBId)
    }

    /**
     * Mutable map used to store which concept belongs to which conceptProperty
     *
     * It is used when documentCreated message comes and we need to add fact to property and to concept
     *
     * For getting properties we use documentId2Properties, but for getting concepts we use this val
     */
    val propertyKBId2ConceptKBId: mutable.Map[ID, ID] = mutable.Map(concepts.collect { case concept if concept.conceptId.isKBId =>
        concept.conceptId.maybeKBId.get -> concept.dependencyInfo.properties.collect { case property if property.propertyId.isKBId => property.propertyId.maybeKBId.get }
    }.flatMap { case (conceptKBId, propertyKBIds) => propertyKBIds.map(propertyKBId => propertyKBId -> conceptKBId) }: _*)
}
