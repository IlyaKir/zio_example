package model.graphql

import zio.{FiberRef, Has}

import scala.concurrent.ExecutionContext

package object context {
    type ExecContext = Has[FiberRef[ExecutionContext]]
}
