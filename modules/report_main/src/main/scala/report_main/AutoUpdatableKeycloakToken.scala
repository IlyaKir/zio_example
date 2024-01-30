package report_main

import com.auth0.jwt.JWT
import sttp.client3.{SttpBackend, UriContext}
import zio.{Fiber, Ref, Schedule, Task, UIO, URIO, ZIO}
import io.circe
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._
import sttp.model.StatusCode
import zio.clock.Clock
import zio.duration._
import zio.logging.{Logging, log}
import org.keycloak.OAuth2Constants
import report_main.AutoUpdatableKeycloakToken.HttpTokenResponse

case class AutoUpdatableKeycloakToken(tokenRef: Ref[HttpTokenResponse]) {
    def getAccessToken: UIO[String] = tokenRef.get.map(_.access_token)
    def getRefreshToken: UIO[String] = tokenRef.get.map(_.refresh_token)
}

object AutoUpdatableKeycloakToken {
    private val expTimeCoef = 0.8

    def apply(client: SttpBackend[Task, Any]): ZIO[Logging with Clock, Throwable, (AutoUpdatableKeycloakToken, Fiber.Runtime[Throwable, Unit])] = {
        for {
            tokenRef <- getToken(client).flatMap(Ref.make)
            decodedToken <- tokenRef.get.map(_.refresh_token).map(JWT.decode)
            scheduleSpaceInSec = (expTimeCoef * (decodedToken.getIssuedAtAsInstant.getEpochSecond - decodedToken.getExpiresAtAsInstant.getEpochSecond)).toLong
            tokenUpdaterFiber <- scheduleUpdateToken(client, tokenRef, scheduleSpaceInSec.seconds)
        } yield (AutoUpdatableKeycloakToken(tokenRef), tokenUpdaterFiber)
    }

    private lazy val keycloakUrl = uri"${sys.env.getOrElse("KEYCLOAK_URL", "")}"

    case class HttpTokenResponse(access_token: String, refresh_token: String)

    private lazy val commonHeaders = Map(
        OAuth2Constants.CLIENT_ID -> sys.env.getOrElse("KEYCLOAK_CLIENT_ID", ""),
        OAuth2Constants.CLIENT_SECRET -> sys.env.getOrElse("KEYCLOAK_CLIENT_SECRET", ""),
        OAuth2Constants.SCOPE -> sys.env.getOrElse("KEYCLOAK_SCOPE", "")
    )

    private lazy val passwordGrantTypeHeaders = commonHeaders ++ Map(
        OAuth2Constants.GRANT_TYPE -> "password",
        OAuth2Constants.USERNAME -> sys.env.getOrElse("KEYCLOAK_USERNAME", ""),
        OAuth2Constants.PASSWORD -> sys.env.getOrElse("KEYCLOAK_PASSWORD", "")
    )

    private def getRefreshTokenGrantTypeHeaders(token: HttpTokenResponse): Map[String, String] = commonHeaders ++ Map(
        OAuth2Constants.GRANT_TYPE -> "refresh_token",
        OAuth2Constants.REFRESH_TOKEN -> s"${token.refresh_token}",
    )

    private def scheduleUpdateToken(client: SttpBackend[Task, Any], tokenRef: Ref[HttpTokenResponse], scheduleSpaced: Duration): URIO[Logging with Clock, Fiber.Runtime[Throwable, Unit]] = {
        val updateToken = ZIO.effect(getToken(client, Some(tokenRef)).flatMap(newToken => tokenRef.update(_ => newToken))).flatten
        updateToken.repeat(Schedule.spaced(scheduleSpaced)).unit.fork
    }

    private def getToken(client: SttpBackend[Task, Any], maybeTokenRef: Option[Ref[HttpTokenResponse]] = None): ZIO[Logging, ResponseException[String, circe.Error], HttpTokenResponse] = {
        val getHeaders = maybeTokenRef match {
            case Some(tokenRef) => log.info("Updating token") *> tokenRef.get.map(getRefreshTokenGrantTypeHeaders)
            case None => log.info("Getting token") *> ZIO.succeed(passwordGrantTypeHeaders)
        }

        getHeaders.flatMap { headers =>
            val request = basicRequest.body(headers).post(keycloakUrl).response(asJson[HttpTokenResponse])
            client.send(request)
                .catchAll { exception => log.error(s"Failed to get token\n${exception}") *> ZIO.fail(HttpError(s"$exception", StatusCode.BadRequest)) }
                .flatMap(_.body match {
                    case Left(responseException) => log.error(s"Failed to parse token\n${responseException}") *> ZIO.fail(responseException)
                    case Right(response) => ZIO.succeed(response)
                })
        }
    }
}
