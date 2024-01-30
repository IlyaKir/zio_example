package report_main.reportHandler.types.parsedExcel.common.metadata

import org.apache.poi.xssf.usermodel.XSSFCell
import report_main.reportHandler.excel.Cell

case class SingleCellMetadata[T](value: T, cell: Cell)

object SingleCellMetadata {
    def apply[T](input: (T, XSSFCell)): SingleCellMetadata[T] = SingleCellMetadata[T](input._1, input._2)
}
