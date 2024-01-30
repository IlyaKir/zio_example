package report_main.reportHandler.types.parsedExcel.common.metadata

import report_main.reportHandler.excel.Cell

case class Metadata[T](value: T, cells: List[Cell])

object Metadata {
    def apply[T](input: (T, List[Cell])): Metadata[T] = Metadata(input._1, input._2)
}
