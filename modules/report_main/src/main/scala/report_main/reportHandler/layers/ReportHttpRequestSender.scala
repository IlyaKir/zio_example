package report_main.reportHandler.layers

import caliban.client.Operations.RootMutation
import caliban.client.SelectionBuilder
import report_main.generated.kb_api.{graphql => kbGraphql}
import report_main.generated.tcontroller.{graphql => tcGraphql}
import report_main.reportHandler.http.gqlQueryResponses.{ResponseConceptType, ResponseLinkType, ResponsePropertyType, ResponseResearchMap}
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus.MessageStatus
import report_main.reportHandler.types.gqlQueryResponses.ResponseDocument
import common.types.ID
import zio.logging.Logging
import zio.{Has, RIO, URIO, ZIO}

trait ReportHttpRequestSender {
    def addResearchMap(mutation: SelectionBuilder[RootMutation, String]): RIO[Logging, ID]

    def updateResearchMap(mutation: SelectionBuilder[RootMutation, String]): RIO[Logging, ID]

    def addContentOnResearchMap(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Boolean]

    /**
     * addConcept, addConceptProperty, addLink, addLinkProperty
     *
     * @return kb object ID
     */
    def addObject(mutation: SelectionBuilder[tcGraphql.Mutation, String]): RIO[Logging, ID]

    def updateObject(mutation: SelectionBuilder[tcGraphql.Mutation, String]): URIO[Logging, Boolean]

    /**
     * addConceptFact, addConceptPropertyFact, addLinkFact, addLinkPropertyFact
     *
     * @return isSuccess
     */
    def addObjectFact(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Boolean]

    def updateConceptAvatar(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Unit]

    def getPaginationResearchMap(researchMapName: String): RIO[Logging, List[ResponseResearchMap]]

    def getPaginationConceptType(conceptTypeName: String): RIO[Logging, List[ResponseConceptType]]

    def getConceptPropertyTypes(conceptType: ResponseConceptType): RIO[Logging, List[ResponsePropertyType]]

    def getLinkTypes(conceptType: ResponseConceptType): RIO[Logging, List[ResponseLinkType]]

    def isDocumentHandled(uuid: String): RIO[Logging, (MessageStatus, Option[ID])]

    def updateDocument(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Boolean]

    def getDocument(documentId: String): URIO[Logging, Option[ResponseDocument]]
}

object ReportHttpRequestSender {
    object MessageStatus extends Enumeration {
        type MessageStatus = Value
        val MessageOk, MessageDuplicate, MessageInProgress, MessageNotHandled, MessageFailed, MessageUnknown = Value
    }

    def addResearchMap(mutation: SelectionBuilder[RootMutation, String]): RIO[Logging with Has[ReportHttpRequestSender], ID] = {
        ZIO.service[ReportHttpRequestSender].flatMap(_.addResearchMap(mutation))
    }

    def updateResearchMap(mutation: SelectionBuilder[RootMutation, String]): RIO[Logging with Has[ReportHttpRequestSender], ID] =
        ZIO.service[ReportHttpRequestSender]flatMap(_.updateResearchMap(mutation))

    def addContentOnResearchMap(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging with Has[ReportHttpRequestSender], Boolean] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.addContentOnResearchMap(mutation))

    /**
     * addConcept, addConceptProperty, addLink, addLinkProperty
     *
     * @return kb object ID
     */
    def addObject(mutation: SelectionBuilder[kbGraphql.Mutation, String]): RIO[Logging with Has[ReportHttpRequestSender], ID] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.addObject(mutation))

    def updateObject(mutation: SelectionBuilder[kbGraphql.Mutation, String]): URIO[Logging with Has[ReportHttpRequestSender], Boolean] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.updateObject(mutation))

    /**
     * addConceptFact, addConceptPropertyFact, addLinkFact, addLinkPropertyFact
     *
     * @return isSuccess
     */
    def addObjectFact(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging with Has[ReportHttpRequestSender], Boolean] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.addObjectFact(mutation))

    def updateConceptAvatar(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging with Has[ReportHttpRequestSender], Unit] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.updateConceptAvatar(mutation))


    def getPaginationResearchMap(researchMapName: String): RIO[Logging with Has[ReportHttpRequestSender], List[ResponseResearchMap]] = {
        ZIO.service[ReportHttpRequestSender].flatMap(_.getPaginationResearchMap(researchMapName))
    }

    def getPaginationConceptType(conceptTypeName: String): RIO[Logging with Has[ReportHttpRequestSender], List[ResponseConceptType]] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.getPaginationConceptType(conceptTypeName))

    def getConceptPropertyTypes(conceptType: ResponseConceptType): RIO[Logging with Has[ReportHttpRequestSender], List[ResponsePropertyType]] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.getConceptPropertyTypes(conceptType))

    def getLinkTypes(conceptType: ResponseConceptType): RIO[Logging with Has[ReportHttpRequestSender], List[ResponseLinkType]] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.getLinkTypes(conceptType))

    def isDocumentHandled(uuid: String): RIO[Logging with Has[ReportHttpRequestSender], (MessageStatus, Option[ID])] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.isDocumentHandled(uuid))

    def updateDocument(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging with Has[ReportHttpRequestSender], Boolean] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.updateDocument(mutation))

    def getDocument(documentId: String): URIO[Logging with Has[ReportHttpRequestSender], Option[ResponseDocument]] =
        ZIO.service[ReportHttpRequestSender].flatMap(_.getDocument(documentId))
}
