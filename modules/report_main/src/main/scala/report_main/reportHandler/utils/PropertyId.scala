package report_main.reportHandler.utils

import common.types.ID

import java.util.UUID

case class PropertyId(id: Either[ID, UUID]) extends IDorUUID

object PropertyId {
    def apply(id: ID): PropertyId = PropertyId(Left(id))
    def apply(uuid: UUID): PropertyId = PropertyId(Right(uuid))
}
