package report_main.reportHandler.types.mainFiles

import org.apache.poi.xssf.usermodel.XSSFWorkbook
case class ReportWorkbook(workbook: XSSFWorkbook, path: String, fileName: String) extends ExcelWorkbook
