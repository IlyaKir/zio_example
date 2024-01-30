package model.graphql.types.input.task

import caliban.schema.Annotations.{GQLDefault, GQLDescription}
import caliban.schema.Schema
import common.types._

@GQLDescription("Used in extreme cases, doesn't display on ui")
case class AddReportFromFileTaskInput(
                                         fileName: String,
                                         accessLevel: Option[ID] = None,
                                         trustLevel: Option[TrustLevel] = None,
                                         topic: String,
                                         @GQLDefault(MessagePriority.Normal.toString)
                                         messagePriority: MessagePriority = MessagePriority.Normal
                                     )

object AddReportFromFileTaskInput {
    implicit val schema: Schema[Any, AddReportFromFileTaskInput] = Schema.genMacro[AddReportFromFileTaskInput].schema
}
