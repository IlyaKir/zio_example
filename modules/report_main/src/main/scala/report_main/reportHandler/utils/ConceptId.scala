package report_main.reportHandler.utils

import common.types.ID

import java.util.UUID

case class ConceptId(id: Either[ID, UUID]) extends IDorUUID

object ConceptId {
    def apply(id: ID): ConceptId = ConceptId(Left(id))
    def apply(uuid: UUID): ConceptId = ConceptId(Right(uuid))
}
