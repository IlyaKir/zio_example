package report_main

import zio.{Has, Ref, UIO, ULayer}

case class Counter(value: Ref[Int]) {
    def get: UIO[Ref[Int]] = UIO.succeed(value)
}
object Counter {
    val live: ULayer[Has[Counter]] = {
        Ref.make(0).map(Counter(_)).toLayer
    }
}
