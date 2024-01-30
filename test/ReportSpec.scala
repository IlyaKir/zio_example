import org.apache.poi.xssf.usermodel.XSSFWorkbook
import report_main.generated.kb_api.graphql.{DateInput, DateTimeValueInput, DoubleValueInput, GeoPointInput, IntValueInput, LinkValueInput, Locale, StringLocaleValueInput, StringValueInput, ValueInput}
import report_main.reportHandler.KBHeadersGetter
import report_main.Counter
import report_main.reportHandler.excel.reader.headers.ReportHeadersReader
import report_main.reportHandler.excel.reader.reportFile.{ConceptReader, LinkReader}
import report_main.reportHandler.fake.ReportHttpRequestSenderFakeLive
import report_main.reportHandler.layers.{ReportHttpRequestSender, ReportWorkbookUpdater}
import report_main.reportHandler.types.mainFiles.ReportWorkbook
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import zio.clock.Clock
import zio.console.Console
import zio.logging.{LogLevel, Logging}
import zio.{Has, RIO, Semaphore, TaskManaged, ZIO, ZLayer, ZManaged}
import zio.test._
import zio.magic._

import java.io.FileInputStream

object ReportSpec extends DefaultRunnableSpec {
    private val testFolder = "test/"
    private val reportTestFileName = "report test.xlsx"
    private val reportTestFullPath = testFolder + reportTestFileName

    private val loggingLayer = (Clock.live ++ Console.live) >>> Logging.console(logLevel = LogLevel.Info)
    private val httpRequestSenderLayer = Counter.live >>> ReportHttpRequestSenderFakeLive.layer

    private val reportUpdateThreads: Int = 1

    val readAutocloseableWorkbook: TaskManaged[XSSFWorkbook] =
        ZManaged.fromAutoCloseable(
            ZIO.effect(new FileInputStream(reportTestFullPath))
        ).flatMap { reportInputStream =>
            ZManaged.fromAutoCloseable(ZIO.effect(new XSSFWorkbook(reportInputStream)))
        }

    def spec: Spec[Any, TestFailure[Object], TestSuccess] = {
        suiteM("Report suite") {
            readAutocloseableWorkbook.use { workbook =>
                readConceptsAndLinks(workbook).map { case (concepts, links) =>
                    Seq(
                        getAvatarTests(concepts),
                        getMetadataFromToTests(concepts),
                        getMetadataNotesTests(concepts),
                        getConceptPropertyTests(concepts),
                        getPropertyValueTypeTests(concepts),
                        getLinkTests(concepts, links)
                    ).flatten
                }
            }
        }.mapError(TestFailure.fail)
            .provideLayer(loggingLayer ++ httpRequestSenderLayer)
    }

    private def readConceptsAndLinks(workbook: XSSFWorkbook): RIO[Logging with Has[ReportHttpRequestSender], (Seq[Concept], Seq[Link])] = {
        for {
            reportWorkbookUpdaterSemaphore <- Semaphore.make(permits = reportUpdateThreads)
            reportWorkbook = ReportWorkbook(workbook = workbook, path = reportTestFullPath, fileName = reportTestFileName)
            reportWorkbookUpdaterLayer = (ZLayer.succeed(reportWorkbook) ++ ZLayer.succeed(reportWorkbookUpdaterSemaphore)) >>> ReportWorkbookUpdater.layer

            (concepts, links) <- (for {
                headers <- ReportHeadersReader.readHeaders(reportWorkbook)
                kbHeaders <- KBHeadersGetter.getKBHeaders(headers)

                concepts <- ConceptReader(kbHeaders).read
                links <- LinkReader(concepts, kbHeaders).read
            } yield (concepts, links))
                .injectSome[Logging with Has[ReportHttpRequestSender]](reportWorkbookUpdaterLayer)
        } yield (concepts, links)
    }

