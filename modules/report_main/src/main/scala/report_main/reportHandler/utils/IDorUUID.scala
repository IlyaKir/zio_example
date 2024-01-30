package report_main.reportHandler.utils

import common.types.ID

import java.util.UUID

trait IDorUUID {
    val id: Either[ID, UUID]

    val isKBId: Boolean = id.isLeft
    val isUUID: Boolean = id.isRight

    val maybeKBId: Option[ID] = id.fold(left => Some(left), _ => None)
    val maybeUUID: Option[UUID] = id.fold(_ => None, right => Some(right))
}
