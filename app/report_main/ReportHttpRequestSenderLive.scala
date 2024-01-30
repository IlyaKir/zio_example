package report_main

import caliban.client.Operations.RootMutation
import caliban.client.{Operations, SelectionBuilder}
import report_main.AutoUpdatableKeycloakToken
import report_main.generated.kb_api.graphql.Query
import report_main.generated.kb_api.{graphql => kbGraphql}
import report_main.generated.tcontroller.{graphql => tcGraphql}
import report_main.reportHandler.http.gqlQueryResponses._
import report_main.reportHandler.layers.ReportHttpRequestSender
import report_main.reportHandler.layers.ReportHttpRequestSender.MessageStatus
import report_main.reportHandler.types.gqlQueryResponses.ResponseDocument
import common.types.ID
import sttp.client3.{SttpBackend, UriContext}
import zio.logging.{Logging, log}
import zio.{Has, RIO, Task, UIO, ULayer, URIO, ZIO}

case class ReportHttpRequestSenderLive(accessToken: AutoUpdatableKeycloakToken, client: SttpBackend[Task, Any]) extends ReportHttpRequestSender {
    import MessageStatus._

    private val kbUrl = uri"${sys.env.getOrElse("KB_API_URL", "")}"
    private val tControllerUrl = sys.env.getOrElse("TCONTROLLER_URL", "") + "/graphql"
    private val tControllerGraphqlUrl = uri"${tControllerUrl}"
    private val XAuthToken = "X-Auth-Token"

    override def addResearchMap(mutation: SelectionBuilder[RootMutation, String]): RIO[Logging, ID] = sendMutation(mutation).map(ID(_))

    override def updateResearchMap(mutation: SelectionBuilder[RootMutation, String]): RIO[Logging, ID] = sendMutation(mutation).map(ID(_))

    override def addContentOnResearchMap(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Boolean] = sendMutation(mutation).catchAll(_ => ZIO.succeed(false))

    override def addObject(mutation: SelectionBuilder[kbGraphql.Mutation, String]): RIO[Logging, ID] = sendMutation(mutation).map(ID(_))

    override def updateObject(mutation: SelectionBuilder[kbGraphql.Mutation, String]): URIO[Logging, Boolean] = sendMutation(mutation).as(true).catchAll(_ => ZIO.succeed(false))

    override def addObjectFact(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Boolean] = sendMutation(mutation).catchAll(_ => ZIO.succeed(false))

    override def updateConceptAvatar(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Unit] = sendMutation(mutation).catchAll(_ => ZIO.succeed(false)).as(())

    override def getPaginationResearchMap(researchMapName: String): RIO[Logging, List[ResponseResearchMap]] = {
        val query = kbGraphql.Query.paginationResearchMap(filterSettings = kbGraphql.ResearchMapFilterSettings(name = Some(researchMapName)))(
            kbGraphql.ResearchMapPagination.listResearchMap(ResponseResearchMap.select))
        sendQuery(query)
    }

    override def getPaginationConceptType(conceptTypeName: String): RIO[Logging, List[ResponseConceptType]] = {
        val query = kbGraphql.Query.paginationConceptType(filterSettings = kbGraphql.ConceptTypeFilterSettings(name = Some(conceptTypeName)))(
            kbGraphql.ConceptTypePagination.listConceptType(LiveResponseConceptType.select))
        sendQuery(query)
    }

    override def getConceptPropertyTypes(conceptType: ResponseConceptType): RIO[Logging, List[ResponsePropertyType]] = {
        val query = kbGraphql.Query.conceptType(conceptType.id)(kbGraphql.ConceptType.listConceptPropertyType(LiveResponsePropertyType.select))
        sendQuery(query).map(_.flatten)
    }

    override def getLinkTypes(conceptType: ResponseConceptType): RIO[Logging, List[ResponseLinkType]] = {
        val query = kbGraphql.Query.conceptType(conceptType.id)(kbGraphql.ConceptType.listConceptLinkType(LiveResponseLinkType.select))
        sendQuery(query)
    }

    private def sendMutation[R](request: SelectionBuilder[Operations.RootMutation, R]): RIO[Logging, R] = {
        for {
            accessToken <- accessToken.getAccessToken
            result <- request.toRequest(kbUrl, dropNullInputValues = true).header(XAuthToken, accessToken).send(client).flatMap { response =>
                ZIO.fromEither(response.body).tapError(error => log.error(error.getMessage()))
            }
        } yield result
    }

    private def sendQuery[R](request: SelectionBuilder[Operations.RootQuery, R]): RIO[Logging, R] = {
        for {
            accessToken <- accessToken.getAccessToken
            result <- request.toRequest(kbUrl, dropNullInputValues = true).header(XAuthToken, accessToken).send(client).flatMap { response =>
                ZIO.fromEither(response.body).tapError(error => log.error(error.getMessage()))
            }
        } yield result
    }

    override def isDocumentHandled(uuid: String): Task[(MessageStatus, Option[ID])] = {
        tcGraphql.Query.messageStatus(uuid)(tcGraphql.MessageStatus.info(
            onMessageOk = tcGraphql.MessageOk.result.map(value => (MessageOk, value.map(ID(_)))),
            onMessageDuplicate = tcGraphql.MessageDuplicate.result.map(value => (MessageDuplicate, value.map(ID(_)))),
            onMessageInProgress = SelectionBuilder.__typename.map(_ => (MessageInProgress, None)),
            onMessageNotHandled = SelectionBuilder.__typename.map(_ => (MessageNotHandled, None)),
            onMessageFailed = SelectionBuilder.__typename.map(_ => (MessageFailed, None)),
            onMessageUnknown = SelectionBuilder.__typename.map(_ => (MessageUnknown, None))
        )).toRequest(tControllerGraphqlUrl).send(client).map(_.body).absolve
    }

    override def updateDocument(mutation: SelectionBuilder[RootMutation, Boolean]): URIO[Logging, Boolean] = sendMutation(mutation).catchAll(_ => ZIO.succeed(false))

    override def getDocument(documentId: String): URIO[Logging, Option[ResponseDocument]] = {
        val query = Query.document(id = documentId)(ResponseDocument.select)
        sendQuery(query).catchAll(_ => UIO.none)
    }
}

object ReportHttpRequestSenderLive {
    def getLayer(autoUpdatableKeycloakToken: AutoUpdatableKeycloakToken, client: SttpBackend[Task, Any]): ULayer[Has[ReportHttpRequestSender]] =
        ZIO.succeed(ReportHttpRequestSenderLive(autoUpdatableKeycloakToken, client)).toLayer
}
