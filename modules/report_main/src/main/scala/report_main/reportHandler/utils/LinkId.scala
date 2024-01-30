package report_main.reportHandler.utils

import common.types.ID

import java.util.UUID

case class LinkId(id: Either[ID, UUID]) extends IDorUUID

object LinkId {
    def apply(id: ID): LinkId = LinkId(Left(id))
    def apply(uuid: UUID): LinkId = LinkId(Right(uuid))
}
