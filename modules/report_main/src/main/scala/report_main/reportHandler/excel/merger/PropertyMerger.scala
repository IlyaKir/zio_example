package report_main.reportHandler.excel.merger

import report_main.reportHandler.layers.WorkbookUpdater
import report_main.reportHandler.types.parsedExcel.reportExcel.metadata.PropertyMetadata
import report_main.reportHandler.types.parsedExcel.reportExcel.property.{Property, PropertyDependencyInfo, PropertyMainInfo, SingleSheetProperty}
import report_main.reportHandler.utils.PropertyId
import zio.{Has, URIO}
import zio.logging.Logging

import java.util.UUID

case class PropertyMerger(property: SingleSheetProperty) {
    import report_main.reportHandler.excel.merger.MergerUtils._

    def merge: URIO[Logging with Has[WorkbookUpdater], Property] = {
        for {
            maybeMetadataNotes <- mergeMetadata(property.enrichment.metadataNoteCells)
            maybeMetadataFrom <- mergeMetadata(property.enrichment.metadataFromCells)
            maybeMetadataTo <- mergeMetadata(property.enrichment.metadataToCells)
            maybeMetadataIsMain <- mergeMetadata(property.enrichment.metadataIsMainCells)
            metadata = PropertyMetadata(maybeMetadataNotes = maybeMetadataNotes,
                maybeMetadataFrom = maybeMetadataFrom, maybeMetadataTo = maybeMetadataTo, maybeMetadataIsMain = maybeMetadataIsMain)

            documents <- mergeDocuments2ReportExcelDocuments(property.enrichment.documents)

            mainInfo = PropertyMainInfo(propertyIdentifier = property.propertyIdentifier, propertyCells = property.propertyCells, metadata = metadata)
            id = {
                val maybeKBId = mainInfo.propertyCells.flatMap(_.maybeParsedComment).headOption
                maybeKBId.map(PropertyId(_)).getOrElse(PropertyId(UUID.randomUUID()))
            }
            dependencyInfo = PropertyDependencyInfo(documents = documents)
        } yield Property(id, mainInfo, dependencyInfo)
    }
}
