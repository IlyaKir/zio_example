package report_main.reportHandler.types.mainFiles

import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}

trait ExcelWorkbook {
    val workbook: XSSFWorkbook
    val fileName: String

    def getSheets: List[XSSFSheet] = List.range(0, workbook.getNumberOfSheets).map(workbook.getSheetAt)
}
