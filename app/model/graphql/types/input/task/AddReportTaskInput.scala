package model.graphql.types.input.task

import caliban.schema.Annotations.GQLDefault
import caliban.schema.Schema
import caliban.uploads.Upload
import common.types._

object AddReportTaskInput {
    implicit val schema: Schema[Any, AddReportTaskInput] = Schema.genMacro[AddReportTaskInput].schema
}

case class AddReportTaskInput(
                                 files: Seq[Upload],
                                 accessLevel: Option[ID] = None,
                                 trustLevel: Option[TrustLevel] = None,
                                 topic: String,
                                 @GQLDefault(MessagePriority.Normal.toString)
                                 messagePriority: MessagePriority = MessagePriority.Normal,
                             )
