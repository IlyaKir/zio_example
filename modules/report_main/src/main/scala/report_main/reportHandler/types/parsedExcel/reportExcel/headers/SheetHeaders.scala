package report_main.reportHandler.types.parsedExcel.reportExcel.headers

import org.apache.poi.xssf.usermodel.{XSSFRow, XSSFSheet}

trait SheetHeaders {
    val sheet: XSSFSheet

    lazy val sheetName: String = sheet.getSheetName
    lazy val sheetRows: List[XSSFRow] = List.range(sheet.getFirstRowNum + 1, sheet.getLastRowNum + 1).flatMap(rowNum => Option(sheet.getRow(rowNum)))
}
