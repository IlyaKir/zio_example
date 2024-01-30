package report_main.reportHandler.excel

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFRow}
import common.types.ID

case class Cell(xssfCell: XSSFCell, valuePosition: Int = 0, maybeParsedComment: Option[ID] = None) {
    def getRow: XSSFRow = xssfCell.getRow

    def getSheetName: String = getRow.getSheet.getSheetName
}
