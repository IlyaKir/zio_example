package report_main.reportHandler

import report_main.reportHandler.http.gqlQueryResponses.{ResponseConceptType, ResponseLinkType, ResponsePropertyType}
import report_main.reportHandler.layers.{ReportHttpRequestSender, ReportWorkbookUpdater, WorkbookUpdater}
import report_main.reportHandler.types.columnHeaders.kb
import report_main.reportHandler.types.columnHeaders.kb.{KBConceptType, KBType}
import report_main.reportHandler.types.columnHeaders.report.{Link, Property}
import report_main.reportHandler.types.parsedExcel.reportExcel.headers.{ReportSheetHeaders, SheetKBHeaders}
import common.types.ID
import zio.logging._
import zio.magic.ZioProvideMagicOps
import zio.{Has, RIO, UIO, URIO, ZIO}

object KBHeadersGetter {

    import report_main.reportHandler.sideEffects.headers.{KBHeaderSE => SE}

    def getKBHeaders(sheetsHeadersExcelInfo: List[ReportSheetHeaders]): URIO[Logging with Has[ReportWorkbookUpdater] with Has[ReportHttpRequestSender], List[SheetKBHeaders]] = {
        SE.gettingKBReportHeaders *>
            ZIO.collectAllSuccesses(sheetsHeadersExcelInfo.map(tryGetSheetKBHeadersInfo))
                .injectSome[Logging with Has[ReportWorkbookUpdater] with Has[ReportHttpRequestSender]](ReportWorkbookUpdater.workbookUpdaterLayer)
    }

    private def tryGetSheetKBHeadersInfo(singleSheetHeadersInfo: ReportSheetHeaders): RIO[Logging with Has[WorkbookUpdater] with Has[ReportHttpRequestSender], SheetKBHeaders] = {
        for {
            sheetConceptType <- getConceptType(singleSheetHeadersInfo)
            sheetConceptPropertyTypes <- ReportHttpRequestSender.getConceptPropertyTypes(sheetConceptType)
            // ResponseLinkType contains LinkPropertyTypes
            sheetLinkTypes <- ReportHttpRequestSender.getLinkTypes(sheetConceptType)
            sheetKBHeaders <- handleResponses(singleSheetHeadersInfo, sheetConceptType, sheetConceptPropertyTypes, sheetLinkTypes)
            _ = colorBadHeaders(sheetKBHeaders)
        } yield sheetKBHeaders
    }

    private def colorBadHeaders(sheetKBHeaders: SheetKBHeaders): URIO[Logging with Has[WorkbookUpdater], Unit] = {
        val sheetHeaders = sheetKBHeaders.sheetHeaders
        ZIO.succeed(
            (sheetHeaders.conceptPropertyColumnIds ++ sheetHeaders.linkColumnIds ++ sheetHeaders.linkPropertyColumnIds).foreach { id =>
                val cell = sheetHeaders.columnId2columnHeader(id).cell
                if (sheetKBHeaders.columnId2KBType.contains(id)) SE.KBTypeFound(cell)
                else SE.KBTypeNotFound(cell)
            })
    }

    private def getConceptType(sheetHeaders: ReportSheetHeaders): RIO[Logging with Has[WorkbookUpdater] with Has[ReportHttpRequestSender], ResponseConceptType] = {
        ReportHttpRequestSender.getPaginationConceptType(sheetHeaders.conceptTypeName).flatMap { responseConceptTypes =>
            responseConceptTypes.find(_.name == sheetHeaders.conceptTypeName) match {
                case Some(value) => SE.conceptTypeFound(sheetHeaders.sheet).as(value)
                case None => SE.conceptTypeNotFound(sheetHeaders.conceptTypeName, sheetHeaders.sheet) *> ZIO.fail(new Throwable)
            }
        }
    }

