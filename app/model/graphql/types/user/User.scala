package model.graphql.types.user

import play.api.libs.json.{Json, OFormat}
import common.types.ID

object User {
    def apply(id: String): User = {
        User(ID(id))
    }

    implicit val UserFormat: OFormat[User] = Json.format[User]
}

case class User(id: ID)
