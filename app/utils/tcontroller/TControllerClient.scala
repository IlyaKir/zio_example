package utils.tcontroller

import play.api.libs.json.Format.GenericFormat
import play.api.libs.json.JsResult.Exception
import play.api.libs.json.Json.JsValueWrapper
import play.api.libs.json.{JsError, JsValue, Json}
import common.types.{ID, MessagePriority}
import sttp.capabilities
import sttp.capabilities.zio.ZioStreams
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend
import sttp.client3.{SttpBackend, basicRequest}
import sttp.model.{StatusCode, Uri}
import zio.logging.{Logging, log}
import zio.{Task, ZIO}

import java.util.UUID
import scala.collection.mutable

object TControllerClient {

    private val tControllerUrl: Uri = Uri.unsafeParse(sys.env.getOrElse("TCONTROLLER_URL", "http://tcontroller:8080") + "/messages/add")

    private def pushRecord(body: String, client: SttpBackend[Task, ZioStreams with capabilities.WebSockets]): ZIO[Logging, Throwable, Unit] = {
        val request = basicRequest
            .body(body)
            .post(tControllerUrl)

        for {
            _ <- request.send(client)
                .foldM(
                    exception => log.throwable(s"Failed pushRecord.", exception).as(Exception(JsError(exception.toString))),
                    value => value.code match {
                        case StatusCode.Ok => log.info(s"Successful pushRecord.").as()
                        case _ => log.error(s"Failed pushRecord. Expected status 200, but got: ${value.code.code}. body: $body").as()
                    }
                )
            _ <- client.close()
        } yield ()
    }

    def saveToTController(
                             taskId: Long,
                             periodicTaskId: Option[Long] = None,
                             timestamp: Long,
                             topic: String,
                             messagePriority: MessagePriority,
                             url: Option[String] = None,
                             fileJson: Option[JsValue] = None,
                             messageJson: Option[JsValue] = None,
                             attachments: Seq[JsValue] = Seq.empty,
                             relatedConceptId: Option[ID],
                             researchMapId: Option[ID]
                         ): ZIO[Logging, Throwable, String] = {
        val uuid = if (fileJson.isDefined) (fileJson.get \ "uuid").as[String] else UUID.randomUUID().toString

        val message: mutable.Buffer[(String, JsValueWrapper)] = scala.collection.mutable.Buffer(
            "_timestamp" -> timestamp,
            "_uuid" -> uuid,
            "_attachments" -> attachments,
            "_task_id" -> taskId.toString
        )

        if (fileJson.isDefined) {
            message += ("_file" -> fileJson.get)
        }

        if (url.isDefined) {
            message += ("_url" -> url.get)
        }

        if (periodicTaskId.isDefined) {
            message += ("_periodic_task_id" -> periodicTaskId.get.toString)
        }

        if (researchMapId.isDefined) {
            message += ("_research_map_id" -> researchMapId.get.id)
        }

        if (relatedConceptId.isDefined) {
            message += ("_related_concept_id" -> relatedConceptId.get.toString)
        }

        val totalMessage = if (messageJson.isDefined) Json.obj(message.toSeq: _*).value ++ messageJson.get.as[Map[String, JsValue]]
        else Json.obj(message.toSeq: _*).value

        val body: mutable.Buffer[(String, JsValueWrapper)] = scala.collection.mutable.Buffer(
            "id" -> uuid,
            "topic" -> topic,
            "priority" -> messagePriority.toString,
            "message" -> Json.toJson(totalMessage),
            "timestamp" -> timestamp.toString,
            "taskId" -> taskId.toString
        )

        if (periodicTaskId.isDefined) {
            body += ("periodicTaskId" -> periodicTaskId.get.toString)
        }

        for {
            client <- AsyncHttpClientZioBackend()
            _ <- pushRecord(Json.obj(body.toSeq: _*).toString(), client)
        } yield uuid
    }

}
