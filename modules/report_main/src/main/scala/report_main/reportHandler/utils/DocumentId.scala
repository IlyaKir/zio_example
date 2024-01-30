package report_main.reportHandler.utils

import common.types.ID

import java.util.UUID

case class DocumentId(id: Either[ID, UUID]) extends IDorUUID

object DocumentId {
    def apply(id: ID): DocumentId = DocumentId(Left(id))
    def apply(uuid: UUID): DocumentId = DocumentId(Right(uuid))
}
