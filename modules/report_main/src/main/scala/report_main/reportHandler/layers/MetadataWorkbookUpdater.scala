package report_main.reportHandler.layers

import org.apache.poi.ss.usermodel.{BorderStyle, FillPatternType}
import org.apache.poi.xssf.usermodel._
import report_main.reportHandler.excel.Cell
import report_main.reportHandler.types.mainFiles.MetadataWorkbook
import common.types.ID
import zio.{Function1ToLayerSyntax, Has, Semaphore, UIO, URLayer}

import scala.collection.mutable.ListBuffer

case class MetadataWorkbookUpdater(maybeMetadataWorkbook: Option[MetadataWorkbook], workbookUpdaterSemaphore: Semaphore) extends WorkbookUpdater {
    import report_main.reportHandler.utils.ColorPalette._

    private def withSemaphore(task: UIO[Unit]): UIO[Unit] = {
        workbookUpdaterSemaphore.withPermit(task)
    }

    private lazy val sheetName2XSSFDrawing: Map[String, XSSFDrawing] = {
        maybeMetadataWorkbook.map { metadataWorkbook =>
            metadataWorkbook.getSheets.map { sheet =>
                val drawing: XSSFDrawing = Option(sheet.getDrawingPatriarch).getOrElse(sheet.createDrawingPatriarch())
                sheet.getSheetName -> drawing
            }.toMap
        }.getOrElse(Map.empty)
    }

    private def addStringComment(cell: XSSFCell, value: String): UIO[Unit] = withSemaphore {
        UIO.succeed {
            Option(cell.getCellComment).foreach(_ => cell.removeCellComment())
            val drawing = sheetName2XSSFDrawing(cell.getSheet.getSheetName)
            val anchor = drawing.createAnchor(0, 0, 0, 0, cell.getColumnIndex, cell.getRowIndex, cell.getColumnIndex + 1, cell.getRowIndex + 1)
            val comment = drawing.createCellComment(anchor)
            comment.setString(value)
            cell.setCellComment(comment)
        }
    }

    override def addKBIdComment(cell: XSSFCell, id: ID): UIO[Unit] = addStringComment(cell, id.toString)

    override def addLinkCellConceptKBIdComment(cell: XSSFCell, kbId: ID): UIO[Unit] = UIO.unit

    override def addLinkCellLinkKBIdComment(cell: XSSFCell, kbId: ID): UIO[Unit] = UIO.unit

    override def updateMultipleKBIdsComment(cell: Cell, id: ID): UIO[Unit] = {
        val xssfCell = cell.xssfCell
        Option(xssfCell.getCellComment) match {
            case Some(xssfComment) if Option(xssfComment.getString).isDefined =>
                val commentKBIds = ListBuffer.from(xssfComment.getString.getString.split(";", -1).map(_.trim))
                commentKBIds.update(cell.valuePosition, id.toString)
                withSemaphore(UIO.succeed(xssfComment.setString(commentKBIds.mkString("; "))).unit)
            case _ => addKBIdComment(xssfCell, id)
        }
    }

    override def addSemicolons(cell: XSSFCell, n: Int): UIO[Unit] = UIO.unit

    override def removeComment(cell: XSSFCell): UIO[Unit] = withSemaphore(UIO.succeed(cell.removeCellComment()))

    // cells
    override def colorCellBlue(cell: XSSFCell): UIO[Unit] = UIO.succeed(cell.setCellStyle(blueXSSFCellStyle))

    override def colorCellGreen(cell: XSSFCell): UIO[Unit] = UIO.succeed(cell.setCellStyle(greenXSSFCellStyle))

    override def colorCellYellow(cell: XSSFCell): UIO[Unit] = UIO.succeed(cell.setCellStyle(yellowXSSFCellStyle))

    override def colorCellRed(cell: XSSFCell): UIO[Unit] = UIO.succeed(cell.setCellStyle(redXSSFCellStyle))

    override def colorCellRed(cells: Seq[XSSFCell]): UIO[Unit] = UIO.succeed(cells.foreach(_.setCellStyle(redXSSFCellStyle)))

    override def colorCellWhite(cell: XSSFCell): UIO[Unit] = UIO.succeed(cell.setCellStyle(whiteXSSFCellStyle))

    override def colorCellGrey(cell: XSSFCell): UIO[Unit] = UIO.succeed(cell.setCellStyle(greyXSSFCellStyle))

    override def colorCellGrey(cells: Seq[XSSFCell]): UIO[Unit] = UIO.succeed(cells.foreach(_.setCellStyle(greyXSSFCellStyle)))

    // tabs
    override def colorTabRed(sheet: XSSFSheet): UIO[Unit] = UIO.succeed(sheet.setTabColor(redXSSFColor))

    override def colorTabGreen(sheet: XSSFSheet): UIO[Unit] = UIO.succeed(sheet.setTabColor(greenXSSFColor))

    override def colorTabGrey(sheet: XSSFSheet): UIO[Unit] = UIO.succeed(sheet.setTabColor(greyXSSFColor))

    override def colorTabWhite(sheet: XSSFSheet): UIO[Unit] = UIO.succeed(sheet.setTabColor(whiteXSSFColor))

    private def getXSSFCellStyle(color: XSSFColor): XSSFCellStyle = {
        maybeMetadataWorkbook.map { metadataWorkbook =>
            val cellStyle = metadataWorkbook.workbook.createCellStyle()
            cellStyle.setBorderTop(BorderStyle.THIN)
            cellStyle.setBorderRight(BorderStyle.THIN)
            cellStyle.setBorderBottom(BorderStyle.THIN)
            cellStyle.setBorderLeft(BorderStyle.THIN)

            cellStyle.setTopBorderColor(lightGreyXSSFColor)
            cellStyle.setRightBorderColor(lightGreyXSSFColor)
            cellStyle.setBottomBorderColor(lightGreyXSSFColor)
            cellStyle.setLeftBorderColor(lightGreyXSSFColor)

            cellStyle.setWrapText(true)

            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND)
            cellStyle.setFillForegroundColor(color)
            cellStyle
        }.orNull
    }

    private lazy val blueXSSFCellStyle = getXSSFCellStyle(blueXSSFColor)
    private lazy val greenXSSFCellStyle = getXSSFCellStyle(greenXSSFColor)
    private lazy val redXSSFCellStyle = getXSSFCellStyle(redXSSFColor)
    private lazy val yellowXSSFCellStyle = getXSSFCellStyle(yellowXSSFColor)
    private lazy val whiteXSSFCellStyle = getXSSFCellStyle(whiteXSSFColor)
    private lazy val greyXSSFCellStyle = getXSSFCellStyle(greyXSSFColor)
}

object MetadataWorkbookUpdater {
    val layer: URLayer[Has[Option[MetadataWorkbook]] with Has[Semaphore], Has[MetadataWorkbookUpdater]] =
        (MetadataWorkbookUpdater(_, _)).toLayer
    val workbookUpdaterLayer: URLayer[Has[MetadataWorkbookUpdater], Has[WorkbookUpdater]] =
        Function1ToLayerSyntax[MetadataWorkbookUpdater, WorkbookUpdater](identity).toLayer
}
