package model.graphql.types

import caliban.schema.Schema

case class State(isSuccess: Boolean)

object State {
    implicit val stateSchema: Schema[Any, State] = Schema.genMacro[State].schema
}
