package report_main.reportHandler.utils

import org.apache.poi.xssf.usermodel.{DefaultIndexedColorMap, XSSFColor}

import java.awt.Color

object ColorPalette {
    private val defaultIndexedColorMap = new DefaultIndexedColorMap()

    val blueXSSFColor = new XSSFColor(new Color(64, 105, 255), defaultIndexedColorMap)
    val greenXSSFColor = new XSSFColor(new Color(119, 221, 119), defaultIndexedColorMap)
    val yellowXSSFColor = new XSSFColor(new Color(255, 255, 121), defaultIndexedColorMap)
    val redXSSFColor = new XSSFColor(new Color(232, 111, 94), defaultIndexedColorMap)
    val whiteXSSFColor = new XSSFColor(new Color(255, 255, 255), defaultIndexedColorMap)
    val greyXSSFColor = new XSSFColor(new Color(145, 145, 145), defaultIndexedColorMap)
    val lightGreyXSSFColor = new XSSFColor(new Color(200, 200, 200), defaultIndexedColorMap)
}
