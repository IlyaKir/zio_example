package report_main.reportHandler.fake

import caliban.client.Operations.RootMutation
import caliban.client.SelectionBuilder
import report_main.Counter
import report_main.generated.kb_api.{graphql => kbGraphql}
import report_main.generated.tcontroller.{graphql => tcGraphql}
import report_main.reportHandler.http.gqlQueryResponses.{ResponseConceptType, ResponseLinkType, ResponsePropertyType, ResponseResearchMap}
import report_main.reportHandler.layers.ReportHttpRequestSender
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus.{MessageOk, MessageStatus}
import report_main.reportHandler.types.gqlQueryResponses.ResponseDocument
import common.types.ID
import zio.{Has, Task, UIO, URLayer, ZIO}

case class ReportHttpRequestSenderFakeLive(counter: Counter) extends ReportHttpRequestSender with FakeKBApi {
    private def getNextKBId: UIO[ID] = {
        for {
            counterRef <- counter.get
            value <- counterRef.updateAndGet(_ + 1)
        } yield ID(s"ОК-${value}")
    }

    /**
     * addConcept, addConceptProperty, addLink, addLinkProperty
     *
     * @return kb object ID
     */
    override def addObject(mutation: SelectionBuilder[kbGraphql.Mutation, String]): Task[ID] = getNextKBId

    override def updateObject(mutation: SelectionBuilder[tcGraphql.Mutation, String]): UIO[Boolean] = UIO.succeed(true)

    /**
     * addConceptFact, addConceptPropertyFact, addLinkFact, addLinkPropertyFact
     *
     * @return isSuccess
     */
    override def addObjectFact(mutation: SelectionBuilder[RootMutation, Boolean]): UIO[Boolean] = UIO.succeed(true)

    override def updateConceptAvatar(mutation: SelectionBuilder[RootMutation, Boolean]): UIO[Unit] = UIO.succeed()

    override def addResearchMap(mutation: SelectionBuilder[RootMutation, String]): Task[ID] = getNextKBId

    override def addContentOnResearchMap(mutation: SelectionBuilder[RootMutation, Boolean]): UIO[Boolean] = UIO.succeed(true)

    override def getPaginationResearchMap(researchMapName: String): Task[List[ResponseResearchMap]] = Task.succeed(List.empty)

    override def getPaginationConceptType(conceptTypeName: String): Task[List[ResponseConceptType]] = {
        getFakeKBTypes.map(_.enrichedConceptPropertyTypes)
    }

    override def getConceptPropertyTypes(conceptType: ResponseConceptType): Task[List[ResponsePropertyType]] = {
        getFakeKBTypes.map(_.enrichedConceptPropertyTypes).map(_.filter { concType =>
            concType.id == conceptType.id && concType.name == conceptType.name
        }).map(_.flatMap(_.propertyTypes))
    }

    override def getLinkTypes(conceptType: ResponseConceptType): Task[List[ResponseLinkType]] = {
        getFakeKBTypes.map(_.enrichedConceptPropertyTypes).map(_.filter { concType =>
            concType.id == conceptType.id && concType.name == conceptType.name
        }).map(_.flatMap(_.linkTypes))
    }

    override def isDocumentHandled(uuid: String): Task[(MessageStatus, Option[ID])] = getNextKBId.map(kbId => (MessageOk, Some(kbId)))

    override def updateResearchMap(mutation: SelectionBuilder[RootMutation, String]): Task[ID] = Task.succeed(ID("ОК-1"))

    override def updateDocument(mutation: SelectionBuilder[RootMutation, Boolean]): UIO[Boolean] = UIO.succeed(true)

    override def getDocument(documentId: String): UIO[Option[ResponseDocument]] = UIO.none
}

object ReportHttpRequestSenderFakeLive {
    val layer: URLayer[Has[Counter], Has[ReportHttpRequestSender]] =
        ZIO.service[Counter].map(ReportHttpRequestSenderFakeLive(_)).toLayer
}
