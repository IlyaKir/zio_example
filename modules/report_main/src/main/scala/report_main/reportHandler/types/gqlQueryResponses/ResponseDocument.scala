package report_main.reportHandler.types.gqlQueryResponses

import caliban.client.SelectionBuilder
import report_main.generated.kb_api.graphql.Document
import report_main.generated.tcontroller.graphql.UnixTime

case class ResponseDocument(title: Option[String],
                            notes: Option[String],
                            externalUrl: Option[String],
                            publicationDate: Option[UnixTime],
                            publicationAuthor: Option[String],
                            markers: List[String])

object ResponseDocument {
    val select: SelectionBuilder[Document, ResponseDocument] =
        (Document.title ~ Document.notes ~ Document.externalUrl ~ Document.publicationDate ~ Document.publicationAuthor ~ Document.markers)
            .mapN((title, notes, externalUrl, publicationDate, publicationAuthor, markers) => ResponseDocument(title, notes, externalUrl, publicationDate, publicationAuthor, markers))
}
