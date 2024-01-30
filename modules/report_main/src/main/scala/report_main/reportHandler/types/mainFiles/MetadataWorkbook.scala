package report_main.reportHandler.types.mainFiles

import org.apache.poi.xssf.usermodel.XSSFWorkbook

case class MetadataWorkbook(workbook: XSSFWorkbook, fileName: String) extends ExcelWorkbook