    private def getAvatarTests(concepts: Seq[Concept]): Seq[ZSpec[Any, Nothing]] = Seq(
        test("test \'Correct metadata avatar (one value - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "OneMetadata")
            lazy val metadataAvatar = concept.head.dependencyInfo.maybeAvatar
            assertTrue(concept.length == 1, metadataAvatar.nonEmpty)
        },
        test("test \'Correct metadata avatar (several equal values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualMetadatas")
            lazy val metadataAvatar = concept.head.dependencyInfo.maybeAvatar
            assertTrue(concept.length == 1, metadataAvatar.nonEmpty)
        },
        test("test \'Correct metadata avatar (several equal values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualMetadatasAddSheet")
            lazy val metadataAvatar = concept.head.dependencyInfo.maybeAvatar
            assertTrue(concept.length == 1, metadataAvatar.nonEmpty)
        },
        test("test \'Wrong metadata avatar (several non equal values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualMetadatas")
            lazy val metadataAvatar = concept.head.dependencyInfo.maybeAvatar
            assertTrue(concept.length == 1, metadataAvatar.isEmpty)
        },
        test("test \'Wrong metadata avatar (several non equal values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualMetadatasAddSheet")
            lazy val metadataAvatar = concept.head.dependencyInfo.maybeAvatar
            assertTrue(concept.length == 1, metadataAvatar.isEmpty)
        }
    )
    private def getMetadataFromToTests(concepts: Seq[Concept]) = Seq(
        test("test \'Correct metadata from/to (one value - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "OneMetadata")
            lazy val metadataFrom = concept.head.mainInfo.metadata.maybeMetadataFrom
            lazy val metadataTo = concept.head.mainInfo.metadata.maybeMetadataTo
            assertTrue(concept.length == 1, metadataFrom.nonEmpty, metadataTo.nonEmpty)
        },
        test("test \'Correct metadata from/to (several equal values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualMetadatas")
            lazy val metadataFrom = concept.head.mainInfo.metadata.maybeMetadataFrom
            lazy val metadataTo = concept.head.mainInfo.metadata.maybeMetadataTo
            assertTrue(concept.length == 1, metadataFrom.nonEmpty, metadataTo.nonEmpty)
        },
        test("test \'Correct metadata from/to (several equal values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualMetadatasAddSheet")
            lazy val metadataFrom = concept.head.mainInfo.metadata.maybeMetadataFrom
            lazy val metadataTo = concept.head.mainInfo.metadata.maybeMetadataTo
            assertTrue(concept.length == 1, metadataFrom.nonEmpty, metadataTo.nonEmpty)
        },
        test("test \'Wrong metadata from/to (several different values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualMetadatas")
            lazy val metadataFrom = concept.head.mainInfo.metadata.maybeMetadataFrom
            lazy val metadataTo = concept.head.mainInfo.metadata.maybeMetadataTo
            assertTrue(concept.length == 1, metadataFrom.isEmpty, metadataTo.isEmpty)
        },
        test("test \'Wrong metadata from/to (several different values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualMetadatasAddSheet")
            lazy val metadataFrom = concept.head.mainInfo.metadata.maybeMetadataFrom
            lazy val metadataTo = concept.head.mainInfo.metadata.maybeMetadataTo
            assertTrue(concept.length == 1, metadataFrom.isEmpty, metadataTo.isEmpty)
        }
    )
    private def getMetadataNotesTests(concepts: Seq[Concept]) = Seq(
        test("test \'Correct metadata notes (one value - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "OneMetadata")
            lazy val metadataNotes = concept.head.mainInfo.metadata.maybeMetadataNotes
            assertTrue(concept.length == 1, metadataNotes.nonEmpty)
        },
        test("test \'Correct metadata notes (several equal values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualMetadatas")
            lazy val metadataNotes = concept.head.mainInfo.metadata.maybeMetadataNotes
            assertTrue(concept.length == 1, metadataNotes.nonEmpty)
        },
        test("test \'Correct metadata notes (several equal values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualMetadatasAddSheet")
            lazy val metadataNotes = concept.head.mainInfo.metadata.maybeMetadataNotes
            assertTrue(concept.length == 1, metadataNotes.nonEmpty)
        },
        test("test \'Wrong metadata notes (several different values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualMetadatas")
            lazy val metadataNotes = concept.head.mainInfo.metadata.maybeMetadataNotes
            assertTrue(concept.length == 1, metadataNotes.isEmpty)
        },
        test("test \'Wrong metadata notes (several different values - one pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualMetadatas")
            lazy val metadataNotes = concept.head.mainInfo.metadata.maybeMetadataNotes
            assertTrue(concept.length == 1, metadataNotes.isEmpty)
        }
    )

    private def getConceptPropertyTests(concepts: Seq[Concept]) = Seq(
        test("test \'Correct concept property (one value - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "OneProperty")
            lazy val properties = concept.head.dependencyInfo.properties
            assertTrue(
                concept.length == 1,
                properties.length == 1,
                properties.head.mainInfo.propertyIdentifier.valueInput == ValueInput(stringValueInput = Some(StringValueInput("Комментарий")))
            )
        },
        test("test \'Correct concept property (several equal values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualProperties")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue = ValueInput(stringValueInput = Some(StringValueInput("Комментарий")))
            assertTrue(
                concept.length == 1,
                properties.length == 1,
                properties.head.mainInfo.propertyCells.length == 2,
                properties.head.mainInfo.propertyIdentifier.valueInput == correctValue
            )
        },
        test("test \'Correct concept property (several equal values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralEqualPropertiesAddSheet")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue = ValueInput(stringValueInput = Some(StringValueInput("Комментарий")))
            assertTrue(
                concept.length == 1,
                properties.length == 2,
                properties.head.mainInfo.propertyCells.length == 1,
                properties.tail.head.mainInfo.propertyCells.length == 1,
                properties.head.mainInfo.propertyIdentifier.valueInput == correctValue,
                properties.tail.head.mainInfo.propertyIdentifier.valueInput == correctValue
            )
        },
        test("test \'Correct concept property (several different values - one page)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualProperties")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue1 = ValueInput(stringValueInput = Some(StringValueInput("Комментарий1")))
            lazy val correctValue2 = ValueInput(stringValueInput = Some(StringValueInput("Комментарий2")))
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 2,
                properties.head.mainInfo.propertyCells.length == 1,
                properties.tail.head.mainInfo.propertyCells.length == 1,
                excelValues.contains(correctValue1),
                excelValues.contains(correctValue2)
            )
        },
        test("test \'Correct concept property (several different values - several pages)\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "SeveralNonEqualPropertiesAddSheet")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue1 = ValueInput(stringValueInput = Some(StringValueInput("Комментарий1")))
            lazy val correctValue2 = ValueInput(stringValueInput = Some(StringValueInput("Комментарий2")))
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 2,
                properties.head.mainInfo.propertyCells.length == 1,
                properties.tail.head.mainInfo.propertyCells.length == 1,
                excelValues.contains(correctValue1),
                excelValues.contains(correctValue2)
            )
        },
    )
    private def getPropertyValueTypeTests(concepts: Seq[Concept]) = Seq(
        // StringValue
        test("test \'Correct property StringValue\'") {
            val getStringValue: String => ValueInput = { value =>
                ValueInput(stringValueInput = Some(StringValueInput(value)))
            }
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "StringValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue1 = getStringValue("Строка")
            lazy val correctValue2 = getStringValue("0")
            lazy val correctValue3 = getStringValue("0.00000000010")
            lazy val correctValue4 = getStringValue("01.01.2007")
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 4,
                excelValues.contains(correctValue1),
                excelValues.contains(correctValue2),
                excelValues.contains(correctValue3),
                excelValues.contains(correctValue4)
            )
        },
        // StringLocaleValue
        test("test \'Correct property StringLocaleValue\'") {
            val getStringLocalValue: String => ValueInput = { value =>
                ValueInput(stringLocaleValueInput = Some(StringLocaleValueInput(value, Locale.other)))
            }
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "StringLocaleValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue1 = getStringLocalValue("Строка")
            lazy val correctValue2 = getStringLocalValue("0")
            lazy val correctValue3 = getStringLocalValue("0.00000000010")
            lazy val correctValue4 = getStringLocalValue("01.01.2007")
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 4,
                excelValues.contains(correctValue1),
                excelValues.contains(correctValue2),
                excelValues.contains(correctValue3),
                excelValues.contains(correctValue4)
            )
        },
        // LinkValue
        test("test \'Correct property LinkValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "LinkValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue = ValueInput(linkValueInput = Some(LinkValueInput("Ссылка")))
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 1,
                excelValues.contains(correctValue)
            )
        },
        test("test \'Wrong property LinkValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "WrongLinkValue")
            lazy val properties = concept.head.dependencyInfo.properties
            assertTrue(
                concept.length == 1,
                properties.isEmpty,
            )
        },
        // GeoValue
        test("test \'Correct property GeoValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "GeoValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue = ValueInput(geoPointValueInput = Some(GeoPointInput(name = Some("Геолокация"))))
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 1,
                excelValues.contains(correctValue)
            )
        },
        test("test \'Wrong property GeoValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "WrongGeoValue")
            lazy val properties = concept.head.dependencyInfo.properties
            assertTrue(
                concept.length == 1,
                properties.isEmpty,
            )
        },
        // IntValue
        test("test \'Correct property IntValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "IntValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue = ValueInput(intValueInput = Some(IntValueInput(0)))
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 1,
                excelValues.contains(correctValue)
            )
        },
        test("test \'Wrong property IntValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "WrongIntValue")
            lazy val properties = concept.head.dependencyInfo.properties
            assertTrue(
                concept.length == 1,
                properties.isEmpty,
            )
        },
        // DoubleValue
        test("test \'Correct property DoubleValue\'") {
            val getDoubleValue: Double => ValueInput = { value =>
                ValueInput(doubleValueInput = Some(DoubleValueInput(value)))
            }
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "DoubleValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue1 = getDoubleValue(1.0)
            lazy val correctValue2 = getDoubleValue(0.1)
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 2,
                excelValues.contains(correctValue1),
                excelValues.contains(correctValue2)
            )
        },
        test("test \'Wrong property DoubleValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "WrongDoubleValue")
            lazy val properties = concept.head.dependencyInfo.properties
            assertTrue(
                concept.length == 1,
                properties.isEmpty,
            )
        },
        // DateValue
        test("test \'Correct property DateValue\'") {
            val getDateValue: DateInput => ValueInput = { date =>
                ValueInput(dateTimeValueInput = Some(DateTimeValueInput(date)))
            }
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "DateValue")
            lazy val properties = concept.head.dependencyInfo.properties
            lazy val correctValue1 = getDateValue(DateInput(day = Some(1), month = Some(1), year = Some(2007)))
            lazy val correctValue2 = getDateValue(DateInput(day = None, month = Some(1), year = Some(2007)))
            lazy val correctValue3 = getDateValue(DateInput(day = None, month = None, year = Some(2007)))
            lazy val excelValues = properties.map(_.mainInfo.propertyIdentifier.valueInput)
            assertTrue(
                concept.length == 1,
                properties.length == 3,
                excelValues.contains(correctValue1),
                excelValues.contains(correctValue2),
                excelValues.contains(correctValue3)
            )
        },
        test("test \'Wrong property DateValue\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "WrongDateValue")
            lazy val properties = concept.head.dependencyInfo.properties
            assertTrue(
                concept.length == 1,
                properties.isEmpty,
            )
        }
    )

    private def getLinkTests(concepts: Seq[Concept], links: Seq[Link]) = Seq(
        test("test \'Simple link\'") {
            println(links.length)
            lazy val link = links.filter(_.mainInfo.linkIdentifier.conceptFrom.mainInfo.conceptIdentifier.name == "Link(From)")
            lazy val assert = link.head.mainInfo.linkIdentifier.conceptTo.mainInfo.conceptIdentifier.name == "Link(To)"
            assertTrue(
                link.length == 1,
                assert
            )
        },
        test("test \'Concept from link column\'") {
            lazy val concept = concepts.filter(_.mainInfo.conceptIdentifier.name == "CreateConceptFromLinkColumn(To)")
            lazy val link = links.filter(_.mainInfo.linkIdentifier.conceptFrom.mainInfo.conceptIdentifier.name == "CreateConceptFromLinkColumn(From)")
            lazy val isConceptToCorrect = link.head.mainInfo.linkIdentifier.conceptTo.mainInfo.conceptIdentifier.name == "CreateConceptFromLinkColumn(To)"
            assertTrue(
                concept.length == 1,
                link.length == 1,
                isConceptToCorrect
            )
        },
        test("test \'Several equal links (one sheet)\'") {
            lazy val link = links.filter(_.mainInfo.linkIdentifier.conceptFrom.mainInfo.conceptIdentifier.name == "SeveralEqualLinks(From)")
            lazy val isConceptToCorrect = link.head.mainInfo.linkIdentifier.conceptTo.mainInfo.conceptIdentifier.name == "SeveralEqualLinks(To)"
            assertTrue(
                link.length == 1,
                isConceptToCorrect
            )
        },
        test("test \'Several non equal links (one sheet)\'") {
            lazy val link = links.filter(_.mainInfo.linkIdentifier.conceptFrom.mainInfo.conceptIdentifier.name == "SeveralNonEqualLinks(From)")
            lazy val conceptToNames = link.map(_.mainInfo.linkIdentifier.conceptTo.mainInfo.conceptIdentifier.name)
            assertTrue(
                link.length == 2,
                conceptToNames.contains("SeveralNonEqualLinks(To1)"),
                conceptToNames.contains("SeveralNonEqualLinks(To2)")
            )
        },
        test("test \'Several equal links (several sheets)\'") {
            lazy val link = links.filter(_.mainInfo.linkIdentifier.conceptFrom.mainInfo.conceptIdentifier.name == "SeveralEqualLinksAddSheet(From)")
            lazy val conceptToNames = link.map(_.mainInfo.linkIdentifier.conceptTo.mainInfo.conceptIdentifier.name)
            assertTrue(
                link.length == 2,
                conceptToNames.head == "SeveralEqualLinksAddSheet(To)",
                conceptToNames.tail.head == "SeveralEqualLinksAddSheet(To)",
            )
        },
        test("test \'Several non equal links (several sheets)\'") {
            lazy val link = links.filter { link =>
                val conceptFromName = link.mainInfo.linkIdentifier.conceptFrom.mainInfo.conceptIdentifier.name
                conceptFromName == "SeveralNonEqualLinksAddSheet(From1)" || conceptFromName == "SeveralNonEqualLinksAddSheet(From2)"
            }
            lazy val conceptToNames = link.map(_.mainInfo.linkIdentifier.conceptTo.mainInfo.conceptIdentifier.name)
            assertTrue(
                link.length == 2,
                conceptToNames.head == "SeveralNonEqualLinksAddSheet(To)",
                conceptToNames.tail.head == "SeveralNonEqualLinksAddSheet(To)",
            )
        }
    )
}
