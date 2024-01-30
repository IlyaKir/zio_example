package report_main.reportHandler.http

import caliban.client.Operations.RootMutation
import caliban.client.SelectionBuilder
import report_main.generated.kb_api.graphql._
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.ConceptMainInfo
import report_main.reportHandler.types.parsedExcel.reportExcel.link.LinkMainInfo
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.ConceptOrLinkMetadata
import report_main.reportHandler.types.parsedExcel.reportExcel.property.PropertyMainInfo
import common.types.ID

object KBMutations {
    def addResearchMap(researchMapName: String): SelectionBuilder[RootMutation, String] = {
        Mutation.addResearchMap(form = ResearchMapCreationInput(name = Some(researchMapName)))(ResearchMap.id)
    }

    def updateResearchMap(researchMapId: ID, updateInput: ResearchMapUpdateInput): SelectionBuilder[RootMutation, String] = {
        Mutation.updateResearchMap(id = researchMapId.toString, form = updateInput)(ResearchMap.id)
    }

    def addContentOnResearchMap(researchMapId: ID, content: ResearchMapContentAddInput): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.addContentOnResearchMap(id = researchMapId.toString, form = content)(ResearchMap.id).map(_ => true)
    }

    def addConcept(kbConcept: ConceptMainInfo,
                   documentId: Option[ID],
                   accessLevelId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.addConcept(form = ConceptMutationInput(name = kbConcept.conceptIdentifier.name,
            factInfo = documentId.map(id => FactInput(documentId = id.toString)),
            conceptTypeId = kbConcept.conceptIdentifier.kbType.id.toString,
            notes = kbConcept.metadata.maybeMetadataNotes.map(_.value),
            accessLevelId = accessLevelId.map(_.toString),
            startDate = kbConcept.metadata.maybeMetadataFrom.map(_.value),
            endDate = kbConcept.metadata.maybeMetadataTo.map(_.value)),
            performanceControl = Some(PerformSynchronously(Some(true)))
        )(Concept.id)
    }

    def updateConcept(kbId: ID, concept: ConceptMainInfo, accessLevelId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.updateConcept(form = ConceptUpdateInput(conceptId = kbId.toString,
            name = concept.conceptIdentifier.name,
            conceptTypeId = concept.conceptIdentifier.kbType.id.toString,
            notes = concept.metadata.maybeMetadataNotes.map(_.value),
            startDate = concept.metadata.maybeMetadataFrom.map(_.value),
            endDate = concept.metadata.maybeMetadataTo.map(_.value),
            accessLevelId = accessLevelId.map(_.toString)
        ))(Concept.id)
    }

    def addConceptFact(conceptId: ID, documentId: ID): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.addConceptFact(id = conceptId.toString,
            fact = FactInput(documentId = documentId.toString),
            performanceControl = Some(PerformSynchronously(Some(true))))(State.isSuccess)
    }

    def updateConceptAvatar(conceptId: ID, documentId: ID): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.updateConceptAvatar(id = conceptId.toString, documentId = documentId.toString)(Concept.isActual)
    }

    def addConceptProperty(kbProperty: PropertyMainInfo, conceptId: ID, documentId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.addConceptProperty(form = ConceptPropertyCreateInput(propertyTypeId = kbProperty.propertyIdentifier.kbPropertyType.id.toString,
            valueInput = List(ComponentValueInput(value = kbProperty.propertyIdentifier.valueInput)),
            notes = kbProperty.metadata.maybeMetadataNotes.map(_.value),
            conceptId = conceptId.toString,
            isMain = kbProperty.metadata.maybeMetadataIsMain.map(_.value),
            factInfo = documentId.map(id => FactInput(id.toString)),
            startDate = kbProperty.metadata.maybeMetadataFrom.map(_.value),
            endDate = kbProperty.metadata.maybeMetadataTo.map(_.value)),
            performanceControl = Some(PerformSynchronously(Some(true))))(ConceptProperty.id)
    }

    def updateConceptProperty(kbId: ID, property: PropertyMainInfo, accessLevelId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.updateConceptProperty(form = ConceptPropertyUpdateInput(
            propertyId = kbId.toString,
            isMain = property.metadata.maybeMetadataIsMain.exists(_.value),
            notes = property.metadata.maybeMetadataNotes.map(_.value),
            computableValue = None,
            startDate = property.metadata.maybeMetadataFrom.map(_.value),
            endDate = property.metadata.maybeMetadataTo.map(_.value),
            valueInput = List(ComponentValueInput(value = property.propertyIdentifier.valueInput)),
            accessLevelId = accessLevelId.map(_.toString)
        ))(ConceptProperty.id)
    }

    def addConceptPropertyFact(propertyId: ID, documentId: ID): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.addConceptPropertyFact(id = propertyId.toString,
            fact = FactInput(documentId = documentId.toString),
            performanceControl = Some(PerformSynchronously(Some(true))))(State.isSuccess)
    }

    def addConceptLink(kbConceptLink: LinkMainInfo, kbConceptFromId: ID, kbConceptToId: ID,
                       documentId: Option[ID], accessLevelId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.addConceptLink(form = ConceptLinkCreationMutationInput(linkTypeId = kbConceptLink.linkIdentifier.kbLinkType.id.toString,
            conceptFromId = kbConceptFromId.toString,
            conceptToId = kbConceptToId.toString,
            notes = kbConceptLink.metadata.maybeMetadataNotes.map(_.value),
            accessLevelId = accessLevelId.map(_.toString),
            factInfo = documentId.map(id => FactInput(id.toString)),
            startDate = kbConceptLink.metadata.maybeMetadataFrom.map(_.value),
            endDate = kbConceptLink.metadata.maybeMetadataTo.map(_.value)),
            performanceControl = Some(PerformSynchronously(Some(true))))(ConceptLink.id)
    }

    def updateLinkProperty(kbId: ID, property: PropertyMainInfo, accessLevelId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        updateConceptProperty(kbId, property, accessLevelId)
    }

    def updateConceptLink(kbId: ID, metadata: ConceptOrLinkMetadata, accessLevelId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.updateConceptLink(form = ConceptLinkUpdateMutationInput(id = kbId.toString,
            notes = metadata.maybeMetadataNotes.map(_.value),
            startDate = metadata.maybeMetadataFrom.map(_.value),
            endDate = metadata.maybeMetadataTo.map(_.value),
            accessLevelId = accessLevelId.map(_.toString)
        ))(ConceptLink.id)
    }

    def addConceptLinkFact(linkId: ID, documentId: ID): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.addConceptLinkFact(id = linkId.toString,
            fact = FactInput(documentId = documentId.toString),
            performanceControl = Some(PerformSynchronously(Some(true))))(State.isSuccess)
    }

    def addConceptLinkProperty(kbProperty: PropertyMainInfo, linkId: ID, documentId: Option[ID]): SelectionBuilder[RootMutation, String] = {
        Mutation.addConceptLinkProperty(form = ConceptLinkPropertyInput(propertyTypeId = kbProperty.propertyIdentifier.kbPropertyType.id.id,
            valueInput = List(ComponentValueInput(value = kbProperty.propertyIdentifier.valueInput)),
            notes = kbProperty.metadata.maybeMetadataNotes.map(_.value),
            linkId = linkId.toString,
            isMain = kbProperty.metadata.maybeMetadataIsMain.map(_.value),
            factInfo = documentId.map(id => FactInput(id.toString)),
            startDate = kbProperty.metadata.maybeMetadataFrom.map(_.value),
            endDate = kbProperty.metadata.maybeMetadataTo.map(_.value)),
            performanceControl = Some(PerformSynchronously(Some(true))))(ConceptProperty.id)
    }

    def addConceptLinkPropertyFact(linkPropertyId: ID, documentId: ID): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.addConceptLinkPropertyFact(id = linkPropertyId.toString,
            fact = FactInput(documentId = documentId.toString),
            performanceControl = Some(PerformSynchronously(Some(true))))(State.isSuccess)
    }

    def updateDocument(documentUpdateInput: DocumentUpdateInput): SelectionBuilder[RootMutation, Boolean] = {
        Mutation.updateDocument(form = documentUpdateInput)(Document.id).map(_ => true)
    }
}