    private def getColumnId2ResponsePropertyType(propertyColumnHeaders: List[Property],
                                                 responsePropertyTypes: List[ResponsePropertyType]): Map[Int, ResponsePropertyType] = {

        val name2ResponsePropertyType = responsePropertyTypes.map(propertyType => propertyType.name -> propertyType).toMap
        propertyColumnHeaders.flatMap { columnHeader =>
            name2ResponsePropertyType.get(columnHeader.propertyTypeName)
                .map(responsePropertyType => columnHeader.cell.getColumnIndex -> responsePropertyType)
        }.toMap
    }

    private def handleResponses(reportSheetInfo: ReportSheetHeaders,
                                conceptType: ResponseConceptType,
                                responseConceptPropertyTypes: List[ResponsePropertyType],
                                responseLinkTypes: List[ResponseLinkType]): UIO[SheetKBHeaders] = {
        UIO.succeed {
            val columnId2ResponseConceptPropertyType = getColumnId2ResponsePropertyType(reportSheetInfo.conceptPropertyColumnHeaders, responseConceptPropertyTypes)
            val linkName2ResponseLinkTypes = responseLinkTypes.groupBy(_.name)

            val columnId2ResponseLinkType = reportSheetInfo.linkColumnHeaders.flatMap { linkColumnHeader =>
                linkName2ResponseLinkTypes.get(linkColumnHeader.linkTypeName) match {
                    case None => None
                    case Some(possibleResponseLinkTypes) => linkColumnHeader.maybeConceptToTypeName match {
                        case Some(conceptToTypeName) => possibleResponseLinkTypes.find(row =>
                            ((row.conceptToType.name == conceptToTypeName) && (row.conceptFromType.name == reportSheetInfo.conceptTypeName)) ||
                                ((row.conceptFromType.name == conceptToTypeName) && (row.conceptToType.name == reportSheetInfo.conceptTypeName)))
                            .map { responseLinkType =>
                                linkColumnHeader.cell.getColumnIndex -> responseLinkType
                            }
                        case None => possibleResponseLinkTypes.find(_.name == linkColumnHeader.linkTypeName)
                            .map(responseLinkType => linkColumnHeader.cell.getColumnIndex -> responseLinkType)
                    }
                }
            }.toMap
            val columnId2ResponseLinkPropertyType = columnId2ResponseLinkType.flatMap { case (columnId, responseLinkType) =>
                val linkPropertyColumnHeaders = reportSheetInfo.linkColumnId2LinkPropertyColumnHeaders.getOrElse(columnId, List())
                getColumnId2ResponsePropertyType(linkPropertyColumnHeaders, responseLinkType.linkPropertyTypes)
            }

            val kbConceptType = KBConceptType(ID(conceptType.id), conceptType.name)
            val columnId2KBLinkType = columnId2ResponseLinkType.map { case (columnId, responseLinkType) =>
                columnId -> kb.KBLinkType(ID(responseLinkType.id),
                    KBConceptType(ID(responseLinkType.conceptFromType.id), responseLinkType.conceptFromType.name),
                    KBConceptType(ID(responseLinkType.conceptToType.id), responseLinkType.conceptToType.name),
                    reportSheetInfo.columnId2columnHeader(columnId).asInstanceOf[Link])
            }

            val columnId2KBPropertyType = (columnId2ResponseConceptPropertyType ++ columnId2ResponseLinkPropertyType).map { case (columnId, responsePropertyType) =>
                columnId -> kb.KBPropertyType(ID(responsePropertyType.id),
                    responsePropertyType.valueType,
                    reportSheetInfo.columnId2columnHeader(columnId).asInstanceOf[Property]
                )
            }
            val columnId2KBType = (columnId2KBLinkType ++ columnId2KBPropertyType).view.mapValues(_.asInstanceOf[KBType]).toMap

            SheetKBHeaders(kbConceptType, columnId2KBType = columnId2KBType, sheetHeaders = reportSheetInfo)
        }
    }
}
