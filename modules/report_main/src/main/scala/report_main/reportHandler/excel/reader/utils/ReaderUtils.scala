package report_main.reportHandler.excel.reader.utils

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFRow}
import report_main.reportHandler.types.columnHeaders.kb.KBConceptType
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept.ConceptIdentifier
import zio.logging.Logging
import zio.{URIO, ZIO}

object ReaderUtils {

    import report_main.reportHandler.excel.reader.utils.CellReaderUtils.{getSingleNonEmptyStringCellValue, getSingleXSSFCell}

    def getConceptIdentifier2Cells(conceptRows: List[XSSFRow],
                                   columnId: Int,
                                   kbConceptType: KBConceptType): URIO[Logging, Map[ConceptIdentifier, List[XSSFCell]]] = {
        val row2Value = ZIO.collectAllSuccesses(conceptRows.map { row =>
            for {
                cell <- getSingleXSSFCell(row, columnId)
                value <- getSingleNonEmptyStringCellValue(cell)
            } yield (cell, value)
        })

        row2Value.map {
            _.groupBy { case (_, metadataName) =>
                ConceptIdentifier(metadataName, kbConceptType)
            }.view.mapValues(_.map { case (cell, _) => cell }).toMap
        }
    }
}
