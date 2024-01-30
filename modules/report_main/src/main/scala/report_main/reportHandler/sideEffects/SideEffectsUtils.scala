package report_main.reportHandler.sideEffects

import org.apache.poi.xssf.usermodel.XSSFCell

trait SideEffectsUtils {
    protected def getCellAddress(cell: XSSFCell): String =
        s"\n\tsheet: <${cell.getSheet.getSheetName}>" +
            s"\n\tcell: ${cell.getAddress.toString}"
}
