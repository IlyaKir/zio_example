package report_main.reportHandler.layers

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}
import report_main.reportHandler.excel.Cell
import common.types.ID
import zio.{Has, UIO, URIO, ZIO}

trait WorkbookUpdater {
    def addKBIdComment(cell: XSSFCell, value: ID): UIO[Unit]

    def addLinkCellConceptKBIdComment(cell: XSSFCell, kbId: ID): UIO[Unit]

    def addLinkCellLinkKBIdComment(cell: XSSFCell, kbId: ID): UIO[Unit]

    def updateMultipleKBIdsComment(cell: Cell, value: ID): UIO[Unit]

    def addSemicolons(cell: XSSFCell, n: Int): UIO[Unit]

    def removeComment(cell: XSSFCell): UIO[Unit]

    // cells
    def colorCellBlue(cell: XSSFCell): UIO[Unit]

    def colorCellGreen(cell: XSSFCell): UIO[Unit]

    def colorCellYellow(cell: XSSFCell): UIO[Unit]

    def colorCellRed(cell: XSSFCell): UIO[Unit]

    def colorCellRed(cells: Seq[XSSFCell]): UIO[Unit]

    def colorCellWhite(cell: XSSFCell): UIO[Unit]

    def colorCellGrey(cell: XSSFCell): UIO[Unit]

    def colorCellGrey(cells: Seq[XSSFCell]): UIO[Unit]

    // tabs
    def colorTabRed(sheet: XSSFSheet): UIO[Unit]

    def colorTabGreen(sheet: XSSFSheet): UIO[Unit]

    def colorTabGrey(sheet: XSSFSheet): UIO[Unit]

    def colorTabWhite(sheet: XSSFSheet): UIO[Unit]
}

object WorkbookUpdater {
    def addKBIdComment(cell: XSSFCell, value: ID): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.addKBIdComment(cell, value))

    def addLinkCellConceptKBIdComment(cell: XSSFCell, linkKBId: ID): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.addLinkCellConceptKBIdComment(cell, linkKBId))

    def addLinkCellLinkKBIdComment(cell: XSSFCell, linkKBId: ID): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.addLinkCellLinkKBIdComment(cell, linkKBId))

    def updateMultipleKBIdsComment(cell: Cell, value: ID): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.updateMultipleKBIdsComment(cell, value))

    def addSemicolons(cell: XSSFCell, n: Int): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.addSemicolons(cell, n))

    def removeComment(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.removeComment(cell))

    // cells
    def colorCellBlue(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellBlue(cell))

    def colorCellGreen(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellGreen(cell))

    def colorCellYellow(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellYellow(cell))

    def colorCellRed(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellRed(cell))

    def colorCellRed(cell: Seq[XSSFCell]): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellRed(cell))

    def colorCellWhite(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellWhite(cell))

    def colorCellGrey(cell: XSSFCell): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellGrey(cell))

    def colorCellGrey(cell: Seq[XSSFCell]): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorCellGrey(cell))

    // tabs
    def colorTabRed(sheet: XSSFSheet): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorTabRed(sheet))

    def colorTabGreen(sheet: XSSFSheet): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorTabGreen(sheet))

    def colorTabGrey(sheet: XSSFSheet): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorTabGrey(sheet))

    def colorTabWhite(sheet: XSSFSheet): URIO[Has[WorkbookUpdater], Unit] = ZIO.serviceWith[WorkbookUpdater](_.colorTabWhite(sheet))
}
