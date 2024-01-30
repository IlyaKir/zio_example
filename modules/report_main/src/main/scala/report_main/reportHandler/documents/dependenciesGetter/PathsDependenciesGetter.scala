package report_main.reportHandler.documents.dependenciesGetter

import report_main.reportHandler.types.documentsDependencies.DocumentPathDependencies
import report_main.reportHandler.types.parsedExcel.reportExcel.concept.Concept
import report_main.reportHandler.types.parsedExcel.reportExcel.link.Link
import zio.URIO
import zio.logging.Logging

object PathsDependenciesGetter {

    import report_main.reportHandler.sideEffects.{DocumentUploaderSE => SE}

    def getReportDocumentPathsDependencies(concepts: List[Concept], links: List[Link]): URIO[Logging, DocumentPathDependencies] = {
        val avatarPath2Concepts = concepts
            .flatMap(concept => concept.dependencyInfo.maybeAvatar.map(_.documentPath -> concept))
            .groupBy { case (path, _) => path }
            .view
            .mapValues(_.map { case (_, concept) => concept })
            .toMap
        val documentPath2Concepts = concepts
            .flatMap(concept => concept.dependencyInfo.documents.map(_.documentPath -> concept)).groupBy(_._1).view.mapValues(_.map(_._2)).toMap
        val documentPath2ConceptProperties = concepts
            .flatMap(_.dependencyInfo.properties).flatMap(property => property.dependencyInfo.documents.map(_.documentPath -> property)).groupBy(_._1).view.mapValues(_.map(_._2)).toMap
        val documentPath2Links = links
            .flatMap(link => link.dependencyInfo.documents.map(_.documentPath -> link)).groupBy(_._1).view.mapValues(_.map(_._2)).toMap
        val documentPath2LinkProperties = links
            .flatMap(_.dependencyInfo.properties).flatMap(property => property.dependencyInfo.documents.map(_.documentPath -> property)).groupBy(_._1).view.mapValues(_.map(_._2)).toMap

        val documentPath2Documents = (avatarPath2Concepts.map { case (path, concepts) => path -> concepts.flatMap(concept => concept.dependencyInfo.maybeAvatar)}.toSeq ++
            documentPath2Concepts.map { case (path, concepts) => path -> concepts.flatMap(_.dependencyInfo.documents).filter(_.documentPath == path)}.toSeq ++
            documentPath2ConceptProperties.map { case (path, properties) => path -> properties.flatMap(_.dependencyInfo.documents).filter(_.documentPath == path)}.toSeq ++
            documentPath2Links.map { case (path, links) => path -> links.flatMap(_.dependencyInfo.documents).filter(_.documentPath == path)}.toSeq ++
            documentPath2LinkProperties.map { case (path, properties) => path -> properties.flatMap(_.dependencyInfo.documents).filter(_.documentPath == path)}.toSeq)
            .groupBy(_._1).view.mapValues(_.flatMap(_._2).toList).toMap

        SE.gettingPathDependencies.as {
            DocumentPathDependencies(avatarPath2Concepts = avatarPath2Concepts,
                documentPath2Concepts = documentPath2Concepts,
                documentPath2ConceptProperties = documentPath2ConceptProperties,
                documentPath2Links = documentPath2Links,
                documentPath2LinkProperties = documentPath2LinkProperties,
                documentPath2Documents = documentPath2Documents)
        }
    }
}
