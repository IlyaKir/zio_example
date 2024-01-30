package report_main.generated.kb_api

import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client._
import caliban.client.__Value._

object graphql {

  type UnixTime = String

  type Upload = String

  sealed trait AccessLevelSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object AccessLevelSorting {
    case object order extends AccessLevelSorting { val value: String = "order" }
    case object name extends AccessLevelSorting { val value: String = "name" }
    case object id extends AccessLevelSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[AccessLevelSorting] = {
      case __StringValue("order") => Right(AccessLevelSorting.order)
      case __StringValue("name")  => Right(AccessLevelSorting.name)
      case __StringValue("id")    => Right(AccessLevelSorting.id)
      case other =>
        Left(DecodingError(s"Can't build AccessLevelSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[AccessLevelSorting] = {
      case AccessLevelSorting.order => __EnumValue("order")
      case AccessLevelSorting.name  => __EnumValue("name")
      case AccessLevelSorting.id    => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[AccessLevelSorting] =
      scala.collection.immutable.Vector(order, name, id)
  }

  sealed trait AccountSorting extends scala.Product with scala.Serializable {
    def value: String
  }
  object AccountSorting {
    case object lastUpdater extends AccountSorting {
      val value: String = "lastUpdater"
    }
    case object creator extends AccountSorting { val value: String = "creator" }
    case object systemUpdateDate extends AccountSorting {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends AccountSorting {
      val value: String = "systemRegistrationDate"
    }
    case object platformId extends AccountSorting {
      val value: String = "platformId"
    }
    case object url extends AccountSorting { val value: String = "url" }
    case object name extends AccountSorting { val value: String = "name" }
    case object id extends AccountSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[AccountSorting] = {
      case __StringValue("lastUpdater") => Right(AccountSorting.lastUpdater)
      case __StringValue("creator")     => Right(AccountSorting.creator)
      case __StringValue("systemUpdateDate") =>
        Right(AccountSorting.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(AccountSorting.systemRegistrationDate)
      case __StringValue("platformId") => Right(AccountSorting.platformId)
      case __StringValue("url")        => Right(AccountSorting.url)
      case __StringValue("name")       => Right(AccountSorting.name)
      case __StringValue("id")         => Right(AccountSorting.id)
      case other =>
        Left(DecodingError(s"Can't build AccountSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[AccountSorting] = {
      case AccountSorting.lastUpdater      => __EnumValue("lastUpdater")
      case AccountSorting.creator          => __EnumValue("creator")
      case AccountSorting.systemUpdateDate => __EnumValue("systemUpdateDate")
      case AccountSorting.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case AccountSorting.platformId => __EnumValue("platformId")
      case AccountSorting.url        => __EnumValue("url")
      case AccountSorting.name       => __EnumValue("name")
      case AccountSorting.id         => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[AccountSorting] =
      scala.collection.immutable.Vector(
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        platformId,
        url,
        name,
        id
      )
  }

  sealed trait AggregationFunction
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object AggregationFunction {
    case object weekly extends AggregationFunction {
      val value: String = "weekly"
    }
    case object monthly extends AggregationFunction {
      val value: String = "monthly"
    }
    case object daily extends AggregationFunction {
      val value: String = "daily"
    }

    implicit val decoder: ScalarDecoder[AggregationFunction] = {
      case __StringValue("weekly")  => Right(AggregationFunction.weekly)
      case __StringValue("monthly") => Right(AggregationFunction.monthly)
      case __StringValue("daily")   => Right(AggregationFunction.daily)
      case other =>
        Left(
          DecodingError(s"Can't build AggregationFunction from input $other")
        )
    }
    implicit val encoder: ArgEncoder[AggregationFunction] = {
      case AggregationFunction.weekly  => __EnumValue("weekly")
      case AggregationFunction.monthly => __EnumValue("monthly")
      case AggregationFunction.daily   => __EnumValue("daily")
    }

    val values: scala.collection.immutable.Vector[AggregationFunction] =
      scala.collection.immutable.Vector(weekly, monthly, daily)
  }

  sealed trait AutocompleteConceptDestination
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object AutocompleteConceptDestination {
    case object markers extends AutocompleteConceptDestination {
      val value: String = "markers"
    }

    implicit val decoder: ScalarDecoder[AutocompleteConceptDestination] = {
      case __StringValue("markers") =>
        Right(AutocompleteConceptDestination.markers)
      case other =>
        Left(
          DecodingError(
            s"Can't build AutocompleteConceptDestination from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[AutocompleteConceptDestination] = {
      case AutocompleteConceptDestination.markers => __EnumValue("markers")
    }

    val values
        : scala.collection.immutable.Vector[AutocompleteConceptDestination] =
      scala.collection.immutable.Vector(markers)
  }

  sealed trait AutocompleteDocumentDestination
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object AutocompleteDocumentDestination {
    case object markers extends AutocompleteDocumentDestination {
      val value: String = "markers"
    }
    case object links extends AutocompleteDocumentDestination {
      val value: String = "links"
    }

    implicit val decoder: ScalarDecoder[AutocompleteDocumentDestination] = {
      case __StringValue("markers") =>
        Right(AutocompleteDocumentDestination.markers)
      case __StringValue("links") =>
        Right(AutocompleteDocumentDestination.links)
      case other =>
        Left(
          DecodingError(
            s"Can't build AutocompleteDocumentDestination from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[AutocompleteDocumentDestination] = {
      case AutocompleteDocumentDestination.markers => __EnumValue("markers")
      case AutocompleteDocumentDestination.links   => __EnumValue("links")
    }

    val values
        : scala.collection.immutable.Vector[AutocompleteDocumentDestination] =
      scala.collection.immutable.Vector(markers, links)
  }

  sealed trait BulkType extends scala.Product with scala.Serializable {
    def value: String
  }
  object BulkType {
    case object account extends BulkType { val value: String = "account" }
    case object platform extends BulkType { val value: String = "platform" }
    case object map extends BulkType { val value: String = "map" }
    case object issue extends BulkType { val value: String = "issue" }
    case object document extends BulkType { val value: String = "document" }
    case object concept extends BulkType { val value: String = "concept" }

    implicit val decoder: ScalarDecoder[BulkType] = {
      case __StringValue("account")  => Right(BulkType.account)
      case __StringValue("platform") => Right(BulkType.platform)
      case __StringValue("map")      => Right(BulkType.map)
      case __StringValue("issue")    => Right(BulkType.issue)
      case __StringValue("document") => Right(BulkType.document)
      case __StringValue("concept")  => Right(BulkType.concept)
      case other =>
        Left(DecodingError(s"Can't build BulkType from input $other"))
    }
    implicit val encoder: ArgEncoder[BulkType] = {
      case BulkType.account  => __EnumValue("account")
      case BulkType.platform => __EnumValue("platform")
      case BulkType.map      => __EnumValue("map")
      case BulkType.issue    => __EnumValue("issue")
      case BulkType.document => __EnumValue("document")
      case BulkType.concept  => __EnumValue("concept")
    }

    val values: scala.collection.immutable.Vector[BulkType] =
      scala.collection.immutable.Vector(
        account,
        platform,
        map,
        issue,
        document,
        concept
      )
  }

  sealed trait ChartTarget extends scala.Product with scala.Serializable {
    def value: String
  }
  object ChartTarget {
    case object document extends ChartTarget { val value: String = "document" }

    implicit val decoder: ScalarDecoder[ChartTarget] = {
      case __StringValue("document") => Right(ChartTarget.document)
      case other =>
        Left(DecodingError(s"Can't build ChartTarget from input $other"))
    }
    implicit val encoder: ArgEncoder[ChartTarget] = {
      case ChartTarget.document => __EnumValue("document")
    }

    val values: scala.collection.immutable.Vector[ChartTarget] =
      scala.collection.immutable.Vector(document)
  }

  sealed trait ChartType extends scala.Product with scala.Serializable {
    def value: String
  }
  object ChartType {
    case object line extends ChartType { val value: String = "line" }

    implicit val decoder: ScalarDecoder[ChartType] = {
      case __StringValue("line") => Right(ChartType.line)
      case other =>
        Left(DecodingError(s"Can't build ChartType from input $other"))
    }
    implicit val encoder: ArgEncoder[ChartType] = { case ChartType.line =>
      __EnumValue("line")
    }

    val values: scala.collection.immutable.Vector[ChartType] =
      scala.collection.immutable.Vector(line)
  }

  sealed trait ComponentView extends scala.Product with scala.Serializable {
    def value: String
  }
  object ComponentView {
    case object value extends ComponentView { val value: String = "value" }
    case object keyValue extends ComponentView {
      val value: String = "keyValue"
    }

    implicit val decoder: ScalarDecoder[ComponentView] = {
      case __StringValue("value")    => Right(ComponentView.value)
      case __StringValue("keyValue") => Right(ComponentView.keyValue)
      case other =>
        Left(DecodingError(s"Can't build ComponentView from input $other"))
    }
    implicit val encoder: ArgEncoder[ComponentView] = {
      case ComponentView.value    => __EnumValue("value")
      case ComponentView.keyValue => __EnumValue("keyValue")
    }

    val values: scala.collection.immutable.Vector[ComponentView] =
      scala.collection.immutable.Vector(value, keyValue)
  }

  sealed trait CompositeConceptTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object CompositeConceptTypeSorting {
    case object name extends CompositeConceptTypeSorting {
      val value: String = "name"
    }
    case object id extends CompositeConceptTypeSorting {
      val value: String = "id"
    }

    implicit val decoder: ScalarDecoder[CompositeConceptTypeSorting] = {
      case __StringValue("name") => Right(CompositeConceptTypeSorting.name)
      case __StringValue("id")   => Right(CompositeConceptTypeSorting.id)
      case other =>
        Left(
          DecodingError(
            s"Can't build CompositeConceptTypeSorting from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[CompositeConceptTypeSorting] = {
      case CompositeConceptTypeSorting.name => __EnumValue("name")
      case CompositeConceptTypeSorting.id   => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[CompositeConceptTypeSorting] =
      scala.collection.immutable.Vector(name, id)
  }

  sealed trait CompositeConceptTypeWidgetTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object CompositeConceptTypeWidgetTypeSorting {
    case object order extends CompositeConceptTypeWidgetTypeSorting {
      val value: String = "order"
    }
    case object name extends CompositeConceptTypeWidgetTypeSorting {
      val value: String = "name"
    }
    case object id extends CompositeConceptTypeWidgetTypeSorting {
      val value: String = "id"
    }

    implicit val decoder
        : ScalarDecoder[CompositeConceptTypeWidgetTypeSorting] = {
      case __StringValue("order") =>
        Right(CompositeConceptTypeWidgetTypeSorting.order)
      case __StringValue("name") =>
        Right(CompositeConceptTypeWidgetTypeSorting.name)
      case __StringValue("id") =>
        Right(CompositeConceptTypeWidgetTypeSorting.id)
      case other =>
        Left(
          DecodingError(
            s"Can't build CompositeConceptTypeWidgetTypeSorting from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[CompositeConceptTypeWidgetTypeSorting] = {
      case CompositeConceptTypeWidgetTypeSorting.order => __EnumValue("order")
      case CompositeConceptTypeWidgetTypeSorting.name  => __EnumValue("name")
      case CompositeConceptTypeWidgetTypeSorting.id    => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[
      CompositeConceptTypeWidgetTypeSorting
    ] = scala.collection.immutable.Vector(order, name, id)
  }

  sealed trait CompositePropertyTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object CompositePropertyTypeSorting {
    case object registrationDate extends CompositePropertyTypeSorting {
      val value: String = "registrationDate"
    }
    case object name extends CompositePropertyTypeSorting {
      val value: String = "name"
    }
    case object id extends CompositePropertyTypeSorting {
      val value: String = "id"
    }

    implicit val decoder: ScalarDecoder[CompositePropertyTypeSorting] = {
      case __StringValue("registrationDate") =>
        Right(CompositePropertyTypeSorting.registrationDate)
      case __StringValue("name") => Right(CompositePropertyTypeSorting.name)
      case __StringValue("id")   => Right(CompositePropertyTypeSorting.id)
      case other =>
        Left(
          DecodingError(
            s"Can't build CompositePropertyTypeSorting from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[CompositePropertyTypeSorting] = {
      case CompositePropertyTypeSorting.registrationDate =>
        __EnumValue("registrationDate")
      case CompositePropertyTypeSorting.name => __EnumValue("name")
      case CompositePropertyTypeSorting.id   => __EnumValue("id")
    }

    val values
        : scala.collection.immutable.Vector[CompositePropertyTypeSorting] =
      scala.collection.immutable.Vector(registrationDate, name, id)
  }

  sealed trait CompositePropertyValueTemplateSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object CompositePropertyValueTemplateSorting {
    case object registrationDate extends CompositePropertyValueTemplateSorting {
      val value: String = "registrationDate"
    }
    case object name extends CompositePropertyValueTemplateSorting {
      val value: String = "name"
    }
    case object id extends CompositePropertyValueTemplateSorting {
      val value: String = "id"
    }

    implicit val decoder
        : ScalarDecoder[CompositePropertyValueTemplateSorting] = {
      case __StringValue("registrationDate") =>
        Right(CompositePropertyValueTemplateSorting.registrationDate)
      case __StringValue("name") =>
        Right(CompositePropertyValueTemplateSorting.name)
      case __StringValue("id") =>
        Right(CompositePropertyValueTemplateSorting.id)
      case other =>
        Left(
          DecodingError(
            s"Can't build CompositePropertyValueTemplateSorting from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[CompositePropertyValueTemplateSorting] = {
      case CompositePropertyValueTemplateSorting.registrationDate =>
        __EnumValue("registrationDate")
      case CompositePropertyValueTemplateSorting.name => __EnumValue("name")
      case CompositePropertyValueTemplateSorting.id   => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[
      CompositePropertyValueTemplateSorting
    ] = scala.collection.immutable.Vector(registrationDate, name, id)
  }

  sealed trait ConceptLinkDirection
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptLinkDirection {
    case object to extends ConceptLinkDirection { val value: String = "to" }
    case object from extends ConceptLinkDirection { val value: String = "from" }

    implicit val decoder: ScalarDecoder[ConceptLinkDirection] = {
      case __StringValue("to")   => Right(ConceptLinkDirection.to)
      case __StringValue("from") => Right(ConceptLinkDirection.from)
      case other =>
        Left(
          DecodingError(s"Can't build ConceptLinkDirection from input $other")
        )
    }
    implicit val encoder: ArgEncoder[ConceptLinkDirection] = {
      case ConceptLinkDirection.to   => __EnumValue("to")
      case ConceptLinkDirection.from => __EnumValue("from")
    }

    val values: scala.collection.immutable.Vector[ConceptLinkDirection] =
      scala.collection.immutable.Vector(to, from)
  }

  sealed trait ConceptLinkTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptLinkTypeSorting {
    case object conceptType extends ConceptLinkTypeSorting {
      val value: String = "conceptType"
    }
    case object name extends ConceptLinkTypeSorting {
      val value: String = "name"
    }
    case object id extends ConceptLinkTypeSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[ConceptLinkTypeSorting] = {
      case __StringValue("conceptType") =>
        Right(ConceptLinkTypeSorting.conceptType)
      case __StringValue("name") => Right(ConceptLinkTypeSorting.name)
      case __StringValue("id")   => Right(ConceptLinkTypeSorting.id)
      case other =>
        Left(
          DecodingError(s"Can't build ConceptLinkTypeSorting from input $other")
        )
    }
    implicit val encoder: ArgEncoder[ConceptLinkTypeSorting] = {
      case ConceptLinkTypeSorting.conceptType => __EnumValue("conceptType")
      case ConceptLinkTypeSorting.name        => __EnumValue("name")
      case ConceptLinkTypeSorting.id          => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[ConceptLinkTypeSorting] =
      scala.collection.immutable.Vector(conceptType, name, id)
  }

  sealed trait ConceptPropertyTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptPropertyTypeSorting {
    case object registrationDate extends ConceptPropertyTypeSorting {
      val value: String = "registrationDate"
    }
    case object name extends ConceptPropertyTypeSorting {
      val value: String = "name"
    }

    implicit val decoder: ScalarDecoder[ConceptPropertyTypeSorting] = {
      case __StringValue("registrationDate") =>
        Right(ConceptPropertyTypeSorting.registrationDate)
      case __StringValue("name") => Right(ConceptPropertyTypeSorting.name)
      case other =>
        Left(
          DecodingError(
            s"Can't build ConceptPropertyTypeSorting from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[ConceptPropertyTypeSorting] = {
      case ConceptPropertyTypeSorting.registrationDate =>
        __EnumValue("registrationDate")
      case ConceptPropertyTypeSorting.name => __EnumValue("name")
    }

    val values: scala.collection.immutable.Vector[ConceptPropertyTypeSorting] =
      scala.collection.immutable.Vector(registrationDate, name)
  }

  sealed trait ConceptPropertyValueTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptPropertyValueTypeSorting {
    case object regexp extends ConceptPropertyValueTypeSorting {
      val value: String = "regexp"
    }
    case object dictionary extends ConceptPropertyValueTypeSorting {
      val value: String = "dictionary"
    }
    case object valueType extends ConceptPropertyValueTypeSorting {
      val value: String = "valueType"
    }
    case object name extends ConceptPropertyValueTypeSorting {
      val value: String = "name"
    }
    case object id extends ConceptPropertyValueTypeSorting {
      val value: String = "id"
    }

    implicit val decoder: ScalarDecoder[ConceptPropertyValueTypeSorting] = {
      case __StringValue("regexp") =>
        Right(ConceptPropertyValueTypeSorting.regexp)
      case __StringValue("dictionary") =>
        Right(ConceptPropertyValueTypeSorting.dictionary)
      case __StringValue("valueType") =>
        Right(ConceptPropertyValueTypeSorting.valueType)
      case __StringValue("name") => Right(ConceptPropertyValueTypeSorting.name)
      case __StringValue("id")   => Right(ConceptPropertyValueTypeSorting.id)
      case other =>
        Left(
          DecodingError(
            s"Can't build ConceptPropertyValueTypeSorting from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[ConceptPropertyValueTypeSorting] = {
      case ConceptPropertyValueTypeSorting.regexp => __EnumValue("regexp")
      case ConceptPropertyValueTypeSorting.dictionary =>
        __EnumValue("dictionary")
      case ConceptPropertyValueTypeSorting.valueType => __EnumValue("valueType")
      case ConceptPropertyValueTypeSorting.name      => __EnumValue("name")
      case ConceptPropertyValueTypeSorting.id        => __EnumValue("id")
    }

    val values
        : scala.collection.immutable.Vector[ConceptPropertyValueTypeSorting] =
      scala.collection.immutable.Vector(regexp, dictionary, valueType, name, id)
  }

  sealed trait ConceptSorting extends scala.Product with scala.Serializable {
    def value: String
  }
  object ConceptSorting {
    case object countTasks extends ConceptSorting {
      val value: String = "countTasks"
    }
    case object countResearchMaps extends ConceptSorting {
      val value: String = "countResearchMaps"
    }
    case object countConceptsAndDocuments extends ConceptSorting {
      val value: String = "countConceptsAndDocuments"
    }
    case object countPotentialDocuments extends ConceptSorting {
      val value: String = "countPotentialDocuments"
    }
    case object countDocumentFacts extends ConceptSorting {
      val value: String = "countDocumentFacts"
    }
    case object countDocumentMentions extends ConceptSorting {
      val value: String = "countDocumentMentions"
    }
    case object countConcepts extends ConceptSorting {
      val value: String = "countConcepts"
    }
    case object countEvents extends ConceptSorting {
      val value: String = "countEvents"
    }
    case object countObjects extends ConceptSorting {
      val value: String = "countObjects"
    }
    case object countProperties extends ConceptSorting {
      val value: String = "countProperties"
    }
    case object score extends ConceptSorting { val value: String = "score" }
    case object lastUpdater extends ConceptSorting {
      val value: String = "lastUpdater"
    }
    case object creator extends ConceptSorting { val value: String = "creator" }
    case object systemUpdateDate extends ConceptSorting {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends ConceptSorting {
      val value: String = "systemRegistrationDate"
    }
    case object accessLevel extends ConceptSorting {
      val value: String = "accessLevel"
    }
    case object name extends ConceptSorting { val value: String = "name" }
    case object id extends ConceptSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[ConceptSorting] = {
      case __StringValue("countTasks") => Right(ConceptSorting.countTasks)
      case __StringValue("countResearchMaps") =>
        Right(ConceptSorting.countResearchMaps)
      case __StringValue("countConceptsAndDocuments") =>
        Right(ConceptSorting.countConceptsAndDocuments)
      case __StringValue("countPotentialDocuments") =>
        Right(ConceptSorting.countPotentialDocuments)
      case __StringValue("countDocumentFacts") =>
        Right(ConceptSorting.countDocumentFacts)
      case __StringValue("countDocumentMentions") =>
        Right(ConceptSorting.countDocumentMentions)
      case __StringValue("countConcepts") => Right(ConceptSorting.countConcepts)
      case __StringValue("countEvents")   => Right(ConceptSorting.countEvents)
      case __StringValue("countObjects")  => Right(ConceptSorting.countObjects)
      case __StringValue("countProperties") =>
        Right(ConceptSorting.countProperties)
      case __StringValue("score")       => Right(ConceptSorting.score)
      case __StringValue("lastUpdater") => Right(ConceptSorting.lastUpdater)
      case __StringValue("creator")     => Right(ConceptSorting.creator)
      case __StringValue("systemUpdateDate") =>
        Right(ConceptSorting.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(ConceptSorting.systemRegistrationDate)
      case __StringValue("accessLevel") => Right(ConceptSorting.accessLevel)
      case __StringValue("name")        => Right(ConceptSorting.name)
      case __StringValue("id")          => Right(ConceptSorting.id)
      case other =>
        Left(DecodingError(s"Can't build ConceptSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[ConceptSorting] = {
      case ConceptSorting.countTasks        => __EnumValue("countTasks")
      case ConceptSorting.countResearchMaps => __EnumValue("countResearchMaps")
      case ConceptSorting.countConceptsAndDocuments =>
        __EnumValue("countConceptsAndDocuments")
      case ConceptSorting.countPotentialDocuments =>
        __EnumValue("countPotentialDocuments")
      case ConceptSorting.countDocumentFacts =>
        __EnumValue("countDocumentFacts")
      case ConceptSorting.countDocumentMentions =>
        __EnumValue("countDocumentMentions")
      case ConceptSorting.countConcepts    => __EnumValue("countConcepts")
      case ConceptSorting.countEvents      => __EnumValue("countEvents")
      case ConceptSorting.countObjects     => __EnumValue("countObjects")
      case ConceptSorting.countProperties  => __EnumValue("countProperties")
      case ConceptSorting.score            => __EnumValue("score")
      case ConceptSorting.lastUpdater      => __EnumValue("lastUpdater")
      case ConceptSorting.creator          => __EnumValue("creator")
      case ConceptSorting.systemUpdateDate => __EnumValue("systemUpdateDate")
      case ConceptSorting.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case ConceptSorting.accessLevel => __EnumValue("accessLevel")
      case ConceptSorting.name        => __EnumValue("name")
      case ConceptSorting.id          => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[ConceptSorting] =
      scala.collection.immutable.Vector(
        countTasks,
        countResearchMaps,
        countConceptsAndDocuments,
        countPotentialDocuments,
        countDocumentFacts,
        countDocumentMentions,
        countConcepts,
        countEvents,
        countObjects,
        countProperties,
        score,
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        accessLevel,
        name,
        id
      )
  }

  sealed trait ConceptTypeLinkMetadata
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptTypeLinkMetadata {
    case object endDate extends ConceptTypeLinkMetadata {
      val value: String = "endDate"
    }
    case object startDate extends ConceptTypeLinkMetadata {
      val value: String = "startDate"
    }
    case object updateDate extends ConceptTypeLinkMetadata {
      val value: String = "updateDate"
    }
    case object registrationDate extends ConceptTypeLinkMetadata {
      val value: String = "registrationDate"
    }
    case object lastUpdater extends ConceptTypeLinkMetadata {
      val value: String = "lastUpdater"
    }
    case object creator extends ConceptTypeLinkMetadata {
      val value: String = "creator"
    }
    case object linkType extends ConceptTypeLinkMetadata {
      val value: String = "linkType"
    }

    implicit val decoder: ScalarDecoder[ConceptTypeLinkMetadata] = {
      case __StringValue("endDate") => Right(ConceptTypeLinkMetadata.endDate)
      case __StringValue("startDate") =>
        Right(ConceptTypeLinkMetadata.startDate)
      case __StringValue("updateDate") =>
        Right(ConceptTypeLinkMetadata.updateDate)
      case __StringValue("registrationDate") =>
        Right(ConceptTypeLinkMetadata.registrationDate)
      case __StringValue("lastUpdater") =>
        Right(ConceptTypeLinkMetadata.lastUpdater)
      case __StringValue("creator")  => Right(ConceptTypeLinkMetadata.creator)
      case __StringValue("linkType") => Right(ConceptTypeLinkMetadata.linkType)
      case other =>
        Left(
          DecodingError(
            s"Can't build ConceptTypeLinkMetadata from input $other"
          )
        )
    }
    implicit val encoder: ArgEncoder[ConceptTypeLinkMetadata] = {
      case ConceptTypeLinkMetadata.endDate    => __EnumValue("endDate")
      case ConceptTypeLinkMetadata.startDate  => __EnumValue("startDate")
      case ConceptTypeLinkMetadata.updateDate => __EnumValue("updateDate")
      case ConceptTypeLinkMetadata.registrationDate =>
        __EnumValue("registrationDate")
      case ConceptTypeLinkMetadata.lastUpdater => __EnumValue("lastUpdater")
      case ConceptTypeLinkMetadata.creator     => __EnumValue("creator")
      case ConceptTypeLinkMetadata.linkType    => __EnumValue("linkType")
    }

    val values: scala.collection.immutable.Vector[ConceptTypeLinkMetadata] =
      scala.collection.immutable.Vector(
        endDate,
        startDate,
        updateDate,
        registrationDate,
        lastUpdater,
        creator,
        linkType
      )
  }

  sealed trait ConceptTypeMetadata
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptTypeMetadata {
    case object image extends ConceptTypeMetadata {
      val value: String = "image"
    }
    case object markers extends ConceptTypeMetadata {
      val value: String = "markers"
    }
    case object endDate extends ConceptTypeMetadata {
      val value: String = "endDate"
    }
    case object startDate extends ConceptTypeMetadata {
      val value: String = "startDate"
    }
    case object lastUpdater extends ConceptTypeMetadata {
      val value: String = "lastUpdater"
    }
    case object creator extends ConceptTypeMetadata {
      val value: String = "creator"
    }
    case object systemUpdateDate extends ConceptTypeMetadata {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends ConceptTypeMetadata {
      val value: String = "systemRegistrationDate"
    }
    case object conceptType extends ConceptTypeMetadata {
      val value: String = "conceptType"
    }
    case object notes extends ConceptTypeMetadata {
      val value: String = "notes"
    }
    case object name extends ConceptTypeMetadata { val value: String = "name" }
    case object concept extends ConceptTypeMetadata {
      val value: String = "concept"
    }

    implicit val decoder: ScalarDecoder[ConceptTypeMetadata] = {
      case __StringValue("image")     => Right(ConceptTypeMetadata.image)
      case __StringValue("markers")   => Right(ConceptTypeMetadata.markers)
      case __StringValue("endDate")   => Right(ConceptTypeMetadata.endDate)
      case __StringValue("startDate") => Right(ConceptTypeMetadata.startDate)
      case __StringValue("lastUpdater") =>
        Right(ConceptTypeMetadata.lastUpdater)
      case __StringValue("creator") => Right(ConceptTypeMetadata.creator)
      case __StringValue("systemUpdateDate") =>
        Right(ConceptTypeMetadata.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(ConceptTypeMetadata.systemRegistrationDate)
      case __StringValue("conceptType") =>
        Right(ConceptTypeMetadata.conceptType)
      case __StringValue("notes")   => Right(ConceptTypeMetadata.notes)
      case __StringValue("name")    => Right(ConceptTypeMetadata.name)
      case __StringValue("concept") => Right(ConceptTypeMetadata.concept)
      case other =>
        Left(
          DecodingError(s"Can't build ConceptTypeMetadata from input $other")
        )
    }
    implicit val encoder: ArgEncoder[ConceptTypeMetadata] = {
      case ConceptTypeMetadata.image       => __EnumValue("image")
      case ConceptTypeMetadata.markers     => __EnumValue("markers")
      case ConceptTypeMetadata.endDate     => __EnumValue("endDate")
      case ConceptTypeMetadata.startDate   => __EnumValue("startDate")
      case ConceptTypeMetadata.lastUpdater => __EnumValue("lastUpdater")
      case ConceptTypeMetadata.creator     => __EnumValue("creator")
      case ConceptTypeMetadata.systemUpdateDate =>
        __EnumValue("systemUpdateDate")
      case ConceptTypeMetadata.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case ConceptTypeMetadata.conceptType => __EnumValue("conceptType")
      case ConceptTypeMetadata.notes       => __EnumValue("notes")
      case ConceptTypeMetadata.name        => __EnumValue("name")
      case ConceptTypeMetadata.concept     => __EnumValue("concept")
    }

    val values: scala.collection.immutable.Vector[ConceptTypeMetadata] =
      scala.collection.immutable.Vector(
        image,
        markers,
        endDate,
        startDate,
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        conceptType,
        notes,
        name,
        concept
      )
  }

  sealed trait ConceptTypeSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptTypeSorting {
    case object dictionary extends ConceptTypeSorting {
      val value: String = "dictionary"
    }
    case object regexp extends ConceptTypeSorting {
      val value: String = "regexp"
    }
    case object name extends ConceptTypeSorting { val value: String = "name" }
    case object id extends ConceptTypeSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[ConceptTypeSorting] = {
      case __StringValue("dictionary") => Right(ConceptTypeSorting.dictionary)
      case __StringValue("regexp")     => Right(ConceptTypeSorting.regexp)
      case __StringValue("name")       => Right(ConceptTypeSorting.name)
      case __StringValue("id")         => Right(ConceptTypeSorting.id)
      case other =>
        Left(DecodingError(s"Can't build ConceptTypeSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[ConceptTypeSorting] = {
      case ConceptTypeSorting.dictionary => __EnumValue("dictionary")
      case ConceptTypeSorting.regexp     => __EnumValue("regexp")
      case ConceptTypeSorting.name       => __EnumValue("name")
      case ConceptTypeSorting.id         => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[ConceptTypeSorting] =
      scala.collection.immutable.Vector(dictionary, regexp, name, id)
  }

  sealed trait ConceptUpdate extends scala.Product with scala.Serializable {
    def value: String
  }
  object ConceptUpdate {
    case object linkProperty extends ConceptUpdate {
      val value: String = "linkProperty"
    }
    case object link extends ConceptUpdate { val value: String = "link" }
    case object property extends ConceptUpdate {
      val value: String = "property"
    }
    case object metadata extends ConceptUpdate {
      val value: String = "metadata"
    }

    implicit val decoder: ScalarDecoder[ConceptUpdate] = {
      case __StringValue("linkProperty") => Right(ConceptUpdate.linkProperty)
      case __StringValue("link")         => Right(ConceptUpdate.link)
      case __StringValue("property")     => Right(ConceptUpdate.property)
      case __StringValue("metadata")     => Right(ConceptUpdate.metadata)
      case other =>
        Left(DecodingError(s"Can't build ConceptUpdate from input $other"))
    }
    implicit val encoder: ArgEncoder[ConceptUpdate] = {
      case ConceptUpdate.linkProperty => __EnumValue("linkProperty")
      case ConceptUpdate.link         => __EnumValue("link")
      case ConceptUpdate.property     => __EnumValue("property")
      case ConceptUpdate.metadata     => __EnumValue("metadata")
    }

    val values: scala.collection.immutable.Vector[ConceptUpdate] =
      scala.collection.immutable.Vector(linkProperty, link, property, metadata)
  }

  sealed trait ConceptVariant extends scala.Product with scala.Serializable {
    def value: String
  }
  object ConceptVariant {
    case object obj extends ConceptVariant { val value: String = "obj" }
    case object event extends ConceptVariant { val value: String = "event" }

    implicit val decoder: ScalarDecoder[ConceptVariant] = {
      case __StringValue("obj")   => Right(ConceptVariant.obj)
      case __StringValue("event") => Right(ConceptVariant.event)
      case other =>
        Left(DecodingError(s"Can't build ConceptVariant from input $other"))
    }
    implicit val encoder: ArgEncoder[ConceptVariant] = {
      case ConceptVariant.obj   => __EnumValue("obj")
      case ConceptVariant.event => __EnumValue("event")
    }

    val values: scala.collection.immutable.Vector[ConceptVariant] =
      scala.collection.immutable.Vector(obj, event)
  }

  sealed trait ConceptViewColumnType
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptViewColumnType {
    case object metrics extends ConceptViewColumnType {
      val value: String = "metrics"
    }
    case object lastUpdater extends ConceptViewColumnType {
      val value: String = "lastUpdater"
    }
    case object creator extends ConceptViewColumnType {
      val value: String = "creator"
    }
    case object systemUpdateDate extends ConceptViewColumnType {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends ConceptViewColumnType {
      val value: String = "systemRegistrationDate"
    }
    case object accessLevel extends ConceptViewColumnType {
      val value: String = "accessLevel"
    }
    case object conceptType extends ConceptViewColumnType {
      val value: String = "conceptType"
    }
    case object name extends ConceptViewColumnType {
      val value: String = "name"
    }
    case object image extends ConceptViewColumnType {
      val value: String = "image"
    }
    case object id extends ConceptViewColumnType { val value: String = "id" }

    implicit val decoder: ScalarDecoder[ConceptViewColumnType] = {
      case __StringValue("metrics") => Right(ConceptViewColumnType.metrics)
      case __StringValue("lastUpdater") =>
        Right(ConceptViewColumnType.lastUpdater)
      case __StringValue("creator") => Right(ConceptViewColumnType.creator)
      case __StringValue("systemUpdateDate") =>
        Right(ConceptViewColumnType.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(ConceptViewColumnType.systemRegistrationDate)
      case __StringValue("accessLevel") =>
        Right(ConceptViewColumnType.accessLevel)
      case __StringValue("conceptType") =>
        Right(ConceptViewColumnType.conceptType)
      case __StringValue("name")  => Right(ConceptViewColumnType.name)
      case __StringValue("image") => Right(ConceptViewColumnType.image)
      case __StringValue("id")    => Right(ConceptViewColumnType.id)
      case other =>
        Left(
          DecodingError(s"Can't build ConceptViewColumnType from input $other")
        )
    }
    implicit val encoder: ArgEncoder[ConceptViewColumnType] = {
      case ConceptViewColumnType.metrics     => __EnumValue("metrics")
      case ConceptViewColumnType.lastUpdater => __EnumValue("lastUpdater")
      case ConceptViewColumnType.creator     => __EnumValue("creator")
      case ConceptViewColumnType.systemUpdateDate =>
        __EnumValue("systemUpdateDate")
      case ConceptViewColumnType.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case ConceptViewColumnType.accessLevel => __EnumValue("accessLevel")
      case ConceptViewColumnType.conceptType => __EnumValue("conceptType")
      case ConceptViewColumnType.name        => __EnumValue("name")
      case ConceptViewColumnType.image       => __EnumValue("image")
      case ConceptViewColumnType.id          => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[ConceptViewColumnType] =
      scala.collection.immutable.Vector(
        metrics,
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        accessLevel,
        conceptType,
        name,
        image,
        id
      )
  }

  sealed trait ConceptViewMetricType
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ConceptViewMetricType {
    case object countTasks extends ConceptViewMetricType {
      val value: String = "countTasks"
    }
    case object countResearchMaps extends ConceptViewMetricType {
      val value: String = "countResearchMaps"
    }
    case object countConceptsAndDocuments extends ConceptViewMetricType {
      val value: String = "countConceptsAndDocuments"
    }
    case object countPotentialDocuments extends ConceptViewMetricType {
      val value: String = "countPotentialDocuments"
    }
    case object countDocumentFacts extends ConceptViewMetricType {
      val value: String = "countDocumentFacts"
    }
    case object countDocumentMentions extends ConceptViewMetricType {
      val value: String = "countDocumentMentions"
    }
    case object countConcepts extends ConceptViewMetricType {
      val value: String = "countConcepts"
    }
    case object countEvents extends ConceptViewMetricType {
      val value: String = "countEvents"
    }
    case object countObjects extends ConceptViewMetricType {
      val value: String = "countObjects"
    }
    case object countProperties extends ConceptViewMetricType {
      val value: String = "countProperties"
    }

    implicit val decoder: ScalarDecoder[ConceptViewMetricType] = {
      case __StringValue("countTasks") =>
        Right(ConceptViewMetricType.countTasks)
      case __StringValue("countResearchMaps") =>
        Right(ConceptViewMetricType.countResearchMaps)
      case __StringValue("countConceptsAndDocuments") =>
        Right(ConceptViewMetricType.countConceptsAndDocuments)
      case __StringValue("countPotentialDocuments") =>
        Right(ConceptViewMetricType.countPotentialDocuments)
      case __StringValue("countDocumentFacts") =>
        Right(ConceptViewMetricType.countDocumentFacts)
      case __StringValue("countDocumentMentions") =>
        Right(ConceptViewMetricType.countDocumentMentions)
      case __StringValue("countConcepts") =>
        Right(ConceptViewMetricType.countConcepts)
      case __StringValue("countEvents") =>
        Right(ConceptViewMetricType.countEvents)
      case __StringValue("countObjects") =>
        Right(ConceptViewMetricType.countObjects)
      case __StringValue("countProperties") =>
        Right(ConceptViewMetricType.countProperties)
      case other =>
        Left(
          DecodingError(s"Can't build ConceptViewMetricType from input $other")
        )
    }
    implicit val encoder: ArgEncoder[ConceptViewMetricType] = {
      case ConceptViewMetricType.countTasks => __EnumValue("countTasks")
      case ConceptViewMetricType.countResearchMaps =>
        __EnumValue("countResearchMaps")
      case ConceptViewMetricType.countConceptsAndDocuments =>
        __EnumValue("countConceptsAndDocuments")
      case ConceptViewMetricType.countPotentialDocuments =>
        __EnumValue("countPotentialDocuments")
      case ConceptViewMetricType.countDocumentFacts =>
        __EnumValue("countDocumentFacts")
      case ConceptViewMetricType.countDocumentMentions =>
        __EnumValue("countDocumentMentions")
      case ConceptViewMetricType.countConcepts => __EnumValue("countConcepts")
      case ConceptViewMetricType.countEvents   => __EnumValue("countEvents")
      case ConceptViewMetricType.countObjects  => __EnumValue("countObjects")
      case ConceptViewMetricType.countProperties =>
        __EnumValue("countProperties")
    }

    val values: scala.collection.immutable.Vector[ConceptViewMetricType] =
      scala.collection.immutable.Vector(
        countTasks,
        countResearchMaps,
        countConceptsAndDocuments,
        countPotentialDocuments,
        countDocumentFacts,
        countDocumentMentions,
        countConcepts,
        countEvents,
        countObjects,
        countProperties
      )
  }

  sealed trait CountryTarget extends scala.Product with scala.Serializable {
    def value: String
  }
  object CountryTarget {
    case object account extends CountryTarget { val value: String = "account" }
    case object platform extends CountryTarget {
      val value: String = "platform"
    }

    implicit val decoder: ScalarDecoder[CountryTarget] = {
      case __StringValue("account")  => Right(CountryTarget.account)
      case __StringValue("platform") => Right(CountryTarget.platform)
      case other =>
        Left(DecodingError(s"Can't build CountryTarget from input $other"))
    }
    implicit val encoder: ArgEncoder[CountryTarget] = {
      case CountryTarget.account  => __EnumValue("account")
      case CountryTarget.platform => __EnumValue("platform")
    }

    val values: scala.collection.immutable.Vector[CountryTarget] =
      scala.collection.immutable.Vector(account, platform)
  }

  sealed trait DocumentFeedMode extends scala.Product with scala.Serializable {
    def value: String
  }
  object DocumentFeedMode {
    case object deleted extends DocumentFeedMode {
      val value: String = "deleted"
    }
    case object favorites extends DocumentFeedMode {
      val value: String = "favorites"
    }
    case object all extends DocumentFeedMode { val value: String = "all" }

    implicit val decoder: ScalarDecoder[DocumentFeedMode] = {
      case __StringValue("deleted")   => Right(DocumentFeedMode.deleted)
      case __StringValue("favorites") => Right(DocumentFeedMode.favorites)
      case __StringValue("all")       => Right(DocumentFeedMode.all)
      case other =>
        Left(DecodingError(s"Can't build DocumentFeedMode from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentFeedMode] = {
      case DocumentFeedMode.deleted   => __EnumValue("deleted")
      case DocumentFeedMode.favorites => __EnumValue("favorites")
      case DocumentFeedMode.all       => __EnumValue("all")
    }

    val values: scala.collection.immutable.Vector[DocumentFeedMode] =
      scala.collection.immutable.Vector(deleted, favorites, all)
  }

  sealed trait DocumentFeedSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object DocumentFeedSorting {
    case object lastUpdater extends DocumentFeedSorting {
      val value: String = "lastUpdater"
    }
    case object creator extends DocumentFeedSorting {
      val value: String = "creator"
    }
    case object systemUpdateDate extends DocumentFeedSorting {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends DocumentFeedSorting {
      val value: String = "systemRegistrationDate"
    }
    case object name extends DocumentFeedSorting { val value: String = "name" }
    case object id extends DocumentFeedSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[DocumentFeedSorting] = {
      case __StringValue("lastUpdater") =>
        Right(DocumentFeedSorting.lastUpdater)
      case __StringValue("creator") => Right(DocumentFeedSorting.creator)
      case __StringValue("systemUpdateDate") =>
        Right(DocumentFeedSorting.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(DocumentFeedSorting.systemRegistrationDate)
      case __StringValue("name") => Right(DocumentFeedSorting.name)
      case __StringValue("id")   => Right(DocumentFeedSorting.id)
      case other =>
        Left(
          DecodingError(s"Can't build DocumentFeedSorting from input $other")
        )
    }
    implicit val encoder: ArgEncoder[DocumentFeedSorting] = {
      case DocumentFeedSorting.lastUpdater => __EnumValue("lastUpdater")
      case DocumentFeedSorting.creator     => __EnumValue("creator")
      case DocumentFeedSorting.systemUpdateDate =>
        __EnumValue("systemUpdateDate")
      case DocumentFeedSorting.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case DocumentFeedSorting.name => __EnumValue("name")
      case DocumentFeedSorting.id   => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[DocumentFeedSorting] =
      scala.collection.immutable.Vector(
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        name,
        id
      )
  }

  sealed trait DocumentGrouping extends scala.Product with scala.Serializable {
    def value: String
  }
  object DocumentGrouping {
    case object story extends DocumentGrouping { val value: String = "story" }
    case object none extends DocumentGrouping { val value: String = "none" }

    implicit val decoder: ScalarDecoder[DocumentGrouping] = {
      case __StringValue("story") => Right(DocumentGrouping.story)
      case __StringValue("none")  => Right(DocumentGrouping.none)
      case other =>
        Left(DecodingError(s"Can't build DocumentGrouping from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentGrouping] = {
      case DocumentGrouping.story => __EnumValue("story")
      case DocumentGrouping.none  => __EnumValue("none")
    }

    val values: scala.collection.immutable.Vector[DocumentGrouping] =
      scala.collection.immutable.Vector(story, none)
  }

  sealed trait DocumentRecall extends scala.Product with scala.Serializable {
    def value: String
  }
  object DocumentRecall {
    case object none extends DocumentRecall { val value: String = "none" }
    case object high extends DocumentRecall { val value: String = "high" }
    case object medium extends DocumentRecall { val value: String = "medium" }
    case object low extends DocumentRecall { val value: String = "low" }

    implicit val decoder: ScalarDecoder[DocumentRecall] = {
      case __StringValue("none")   => Right(DocumentRecall.none)
      case __StringValue("high")   => Right(DocumentRecall.high)
      case __StringValue("medium") => Right(DocumentRecall.medium)
      case __StringValue("low")    => Right(DocumentRecall.low)
      case other =>
        Left(DecodingError(s"Can't build DocumentRecall from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentRecall] = {
      case DocumentRecall.none   => __EnumValue("none")
      case DocumentRecall.high   => __EnumValue("high")
      case DocumentRecall.medium => __EnumValue("medium")
      case DocumentRecall.low    => __EnumValue("low")
    }

    val values: scala.collection.immutable.Vector[DocumentRecall] =
      scala.collection.immutable.Vector(none, high, medium, low)
  }

  sealed trait DocumentSorting extends scala.Product with scala.Serializable {
    def value: String
  }
  object DocumentSorting {
    case object countPropertyCandidates extends DocumentSorting {
      val value: String = "countPropertyCandidates"
    }
    case object countResearchMaps extends DocumentSorting {
      val value: String = "countResearchMaps"
    }
    case object countTasks extends DocumentSorting {
      val value: String = "countTasks"
    }
    case object countChildDocs extends DocumentSorting {
      val value: String = "countChildDocs"
    }
    case object countLinks extends DocumentSorting {
      val value: String = "countLinks"
    }
    case object countDisambiguatedEntities extends DocumentSorting {
      val value: String = "countDisambiguatedEntities"
    }
    case object countEntities extends DocumentSorting {
      val value: String = "countEntities"
    }
    case object countNamedEntities extends DocumentSorting {
      val value: String = "countNamedEntities"
    }
    case object countConcepts extends DocumentSorting {
      val value: String = "countConcepts"
    }
    case object countEvents extends DocumentSorting {
      val value: String = "countEvents"
    }
    case object countObjects extends DocumentSorting {
      val value: String = "countObjects"
    }
    case object score extends DocumentSorting { val value: String = "score" }
    case object trustLevel extends DocumentSorting {
      val value: String = "trustLevel"
    }
    case object secretLevel extends DocumentSorting {
      val value: String = "secretLevel"
    }
    case object updateDate extends DocumentSorting {
      val value: String = "updateDate"
    }
    case object registrationDate extends DocumentSorting {
      val value: String = "registrationDate"
    }
    case object publicationDate extends DocumentSorting {
      val value: String = "publicationDate"
    }
    case object text extends DocumentSorting { val value: String = "text" }
    case object title extends DocumentSorting { val value: String = "title" }
    case object id extends DocumentSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[DocumentSorting] = {
      case __StringValue("countPropertyCandidates") =>
        Right(DocumentSorting.countPropertyCandidates)
      case __StringValue("countResearchMaps") =>
        Right(DocumentSorting.countResearchMaps)
      case __StringValue("countTasks") => Right(DocumentSorting.countTasks)
      case __StringValue("countChildDocs") =>
        Right(DocumentSorting.countChildDocs)
      case __StringValue("countLinks") => Right(DocumentSorting.countLinks)
      case __StringValue("countDisambiguatedEntities") =>
        Right(DocumentSorting.countDisambiguatedEntities)
      case __StringValue("countEntities") =>
        Right(DocumentSorting.countEntities)
      case __StringValue("countNamedEntities") =>
        Right(DocumentSorting.countNamedEntities)
      case __StringValue("countConcepts") =>
        Right(DocumentSorting.countConcepts)
      case __StringValue("countEvents")  => Right(DocumentSorting.countEvents)
      case __StringValue("countObjects") => Right(DocumentSorting.countObjects)
      case __StringValue("score")        => Right(DocumentSorting.score)
      case __StringValue("trustLevel")   => Right(DocumentSorting.trustLevel)
      case __StringValue("secretLevel")  => Right(DocumentSorting.secretLevel)
      case __StringValue("updateDate")   => Right(DocumentSorting.updateDate)
      case __StringValue("registrationDate") =>
        Right(DocumentSorting.registrationDate)
      case __StringValue("publicationDate") =>
        Right(DocumentSorting.publicationDate)
      case __StringValue("text")  => Right(DocumentSorting.text)
      case __StringValue("title") => Right(DocumentSorting.title)
      case __StringValue("id")    => Right(DocumentSorting.id)
      case other =>
        Left(DecodingError(s"Can't build DocumentSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentSorting] = {
      case DocumentSorting.countPropertyCandidates =>
        __EnumValue("countPropertyCandidates")
      case DocumentSorting.countResearchMaps => __EnumValue("countResearchMaps")
      case DocumentSorting.countTasks        => __EnumValue("countTasks")
      case DocumentSorting.countChildDocs    => __EnumValue("countChildDocs")
      case DocumentSorting.countLinks        => __EnumValue("countLinks")
      case DocumentSorting.countDisambiguatedEntities =>
        __EnumValue("countDisambiguatedEntities")
      case DocumentSorting.countEntities => __EnumValue("countEntities")
      case DocumentSorting.countNamedEntities =>
        __EnumValue("countNamedEntities")
      case DocumentSorting.countConcepts    => __EnumValue("countConcepts")
      case DocumentSorting.countEvents      => __EnumValue("countEvents")
      case DocumentSorting.countObjects     => __EnumValue("countObjects")
      case DocumentSorting.score            => __EnumValue("score")
      case DocumentSorting.trustLevel       => __EnumValue("trustLevel")
      case DocumentSorting.secretLevel      => __EnumValue("secretLevel")
      case DocumentSorting.updateDate       => __EnumValue("updateDate")
      case DocumentSorting.registrationDate => __EnumValue("registrationDate")
      case DocumentSorting.publicationDate  => __EnumValue("publicationDate")
      case DocumentSorting.text             => __EnumValue("text")
      case DocumentSorting.title            => __EnumValue("title")
      case DocumentSorting.id               => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[DocumentSorting] =
      scala.collection.immutable.Vector(
        countPropertyCandidates,
        countResearchMaps,
        countTasks,
        countChildDocs,
        countLinks,
        countDisambiguatedEntities,
        countEntities,
        countNamedEntities,
        countConcepts,
        countEvents,
        countObjects,
        score,
        trustLevel,
        secretLevel,
        updateDate,
        registrationDate,
        publicationDate,
        text,
        title,
        id
      )
  }

  sealed trait DocumentSourceType
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object DocumentSourceType {
    case object external extends DocumentSourceType {
      val value: String = "external"
    }
    case object internal extends DocumentSourceType {
      val value: String = "internal"
    }

    implicit val decoder: ScalarDecoder[DocumentSourceType] = {
      case __StringValue("external") => Right(DocumentSourceType.external)
      case __StringValue("internal") => Right(DocumentSourceType.internal)
      case other =>
        Left(DecodingError(s"Can't build DocumentSourceType from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentSourceType] = {
      case DocumentSourceType.external => __EnumValue("external")
      case DocumentSourceType.internal => __EnumValue("internal")
    }

    val values: scala.collection.immutable.Vector[DocumentSourceType] =
      scala.collection.immutable.Vector(external, internal)
  }

  sealed trait DocumentType extends scala.Product with scala.Serializable {
    def value: String
  }
  object DocumentType {
    case object image extends DocumentType { val value: String = "image" }
    case object text extends DocumentType { val value: String = "text" }

    implicit val decoder: ScalarDecoder[DocumentType] = {
      case __StringValue("image") => Right(DocumentType.image)
      case __StringValue("text")  => Right(DocumentType.text)
      case other =>
        Left(DecodingError(s"Can't build DocumentType from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentType] = {
      case DocumentType.image => __EnumValue("image")
      case DocumentType.text  => __EnumValue("text")
    }

    val values: scala.collection.immutable.Vector[DocumentType] =
      scala.collection.immutable.Vector(image, text)
  }

  sealed trait DocumentUpdate extends scala.Product with scala.Serializable {
    def value: String
  }
  object DocumentUpdate {
    case object markup extends DocumentUpdate { val value: String = "markup" }
    case object content extends DocumentUpdate { val value: String = "content" }
    case object metadata extends DocumentUpdate {
      val value: String = "metadata"
    }

    implicit val decoder: ScalarDecoder[DocumentUpdate] = {
      case __StringValue("markup")   => Right(DocumentUpdate.markup)
      case __StringValue("content")  => Right(DocumentUpdate.content)
      case __StringValue("metadata") => Right(DocumentUpdate.metadata)
      case other =>
        Left(DecodingError(s"Can't build DocumentUpdate from input $other"))
    }
    implicit val encoder: ArgEncoder[DocumentUpdate] = {
      case DocumentUpdate.markup   => __EnumValue("markup")
      case DocumentUpdate.content  => __EnumValue("content")
      case DocumentUpdate.metadata => __EnumValue("metadata")
    }

    val values: scala.collection.immutable.Vector[DocumentUpdate] =
      scala.collection.immutable.Vector(markup, content, metadata)
  }

  sealed trait DocumentViewColumnType
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object DocumentViewColumnType {
    case object account extends DocumentViewColumnType {
      val value: String = "account"
    }
    case object platform extends DocumentViewColumnType {
      val value: String = "platform"
    }
    case object externalUrl extends DocumentViewColumnType {
      val value: String = "externalUrl"
    }
    case object trustLevel extends DocumentViewColumnType {
      val value: String = "trustLevel"
    }
    case object accessLevel extends DocumentViewColumnType {
      val value: String = "accessLevel"
    }
    case object lastUpdater extends DocumentViewColumnType {
      val value: String = "lastUpdater"
    }
    case object creator extends DocumentViewColumnType {
      val value: String = "creator"
    }
    case object systemUpdateDate extends DocumentViewColumnType {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends DocumentViewColumnType {
      val value: String = "systemRegistrationDate"
    }
    case object publicationAuthor extends DocumentViewColumnType {
      val value: String = "publicationAuthor"
    }
    case object publicationDate extends DocumentViewColumnType {
      val value: String = "publicationDate"
    }

    implicit val decoder: ScalarDecoder[DocumentViewColumnType] = {
      case __StringValue("account")  => Right(DocumentViewColumnType.account)
      case __StringValue("platform") => Right(DocumentViewColumnType.platform)
      case __StringValue("externalUrl") =>
        Right(DocumentViewColumnType.externalUrl)
      case __StringValue("trustLevel") =>
        Right(DocumentViewColumnType.trustLevel)
      case __StringValue("accessLevel") =>
        Right(DocumentViewColumnType.accessLevel)
      case __StringValue("lastUpdater") =>
        Right(DocumentViewColumnType.lastUpdater)
      case __StringValue("creator") => Right(DocumentViewColumnType.creator)
      case __StringValue("systemUpdateDate") =>
        Right(DocumentViewColumnType.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(DocumentViewColumnType.systemRegistrationDate)
      case __StringValue("publicationAuthor") =>
        Right(DocumentViewColumnType.publicationAuthor)
      case __StringValue("publicationDate") =>
        Right(DocumentViewColumnType.publicationDate)
      case other =>
        Left(
          DecodingError(s"Can't build DocumentViewColumnType from input $other")
        )
    }
    implicit val encoder: ArgEncoder[DocumentViewColumnType] = {
      case DocumentViewColumnType.account     => __EnumValue("account")
      case DocumentViewColumnType.platform    => __EnumValue("platform")
      case DocumentViewColumnType.externalUrl => __EnumValue("externalUrl")
      case DocumentViewColumnType.trustLevel  => __EnumValue("trustLevel")
      case DocumentViewColumnType.accessLevel => __EnumValue("accessLevel")
      case DocumentViewColumnType.lastUpdater => __EnumValue("lastUpdater")
      case DocumentViewColumnType.creator     => __EnumValue("creator")
      case DocumentViewColumnType.systemUpdateDate =>
        __EnumValue("systemUpdateDate")
      case DocumentViewColumnType.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case DocumentViewColumnType.publicationAuthor =>
        __EnumValue("publicationAuthor")
      case DocumentViewColumnType.publicationDate =>
        __EnumValue("publicationDate")
    }

    val values: scala.collection.immutable.Vector[DocumentViewColumnType] =
      scala.collection.immutable.Vector(
        account,
        platform,
        externalUrl,
        trustLevel,
        accessLevel,
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        publicationAuthor,
        publicationDate
      )
  }

  sealed trait DocumentViewMetricType
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object DocumentViewMetricType {
    case object countPropertyCandidates extends DocumentViewMetricType {
      val value: String = "countPropertyCandidates"
    }
    case object countResearchMaps extends DocumentViewMetricType {
      val value: String = "countResearchMaps"
    }
    case object countTasks extends DocumentViewMetricType {
      val value: String = "countTasks"
    }
    case object countLinks extends DocumentViewMetricType {
      val value: String = "countLinks"
    }
    case object countChildDocs extends DocumentViewMetricType {
      val value: String = "countChildDocs"
    }
    case object countDisambiguatedEntities extends DocumentViewMetricType {
      val value: String = "countDisambiguatedEntities"
    }
    case object countNamedEntities extends DocumentViewMetricType {
      val value: String = "countNamedEntities"
    }
    case object countEntities extends DocumentViewMetricType {
      val value: String = "countEntities"
    }
    case object countConcepts extends DocumentViewMetricType {
      val value: String = "countConcepts"
    }
    case object countEvents extends DocumentViewMetricType {
      val value: String = "countEvents"
    }
    case object countObjects extends DocumentViewMetricType {
      val value: String = "countObjects"
    }

    implicit val decoder: ScalarDecoder[DocumentViewMetricType] = {
      case __StringValue("countPropertyCandidates") =>
        Right(DocumentViewMetricType.countPropertyCandidates)
      case __StringValue("countResearchMaps") =>
        Right(DocumentViewMetricType.countResearchMaps)
      case __StringValue("countTasks") =>
        Right(DocumentViewMetricType.countTasks)
      case __StringValue("countLinks") =>
        Right(DocumentViewMetricType.countLinks)
      case __StringValue("countChildDocs") =>
        Right(DocumentViewMetricType.countChildDocs)
      case __StringValue("countDisambiguatedEntities") =>
        Right(DocumentViewMetricType.countDisambiguatedEntities)
      case __StringValue("countNamedEntities") =>
        Right(DocumentViewMetricType.countNamedEntities)
      case __StringValue("countEntities") =>
        Right(DocumentViewMetricType.countEntities)
      case __StringValue("countConcepts") =>
        Right(DocumentViewMetricType.countConcepts)
      case __StringValue("countEvents") =>
        Right(DocumentViewMetricType.countEvents)
      case __StringValue("countObjects") =>
        Right(DocumentViewMetricType.countObjects)
      case other =>
        Left(
          DecodingError(s"Can't build DocumentViewMetricType from input $other")
        )
    }
    implicit val encoder: ArgEncoder[DocumentViewMetricType] = {
      case DocumentViewMetricType.countPropertyCandidates =>
        __EnumValue("countPropertyCandidates")
      case DocumentViewMetricType.countResearchMaps =>
        __EnumValue("countResearchMaps")
      case DocumentViewMetricType.countTasks => __EnumValue("countTasks")
      case DocumentViewMetricType.countLinks => __EnumValue("countLinks")
      case DocumentViewMetricType.countChildDocs =>
        __EnumValue("countChildDocs")
      case DocumentViewMetricType.countDisambiguatedEntities =>
        __EnumValue("countDisambiguatedEntities")
      case DocumentViewMetricType.countNamedEntities =>
        __EnumValue("countNamedEntities")
      case DocumentViewMetricType.countEntities => __EnumValue("countEntities")
      case DocumentViewMetricType.countConcepts => __EnumValue("countConcepts")
      case DocumentViewMetricType.countEvents   => __EnumValue("countEvents")
      case DocumentViewMetricType.countObjects  => __EnumValue("countObjects")
    }

    val values: scala.collection.immutable.Vector[DocumentViewMetricType] =
      scala.collection.immutable.Vector(
        countPropertyCandidates,
        countResearchMaps,
        countTasks,
        countLinks,
        countChildDocs,
        countDisambiguatedEntities,
        countNamedEntities,
        countEntities,
        countConcepts,
        countEvents,
        countObjects
      )
  }

  sealed trait ElementType extends scala.Product with scala.Serializable {
    def value: String
  }
  object ElementType {
    case object blackList extends ElementType {
      val value: String = "blackList"
    }
    case object whiteList extends ElementType {
      val value: String = "whiteList"
    }

    implicit val decoder: ScalarDecoder[ElementType] = {
      case __StringValue("blackList") => Right(ElementType.blackList)
      case __StringValue("whiteList") => Right(ElementType.whiteList)
      case other =>
        Left(DecodingError(s"Can't build ElementType from input $other"))
    }
    implicit val encoder: ArgEncoder[ElementType] = {
      case ElementType.blackList => __EnumValue("blackList")
      case ElementType.whiteList => __EnumValue("whiteList")
    }

    val values: scala.collection.immutable.Vector[ElementType] =
      scala.collection.immutable.Vector(blackList, whiteList)
  }

  sealed trait FactStatus extends scala.Product with scala.Serializable {
    def value: String
  }
  object FactStatus {
    case object `new` extends FactStatus { val value: String = "`new`" }
    case object autoApproved extends FactStatus {
      val value: String = "autoApproved"
    }
    case object hidden extends FactStatus { val value: String = "hidden" }
    case object declined extends FactStatus { val value: String = "declined" }
    case object approved extends FactStatus { val value: String = "approved" }

    implicit val decoder: ScalarDecoder[FactStatus] = {
      case __StringValue("new")          => Right(FactStatus.`new`)
      case __StringValue("autoApproved") => Right(FactStatus.autoApproved)
      case __StringValue("hidden")       => Right(FactStatus.hidden)
      case __StringValue("declined")     => Right(FactStatus.declined)
      case __StringValue("approved")     => Right(FactStatus.approved)
      case other =>
        Left(DecodingError(s"Can't build FactStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[FactStatus] = {
      case FactStatus.`new`        => __EnumValue("new")
      case FactStatus.autoApproved => __EnumValue("autoApproved")
      case FactStatus.hidden       => __EnumValue("hidden")
      case FactStatus.declined     => __EnumValue("declined")
      case FactStatus.approved     => __EnumValue("approved")
    }

    val values: scala.collection.immutable.Vector[FactStatus] =
      scala.collection.immutable.Vector(
        `new`,
        autoApproved,
        hidden,
        declined,
        approved
      )
  }

  sealed trait IssuePriority extends scala.Product with scala.Serializable {
    def value: String
  }
  object IssuePriority {
    case object High extends IssuePriority { val value: String = "High" }
    case object Medium extends IssuePriority { val value: String = "Medium" }
    case object Low extends IssuePriority { val value: String = "Low" }

    implicit val decoder: ScalarDecoder[IssuePriority] = {
      case __StringValue("High")   => Right(IssuePriority.High)
      case __StringValue("Medium") => Right(IssuePriority.Medium)
      case __StringValue("Low")    => Right(IssuePriority.Low)
      case other =>
        Left(DecodingError(s"Can't build IssuePriority from input $other"))
    }
    implicit val encoder: ArgEncoder[IssuePriority] = {
      case IssuePriority.High   => __EnumValue("High")
      case IssuePriority.Medium => __EnumValue("Medium")
      case IssuePriority.Low    => __EnumValue("Low")
    }

    val values: scala.collection.immutable.Vector[IssuePriority] =
      scala.collection.immutable.Vector(High, Medium, Low)
  }

  sealed trait IssueSorting extends scala.Product with scala.Serializable {
    def value: String
  }
  object IssueSorting {
    case object executor extends IssueSorting { val value: String = "executor" }
    case object lastUpdater extends IssueSorting {
      val value: String = "lastUpdater"
    }
    case object creator extends IssueSorting { val value: String = "creator" }
    case object updateDate extends IssueSorting {
      val value: String = "updateDate"
    }
    case object registrationDate extends IssueSorting {
      val value: String = "registrationDate"
    }
    case object priority extends IssueSorting { val value: String = "priority" }
    case object status extends IssueSorting { val value: String = "status" }
    case object topic extends IssueSorting { val value: String = "topic" }
    case object id extends IssueSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[IssueSorting] = {
      case __StringValue("executor")    => Right(IssueSorting.executor)
      case __StringValue("lastUpdater") => Right(IssueSorting.lastUpdater)
      case __StringValue("creator")     => Right(IssueSorting.creator)
      case __StringValue("updateDate")  => Right(IssueSorting.updateDate)
      case __StringValue("registrationDate") =>
        Right(IssueSorting.registrationDate)
      case __StringValue("priority") => Right(IssueSorting.priority)
      case __StringValue("status")   => Right(IssueSorting.status)
      case __StringValue("topic")    => Right(IssueSorting.topic)
      case __StringValue("id")       => Right(IssueSorting.id)
      case other =>
        Left(DecodingError(s"Can't build IssueSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[IssueSorting] = {
      case IssueSorting.executor         => __EnumValue("executor")
      case IssueSorting.lastUpdater      => __EnumValue("lastUpdater")
      case IssueSorting.creator          => __EnumValue("creator")
      case IssueSorting.updateDate       => __EnumValue("updateDate")
      case IssueSorting.registrationDate => __EnumValue("registrationDate")
      case IssueSorting.priority         => __EnumValue("priority")
      case IssueSorting.status           => __EnumValue("status")
      case IssueSorting.topic            => __EnumValue("topic")
      case IssueSorting.id               => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[IssueSorting] =
      scala.collection.immutable.Vector(
        executor,
        lastUpdater,
        creator,
        updateDate,
        registrationDate,
        priority,
        status,
        topic,
        id
      )
  }

  sealed trait IssueStatus extends scala.Product with scala.Serializable {
    def value: String
  }
  object IssueStatus {
    case object dataRequested extends IssueStatus {
      val value: String = "dataRequested"
    }
    case object improvementRequested extends IssueStatus {
      val value: String = "improvementRequested"
    }
    case object reviewRequested extends IssueStatus {
      val value: String = "reviewRequested"
    }
    case object canceled extends IssueStatus { val value: String = "canceled" }
    case object closed extends IssueStatus { val value: String = "closed" }
    case object development extends IssueStatus {
      val value: String = "development"
    }
    case object `open` extends IssueStatus { val value: String = "`open`" }

    implicit val decoder: ScalarDecoder[IssueStatus] = {
      case __StringValue("dataRequested") => Right(IssueStatus.dataRequested)
      case __StringValue("improvementRequested") =>
        Right(IssueStatus.improvementRequested)
      case __StringValue("reviewRequested") =>
        Right(IssueStatus.reviewRequested)
      case __StringValue("canceled")    => Right(IssueStatus.canceled)
      case __StringValue("closed")      => Right(IssueStatus.closed)
      case __StringValue("development") => Right(IssueStatus.development)
      case __StringValue("open")        => Right(IssueStatus.`open`)
      case other =>
        Left(DecodingError(s"Can't build IssueStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[IssueStatus] = {
      case IssueStatus.dataRequested => __EnumValue("dataRequested")
      case IssueStatus.improvementRequested =>
        __EnumValue("improvementRequested")
      case IssueStatus.reviewRequested => __EnumValue("reviewRequested")
      case IssueStatus.canceled        => __EnumValue("canceled")
      case IssueStatus.closed          => __EnumValue("closed")
      case IssueStatus.development     => __EnumValue("development")
      case IssueStatus.`open`          => __EnumValue("open")
    }

    val values: scala.collection.immutable.Vector[IssueStatus] =
      scala.collection.immutable.Vector(
        dataRequested,
        improvementRequested,
        reviewRequested,
        canceled,
        closed,
        development,
        `open`
      )
  }

  sealed trait LinkDirection extends scala.Product with scala.Serializable {
    def value: String
  }
  object LinkDirection {
    case object undirected extends LinkDirection {
      val value: String = "undirected"
    }
    case object out extends LinkDirection { val value: String = "out" }
    case object in extends LinkDirection { val value: String = "in" }

    implicit val decoder: ScalarDecoder[LinkDirection] = {
      case __StringValue("undirected") => Right(LinkDirection.undirected)
      case __StringValue("out")        => Right(LinkDirection.out)
      case __StringValue("in")         => Right(LinkDirection.in)
      case other =>
        Left(DecodingError(s"Can't build LinkDirection from input $other"))
    }
    implicit val encoder: ArgEncoder[LinkDirection] = {
      case LinkDirection.undirected => __EnumValue("undirected")
      case LinkDirection.out        => __EnumValue("out")
      case LinkDirection.in         => __EnumValue("in")
    }

    val values: scala.collection.immutable.Vector[LinkDirection] =
      scala.collection.immutable.Vector(undirected, out, in)
  }

  sealed trait Locale extends scala.Product with scala.Serializable {
    def value: String
  }
  object Locale {
    case object other extends Locale { val value: String = "other" }
    case object eng extends Locale { val value: String = "eng" }
    case object ru extends Locale { val value: String = "ru" }

    implicit val decoder: ScalarDecoder[Locale] = {
      case __StringValue("other") => Right(Locale.other)
      case __StringValue("eng")   => Right(Locale.eng)
      case __StringValue("ru")    => Right(Locale.ru)
      case other                  => Left(DecodingError(s"Can't build Locale from input $other"))
    }
    implicit val encoder: ArgEncoder[Locale] = {
      case Locale.other => __EnumValue("other")
      case Locale.eng   => __EnumValue("eng")
      case Locale.ru    => __EnumValue("ru")
    }

    val values: scala.collection.immutable.Vector[Locale] =
      scala.collection.immutable.Vector(other, eng, ru)
  }

  sealed trait MapEdgeType extends scala.Product with scala.Serializable {
    def value: String
  }
  object MapEdgeType {
    case object conceptTypeLink extends MapEdgeType {
      val value: String = "conceptTypeLink"
    }
    case object documentLink extends MapEdgeType {
      val value: String = "documentLink"
    }
    case object conceptMention extends MapEdgeType {
      val value: String = "conceptMention"
    }
    case object conceptCandidateFactMention extends MapEdgeType {
      val value: String = "conceptCandidateFactMention"
    }
    case object conceptLinkCandidateFact extends MapEdgeType {
      val value: String = "conceptLinkCandidateFact"
    }
    case object conceptImplicitLink extends MapEdgeType {
      val value: String = "conceptImplicitLink"
    }
    case object conceptFactLink extends MapEdgeType {
      val value: String = "conceptFactLink"
    }
    case object conceptLink extends MapEdgeType {
      val value: String = "conceptLink"
    }

    implicit val decoder: ScalarDecoder[MapEdgeType] = {
      case __StringValue("conceptTypeLink") =>
        Right(MapEdgeType.conceptTypeLink)
      case __StringValue("documentLink")   => Right(MapEdgeType.documentLink)
      case __StringValue("conceptMention") => Right(MapEdgeType.conceptMention)
      case __StringValue("conceptCandidateFactMention") =>
        Right(MapEdgeType.conceptCandidateFactMention)
      case __StringValue("conceptLinkCandidateFact") =>
        Right(MapEdgeType.conceptLinkCandidateFact)
      case __StringValue("conceptImplicitLink") =>
        Right(MapEdgeType.conceptImplicitLink)
      case __StringValue("conceptFactLink") =>
        Right(MapEdgeType.conceptFactLink)
      case __StringValue("conceptLink") => Right(MapEdgeType.conceptLink)
      case other =>
        Left(DecodingError(s"Can't build MapEdgeType from input $other"))
    }
    implicit val encoder: ArgEncoder[MapEdgeType] = {
      case MapEdgeType.conceptTypeLink => __EnumValue("conceptTypeLink")
      case MapEdgeType.documentLink    => __EnumValue("documentLink")
      case MapEdgeType.conceptMention  => __EnumValue("conceptMention")
      case MapEdgeType.conceptCandidateFactMention =>
        __EnumValue("conceptCandidateFactMention")
      case MapEdgeType.conceptLinkCandidateFact =>
        __EnumValue("conceptLinkCandidateFact")
      case MapEdgeType.conceptImplicitLink => __EnumValue("conceptImplicitLink")
      case MapEdgeType.conceptFactLink     => __EnumValue("conceptFactLink")
      case MapEdgeType.conceptLink         => __EnumValue("conceptLink")
    }

    val values: scala.collection.immutable.Vector[MapEdgeType] =
      scala.collection.immutable.Vector(
        conceptTypeLink,
        documentLink,
        conceptMention,
        conceptCandidateFactMention,
        conceptLinkCandidateFact,
        conceptImplicitLink,
        conceptFactLink,
        conceptLink
      )
  }

  sealed trait MapNodeType extends scala.Product with scala.Serializable {
    def value: String
  }
  object MapNodeType {
    case object conceptType extends MapNodeType {
      val value: String = "conceptType"
    }
    case object conceptCandidateFact extends MapNodeType {
      val value: String = "conceptCandidateFact"
    }
    case object document extends MapNodeType { val value: String = "document" }
    case object concept extends MapNodeType { val value: String = "concept" }

    implicit val decoder: ScalarDecoder[MapNodeType] = {
      case __StringValue("conceptType") => Right(MapNodeType.conceptType)
      case __StringValue("conceptCandidateFact") =>
        Right(MapNodeType.conceptCandidateFact)
      case __StringValue("document") => Right(MapNodeType.document)
      case __StringValue("concept")  => Right(MapNodeType.concept)
      case other =>
        Left(DecodingError(s"Can't build MapNodeType from input $other"))
    }
    implicit val encoder: ArgEncoder[MapNodeType] = {
      case MapNodeType.conceptType => __EnumValue("conceptType")
      case MapNodeType.conceptCandidateFact =>
        __EnumValue("conceptCandidateFact")
      case MapNodeType.document => __EnumValue("document")
      case MapNodeType.concept  => __EnumValue("concept")
    }

    val values: scala.collection.immutable.Vector[MapNodeType] =
      scala.collection.immutable.Vector(
        conceptType,
        conceptCandidateFact,
        document,
        concept
      )
  }

  sealed trait NodeType extends scala.Product with scala.Serializable {
    def value: String
  }
  object NodeType {
    case object other extends NodeType { val value: String = "other" }
    case object image extends NodeType { val value: String = "image" }
    case object row extends NodeType { val value: String = "row" }
    case object table extends NodeType { val value: String = "table" }
    case object key extends NodeType { val value: String = "key" }
    case object json extends NodeType { val value: String = "json" }
    case object list extends NodeType { val value: String = "list" }
    case object text extends NodeType { val value: String = "text" }
    case object header extends NodeType { val value: String = "header" }

    implicit val decoder: ScalarDecoder[NodeType] = {
      case __StringValue("other")  => Right(NodeType.other)
      case __StringValue("image")  => Right(NodeType.image)
      case __StringValue("row")    => Right(NodeType.row)
      case __StringValue("table")  => Right(NodeType.table)
      case __StringValue("key")    => Right(NodeType.key)
      case __StringValue("json")   => Right(NodeType.json)
      case __StringValue("list")   => Right(NodeType.list)
      case __StringValue("text")   => Right(NodeType.text)
      case __StringValue("header") => Right(NodeType.header)
      case other =>
        Left(DecodingError(s"Can't build NodeType from input $other"))
    }
    implicit val encoder: ArgEncoder[NodeType] = {
      case NodeType.other  => __EnumValue("other")
      case NodeType.image  => __EnumValue("image")
      case NodeType.row    => __EnumValue("row")
      case NodeType.table  => __EnumValue("table")
      case NodeType.key    => __EnumValue("key")
      case NodeType.json   => __EnumValue("json")
      case NodeType.list   => __EnumValue("list")
      case NodeType.text   => __EnumValue("text")
      case NodeType.header => __EnumValue("header")
    }

    val values: scala.collection.immutable.Vector[NodeType] =
      scala.collection.immutable.Vector(
        other,
        image,
        row,
        table,
        key,
        json,
        list,
        text,
        header
      )
  }

  sealed trait PlatformSorting extends scala.Product with scala.Serializable {
    def value: String
  }
  object PlatformSorting {
    case object lastUpdater extends PlatformSorting {
      val value: String = "lastUpdater"
    }
    case object creator extends PlatformSorting {
      val value: String = "creator"
    }
    case object systemUpdateDate extends PlatformSorting {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends PlatformSorting {
      val value: String = "systemRegistrationDate"
    }
    case object platformType extends PlatformSorting {
      val value: String = "platformType"
    }
    case object url extends PlatformSorting { val value: String = "url" }
    case object name extends PlatformSorting { val value: String = "name" }
    case object id extends PlatformSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[PlatformSorting] = {
      case __StringValue("lastUpdater") => Right(PlatformSorting.lastUpdater)
      case __StringValue("creator")     => Right(PlatformSorting.creator)
      case __StringValue("systemUpdateDate") =>
        Right(PlatformSorting.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(PlatformSorting.systemRegistrationDate)
      case __StringValue("platformType") => Right(PlatformSorting.platformType)
      case __StringValue("url")          => Right(PlatformSorting.url)
      case __StringValue("name")         => Right(PlatformSorting.name)
      case __StringValue("id")           => Right(PlatformSorting.id)
      case other =>
        Left(DecodingError(s"Can't build PlatformSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[PlatformSorting] = {
      case PlatformSorting.lastUpdater      => __EnumValue("lastUpdater")
      case PlatformSorting.creator          => __EnumValue("creator")
      case PlatformSorting.systemUpdateDate => __EnumValue("systemUpdateDate")
      case PlatformSorting.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case PlatformSorting.platformType => __EnumValue("platformType")
      case PlatformSorting.url          => __EnumValue("url")
      case PlatformSorting.name         => __EnumValue("name")
      case PlatformSorting.id           => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[PlatformSorting] =
      scala.collection.immutable.Vector(
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        platformType,
        url,
        name,
        id
      )
  }

  sealed trait PlatformType extends scala.Product with scala.Serializable {
    def value: String
  }
  object PlatformType {
    case object fileStorage extends PlatformType {
      val value: String = "fileStorage"
    }
    case object database extends PlatformType { val value: String = "database" }
    case object procurement extends PlatformType {
      val value: String = "procurement"
    }
    case object review extends PlatformType { val value: String = "review" }
    case object forum extends PlatformType { val value: String = "forum" }
    case object newsAggregator extends PlatformType {
      val value: String = "newsAggregator"
    }
    case object media extends PlatformType { val value: String = "media" }
    case object blog extends PlatformType { val value: String = "blog" }
    case object messenger extends PlatformType {
      val value: String = "messenger"
    }
    case object socialNetwork extends PlatformType {
      val value: String = "socialNetwork"
    }

    implicit val decoder: ScalarDecoder[PlatformType] = {
      case __StringValue("fileStorage")    => Right(PlatformType.fileStorage)
      case __StringValue("database")       => Right(PlatformType.database)
      case __StringValue("procurement")    => Right(PlatformType.procurement)
      case __StringValue("review")         => Right(PlatformType.review)
      case __StringValue("forum")          => Right(PlatformType.forum)
      case __StringValue("newsAggregator") => Right(PlatformType.newsAggregator)
      case __StringValue("media")          => Right(PlatformType.media)
      case __StringValue("blog")           => Right(PlatformType.blog)
      case __StringValue("messenger")      => Right(PlatformType.messenger)
      case __StringValue("socialNetwork")  => Right(PlatformType.socialNetwork)
      case other =>
        Left(DecodingError(s"Can't build PlatformType from input $other"))
    }
    implicit val encoder: ArgEncoder[PlatformType] = {
      case PlatformType.fileStorage    => __EnumValue("fileStorage")
      case PlatformType.database       => __EnumValue("database")
      case PlatformType.procurement    => __EnumValue("procurement")
      case PlatformType.review         => __EnumValue("review")
      case PlatformType.forum          => __EnumValue("forum")
      case PlatformType.newsAggregator => __EnumValue("newsAggregator")
      case PlatformType.media          => __EnumValue("media")
      case PlatformType.blog           => __EnumValue("blog")
      case PlatformType.messenger      => __EnumValue("messenger")
      case PlatformType.socialNetwork  => __EnumValue("socialNetwork")
    }

    val values: scala.collection.immutable.Vector[PlatformType] =
      scala.collection.immutable.Vector(
        fileStorage,
        database,
        procurement,
        review,
        forum,
        newsAggregator,
        media,
        blog,
        messenger,
        socialNetwork
      )
  }

  sealed trait PropLinkOrConcept extends scala.Product with scala.Serializable {
    def value: String
  }
  object PropLinkOrConcept {
    case object link extends PropLinkOrConcept { val value: String = "link" }
    case object concept extends PropLinkOrConcept {
      val value: String = "concept"
    }

    implicit val decoder: ScalarDecoder[PropLinkOrConcept] = {
      case __StringValue("link")    => Right(PropLinkOrConcept.link)
      case __StringValue("concept") => Right(PropLinkOrConcept.concept)
      case other =>
        Left(DecodingError(s"Can't build PropLinkOrConcept from input $other"))
    }
    implicit val encoder: ArgEncoder[PropLinkOrConcept] = {
      case PropLinkOrConcept.link    => __EnumValue("link")
      case PropLinkOrConcept.concept => __EnumValue("concept")
    }

    val values: scala.collection.immutable.Vector[PropLinkOrConcept] =
      scala.collection.immutable.Vector(link, concept)
  }

  sealed trait RedmineIssueType extends scala.Product with scala.Serializable {
    def value: String
  }
  object RedmineIssueType {
    case object document extends RedmineIssueType {
      val value: String = "document"
    }
    case object concept extends RedmineIssueType {
      val value: String = "concept"
    }

    implicit val decoder: ScalarDecoder[RedmineIssueType] = {
      case __StringValue("document") => Right(RedmineIssueType.document)
      case __StringValue("concept")  => Right(RedmineIssueType.concept)
      case other =>
        Left(DecodingError(s"Can't build RedmineIssueType from input $other"))
    }
    implicit val encoder: ArgEncoder[RedmineIssueType] = {
      case RedmineIssueType.document => __EnumValue("document")
      case RedmineIssueType.concept  => __EnumValue("concept")
    }

    val values: scala.collection.immutable.Vector[RedmineIssueType] =
      scala.collection.immutable.Vector(document, concept)
  }

  sealed trait RelatedDocumentSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object RelatedDocumentSorting {
    case object updateDate extends RelatedDocumentSorting {
      val value: String = "updateDate"
    }
    case object registrationDate extends RelatedDocumentSorting {
      val value: String = "registrationDate"
    }
    case object publicationDate extends RelatedDocumentSorting {
      val value: String = "publicationDate"
    }

    implicit val decoder: ScalarDecoder[RelatedDocumentSorting] = {
      case __StringValue("updateDate") =>
        Right(RelatedDocumentSorting.updateDate)
      case __StringValue("registrationDate") =>
        Right(RelatedDocumentSorting.registrationDate)
      case __StringValue("publicationDate") =>
        Right(RelatedDocumentSorting.publicationDate)
      case other =>
        Left(
          DecodingError(s"Can't build RelatedDocumentSorting from input $other")
        )
    }
    implicit val encoder: ArgEncoder[RelatedDocumentSorting] = {
      case RelatedDocumentSorting.updateDate => __EnumValue("updateDate")
      case RelatedDocumentSorting.registrationDate =>
        __EnumValue("registrationDate")
      case RelatedDocumentSorting.publicationDate =>
        __EnumValue("publicationDate")
    }

    val values: scala.collection.immutable.Vector[RelatedDocumentSorting] =
      scala.collection.immutable.Vector(
        updateDate,
        registrationDate,
        publicationDate
      )
  }

  sealed trait ResearchMapSorting
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object ResearchMapSorting {
    case object conceptAndDocumentLink extends ResearchMapSorting {
      val value: String = "conceptAndDocumentLink"
    }
    case object documentLink extends ResearchMapSorting {
      val value: String = "documentLink"
    }
    case object conceptLink extends ResearchMapSorting {
      val value: String = "conceptLink"
    }
    case object lastUpdater extends ResearchMapSorting {
      val value: String = "lastUpdater"
    }
    case object creator extends ResearchMapSorting {
      val value: String = "creator"
    }
    case object systemUpdateDate extends ResearchMapSorting {
      val value: String = "systemUpdateDate"
    }
    case object systemRegistrationDate extends ResearchMapSorting {
      val value: String = "systemRegistrationDate"
    }
    case object accessLevel extends ResearchMapSorting {
      val value: String = "accessLevel"
    }
    case object name extends ResearchMapSorting { val value: String = "name" }
    case object id extends ResearchMapSorting { val value: String = "id" }

    implicit val decoder: ScalarDecoder[ResearchMapSorting] = {
      case __StringValue("conceptAndDocumentLink") =>
        Right(ResearchMapSorting.conceptAndDocumentLink)
      case __StringValue("documentLink") =>
        Right(ResearchMapSorting.documentLink)
      case __StringValue("conceptLink") => Right(ResearchMapSorting.conceptLink)
      case __StringValue("lastUpdater") => Right(ResearchMapSorting.lastUpdater)
      case __StringValue("creator")     => Right(ResearchMapSorting.creator)
      case __StringValue("systemUpdateDate") =>
        Right(ResearchMapSorting.systemUpdateDate)
      case __StringValue("systemRegistrationDate") =>
        Right(ResearchMapSorting.systemRegistrationDate)
      case __StringValue("accessLevel") => Right(ResearchMapSorting.accessLevel)
      case __StringValue("name")        => Right(ResearchMapSorting.name)
      case __StringValue("id")          => Right(ResearchMapSorting.id)
      case other =>
        Left(DecodingError(s"Can't build ResearchMapSorting from input $other"))
    }
    implicit val encoder: ArgEncoder[ResearchMapSorting] = {
      case ResearchMapSorting.conceptAndDocumentLink =>
        __EnumValue("conceptAndDocumentLink")
      case ResearchMapSorting.documentLink => __EnumValue("documentLink")
      case ResearchMapSorting.conceptLink  => __EnumValue("conceptLink")
      case ResearchMapSorting.lastUpdater  => __EnumValue("lastUpdater")
      case ResearchMapSorting.creator      => __EnumValue("creator")
      case ResearchMapSorting.systemUpdateDate =>
        __EnumValue("systemUpdateDate")
      case ResearchMapSorting.systemRegistrationDate =>
        __EnumValue("systemRegistrationDate")
      case ResearchMapSorting.accessLevel => __EnumValue("accessLevel")
      case ResearchMapSorting.name        => __EnumValue("name")
      case ResearchMapSorting.id          => __EnumValue("id")
    }

    val values: scala.collection.immutable.Vector[ResearchMapSorting] =
      scala.collection.immutable.Vector(
        conceptAndDocumentLink,
        documentLink,
        conceptLink,
        lastUpdater,
        creator,
        systemUpdateDate,
        systemRegistrationDate,
        accessLevel,
        name,
        id
      )
  }

  sealed trait SortDirection extends scala.Product with scala.Serializable {
    def value: String
  }
  object SortDirection {
    case object ascending extends SortDirection {
      val value: String = "ascending"
    }
    case object descending extends SortDirection {
      val value: String = "descending"
    }

    implicit val decoder: ScalarDecoder[SortDirection] = {
      case __StringValue("ascending")  => Right(SortDirection.ascending)
      case __StringValue("descending") => Right(SortDirection.descending)
      case other =>
        Left(DecodingError(s"Can't build SortDirection from input $other"))
    }
    implicit val encoder: ArgEncoder[SortDirection] = {
      case SortDirection.ascending  => __EnumValue("ascending")
      case SortDirection.descending => __EnumValue("descending")
    }

    val values: scala.collection.immutable.Vector[SortDirection] =
      scala.collection.immutable.Vector(ascending, descending)
  }

  sealed trait TrustLevel extends scala.Product with scala.Serializable {
    def value: String
  }
  object TrustLevel {
    case object high extends TrustLevel { val value: String = "high" }
    case object medium extends TrustLevel { val value: String = "medium" }
    case object low extends TrustLevel { val value: String = "low" }

    implicit val decoder: ScalarDecoder[TrustLevel] = {
      case __StringValue("high")   => Right(TrustLevel.high)
      case __StringValue("medium") => Right(TrustLevel.medium)
      case __StringValue("low")    => Right(TrustLevel.low)
      case other =>
        Left(DecodingError(s"Can't build TrustLevel from input $other"))
    }
    implicit val encoder: ArgEncoder[TrustLevel] = {
      case TrustLevel.high   => __EnumValue("high")
      case TrustLevel.medium => __EnumValue("medium")
      case TrustLevel.low    => __EnumValue("low")
    }

    val values: scala.collection.immutable.Vector[TrustLevel] =
      scala.collection.immutable.Vector(high, medium, low)
  }

  sealed trait ValueType extends scala.Product with scala.Serializable {
    def value: String
  }
  object ValueType {
    case object Link extends ValueType { val value: String = "Link" }
    case object Double extends ValueType { val value: String = "Double" }
    case object StringLocale extends ValueType {
      val value: String = "StringLocale"
    }
    case object Geo extends ValueType { val value: String = "Geo" }
    case object Date extends ValueType { val value: String = "Date" }
    case object Int extends ValueType { val value: String = "Int" }
    case object String extends ValueType { val value: String = "String" }

    implicit val decoder: ScalarDecoder[ValueType] = {
      case __StringValue("Link")         => Right(ValueType.Link)
      case __StringValue("Double")       => Right(ValueType.Double)
      case __StringValue("StringLocale") => Right(ValueType.StringLocale)
      case __StringValue("Geo")          => Right(ValueType.Geo)
      case __StringValue("Date")         => Right(ValueType.Date)
      case __StringValue("Int")          => Right(ValueType.Int)
      case __StringValue("String")       => Right(ValueType.String)
      case other =>
        Left(DecodingError(s"Can't build ValueType from input $other"))
    }
    implicit val encoder: ArgEncoder[ValueType] = {
      case ValueType.Link         => __EnumValue("Link")
      case ValueType.Double       => __EnumValue("Double")
      case ValueType.StringLocale => __EnumValue("StringLocale")
      case ValueType.Geo          => __EnumValue("Geo")
      case ValueType.Date         => __EnumValue("Date")
      case ValueType.Int          => __EnumValue("Int")
      case ValueType.String       => __EnumValue("String")
    }

    val values: scala.collection.immutable.Vector[ValueType] =
      scala.collection.immutable.Vector(
        Link,
        Double,
        StringLocale,
        Geo,
        Date,
        Int,
        String
      )
  }

  sealed trait WidgetTypeTableType
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object WidgetTypeTableType {
    case object vertical extends WidgetTypeTableType {
      val value: String = "vertical"
    }
    case object horizontal extends WidgetTypeTableType {
      val value: String = "horizontal"
    }

    implicit val decoder: ScalarDecoder[WidgetTypeTableType] = {
      case __StringValue("vertical")   => Right(WidgetTypeTableType.vertical)
      case __StringValue("horizontal") => Right(WidgetTypeTableType.horizontal)
      case other =>
        Left(
          DecodingError(s"Can't build WidgetTypeTableType from input $other")
        )
    }
    implicit val encoder: ArgEncoder[WidgetTypeTableType] = {
      case WidgetTypeTableType.vertical   => __EnumValue("vertical")
      case WidgetTypeTableType.horizontal => __EnumValue("horizontal")
    }

    val values: scala.collection.immutable.Vector[WidgetTypeTableType] =
      scala.collection.immutable.Vector(vertical, horizontal)
  }

  type FactInterface
  object FactInterface {

    final case class FactInterfaceView[MentionSelection, DocumentSelection](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        document: DocumentSelection
    )

    type ViewSelection[MentionSelection, DocumentSelection] = SelectionBuilder[
      FactInterface,
      FactInterfaceView[MentionSelection, DocumentSelection]
    ]

    def view[MentionSelection, DocumentSelection](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        documentSelection: SelectionBuilder[Document, DocumentSelection]
    ): ViewSelection[MentionSelection, DocumentSelection] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ document(documentSelection))
      .map {
        case (
              id,
              mention,
              systemRegistrationDate,
              systemUpdateDate,
              document
            ) =>
          FactInterfaceView(
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            document
          )
      }

    def id: SelectionBuilder[FactInterface, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[FactInterface, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate: SelectionBuilder[FactInterface, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[FactInterface, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[FactInterface, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
  }

  type RecordInterface
  object RecordInterface {

    final case class RecordInterfaceView[
        CreatorSelection,
        LastUpdaterSelection
    ](
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[CreatorSelection, LastUpdaterSelection] =
      SelectionBuilder[
        RecordInterface,
        RecordInterfaceView[CreatorSelection, LastUpdaterSelection]
      ]

    def view[CreatorSelection, LastUpdaterSelection](
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[CreatorSelection, LastUpdaterSelection] =
      (systemRegistrationDate ~ systemUpdateDate ~ creator(
        creatorSelection
      ) ~ lastUpdater(lastUpdaterSelection)).map {
        case (systemRegistrationDate, systemUpdateDate, creator, lastUpdater) =>
          RecordInterfaceView(
            systemRegistrationDate,
            systemUpdateDate,
            creator,
            lastUpdater
          )
      }

    def systemRegistrationDate: SelectionBuilder[RecordInterface, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[RecordInterface, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RecordInterface, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RecordInterface, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type AccessLevel
  object AccessLevel {

    final case class AccessLevelView(id: String, name: String, order: Long)

    type ViewSelection = SelectionBuilder[AccessLevel, AccessLevelView]

    def view: ViewSelection = (id ~ name ~ order).map {
      case (id, name, order) => AccessLevelView(id, name, order)
    }

    def id: SelectionBuilder[AccessLevel, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[AccessLevel, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def order: SelectionBuilder[AccessLevel, Long] =
      _root_.caliban.client.SelectionBuilder.Field("order", Scalar())
  }

  type AccessLevelPagination
  object AccessLevelPagination {

    final case class AccessLevelPaginationView[ListAccessLevelSelection](
        listAccessLevel: List[ListAccessLevelSelection],
        total: Int
    )

    type ViewSelection[ListAccessLevelSelection] =
      SelectionBuilder[AccessLevelPagination, AccessLevelPaginationView[
        ListAccessLevelSelection
      ]]

    def view[ListAccessLevelSelection](
        listAccessLevelSelection: SelectionBuilder[
          AccessLevel,
          ListAccessLevelSelection
        ]
    ): ViewSelection[ListAccessLevelSelection] =
      (listAccessLevel(listAccessLevelSelection) ~ total).map {
        case (listAccessLevel, total) =>
          AccessLevelPaginationView(listAccessLevel, total)
      }

    def listAccessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[AccessLevelPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listAccessLevel", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[AccessLevelPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type Account
  object Account {

    final case class AccountView[
        ParamsSelection,
        PlatformSelection,
        ImageSelection,
        MetricSelection,
        PeriodSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        url: String,
        country: scala.Option[String],
        markers: List[String],
        params: List[ParamsSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        platform: PlatformSelection,
        image: scala.Option[ImageSelection],
        metric: MetricSelection,
        period: PeriodSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        ParamsSelection,
        PlatformSelection,
        ImageSelection,
        MetricSelection,
        PeriodSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[Account, AccountView[
      ParamsSelection,
      PlatformSelection,
      ImageSelection,
      MetricSelection,
      PeriodSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ParamsSelection,
        PlatformSelection,
        ImageSelection,
        MetricSelection,
        PeriodSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paramsSelection: SelectionBuilder[Parameter, ParamsSelection],
        platformSelection: SelectionBuilder[Platform, PlatformSelection],
        imageSelection: SelectionBuilder[Image, ImageSelection],
        metricSelection: SelectionBuilder[AccountStatistics, MetricSelection],
        periodSelection: SelectionBuilder[DateTimeInterval, PeriodSelection],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ParamsSelection,
      PlatformSelection,
      ImageSelection,
      MetricSelection,
      PeriodSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ name ~ url ~ country ~ markers ~ params(
      paramsSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ platform(
      platformSelection
    ) ~ image(imageSelection) ~ metric(metricSelection) ~ period(
      periodSelection
    ) ~ creator(creatorSelection) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            name,
            url,
            country,
            markers,
            params,
            systemRegistrationDate,
            systemUpdateDate,
            platform,
            image,
            metric,
            period,
            creator,
            lastUpdater
          ) =>
        AccountView(
          id,
          name,
          url,
          country,
          markers,
          params,
          systemRegistrationDate,
          systemUpdateDate,
          platform,
          image,
          metric,
          period,
          creator,
          lastUpdater
        )
    }

    /** key
      */
    def id: SelectionBuilder[Account, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[Account, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def url: SelectionBuilder[Account, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())
    def country: SelectionBuilder[Account, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("country", OptionOf(Scalar()))
    def markers: SelectionBuilder[Account, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
    def params[A](
        innerSelection: SelectionBuilder[Parameter, A]
    ): SelectionBuilder[Account, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("params", ListOf(Obj(innerSelection)))
    def systemRegistrationDate: SelectionBuilder[Account, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Account, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def platform[A](
        innerSelection: SelectionBuilder[Platform, A]
    ): SelectionBuilder[Account, A] = _root_.caliban.client.SelectionBuilder
      .Field("platform", Obj(innerSelection))
    def image[A](
        innerSelection: SelectionBuilder[Image, A]
    ): SelectionBuilder[Account, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("image", OptionOf(Obj(innerSelection)))
    def metric[A](
        innerSelection: SelectionBuilder[AccountStatistics, A]
    ): SelectionBuilder[Account, A] = _root_.caliban.client.SelectionBuilder
      .Field("metric", Obj(innerSelection))
    def period[A](
        innerSelection: SelectionBuilder[DateTimeInterval, A]
    ): SelectionBuilder[Account, A] = _root_.caliban.client.SelectionBuilder
      .Field("period", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Account, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Account, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type AccountFacet
  object AccountFacet {

    final case class AccountFacetView[ValueSelection](
        value: ValueSelection,
        count: Long
    )

    type ViewSelection[ValueSelection] =
      SelectionBuilder[AccountFacet, AccountFacetView[ValueSelection]]

    def view[ValueSelection](
        valueSelection: SelectionBuilder[Account, ValueSelection]
    ): ViewSelection[ValueSelection] = (value(valueSelection) ~ count).map {
      case (value, count) => AccountFacetView(value, count)
    }

    def value[A](
        innerSelection: SelectionBuilder[Account, A]
    ): SelectionBuilder[AccountFacet, A] =
      _root_.caliban.client.SelectionBuilder.Field("value", Obj(innerSelection))
    def count: SelectionBuilder[AccountFacet, Long] =
      _root_.caliban.client.SelectionBuilder.Field("count", Scalar())
  }

  type AccountPagination
  object AccountPagination {

    final case class AccountPaginationView[ListAccountSelection](
        listAccount: List[ListAccountSelection],
        total: Int,
        totalPlatforms: Int
    )

    type ViewSelection[ListAccountSelection] =
      SelectionBuilder[AccountPagination, AccountPaginationView[
        ListAccountSelection
      ]]

    def view[ListAccountSelection](
        listAccountSelection: SelectionBuilder[Account, ListAccountSelection]
    ): ViewSelection[ListAccountSelection] =
      (listAccount(listAccountSelection) ~ total ~ totalPlatforms).map {
        case (listAccount, total, totalPlatforms) =>
          AccountPaginationView(listAccount, total, totalPlatforms)
      }

    def listAccount[A](
        innerSelection: SelectionBuilder[Account, A]
    ): SelectionBuilder[AccountPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listAccount", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[AccountPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def totalPlatforms: SelectionBuilder[AccountPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalPlatforms", Scalar())
  }

  type AccountStatistics
  object AccountStatistics {

    final case class AccountStatisticsView(
        countDoc: Int,
        countDocToday: Int,
        countDocWeek: Int,
        countDocMonth: Int,
        recallDocToday: DocumentRecall,
        recallDocWeek: DocumentRecall,
        recallDocMonth: DocumentRecall
    )

    type ViewSelection =
      SelectionBuilder[AccountStatistics, AccountStatisticsView]

    def view: ViewSelection =
      (countDoc ~ countDocToday ~ countDocWeek ~ countDocMonth ~ recallDocToday ~ recallDocWeek ~ recallDocMonth)
        .map {
          case (
                countDoc,
                countDocToday,
                countDocWeek,
                countDocMonth,
                recallDocToday,
                recallDocWeek,
                recallDocMonth
              ) =>
            AccountStatisticsView(
              countDoc,
              countDocToday,
              countDocWeek,
              countDocMonth,
              recallDocToday,
              recallDocWeek,
              recallDocMonth
            )
        }

    def countDoc: SelectionBuilder[AccountStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDoc", Scalar())
    def countDocToday: SelectionBuilder[AccountStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDocToday", Scalar())
    def countDocWeek: SelectionBuilder[AccountStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDocWeek", Scalar())
    def countDocMonth: SelectionBuilder[AccountStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDocMonth", Scalar())
    def recallDocToday: SelectionBuilder[AccountStatistics, DocumentRecall] =
      _root_.caliban.client.SelectionBuilder.Field("recallDocToday", Scalar())
    def recallDocWeek: SelectionBuilder[AccountStatistics, DocumentRecall] =
      _root_.caliban.client.SelectionBuilder.Field("recallDocWeek", Scalar())
    def recallDocMonth: SelectionBuilder[AccountStatistics, DocumentRecall] =
      _root_.caliban.client.SelectionBuilder.Field("recallDocMonth", Scalar())
  }

  type Annotation
  object Annotation {

    final case class AnnotationView(start: Int, end: Int, value: String)

    type ViewSelection = SelectionBuilder[Annotation, AnnotationView]

    def view: ViewSelection = (start ~ end ~ value).map {
      case (start, end, value) => AnnotationView(start, end, value)
    }

    def start: SelectionBuilder[Annotation, Int] =
      _root_.caliban.client.SelectionBuilder.Field("start", Scalar())
    def end: SelectionBuilder[Annotation, Int] =
      _root_.caliban.client.SelectionBuilder.Field("end", Scalar())
    def value: SelectionBuilder[Annotation, String] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
  }

  type Autocomplete
  object Autocomplete {

    final case class AutocompleteView(autocomplete: List[String])

    type ViewSelection = SelectionBuilder[Autocomplete, AutocompleteView]

    def view: ViewSelection =
      autocomplete.map(autocomplete => AutocompleteView(autocomplete))

    def autocomplete: SelectionBuilder[Autocomplete, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("autocomplete", ListOf(Scalar()))
  }

  type Chart
  object Chart {

    final case class ChartView[DescriptionSelection, DataSelection](
        id: String,
        description: DescriptionSelection,
        data: List[DataSelection]
    )

    type ViewSelection[DescriptionSelection, DataSelection] =
      SelectionBuilder[Chart, ChartView[DescriptionSelection, DataSelection]]

    def view[DescriptionSelection, DataSelection](
        descriptionSelection: SelectionBuilder[
          ChartDescription,
          DescriptionSelection
        ],
        dataSelection: SelectionBuilder[ChartData, DataSelection]
    ): ViewSelection[DescriptionSelection, DataSelection] =
      (id ~ description(descriptionSelection) ~ data(dataSelection)).map {
        case (id, description, data) => ChartView(id, description, data)
      }

    def id: SelectionBuilder[Chart, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def description[A](
        innerSelection: SelectionBuilder[ChartDescription, A]
    ): SelectionBuilder[Chart, A] = _root_.caliban.client.SelectionBuilder
      .Field("description", Obj(innerSelection))
    def data[A](
        innerSelection: SelectionBuilder[ChartData, A]
    ): SelectionBuilder[Chart, List[A]] = _root_.caliban.client.SelectionBuilder
      .Field("data", ListOf(Obj(innerSelection)))
  }

  type ChartData
  object ChartData {

    final case class ChartDataView(x: String, y: Long)

    type ViewSelection = SelectionBuilder[ChartData, ChartDataView]

    def view: ViewSelection = (x ~ y).map { case (x, y) => ChartDataView(x, y) }

    def x: SelectionBuilder[ChartData, String] =
      _root_.caliban.client.SelectionBuilder.Field("x", Scalar())
    def y: SelectionBuilder[ChartData, Long] =
      _root_.caliban.client.SelectionBuilder.Field("y", Scalar())
  }

  type ChartDescription
  object ChartDescription {

    final case class ChartDescriptionView[OutputLimiterSelection](
        chartType: ChartType,
        target: ChartTarget,
        query: String,
        aggregationField: String,
        aggregationFunction: scala.Option[AggregationFunction],
        outputLimiter: OutputLimiterSelection
    )

    type ViewSelection[OutputLimiterSelection] =
      SelectionBuilder[ChartDescription, ChartDescriptionView[
        OutputLimiterSelection
      ]]

    def view[OutputLimiterSelection](
        outputLimiterSelection: SelectionBuilder[
          OutputLimiter,
          OutputLimiterSelection
        ]
    ): ViewSelection[OutputLimiterSelection] =
      (chartType ~ target ~ query ~ aggregationField ~ aggregationFunction ~ outputLimiter(
        outputLimiterSelection
      )).map {
        case (
              chartType,
              target,
              query,
              aggregationField,
              aggregationFunction,
              outputLimiter
            ) =>
          ChartDescriptionView(
            chartType,
            target,
            query,
            aggregationField,
            aggregationFunction,
            outputLimiter
          )
      }

    def chartType: SelectionBuilder[ChartDescription, ChartType] =
      _root_.caliban.client.SelectionBuilder.Field("chartType", Scalar())
    def target: SelectionBuilder[ChartDescription, ChartTarget] =
      _root_.caliban.client.SelectionBuilder.Field("target", Scalar())
    def query: SelectionBuilder[ChartDescription, String] =
      _root_.caliban.client.SelectionBuilder.Field("query", Scalar())
    def aggregationField: SelectionBuilder[ChartDescription, String] =
      _root_.caliban.client.SelectionBuilder.Field("aggregationField", Scalar())
    def aggregationFunction: SelectionBuilder[ChartDescription, scala.Option[
      AggregationFunction
    ]] = _root_.caliban.client.SelectionBuilder
      .Field("aggregationFunction", OptionOf(Scalar()))
    def outputLimiter[A](
        innerSelection: SelectionBuilder[OutputLimiter, A]
    ): SelectionBuilder[ChartDescription, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("outputLimiter", Obj(innerSelection))
  }

  type CommonStringPagination
  object CommonStringPagination {

    final case class CommonStringPaginationView(
        total: Int,
        listString: List[String]
    )

    type ViewSelection =
      SelectionBuilder[CommonStringPagination, CommonStringPaginationView]

    def view: ViewSelection = (total ~ listString).map {
      case (total, listString) => CommonStringPaginationView(total, listString)
    }

    def total: SelectionBuilder[CommonStringPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listString: SelectionBuilder[CommonStringPagination, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listString", ListOf(Scalar()))
  }

  type CompositeConcept
  object CompositeConcept {

    final case class CompositeConceptView[
        RootConceptSelection,
        CompositeConceptTypeSelection,
        ListConceptsSelection,
        PaginateSingleWidgetSelection,
        PaginationConceptMentionSelection,
        ListConceptMentionSelection
    ](
        rootConcept: RootConceptSelection,
        compositeConceptType: CompositeConceptTypeSelection,
        id: String,
        listConcepts: List[ListConceptsSelection],
        paginateSingleWidget: PaginateSingleWidgetSelection,
        paginationConceptMention: scala.Option[
          PaginationConceptMentionSelection
        ],
        listConceptMention: scala.Option[List[ListConceptMentionSelection]]
    )

    type ViewSelection[
        RootConceptSelection,
        CompositeConceptTypeSelection,
        ListConceptsSelection,
        PaginateSingleWidgetSelection,
        PaginationConceptMentionSelection,
        ListConceptMentionSelection
    ] = SelectionBuilder[CompositeConcept, CompositeConceptView[
      RootConceptSelection,
      CompositeConceptTypeSelection,
      ListConceptsSelection,
      PaginateSingleWidgetSelection,
      PaginationConceptMentionSelection,
      ListConceptMentionSelection
    ]]

    def view[
        RootConceptSelection,
        CompositeConceptTypeSelection,
        ListConceptsSelection,
        PaginateSingleWidgetSelection,
        PaginationConceptMentionSelection,
        ListConceptMentionSelection
    ](
        paginateSingleWidgetWidgetTypeId: String,
        paginateSingleWidgetOffset: scala.Option[Int] = None,
        paginateSingleWidgetLimit: scala.Option[Int] = None,
        paginationConceptMentionOffset: scala.Option[Int] = None,
        paginationConceptMentionLimit: scala.Option[Int] = None,
        paginationConceptMentionFilterSettings: DocumentLinkFilterSetting
    )(
        rootConceptSelection: SelectionBuilder[Concept, RootConceptSelection],
        compositeConceptTypeSelection: SelectionBuilder[
          CompositeConceptType,
          CompositeConceptTypeSelection
        ],
        listConceptsSelection: SelectionBuilder[Concept, ListConceptsSelection],
        paginateSingleWidgetSelection: SelectionBuilder[
          CompositeConceptWidgetRowPagination,
          PaginateSingleWidgetSelection
        ],
        paginationConceptMentionSelection: SelectionBuilder[
          ConceptFactPagination,
          PaginationConceptMentionSelection
        ],
        listConceptMentionSelection: SelectionBuilder[
          ConceptFact,
          ListConceptMentionSelection
        ]
    ): ViewSelection[
      RootConceptSelection,
      CompositeConceptTypeSelection,
      ListConceptsSelection,
      PaginateSingleWidgetSelection,
      PaginationConceptMentionSelection,
      ListConceptMentionSelection
    ] = (rootConcept(rootConceptSelection) ~ compositeConceptType(
      compositeConceptTypeSelection
    ) ~ id ~ listConcepts(listConceptsSelection) ~ paginateSingleWidget(
      paginateSingleWidgetWidgetTypeId,
      paginateSingleWidgetOffset,
      paginateSingleWidgetLimit
    )(paginateSingleWidgetSelection) ~ paginationConceptMention(
      paginationConceptMentionOffset,
      paginationConceptMentionLimit,
      paginationConceptMentionFilterSettings
    )(paginationConceptMentionSelection) ~ listConceptMention(
      listConceptMentionSelection
    )).map {
      case (
            rootConcept,
            compositeConceptType,
            id,
            listConcepts,
            paginateSingleWidget,
            paginationConceptMention,
            listConceptMention
          ) =>
        CompositeConceptView(
          rootConcept,
          compositeConceptType,
          id,
          listConcepts,
          paginateSingleWidget,
          paginationConceptMention,
          listConceptMention
        )
    }

    def rootConcept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[CompositeConcept, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("rootConcept", Obj(innerSelection))
    def compositeConceptType[A](
        innerSelection: SelectionBuilder[CompositeConceptType, A]
    ): SelectionBuilder[CompositeConcept, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("compositeConceptType", Obj(innerSelection))
    def id: SelectionBuilder[CompositeConcept, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def listConcepts[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[CompositeConcept, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConcepts", ListOf(Obj(innerSelection)))
    def paginateSingleWidget[A](
        widgetTypeId: String,
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(
        innerSelection: SelectionBuilder[CompositeConceptWidgetRowPagination, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[CompositeConcept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginateSingleWidget",
        Obj(innerSelection),
        arguments = List(
          Argument("widgetTypeId", widgetTypeId, "ID!")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("limit", limit, "Int")(encoder2)
        )
      )
    def paginationConceptMention[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: DocumentLinkFilterSetting
    )(innerSelection: SelectionBuilder[ConceptFactPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[DocumentLinkFilterSetting]
    ): SelectionBuilder[CompositeConcept, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptMention",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "DocumentLinkFilterSetting!"
          )(encoder2)
        )
      )
    def listConceptMention[A](
        innerSelection: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[CompositeConcept, scala.Option[List[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptMention", OptionOf(ListOf(Obj(innerSelection))))
  }

  type CompositeConceptPagination
  object CompositeConceptPagination {

    final case class CompositeConceptPaginationView[
        ListCompositeConceptSelection
    ](listCompositeConcept: List[ListCompositeConceptSelection], total: Long)

    type ViewSelection[ListCompositeConceptSelection] = SelectionBuilder[
      CompositeConceptPagination,
      CompositeConceptPaginationView[ListCompositeConceptSelection]
    ]

    def view[ListCompositeConceptSelection](
        listCompositeConceptSelection: SelectionBuilder[
          CompositeConcept,
          ListCompositeConceptSelection
        ]
    ): ViewSelection[ListCompositeConceptSelection] =
      (listCompositeConcept(listCompositeConceptSelection) ~ total).map {
        case (listCompositeConcept, total) =>
          CompositeConceptPaginationView(listCompositeConcept, total)
      }

    def listCompositeConcept[A](
        innerSelection: SelectionBuilder[CompositeConcept, A]
    ): SelectionBuilder[CompositeConceptPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCompositeConcept", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[CompositeConceptPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type CompositeConceptStatistics
  object CompositeConceptStatistics {

    final case class CompositeConceptStatisticsView(countConceptTypes: Int)

    type ViewSelection = SelectionBuilder[
      CompositeConceptStatistics,
      CompositeConceptStatisticsView
    ]

    def view: ViewSelection = countConceptTypes.map(countConceptTypes =>
      CompositeConceptStatisticsView(countConceptTypes)
    )

    /** number of conceptTypes compositeConceptType consists of
      */
    def countConceptTypes: SelectionBuilder[CompositeConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countConceptTypes", Scalar())
  }

  type CompositeConceptType
  object CompositeConceptType {

    final case class CompositeConceptTypeView[
        RootConceptTypeSelection,
        MetricSelection,
        PaginationWidgetTypeSelection,
        ListWidgetTypeSelection,
        ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        rootConceptType: RootConceptTypeSelection,
        isDefault: Boolean,
        layout: String,
        hasSupportingDocuments: Boolean,
        hasHeaderInformation: Boolean,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        metric: MetricSelection,
        paginationWidgetType: PaginationWidgetTypeSelection,
        listWidgetType: List[ListWidgetTypeSelection],
        listConceptLinkTypesCompositeConceptTypeConsistsOf: List[
          ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection
        ],
        showInMenu: Boolean,
        internalUrl: scala.Option[String],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        RootConceptTypeSelection,
        MetricSelection,
        PaginationWidgetTypeSelection,
        ListWidgetTypeSelection,
        ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[CompositeConceptType, CompositeConceptTypeView[
      RootConceptTypeSelection,
      MetricSelection,
      PaginationWidgetTypeSelection,
      ListWidgetTypeSelection,
      ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        RootConceptTypeSelection,
        MetricSelection,
        PaginationWidgetTypeSelection,
        ListWidgetTypeSelection,
        ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationWidgetTypeLimit: scala.Option[Int] = None,
        paginationWidgetTypeOffset: scala.Option[Int] = None,
        paginationWidgetTypeSortDirection: scala.Option[SortDirection] = None,
        paginationWidgetTypeSorting: scala.Option[
          CompositeConceptTypeWidgetTypeSorting
        ] = None
    )(
        rootConceptTypeSelection: SelectionBuilder[
          ConceptType,
          RootConceptTypeSelection
        ],
        metricSelection: SelectionBuilder[
          CompositeConceptStatistics,
          MetricSelection
        ],
        paginationWidgetTypeSelection: SelectionBuilder[
          CompositeConceptTypeWidgetTypePagination,
          PaginationWidgetTypeSelection
        ],
        listWidgetTypeSelection: SelectionBuilder[
          CompositeConceptTypeWidgetType,
          ListWidgetTypeSelection
        ],
        listConceptLinkTypesCompositeConceptTypeConsistsOfSelection: SelectionBuilder[
          ConceptLinkType,
          ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      RootConceptTypeSelection,
      MetricSelection,
      PaginationWidgetTypeSelection,
      ListWidgetTypeSelection,
      ListConceptLinkTypesCompositeConceptTypeConsistsOfSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ name ~ rootConceptType(
      rootConceptTypeSelection
    ) ~ isDefault ~ layout ~ hasSupportingDocuments ~ hasHeaderInformation ~ systemRegistrationDate ~ systemUpdateDate ~ metric(
      metricSelection
    ) ~ paginationWidgetType(
      paginationWidgetTypeLimit,
      paginationWidgetTypeOffset,
      paginationWidgetTypeSortDirection,
      paginationWidgetTypeSorting
    )(paginationWidgetTypeSelection) ~ listWidgetType(
      listWidgetTypeSelection
    ) ~ listConceptLinkTypesCompositeConceptTypeConsistsOf(
      listConceptLinkTypesCompositeConceptTypeConsistsOfSelection
    ) ~ showInMenu ~ internalUrl ~ creator(creatorSelection) ~ lastUpdater(
      lastUpdaterSelection
    )).map {
      case (
            id,
            name,
            rootConceptType,
            isDefault,
            layout,
            hasSupportingDocuments,
            hasHeaderInformation,
            systemRegistrationDate,
            systemUpdateDate,
            metric,
            paginationWidgetType,
            listWidgetType,
            listConceptLinkTypesCompositeConceptTypeConsistsOf,
            showInMenu,
            internalUrl,
            creator,
            lastUpdater
          ) =>
        CompositeConceptTypeView(
          id,
          name,
          rootConceptType,
          isDefault,
          layout,
          hasSupportingDocuments,
          hasHeaderInformation,
          systemRegistrationDate,
          systemUpdateDate,
          metric,
          paginationWidgetType,
          listWidgetType,
          listConceptLinkTypesCompositeConceptTypeConsistsOf,
          showInMenu,
          internalUrl,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[CompositeConceptType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[CompositeConceptType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def rootConceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[CompositeConceptType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("rootConceptType", Obj(innerSelection))
    def isDefault: SelectionBuilder[CompositeConceptType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isDefault", Scalar())
    def layout: SelectionBuilder[CompositeConceptType, String] =
      _root_.caliban.client.SelectionBuilder.Field("layout", Scalar())
    def hasSupportingDocuments
        : SelectionBuilder[CompositeConceptType, Boolean] =
      _root_.caliban.client.SelectionBuilder
        .Field("hasSupportingDocuments", Scalar())
    def hasHeaderInformation: SelectionBuilder[CompositeConceptType, Boolean] =
      _root_.caliban.client.SelectionBuilder
        .Field("hasHeaderInformation", Scalar())
    def systemRegistrationDate
        : SelectionBuilder[CompositeConceptType, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[CompositeConceptType, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def metric[A](
        innerSelection: SelectionBuilder[CompositeConceptStatistics, A]
    ): SelectionBuilder[CompositeConceptType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("metric", Obj(innerSelection))
    def paginationWidgetType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        sortDirection: scala.Option[SortDirection] = None,
        sorting: scala.Option[CompositeConceptTypeWidgetTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[
          CompositeConceptTypeWidgetTypePagination,
          A
        ]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[SortDirection]],
        encoder3: ArgEncoder[
          scala.Option[CompositeConceptTypeWidgetTypeSorting]
        ]
    ): SelectionBuilder[CompositeConceptType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationWidgetType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder2),
          Argument("sorting", sorting, "CompositeConceptTypeWidgetTypeSorting")(
            encoder3
          )
        )
      )
    def listWidgetType[A](
        innerSelection: SelectionBuilder[CompositeConceptTypeWidgetType, A]
    ): SelectionBuilder[CompositeConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listWidgetType", ListOf(Obj(innerSelection)))
    def listConceptLinkTypesCompositeConceptTypeConsistsOf[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[CompositeConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listConceptLinkTypesCompositeConceptTypeConsistsOf",
        ListOf(Obj(innerSelection))
      )
    def showInMenu: SelectionBuilder[CompositeConceptType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("showInMenu", Scalar())
    def internalUrl
        : SelectionBuilder[CompositeConceptType, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("internalUrl", OptionOf(Scalar()))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositeConceptType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositeConceptType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type CompositeConceptTypePagination
  object CompositeConceptTypePagination {

    final case class CompositeConceptTypePaginationView[
        ListCompositeConceptTypeSelection
    ](
        listCompositeConceptType: List[ListCompositeConceptTypeSelection],
        total: Int
    )

    type ViewSelection[ListCompositeConceptTypeSelection] = SelectionBuilder[
      CompositeConceptTypePagination,
      CompositeConceptTypePaginationView[ListCompositeConceptTypeSelection]
    ]

    def view[ListCompositeConceptTypeSelection](
        listCompositeConceptTypeSelection: SelectionBuilder[
          CompositeConceptType,
          ListCompositeConceptTypeSelection
        ]
    ): ViewSelection[ListCompositeConceptTypeSelection] =
      (listCompositeConceptType(listCompositeConceptTypeSelection) ~ total)
        .map { case (listCompositeConceptType, total) =>
          CompositeConceptTypePaginationView(listCompositeConceptType, total)
        }

    def listCompositeConceptType[A](
        innerSelection: SelectionBuilder[CompositeConceptType, A]
    ): SelectionBuilder[CompositeConceptTypePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCompositeConceptType", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[CompositeConceptTypePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type CompositeConceptTypeWidgetType
  object CompositeConceptTypeWidgetType {

    final case class CompositeConceptTypeWidgetTypeView[
        CompositeConceptTypeSelection,
        HierarchySelection,
        ColumnsInfoSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        tableType: WidgetTypeTableType,
        compositeConceptType: CompositeConceptTypeSelection,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        hierarchy: List[List[HierarchySelection]],
        columnsInfo: List[ColumnsInfoSelection],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        CompositeConceptTypeSelection,
        HierarchySelection,
        ColumnsInfoSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[
      CompositeConceptTypeWidgetType,
      CompositeConceptTypeWidgetTypeView[
        CompositeConceptTypeSelection,
        HierarchySelection,
        ColumnsInfoSelection,
        CreatorSelection,
        LastUpdaterSelection
      ]
    ]

    def view[
        CompositeConceptTypeSelection,
        HierarchySelection,
        ColumnsInfoSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        compositeConceptTypeSelection: SelectionBuilder[
          CompositeConceptType,
          CompositeConceptTypeSelection
        ],
        hierarchySelection: SelectionBuilder[
          ConceptLinkTypePath,
          HierarchySelection
        ],
        columnsInfoSelection: SelectionBuilder[
          CompositeConceptTypeWidgetTypeColumn,
          ColumnsInfoSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      CompositeConceptTypeSelection,
      HierarchySelection,
      ColumnsInfoSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ name ~ tableType ~ compositeConceptType(
      compositeConceptTypeSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ hierarchy(
      hierarchySelection
    ) ~ columnsInfo(columnsInfoSelection) ~ creator(
      creatorSelection
    ) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            name,
            tableType,
            compositeConceptType,
            systemRegistrationDate,
            systemUpdateDate,
            hierarchy,
            columnsInfo,
            creator,
            lastUpdater
          ) =>
        CompositeConceptTypeWidgetTypeView(
          id,
          name,
          tableType,
          compositeConceptType,
          systemRegistrationDate,
          systemUpdateDate,
          hierarchy,
          columnsInfo,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[CompositeConceptTypeWidgetType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[CompositeConceptTypeWidgetType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def tableType: SelectionBuilder[
      CompositeConceptTypeWidgetType,
      WidgetTypeTableType
    ] = _root_.caliban.client.SelectionBuilder.Field("tableType", Scalar())
    def compositeConceptType[A](
        innerSelection: SelectionBuilder[CompositeConceptType, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("compositeConceptType", Obj(innerSelection))
    def systemRegistrationDate
        : SelectionBuilder[CompositeConceptTypeWidgetType, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[
      CompositeConceptTypeWidgetType,
      scala.Option[UnixTime]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("systemUpdateDate", OptionOf(Scalar()))
    def hierarchy[A](
        innerSelection: SelectionBuilder[ConceptLinkTypePath, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetType, List[List[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("hierarchy", ListOf(ListOf(Obj(innerSelection))))
    def columnsInfo[A](
        innerSelection: SelectionBuilder[
          CompositeConceptTypeWidgetTypeColumn,
          A
        ]
    ): SelectionBuilder[CompositeConceptTypeWidgetType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("columnsInfo", ListOf(Obj(innerSelection)))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type CompositeConceptTypeWidgetTypeColumn
  object CompositeConceptTypeWidgetTypeColumn {

    final case class CompositeConceptTypeWidgetTypeColumnView[
        ConceptLinkTypesPathSelection,
        PropertyTypeSelection,
        LinkPropertyTypeSelection
    ](
        id: String,
        name: String,
        isMainProperties: Boolean,
        listValues: Boolean,
        sortByColumn: Boolean,
        sortDirection: scala.Option[SortDirection],
        conceptLinkTypesPath: List[ConceptLinkTypesPathSelection],
        propertyType: scala.Option[PropertyTypeSelection],
        metadata: scala.Option[ConceptTypeMetadata],
        linkPropertyType: scala.Option[LinkPropertyTypeSelection],
        linkMetadata: scala.Option[ConceptTypeLinkMetadata],
        sortable: Boolean
    )

    type ViewSelection[
        ConceptLinkTypesPathSelection,
        PropertyTypeSelection,
        LinkPropertyTypeSelection
    ] = SelectionBuilder[
      CompositeConceptTypeWidgetTypeColumn,
      CompositeConceptTypeWidgetTypeColumnView[
        ConceptLinkTypesPathSelection,
        PropertyTypeSelection,
        LinkPropertyTypeSelection
      ]
    ]

    def view[
        ConceptLinkTypesPathSelection,
        PropertyTypeSelection,
        LinkPropertyTypeSelection
    ](
        conceptLinkTypesPathSelection: SelectionBuilder[
          ConceptLinkTypePath,
          ConceptLinkTypesPathSelection
        ],
        propertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          PropertyTypeSelection
        ],
        linkPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          LinkPropertyTypeSelection
        ]
    ): ViewSelection[
      ConceptLinkTypesPathSelection,
      PropertyTypeSelection,
      LinkPropertyTypeSelection
    ] =
      (id ~ name ~ isMainProperties ~ listValues ~ sortByColumn ~ sortDirection ~ conceptLinkTypesPath(
        conceptLinkTypesPathSelection
      ) ~ propertyType(propertyTypeSelection) ~ metadata ~ linkPropertyType(
        linkPropertyTypeSelection
      ) ~ linkMetadata ~ sortable).map {
        case (
              id,
              name,
              isMainProperties,
              listValues,
              sortByColumn,
              sortDirection,
              conceptLinkTypesPath,
              propertyType,
              metadata,
              linkPropertyType,
              linkMetadata,
              sortable
            ) =>
          CompositeConceptTypeWidgetTypeColumnView(
            id,
            name,
            isMainProperties,
            listValues,
            sortByColumn,
            sortDirection,
            conceptLinkTypesPath,
            propertyType,
            metadata,
            linkPropertyType,
            linkMetadata,
            sortable
          )
      }

    def id: SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def isMainProperties
        : SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isMainProperties", Scalar())
    def listValues
        : SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("listValues", Scalar())

    /** used only in concept type view
      */
    def sortByColumn
        : SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("sortByColumn", Scalar())

    /** used only in concept type view
      */
    def sortDirection: SelectionBuilder[
      CompositeConceptTypeWidgetTypeColumn,
      scala.Option[SortDirection]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("sortDirection", OptionOf(Scalar()))

    /** link types with directions; path from root conceptType to conceptType with propertyType
      */
    def conceptLinkTypesPath[A](
        innerSelection: SelectionBuilder[ConceptLinkTypePath, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptLinkTypesPath", ListOf(Obj(innerSelection)))
    def propertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("propertyType", OptionOf(Obj(innerSelection)))
    def metadata: SelectionBuilder[
      CompositeConceptTypeWidgetTypeColumn,
      scala.Option[ConceptTypeMetadata]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("metadata", OptionOf(Scalar()))
    def linkPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("linkPropertyType", OptionOf(Obj(innerSelection)))
    def linkMetadata: SelectionBuilder[
      CompositeConceptTypeWidgetTypeColumn,
      scala.Option[ConceptTypeLinkMetadata]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("linkMetadata", OptionOf(Scalar()))

    /** used only in concept type view
      */
    def sortable
        : SelectionBuilder[CompositeConceptTypeWidgetTypeColumn, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("sortable", Scalar())
  }

  type CompositeConceptTypeWidgetTypePagination
  object CompositeConceptTypeWidgetTypePagination {

    final case class CompositeConceptTypeWidgetTypePaginationView[
        ListCompositeConceptTypeWidgetSelection
    ](
        listCompositeConceptTypeWidget: List[
          ListCompositeConceptTypeWidgetSelection
        ],
        total: Int
    )

    type ViewSelection[ListCompositeConceptTypeWidgetSelection] =
      SelectionBuilder[
        CompositeConceptTypeWidgetTypePagination,
        CompositeConceptTypeWidgetTypePaginationView[
          ListCompositeConceptTypeWidgetSelection
        ]
      ]

    def view[ListCompositeConceptTypeWidgetSelection](
        listCompositeConceptTypeWidgetSelection: SelectionBuilder[
          CompositeConceptTypeWidgetType,
          ListCompositeConceptTypeWidgetSelection
        ]
    ): ViewSelection[ListCompositeConceptTypeWidgetSelection] =
      (listCompositeConceptTypeWidget(
        listCompositeConceptTypeWidgetSelection
      ) ~ total).map { case (listCompositeConceptTypeWidget, total) =>
        CompositeConceptTypeWidgetTypePaginationView(
          listCompositeConceptTypeWidget,
          total
        )
      }

    def listCompositeConceptTypeWidget[A](
        innerSelection: SelectionBuilder[CompositeConceptTypeWidgetType, A]
    ): SelectionBuilder[CompositeConceptTypeWidgetTypePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCompositeConceptTypeWidget", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[CompositeConceptTypeWidgetTypePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type CompositeConceptWidgetRowPagination
  object CompositeConceptWidgetRowPagination {

    final case class CompositeConceptWidgetRowPaginationView[
        WidgetTypeSelection,
        RowsSelection
    ](
        widgetType: WidgetTypeSelection,
        total: Int,
        rows: List[List[List[RowsSelection]]]
    )

    type ViewSelection[WidgetTypeSelection, RowsSelection] = SelectionBuilder[
      CompositeConceptWidgetRowPagination,
      CompositeConceptWidgetRowPaginationView[
        WidgetTypeSelection,
        RowsSelection
      ]
    ]

    def view[WidgetTypeSelection, RowsSelection](
        widgetTypeSelection: SelectionBuilder[
          CompositeConceptTypeWidgetType,
          WidgetTypeSelection
        ],
        rowsSelectionOnCompositeValue: SelectionBuilder[
          CompositeValue,
          RowsSelection
        ],
        rowsSelectionOnConcept: SelectionBuilder[Concept, RowsSelection],
        rowsSelectionOnConceptLinkType: SelectionBuilder[
          ConceptLinkType,
          RowsSelection
        ],
        rowsSelectionOnConceptType: SelectionBuilder[
          ConceptType,
          RowsSelection
        ],
        rowsSelectionOnDateTimeValue: SelectionBuilder[
          DateTimeValue,
          RowsSelection
        ],
        rowsSelectionOnDoubleValue: SelectionBuilder[
          DoubleValue,
          RowsSelection
        ],
        rowsSelectionOnGeoPointValue: SelectionBuilder[
          GeoPointValue,
          RowsSelection
        ],
        rowsSelectionOnImage: SelectionBuilder[Image, RowsSelection],
        rowsSelectionOnIntValue: SelectionBuilder[IntValue, RowsSelection],
        rowsSelectionOnLinkValue: SelectionBuilder[LinkValue, RowsSelection],
        rowsSelectionOnStringLocaleValue: SelectionBuilder[
          StringLocaleValue,
          RowsSelection
        ],
        rowsSelectionOnStringValue: SelectionBuilder[
          StringValue,
          RowsSelection
        ],
        rowsSelectionOnUser: SelectionBuilder[User, RowsSelection]
    ): ViewSelection[WidgetTypeSelection, RowsSelection] =
      (widgetType(widgetTypeSelection) ~ total ~ rows(
        rowsSelectionOnCompositeValue,
        rowsSelectionOnConcept,
        rowsSelectionOnConceptLinkType,
        rowsSelectionOnConceptType,
        rowsSelectionOnDateTimeValue,
        rowsSelectionOnDoubleValue,
        rowsSelectionOnGeoPointValue,
        rowsSelectionOnImage,
        rowsSelectionOnIntValue,
        rowsSelectionOnLinkValue,
        rowsSelectionOnStringLocaleValue,
        rowsSelectionOnStringValue,
        rowsSelectionOnUser
      )).map { case (widgetType, total, rows) =>
        CompositeConceptWidgetRowPaginationView(widgetType, total, rows)
      }

    def widgetType[A](
        innerSelection: SelectionBuilder[CompositeConceptTypeWidgetType, A]
    ): SelectionBuilder[CompositeConceptWidgetRowPagination, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("widgetType", Obj(innerSelection))
    def total: SelectionBuilder[CompositeConceptWidgetRowPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def rows[A](
        onCompositeValue: SelectionBuilder[CompositeValue, A],
        onConcept: SelectionBuilder[Concept, A],
        onConceptLinkType: SelectionBuilder[ConceptLinkType, A],
        onConceptType: SelectionBuilder[ConceptType, A],
        onDateTimeValue: SelectionBuilder[DateTimeValue, A],
        onDoubleValue: SelectionBuilder[DoubleValue, A],
        onGeoPointValue: SelectionBuilder[GeoPointValue, A],
        onImage: SelectionBuilder[Image, A],
        onIntValue: SelectionBuilder[IntValue, A],
        onLinkValue: SelectionBuilder[LinkValue, A],
        onStringLocaleValue: SelectionBuilder[StringLocaleValue, A],
        onStringValue: SelectionBuilder[StringValue, A],
        onUser: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositeConceptWidgetRowPagination, List[
      List[List[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "rows",
      ListOf(
        ListOf(
          ListOf(
            ChoiceOf(
              Map(
                "CompositeValue" -> Obj(onCompositeValue),
                "Concept" -> Obj(onConcept),
                "ConceptLinkType" -> Obj(onConceptLinkType),
                "ConceptType" -> Obj(onConceptType),
                "DateTimeValue" -> Obj(onDateTimeValue),
                "DoubleValue" -> Obj(onDoubleValue),
                "GeoPointValue" -> Obj(onGeoPointValue),
                "Image" -> Obj(onImage),
                "IntValue" -> Obj(onIntValue),
                "LinkValue" -> Obj(onLinkValue),
                "StringLocaleValue" -> Obj(onStringLocaleValue),
                "StringValue" -> Obj(onStringValue),
                "User" -> Obj(onUser)
              )
            )
          )
        )
      )
    )
    def rowsOption[A](
        onCompositeValue: scala.Option[SelectionBuilder[CompositeValue, A]] =
          None,
        onConcept: scala.Option[SelectionBuilder[Concept, A]] = None,
        onConceptLinkType: scala.Option[SelectionBuilder[ConceptLinkType, A]] =
          None,
        onConceptType: scala.Option[SelectionBuilder[ConceptType, A]] = None,
        onDateTimeValue: scala.Option[SelectionBuilder[DateTimeValue, A]] =
          None,
        onDoubleValue: scala.Option[SelectionBuilder[DoubleValue, A]] = None,
        onGeoPointValue: scala.Option[SelectionBuilder[GeoPointValue, A]] =
          None,
        onImage: scala.Option[SelectionBuilder[Image, A]] = None,
        onIntValue: scala.Option[SelectionBuilder[IntValue, A]] = None,
        onLinkValue: scala.Option[SelectionBuilder[LinkValue, A]] = None,
        onStringLocaleValue: scala.Option[
          SelectionBuilder[StringLocaleValue, A]
        ] = None,
        onStringValue: scala.Option[SelectionBuilder[StringValue, A]] = None,
        onUser: scala.Option[SelectionBuilder[User, A]] = None
    ): SelectionBuilder[CompositeConceptWidgetRowPagination, List[
      List[List[scala.Option[A]]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "rows",
      ListOf(
        ListOf(
          ListOf(
            ChoiceOf(
              Map(
                "CompositeValue" -> onCompositeValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "Concept" -> onConcept.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "ConceptLinkType" -> onConceptLinkType
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "ConceptType" -> onConceptType
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "DateTimeValue" -> onDateTimeValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "DoubleValue" -> onDoubleValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "GeoPointValue" -> onGeoPointValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "Image" -> onImage.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "IntValue" -> onIntValue.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "LinkValue" -> onLinkValue.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "StringLocaleValue" -> onStringLocaleValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "StringValue" -> onStringValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "User" -> onUser.fold[FieldBuilder[scala.Option[A]]](NullField)(
                  a => OptionOf(Obj(a))
                )
              )
            )
          )
        )
      )
    )
  }

  type CompositePropertyValueTemplate
  object CompositePropertyValueTemplate {

    final case class CompositePropertyValueTemplateView[
        CreatorSelection,
        LastUpdaterSelection,
        ComponentValueTypesSelection
    ](
        id: String,
        name: String,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection],
        componentValueTypes: List[ComponentValueTypesSelection]
    )

    type ViewSelection[
        CreatorSelection,
        LastUpdaterSelection,
        ComponentValueTypesSelection
    ] = SelectionBuilder[
      CompositePropertyValueTemplate,
      CompositePropertyValueTemplateView[
        CreatorSelection,
        LastUpdaterSelection,
        ComponentValueTypesSelection
      ]
    ]

    def view[
        CreatorSelection,
        LastUpdaterSelection,
        ComponentValueTypesSelection
    ](
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection],
        componentValueTypesSelection: SelectionBuilder[
          CompositePropertyValueType,
          ComponentValueTypesSelection
        ]
    ): ViewSelection[
      CreatorSelection,
      LastUpdaterSelection,
      ComponentValueTypesSelection
    ] = (id ~ name ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
      creatorSelection
    ) ~ lastUpdater(lastUpdaterSelection) ~ componentValueTypes(
      componentValueTypesSelection
    )).map {
      case (
            id,
            name,
            systemRegistrationDate,
            systemUpdateDate,
            creator,
            lastUpdater,
            componentValueTypes
          ) =>
        CompositePropertyValueTemplateView(
          id,
          name,
          systemRegistrationDate,
          systemUpdateDate,
          creator,
          lastUpdater,
          componentValueTypes
        )
    }

    def id: SelectionBuilder[CompositePropertyValueTemplate, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[CompositePropertyValueTemplate, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def systemRegistrationDate
        : SelectionBuilder[CompositePropertyValueTemplate, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[
      CompositePropertyValueTemplate,
      scala.Option[UnixTime]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("systemUpdateDate", OptionOf(Scalar()))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositePropertyValueTemplate, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CompositePropertyValueTemplate, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def componentValueTypes[A](
        innerSelection: SelectionBuilder[CompositePropertyValueType, A]
    ): SelectionBuilder[CompositePropertyValueTemplate, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("componentValueTypes", ListOf(Obj(innerSelection)))
  }

  type CompositePropertyValueTemplatePagination
  object CompositePropertyValueTemplatePagination {

    final case class CompositePropertyValueTemplatePaginationView[
        ListCompositePropertyValueTemplateSelection
    ](
        listCompositePropertyValueTemplate: List[
          ListCompositePropertyValueTemplateSelection
        ],
        total: Int
    )

    type ViewSelection[ListCompositePropertyValueTemplateSelection] =
      SelectionBuilder[
        CompositePropertyValueTemplatePagination,
        CompositePropertyValueTemplatePaginationView[
          ListCompositePropertyValueTemplateSelection
        ]
      ]

    def view[ListCompositePropertyValueTemplateSelection](
        listCompositePropertyValueTemplateSelection: SelectionBuilder[
          CompositePropertyValueTemplate,
          ListCompositePropertyValueTemplateSelection
        ]
    ): ViewSelection[ListCompositePropertyValueTemplateSelection] =
      (listCompositePropertyValueTemplate(
        listCompositePropertyValueTemplateSelection
      ) ~ total).map { case (listCompositePropertyValueTemplate, total) =>
        CompositePropertyValueTemplatePaginationView(
          listCompositePropertyValueTemplate,
          total
        )
      }

    def listCompositePropertyValueTemplate[A](
        innerSelection: SelectionBuilder[CompositePropertyValueTemplate, A]
    ): SelectionBuilder[CompositePropertyValueTemplatePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listCompositePropertyValueTemplate",
        ListOf(Obj(innerSelection))
      )
    def total: SelectionBuilder[CompositePropertyValueTemplatePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type CompositePropertyValueType
  object CompositePropertyValueType {

    final case class CompositePropertyValueTypeView[ValueTypeSelection](
        id: String,
        name: String,
        valueType: ValueTypeSelection,
        isRequired: Boolean,
        view: ComponentView
    )

    type ViewSelection[ValueTypeSelection] = SelectionBuilder[
      CompositePropertyValueType,
      CompositePropertyValueTypeView[ValueTypeSelection]
    ]

    def view[ValueTypeSelection](
        valueTypeSelection: SelectionBuilder[
          ConceptPropertyValueType,
          ValueTypeSelection
        ]
    ): ViewSelection[ValueTypeSelection] =
      (id ~ name ~ valueType(valueTypeSelection) ~ isRequired ~ view).map {
        case (id, name, valueType, isRequired, view) =>
          CompositePropertyValueTypeView(id, name, valueType, isRequired, view)
      }

    def id: SelectionBuilder[CompositePropertyValueType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[CompositePropertyValueType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def valueType[A](
        innerSelection: SelectionBuilder[ConceptPropertyValueType, A]
    ): SelectionBuilder[CompositePropertyValueType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("valueType", Obj(innerSelection))
    def isRequired: SelectionBuilder[CompositePropertyValueType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isRequired", Scalar())
    def view: SelectionBuilder[CompositePropertyValueType, ComponentView] =
      _root_.caliban.client.SelectionBuilder.Field("view", Scalar())
  }

  type CompositeValue
  object CompositeValue {

    final case class CompositeValueView[ListValueSelection](
        listValue: List[ListValueSelection]
    )

    type ViewSelection[ListValueSelection] =
      SelectionBuilder[CompositeValue, CompositeValueView[ListValueSelection]]

    def view[ListValueSelection](
        listValueSelection: SelectionBuilder[NamedValue, ListValueSelection]
    ): ViewSelection[ListValueSelection] =
      listValue(listValueSelection).map(listValue =>
        CompositeValueView(listValue)
      )

    def listValue[A](
        innerSelection: SelectionBuilder[NamedValue, A]
    ): SelectionBuilder[CompositeValue, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listValue", ListOf(Obj(innerSelection)))
  }

  type Concept
  object Concept {

    final case class ConceptView[
        StartDateSelection,
        EndDateSelection,
        ConceptTypeSelection,
        PaginationConceptPropertySelection,
        PaginationConceptLinkSelection,
        PaginationConceptFactSelection,
        PaginationConceptPropertyDocumentsSelection,
        PaginationConceptLinkDocumentsSelection,
        ListConceptFactSelection,
        ImageSelection,
        MetricSelection,
        ListAliasSelection,
        PaginationAliasSelection,
        PaginationMergedConceptSelection,
        ListHeaderConceptPropertySelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        ListSubscriptionSelection,
        PaginationResearchMapSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        isActual: Boolean,
        name: String,
        notes: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        markers: List[String],
        startDate: scala.Option[StartDateSelection],
        endDate: scala.Option[EndDateSelection],
        conceptType: ConceptTypeSelection,
        paginationConceptProperty: PaginationConceptPropertySelection,
        paginationConceptLink: PaginationConceptLinkSelection,
        paginationConceptFact: PaginationConceptFactSelection,
        paginationConceptPropertyDocuments: PaginationConceptPropertyDocumentsSelection,
        paginationConceptLinkDocuments: PaginationConceptLinkDocumentsSelection,
        listConceptFact: List[ListConceptFactSelection],
        image: scala.Option[ImageSelection],
        metric: MetricSelection,
        listAlias: List[ListAliasSelection],
        paginationAlias: PaginationAliasSelection,
        paginationMergedConcept: PaginationMergedConceptSelection,
        listHeaderConceptProperty: List[ListHeaderConceptPropertySelection],
        paginationRedmineIssues: PaginationRedmineIssuesSelection,
        paginationIssue: PaginationIssueSelection,
        accessLevel: AccessLevelSelection,
        listSubscription: ListSubscriptionSelection,
        paginationResearchMap: PaginationResearchMapSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    final case class ConceptViewArgs(
        paginationConceptPropertyOffset: scala.Option[Int] = None,
        paginationConceptPropertyLimit: scala.Option[Int] = None,
        paginationConceptPropertyFilterSettings: ConceptPropertyFilterSettings,
        paginationConceptLinkOffset: scala.Option[Int] = None,
        paginationConceptLinkLimit: scala.Option[Int] = None,
        paginationConceptLinkFilterSettings: ConceptLinkFilterSettings,
        paginationConceptFactOffset: scala.Option[Int] = None,
        paginationConceptFactLimit: scala.Option[Int] = None,
        paginationConceptFactFilterSettings: DocumentLinkFilterSetting,
        paginationConceptPropertyDocumentsOffset: scala.Option[Int] = None,
        paginationConceptPropertyDocumentsLimit: scala.Option[Int] = None,
        paginationConceptPropertyDocumentsFilterSettings: ConceptPropertyFilterSettings,
        paginationConceptLinkDocumentsOffset: scala.Option[Int] = None,
        paginationConceptLinkDocumentsLimit: scala.Option[Int] = None,
        paginationConceptLinkDocumentsFilterSettings: ConceptLinkFilterSettings,
        paginationAliasLimit: scala.Option[Int] = None,
        paginationAliasOffset: scala.Option[Int] = None,
        paginationMergedConceptLimit: scala.Option[Int] = None,
        paginationMergedConceptOffset: scala.Option[Int] = None,
        paginationRedmineIssuesLimit: scala.Option[Int] = None,
        paginationRedmineIssuesOffset: scala.Option[Int] = None,
        paginationRedmineIssuesSortDirection: scala.Option[SortDirection] =
          None,
        paginationIssueOffset: scala.Option[Int] = None,
        paginationIssueLimit: scala.Option[Int] = None,
        paginationIssueFilterSettings: IssueFilterSettings,
        paginationIssueSortDirection: SortDirection,
        paginationIssueSorting: IssueSorting,
        paginationResearchMapOffset: scala.Option[Int] = None,
        paginationResearchMapLimit: scala.Option[Int] = None,
        paginationResearchMapFilterSettings: ResearchMapFilterSettings,
        paginationResearchMapSortDirection: SortDirection,
        paginationResearchMapSorting: ResearchMapSorting
    )

    type ViewSelection[
        StartDateSelection,
        EndDateSelection,
        ConceptTypeSelection,
        PaginationConceptPropertySelection,
        PaginationConceptLinkSelection,
        PaginationConceptFactSelection,
        PaginationConceptPropertyDocumentsSelection,
        PaginationConceptLinkDocumentsSelection,
        ListConceptFactSelection,
        ImageSelection,
        MetricSelection,
        ListAliasSelection,
        PaginationAliasSelection,
        PaginationMergedConceptSelection,
        ListHeaderConceptPropertySelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        ListSubscriptionSelection,
        PaginationResearchMapSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[Concept, ConceptView[
      StartDateSelection,
      EndDateSelection,
      ConceptTypeSelection,
      PaginationConceptPropertySelection,
      PaginationConceptLinkSelection,
      PaginationConceptFactSelection,
      PaginationConceptPropertyDocumentsSelection,
      PaginationConceptLinkDocumentsSelection,
      ListConceptFactSelection,
      ImageSelection,
      MetricSelection,
      ListAliasSelection,
      PaginationAliasSelection,
      PaginationMergedConceptSelection,
      ListHeaderConceptPropertySelection,
      PaginationRedmineIssuesSelection,
      PaginationIssueSelection,
      AccessLevelSelection,
      ListSubscriptionSelection,
      PaginationResearchMapSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        StartDateSelection,
        EndDateSelection,
        ConceptTypeSelection,
        PaginationConceptPropertySelection,
        PaginationConceptLinkSelection,
        PaginationConceptFactSelection,
        PaginationConceptPropertyDocumentsSelection,
        PaginationConceptLinkDocumentsSelection,
        ListConceptFactSelection,
        ImageSelection,
        MetricSelection,
        ListAliasSelection,
        PaginationAliasSelection,
        PaginationMergedConceptSelection,
        ListHeaderConceptPropertySelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        ListSubscriptionSelection,
        PaginationResearchMapSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](args: ConceptViewArgs)(
        startDateSelection: SelectionBuilder[DateTimeValue, StartDateSelection],
        endDateSelection: SelectionBuilder[DateTimeValue, EndDateSelection],
        conceptTypeSelection: SelectionBuilder[
          ConceptType,
          ConceptTypeSelection
        ],
        paginationConceptPropertySelection: SelectionBuilder[
          ConceptPropertyPagination,
          PaginationConceptPropertySelection
        ],
        paginationConceptLinkSelection: SelectionBuilder[
          ConceptLinkPagination,
          PaginationConceptLinkSelection
        ],
        paginationConceptFactSelection: SelectionBuilder[
          ConceptFactPagination,
          PaginationConceptFactSelection
        ],
        paginationConceptPropertyDocumentsSelection: SelectionBuilder[
          DocumentPagination,
          PaginationConceptPropertyDocumentsSelection
        ],
        paginationConceptLinkDocumentsSelection: SelectionBuilder[
          DocumentPagination,
          PaginationConceptLinkDocumentsSelection
        ],
        listConceptFactSelection: SelectionBuilder[
          ConceptFact,
          ListConceptFactSelection
        ],
        imageSelection: SelectionBuilder[Image, ImageSelection],
        metricSelection: SelectionBuilder[ConceptStatistics, MetricSelection],
        listAliasSelection: SelectionBuilder[
          ConceptProperty,
          ListAliasSelection
        ],
        paginationAliasSelection: SelectionBuilder[
          ConceptPropertyPagination,
          PaginationAliasSelection
        ],
        paginationMergedConceptSelection: SelectionBuilder[
          MergedConceptPagination,
          PaginationMergedConceptSelection
        ],
        listHeaderConceptPropertySelection: SelectionBuilder[
          ConceptProperty,
          ListHeaderConceptPropertySelection
        ],
        paginationRedmineIssuesSelection: SelectionBuilder[
          RedmineIssuePagination,
          PaginationRedmineIssuesSelection
        ],
        paginationIssueSelection: SelectionBuilder[
          IssuePagination,
          PaginationIssueSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        listSubscriptionSelection: SelectionBuilder[
          ConceptSubscriptions,
          ListSubscriptionSelection
        ],
        paginationResearchMapSelection: SelectionBuilder[
          ResearchMapPagination,
          PaginationResearchMapSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      StartDateSelection,
      EndDateSelection,
      ConceptTypeSelection,
      PaginationConceptPropertySelection,
      PaginationConceptLinkSelection,
      PaginationConceptFactSelection,
      PaginationConceptPropertyDocumentsSelection,
      PaginationConceptLinkDocumentsSelection,
      ListConceptFactSelection,
      ImageSelection,
      MetricSelection,
      ListAliasSelection,
      PaginationAliasSelection,
      PaginationMergedConceptSelection,
      ListHeaderConceptPropertySelection,
      PaginationRedmineIssuesSelection,
      PaginationIssueSelection,
      AccessLevelSelection,
      ListSubscriptionSelection,
      PaginationResearchMapSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (((id ~ isActual ~ name ~ notes ~ systemRegistrationDate ~ systemUpdateDate ~ markers ~ startDate(
        startDateSelection
      ) ~ endDate(endDateSelection) ~ conceptType(
        conceptTypeSelection
      ) ~ paginationConceptProperty(
        args.paginationConceptPropertyOffset,
        args.paginationConceptPropertyLimit,
        args.paginationConceptPropertyFilterSettings
      )(paginationConceptPropertySelection) ~ paginationConceptLink(
        args.paginationConceptLinkOffset,
        args.paginationConceptLinkLimit,
        args.paginationConceptLinkFilterSettings
      )(paginationConceptLinkSelection) ~ paginationConceptFact(
        args.paginationConceptFactOffset,
        args.paginationConceptFactLimit,
        args.paginationConceptFactFilterSettings
      )(paginationConceptFactSelection) ~ paginationConceptPropertyDocuments(
        args.paginationConceptPropertyDocumentsOffset,
        args.paginationConceptPropertyDocumentsLimit,
        args.paginationConceptPropertyDocumentsFilterSettings
      )(
        paginationConceptPropertyDocumentsSelection
      ) ~ paginationConceptLinkDocuments(
        args.paginationConceptLinkDocumentsOffset,
        args.paginationConceptLinkDocumentsLimit,
        args.paginationConceptLinkDocumentsFilterSettings
      )(paginationConceptLinkDocumentsSelection) ~ listConceptFact(
        listConceptFactSelection
      ) ~ image(imageSelection) ~ metric(metricSelection) ~ listAlias(
        listAliasSelection
      ) ~ paginationAlias(
        args.paginationAliasLimit,
        args.paginationAliasOffset
      )(paginationAliasSelection) ~ paginationMergedConcept(
        args.paginationMergedConceptLimit,
        args.paginationMergedConceptOffset
      )(paginationMergedConceptSelection) ~ listHeaderConceptProperty(
        listHeaderConceptPropertySelection
      )) ~ (paginationRedmineIssues(
        args.paginationRedmineIssuesLimit,
        args.paginationRedmineIssuesOffset,
        args.paginationRedmineIssuesSortDirection
      )(paginationRedmineIssuesSelection) ~ paginationIssue(
        args.paginationIssueOffset,
        args.paginationIssueLimit,
        args.paginationIssueFilterSettings,
        args.paginationIssueSortDirection,
        args.paginationIssueSorting
      )(paginationIssueSelection) ~ accessLevel(
        accessLevelSelection
      ) ~ listSubscription(listSubscriptionSelection) ~ paginationResearchMap(
        args.paginationResearchMapOffset,
        args.paginationResearchMapLimit,
        args.paginationResearchMapFilterSettings,
        args.paginationResearchMapSortDirection,
        args.paginationResearchMapSorting
      )(paginationResearchMapSelection) ~ creator(
        creatorSelection
      ) ~ lastUpdater(lastUpdaterSelection)))).map {
        case (
              (
                id,
                isActual,
                name,
                notes,
                systemRegistrationDate,
                systemUpdateDate,
                markers,
                startDate,
                endDate,
                conceptType,
                paginationConceptProperty,
                paginationConceptLink,
                paginationConceptFact,
                paginationConceptPropertyDocuments,
                paginationConceptLinkDocuments,
                listConceptFact,
                image,
                metric,
                listAlias,
                paginationAlias,
                paginationMergedConcept,
                listHeaderConceptProperty
              ),
              (
                paginationRedmineIssues,
                paginationIssue,
                accessLevel,
                listSubscription,
                paginationResearchMap,
                creator,
                lastUpdater
              )
            ) =>
          ConceptView(
            id,
            isActual,
            name,
            notes,
            systemRegistrationDate,
            systemUpdateDate,
            markers,
            startDate,
            endDate,
            conceptType,
            paginationConceptProperty,
            paginationConceptLink,
            paginationConceptFact,
            paginationConceptPropertyDocuments,
            paginationConceptLinkDocuments,
            listConceptFact,
            image,
            metric,
            listAlias,
            paginationAlias,
            paginationMergedConcept,
            listHeaderConceptProperty,
            paginationRedmineIssues,
            paginationIssue,
            accessLevel,
            listSubscription,
            paginationResearchMap,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[Concept, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def isActual: SelectionBuilder[Concept, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isActual", Scalar())
    def name: SelectionBuilder[Concept, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def notes: SelectionBuilder[Concept, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("notes", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[Concept, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Concept, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def markers: SelectionBuilder[Concept, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
    def startDate[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[Concept, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("startDate", OptionOf(Obj(innerSelection)))
    def endDate[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[Concept, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("endDate", OptionOf(Obj(innerSelection)))
    def conceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[Concept, A] = _root_.caliban.client.SelectionBuilder
      .Field("conceptType", Obj(innerSelection))
    def paginationConceptProperty[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ConceptPropertyFilterSettings
    )(innerSelection: SelectionBuilder[ConceptPropertyPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyFilterSettings]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptProperty",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyFilterSettings!"
          )(encoder2)
        )
      )
    def paginationConceptLink[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ConceptLinkFilterSettings
    )(innerSelection: SelectionBuilder[ConceptLinkPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptLinkFilterSettings]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLink",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptLinkFilterSettings!"
          )(encoder2)
        )
      )
    def paginationConceptFact[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: DocumentLinkFilterSetting
    )(innerSelection: SelectionBuilder[ConceptFactPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[DocumentLinkFilterSetting]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptFact",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "DocumentLinkFilterSetting!"
          )(encoder2)
        )
      )
    def paginationConceptPropertyDocuments[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ConceptPropertyFilterSettings
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyFilterSettings]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptPropertyDocuments",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyFilterSettings!"
          )(encoder2)
        )
      )
    def paginationConceptLinkDocuments[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ConceptLinkFilterSettings
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptLinkFilterSettings]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkDocuments",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptLinkFilterSettings!"
          )(encoder2)
        )
      )
    def listConceptFact[A](
        innerSelection: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[Concept, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptFact", ListOf(Obj(innerSelection)))
    def image[A](
        innerSelection: SelectionBuilder[Image, A]
    ): SelectionBuilder[Concept, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("image", OptionOf(Obj(innerSelection)))
    def metric[A](
        innerSelection: SelectionBuilder[ConceptStatistics, A]
    ): SelectionBuilder[Concept, A] = _root_.caliban.client.SelectionBuilder
      .Field("metric", Obj(innerSelection))
    def listAlias[A](
        innerSelection: SelectionBuilder[ConceptProperty, A]
    ): SelectionBuilder[Concept, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listAlias", ListOf(Obj(innerSelection)))
    def paginationAlias[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptPropertyPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationAlias",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1)
        )
      )
    def paginationMergedConcept[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[MergedConceptPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationMergedConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1)
        )
      )
    def listHeaderConceptProperty[A](
        innerSelection: SelectionBuilder[ConceptProperty, A]
    ): SelectionBuilder[Concept, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listHeaderConceptProperty", ListOf(Obj(innerSelection)))
    def paginationRedmineIssues[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        sortDirection: scala.Option[SortDirection] = None
    )(innerSelection: SelectionBuilder[RedmineIssuePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[SortDirection]]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationRedmineIssues",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder2)
        )
      )
    def paginationIssue[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: IssueFilterSettings,
        sortDirection: SortDirection,
        sorting: IssueSorting
    )(innerSelection: SelectionBuilder[IssuePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[IssueFilterSettings],
        encoder3: ArgEncoder[SortDirection],
        encoder4: ArgEncoder[IssueSorting]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationIssue",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("filterSettings", filterSettings, "IssueFilterSettings!")(
            encoder2
          ),
          Argument("sortDirection", sortDirection, "SortDirection!")(encoder3),
          Argument("sorting", sorting, "IssueSorting!")(encoder4)
        )
      )
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[Concept, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
    def listSubscription[A](
        innerSelection: SelectionBuilder[ConceptSubscriptions, A]
    ): SelectionBuilder[Concept, A] = _root_.caliban.client.SelectionBuilder
      .Field("listSubscription", Obj(innerSelection))
    def paginationResearchMap[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ResearchMapFilterSettings,
        sortDirection: SortDirection,
        sorting: ResearchMapSorting
    )(innerSelection: SelectionBuilder[ResearchMapPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ResearchMapFilterSettings],
        encoder3: ArgEncoder[SortDirection],
        encoder4: ArgEncoder[ResearchMapSorting]
    ): SelectionBuilder[Concept, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationResearchMap",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ResearchMapFilterSettings!"
          )(encoder2),
          Argument("sortDirection", sortDirection, "SortDirection!")(encoder3),
          Argument("sorting", sorting, "ResearchMapSorting!")(encoder4)
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Concept, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Concept, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptCandidateFact
  object ConceptCandidateFact {

    final case class ConceptCandidateFactView[
        MentionSelection,
        ConceptTypeSelection,
        ListConceptSelection,
        DocumentSelection
    ](
        id: String,
        name: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        conceptType: ConceptTypeSelection,
        listConcept: List[ListConceptSelection],
        document: DocumentSelection
    )

    type ViewSelection[
        MentionSelection,
        ConceptTypeSelection,
        ListConceptSelection,
        DocumentSelection
    ] = SelectionBuilder[ConceptCandidateFact, ConceptCandidateFactView[
      MentionSelection,
      ConceptTypeSelection,
      ListConceptSelection,
      DocumentSelection
    ]]

    def view[
        MentionSelection,
        ConceptTypeSelection,
        ListConceptSelection,
        DocumentSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        conceptTypeSelection: SelectionBuilder[
          ConceptType,
          ConceptTypeSelection
        ],
        listConceptSelection: SelectionBuilder[Concept, ListConceptSelection],
        documentSelection: SelectionBuilder[Document, DocumentSelection]
    ): ViewSelection[
      MentionSelection,
      ConceptTypeSelection,
      ListConceptSelection,
      DocumentSelection
    ] = (id ~ name ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ conceptType(
      conceptTypeSelection
    ) ~ listConcept(listConceptSelection) ~ document(documentSelection)).map {
      case (
            id,
            name,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            conceptType,
            listConcept,
            document
          ) =>
        ConceptCandidateFactView(
          id,
          name,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          conceptType,
          listConcept,
          document
        )
    }

    def id: SelectionBuilder[ConceptCandidateFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ConceptCandidateFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptCandidateFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate
        : SelectionBuilder[ConceptCandidateFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptCandidateFact, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def conceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptType", Obj(innerSelection))
    def listConcept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptCandidateFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConcept", ListOf(Obj(innerSelection)))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
  }

  type ConceptCandidateFactMention
  object ConceptCandidateFactMention {

    final case class ConceptCandidateFactMentionView[
        ConceptSelection,
        MentionSelection
    ](concept: ConceptSelection, mention: MentionSelection)

    type ViewSelection[ConceptSelection, MentionSelection] = SelectionBuilder[
      ConceptCandidateFactMention,
      ConceptCandidateFactMentionView[ConceptSelection, MentionSelection]
    ]

    def view[ConceptSelection, MentionSelection](
        conceptSelection: SelectionBuilder[
          ConceptCandidateFact,
          ConceptSelection
        ],
        mentionSelection: SelectionBuilder[Mention, MentionSelection]
    ): ViewSelection[ConceptSelection, MentionSelection] =
      (concept(conceptSelection) ~ mention(mentionSelection)).map {
        case (concept, mention) =>
          ConceptCandidateFactMentionView(concept, mention)
      }

    def concept[A](
        innerSelection: SelectionBuilder[ConceptCandidateFact, A]
    ): SelectionBuilder[ConceptCandidateFactMention, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("concept", Obj(innerSelection))
    def mention[A](
        innerSelection: SelectionBuilder[Mention, A]
    ): SelectionBuilder[ConceptCandidateFactMention, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", Obj(innerSelection))
  }

  type ConceptFact
  object ConceptFact {

    final case class ConceptFactView[
        MentionSelection,
        AccessLevelSelection,
        ConceptSelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        accessLevel: AccessLevelSelection,
        concept: ConceptSelection,
        document: DocumentSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        MentionSelection,
        AccessLevelSelection,
        ConceptSelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptFact, ConceptFactView[
      MentionSelection,
      AccessLevelSelection,
      ConceptSelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        MentionSelection,
        AccessLevelSelection,
        ConceptSelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        conceptSelection: SelectionBuilder[Concept, ConceptSelection],
        documentSelection: SelectionBuilder[Document, DocumentSelection],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      MentionSelection,
      AccessLevelSelection,
      ConceptSelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ accessLevel(
      accessLevelSelection
    ) ~ concept(conceptSelection) ~ document(documentSelection) ~ creator(
      creatorSelection
    ) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            accessLevel,
            concept,
            document,
            creator,
            lastUpdater
          ) =>
        ConceptFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          accessLevel,
          concept,
          document,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate: SelectionBuilder[ConceptFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptFact, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ConceptFact, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
    def concept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptFact, A] = _root_.caliban.client.SelectionBuilder
      .Field("concept", Obj(innerSelection))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptFact, A] = _root_.caliban.client.SelectionBuilder
      .Field("document", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptFact, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptFactLink
  object ConceptFactLink {

    final case class ConceptFactLinkView[
        ConceptSelection,
        ConceptFactSelection
    ](
        conceptId: String,
        conceptFactId: String,
        status: scala.Option[FactStatus],
        isImplicit: Boolean,
        concept: ConceptSelection,
        conceptFact: ConceptFactSelection
    )

    type ViewSelection[ConceptSelection, ConceptFactSelection] =
      SelectionBuilder[
        ConceptFactLink,
        ConceptFactLinkView[ConceptSelection, ConceptFactSelection]
      ]

    def view[ConceptSelection, ConceptFactSelection](
        conceptSelection: SelectionBuilder[Concept, ConceptSelection],
        conceptFactSelection: SelectionBuilder[
          ConceptCandidateFact,
          ConceptFactSelection
        ]
    ): ViewSelection[ConceptSelection, ConceptFactSelection] =
      (conceptId ~ conceptFactId ~ status ~ isImplicit ~ concept(
        conceptSelection
      ) ~ conceptFact(conceptFactSelection)).map {
        case (
              conceptId,
              conceptFactId,
              status,
              isImplicit,
              concept,
              conceptFact
            ) =>
          ConceptFactLinkView(
            conceptId,
            conceptFactId,
            status,
            isImplicit,
            concept,
            conceptFact
          )
      }

    def conceptId: SelectionBuilder[ConceptFactLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("conceptId", Scalar())
    def conceptFactId: SelectionBuilder[ConceptFactLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("conceptFactId", Scalar())
    def status: SelectionBuilder[ConceptFactLink, scala.Option[FactStatus]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def isImplicit: SelectionBuilder[ConceptFactLink, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isImplicit", Scalar())
    def concept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptFactLink, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("concept", Obj(innerSelection))
    def conceptFact[A](
        innerSelection: SelectionBuilder[ConceptCandidateFact, A]
    ): SelectionBuilder[ConceptFactLink, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptFact", Obj(innerSelection))
  }

  type ConceptFactPagination
  object ConceptFactPagination {

    final case class ConceptFactPaginationView[ListConceptFactSelection](
        total: Long,
        listConceptFact: List[ListConceptFactSelection]
    )

    type ViewSelection[ListConceptFactSelection] =
      SelectionBuilder[ConceptFactPagination, ConceptFactPaginationView[
        ListConceptFactSelection
      ]]

    def view[ListConceptFactSelection](
        listConceptFactSelection: SelectionBuilder[
          ConceptFact,
          ListConceptFactSelection
        ]
    ): ViewSelection[ListConceptFactSelection] =
      (total ~ listConceptFact(listConceptFactSelection)).map {
        case (total, listConceptFact) =>
          ConceptFactPaginationView(total, listConceptFact)
      }

    def total: SelectionBuilder[ConceptFactPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listConceptFact[A](
        innerSelection: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[ConceptFactPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptFact", ListOf(Obj(innerSelection)))
  }

  type ConceptImplicitLink
  object ConceptImplicitLink {

    final case class ConceptImplicitLinkView[
        ConceptFromSelection,
        ConceptToSelection,
        ConceptLinkTypeSelection
    ](
        conceptFromId: String,
        conceptToId: String,
        conceptFrom: ConceptFromSelection,
        conceptTo: ConceptToSelection,
        conceptLinkType: ConceptLinkTypeSelection
    )

    type ViewSelection[
        ConceptFromSelection,
        ConceptToSelection,
        ConceptLinkTypeSelection
    ] = SelectionBuilder[ConceptImplicitLink, ConceptImplicitLinkView[
      ConceptFromSelection,
      ConceptToSelection,
      ConceptLinkTypeSelection
    ]]

    def view[
        ConceptFromSelection,
        ConceptToSelection,
        ConceptLinkTypeSelection
    ](
        conceptFromSelection: SelectionBuilder[Concept, ConceptFromSelection],
        conceptToSelection: SelectionBuilder[Concept, ConceptToSelection],
        conceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ConceptLinkTypeSelection
        ]
    ): ViewSelection[
      ConceptFromSelection,
      ConceptToSelection,
      ConceptLinkTypeSelection
    ] = (conceptFromId ~ conceptToId ~ conceptFrom(
      conceptFromSelection
    ) ~ conceptTo(conceptToSelection) ~ conceptLinkType(
      conceptLinkTypeSelection
    )).map {
      case (
            conceptFromId,
            conceptToId,
            conceptFrom,
            conceptTo,
            conceptLinkType
          ) =>
        ConceptImplicitLinkView(
          conceptFromId,
          conceptToId,
          conceptFrom,
          conceptTo,
          conceptLinkType
        )
    }

    def conceptFromId: SelectionBuilder[ConceptImplicitLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("conceptFromId", Scalar())
    def conceptToId: SelectionBuilder[ConceptImplicitLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("conceptToId", Scalar())
    def conceptFrom[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptImplicitLink, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptFrom", Obj(innerSelection))
    def conceptTo[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptImplicitLink, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptTo", Obj(innerSelection))
    def conceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptImplicitLink, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptLinkType", Obj(innerSelection))
  }

  type ConceptLink
  object ConceptLink {

    final case class ConceptLinkView[
        StartDateSelection,
        EndDateSelection,
        ConceptFromSelection,
        ConceptToSelection,
        ConceptLinkTypeSelection,
        PaginationConceptLinkPropertySelection,
        PaginationConceptLinkPropertyDocumentsSelection,
        PaginationDocumentSelection,
        ListConceptLinkFactSelection,
        AccessLevelSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        conceptFromId: String,
        conceptToId: String,
        notes: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        startDate: scala.Option[StartDateSelection],
        endDate: scala.Option[EndDateSelection],
        conceptFrom: ConceptFromSelection,
        conceptTo: ConceptToSelection,
        conceptLinkType: ConceptLinkTypeSelection,
        paginationConceptLinkProperty: PaginationConceptLinkPropertySelection,
        paginationConceptLinkPropertyDocuments: PaginationConceptLinkPropertyDocumentsSelection,
        paginationDocument: PaginationDocumentSelection,
        listConceptLinkFact: List[ListConceptLinkFactSelection],
        accessLevel: AccessLevelSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        StartDateSelection,
        EndDateSelection,
        ConceptFromSelection,
        ConceptToSelection,
        ConceptLinkTypeSelection,
        PaginationConceptLinkPropertySelection,
        PaginationConceptLinkPropertyDocumentsSelection,
        PaginationDocumentSelection,
        ListConceptLinkFactSelection,
        AccessLevelSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptLink, ConceptLinkView[
      StartDateSelection,
      EndDateSelection,
      ConceptFromSelection,
      ConceptToSelection,
      ConceptLinkTypeSelection,
      PaginationConceptLinkPropertySelection,
      PaginationConceptLinkPropertyDocumentsSelection,
      PaginationDocumentSelection,
      ListConceptLinkFactSelection,
      AccessLevelSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        StartDateSelection,
        EndDateSelection,
        ConceptFromSelection,
        ConceptToSelection,
        ConceptLinkTypeSelection,
        PaginationConceptLinkPropertySelection,
        PaginationConceptLinkPropertyDocumentsSelection,
        PaginationDocumentSelection,
        ListConceptLinkFactSelection,
        AccessLevelSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationConceptLinkPropertyOffset: scala.Option[Int] = None,
        paginationConceptLinkPropertyLimit: scala.Option[Int] = None,
        paginationConceptLinkPropertyFilterSettings: ConceptPropertyFilterSettings,
        paginationConceptLinkPropertyDocumentsOffset: scala.Option[Int] = None,
        paginationConceptLinkPropertyDocumentsLimit: scala.Option[Int] = None,
        paginationConceptLinkPropertyDocumentsFilterSettings: ConceptPropertyFilterSettings,
        paginationDocumentOffset: scala.Option[Int] = None,
        paginationDocumentLimit: scala.Option[Int] = None
    )(
        startDateSelection: SelectionBuilder[DateTimeValue, StartDateSelection],
        endDateSelection: SelectionBuilder[DateTimeValue, EndDateSelection],
        conceptFromSelection: SelectionBuilder[Concept, ConceptFromSelection],
        conceptToSelection: SelectionBuilder[Concept, ConceptToSelection],
        conceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ConceptLinkTypeSelection
        ],
        paginationConceptLinkPropertySelection: SelectionBuilder[
          ConceptPropertyPagination,
          PaginationConceptLinkPropertySelection
        ],
        paginationConceptLinkPropertyDocumentsSelection: SelectionBuilder[
          DocumentPagination,
          PaginationConceptLinkPropertyDocumentsSelection
        ],
        paginationDocumentSelection: SelectionBuilder[
          DocumentPagination,
          PaginationDocumentSelection
        ],
        listConceptLinkFactSelection: SelectionBuilder[
          ConceptLinkFact,
          ListConceptLinkFactSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      StartDateSelection,
      EndDateSelection,
      ConceptFromSelection,
      ConceptToSelection,
      ConceptLinkTypeSelection,
      PaginationConceptLinkPropertySelection,
      PaginationConceptLinkPropertyDocumentsSelection,
      PaginationDocumentSelection,
      ListConceptLinkFactSelection,
      AccessLevelSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (id ~ conceptFromId ~ conceptToId ~ notes ~ systemRegistrationDate ~ systemUpdateDate ~ startDate(
        startDateSelection
      ) ~ endDate(endDateSelection) ~ conceptFrom(
        conceptFromSelection
      ) ~ conceptTo(conceptToSelection) ~ conceptLinkType(
        conceptLinkTypeSelection
      ) ~ paginationConceptLinkProperty(
        paginationConceptLinkPropertyOffset,
        paginationConceptLinkPropertyLimit,
        paginationConceptLinkPropertyFilterSettings
      )(
        paginationConceptLinkPropertySelection
      ) ~ paginationConceptLinkPropertyDocuments(
        paginationConceptLinkPropertyDocumentsOffset,
        paginationConceptLinkPropertyDocumentsLimit,
        paginationConceptLinkPropertyDocumentsFilterSettings
      )(paginationConceptLinkPropertyDocumentsSelection) ~ paginationDocument(
        paginationDocumentOffset,
        paginationDocumentLimit
      )(paginationDocumentSelection) ~ listConceptLinkFact(
        listConceptLinkFactSelection
      ) ~ accessLevel(accessLevelSelection) ~ creator(
        creatorSelection
      ) ~ lastUpdater(lastUpdaterSelection)).map {
        case (
              id,
              conceptFromId,
              conceptToId,
              notes,
              systemRegistrationDate,
              systemUpdateDate,
              startDate,
              endDate,
              conceptFrom,
              conceptTo,
              conceptLinkType,
              paginationConceptLinkProperty,
              paginationConceptLinkPropertyDocuments,
              paginationDocument,
              listConceptLinkFact,
              accessLevel,
              creator,
              lastUpdater
            ) =>
          ConceptLinkView(
            id,
            conceptFromId,
            conceptToId,
            notes,
            systemRegistrationDate,
            systemUpdateDate,
            startDate,
            endDate,
            conceptFrom,
            conceptTo,
            conceptLinkType,
            paginationConceptLinkProperty,
            paginationConceptLinkPropertyDocuments,
            paginationDocument,
            listConceptLinkFact,
            accessLevel,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[ConceptLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def conceptFromId: SelectionBuilder[ConceptLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("conceptFromId", Scalar())
    def conceptToId: SelectionBuilder[ConceptLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("conceptToId", Scalar())
    def notes: SelectionBuilder[ConceptLink, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("notes", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[ConceptLink, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptLink, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def startDate[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[ConceptLink, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("startDate", OptionOf(Obj(innerSelection)))
    def endDate[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[ConceptLink, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("endDate", OptionOf(Obj(innerSelection)))
    def conceptFrom[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptLink, A] = _root_.caliban.client.SelectionBuilder
      .Field("conceptFrom", Obj(innerSelection))
    def conceptTo[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptLink, A] = _root_.caliban.client.SelectionBuilder
      .Field("conceptTo", Obj(innerSelection))
    def conceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptLink, A] = _root_.caliban.client.SelectionBuilder
      .Field("conceptLinkType", Obj(innerSelection))
    def paginationConceptLinkProperty[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ConceptPropertyFilterSettings
    )(innerSelection: SelectionBuilder[ConceptPropertyPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyFilterSettings]
    ): SelectionBuilder[ConceptLink, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkProperty",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyFilterSettings!"
          )(encoder2)
        )
      )
    def paginationConceptLinkPropertyDocuments[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: ConceptPropertyFilterSettings
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyFilterSettings]
    ): SelectionBuilder[ConceptLink, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkPropertyDocuments",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyFilterSettings!"
          )(encoder2)
        )
      )
    def paginationDocument[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[ConceptLink, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationDocument",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def listConceptLinkFact[A](
        innerSelection: SelectionBuilder[ConceptLinkFact, A]
    ): SelectionBuilder[ConceptLink, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkFact", ListOf(Obj(innerSelection)))
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ConceptLink, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLink, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLink, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptLinkCandidateFact
  object ConceptLinkCandidateFact {

    final case class ConceptLinkCandidateFactView[
        MentionSelection,
        ConceptLinkTypeSelection,
        FactFromSelection,
        FactToSelection,
        DocumentSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        conceptLinkType: ConceptLinkTypeSelection,
        factFrom: scala.Option[FactFromSelection],
        factTo: scala.Option[FactToSelection],
        document: DocumentSelection
    )

    type ViewSelection[
        MentionSelection,
        ConceptLinkTypeSelection,
        FactFromSelection,
        FactToSelection,
        DocumentSelection
    ] = SelectionBuilder[ConceptLinkCandidateFact, ConceptLinkCandidateFactView[
      MentionSelection,
      ConceptLinkTypeSelection,
      FactFromSelection,
      FactToSelection,
      DocumentSelection
    ]]

    def view[
        MentionSelection,
        ConceptLinkTypeSelection,
        FactFromSelection,
        FactToSelection,
        DocumentSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        conceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ConceptLinkTypeSelection
        ],
        factFromSelectionOnConceptCandidateFact: SelectionBuilder[
          ConceptCandidateFact,
          FactFromSelection
        ],
        factFromSelectionOnConceptFact: SelectionBuilder[
          ConceptFact,
          FactFromSelection
        ],
        factToSelectionOnConceptCandidateFact: SelectionBuilder[
          ConceptCandidateFact,
          FactToSelection
        ],
        factToSelectionOnConceptFact: SelectionBuilder[
          ConceptFact,
          FactToSelection
        ],
        documentSelection: SelectionBuilder[Document, DocumentSelection]
    ): ViewSelection[
      MentionSelection,
      ConceptLinkTypeSelection,
      FactFromSelection,
      FactToSelection,
      DocumentSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ conceptLinkType(
      conceptLinkTypeSelection
    ) ~ factFrom(
      factFromSelectionOnConceptCandidateFact,
      factFromSelectionOnConceptFact
    ) ~ factTo(
      factToSelectionOnConceptCandidateFact,
      factToSelectionOnConceptFact
    ) ~ document(documentSelection)).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            conceptLinkType,
            factFrom,
            factTo,
            document
          ) =>
        ConceptLinkCandidateFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          conceptLinkType,
          factFrom,
          factTo,
          document
        )
    }

    def id: SelectionBuilder[ConceptLinkCandidateFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptLinkCandidateFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate
        : SelectionBuilder[ConceptLinkCandidateFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptLinkCandidateFact, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def conceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptLinkCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptLinkType", Obj(innerSelection))
    def factFrom[A](
        onConceptCandidateFact: SelectionBuilder[ConceptCandidateFact, A],
        onConceptFact: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[ConceptLinkCandidateFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "factFrom",
        OptionOf(
          ChoiceOf(
            Map(
              "ConceptCandidateFact" -> Obj(onConceptCandidateFact),
              "ConceptFact" -> Obj(onConceptFact)
            )
          )
        )
      )
    def factTo[A](
        onConceptCandidateFact: SelectionBuilder[ConceptCandidateFact, A],
        onConceptFact: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[ConceptLinkCandidateFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "factTo",
        OptionOf(
          ChoiceOf(
            Map(
              "ConceptCandidateFact" -> Obj(onConceptCandidateFact),
              "ConceptFact" -> Obj(onConceptFact)
            )
          )
        )
      )
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptLinkCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
    def factFromOption[A](
        onConceptCandidateFact: scala.Option[
          SelectionBuilder[ConceptCandidateFact, A]
        ] = None,
        onConceptFact: scala.Option[SelectionBuilder[ConceptFact, A]] = None
    ): SelectionBuilder[ConceptLinkCandidateFact, scala.Option[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "factFrom",
      OptionOf(
        ChoiceOf(
          Map(
            "ConceptCandidateFact" -> onConceptCandidateFact
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptFact" -> onConceptFact.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a)))
          )
        )
      )
    )
    def factToOption[A](
        onConceptCandidateFact: scala.Option[
          SelectionBuilder[ConceptCandidateFact, A]
        ] = None,
        onConceptFact: scala.Option[SelectionBuilder[ConceptFact, A]] = None
    ): SelectionBuilder[ConceptLinkCandidateFact, scala.Option[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "factTo",
      OptionOf(
        ChoiceOf(
          Map(
            "ConceptCandidateFact" -> onConceptCandidateFact
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptFact" -> onConceptFact.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a)))
          )
        )
      )
    )
  }

  type ConceptLinkFact
  object ConceptLinkFact {

    final case class ConceptLinkFactView[
        MentionSelection,
        AccessLevelSelection,
        ConceptLinkSelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        accessLevel: AccessLevelSelection,
        conceptLink: ConceptLinkSelection,
        document: DocumentSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        MentionSelection,
        AccessLevelSelection,
        ConceptLinkSelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptLinkFact, ConceptLinkFactView[
      MentionSelection,
      AccessLevelSelection,
      ConceptLinkSelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        MentionSelection,
        AccessLevelSelection,
        ConceptLinkSelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        conceptLinkSelection: SelectionBuilder[
          ConceptLink,
          ConceptLinkSelection
        ],
        documentSelection: SelectionBuilder[Document, DocumentSelection],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      MentionSelection,
      AccessLevelSelection,
      ConceptLinkSelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ accessLevel(
      accessLevelSelection
    ) ~ conceptLink(conceptLinkSelection) ~ document(
      documentSelection
    ) ~ creator(creatorSelection) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            accessLevel,
            conceptLink,
            document,
            creator,
            lastUpdater
          ) =>
        ConceptLinkFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          accessLevel,
          conceptLink,
          document,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptLinkFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptLinkFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate: SelectionBuilder[ConceptLinkFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptLinkFact, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ConceptLinkFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("accessLevel", Obj(innerSelection))
    def conceptLink[A](
        innerSelection: SelectionBuilder[ConceptLink, A]
    ): SelectionBuilder[ConceptLinkFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptLink", Obj(innerSelection))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptLinkFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLinkFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLinkFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptLinkFactPagination
  object ConceptLinkFactPagination {

    final case class ConceptLinkFactPaginationView[
        ListConceptLinkFactSelection
    ](total: Long, listConceptLinkFact: List[ListConceptLinkFactSelection])

    type ViewSelection[ListConceptLinkFactSelection] =
      SelectionBuilder[ConceptLinkFactPagination, ConceptLinkFactPaginationView[
        ListConceptLinkFactSelection
      ]]

    def view[ListConceptLinkFactSelection](
        listConceptLinkFactSelection: SelectionBuilder[
          ConceptLinkFact,
          ListConceptLinkFactSelection
        ]
    ): ViewSelection[ListConceptLinkFactSelection] =
      (total ~ listConceptLinkFact(listConceptLinkFactSelection)).map {
        case (total, listConceptLinkFact) =>
          ConceptLinkFactPaginationView(total, listConceptLinkFact)
      }

    def total: SelectionBuilder[ConceptLinkFactPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listConceptLinkFact[A](
        innerSelection: SelectionBuilder[ConceptLinkFact, A]
    ): SelectionBuilder[ConceptLinkFactPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkFact", ListOf(Obj(innerSelection)))
  }

  type ConceptLinkPagination
  object ConceptLinkPagination {

    final case class ConceptLinkPaginationView[ListConceptLinkSelection](
        total: Long,
        listConceptLink: List[ListConceptLinkSelection]
    )

    type ViewSelection[ListConceptLinkSelection] =
      SelectionBuilder[ConceptLinkPagination, ConceptLinkPaginationView[
        ListConceptLinkSelection
      ]]

    def view[ListConceptLinkSelection](
        listConceptLinkSelection: SelectionBuilder[
          ConceptLink,
          ListConceptLinkSelection
        ]
    ): ViewSelection[ListConceptLinkSelection] =
      (total ~ listConceptLink(listConceptLinkSelection)).map {
        case (total, listConceptLink) =>
          ConceptLinkPaginationView(total, listConceptLink)
      }

    def total: SelectionBuilder[ConceptLinkPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listConceptLink[A](
        innerSelection: SelectionBuilder[ConceptLink, A]
    ): SelectionBuilder[ConceptLinkPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLink", ListOf(Obj(innerSelection)))
  }

  type ConceptLinkPropertyFact
  object ConceptLinkPropertyFact {

    final case class ConceptLinkPropertyFactView[
        MentionSelection,
        ParentConceptLinkSelection,
        AccessLevelSelection,
        ConceptLinkPropertySelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        parentConceptLink: ParentConceptLinkSelection,
        accessLevel: AccessLevelSelection,
        conceptLinkProperty: ConceptLinkPropertySelection,
        document: DocumentSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        MentionSelection,
        ParentConceptLinkSelection,
        AccessLevelSelection,
        ConceptLinkPropertySelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptLinkPropertyFact, ConceptLinkPropertyFactView[
      MentionSelection,
      ParentConceptLinkSelection,
      AccessLevelSelection,
      ConceptLinkPropertySelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        MentionSelection,
        ParentConceptLinkSelection,
        AccessLevelSelection,
        ConceptLinkPropertySelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        parentConceptLinkSelection: SelectionBuilder[
          ConceptLink,
          ParentConceptLinkSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        conceptLinkPropertySelection: SelectionBuilder[
          ConceptProperty,
          ConceptLinkPropertySelection
        ],
        documentSelection: SelectionBuilder[Document, DocumentSelection],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      MentionSelection,
      ParentConceptLinkSelection,
      AccessLevelSelection,
      ConceptLinkPropertySelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ parentConceptLink(
      parentConceptLinkSelection
    ) ~ accessLevel(accessLevelSelection) ~ conceptLinkProperty(
      conceptLinkPropertySelection
    ) ~ document(documentSelection) ~ creator(creatorSelection) ~ lastUpdater(
      lastUpdaterSelection
    )).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            parentConceptLink,
            accessLevel,
            conceptLinkProperty,
            document,
            creator,
            lastUpdater
          ) =>
        ConceptLinkPropertyFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          parentConceptLink,
          accessLevel,
          conceptLinkProperty,
          document,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptLinkPropertyFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate
        : SelectionBuilder[ConceptLinkPropertyFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptLinkPropertyFact, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def parentConceptLink[A](
        innerSelection: SelectionBuilder[ConceptLink, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("parentConceptLink", Obj(innerSelection))
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("accessLevel", Obj(innerSelection))
    def conceptLinkProperty[A](
        innerSelection: SelectionBuilder[ConceptProperty, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptLinkProperty", Obj(innerSelection))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLinkPropertyFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptLinkType
  object ConceptLinkType {

    final case class ConceptLinkTypeView[
        ConceptFromTypeSelection,
        ConceptToTypeSelection,
        PretrainedRelExtModelsSelection,
        PaginationConceptLinkPropertyTypeSelection,
        ListConceptLinkPropertyTypeSelection,
        MetricSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        isDirected: Boolean,
        isHierarchical: Boolean,
        conceptFromType: ConceptFromTypeSelection,
        conceptToType: ConceptToTypeSelection,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        pretrainedRelExtModels: List[PretrainedRelExtModelsSelection],
        notifyOnUpdate: Boolean,
        paginationConceptLinkPropertyType: PaginationConceptLinkPropertyTypeSelection,
        listConceptLinkPropertyType: List[ListConceptLinkPropertyTypeSelection],
        metric: MetricSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        ConceptFromTypeSelection,
        ConceptToTypeSelection,
        PretrainedRelExtModelsSelection,
        PaginationConceptLinkPropertyTypeSelection,
        ListConceptLinkPropertyTypeSelection,
        MetricSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptLinkType, ConceptLinkTypeView[
      ConceptFromTypeSelection,
      ConceptToTypeSelection,
      PretrainedRelExtModelsSelection,
      PaginationConceptLinkPropertyTypeSelection,
      ListConceptLinkPropertyTypeSelection,
      MetricSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ConceptFromTypeSelection,
        ConceptToTypeSelection,
        PretrainedRelExtModelsSelection,
        PaginationConceptLinkPropertyTypeSelection,
        ListConceptLinkPropertyTypeSelection,
        MetricSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationConceptLinkPropertyTypeLimit: scala.Option[Int] = None,
        paginationConceptLinkPropertyTypeOffset: scala.Option[Int] = None,
        paginationConceptLinkPropertyTypeFilterSettings: ConceptPropertyTypeFilterSettings,
        paginationConceptLinkPropertyTypeSortDirection: SortDirection,
        paginationConceptLinkPropertyTypeSorting: ConceptTypeSorting
    )(
        conceptFromTypeSelection: SelectionBuilder[
          ConceptType,
          ConceptFromTypeSelection
        ],
        conceptToTypeSelection: SelectionBuilder[
          ConceptType,
          ConceptToTypeSelection
        ],
        pretrainedRelExtModelsSelection: SelectionBuilder[
          RelExtModel,
          PretrainedRelExtModelsSelection
        ],
        paginationConceptLinkPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyTypePagination,
          PaginationConceptLinkPropertyTypeSelection
        ],
        listConceptLinkPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          ListConceptLinkPropertyTypeSelection
        ],
        metricSelection: SelectionBuilder[
          ConceptLinkTypeStatistics,
          MetricSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ConceptFromTypeSelection,
      ConceptToTypeSelection,
      PretrainedRelExtModelsSelection,
      PaginationConceptLinkPropertyTypeSelection,
      ListConceptLinkPropertyTypeSelection,
      MetricSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ name ~ isDirected ~ isHierarchical ~ conceptFromType(
      conceptFromTypeSelection
    ) ~ conceptToType(
      conceptToTypeSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ pretrainedRelExtModels(
      pretrainedRelExtModelsSelection
    ) ~ notifyOnUpdate ~ paginationConceptLinkPropertyType(
      paginationConceptLinkPropertyTypeLimit,
      paginationConceptLinkPropertyTypeOffset,
      paginationConceptLinkPropertyTypeFilterSettings,
      paginationConceptLinkPropertyTypeSortDirection,
      paginationConceptLinkPropertyTypeSorting
    )(paginationConceptLinkPropertyTypeSelection) ~ listConceptLinkPropertyType(
      listConceptLinkPropertyTypeSelection
    ) ~ metric(metricSelection) ~ creator(creatorSelection) ~ lastUpdater(
      lastUpdaterSelection
    )).map {
      case (
            id,
            name,
            isDirected,
            isHierarchical,
            conceptFromType,
            conceptToType,
            systemRegistrationDate,
            systemUpdateDate,
            pretrainedRelExtModels,
            notifyOnUpdate,
            paginationConceptLinkPropertyType,
            listConceptLinkPropertyType,
            metric,
            creator,
            lastUpdater
          ) =>
        ConceptLinkTypeView(
          id,
          name,
          isDirected,
          isHierarchical,
          conceptFromType,
          conceptToType,
          systemRegistrationDate,
          systemUpdateDate,
          pretrainedRelExtModels,
          notifyOnUpdate,
          paginationConceptLinkPropertyType,
          listConceptLinkPropertyType,
          metric,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptLinkType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ConceptLinkType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def isDirected: SelectionBuilder[ConceptLinkType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isDirected", Scalar())
    def isHierarchical: SelectionBuilder[ConceptLinkType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isHierarchical", Scalar())
    def conceptFromType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptLinkType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptFromType", Obj(innerSelection))
    def conceptToType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptLinkType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptToType", Obj(innerSelection))
    def systemRegistrationDate: SelectionBuilder[ConceptLinkType, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptLinkType, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def pretrainedRelExtModels[A](
        innerSelection: SelectionBuilder[RelExtModel, A]
    ): SelectionBuilder[ConceptLinkType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pretrainedRelExtModels", ListOf(Obj(innerSelection)))
    def notifyOnUpdate: SelectionBuilder[ConceptLinkType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("notifyOnUpdate", Scalar())
    def paginationConceptLinkPropertyType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptPropertyTypeFilterSettings,
        sortDirection: SortDirection,
        sorting: ConceptTypeSorting
    )(
        innerSelection: SelectionBuilder[ConceptPropertyTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyTypeFilterSettings],
        encoder3: ArgEncoder[SortDirection],
        encoder4: ArgEncoder[ConceptTypeSorting]
    ): SelectionBuilder[ConceptLinkType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyTypeFilterSettings!"
          )(encoder2),
          Argument("sortDirection", sortDirection, "SortDirection!")(encoder3),
          Argument("sorting", sorting, "ConceptTypeSorting!")(encoder4)
        )
      )
    def listConceptLinkPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[ConceptLinkType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkPropertyType", ListOf(Obj(innerSelection)))
    def metric[A](
        innerSelection: SelectionBuilder[ConceptLinkTypeStatistics, A]
    ): SelectionBuilder[ConceptLinkType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("metric", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLinkType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptLinkType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptLinkTypePagination
  object ConceptLinkTypePagination {

    final case class ConceptLinkTypePaginationView[
        ListConceptLinkTypeSelection
    ](listConceptLinkType: List[ListConceptLinkTypeSelection], total: Int)

    type ViewSelection[ListConceptLinkTypeSelection] =
      SelectionBuilder[ConceptLinkTypePagination, ConceptLinkTypePaginationView[
        ListConceptLinkTypeSelection
      ]]

    def view[ListConceptLinkTypeSelection](
        listConceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ListConceptLinkTypeSelection
        ]
    ): ViewSelection[ListConceptLinkTypeSelection] =
      (listConceptLinkType(listConceptLinkTypeSelection) ~ total).map {
        case (listConceptLinkType, total) =>
          ConceptLinkTypePaginationView(listConceptLinkType, total)
      }

    def listConceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptLinkTypePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkType", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[ConceptLinkTypePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type ConceptLinkTypePath
  object ConceptLinkTypePath {

    final case class ConceptLinkTypePathView[LinkTypeSelection](
        linkType: LinkTypeSelection,
        fixed: scala.Option[ConceptLinkDirection]
    )

    type ViewSelection[LinkTypeSelection] =
      SelectionBuilder[ConceptLinkTypePath, ConceptLinkTypePathView[
        LinkTypeSelection
      ]]

    def view[LinkTypeSelection](
        linkTypeSelection: SelectionBuilder[ConceptLinkType, LinkTypeSelection]
    ): ViewSelection[LinkTypeSelection] =
      (linkType(linkTypeSelection) ~ fixed).map { case (linkType, fixed) =>
        ConceptLinkTypePathView(linkType, fixed)
      }

    def linkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptLinkTypePath, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("linkType", Obj(innerSelection))
    def fixed: SelectionBuilder[ConceptLinkTypePath, scala.Option[
      ConceptLinkDirection
    ]] =
      _root_.caliban.client.SelectionBuilder.Field("fixed", OptionOf(Scalar()))
  }

  type ConceptLinkTypeStatistics
  object ConceptLinkTypeStatistics {

    final case class ConceptLinkTypeStatisticsView(countPropertyType: Int)

    type ViewSelection =
      SelectionBuilder[ConceptLinkTypeStatistics, ConceptLinkTypeStatisticsView]

    def view: ViewSelection = countPropertyType.map(countPropertyType =>
      ConceptLinkTypeStatisticsView(countPropertyType)
    )

    def countPropertyType: SelectionBuilder[ConceptLinkTypeStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countPropertyType", Scalar())
  }

  type ConceptMention
  object ConceptMention {

    final case class ConceptMentionView[ConceptSelection, MentionSelection](
        concept: ConceptSelection,
        mention: MentionSelection
    )

    type ViewSelection[ConceptSelection, MentionSelection] = SelectionBuilder[
      ConceptMention,
      ConceptMentionView[ConceptSelection, MentionSelection]
    ]

    def view[ConceptSelection, MentionSelection](
        conceptSelection: SelectionBuilder[Concept, ConceptSelection],
        mentionSelection: SelectionBuilder[Mention, MentionSelection]
    ): ViewSelection[ConceptSelection, MentionSelection] =
      (concept(conceptSelection) ~ mention(mentionSelection)).map {
        case (concept, mention) => ConceptMentionView(concept, mention)
      }

    def concept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptMention, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("concept", Obj(innerSelection))
    def mention[A](
        innerSelection: SelectionBuilder[Mention, A]
    ): SelectionBuilder[ConceptMention, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", Obj(innerSelection))
  }

  type ConceptPagination
  object ConceptPagination {

    final case class ConceptPaginationView[ListConceptSelection](
        total: Long,
        showTotal: Long,
        listConcept: List[ListConceptSelection]
    )

    type ViewSelection[ListConceptSelection] =
      SelectionBuilder[ConceptPagination, ConceptPaginationView[
        ListConceptSelection
      ]]

    def view[ListConceptSelection](
        listConceptSelection: SelectionBuilder[Concept, ListConceptSelection]
    ): ViewSelection[ListConceptSelection] =
      (total ~ showTotal ~ listConcept(listConceptSelection)).map {
        case (total, showTotal, listConcept) =>
          ConceptPaginationView(total, showTotal, listConcept)
      }

    def total: SelectionBuilder[ConceptPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def showTotal: SelectionBuilder[ConceptPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("showTotal", Scalar())
    def listConcept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConcept", ListOf(Obj(innerSelection)))
  }

  type ConceptProperty
  object ConceptProperty {

    final case class ConceptPropertyView[
        PropertyTypeSelection,
        StartDateSelection,
        EndDateSelection,
        PaginationDocumentSelection,
        AccessLevelSelection,
        ValueSelection,
        ListConceptPropertyFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        isMain: Boolean,
        propertyType: PropertyTypeSelection,
        notes: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        startDate: scala.Option[StartDateSelection],
        endDate: scala.Option[EndDateSelection],
        paginationDocument: PaginationDocumentSelection,
        accessLevel: AccessLevelSelection,
        value: ValueSelection,
        listConceptPropertyFact: List[ListConceptPropertyFactSelection],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        PropertyTypeSelection,
        StartDateSelection,
        EndDateSelection,
        PaginationDocumentSelection,
        AccessLevelSelection,
        ValueSelection,
        ListConceptPropertyFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptProperty, ConceptPropertyView[
      PropertyTypeSelection,
      StartDateSelection,
      EndDateSelection,
      PaginationDocumentSelection,
      AccessLevelSelection,
      ValueSelection,
      ListConceptPropertyFactSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        PropertyTypeSelection,
        StartDateSelection,
        EndDateSelection,
        PaginationDocumentSelection,
        AccessLevelSelection,
        ValueSelection,
        ListConceptPropertyFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationDocumentOffset: scala.Option[Int] = None,
        paginationDocumentLimit: scala.Option[Int] = None
    )(
        propertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          PropertyTypeSelection
        ],
        startDateSelection: SelectionBuilder[DateTimeValue, StartDateSelection],
        endDateSelection: SelectionBuilder[DateTimeValue, EndDateSelection],
        paginationDocumentSelection: SelectionBuilder[
          DocumentPagination,
          PaginationDocumentSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        valueSelectionOnCompositeValue: SelectionBuilder[
          CompositeValue,
          ValueSelection
        ],
        valueSelectionOnDateTimeValue: SelectionBuilder[
          DateTimeValue,
          ValueSelection
        ],
        valueSelectionOnDoubleValue: SelectionBuilder[
          DoubleValue,
          ValueSelection
        ],
        valueSelectionOnGeoPointValue: SelectionBuilder[
          GeoPointValue,
          ValueSelection
        ],
        valueSelectionOnIntValue: SelectionBuilder[IntValue, ValueSelection],
        valueSelectionOnLinkValue: SelectionBuilder[LinkValue, ValueSelection],
        valueSelectionOnStringLocaleValue: SelectionBuilder[
          StringLocaleValue,
          ValueSelection
        ],
        valueSelectionOnStringValue: SelectionBuilder[
          StringValue,
          ValueSelection
        ],
        listConceptPropertyFactSelectionOnConceptLinkPropertyFact: SelectionBuilder[
          ConceptLinkPropertyFact,
          ListConceptPropertyFactSelection
        ],
        listConceptPropertyFactSelectionOnConceptPropertyFact: SelectionBuilder[
          ConceptPropertyFact,
          ListConceptPropertyFactSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      PropertyTypeSelection,
      StartDateSelection,
      EndDateSelection,
      PaginationDocumentSelection,
      AccessLevelSelection,
      ValueSelection,
      ListConceptPropertyFactSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ isMain ~ propertyType(
      propertyTypeSelection
    ) ~ notes ~ systemRegistrationDate ~ systemUpdateDate ~ startDate(
      startDateSelection
    ) ~ endDate(endDateSelection) ~ paginationDocument(
      paginationDocumentOffset,
      paginationDocumentLimit
    )(paginationDocumentSelection) ~ accessLevel(accessLevelSelection) ~ value(
      valueSelectionOnCompositeValue,
      valueSelectionOnDateTimeValue,
      valueSelectionOnDoubleValue,
      valueSelectionOnGeoPointValue,
      valueSelectionOnIntValue,
      valueSelectionOnLinkValue,
      valueSelectionOnStringLocaleValue,
      valueSelectionOnStringValue
    ) ~ listConceptPropertyFact(
      listConceptPropertyFactSelectionOnConceptLinkPropertyFact,
      listConceptPropertyFactSelectionOnConceptPropertyFact
    ) ~ creator(creatorSelection) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            isMain,
            propertyType,
            notes,
            systemRegistrationDate,
            systemUpdateDate,
            startDate,
            endDate,
            paginationDocument,
            accessLevel,
            value,
            listConceptPropertyFact,
            creator,
            lastUpdater
          ) =>
        ConceptPropertyView(
          id,
          isMain,
          propertyType,
          notes,
          systemRegistrationDate,
          systemUpdateDate,
          startDate,
          endDate,
          paginationDocument,
          accessLevel,
          value,
          listConceptPropertyFact,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptProperty, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def isMain: SelectionBuilder[ConceptProperty, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isMain", Scalar())
    def propertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[ConceptProperty, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("propertyType", Obj(innerSelection))
    def notes: SelectionBuilder[ConceptProperty, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("notes", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[ConceptProperty, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptProperty, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def startDate[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[ConceptProperty, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("startDate", OptionOf(Obj(innerSelection)))
    def endDate[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[ConceptProperty, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("endDate", OptionOf(Obj(innerSelection)))
    def paginationDocument[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[ConceptProperty, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationDocument",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ConceptProperty, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("accessLevel", Obj(innerSelection))
    def value[A](
        onCompositeValue: SelectionBuilder[CompositeValue, A],
        onDateTimeValue: SelectionBuilder[DateTimeValue, A],
        onDoubleValue: SelectionBuilder[DoubleValue, A],
        onGeoPointValue: SelectionBuilder[GeoPointValue, A],
        onIntValue: SelectionBuilder[IntValue, A],
        onLinkValue: SelectionBuilder[LinkValue, A],
        onStringLocaleValue: SelectionBuilder[StringLocaleValue, A],
        onStringValue: SelectionBuilder[StringValue, A]
    ): SelectionBuilder[ConceptProperty, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "value",
        ChoiceOf(
          Map(
            "CompositeValue" -> Obj(onCompositeValue),
            "DateTimeValue" -> Obj(onDateTimeValue),
            "DoubleValue" -> Obj(onDoubleValue),
            "GeoPointValue" -> Obj(onGeoPointValue),
            "IntValue" -> Obj(onIntValue),
            "LinkValue" -> Obj(onLinkValue),
            "StringLocaleValue" -> Obj(onStringLocaleValue),
            "StringValue" -> Obj(onStringValue)
          )
        )
      )
    def listConceptPropertyFact[A](
        onConceptLinkPropertyFact: SelectionBuilder[ConceptLinkPropertyFact, A],
        onConceptPropertyFact: SelectionBuilder[ConceptPropertyFact, A]
    ): SelectionBuilder[ConceptProperty, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listConceptPropertyFact",
        ListOf(
          ChoiceOf(
            Map(
              "ConceptLinkPropertyFact" -> Obj(onConceptLinkPropertyFact),
              "ConceptPropertyFact" -> Obj(onConceptPropertyFact)
            )
          )
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptProperty, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptProperty, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def valueOption[A](
        onCompositeValue: scala.Option[SelectionBuilder[CompositeValue, A]] =
          None,
        onDateTimeValue: scala.Option[SelectionBuilder[DateTimeValue, A]] =
          None,
        onDoubleValue: scala.Option[SelectionBuilder[DoubleValue, A]] = None,
        onGeoPointValue: scala.Option[SelectionBuilder[GeoPointValue, A]] =
          None,
        onIntValue: scala.Option[SelectionBuilder[IntValue, A]] = None,
        onLinkValue: scala.Option[SelectionBuilder[LinkValue, A]] = None,
        onStringLocaleValue: scala.Option[
          SelectionBuilder[StringLocaleValue, A]
        ] = None,
        onStringValue: scala.Option[SelectionBuilder[StringValue, A]] = None
    ): SelectionBuilder[ConceptProperty, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "value",
        ChoiceOf(
          Map(
            "CompositeValue" -> onCompositeValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "DateTimeValue" -> onDateTimeValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "DoubleValue" -> onDoubleValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "GeoPointValue" -> onGeoPointValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "IntValue" -> onIntValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "LinkValue" -> onLinkValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "StringLocaleValue" -> onStringLocaleValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "StringValue" -> onStringValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a)))
          )
        )
      )
    def listConceptPropertyFactOption[A](
        onConceptLinkPropertyFact: scala.Option[
          SelectionBuilder[ConceptLinkPropertyFact, A]
        ] = None,
        onConceptPropertyFact: scala.Option[
          SelectionBuilder[ConceptPropertyFact, A]
        ] = None
    ): SelectionBuilder[ConceptProperty, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listConceptPropertyFact",
        ListOf(
          ChoiceOf(
            Map(
              "ConceptLinkPropertyFact" -> onConceptLinkPropertyFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptPropertyFact" -> onConceptPropertyFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                )
            )
          )
        )
      )
  }

  type ConceptPropertyCandidateFact
  object ConceptPropertyCandidateFact {

    final case class ConceptPropertyCandidateFactView[
        MentionSelection,
        ConceptPropertyTypeSelection,
        FactToSelection,
        FactFromSelection,
        DocumentSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        conceptPropertyType: ConceptPropertyTypeSelection,
        factTo: FactToSelection,
        factFrom: scala.Option[FactFromSelection],
        document: DocumentSelection
    )

    type ViewSelection[
        MentionSelection,
        ConceptPropertyTypeSelection,
        FactToSelection,
        FactFromSelection,
        DocumentSelection
    ] = SelectionBuilder[
      ConceptPropertyCandidateFact,
      ConceptPropertyCandidateFactView[
        MentionSelection,
        ConceptPropertyTypeSelection,
        FactToSelection,
        FactFromSelection,
        DocumentSelection
      ]
    ]

    def view[
        MentionSelection,
        ConceptPropertyTypeSelection,
        FactToSelection,
        FactFromSelection,
        DocumentSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        conceptPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          ConceptPropertyTypeSelection
        ],
        factToSelection: SelectionBuilder[
          ConceptPropertyValueCandidateFact,
          FactToSelection
        ],
        factFromSelectionOnConceptCandidateFact: SelectionBuilder[
          ConceptCandidateFact,
          FactFromSelection
        ],
        factFromSelectionOnConceptFact: SelectionBuilder[
          ConceptFact,
          FactFromSelection
        ],
        documentSelection: SelectionBuilder[Document, DocumentSelection]
    ): ViewSelection[
      MentionSelection,
      ConceptPropertyTypeSelection,
      FactToSelection,
      FactFromSelection,
      DocumentSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ conceptPropertyType(
      conceptPropertyTypeSelection
    ) ~ factTo(factToSelection) ~ factFrom(
      factFromSelectionOnConceptCandidateFact,
      factFromSelectionOnConceptFact
    ) ~ document(documentSelection)).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            conceptPropertyType,
            factTo,
            factFrom,
            document
          ) =>
        ConceptPropertyCandidateFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          conceptPropertyType,
          factTo,
          factFrom,
          document
        )
    }

    def id: SelectionBuilder[ConceptPropertyCandidateFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptPropertyCandidateFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate
        : SelectionBuilder[ConceptPropertyCandidateFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[
      ConceptPropertyCandidateFact,
      scala.Option[UnixTime]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("systemUpdateDate", OptionOf(Scalar()))
    def conceptPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[ConceptPropertyCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptPropertyType", Obj(innerSelection))
    def factTo[A](
        innerSelection: SelectionBuilder[ConceptPropertyValueCandidateFact, A]
    ): SelectionBuilder[ConceptPropertyCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("factTo", Obj(innerSelection))
    def factFrom[A](
        onConceptCandidateFact: SelectionBuilder[ConceptCandidateFact, A],
        onConceptFact: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[ConceptPropertyCandidateFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "factFrom",
        OptionOf(
          ChoiceOf(
            Map(
              "ConceptCandidateFact" -> Obj(onConceptCandidateFact),
              "ConceptFact" -> Obj(onConceptFact)
            )
          )
        )
      )
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptPropertyCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
    def factFromOption[A](
        onConceptCandidateFact: scala.Option[
          SelectionBuilder[ConceptCandidateFact, A]
        ] = None,
        onConceptFact: scala.Option[SelectionBuilder[ConceptFact, A]] = None
    ): SelectionBuilder[ConceptPropertyCandidateFact, scala.Option[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "factFrom",
      OptionOf(
        ChoiceOf(
          Map(
            "ConceptCandidateFact" -> onConceptCandidateFact
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptFact" -> onConceptFact.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a)))
          )
        )
      )
    )
  }

  type ConceptPropertyFact
  object ConceptPropertyFact {

    final case class ConceptPropertyFactView[
        MentionSelection,
        ParentConceptSelection,
        AccessLevelSelection,
        ConceptPropertySelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        parentConcept: ParentConceptSelection,
        accessLevel: AccessLevelSelection,
        conceptProperty: ConceptPropertySelection,
        document: DocumentSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        MentionSelection,
        ParentConceptSelection,
        AccessLevelSelection,
        ConceptPropertySelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptPropertyFact, ConceptPropertyFactView[
      MentionSelection,
      ParentConceptSelection,
      AccessLevelSelection,
      ConceptPropertySelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        MentionSelection,
        ParentConceptSelection,
        AccessLevelSelection,
        ConceptPropertySelection,
        DocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        parentConceptSelection: SelectionBuilder[
          Concept,
          ParentConceptSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        conceptPropertySelection: SelectionBuilder[
          ConceptProperty,
          ConceptPropertySelection
        ],
        documentSelection: SelectionBuilder[Document, DocumentSelection],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      MentionSelection,
      ParentConceptSelection,
      AccessLevelSelection,
      ConceptPropertySelection,
      DocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ parentConcept(
      parentConceptSelection
    ) ~ accessLevel(accessLevelSelection) ~ conceptProperty(
      conceptPropertySelection
    ) ~ document(documentSelection) ~ creator(creatorSelection) ~ lastUpdater(
      lastUpdaterSelection
    )).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            parentConcept,
            accessLevel,
            conceptProperty,
            document,
            creator,
            lastUpdater
          ) =>
        ConceptPropertyFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          parentConcept,
          accessLevel,
          conceptProperty,
          document,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptPropertyFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptPropertyFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate
        : SelectionBuilder[ConceptPropertyFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptPropertyFact, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def parentConcept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("parentConcept", Obj(innerSelection))
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ConceptPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("accessLevel", Obj(innerSelection))
    def conceptProperty[A](
        innerSelection: SelectionBuilder[ConceptProperty, A]
    ): SelectionBuilder[ConceptPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptProperty", Obj(innerSelection))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptPropertyFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptPropertyFact, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptPropertyPagination
  object ConceptPropertyPagination {

    final case class ConceptPropertyPaginationView[
        ListConceptPropertySelection
    ](total: Long, listConceptProperty: List[ListConceptPropertySelection])

    type ViewSelection[ListConceptPropertySelection] =
      SelectionBuilder[ConceptPropertyPagination, ConceptPropertyPaginationView[
        ListConceptPropertySelection
      ]]

    def view[ListConceptPropertySelection](
        listConceptPropertySelection: SelectionBuilder[
          ConceptProperty,
          ListConceptPropertySelection
        ]
    ): ViewSelection[ListConceptPropertySelection] =
      (total ~ listConceptProperty(listConceptPropertySelection)).map {
        case (total, listConceptProperty) =>
          ConceptPropertyPaginationView(total, listConceptProperty)
      }

    def total: SelectionBuilder[ConceptPropertyPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listConceptProperty[A](
        innerSelection: SelectionBuilder[ConceptProperty, A]
    ): SelectionBuilder[ConceptPropertyPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptProperty", ListOf(Obj(innerSelection)))
  }

  type ConceptPropertyType
  object ConceptPropertyType {

    final case class ConceptPropertyTypeView[
        PretrainedRelExtModelsSelection,
        ParentConceptTypeSelection,
        ParentConceptLinkTypeSelection,
        ValueTypeSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        pretrainedRelExtModels: List[PretrainedRelExtModelsSelection],
        notifyOnUpdate: Boolean,
        computableFormula: scala.Option[String],
        parentConceptType: scala.Option[ParentConceptTypeSelection],
        parentConceptLinkType: scala.Option[ParentConceptLinkTypeSelection],
        valueType: ValueTypeSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        PretrainedRelExtModelsSelection,
        ParentConceptTypeSelection,
        ParentConceptLinkTypeSelection,
        ValueTypeSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptPropertyType, ConceptPropertyTypeView[
      PretrainedRelExtModelsSelection,
      ParentConceptTypeSelection,
      ParentConceptLinkTypeSelection,
      ValueTypeSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        PretrainedRelExtModelsSelection,
        ParentConceptTypeSelection,
        ParentConceptLinkTypeSelection,
        ValueTypeSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        pretrainedRelExtModelsSelection: SelectionBuilder[
          RelExtModel,
          PretrainedRelExtModelsSelection
        ],
        parentConceptTypeSelection: SelectionBuilder[
          ConceptType,
          ParentConceptTypeSelection
        ],
        parentConceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ParentConceptLinkTypeSelection
        ],
        valueTypeSelectionOnCompositePropertyValueTemplate: SelectionBuilder[
          CompositePropertyValueTemplate,
          ValueTypeSelection
        ],
        valueTypeSelectionOnConceptPropertyValueType: SelectionBuilder[
          ConceptPropertyValueType,
          ValueTypeSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      PretrainedRelExtModelsSelection,
      ParentConceptTypeSelection,
      ParentConceptLinkTypeSelection,
      ValueTypeSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (id ~ name ~ systemRegistrationDate ~ systemUpdateDate ~ pretrainedRelExtModels(
        pretrainedRelExtModelsSelection
      ) ~ notifyOnUpdate ~ computableFormula ~ parentConceptType(
        parentConceptTypeSelection
      ) ~ parentConceptLinkType(parentConceptLinkTypeSelection) ~ valueType(
        valueTypeSelectionOnCompositePropertyValueTemplate,
        valueTypeSelectionOnConceptPropertyValueType
      ) ~ creator(creatorSelection) ~ lastUpdater(lastUpdaterSelection)).map {
        case (
              id,
              name,
              systemRegistrationDate,
              systemUpdateDate,
              pretrainedRelExtModels,
              notifyOnUpdate,
              computableFormula,
              parentConceptType,
              parentConceptLinkType,
              valueType,
              creator,
              lastUpdater
            ) =>
          ConceptPropertyTypeView(
            id,
            name,
            systemRegistrationDate,
            systemUpdateDate,
            pretrainedRelExtModels,
            notifyOnUpdate,
            computableFormula,
            parentConceptType,
            parentConceptLinkType,
            valueType,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[ConceptPropertyType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ConceptPropertyType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def systemRegistrationDate
        : SelectionBuilder[ConceptPropertyType, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptPropertyType, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def pretrainedRelExtModels[A](
        innerSelection: SelectionBuilder[RelExtModel, A]
    ): SelectionBuilder[ConceptPropertyType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pretrainedRelExtModels", ListOf(Obj(innerSelection)))
    def notifyOnUpdate: SelectionBuilder[ConceptPropertyType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("notifyOnUpdate", Scalar())
    def computableFormula
        : SelectionBuilder[ConceptPropertyType, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("computableFormula", OptionOf(Scalar()))
    def parentConceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptPropertyType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("parentConceptType", OptionOf(Obj(innerSelection)))
    def parentConceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptPropertyType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("parentConceptLinkType", OptionOf(Obj(innerSelection)))
    def valueType[A](
        onCompositePropertyValueTemplate: SelectionBuilder[
          CompositePropertyValueTemplate,
          A
        ],
        onConceptPropertyValueType: SelectionBuilder[
          ConceptPropertyValueType,
          A
        ]
    ): SelectionBuilder[ConceptPropertyType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "valueType",
        ChoiceOf(
          Map(
            "CompositePropertyValueTemplate" -> Obj(
              onCompositePropertyValueTemplate
            ),
            "ConceptPropertyValueType" -> Obj(onConceptPropertyValueType)
          )
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptPropertyType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptPropertyType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def valueTypeOption[A](
        onCompositePropertyValueTemplate: scala.Option[
          SelectionBuilder[CompositePropertyValueTemplate, A]
        ] = None,
        onConceptPropertyValueType: scala.Option[
          SelectionBuilder[ConceptPropertyValueType, A]
        ] = None
    ): SelectionBuilder[ConceptPropertyType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "valueType",
        ChoiceOf(
          Map(
            "CompositePropertyValueTemplate" -> onCompositePropertyValueTemplate
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptPropertyValueType" -> onConceptPropertyValueType
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              )
          )
        )
      )
  }

  type ConceptPropertyTypePagination
  object ConceptPropertyTypePagination {

    final case class ConceptPropertyTypePaginationView[
        ListConceptPropertyTypeSelection
    ](
        listConceptPropertyType: List[ListConceptPropertyTypeSelection],
        total: Int
    )

    type ViewSelection[ListConceptPropertyTypeSelection] = SelectionBuilder[
      ConceptPropertyTypePagination,
      ConceptPropertyTypePaginationView[ListConceptPropertyTypeSelection]
    ]

    def view[ListConceptPropertyTypeSelection](
        listConceptPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          ListConceptPropertyTypeSelection
        ]
    ): ViewSelection[ListConceptPropertyTypeSelection] =
      (listConceptPropertyType(listConceptPropertyTypeSelection) ~ total).map {
        case (listConceptPropertyType, total) =>
          ConceptPropertyTypePaginationView(listConceptPropertyType, total)
      }

    def listConceptPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[ConceptPropertyTypePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptPropertyType", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[ConceptPropertyTypePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type ConceptPropertyValueCandidateFact
  object ConceptPropertyValueCandidateFact {

    final case class ConceptPropertyValueCandidateFactView[
        MentionSelection,
        ConceptPropertyValueTypeSelection,
        DocumentSelection
    ](
        id: String,
        mention: List[MentionSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        conceptPropertyValueType: ConceptPropertyValueTypeSelection,
        document: DocumentSelection
    )

    type ViewSelection[
        MentionSelection,
        ConceptPropertyValueTypeSelection,
        DocumentSelection
    ] = SelectionBuilder[
      ConceptPropertyValueCandidateFact,
      ConceptPropertyValueCandidateFactView[
        MentionSelection,
        ConceptPropertyValueTypeSelection,
        DocumentSelection
      ]
    ]

    def view[
        MentionSelection,
        ConceptPropertyValueTypeSelection,
        DocumentSelection
    ](
        mentionSelection: SelectionBuilder[TextBounding, MentionSelection],
        conceptPropertyValueTypeSelection: SelectionBuilder[
          ConceptPropertyValueType,
          ConceptPropertyValueTypeSelection
        ],
        documentSelection: SelectionBuilder[Document, DocumentSelection]
    ): ViewSelection[
      MentionSelection,
      ConceptPropertyValueTypeSelection,
      DocumentSelection
    ] = (id ~ mention(
      mentionSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ conceptPropertyValueType(
      conceptPropertyValueTypeSelection
    ) ~ document(documentSelection)).map {
      case (
            id,
            mention,
            systemRegistrationDate,
            systemUpdateDate,
            conceptPropertyValueType,
            document
          ) =>
        ConceptPropertyValueCandidateFactView(
          id,
          mention,
          systemRegistrationDate,
          systemUpdateDate,
          conceptPropertyValueType,
          document
        )
    }

    def id: SelectionBuilder[ConceptPropertyValueCandidateFact, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def mention[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[ConceptPropertyValueCandidateFact, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mention", ListOf(Obj(innerSelection)))
    def systemRegistrationDate
        : SelectionBuilder[ConceptPropertyValueCandidateFact, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[
      ConceptPropertyValueCandidateFact,
      scala.Option[UnixTime]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("systemUpdateDate", OptionOf(Scalar()))
    def conceptPropertyValueType[A](
        innerSelection: SelectionBuilder[ConceptPropertyValueType, A]
    ): SelectionBuilder[ConceptPropertyValueCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptPropertyValueType", Obj(innerSelection))
    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[ConceptPropertyValueCandidateFact, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
  }

  type ConceptPropertyValueStatistics
  object ConceptPropertyValueStatistics {

    final case class ConceptPropertyValueStatisticsView(
        countConceptType: Int,
        countLinkType: Int,
        countDictionary: Int,
        countRegexp: Int
    )

    type ViewSelection = SelectionBuilder[
      ConceptPropertyValueStatistics,
      ConceptPropertyValueStatisticsView
    ]

    def view: ViewSelection =
      (countConceptType ~ countLinkType ~ countDictionary ~ countRegexp).map {
        case (countConceptType, countLinkType, countDictionary, countRegexp) =>
          ConceptPropertyValueStatisticsView(
            countConceptType,
            countLinkType,
            countDictionary,
            countRegexp
          )
      }

    def countConceptType
        : SelectionBuilder[ConceptPropertyValueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countConceptType", Scalar())
    def countLinkType: SelectionBuilder[ConceptPropertyValueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countLinkType", Scalar())
    def countDictionary: SelectionBuilder[ConceptPropertyValueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDictionary", Scalar())
    def countRegexp: SelectionBuilder[ConceptPropertyValueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countRegexp", Scalar())
  }

  type ConceptPropertyValueType
  object ConceptPropertyValueType {

    final case class ConceptPropertyValueTypeView[
        ListWhiteRegexpSelection,
        MetricSelection,
        ListConceptTypeSelection,
        PaginationConceptTypeSelection,
        ListConceptLinkTypeSelection,
        PaginationConceptLinkTypeSelection,
        ListBlackRegexpSelection,
        ListTypeSearchElementSelection,
        ListTypeBlackSearchElementSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        valueType: ValueType,
        listWhiteDictionary: List[String],
        pretrainedNERCModels: List[String],
        listWhiteRegexp: List[ListWhiteRegexpSelection],
        valueRestriction: List[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        listBlackDictionary: List[String],
        metric: MetricSelection,
        listConceptType: List[ListConceptTypeSelection],
        paginationConceptType: PaginationConceptTypeSelection,
        listConceptLinkType: List[ListConceptLinkTypeSelection],
        paginationConceptLinkType: PaginationConceptLinkTypeSelection,
        listBlackRegexp: List[ListBlackRegexpSelection],
        listTypeSearchElement: List[ListTypeSearchElementSelection],
        listTypeBlackSearchElement: List[ListTypeBlackSearchElementSelection],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        ListWhiteRegexpSelection,
        MetricSelection,
        ListConceptTypeSelection,
        PaginationConceptTypeSelection,
        ListConceptLinkTypeSelection,
        PaginationConceptLinkTypeSelection,
        ListBlackRegexpSelection,
        ListTypeSearchElementSelection,
        ListTypeBlackSearchElementSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptPropertyValueType, ConceptPropertyValueTypeView[
      ListWhiteRegexpSelection,
      MetricSelection,
      ListConceptTypeSelection,
      PaginationConceptTypeSelection,
      ListConceptLinkTypeSelection,
      PaginationConceptLinkTypeSelection,
      ListBlackRegexpSelection,
      ListTypeSearchElementSelection,
      ListTypeBlackSearchElementSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ListWhiteRegexpSelection,
        MetricSelection,
        ListConceptTypeSelection,
        PaginationConceptTypeSelection,
        ListConceptLinkTypeSelection,
        PaginationConceptLinkTypeSelection,
        ListBlackRegexpSelection,
        ListTypeSearchElementSelection,
        ListTypeBlackSearchElementSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationConceptTypeLimit: scala.Option[Int] = None,
        paginationConceptTypeOffset: scala.Option[Int] = None,
        paginationConceptLinkTypeLimit: scala.Option[Int] = None,
        paginationConceptLinkTypeOffset: scala.Option[Int] = None
    )(
        listWhiteRegexpSelection: SelectionBuilder[
          NERCRegexp,
          ListWhiteRegexpSelection
        ],
        metricSelection: SelectionBuilder[
          ConceptPropertyValueStatistics,
          MetricSelection
        ],
        listConceptTypeSelection: SelectionBuilder[
          ConceptType,
          ListConceptTypeSelection
        ],
        paginationConceptTypeSelection: SelectionBuilder[
          ConceptTypePagination,
          PaginationConceptTypeSelection
        ],
        listConceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ListConceptLinkTypeSelection
        ],
        paginationConceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkTypePagination,
          PaginationConceptLinkTypeSelection
        ],
        listBlackRegexpSelection: SelectionBuilder[
          NERCRegexp,
          ListBlackRegexpSelection
        ],
        listTypeSearchElementSelectionOnDictValue: SelectionBuilder[
          DictValue,
          ListTypeSearchElementSelection
        ],
        listTypeSearchElementSelectionOnNERCRegexp: SelectionBuilder[
          NERCRegexp,
          ListTypeSearchElementSelection
        ],
        listTypeBlackSearchElementSelectionOnDictValue: SelectionBuilder[
          DictValue,
          ListTypeBlackSearchElementSelection
        ],
        listTypeBlackSearchElementSelectionOnNERCRegexp: SelectionBuilder[
          NERCRegexp,
          ListTypeBlackSearchElementSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ListWhiteRegexpSelection,
      MetricSelection,
      ListConceptTypeSelection,
      PaginationConceptTypeSelection,
      ListConceptLinkTypeSelection,
      PaginationConceptLinkTypeSelection,
      ListBlackRegexpSelection,
      ListTypeSearchElementSelection,
      ListTypeBlackSearchElementSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ name ~ valueType ~ listWhiteDictionary ~ pretrainedNERCModels ~ listWhiteRegexp(
      listWhiteRegexpSelection
    ) ~ valueRestriction ~ systemRegistrationDate ~ systemUpdateDate ~ listBlackDictionary ~ metric(
      metricSelection
    ) ~ listConceptType(listConceptTypeSelection) ~ paginationConceptType(
      paginationConceptTypeLimit,
      paginationConceptTypeOffset
    )(paginationConceptTypeSelection) ~ listConceptLinkType(
      listConceptLinkTypeSelection
    ) ~ paginationConceptLinkType(
      paginationConceptLinkTypeLimit,
      paginationConceptLinkTypeOffset
    )(paginationConceptLinkTypeSelection) ~ listBlackRegexp(
      listBlackRegexpSelection
    ) ~ listTypeSearchElement(
      listTypeSearchElementSelectionOnDictValue,
      listTypeSearchElementSelectionOnNERCRegexp
    ) ~ listTypeBlackSearchElement(
      listTypeBlackSearchElementSelectionOnDictValue,
      listTypeBlackSearchElementSelectionOnNERCRegexp
    ) ~ creator(creatorSelection) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            name,
            valueType,
            listWhiteDictionary,
            pretrainedNERCModels,
            listWhiteRegexp,
            valueRestriction,
            systemRegistrationDate,
            systemUpdateDate,
            listBlackDictionary,
            metric,
            listConceptType,
            paginationConceptType,
            listConceptLinkType,
            paginationConceptLinkType,
            listBlackRegexp,
            listTypeSearchElement,
            listTypeBlackSearchElement,
            creator,
            lastUpdater
          ) =>
        ConceptPropertyValueTypeView(
          id,
          name,
          valueType,
          listWhiteDictionary,
          pretrainedNERCModels,
          listWhiteRegexp,
          valueRestriction,
          systemRegistrationDate,
          systemUpdateDate,
          listBlackDictionary,
          metric,
          listConceptType,
          paginationConceptType,
          listConceptLinkType,
          paginationConceptLinkType,
          listBlackRegexp,
          listTypeSearchElement,
          listTypeBlackSearchElement,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptPropertyValueType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ConceptPropertyValueType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def valueType: SelectionBuilder[ConceptPropertyValueType, ValueType] =
      _root_.caliban.client.SelectionBuilder.Field("valueType", Scalar())
    def listWhiteDictionary
        : SelectionBuilder[ConceptPropertyValueType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listWhiteDictionary", ListOf(Scalar()))
    def pretrainedNERCModels
        : SelectionBuilder[ConceptPropertyValueType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pretrainedNERCModels", ListOf(Scalar()))
    def listWhiteRegexp[A](
        innerSelection: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptPropertyValueType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listWhiteRegexp", ListOf(Obj(innerSelection)))
    def valueRestriction
        : SelectionBuilder[ConceptPropertyValueType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("valueRestriction", ListOf(Scalar()))
    def systemRegistrationDate
        : SelectionBuilder[ConceptPropertyValueType, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptPropertyValueType, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def listBlackDictionary
        : SelectionBuilder[ConceptPropertyValueType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listBlackDictionary", ListOf(Scalar()))
    def metric[A](
        innerSelection: SelectionBuilder[ConceptPropertyValueStatistics, A]
    ): SelectionBuilder[ConceptPropertyValueType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("metric", Obj(innerSelection))
    def listConceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptPropertyValueType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptType", ListOf(Obj(innerSelection)))
    def paginationConceptType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptTypePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[ConceptPropertyValueType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1)
        )
      )
    def listConceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptPropertyValueType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkType", ListOf(Obj(innerSelection)))
    def paginationConceptLinkType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptLinkTypePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[ConceptPropertyValueType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1)
        )
      )
    def listBlackRegexp[A](
        innerSelection: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptPropertyValueType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listBlackRegexp", ListOf(Obj(innerSelection)))
    def listTypeSearchElement[A](
        onDictValue: SelectionBuilder[DictValue, A],
        onNERCRegexp: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptPropertyValueType, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> Obj(onDictValue),
              "NERCRegexp" -> Obj(onNERCRegexp)
            )
          )
        )
      )
    def listTypeBlackSearchElement[A](
        onDictValue: SelectionBuilder[DictValue, A],
        onNERCRegexp: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptPropertyValueType, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeBlackSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> Obj(onDictValue),
              "NERCRegexp" -> Obj(onNERCRegexp)
            )
          )
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptPropertyValueType, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptPropertyValueType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def listTypeSearchElementOption[A](
        onDictValue: scala.Option[SelectionBuilder[DictValue, A]] = None,
        onNERCRegexp: scala.Option[SelectionBuilder[NERCRegexp, A]] = None
    ): SelectionBuilder[ConceptPropertyValueType, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> onDictValue.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a))),
              "NERCRegexp" -> onNERCRegexp.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a)))
            )
          )
        )
      )
    def listTypeBlackSearchElementOption[A](
        onDictValue: scala.Option[SelectionBuilder[DictValue, A]] = None,
        onNERCRegexp: scala.Option[SelectionBuilder[NERCRegexp, A]] = None
    ): SelectionBuilder[ConceptPropertyValueType, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeBlackSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> onDictValue.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a))),
              "NERCRegexp" -> onNERCRegexp.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a)))
            )
          )
        )
      )
  }

  type ConceptPropertyValueTypePagination
  object ConceptPropertyValueTypePagination {

    final case class ConceptPropertyValueTypePaginationView[
        ListConceptPropertyValueTypeSelection
    ](
        listConceptPropertyValueType: List[
          ListConceptPropertyValueTypeSelection
        ],
        total: Int
    )

    type ViewSelection[ListConceptPropertyValueTypeSelection] =
      SelectionBuilder[
        ConceptPropertyValueTypePagination,
        ConceptPropertyValueTypePaginationView[
          ListConceptPropertyValueTypeSelection
        ]
      ]

    def view[ListConceptPropertyValueTypeSelection](
        listConceptPropertyValueTypeSelection: SelectionBuilder[
          ConceptPropertyValueType,
          ListConceptPropertyValueTypeSelection
        ]
    ): ViewSelection[ListConceptPropertyValueTypeSelection] =
      (listConceptPropertyValueType(
        listConceptPropertyValueTypeSelection
      ) ~ total).map { case (listConceptPropertyValueType, total) =>
        ConceptPropertyValueTypePaginationView(
          listConceptPropertyValueType,
          total
        )
      }

    def listConceptPropertyValueType[A](
        innerSelection: SelectionBuilder[ConceptPropertyValueType, A]
    ): SelectionBuilder[ConceptPropertyValueTypePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptPropertyValueType", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[ConceptPropertyValueTypePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type ConceptRegistryView
  object ConceptRegistryView {

    final case class ConceptRegistryViewView[
        ColumnsSelection,
        MetricsSelection,
        SortingSelection
    ](
        columns: List[ColumnsSelection],
        metrics: List[MetricsSelection],
        sorting: scala.Option[SortingSelection]
    )

    type ViewSelection[ColumnsSelection, MetricsSelection, SortingSelection] =
      SelectionBuilder[ConceptRegistryView, ConceptRegistryViewView[
        ColumnsSelection,
        MetricsSelection,
        SortingSelection
      ]]

    def view[ColumnsSelection, MetricsSelection, SortingSelection](
        columnsSelection: SelectionBuilder[
          ConceptRegistryViewColumn,
          ColumnsSelection
        ],
        metricsSelection: SelectionBuilder[
          ConceptRegistryViewMetric,
          MetricsSelection
        ],
        sortingSelection: SelectionBuilder[
          ConceptRegistryViewSorting,
          SortingSelection
        ]
    ): ViewSelection[ColumnsSelection, MetricsSelection, SortingSelection] =
      (columns(columnsSelection) ~ metrics(metricsSelection) ~ sorting(
        sortingSelection
      )).map { case (columns, metrics, sorting) =>
        ConceptRegistryViewView(columns, metrics, sorting)
      }

    def columns[A](
        innerSelection: SelectionBuilder[ConceptRegistryViewColumn, A]
    ): SelectionBuilder[ConceptRegistryView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("columns", ListOf(Obj(innerSelection)))
    def metrics[A](
        innerSelection: SelectionBuilder[ConceptRegistryViewMetric, A]
    ): SelectionBuilder[ConceptRegistryView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("metrics", ListOf(Obj(innerSelection)))
    def sorting[A](
        innerSelection: SelectionBuilder[ConceptRegistryViewSorting, A]
    ): SelectionBuilder[ConceptRegistryView, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("sorting", OptionOf(Obj(innerSelection)))
  }

  type ConceptRegistryViewColumn
  object ConceptRegistryViewColumn {

    final case class ConceptRegistryViewColumnView(
        columnType: ConceptViewColumnType
    )

    type ViewSelection =
      SelectionBuilder[ConceptRegistryViewColumn, ConceptRegistryViewColumnView]

    def view: ViewSelection =
      columnType.map(columnType => ConceptRegistryViewColumnView(columnType))

    def columnType
        : SelectionBuilder[ConceptRegistryViewColumn, ConceptViewColumnType] =
      _root_.caliban.client.SelectionBuilder.Field("columnType", Scalar())
  }

  type ConceptRegistryViewMetric
  object ConceptRegistryViewMetric {

    final case class ConceptRegistryViewMetricView(
        metricType: ConceptViewMetricType
    )

    type ViewSelection =
      SelectionBuilder[ConceptRegistryViewMetric, ConceptRegistryViewMetricView]

    def view: ViewSelection =
      metricType.map(metricType => ConceptRegistryViewMetricView(metricType))

    def metricType
        : SelectionBuilder[ConceptRegistryViewMetric, ConceptViewMetricType] =
      _root_.caliban.client.SelectionBuilder.Field("metricType", Scalar())
  }

  type ConceptRegistryViewSorting
  object ConceptRegistryViewSorting {

    final case class ConceptRegistryViewSortingView(
        sortingType: ConceptSorting,
        sortDirection: SortDirection
    )

    type ViewSelection = SelectionBuilder[
      ConceptRegistryViewSorting,
      ConceptRegistryViewSortingView
    ]

    def view: ViewSelection = (sortingType ~ sortDirection).map {
      case (sortingType, sortDirection) =>
        ConceptRegistryViewSortingView(sortingType, sortDirection)
    }

    def sortingType
        : SelectionBuilder[ConceptRegistryViewSorting, ConceptSorting] =
      _root_.caliban.client.SelectionBuilder.Field("sortingType", Scalar())
    def sortDirection
        : SelectionBuilder[ConceptRegistryViewSorting, SortDirection] =
      _root_.caliban.client.SelectionBuilder.Field("sortDirection", Scalar())
  }

  type ConceptStatistics
  object ConceptStatistics {

    final case class ConceptStatisticsView(
        countProperties: Int,
        countObjects: Int,
        countEvents: Int,
        countDocumentFacts: Int,
        countPotentialDocuments: Int,
        countResearchMaps: Int,
        countTasks: Int,
        countConcepts: Int,
        countDocumentMentions: Int,
        countConceptsAndDocuments: Int
    )

    type ViewSelection =
      SelectionBuilder[ConceptStatistics, ConceptStatisticsView]

    def view: ViewSelection =
      (countProperties ~ countObjects ~ countEvents ~ countDocumentFacts ~ countPotentialDocuments ~ countResearchMaps ~ countTasks ~ countConcepts ~ countDocumentMentions ~ countConceptsAndDocuments)
        .map {
          case (
                countProperties,
                countObjects,
                countEvents,
                countDocumentFacts,
                countPotentialDocuments,
                countResearchMaps,
                countTasks,
                countConcepts,
                countDocumentMentions,
                countConceptsAndDocuments
              ) =>
            ConceptStatisticsView(
              countProperties,
              countObjects,
              countEvents,
              countDocumentFacts,
              countPotentialDocuments,
              countResearchMaps,
              countTasks,
              countConcepts,
              countDocumentMentions,
              countConceptsAndDocuments
            )
        }

    def countProperties: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countProperties", Scalar())
    def countObjects: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countObjects", Scalar())
    def countEvents: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countEvents", Scalar())

    /** documents with approved concept's facts
      */
    def countDocumentFacts: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countDocumentFacts", Scalar())

    /** documents with unapproved concept's or its properties'/links' facts
      */
    def countPotentialDocuments: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countPotentialDocuments", Scalar())
    def countResearchMaps: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countResearchMaps", Scalar())
    def countTasks: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countTasks", Scalar())
    def countConcepts: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countConcepts", Scalar())
    def countDocumentMentions: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countDocumentMentions", Scalar())

    /** documents with all (approved and unapproved) facts about concept or its properties, links
      */
    def countConceptsAndDocuments: SelectionBuilder[ConceptStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countConceptsAndDocuments", Scalar())
  }

  type ConceptSubscriptions
  object ConceptSubscriptions {

    final case class ConceptSubscriptionsView[ListUserSelection](
        subscriptions: List[ConceptUpdate],
        listUser: List[ListUserSelection],
        countUsers: Int
    )

    type ViewSelection[ListUserSelection] =
      SelectionBuilder[ConceptSubscriptions, ConceptSubscriptionsView[
        ListUserSelection
      ]]

    def view[ListUserSelection](
        listUserSelection: SelectionBuilder[User, ListUserSelection]
    ): ViewSelection[ListUserSelection] =
      (subscriptions ~ listUser(listUserSelection) ~ countUsers).map {
        case (subscriptions, listUser, countUsers) =>
          ConceptSubscriptionsView(subscriptions, listUser, countUsers)
      }

    def subscriptions
        : SelectionBuilder[ConceptSubscriptions, List[ConceptUpdate]] =
      _root_.caliban.client.SelectionBuilder
        .Field("subscriptions", ListOf(Scalar()))
    def listUser[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptSubscriptions, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listUser", ListOf(Obj(innerSelection)))
    def countUsers: SelectionBuilder[ConceptSubscriptions, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countUsers", Scalar())
  }

  type ConceptType
  object ConceptType {

    final case class ConceptTypeView[
        ListWhiteRegexpSelection,
        PaginationConceptPropertyTypeSelection,
        MetricSelection,
        PaginationConceptLinkTypeSelection,
        PaginationConceptTypeViewSelection,
        ListCompositeConceptTypeSelection,
        ListConceptPropertyTypeSelection,
        ListConceptLinkTypeSelection,
        ListConceptHeaderPropertyTypeSelection,
        ImageSelection,
        ListBlackRegexpSelection,
        ListTypeSearchElementSelection,
        ListTypeBlackSearchElementSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        xCoordinate: Double,
        yCoordinate: Double,
        listWhiteDictionary: List[String],
        pretrainedNERCModels: List[String],
        listWhiteRegexp: List[ListWhiteRegexpSelection],
        isEvent: Boolean,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        listBlackDictionary: List[String],
        paginationConceptPropertyType: PaginationConceptPropertyTypeSelection,
        metric: MetricSelection,
        paginationConceptLinkType: PaginationConceptLinkTypeSelection,
        paginationConceptTypeView: PaginationConceptTypeViewSelection,
        listCompositeConceptType: List[ListCompositeConceptTypeSelection],
        listConceptPropertyType: List[ListConceptPropertyTypeSelection],
        listConceptLinkType: List[ListConceptLinkTypeSelection],
        listConceptHeaderPropertyType: List[
          ListConceptHeaderPropertyTypeSelection
        ],
        image: scala.Option[ImageSelection],
        fullDictionary: List[String],
        nonConfigurableDictionary: List[String],
        showInMenu: Boolean,
        listBlackRegexp: List[ListBlackRegexpSelection],
        listNamesDictionary: List[String],
        listTypeSearchElement: List[ListTypeSearchElementSelection],
        listTypeBlackSearchElement: List[ListTypeBlackSearchElementSelection],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        ListWhiteRegexpSelection,
        PaginationConceptPropertyTypeSelection,
        MetricSelection,
        PaginationConceptLinkTypeSelection,
        PaginationConceptTypeViewSelection,
        ListCompositeConceptTypeSelection,
        ListConceptPropertyTypeSelection,
        ListConceptLinkTypeSelection,
        ListConceptHeaderPropertyTypeSelection,
        ImageSelection,
        ListBlackRegexpSelection,
        ListTypeSearchElementSelection,
        ListTypeBlackSearchElementSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptType, ConceptTypeView[
      ListWhiteRegexpSelection,
      PaginationConceptPropertyTypeSelection,
      MetricSelection,
      PaginationConceptLinkTypeSelection,
      PaginationConceptTypeViewSelection,
      ListCompositeConceptTypeSelection,
      ListConceptPropertyTypeSelection,
      ListConceptLinkTypeSelection,
      ListConceptHeaderPropertyTypeSelection,
      ImageSelection,
      ListBlackRegexpSelection,
      ListTypeSearchElementSelection,
      ListTypeBlackSearchElementSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ListWhiteRegexpSelection,
        PaginationConceptPropertyTypeSelection,
        MetricSelection,
        PaginationConceptLinkTypeSelection,
        PaginationConceptTypeViewSelection,
        ListCompositeConceptTypeSelection,
        ListConceptPropertyTypeSelection,
        ListConceptLinkTypeSelection,
        ListConceptHeaderPropertyTypeSelection,
        ImageSelection,
        ListBlackRegexpSelection,
        ListTypeSearchElementSelection,
        ListTypeBlackSearchElementSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationConceptPropertyTypeLimit: scala.Option[Int] = None,
        paginationConceptPropertyTypeOffset: scala.Option[Int] = None,
        paginationConceptPropertyTypeFilterSettings: ConceptPropertyTypeFilterSettings,
        paginationConceptPropertyTypeSortDirection: scala.Option[
          SortDirection
        ] = None,
        paginationConceptPropertyTypeSorting: scala.Option[
          ConceptPropertyTypeSorting
        ] = None,
        paginationConceptLinkTypeLimit: scala.Option[Int] = None,
        paginationConceptLinkTypeOffset: scala.Option[Int] = None,
        paginationConceptLinkTypeFilterSettings: ConceptLinkTypeFilterSettings,
        paginationConceptLinkTypeSortDirection: scala.Option[SortDirection] =
          None,
        paginationConceptLinkTypeSorting: scala.Option[ConceptLinkTypeSorting] =
          None,
        paginationConceptTypeViewLimit: scala.Option[Int] = None,
        paginationConceptTypeViewOffset: scala.Option[Int] = None
    )(
        listWhiteRegexpSelection: SelectionBuilder[
          NERCRegexp,
          ListWhiteRegexpSelection
        ],
        paginationConceptPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyTypePagination,
          PaginationConceptPropertyTypeSelection
        ],
        metricSelection: SelectionBuilder[
          ConceptTypeStatistics,
          MetricSelection
        ],
        paginationConceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkTypePagination,
          PaginationConceptLinkTypeSelection
        ],
        paginationConceptTypeViewSelection: SelectionBuilder[
          ConceptTypeViewPagination,
          PaginationConceptTypeViewSelection
        ],
        listCompositeConceptTypeSelection: SelectionBuilder[
          CompositeConceptType,
          ListCompositeConceptTypeSelection
        ],
        listConceptPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          ListConceptPropertyTypeSelection
        ],
        listConceptLinkTypeSelection: SelectionBuilder[
          ConceptLinkType,
          ListConceptLinkTypeSelection
        ],
        listConceptHeaderPropertyTypeSelection: SelectionBuilder[
          ConceptPropertyType,
          ListConceptHeaderPropertyTypeSelection
        ],
        imageSelection: SelectionBuilder[Image, ImageSelection],
        listBlackRegexpSelection: SelectionBuilder[
          NERCRegexp,
          ListBlackRegexpSelection
        ],
        listTypeSearchElementSelectionOnDictValue: SelectionBuilder[
          DictValue,
          ListTypeSearchElementSelection
        ],
        listTypeSearchElementSelectionOnNERCRegexp: SelectionBuilder[
          NERCRegexp,
          ListTypeSearchElementSelection
        ],
        listTypeBlackSearchElementSelectionOnDictValue: SelectionBuilder[
          DictValue,
          ListTypeBlackSearchElementSelection
        ],
        listTypeBlackSearchElementSelectionOnNERCRegexp: SelectionBuilder[
          NERCRegexp,
          ListTypeBlackSearchElementSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ListWhiteRegexpSelection,
      PaginationConceptPropertyTypeSelection,
      MetricSelection,
      PaginationConceptLinkTypeSelection,
      PaginationConceptTypeViewSelection,
      ListCompositeConceptTypeSelection,
      ListConceptPropertyTypeSelection,
      ListConceptLinkTypeSelection,
      ListConceptHeaderPropertyTypeSelection,
      ImageSelection,
      ListBlackRegexpSelection,
      ListTypeSearchElementSelection,
      ListTypeBlackSearchElementSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (((id ~ name ~ xCoordinate ~ yCoordinate ~ listWhiteDictionary ~ pretrainedNERCModels ~ listWhiteRegexp(
      listWhiteRegexpSelection
    ) ~ isEvent ~ systemRegistrationDate ~ systemUpdateDate ~ listBlackDictionary ~ paginationConceptPropertyType(
      paginationConceptPropertyTypeLimit,
      paginationConceptPropertyTypeOffset,
      paginationConceptPropertyTypeFilterSettings,
      paginationConceptPropertyTypeSortDirection,
      paginationConceptPropertyTypeSorting
    )(paginationConceptPropertyTypeSelection) ~ metric(
      metricSelection
    ) ~ paginationConceptLinkType(
      paginationConceptLinkTypeLimit,
      paginationConceptLinkTypeOffset,
      paginationConceptLinkTypeFilterSettings,
      paginationConceptLinkTypeSortDirection,
      paginationConceptLinkTypeSorting
    )(paginationConceptLinkTypeSelection) ~ paginationConceptTypeView(
      paginationConceptTypeViewLimit,
      paginationConceptTypeViewOffset
    )(paginationConceptTypeViewSelection) ~ listCompositeConceptType(
      listCompositeConceptTypeSelection
    ) ~ listConceptPropertyType(
      listConceptPropertyTypeSelection
    ) ~ listConceptLinkType(
      listConceptLinkTypeSelection
    ) ~ listConceptHeaderPropertyType(
      listConceptHeaderPropertyTypeSelection
    ) ~ image(
      imageSelection
    ) ~ fullDictionary ~ nonConfigurableDictionary) ~ (showInMenu ~ listBlackRegexp(
      listBlackRegexpSelection
    ) ~ listNamesDictionary ~ listTypeSearchElement(
      listTypeSearchElementSelectionOnDictValue,
      listTypeSearchElementSelectionOnNERCRegexp
    ) ~ listTypeBlackSearchElement(
      listTypeBlackSearchElementSelectionOnDictValue,
      listTypeBlackSearchElementSelectionOnNERCRegexp
    ) ~ creator(creatorSelection) ~ lastUpdater(lastUpdaterSelection)))).map {
      case (
            (
              id,
              name,
              xCoordinate,
              yCoordinate,
              listWhiteDictionary,
              pretrainedNERCModels,
              listWhiteRegexp,
              isEvent,
              systemRegistrationDate,
              systemUpdateDate,
              listBlackDictionary,
              paginationConceptPropertyType,
              metric,
              paginationConceptLinkType,
              paginationConceptTypeView,
              listCompositeConceptType,
              listConceptPropertyType,
              listConceptLinkType,
              listConceptHeaderPropertyType,
              image,
              fullDictionary,
              nonConfigurableDictionary
            ),
            (
              showInMenu,
              listBlackRegexp,
              listNamesDictionary,
              listTypeSearchElement,
              listTypeBlackSearchElement,
              creator,
              lastUpdater
            )
          ) =>
        ConceptTypeView(
          id,
          name,
          xCoordinate,
          yCoordinate,
          listWhiteDictionary,
          pretrainedNERCModels,
          listWhiteRegexp,
          isEvent,
          systemRegistrationDate,
          systemUpdateDate,
          listBlackDictionary,
          paginationConceptPropertyType,
          metric,
          paginationConceptLinkType,
          paginationConceptTypeView,
          listCompositeConceptType,
          listConceptPropertyType,
          listConceptLinkType,
          listConceptHeaderPropertyType,
          image,
          fullDictionary,
          nonConfigurableDictionary,
          showInMenu,
          listBlackRegexp,
          listNamesDictionary,
          listTypeSearchElement,
          listTypeBlackSearchElement,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[ConceptType, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ConceptType, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def xCoordinate: SelectionBuilder[ConceptType, Double] =
      _root_.caliban.client.SelectionBuilder.Field("xCoordinate", Scalar())
    def yCoordinate: SelectionBuilder[ConceptType, Double] =
      _root_.caliban.client.SelectionBuilder.Field("yCoordinate", Scalar())
    def listWhiteDictionary: SelectionBuilder[ConceptType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listWhiteDictionary", ListOf(Scalar()))
    def pretrainedNERCModels: SelectionBuilder[ConceptType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pretrainedNERCModels", ListOf(Scalar()))
    def listWhiteRegexp[A](
        innerSelection: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listWhiteRegexp", ListOf(Obj(innerSelection)))
    def isEvent: SelectionBuilder[ConceptType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isEvent", Scalar())
    def systemRegistrationDate: SelectionBuilder[ConceptType, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptType, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def listBlackDictionary: SelectionBuilder[ConceptType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listBlackDictionary", ListOf(Scalar()))
    def paginationConceptPropertyType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptPropertyTypeFilterSettings,
        sortDirection: scala.Option[SortDirection] = None,
        sorting: scala.Option[ConceptPropertyTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[ConceptPropertyTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptPropertyTypeSorting]]
    ): SelectionBuilder[ConceptType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyTypeFilterSettings!"
          )(encoder2),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
          Argument("sorting", sorting, "ConceptPropertyTypeSorting")(encoder4)
        )
      )
    def metric[A](
        innerSelection: SelectionBuilder[ConceptTypeStatistics, A]
    ): SelectionBuilder[ConceptType, A] = _root_.caliban.client.SelectionBuilder
      .Field("metric", Obj(innerSelection))
    def paginationConceptLinkType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptLinkTypeFilterSettings,
        sortDirection: scala.Option[SortDirection] = None,
        sorting: scala.Option[ConceptLinkTypeSorting] = None
    )(innerSelection: SelectionBuilder[ConceptLinkTypePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptLinkTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptLinkTypeSorting]]
    ): SelectionBuilder[ConceptType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptLinkTypeFilterSettings!"
          )(encoder2),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
          Argument("sorting", sorting, "ConceptLinkTypeSorting")(encoder4)
        )
      )
    def paginationConceptTypeView[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptTypeViewPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[ConceptType, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptTypeView",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1)
        )
      )
    def listCompositeConceptType[A](
        innerSelection: SelectionBuilder[CompositeConceptType, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCompositeConceptType", ListOf(Obj(innerSelection)))
    def listConceptPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptPropertyType", ListOf(Obj(innerSelection)))
    def listConceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkType", ListOf(Obj(innerSelection)))
    def listConceptHeaderPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptHeaderPropertyType", ListOf(Obj(innerSelection)))
    def image[A](
        innerSelection: SelectionBuilder[Image, A]
    ): SelectionBuilder[ConceptType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("image", OptionOf(Obj(innerSelection)))
    @deprecated(
      "do not show to user, union of DB dictionary and alias dictionary",
      ""
    )
    def fullDictionary: SelectionBuilder[ConceptType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("fullDictionary", ListOf(Scalar()))
    def nonConfigurableDictionary: SelectionBuilder[ConceptType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("nonConfigurableDictionary", ListOf(Scalar()))
    def showInMenu: SelectionBuilder[ConceptType, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("showInMenu", Scalar())
    def listBlackRegexp[A](
        innerSelection: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listBlackRegexp", ListOf(Obj(innerSelection)))
    def listNamesDictionary: SelectionBuilder[ConceptType, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listNamesDictionary", ListOf(Scalar()))
    def listTypeSearchElement[A](
        onDictValue: SelectionBuilder[DictValue, A],
        onNERCRegexp: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> Obj(onDictValue),
              "NERCRegexp" -> Obj(onNERCRegexp)
            )
          )
        )
      )
    def listTypeBlackSearchElement[A](
        onDictValue: SelectionBuilder[DictValue, A],
        onNERCRegexp: SelectionBuilder[NERCRegexp, A]
    ): SelectionBuilder[ConceptType, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeBlackSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> Obj(onDictValue),
              "NERCRegexp" -> Obj(onNERCRegexp)
            )
          )
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptType, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptType, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def listTypeSearchElementOption[A](
        onDictValue: scala.Option[SelectionBuilder[DictValue, A]] = None,
        onNERCRegexp: scala.Option[SelectionBuilder[NERCRegexp, A]] = None
    ): SelectionBuilder[ConceptType, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> onDictValue.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a))),
              "NERCRegexp" -> onNERCRegexp.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a)))
            )
          )
        )
      )
    def listTypeBlackSearchElementOption[A](
        onDictValue: scala.Option[SelectionBuilder[DictValue, A]] = None,
        onNERCRegexp: scala.Option[SelectionBuilder[NERCRegexp, A]] = None
    ): SelectionBuilder[ConceptType, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTypeBlackSearchElement",
        ListOf(
          ChoiceOf(
            Map(
              "DictValue" -> onDictValue.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a))),
              "NERCRegexp" -> onNERCRegexp.fold[FieldBuilder[scala.Option[A]]](
                NullField
              )(a => OptionOf(Obj(a)))
            )
          )
        )
      )
  }

  type ConceptTypePagination
  object ConceptTypePagination {

    final case class ConceptTypePaginationView[ListConceptTypeSelection](
        listConceptType: List[ListConceptTypeSelection],
        total: Int
    )

    type ViewSelection[ListConceptTypeSelection] =
      SelectionBuilder[ConceptTypePagination, ConceptTypePaginationView[
        ListConceptTypeSelection
      ]]

    def view[ListConceptTypeSelection](
        listConceptTypeSelection: SelectionBuilder[
          ConceptType,
          ListConceptTypeSelection
        ]
    ): ViewSelection[ListConceptTypeSelection] =
      (listConceptType(listConceptTypeSelection) ~ total).map {
        case (listConceptType, total) =>
          ConceptTypePaginationView(listConceptType, total)
      }

    def listConceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptTypePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptType", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[ConceptTypePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type ConceptTypeStatistics
  object ConceptTypeStatistics {

    final case class ConceptTypeStatisticsView(
        countPropertyType: Int,
        countLinkType: Int,
        countDictionary: Int,
        countRegexp: Int
    )

    type ViewSelection =
      SelectionBuilder[ConceptTypeStatistics, ConceptTypeStatisticsView]

    def view: ViewSelection =
      (countPropertyType ~ countLinkType ~ countDictionary ~ countRegexp).map {
        case (countPropertyType, countLinkType, countDictionary, countRegexp) =>
          ConceptTypeStatisticsView(
            countPropertyType,
            countLinkType,
            countDictionary,
            countRegexp
          )
      }

    def countPropertyType: SelectionBuilder[ConceptTypeStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countPropertyType", Scalar())
    def countLinkType: SelectionBuilder[ConceptTypeStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countLinkType", Scalar())
    def countDictionary: SelectionBuilder[ConceptTypeStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDictionary", Scalar())
    def countRegexp: SelectionBuilder[ConceptTypeStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countRegexp", Scalar())
  }

  type ConceptTypeView
  object ConceptTypeView {

    final case class ConceptTypeViewView[
        ConceptTypeSelection,
        ColumnsSelection,
        PaginationConceptSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        showInMenu: Boolean,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        conceptType: ConceptTypeSelection,
        columns: List[ColumnsSelection],
        paginationConcept: PaginationConceptSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        ConceptTypeSelection,
        ColumnsSelection,
        PaginationConceptSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ConceptTypeView, ConceptTypeViewView[
      ConceptTypeSelection,
      ColumnsSelection,
      PaginationConceptSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ConceptTypeSelection,
        ColumnsSelection,
        PaginationConceptSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationConceptLimit: scala.Option[Int] = None,
        paginationConceptOffset: scala.Option[Int] = None,
        paginationConceptSortColumn: scala.Option[String] = None,
        paginationConceptSortDirection: scala.Option[SortDirection] = None,
        paginationConceptQuery: scala.Option[String] = None,
        paginationConceptFilterSettings: scala.Option[ConceptFilterSettings] =
          None
    )(
        conceptTypeSelection: SelectionBuilder[
          ConceptType,
          ConceptTypeSelection
        ],
        columnsSelection: SelectionBuilder[
          CompositeConceptTypeWidgetTypeColumn,
          ColumnsSelection
        ],
        paginationConceptSelection: SelectionBuilder[
          ConceptViewPagination,
          PaginationConceptSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ConceptTypeSelection,
      ColumnsSelection,
      PaginationConceptSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (id ~ name ~ showInMenu ~ systemRegistrationDate ~ systemUpdateDate ~ conceptType(
        conceptTypeSelection
      ) ~ columns(columnsSelection) ~ paginationConcept(
        paginationConceptLimit,
        paginationConceptOffset,
        paginationConceptSortColumn,
        paginationConceptSortDirection,
        paginationConceptQuery,
        paginationConceptFilterSettings
      )(paginationConceptSelection) ~ creator(creatorSelection) ~ lastUpdater(
        lastUpdaterSelection
      )).map {
        case (
              id,
              name,
              showInMenu,
              systemRegistrationDate,
              systemUpdateDate,
              conceptType,
              columns,
              paginationConcept,
              creator,
              lastUpdater
            ) =>
          ConceptTypeViewView(
            id,
            name,
            showInMenu,
            systemRegistrationDate,
            systemUpdateDate,
            conceptType,
            columns,
            paginationConcept,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[ConceptTypeView, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ConceptTypeView, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def showInMenu: SelectionBuilder[ConceptTypeView, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("showInMenu", Scalar())
    def systemRegistrationDate: SelectionBuilder[ConceptTypeView, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ConceptTypeView, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def conceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[ConceptTypeView, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptType", Obj(innerSelection))
    def columns[A](
        innerSelection: SelectionBuilder[
          CompositeConceptTypeWidgetTypeColumn,
          A
        ]
    ): SelectionBuilder[ConceptTypeView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("columns", ListOf(Obj(innerSelection)))
    def paginationConcept[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        sortColumn: scala.Option[String] = None,
        sortDirection: scala.Option[SortDirection] = None,
        query: scala.Option[String] = None,
        filterSettings: scala.Option[ConceptFilterSettings] = None
    )(innerSelection: SelectionBuilder[ConceptViewPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[String]],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[String]],
        encoder5: ArgEncoder[scala.Option[ConceptFilterSettings]]
    ): SelectionBuilder[ConceptTypeView, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("sortColumn", sortColumn, "ID")(encoder2),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
          Argument("query", query, "String")(encoder4),
          Argument("filterSettings", filterSettings, "ConceptFilterSettings")(
            encoder5
          )
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptTypeView, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptTypeView, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ConceptTypeViewPagination
  object ConceptTypeViewPagination {

    final case class ConceptTypeViewPaginationView[
        ListConceptTypeViewSelection
    ](listConceptTypeView: List[ListConceptTypeViewSelection], total: Int)

    type ViewSelection[ListConceptTypeViewSelection] =
      SelectionBuilder[ConceptTypeViewPagination, ConceptTypeViewPaginationView[
        ListConceptTypeViewSelection
      ]]

    def view[ListConceptTypeViewSelection](
        listConceptTypeViewSelection: SelectionBuilder[
          ConceptTypeView,
          ListConceptTypeViewSelection
        ]
    ): ViewSelection[ListConceptTypeViewSelection] =
      (listConceptTypeView(listConceptTypeViewSelection) ~ total).map {
        case (listConceptTypeView, total) =>
          ConceptTypeViewPaginationView(listConceptTypeView, total)
      }

    def listConceptTypeView[A](
        innerSelection: SelectionBuilder[ConceptTypeView, A]
    ): SelectionBuilder[ConceptTypeViewPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptTypeView", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[ConceptTypeViewPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type ConceptView
  object ConceptView {

    final case class ConceptViewView[ConceptSelection, RowsSelection](
        concept: ConceptSelection,
        rows: List[List[RowsSelection]]
    )

    type ViewSelection[ConceptSelection, RowsSelection] = SelectionBuilder[
      ConceptView,
      ConceptViewView[ConceptSelection, RowsSelection]
    ]

    def view[ConceptSelection, RowsSelection](
        conceptSelection: SelectionBuilder[Concept, ConceptSelection],
        rowsSelectionOnCompositeValue: SelectionBuilder[
          CompositeValue,
          RowsSelection
        ],
        rowsSelectionOnConcept: SelectionBuilder[Concept, RowsSelection],
        rowsSelectionOnConceptLinkType: SelectionBuilder[
          ConceptLinkType,
          RowsSelection
        ],
        rowsSelectionOnConceptType: SelectionBuilder[
          ConceptType,
          RowsSelection
        ],
        rowsSelectionOnDateTimeValue: SelectionBuilder[
          DateTimeValue,
          RowsSelection
        ],
        rowsSelectionOnDoubleValue: SelectionBuilder[
          DoubleValue,
          RowsSelection
        ],
        rowsSelectionOnGeoPointValue: SelectionBuilder[
          GeoPointValue,
          RowsSelection
        ],
        rowsSelectionOnImage: SelectionBuilder[Image, RowsSelection],
        rowsSelectionOnIntValue: SelectionBuilder[IntValue, RowsSelection],
        rowsSelectionOnLinkValue: SelectionBuilder[LinkValue, RowsSelection],
        rowsSelectionOnStringLocaleValue: SelectionBuilder[
          StringLocaleValue,
          RowsSelection
        ],
        rowsSelectionOnStringValue: SelectionBuilder[
          StringValue,
          RowsSelection
        ],
        rowsSelectionOnUser: SelectionBuilder[User, RowsSelection]
    ): ViewSelection[ConceptSelection, RowsSelection] =
      (concept(conceptSelection) ~ rows(
        rowsSelectionOnCompositeValue,
        rowsSelectionOnConcept,
        rowsSelectionOnConceptLinkType,
        rowsSelectionOnConceptType,
        rowsSelectionOnDateTimeValue,
        rowsSelectionOnDoubleValue,
        rowsSelectionOnGeoPointValue,
        rowsSelectionOnImage,
        rowsSelectionOnIntValue,
        rowsSelectionOnLinkValue,
        rowsSelectionOnStringLocaleValue,
        rowsSelectionOnStringValue,
        rowsSelectionOnUser
      )).map { case (concept, rows) => ConceptViewView(concept, rows) }

    def concept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptView, A] = _root_.caliban.client.SelectionBuilder
      .Field("concept", Obj(innerSelection))
    def rows[A](
        onCompositeValue: SelectionBuilder[CompositeValue, A],
        onConcept: SelectionBuilder[Concept, A],
        onConceptLinkType: SelectionBuilder[ConceptLinkType, A],
        onConceptType: SelectionBuilder[ConceptType, A],
        onDateTimeValue: SelectionBuilder[DateTimeValue, A],
        onDoubleValue: SelectionBuilder[DoubleValue, A],
        onGeoPointValue: SelectionBuilder[GeoPointValue, A],
        onImage: SelectionBuilder[Image, A],
        onIntValue: SelectionBuilder[IntValue, A],
        onLinkValue: SelectionBuilder[LinkValue, A],
        onStringLocaleValue: SelectionBuilder[StringLocaleValue, A],
        onStringValue: SelectionBuilder[StringValue, A],
        onUser: SelectionBuilder[User, A]
    ): SelectionBuilder[ConceptView, List[List[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "rows",
        ListOf(
          ListOf(
            ChoiceOf(
              Map(
                "CompositeValue" -> Obj(onCompositeValue),
                "Concept" -> Obj(onConcept),
                "ConceptLinkType" -> Obj(onConceptLinkType),
                "ConceptType" -> Obj(onConceptType),
                "DateTimeValue" -> Obj(onDateTimeValue),
                "DoubleValue" -> Obj(onDoubleValue),
                "GeoPointValue" -> Obj(onGeoPointValue),
                "Image" -> Obj(onImage),
                "IntValue" -> Obj(onIntValue),
                "LinkValue" -> Obj(onLinkValue),
                "StringLocaleValue" -> Obj(onStringLocaleValue),
                "StringValue" -> Obj(onStringValue),
                "User" -> Obj(onUser)
              )
            )
          )
        )
      )
    def rowsOption[A](
        onCompositeValue: scala.Option[SelectionBuilder[CompositeValue, A]] =
          None,
        onConcept: scala.Option[SelectionBuilder[Concept, A]] = None,
        onConceptLinkType: scala.Option[SelectionBuilder[ConceptLinkType, A]] =
          None,
        onConceptType: scala.Option[SelectionBuilder[ConceptType, A]] = None,
        onDateTimeValue: scala.Option[SelectionBuilder[DateTimeValue, A]] =
          None,
        onDoubleValue: scala.Option[SelectionBuilder[DoubleValue, A]] = None,
        onGeoPointValue: scala.Option[SelectionBuilder[GeoPointValue, A]] =
          None,
        onImage: scala.Option[SelectionBuilder[Image, A]] = None,
        onIntValue: scala.Option[SelectionBuilder[IntValue, A]] = None,
        onLinkValue: scala.Option[SelectionBuilder[LinkValue, A]] = None,
        onStringLocaleValue: scala.Option[
          SelectionBuilder[StringLocaleValue, A]
        ] = None,
        onStringValue: scala.Option[SelectionBuilder[StringValue, A]] = None,
        onUser: scala.Option[SelectionBuilder[User, A]] = None
    ): SelectionBuilder[ConceptView, List[List[scala.Option[A]]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "rows",
        ListOf(
          ListOf(
            ChoiceOf(
              Map(
                "CompositeValue" -> onCompositeValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "Concept" -> onConcept.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "ConceptLinkType" -> onConceptLinkType
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "ConceptType" -> onConceptType
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "DateTimeValue" -> onDateTimeValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "DoubleValue" -> onDoubleValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "GeoPointValue" -> onGeoPointValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "Image" -> onImage.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "IntValue" -> onIntValue.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "LinkValue" -> onLinkValue.fold[FieldBuilder[scala.Option[A]]](
                  NullField
                )(a => OptionOf(Obj(a))),
                "StringLocaleValue" -> onStringLocaleValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "StringValue" -> onStringValue
                  .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                    OptionOf(Obj(a))
                  ),
                "User" -> onUser.fold[FieldBuilder[scala.Option[A]]](NullField)(
                  a => OptionOf(Obj(a))
                )
              )
            )
          )
        )
      )
  }

  type ConceptViewPagination
  object ConceptViewPagination {

    final case class ConceptViewPaginationView[ListConceptViewSelection](
        total: Long,
        listConceptView: List[ListConceptViewSelection]
    )

    type ViewSelection[ListConceptViewSelection] =
      SelectionBuilder[ConceptViewPagination, ConceptViewPaginationView[
        ListConceptViewSelection
      ]]

    def view[ListConceptViewSelection](
        listConceptViewSelection: SelectionBuilder[
          ConceptView,
          ListConceptViewSelection
        ]
    ): ViewSelection[ListConceptViewSelection] =
      (total ~ listConceptView(listConceptViewSelection)).map {
        case (total, listConceptView) =>
          ConceptViewPaginationView(total, listConceptView)
      }

    def total: SelectionBuilder[ConceptViewPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listConceptView[A](
        innerSelection: SelectionBuilder[ConceptView, A]
    ): SelectionBuilder[ConceptViewPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptView", ListOf(Obj(innerSelection)))
  }

  type ConceptWithNeighbors
  object ConceptWithNeighbors {

    final case class ConceptWithNeighborsView[ConceptSelection](
        concept: ConceptSelection,
        numOfNeighbors: Int
    )

    type ViewSelection[ConceptSelection] =
      SelectionBuilder[ConceptWithNeighbors, ConceptWithNeighborsView[
        ConceptSelection
      ]]

    def view[ConceptSelection](
        conceptSelection: SelectionBuilder[Concept, ConceptSelection]
    ): ViewSelection[ConceptSelection] =
      (concept(conceptSelection) ~ numOfNeighbors).map {
        case (concept, numOfNeighbors) =>
          ConceptWithNeighborsView(concept, numOfNeighbors)
      }

    def concept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[ConceptWithNeighbors, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("concept", Obj(innerSelection))
    def numOfNeighbors: SelectionBuilder[ConceptWithNeighbors, Int] =
      _root_.caliban.client.SelectionBuilder.Field("numOfNeighbors", Scalar())
  }

  type Coordinates
  object Coordinates {

    final case class CoordinatesView(latitude: Double, longitude: Double)

    type ViewSelection = SelectionBuilder[Coordinates, CoordinatesView]

    def view: ViewSelection = (latitude ~ longitude).map {
      case (latitude, longitude) => CoordinatesView(latitude, longitude)
    }

    def latitude: SelectionBuilder[Coordinates, Double] =
      _root_.caliban.client.SelectionBuilder.Field("latitude", Scalar())
    def longitude: SelectionBuilder[Coordinates, Double] =
      _root_.caliban.client.SelectionBuilder.Field("longitude", Scalar())
  }

  type CountryPagination
  object CountryPagination {

    final case class CountryPaginationView(
        listCountry: List[String],
        total: Int
    )

    type ViewSelection =
      SelectionBuilder[CountryPagination, CountryPaginationView]

    def view: ViewSelection = (listCountry ~ total).map {
      case (listCountry, total) => CountryPaginationView(listCountry, total)
    }

    def listCountry: SelectionBuilder[CountryPagination, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCountry", ListOf(Scalar()))
    def total: SelectionBuilder[CountryPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type Date
  object Date {

    final case class DateView(
        year: scala.Option[Int],
        month: scala.Option[Int],
        day: scala.Option[Int]
    )

    type ViewSelection = SelectionBuilder[Date, DateView]

    def view: ViewSelection = (year ~ month ~ day).map {
      case (year, month, day) => DateView(year, month, day)
    }

    def year: SelectionBuilder[Date, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("year", OptionOf(Scalar()))
    def month: SelectionBuilder[Date, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("month", OptionOf(Scalar()))
    def day: SelectionBuilder[Date, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("day", OptionOf(Scalar()))
  }

  type DateTimeInterval
  object DateTimeInterval {

    final case class DateTimeIntervalView[StartSelection, EndSelection](
        start: scala.Option[StartSelection],
        end: scala.Option[EndSelection]
    )

    type ViewSelection[StartSelection, EndSelection] = SelectionBuilder[
      DateTimeInterval,
      DateTimeIntervalView[StartSelection, EndSelection]
    ]

    def view[StartSelection, EndSelection](
        startSelection: SelectionBuilder[DateTimeValue, StartSelection],
        endSelection: SelectionBuilder[DateTimeValue, EndSelection]
    ): ViewSelection[StartSelection, EndSelection] =
      (start(startSelection) ~ end(endSelection)).map { case (start, end) =>
        DateTimeIntervalView(start, end)
      }

    def start[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[DateTimeInterval, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("start", OptionOf(Obj(innerSelection)))
    def end[A](
        innerSelection: SelectionBuilder[DateTimeValue, A]
    ): SelectionBuilder[DateTimeInterval, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("end", OptionOf(Obj(innerSelection)))
  }

  type DateTimeValue
  object DateTimeValue {

    final case class DateTimeValueView[DateSelection, TimeSelection](
        date: DateSelection,
        time: scala.Option[TimeSelection]
    )

    type ViewSelection[DateSelection, TimeSelection] = SelectionBuilder[
      DateTimeValue,
      DateTimeValueView[DateSelection, TimeSelection]
    ]

    def view[DateSelection, TimeSelection](
        dateSelection: SelectionBuilder[Date, DateSelection],
        timeSelection: SelectionBuilder[Time, TimeSelection]
    ): ViewSelection[DateSelection, TimeSelection] =
      (date(dateSelection) ~ time(timeSelection)).map { case (date, time) =>
        DateTimeValueView(date, time)
      }

    def date[A](
        innerSelection: SelectionBuilder[Date, A]
    ): SelectionBuilder[DateTimeValue, A] =
      _root_.caliban.client.SelectionBuilder.Field("date", Obj(innerSelection))
    def time[A](
        innerSelection: SelectionBuilder[Time, A]
    ): SelectionBuilder[DateTimeValue, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("time", OptionOf(Obj(innerSelection)))
  }

  type DictValue
  object DictValue {

    final case class DictValueView(value: String)

    type ViewSelection = SelectionBuilder[DictValue, DictValueView]

    def view: ViewSelection = value.map(value => DictValueView(value))

    def value: SelectionBuilder[DictValue, String] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
  }

  type DocSpecificMetadata
  object DocSpecificMetadata {

    final case class DocSpecificMetadataView(
        category: scala.Option[String],
        lastPrintedDate: scala.Option[UnixTime],
        lastModifiedBy: scala.Option[String],
        createdDate: scala.Option[UnixTime],
        comments: scala.Option[String],
        author: scala.Option[String],
        documentSubject: scala.Option[String],
        keywords: scala.Option[String],
        modifiedData: scala.Option[UnixTime],
        docName: scala.Option[String]
    )

    type ViewSelection =
      SelectionBuilder[DocSpecificMetadata, DocSpecificMetadataView]

    def view: ViewSelection =
      (category ~ lastPrintedDate ~ lastModifiedBy ~ createdDate ~ comments ~ author ~ documentSubject ~ keywords ~ modifiedData ~ docName)
        .map {
          case (
                category,
                lastPrintedDate,
                lastModifiedBy,
                createdDate,
                comments,
                author,
                documentSubject,
                keywords,
                modifiedData,
                docName
              ) =>
            DocSpecificMetadataView(
              category,
              lastPrintedDate,
              lastModifiedBy,
              createdDate,
              comments,
              author,
              documentSubject,
              keywords,
              modifiedData,
              docName
            )
        }

    /** Категории
      */
    def category: SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("category", OptionOf(Scalar()))

    /** Дата последней печати
      */
    def lastPrintedDate
        : SelectionBuilder[DocSpecificMetadata, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastPrintedDate", OptionOf(Scalar()))

    /** Кем сохранен
      */
    def lastModifiedBy
        : SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastModifiedBy", OptionOf(Scalar()))

    /** Дата создания содержимого
      */
    def createdDate
        : SelectionBuilder[DocSpecificMetadata, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("createdDate", OptionOf(Scalar()))

    /** Комментарии
      */
    def comments: SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("comments", OptionOf(Scalar()))

    /** Авторы
      */
    def author: SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("author", OptionOf(Scalar()))

    /** Тема
      */
    def documentSubject
        : SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("documentSubject", OptionOf(Scalar()))

    /** Ключевые слова
      */
    def keywords: SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("keywords", OptionOf(Scalar()))

    /** Дата последнего сохранения
      */
    def modifiedData
        : SelectionBuilder[DocSpecificMetadata, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("modifiedData", OptionOf(Scalar()))

    /** Название документа
      */
    def docName: SelectionBuilder[DocSpecificMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("docName", OptionOf(Scalar()))
  }

  type Document
  object Document {

    final case class DocumentView[
        HighlightingsSelection,
        TablesSelection,
        MetadataSelection,
        ParentSelection,
        ListChildSelection,
        PaginationChildSelection,
        AvatarSelection,
        MetricSelection,
        PaginationConceptFactSelection,
        ListConceptFactSelection,
        PaginationConceptLinkFactSelection,
        ListConceptLinkDocumentFactSelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        TextSelection,
        ListSubscriptionSelection,
        PaginationSimilarDocumentsSelection,
        ListFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        title: scala.Option[String],
        externalUrl: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        publicationDate: scala.Option[UnixTime],
        publicationAuthor: scala.Option[String],
        notes: scala.Option[String],
        documentType: DocumentType,
        highlightings: List[HighlightingsSelection],
        markers: List[String],
        tables: List[TablesSelection],
        metadata: scala.Option[MetadataSelection],
        uuid: String,
        trustLevel: scala.Option[TrustLevel],
        score: scala.Option[Double],
        hasText: Boolean,
        parent: scala.Option[ParentSelection],
        listChild: List[ListChildSelection],
        paginationChild: PaginationChildSelection,
        internalUrl: scala.Option[String],
        avatar: scala.Option[AvatarSelection],
        metric: MetricSelection,
        paginationConceptFact: PaginationConceptFactSelection,
        listConceptFact: List[ListConceptFactSelection],
        paginationConceptLinkFact: PaginationConceptLinkFactSelection,
        listConceptLinkDocumentFact: List[ListConceptLinkDocumentFactSelection],
        preview: String,
        paginationRedmineIssues: PaginationRedmineIssuesSelection,
        paginationIssue: PaginationIssueSelection,
        accessLevel: AccessLevelSelection,
        text: List[TextSelection],
        story: String,
        listSubscription: ListSubscriptionSelection,
        paginationSimilarDocuments: PaginationSimilarDocumentsSelection,
        isRead: Boolean,
        listFact: List[ListFactSelection],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    final case class DocumentViewSelectionArgs[
        HighlightingsSelection,
        TablesSelection,
        MetadataSelection,
        ParentSelection,
        ListChildSelection,
        PaginationChildSelection,
        AvatarSelection,
        MetricSelection,
        PaginationConceptFactSelection,
        ListConceptFactSelection,
        PaginationConceptLinkFactSelection,
        ListConceptLinkDocumentFactSelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        TextSelection,
        ListSubscriptionSelection,
        PaginationSimilarDocumentsSelection,
        ListFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        highlightingsSelection: SelectionBuilder[
          Highlighting,
          HighlightingsSelection
        ],
        tablesSelection: SelectionBuilder[Table, TablesSelection],
        metadataSelection: SelectionBuilder[
          DocumentMetadata,
          MetadataSelection
        ],
        parentSelection: SelectionBuilder[Document, ParentSelection],
        listChildSelection: SelectionBuilder[Document, ListChildSelection],
        paginationChildSelection: SelectionBuilder[
          DocumentPagination,
          PaginationChildSelection
        ],
        avatarSelection: SelectionBuilder[Image, AvatarSelection],
        metricSelection: SelectionBuilder[Metrics, MetricSelection],
        paginationConceptFactSelection: SelectionBuilder[
          ConceptFactPagination,
          PaginationConceptFactSelection
        ],
        listConceptFactSelection: SelectionBuilder[
          ConceptFact,
          ListConceptFactSelection
        ],
        paginationConceptLinkFactSelection: SelectionBuilder[
          ConceptLinkFactPagination,
          PaginationConceptLinkFactSelection
        ],
        listConceptLinkDocumentFactSelection: SelectionBuilder[
          ConceptLinkFact,
          ListConceptLinkDocumentFactSelection
        ],
        paginationRedmineIssuesSelection: SelectionBuilder[
          RedmineIssuePagination,
          PaginationRedmineIssuesSelection
        ],
        paginationIssueSelection: SelectionBuilder[
          IssuePagination,
          PaginationIssueSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        textSelection: SelectionBuilder[FlatDocumentStructure, TextSelection],
        listSubscriptionSelection: SelectionBuilder[
          DocumentSubscriptions,
          ListSubscriptionSelection
        ],
        paginationSimilarDocumentsSelection: SelectionBuilder[
          DocumentPagination,
          PaginationSimilarDocumentsSelection
        ],
        listFactSelectionOnConceptCandidateFact: SelectionBuilder[
          ConceptCandidateFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptFact: SelectionBuilder[
          ConceptFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptLinkCandidateFact: SelectionBuilder[
          ConceptLinkCandidateFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptLinkFact: SelectionBuilder[
          ConceptLinkFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptLinkPropertyFact: SelectionBuilder[
          ConceptLinkPropertyFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptPropertyCandidateFact: SelectionBuilder[
          ConceptPropertyCandidateFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptPropertyFact: SelectionBuilder[
          ConceptPropertyFact,
          ListFactSelection
        ],
        listFactSelectionOnConceptPropertyValueCandidateFact: SelectionBuilder[
          ConceptPropertyValueCandidateFact,
          ListFactSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    )

    type ViewSelection[
        HighlightingsSelection,
        TablesSelection,
        MetadataSelection,
        ParentSelection,
        ListChildSelection,
        PaginationChildSelection,
        AvatarSelection,
        MetricSelection,
        PaginationConceptFactSelection,
        ListConceptFactSelection,
        PaginationConceptLinkFactSelection,
        ListConceptLinkDocumentFactSelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        TextSelection,
        ListSubscriptionSelection,
        PaginationSimilarDocumentsSelection,
        ListFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[Document, DocumentView[
      HighlightingsSelection,
      TablesSelection,
      MetadataSelection,
      ParentSelection,
      ListChildSelection,
      PaginationChildSelection,
      AvatarSelection,
      MetricSelection,
      PaginationConceptFactSelection,
      ListConceptFactSelection,
      PaginationConceptLinkFactSelection,
      ListConceptLinkDocumentFactSelection,
      PaginationRedmineIssuesSelection,
      PaginationIssueSelection,
      AccessLevelSelection,
      TextSelection,
      ListSubscriptionSelection,
      PaginationSimilarDocumentsSelection,
      ListFactSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        HighlightingsSelection,
        TablesSelection,
        MetadataSelection,
        ParentSelection,
        ListChildSelection,
        PaginationChildSelection,
        AvatarSelection,
        MetricSelection,
        PaginationConceptFactSelection,
        ListConceptFactSelection,
        PaginationConceptLinkFactSelection,
        ListConceptLinkDocumentFactSelection,
        PaginationRedmineIssuesSelection,
        PaginationIssueSelection,
        AccessLevelSelection,
        TextSelection,
        ListSubscriptionSelection,
        PaginationSimilarDocumentsSelection,
        ListFactSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationChildOffset: scala.Option[Int] = None,
        paginationChildLimit: scala.Option[Int] = None,
        paginationChildFilterSettings: DocumentLinkFilterSetting,
        paginationConceptFactOffset: scala.Option[Int] = None,
        paginationConceptFactLimit: scala.Option[Int] = None,
        paginationConceptLinkFactOffset: scala.Option[Int] = None,
        paginationConceptLinkFactLimit: scala.Option[Int] = None,
        paginationRedmineIssuesLimit: scala.Option[Int] = None,
        paginationRedmineIssuesOffset: scala.Option[Int] = None,
        paginationRedmineIssuesSortDirection: scala.Option[SortDirection] =
          None,
        paginationIssueOffset: scala.Option[Int] = None,
        paginationIssueLimit: scala.Option[Int] = None,
        paginationIssueFilterSettings: IssueFilterSettings,
        paginationIssueSortDirection: SortDirection,
        paginationIssueSorting: IssueSorting,
        textShowHidden: scala.Option[Boolean] = None,
        paginationSimilarDocumentsOffset: scala.Option[Int] = None,
        paginationSimilarDocumentsLimit: scala.Option[Int] = None
    )(
        selectionArgs: DocumentViewSelectionArgs[
          HighlightingsSelection,
          TablesSelection,
          MetadataSelection,
          ParentSelection,
          ListChildSelection,
          PaginationChildSelection,
          AvatarSelection,
          MetricSelection,
          PaginationConceptFactSelection,
          ListConceptFactSelection,
          PaginationConceptLinkFactSelection,
          ListConceptLinkDocumentFactSelection,
          PaginationRedmineIssuesSelection,
          PaginationIssueSelection,
          AccessLevelSelection,
          TextSelection,
          ListSubscriptionSelection,
          PaginationSimilarDocumentsSelection,
          ListFactSelection,
          CreatorSelection,
          LastUpdaterSelection
        ]
    ): ViewSelection[
      HighlightingsSelection,
      TablesSelection,
      MetadataSelection,
      ParentSelection,
      ListChildSelection,
      PaginationChildSelection,
      AvatarSelection,
      MetricSelection,
      PaginationConceptFactSelection,
      ListConceptFactSelection,
      PaginationConceptLinkFactSelection,
      ListConceptLinkDocumentFactSelection,
      PaginationRedmineIssuesSelection,
      PaginationIssueSelection,
      AccessLevelSelection,
      TextSelection,
      ListSubscriptionSelection,
      PaginationSimilarDocumentsSelection,
      ListFactSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (((id ~ title ~ externalUrl ~ systemRegistrationDate ~ systemUpdateDate ~ publicationDate ~ publicationAuthor ~ notes ~ documentType ~ highlightings(
        selectionArgs.highlightingsSelection
      ) ~ markers ~ tables(selectionArgs.tablesSelection) ~ metadata(
        selectionArgs.metadataSelection
      ) ~ uuid ~ trustLevel ~ score ~ hasText ~ parent(
        selectionArgs.parentSelection
      ) ~ listChild(selectionArgs.listChildSelection) ~ paginationChild(
        paginationChildOffset,
        paginationChildLimit,
        paginationChildFilterSettings
      )(selectionArgs.paginationChildSelection) ~ internalUrl ~ avatar(
        selectionArgs.avatarSelection
      )) ~ (metric(selectionArgs.metricSelection) ~ paginationConceptFact(
        paginationConceptFactOffset,
        paginationConceptFactLimit
      )(selectionArgs.paginationConceptFactSelection) ~ listConceptFact(
        selectionArgs.listConceptFactSelection
      ) ~ paginationConceptLinkFact(
        paginationConceptLinkFactOffset,
        paginationConceptLinkFactLimit
      )(
        selectionArgs.paginationConceptLinkFactSelection
      ) ~ listConceptLinkDocumentFact(
        selectionArgs.listConceptLinkDocumentFactSelection
      ) ~ preview ~ paginationRedmineIssues(
        paginationRedmineIssuesLimit,
        paginationRedmineIssuesOffset,
        paginationRedmineIssuesSortDirection
      )(selectionArgs.paginationRedmineIssuesSelection) ~ paginationIssue(
        paginationIssueOffset,
        paginationIssueLimit,
        paginationIssueFilterSettings,
        paginationIssueSortDirection,
        paginationIssueSorting
      )(selectionArgs.paginationIssueSelection) ~ accessLevel(
        selectionArgs.accessLevelSelection
      ) ~ text(textShowHidden)(
        selectionArgs.textSelection
      ) ~ story ~ listSubscription(
        selectionArgs.listSubscriptionSelection
      ) ~ paginationSimilarDocuments(
        paginationSimilarDocumentsOffset,
        paginationSimilarDocumentsLimit
      )(selectionArgs.paginationSimilarDocumentsSelection) ~ isRead ~ listFact(
        selectionArgs.listFactSelectionOnConceptCandidateFact,
        selectionArgs.listFactSelectionOnConceptFact,
        selectionArgs.listFactSelectionOnConceptLinkCandidateFact,
        selectionArgs.listFactSelectionOnConceptLinkFact,
        selectionArgs.listFactSelectionOnConceptLinkPropertyFact,
        selectionArgs.listFactSelectionOnConceptPropertyCandidateFact,
        selectionArgs.listFactSelectionOnConceptPropertyFact,
        selectionArgs.listFactSelectionOnConceptPropertyValueCandidateFact
      ) ~ creator(selectionArgs.creatorSelection) ~ lastUpdater(
        selectionArgs.lastUpdaterSelection
      )))).map {
        case (
              (
                id,
                title,
                externalUrl,
                systemRegistrationDate,
                systemUpdateDate,
                publicationDate,
                publicationAuthor,
                notes,
                documentType,
                highlightings,
                markers,
                tables,
                metadata,
                uuid,
                trustLevel,
                score,
                hasText,
                parent,
                listChild,
                paginationChild,
                internalUrl,
                avatar
              ),
              (
                metric,
                paginationConceptFact,
                listConceptFact,
                paginationConceptLinkFact,
                listConceptLinkDocumentFact,
                preview,
                paginationRedmineIssues,
                paginationIssue,
                accessLevel,
                text,
                story,
                listSubscription,
                paginationSimilarDocuments,
                isRead,
                listFact,
                creator,
                lastUpdater
              )
            ) =>
          DocumentView(
            id,
            title,
            externalUrl,
            systemRegistrationDate,
            systemUpdateDate,
            publicationDate,
            publicationAuthor,
            notes,
            documentType,
            highlightings,
            markers,
            tables,
            metadata,
            uuid,
            trustLevel,
            score,
            hasText,
            parent,
            listChild,
            paginationChild,
            internalUrl,
            avatar,
            metric,
            paginationConceptFact,
            listConceptFact,
            paginationConceptLinkFact,
            listConceptLinkDocumentFact,
            preview,
            paginationRedmineIssues,
            paginationIssue,
            accessLevel,
            text,
            story,
            listSubscription,
            paginationSimilarDocuments,
            isRead,
            listFact,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[Document, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def title: SelectionBuilder[Document, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("title", OptionOf(Scalar()))
    def externalUrl: SelectionBuilder[Document, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("externalUrl", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[Document, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Document, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def publicationDate: SelectionBuilder[Document, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("publicationDate", OptionOf(Scalar()))
    def publicationAuthor: SelectionBuilder[Document, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("publicationAuthor", OptionOf(Scalar()))
    def notes: SelectionBuilder[Document, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("notes", OptionOf(Scalar()))
    def documentType: SelectionBuilder[Document, DocumentType] =
      _root_.caliban.client.SelectionBuilder.Field("documentType", Scalar())

    /** list of annotated highlightings
      */
    def highlightings[A](
        innerSelection: SelectionBuilder[Highlighting, A]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("highlightings", ListOf(Obj(innerSelection)))
    def markers: SelectionBuilder[Document, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
    def tables[A](
        innerSelection: SelectionBuilder[Table, A]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("tables", ListOf(Obj(innerSelection)))
    def metadata[A](
        innerSelection: SelectionBuilder[DocumentMetadata, A]
    ): SelectionBuilder[Document, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("metadata", OptionOf(Obj(innerSelection)))
    def uuid: SelectionBuilder[Document, String] =
      _root_.caliban.client.SelectionBuilder.Field("uuid", Scalar())
    def trustLevel: SelectionBuilder[Document, scala.Option[TrustLevel]] =
      _root_.caliban.client.SelectionBuilder
        .Field("trustLevel", OptionOf(Scalar()))
    def score: SelectionBuilder[Document, scala.Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("score", OptionOf(Scalar()))
    def hasText: SelectionBuilder[Document, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("hasText", Scalar())
    def parent[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[Document, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("parent", OptionOf(Obj(innerSelection)))
    def listChild[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listChild", ListOf(Obj(innerSelection)))
    def paginationChild[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: DocumentLinkFilterSetting
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[DocumentLinkFilterSetting]
    ): SelectionBuilder[Document, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationChild",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "DocumentLinkFilterSetting!"
          )(encoder2)
        )
      )
    def internalUrl: SelectionBuilder[Document, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("internalUrl", OptionOf(Scalar()))
    def avatar[A](
        innerSelection: SelectionBuilder[Image, A]
    ): SelectionBuilder[Document, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("avatar", OptionOf(Obj(innerSelection)))
    def metric[A](
        innerSelection: SelectionBuilder[Metrics, A]
    ): SelectionBuilder[Document, A] = _root_.caliban.client.SelectionBuilder
      .Field("metric", Obj(innerSelection))
    def paginationConceptFact[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptFactPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Document, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptFact",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def listConceptFact[A](
        innerSelection: SelectionBuilder[ConceptFact, A]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptFact", ListOf(Obj(innerSelection)))
    def paginationConceptLinkFact[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptLinkFactPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Document, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkFact",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def listConceptLinkDocumentFact[A](
        innerSelection: SelectionBuilder[ConceptLinkFact, A]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkDocumentFact", ListOf(Obj(innerSelection)))
    def preview: SelectionBuilder[Document, String] =
      _root_.caliban.client.SelectionBuilder.Field("preview", Scalar())
    def paginationRedmineIssues[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        sortDirection: scala.Option[SortDirection] = None
    )(innerSelection: SelectionBuilder[RedmineIssuePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[SortDirection]]
    ): SelectionBuilder[Document, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationRedmineIssues",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder2)
        )
      )
    def paginationIssue[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: IssueFilterSettings,
        sortDirection: SortDirection,
        sorting: IssueSorting
    )(innerSelection: SelectionBuilder[IssuePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[IssueFilterSettings],
        encoder3: ArgEncoder[SortDirection],
        encoder4: ArgEncoder[IssueSorting]
    ): SelectionBuilder[Document, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationIssue",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("filterSettings", filterSettings, "IssueFilterSettings!")(
            encoder2
          ),
          Argument("sortDirection", sortDirection, "SortDirection!")(encoder3),
          Argument("sorting", sorting, "IssueSorting!")(encoder4)
        )
      )
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[Document, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
    def text[A](
        showHidden: scala.Option[Boolean] = None
    )(innerSelection: SelectionBuilder[FlatDocumentStructure, A])(implicit
        encoder0: ArgEncoder[scala.Option[Boolean]]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "text",
        ListOf(Obj(innerSelection)),
        arguments =
          List(Argument("showHidden", showHidden, "Boolean")(encoder0))
      )
    def story: SelectionBuilder[Document, String] =
      _root_.caliban.client.SelectionBuilder.Field("story", Scalar())
    def listSubscription[A](
        innerSelection: SelectionBuilder[DocumentSubscriptions, A]
    ): SelectionBuilder[Document, A] = _root_.caliban.client.SelectionBuilder
      .Field("listSubscription", Obj(innerSelection))
    def paginationSimilarDocuments[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Document, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationSimilarDocuments",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def isRead: SelectionBuilder[Document, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isRead", Scalar())
    def listFact[A](
        onConceptCandidateFact: SelectionBuilder[ConceptCandidateFact, A],
        onConceptFact: SelectionBuilder[ConceptFact, A],
        onConceptLinkCandidateFact: SelectionBuilder[
          ConceptLinkCandidateFact,
          A
        ],
        onConceptLinkFact: SelectionBuilder[ConceptLinkFact, A],
        onConceptLinkPropertyFact: SelectionBuilder[ConceptLinkPropertyFact, A],
        onConceptPropertyCandidateFact: SelectionBuilder[
          ConceptPropertyCandidateFact,
          A
        ],
        onConceptPropertyFact: SelectionBuilder[ConceptPropertyFact, A],
        onConceptPropertyValueCandidateFact: SelectionBuilder[
          ConceptPropertyValueCandidateFact,
          A
        ]
    ): SelectionBuilder[Document, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listFact",
        ListOf(
          ChoiceOf(
            Map(
              "ConceptCandidateFact" -> Obj(onConceptCandidateFact),
              "ConceptFact" -> Obj(onConceptFact),
              "ConceptLinkCandidateFact" -> Obj(onConceptLinkCandidateFact),
              "ConceptLinkFact" -> Obj(onConceptLinkFact),
              "ConceptLinkPropertyFact" -> Obj(onConceptLinkPropertyFact),
              "ConceptPropertyCandidateFact" -> Obj(
                onConceptPropertyCandidateFact
              ),
              "ConceptPropertyFact" -> Obj(onConceptPropertyFact),
              "ConceptPropertyValueCandidateFact" -> Obj(
                onConceptPropertyValueCandidateFact
              )
            )
          )
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Document, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Document, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def listFactOption[A](
        onConceptCandidateFact: scala.Option[
          SelectionBuilder[ConceptCandidateFact, A]
        ] = None,
        onConceptFact: scala.Option[SelectionBuilder[ConceptFact, A]] = None,
        onConceptLinkCandidateFact: scala.Option[
          SelectionBuilder[ConceptLinkCandidateFact, A]
        ] = None,
        onConceptLinkFact: scala.Option[SelectionBuilder[ConceptLinkFact, A]] =
          None,
        onConceptLinkPropertyFact: scala.Option[
          SelectionBuilder[ConceptLinkPropertyFact, A]
        ] = None,
        onConceptPropertyCandidateFact: scala.Option[
          SelectionBuilder[ConceptPropertyCandidateFact, A]
        ] = None,
        onConceptPropertyFact: scala.Option[
          SelectionBuilder[ConceptPropertyFact, A]
        ] = None,
        onConceptPropertyValueCandidateFact: scala.Option[
          SelectionBuilder[ConceptPropertyValueCandidateFact, A]
        ] = None
    ): SelectionBuilder[Document, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listFact",
        ListOf(
          ChoiceOf(
            Map(
              "ConceptCandidateFact" -> onConceptCandidateFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptFact" -> onConceptFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptLinkCandidateFact" -> onConceptLinkCandidateFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptLinkFact" -> onConceptLinkFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptLinkPropertyFact" -> onConceptLinkPropertyFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptPropertyCandidateFact" -> onConceptPropertyCandidateFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptPropertyFact" -> onConceptPropertyFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                ),
              "ConceptPropertyValueCandidateFact" -> onConceptPropertyValueCandidateFact
                .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                  OptionOf(Obj(a))
                )
            )
          )
        )
      )
  }

  type DocumentCardView
  object DocumentCardView {

    final case class DocumentCardViewView[ColumnsSelection, MetricsSelection](
        columns: List[ColumnsSelection],
        metrics: List[MetricsSelection]
    )

    type ViewSelection[ColumnsSelection, MetricsSelection] = SelectionBuilder[
      DocumentCardView,
      DocumentCardViewView[ColumnsSelection, MetricsSelection]
    ]

    def view[ColumnsSelection, MetricsSelection](
        columnsSelection: SelectionBuilder[
          DocumentCardViewColumn,
          ColumnsSelection
        ],
        metricsSelection: SelectionBuilder[DocumentViewMetric, MetricsSelection]
    ): ViewSelection[ColumnsSelection, MetricsSelection] =
      (columns(columnsSelection) ~ metrics(metricsSelection)).map {
        case (columns, metrics) => DocumentCardViewView(columns, metrics)
      }

    def columns[A](
        innerSelection: SelectionBuilder[DocumentCardViewColumn, A]
    ): SelectionBuilder[DocumentCardView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("columns", ListOf(Obj(innerSelection)))
    def metrics[A](
        innerSelection: SelectionBuilder[DocumentViewMetric, A]
    ): SelectionBuilder[DocumentCardView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("metrics", ListOf(Obj(innerSelection)))
  }

  type DocumentCardViewColumn
  object DocumentCardViewColumn {

    final case class DocumentCardViewColumnView(
        columnType: DocumentViewColumnType
    )

    type ViewSelection =
      SelectionBuilder[DocumentCardViewColumn, DocumentCardViewColumnView]

    def view: ViewSelection =
      columnType.map(columnType => DocumentCardViewColumnView(columnType))

    def columnType
        : SelectionBuilder[DocumentCardViewColumn, DocumentViewColumnType] =
      _root_.caliban.client.SelectionBuilder.Field("columnType", Scalar())
  }

  type DocumentFeed
  object DocumentFeed {

    final case class DocumentFeedView[
        PaginationDocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        searchString: String,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        paginationDocument: PaginationDocumentSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        PaginationDocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[DocumentFeed, DocumentFeedView[
      PaginationDocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        PaginationDocumentSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        paginationDocumentMode: scala.Option[DocumentFeedMode] = None,
        paginationDocumentLimit: scala.Option[Int] = None,
        paginationDocumentOffset: scala.Option[Int] = None,
        paginationDocumentQuery: scala.Option[String] = None,
        paginationDocumentFilterSettings: scala.Option[DocumentFilterSettings] =
          None,
        paginationDocumentDirection: scala.Option[SortDirection] = None,
        paginationDocumentSortField: scala.Option[DocumentSorting] = None,
        paginationDocumentExtraSettings: ExtraSettings
    )(
        paginationDocumentSelection: SelectionBuilder[
          DocumentFromDocumentFeedPagination,
          PaginationDocumentSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      PaginationDocumentSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (id ~ name ~ searchString ~ systemRegistrationDate ~ systemUpdateDate ~ paginationDocument(
        paginationDocumentMode,
        paginationDocumentLimit,
        paginationDocumentOffset,
        paginationDocumentQuery,
        paginationDocumentFilterSettings,
        paginationDocumentDirection,
        paginationDocumentSortField,
        paginationDocumentExtraSettings
      )(paginationDocumentSelection) ~ creator(creatorSelection) ~ lastUpdater(
        lastUpdaterSelection
      )).map {
        case (
              id,
              name,
              searchString,
              systemRegistrationDate,
              systemUpdateDate,
              paginationDocument,
              creator,
              lastUpdater
            ) =>
          DocumentFeedView(
            id,
            name,
            searchString,
            systemRegistrationDate,
            systemUpdateDate,
            paginationDocument,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[DocumentFeed, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[DocumentFeed, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def searchString: SelectionBuilder[DocumentFeed, String] =
      _root_.caliban.client.SelectionBuilder.Field("searchString", Scalar())
    def systemRegistrationDate: SelectionBuilder[DocumentFeed, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[DocumentFeed, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def paginationDocument[A](
        mode: scala.Option[DocumentFeedMode] = None,
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        query: scala.Option[String] = None,
        filterSettings: scala.Option[DocumentFilterSettings] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[DocumentSorting] = None,
        extraSettings: ExtraSettings
    )(
        innerSelection: SelectionBuilder[DocumentFromDocumentFeedPagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[DocumentFeedMode]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[String]],
        encoder4: ArgEncoder[scala.Option[DocumentFilterSettings]],
        encoder5: ArgEncoder[scala.Option[SortDirection]],
        encoder6: ArgEncoder[scala.Option[DocumentSorting]],
        encoder7: ArgEncoder[ExtraSettings]
    ): SelectionBuilder[DocumentFeed, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationDocument",
        Obj(innerSelection),
        arguments = List(
          Argument("mode", mode, "DocumentFeedMode")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("query", query, "String")(encoder3),
          Argument("filterSettings", filterSettings, "DocumentFilterSettings")(
            encoder4
          ),
          Argument("direction", direction, "SortDirection")(encoder5),
          Argument("sortField", sortField, "DocumentSorting")(encoder6),
          Argument("extraSettings", extraSettings, "ExtraSettings!")(encoder7)
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[DocumentFeed, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[DocumentFeed, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type DocumentFeedPagination
  object DocumentFeedPagination {

    final case class DocumentFeedPaginationView[ListDocumentFeedSelection](
        listDocumentFeed: List[ListDocumentFeedSelection],
        total: Int
    )

    type ViewSelection[ListDocumentFeedSelection] =
      SelectionBuilder[DocumentFeedPagination, DocumentFeedPaginationView[
        ListDocumentFeedSelection
      ]]

    def view[ListDocumentFeedSelection](
        listDocumentFeedSelection: SelectionBuilder[
          DocumentFeed,
          ListDocumentFeedSelection
        ]
    ): ViewSelection[ListDocumentFeedSelection] =
      (listDocumentFeed(listDocumentFeedSelection) ~ total).map {
        case (listDocumentFeed, total) =>
          DocumentFeedPaginationView(listDocumentFeed, total)
      }

    def listDocumentFeed[A](
        innerSelection: SelectionBuilder[DocumentFeed, A]
    ): SelectionBuilder[DocumentFeedPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listDocumentFeed", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[DocumentFeedPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type DocumentFromDocumentFeed
  object DocumentFromDocumentFeed {

    final case class DocumentFromDocumentFeedView[DocumentSelection](
        document: DocumentSelection,
        isFromFavorites: Boolean,
        isFromDeleted: Boolean
    )

    type ViewSelection[DocumentSelection] =
      SelectionBuilder[DocumentFromDocumentFeed, DocumentFromDocumentFeedView[
        DocumentSelection
      ]]

    def view[DocumentSelection](
        documentSelection: SelectionBuilder[Document, DocumentSelection]
    ): ViewSelection[DocumentSelection] =
      (document(documentSelection) ~ isFromFavorites ~ isFromDeleted).map {
        case (document, isFromFavorites, isFromDeleted) =>
          DocumentFromDocumentFeedView(document, isFromFavorites, isFromDeleted)
      }

    def document[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[DocumentFromDocumentFeed, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("document", Obj(innerSelection))
    def isFromFavorites: SelectionBuilder[DocumentFromDocumentFeed, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isFromFavorites", Scalar())
    def isFromDeleted: SelectionBuilder[DocumentFromDocumentFeed, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isFromDeleted", Scalar())
  }

  type DocumentFromDocumentFeedPagination
  object DocumentFromDocumentFeedPagination {

    final case class DocumentFromDocumentFeedPaginationView[
        ListDocumentSelection
    ](listDocument: List[ListDocumentSelection], total: Int, showTotal: Int)

    type ViewSelection[ListDocumentSelection] = SelectionBuilder[
      DocumentFromDocumentFeedPagination,
      DocumentFromDocumentFeedPaginationView[ListDocumentSelection]
    ]

    def view[ListDocumentSelection](
        listDocumentSelection: SelectionBuilder[
          DocumentFromDocumentFeed,
          ListDocumentSelection
        ]
    ): ViewSelection[ListDocumentSelection] =
      (listDocument(listDocumentSelection) ~ total ~ showTotal).map {
        case (listDocument, total, showTotal) =>
          DocumentFromDocumentFeedPaginationView(listDocument, total, showTotal)
      }

    def listDocument[A](
        innerSelection: SelectionBuilder[DocumentFromDocumentFeed, A]
    ): SelectionBuilder[DocumentFromDocumentFeedPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listDocument", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[DocumentFromDocumentFeedPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def showTotal: SelectionBuilder[DocumentFromDocumentFeedPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("showTotal", Scalar())
  }

  type DocumentLink
  object DocumentLink {

    final case class DocumentLinkView(parentId: String, childId: String)

    type ViewSelection = SelectionBuilder[DocumentLink, DocumentLinkView]

    def view: ViewSelection = (parentId ~ childId).map {
      case (parentId, childId) => DocumentLinkView(parentId, childId)
    }

    def parentId: SelectionBuilder[DocumentLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("parentId", Scalar())
    def childId: SelectionBuilder[DocumentLink, String] =
      _root_.caliban.client.SelectionBuilder.Field("childId", Scalar())
  }

  type DocumentMetadata
  object DocumentMetadata {

    final case class DocumentMetadataView[
        DocSpecificMetadataSelection,
        PdfSpecificMetadataSelection,
        ImageSpecificMetadataSelection,
        LanguageSelection,
        PlatformSelection,
        AccountSelection
    ](
        fileName: String,
        size: Long,
        fileType: scala.Option[String],
        modifiedTime: UnixTime,
        createdTime: UnixTime,
        accessTime: UnixTime,
        docSpecificMetadata: scala.Option[DocSpecificMetadataSelection],
        pdfSpecificMetadata: scala.Option[PdfSpecificMetadataSelection],
        imageSpecificMetadata: scala.Option[ImageSpecificMetadataSelection],
        source: scala.Option[String],
        language: scala.Option[LanguageSelection],
        jobId: scala.Option[String],
        periodicJobId: scala.Option[String],
        taskId: scala.Option[String],
        periodicTaskId: scala.Option[String],
        platform: scala.Option[PlatformSelection],
        account: List[AccountSelection]
    )

    type ViewSelection[
        DocSpecificMetadataSelection,
        PdfSpecificMetadataSelection,
        ImageSpecificMetadataSelection,
        LanguageSelection,
        PlatformSelection,
        AccountSelection
    ] = SelectionBuilder[DocumentMetadata, DocumentMetadataView[
      DocSpecificMetadataSelection,
      PdfSpecificMetadataSelection,
      ImageSpecificMetadataSelection,
      LanguageSelection,
      PlatformSelection,
      AccountSelection
    ]]

    def view[
        DocSpecificMetadataSelection,
        PdfSpecificMetadataSelection,
        ImageSpecificMetadataSelection,
        LanguageSelection,
        PlatformSelection,
        AccountSelection
    ](
        docSpecificMetadataSelection: SelectionBuilder[
          DocSpecificMetadata,
          DocSpecificMetadataSelection
        ],
        pdfSpecificMetadataSelection: SelectionBuilder[
          PdfSpecificMetadataGQL,
          PdfSpecificMetadataSelection
        ],
        imageSpecificMetadataSelection: SelectionBuilder[
          ImageSpecificMetadataGQL,
          ImageSpecificMetadataSelection
        ],
        languageSelection: SelectionBuilder[Language, LanguageSelection],
        platformSelection: SelectionBuilder[Platform, PlatformSelection],
        accountSelection: SelectionBuilder[Account, AccountSelection]
    ): ViewSelection[
      DocSpecificMetadataSelection,
      PdfSpecificMetadataSelection,
      ImageSpecificMetadataSelection,
      LanguageSelection,
      PlatformSelection,
      AccountSelection
    ] =
      (fileName ~ size ~ fileType ~ modifiedTime ~ createdTime ~ accessTime ~ docSpecificMetadata(
        docSpecificMetadataSelection
      ) ~ pdfSpecificMetadata(
        pdfSpecificMetadataSelection
      ) ~ imageSpecificMetadata(
        imageSpecificMetadataSelection
      ) ~ source ~ language(
        languageSelection
      ) ~ jobId ~ periodicJobId ~ taskId ~ periodicTaskId ~ platform(
        platformSelection
      ) ~ account(accountSelection)).map {
        case (
              fileName,
              size,
              fileType,
              modifiedTime,
              createdTime,
              accessTime,
              docSpecificMetadata,
              pdfSpecificMetadata,
              imageSpecificMetadata,
              source,
              language,
              jobId,
              periodicJobId,
              taskId,
              periodicTaskId,
              platform,
              account
            ) =>
          DocumentMetadataView(
            fileName,
            size,
            fileType,
            modifiedTime,
            createdTime,
            accessTime,
            docSpecificMetadata,
            pdfSpecificMetadata,
            imageSpecificMetadata,
            source,
            language,
            jobId,
            periodicJobId,
            taskId,
            periodicTaskId,
            platform,
            account
          )
      }

    /** Название файла
      */
    def fileName: SelectionBuilder[DocumentMetadata, String] =
      _root_.caliban.client.SelectionBuilder.Field("fileName", Scalar())

    /** Размер файла
      */
    def size: SelectionBuilder[DocumentMetadata, Long] =
      _root_.caliban.client.SelectionBuilder.Field("size", Scalar())

    /** Формат файла
      */
    def fileType: SelectionBuilder[DocumentMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("fileType", OptionOf(Scalar()))

    /** Дата изменения
      */
    def modifiedTime: SelectionBuilder[DocumentMetadata, UnixTime] =
      _root_.caliban.client.SelectionBuilder.Field("modifiedTime", Scalar())

    /** Дата создания
      */
    def createdTime: SelectionBuilder[DocumentMetadata, UnixTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdTime", Scalar())

    /** Дата последнего просмотра
      */
    def accessTime: SelectionBuilder[DocumentMetadata, UnixTime] =
      _root_.caliban.client.SelectionBuilder.Field("accessTime", Scalar())

    /** Подробные свойства файла (для doc, docx)
      */
    def docSpecificMetadata[A](
        innerSelection: SelectionBuilder[DocSpecificMetadata, A]
    ): SelectionBuilder[DocumentMetadata, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("docSpecificMetadata", OptionOf(Obj(innerSelection)))

    /** Подробные свойства файла (для pdf)
      */
    def pdfSpecificMetadata[A](
        innerSelection: SelectionBuilder[PdfSpecificMetadataGQL, A]
    ): SelectionBuilder[DocumentMetadata, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pdfSpecificMetadata", OptionOf(Obj(innerSelection)))

    /** Подробные свойства файла (для картинок)
      */
    def imageSpecificMetadata[A](
        innerSelection: SelectionBuilder[ImageSpecificMetadataGQL, A]
    ): SelectionBuilder[DocumentMetadata, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("imageSpecificMetadata", OptionOf(Obj(innerSelection)))

    /** Источник документа
      */
    def source: SelectionBuilder[DocumentMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("source", OptionOf(Scalar()))

    /** Язык документа
      */
    def language[A](
        innerSelection: SelectionBuilder[Language, A]
    ): SelectionBuilder[DocumentMetadata, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("language", OptionOf(Obj(innerSelection)))

    /** Идентификатор запуска сбора
      */
    def jobId: SelectionBuilder[DocumentMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("jobId", OptionOf(Scalar()))

    /** Идентификатор периодического запуска сбора
      */
    def periodicJobId
        : SelectionBuilder[DocumentMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("periodicJobId", OptionOf(Scalar()))

    /** Идентификатор задачи импорта
      */
    def taskId: SelectionBuilder[DocumentMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("taskId", OptionOf(Scalar()))

    /** Идентификатор периодической задачи импорта
      */
    def periodicTaskId
        : SelectionBuilder[DocumentMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("periodicTaskId", OptionOf(Scalar()))
    def platform[A](
        innerSelection: SelectionBuilder[Platform, A]
    ): SelectionBuilder[DocumentMetadata, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("platform", OptionOf(Obj(innerSelection)))
    def account[A](
        innerSelection: SelectionBuilder[Account, A]
    ): SelectionBuilder[DocumentMetadata, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("account", ListOf(Obj(innerSelection)))
  }

  type DocumentPagination
  object DocumentPagination {

    final case class DocumentPaginationView[ListDocumentSelection](
        listDocument: List[ListDocumentSelection],
        total: Int
    )

    type ViewSelection[ListDocumentSelection] =
      SelectionBuilder[DocumentPagination, DocumentPaginationView[
        ListDocumentSelection
      ]]

    def view[ListDocumentSelection](
        listDocumentSelection: SelectionBuilder[Document, ListDocumentSelection]
    ): ViewSelection[ListDocumentSelection] =
      (listDocument(listDocumentSelection) ~ total).map {
        case (listDocument, total) =>
          DocumentPaginationView(listDocument, total)
      }

    def listDocument[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[DocumentPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listDocument", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[DocumentPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type DocumentRegistryView
  object DocumentRegistryView {

    final case class DocumentRegistryViewView[
        ColumnsSelection,
        MetricsSelection,
        SortingSelection
    ](
        columns: List[ColumnsSelection],
        metrics: List[MetricsSelection],
        sorting: scala.Option[SortingSelection]
    )

    type ViewSelection[ColumnsSelection, MetricsSelection, SortingSelection] =
      SelectionBuilder[DocumentRegistryView, DocumentRegistryViewView[
        ColumnsSelection,
        MetricsSelection,
        SortingSelection
      ]]

    def view[ColumnsSelection, MetricsSelection, SortingSelection](
        columnsSelection: SelectionBuilder[
          DocumentRegistryViewColumn,
          ColumnsSelection
        ],
        metricsSelection: SelectionBuilder[
          DocumentViewMetric,
          MetricsSelection
        ],
        sortingSelection: SelectionBuilder[
          DocumentRegistryViewSorting,
          SortingSelection
        ]
    ): ViewSelection[ColumnsSelection, MetricsSelection, SortingSelection] =
      (columns(columnsSelection) ~ metrics(metricsSelection) ~ sorting(
        sortingSelection
      )).map { case (columns, metrics, sorting) =>
        DocumentRegistryViewView(columns, metrics, sorting)
      }

    def columns[A](
        innerSelection: SelectionBuilder[DocumentRegistryViewColumn, A]
    ): SelectionBuilder[DocumentRegistryView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("columns", ListOf(Obj(innerSelection)))
    def metrics[A](
        innerSelection: SelectionBuilder[DocumentViewMetric, A]
    ): SelectionBuilder[DocumentRegistryView, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("metrics", ListOf(Obj(innerSelection)))
    def sorting[A](
        innerSelection: SelectionBuilder[DocumentRegistryViewSorting, A]
    ): SelectionBuilder[DocumentRegistryView, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("sorting", OptionOf(Obj(innerSelection)))
  }

  type DocumentRegistryViewColumn
  object DocumentRegistryViewColumn {

    final case class DocumentRegistryViewColumnView(
        columnType: DocumentViewColumnType
    )

    type ViewSelection = SelectionBuilder[
      DocumentRegistryViewColumn,
      DocumentRegistryViewColumnView
    ]

    def view: ViewSelection =
      columnType.map(columnType => DocumentRegistryViewColumnView(columnType))

    def columnType
        : SelectionBuilder[DocumentRegistryViewColumn, DocumentViewColumnType] =
      _root_.caliban.client.SelectionBuilder.Field("columnType", Scalar())
  }

  type DocumentRegistryViewSorting
  object DocumentRegistryViewSorting {

    final case class DocumentRegistryViewSortingView(
        sortingType: DocumentSorting,
        sortDirection: SortDirection
    )

    type ViewSelection = SelectionBuilder[
      DocumentRegistryViewSorting,
      DocumentRegistryViewSortingView
    ]

    def view: ViewSelection = (sortingType ~ sortDirection).map {
      case (sortingType, sortDirection) =>
        DocumentRegistryViewSortingView(sortingType, sortDirection)
    }

    def sortingType
        : SelectionBuilder[DocumentRegistryViewSorting, DocumentSorting] =
      _root_.caliban.client.SelectionBuilder.Field("sortingType", Scalar())
    def sortDirection
        : SelectionBuilder[DocumentRegistryViewSorting, SortDirection] =
      _root_.caliban.client.SelectionBuilder.Field("sortDirection", Scalar())
  }

  type DocumentSubscriptions
  object DocumentSubscriptions {

    final case class DocumentSubscriptionsView[ListUserSelection](
        subscriptions: List[DocumentUpdate],
        listUser: List[ListUserSelection],
        countUsers: Int
    )

    type ViewSelection[ListUserSelection] =
      SelectionBuilder[DocumentSubscriptions, DocumentSubscriptionsView[
        ListUserSelection
      ]]

    def view[ListUserSelection](
        listUserSelection: SelectionBuilder[User, ListUserSelection]
    ): ViewSelection[ListUserSelection] =
      (subscriptions ~ listUser(listUserSelection) ~ countUsers).map {
        case (subscriptions, listUser, countUsers) =>
          DocumentSubscriptionsView(subscriptions, listUser, countUsers)
      }

    def subscriptions
        : SelectionBuilder[DocumentSubscriptions, List[DocumentUpdate]] =
      _root_.caliban.client.SelectionBuilder
        .Field("subscriptions", ListOf(Scalar()))
    def listUser[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[DocumentSubscriptions, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listUser", ListOf(Obj(innerSelection)))
    def countUsers: SelectionBuilder[DocumentSubscriptions, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countUsers", Scalar())
  }

  type DocumentViewMetric
  object DocumentViewMetric {

    final case class DocumentViewMetricView(metricType: DocumentViewMetricType)

    type ViewSelection =
      SelectionBuilder[DocumentViewMetric, DocumentViewMetricView]

    def view: ViewSelection =
      metricType.map(metricType => DocumentViewMetricView(metricType))

    def metricType
        : SelectionBuilder[DocumentViewMetric, DocumentViewMetricType] =
      _root_.caliban.client.SelectionBuilder.Field("metricType", Scalar())
  }

  type DomainMap
  object DomainMap {

    final case class DomainMapView[ListNodeSelection, ListEdgeSelection](
        listNode: List[ListNodeSelection],
        listEdge: List[ListEdgeSelection]
    )

    type ViewSelection[ListNodeSelection, ListEdgeSelection] = SelectionBuilder[
      DomainMap,
      DomainMapView[ListNodeSelection, ListEdgeSelection]
    ]

    def view[ListNodeSelection, ListEdgeSelection](
        listNodeSelection: SelectionBuilder[MapNode, ListNodeSelection],
        listEdgeSelection: SelectionBuilder[MapEdge, ListEdgeSelection]
    ): ViewSelection[ListNodeSelection, ListEdgeSelection] =
      (listNode(listNodeSelection) ~ listEdge(listEdgeSelection)).map {
        case (listNode, listEdge) => DomainMapView(listNode, listEdge)
      }

    def listNode[A](
        innerSelection: SelectionBuilder[MapNode, A]
    ): SelectionBuilder[DomainMap, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listNode", ListOf(Obj(innerSelection)))
    def listEdge[A](
        innerSelection: SelectionBuilder[MapEdge, A]
    ): SelectionBuilder[DomainMap, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listEdge", ListOf(Obj(innerSelection)))
  }

  type DoubleValue
  object DoubleValue {

    final case class DoubleValueView(value: Double)

    type ViewSelection = SelectionBuilder[DoubleValue, DoubleValueView]

    def view: ViewSelection = value.map(value => DoubleValueView(value))

    def value: SelectionBuilder[DoubleValue, Double] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
  }

  type Facet
  object Facet {

    final case class FacetView(value: String, count: Long)

    type ViewSelection = SelectionBuilder[Facet, FacetView]

    def view: ViewSelection = (value ~ count).map { case (value, count) =>
      FacetView(value, count)
    }

    def value: SelectionBuilder[Facet, String] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
    def count: SelectionBuilder[Facet, Long] =
      _root_.caliban.client.SelectionBuilder.Field("count", Scalar())
  }

  type FlatDocumentStructure
  object FlatDocumentStructure {

    final case class FlatDocumentStructureView[
        AnnotationsSelection,
        MetadataSelection,
        LanguageSelection
    ](
        text: String,
        annotations: List[AnnotationsSelection],
        metadata: MetadataSelection,
        documentId: scala.Option[String],
        nodeId: String,
        hierarchyLevel: Int,
        translatedText: String,
        id: String,
        language: scala.Option[LanguageSelection]
    )

    type ViewSelection[
        AnnotationsSelection,
        MetadataSelection,
        LanguageSelection
    ] = SelectionBuilder[FlatDocumentStructure, FlatDocumentStructureView[
      AnnotationsSelection,
      MetadataSelection,
      LanguageSelection
    ]]

    def view[AnnotationsSelection, MetadataSelection, LanguageSelection](
        annotationsSelection: SelectionBuilder[
          Annotation,
          AnnotationsSelection
        ],
        metadataSelection: SelectionBuilder[
          ParagraphMetadata,
          MetadataSelection
        ],
        languageSelection: SelectionBuilder[Language, LanguageSelection]
    ): ViewSelection[
      AnnotationsSelection,
      MetadataSelection,
      LanguageSelection
    ] = (text ~ annotations(annotationsSelection) ~ metadata(
      metadataSelection
    ) ~ documentId ~ nodeId ~ hierarchyLevel ~ translatedText ~ id ~ language(
      languageSelection
    )).map {
      case (
            text,
            annotations,
            metadata,
            documentId,
            nodeId,
            hierarchyLevel,
            translatedText,
            id,
            language
          ) =>
        FlatDocumentStructureView(
          text,
          annotations,
          metadata,
          documentId,
          nodeId,
          hierarchyLevel,
          translatedText,
          id,
          language
        )
    }

    def text: SelectionBuilder[FlatDocumentStructure, String] =
      _root_.caliban.client.SelectionBuilder.Field("text", Scalar())
    def annotations[A](
        innerSelection: SelectionBuilder[Annotation, A]
    ): SelectionBuilder[FlatDocumentStructure, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("annotations", ListOf(Obj(innerSelection)))
    def metadata[A](
        innerSelection: SelectionBuilder[ParagraphMetadata, A]
    ): SelectionBuilder[FlatDocumentStructure, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("metadata", Obj(innerSelection))
    def documentId
        : SelectionBuilder[FlatDocumentStructure, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("documentId", OptionOf(Scalar()))
    def nodeId: SelectionBuilder[FlatDocumentStructure, String] =
      _root_.caliban.client.SelectionBuilder.Field("nodeId", Scalar())
    def hierarchyLevel: SelectionBuilder[FlatDocumentStructure, Int] =
      _root_.caliban.client.SelectionBuilder.Field("hierarchyLevel", Scalar())
    def translatedText: SelectionBuilder[FlatDocumentStructure, String] =
      _root_.caliban.client.SelectionBuilder.Field("translatedText", Scalar())
    def id: SelectionBuilder[FlatDocumentStructure, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def language[A](
        innerSelection: SelectionBuilder[Language, A]
    ): SelectionBuilder[FlatDocumentStructure, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("language", OptionOf(Obj(innerSelection)))
  }

  type GeoPointValue
  object GeoPointValue {

    final case class GeoPointValueView[PointSelection](
        point: scala.Option[PointSelection],
        name: scala.Option[String]
    )

    type ViewSelection[PointSelection] =
      SelectionBuilder[GeoPointValue, GeoPointValueView[PointSelection]]

    def view[PointSelection](
        pointSelection: SelectionBuilder[Coordinates, PointSelection]
    ): ViewSelection[PointSelection] = (point(pointSelection) ~ name).map {
      case (point, name) => GeoPointValueView(point, name)
    }

    def point[A](
        innerSelection: SelectionBuilder[Coordinates, A]
    ): SelectionBuilder[GeoPointValue, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("point", OptionOf(Obj(innerSelection)))
    def name: SelectionBuilder[GeoPointValue, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
  }

  type Group
  object Group {

    final case class GroupView(
        id: String,
        name: String,
        xCoordinate: Double,
        yCoordinate: Double,
        collapsed: Boolean,
        layout: scala.Option[String]
    )

    type ViewSelection = SelectionBuilder[Group, GroupView]

    def view: ViewSelection =
      (id ~ name ~ xCoordinate ~ yCoordinate ~ collapsed ~ layout).map {
        case (id, name, xCoordinate, yCoordinate, collapsed, layout) =>
          GroupView(id, name, xCoordinate, yCoordinate, collapsed, layout)
      }

    def id: SelectionBuilder[Group, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[Group, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def xCoordinate: SelectionBuilder[Group, Double] =
      _root_.caliban.client.SelectionBuilder.Field("xCoordinate", Scalar())
    def yCoordinate: SelectionBuilder[Group, Double] =
      _root_.caliban.client.SelectionBuilder.Field("yCoordinate", Scalar())
    def collapsed: SelectionBuilder[Group, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("collapsed", Scalar())
    def layout: SelectionBuilder[Group, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("layout", OptionOf(Scalar()))
  }

  type Highlighting
  object Highlighting {

    final case class HighlightingView[AnnotationsSelection](
        highlighting: String,
        annotations: List[AnnotationsSelection]
    )

    type ViewSelection[AnnotationsSelection] =
      SelectionBuilder[Highlighting, HighlightingView[AnnotationsSelection]]

    def view[AnnotationsSelection](
        annotationsSelection: SelectionBuilder[
          HLAnnotation,
          AnnotationsSelection
        ]
    ): ViewSelection[AnnotationsSelection] =
      (highlighting ~ annotations(annotationsSelection)).map {
        case (highlighting, annotations) =>
          HighlightingView(highlighting, annotations)
      }

    def highlighting: SelectionBuilder[Highlighting, String] =
      _root_.caliban.client.SelectionBuilder.Field("highlighting", Scalar())
    def annotations[A](
        innerSelection: SelectionBuilder[HLAnnotation, A]
    ): SelectionBuilder[Highlighting, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("annotations", ListOf(Obj(innerSelection)))
  }

  type HLAnnotation
  object HLAnnotation {

    final case class HLAnnotationView(start: Int, end: Int)

    type ViewSelection = SelectionBuilder[HLAnnotation, HLAnnotationView]

    def view: ViewSelection = (start ~ end).map { case (start, end) =>
      HLAnnotationView(start, end)
    }

    def start: SelectionBuilder[HLAnnotation, Int] =
      _root_.caliban.client.SelectionBuilder.Field("start", Scalar())
    def end: SelectionBuilder[HLAnnotation, Int] =
      _root_.caliban.client.SelectionBuilder.Field("end", Scalar())
  }

  type Image
  object Image {

    final case class ImageView(url: String)

    type ViewSelection = SelectionBuilder[Image, ImageView]

    def view: ViewSelection = url.map(url => ImageView(url))

    def url: SelectionBuilder[Image, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())
  }

  type ImageSpecificMetadataGQL
  object ImageSpecificMetadataGQL {

    final case class ImageSpecificMetadataGQLView(
        height: scala.Option[Long],
        width: scala.Option[Long],
        orientation: scala.Option[Int]
    )

    type ViewSelection =
      SelectionBuilder[ImageSpecificMetadataGQL, ImageSpecificMetadataGQLView]

    def view: ViewSelection = (height ~ width ~ orientation).map {
      case (height, width, orientation) =>
        ImageSpecificMetadataGQLView(height, width, orientation)
    }

    /** Высота
      */
    def height: SelectionBuilder[ImageSpecificMetadataGQL, scala.Option[Long]] =
      _root_.caliban.client.SelectionBuilder.Field("height", OptionOf(Scalar()))

    /** Ширина
      */
    def width: SelectionBuilder[ImageSpecificMetadataGQL, scala.Option[Long]] =
      _root_.caliban.client.SelectionBuilder.Field("width", OptionOf(Scalar()))

    /** Оринетация
      */
    def orientation
        : SelectionBuilder[ImageSpecificMetadataGQL, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("orientation", OptionOf(Scalar()))
  }

  type IntValue
  object IntValue {

    final case class IntValueView(value: Int)

    type ViewSelection = SelectionBuilder[IntValue, IntValueView]

    def view: ViewSelection = value.map(value => IntValueView(value))

    def value: SelectionBuilder[IntValue, Int] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
  }

  type Issue
  object Issue {

    final case class IssueView[
        CreatorSelection,
        LastUpdaterSelection,
        ExecutorSelection,
        PaginationDocumentSelection,
        PaginationConceptSelection,
        PaginationIssueSelection,
        MetricSelection,
        PaginationIssueChangeSelection
    ](
        id: String,
        topic: String,
        description: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        status: IssueStatus,
        priority: IssuePriority,
        executionTimeLimit: scala.Option[UnixTime],
        markers: List[String],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection],
        executor: ExecutorSelection,
        paginationDocument: PaginationDocumentSelection,
        paginationConcept: PaginationConceptSelection,
        paginationIssue: PaginationIssueSelection,
        metric: MetricSelection,
        paginationIssueChange: PaginationIssueChangeSelection
    )

    type ViewSelection[
        CreatorSelection,
        LastUpdaterSelection,
        ExecutorSelection,
        PaginationDocumentSelection,
        PaginationConceptSelection,
        PaginationIssueSelection,
        MetricSelection,
        PaginationIssueChangeSelection
    ] = SelectionBuilder[Issue, IssueView[
      CreatorSelection,
      LastUpdaterSelection,
      ExecutorSelection,
      PaginationDocumentSelection,
      PaginationConceptSelection,
      PaginationIssueSelection,
      MetricSelection,
      PaginationIssueChangeSelection
    ]]

    def view[
        CreatorSelection,
        LastUpdaterSelection,
        ExecutorSelection,
        PaginationDocumentSelection,
        PaginationConceptSelection,
        PaginationIssueSelection,
        MetricSelection,
        PaginationIssueChangeSelection
    ](
        paginationDocumentOffset: scala.Option[Int] = None,
        paginationDocumentLimit: scala.Option[Int] = None,
        paginationConceptOffset: scala.Option[Int] = None,
        paginationConceptLimit: scala.Option[Int] = None,
        paginationIssueOffset: scala.Option[Int] = None,
        paginationIssueLimit: scala.Option[Int] = None,
        paginationIssueFilterSettings: IssueFilterSettings,
        paginationIssueSortDirection: SortDirection,
        paginationIssueSorting: IssueSorting,
        paginationIssueChangeOffset: scala.Option[Int] = None,
        paginationIssueChangeLimit: scala.Option[Int] = None
    )(
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection],
        executorSelection: SelectionBuilder[User, ExecutorSelection],
        paginationDocumentSelection: SelectionBuilder[
          DocumentPagination,
          PaginationDocumentSelection
        ],
        paginationConceptSelection: SelectionBuilder[
          ConceptPagination,
          PaginationConceptSelection
        ],
        paginationIssueSelection: SelectionBuilder[
          IssuePagination,
          PaginationIssueSelection
        ],
        metricSelection: SelectionBuilder[IssueStatistics, MetricSelection],
        paginationIssueChangeSelection: SelectionBuilder[
          IssueChangePagination,
          PaginationIssueChangeSelection
        ]
    ): ViewSelection[
      CreatorSelection,
      LastUpdaterSelection,
      ExecutorSelection,
      PaginationDocumentSelection,
      PaginationConceptSelection,
      PaginationIssueSelection,
      MetricSelection,
      PaginationIssueChangeSelection
    ] =
      (id ~ topic ~ description ~ systemRegistrationDate ~ systemUpdateDate ~ status ~ priority ~ executionTimeLimit ~ markers ~ creator(
        creatorSelection
      ) ~ lastUpdater(lastUpdaterSelection) ~ executor(
        executorSelection
      ) ~ paginationDocument(paginationDocumentOffset, paginationDocumentLimit)(
        paginationDocumentSelection
      ) ~ paginationConcept(paginationConceptOffset, paginationConceptLimit)(
        paginationConceptSelection
      ) ~ paginationIssue(
        paginationIssueOffset,
        paginationIssueLimit,
        paginationIssueFilterSettings,
        paginationIssueSortDirection,
        paginationIssueSorting
      )(paginationIssueSelection) ~ metric(
        metricSelection
      ) ~ paginationIssueChange(
        paginationIssueChangeOffset,
        paginationIssueChangeLimit
      )(paginationIssueChangeSelection)).map {
        case (
              id,
              topic,
              description,
              systemRegistrationDate,
              systemUpdateDate,
              status,
              priority,
              executionTimeLimit,
              markers,
              creator,
              lastUpdater,
              executor,
              paginationDocument,
              paginationConcept,
              paginationIssue,
              metric,
              paginationIssueChange
            ) =>
          IssueView(
            id,
            topic,
            description,
            systemRegistrationDate,
            systemUpdateDate,
            status,
            priority,
            executionTimeLimit,
            markers,
            creator,
            lastUpdater,
            executor,
            paginationDocument,
            paginationConcept,
            paginationIssue,
            metric,
            paginationIssueChange
          )
      }

    def id: SelectionBuilder[Issue, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def topic: SelectionBuilder[Issue, String] =
      _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
    def description: SelectionBuilder[Issue, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[Issue, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Issue, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def status: SelectionBuilder[Issue, IssueStatus] =
      _root_.caliban.client.SelectionBuilder.Field("status", Scalar())
    def priority: SelectionBuilder[Issue, IssuePriority] =
      _root_.caliban.client.SelectionBuilder.Field("priority", Scalar())
    def executionTimeLimit: SelectionBuilder[Issue, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("executionTimeLimit", OptionOf(Scalar()))
    def markers: SelectionBuilder[Issue, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Issue, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Issue, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    def executor[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Issue, A] = _root_.caliban.client.SelectionBuilder
      .Field("executor", Obj(innerSelection))
    def paginationDocument[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Issue, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationDocument",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def paginationConcept[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Issue, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
    def paginationIssue[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: IssueFilterSettings,
        sortDirection: SortDirection,
        sorting: IssueSorting
    )(innerSelection: SelectionBuilder[IssuePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[IssueFilterSettings],
        encoder3: ArgEncoder[SortDirection],
        encoder4: ArgEncoder[IssueSorting]
    ): SelectionBuilder[Issue, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationIssue",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("filterSettings", filterSettings, "IssueFilterSettings!")(
            encoder2
          ),
          Argument("sortDirection", sortDirection, "SortDirection!")(encoder3),
          Argument("sorting", sorting, "IssueSorting!")(encoder4)
        )
      )
    def metric[A](
        innerSelection: SelectionBuilder[IssueStatistics, A]
    ): SelectionBuilder[Issue, A] = _root_.caliban.client.SelectionBuilder
      .Field("metric", Obj(innerSelection))
    def paginationIssueChange[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[IssueChangePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Issue, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationIssueChange",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1)
        )
      )
  }

  type IssueChange
  object IssueChange {

    final case class IssueChangeView[
        FromSelection,
        ToSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        from: FromSelection,
        to: ToSelection,
        comment: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        FromSelection,
        ToSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[IssueChange, IssueChangeView[
      FromSelection,
      ToSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        FromSelection,
        ToSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        fromSelection: SelectionBuilder[IssueInfo, FromSelection],
        toSelection: SelectionBuilder[IssueInfo, ToSelection],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      FromSelection,
      ToSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ from(fromSelection) ~ to(
      toSelection
    ) ~ comment ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
      creatorSelection
    ) ~ lastUpdater(lastUpdaterSelection)).map {
      case (
            id,
            from,
            to,
            comment,
            systemRegistrationDate,
            systemUpdateDate,
            creator,
            lastUpdater
          ) =>
        IssueChangeView(
          id,
          from,
          to,
          comment,
          systemRegistrationDate,
          systemUpdateDate,
          creator,
          lastUpdater
        )
    }

    def id: SelectionBuilder[IssueChange, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def from[A](
        innerSelection: SelectionBuilder[IssueInfo, A]
    ): SelectionBuilder[IssueChange, A] =
      _root_.caliban.client.SelectionBuilder.Field("from", Obj(innerSelection))
    def to[A](
        innerSelection: SelectionBuilder[IssueInfo, A]
    ): SelectionBuilder[IssueChange, A] =
      _root_.caliban.client.SelectionBuilder.Field("to", Obj(innerSelection))
    def comment: SelectionBuilder[IssueChange, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("comment", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[IssueChange, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[IssueChange, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[IssueChange, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[IssueChange, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type IssueChangePagination
  object IssueChangePagination {

    final case class IssueChangePaginationView[ListIssueChangeSelection](
        total: Long,
        listIssueChange: List[ListIssueChangeSelection]
    )

    type ViewSelection[ListIssueChangeSelection] =
      SelectionBuilder[IssueChangePagination, IssueChangePaginationView[
        ListIssueChangeSelection
      ]]

    def view[ListIssueChangeSelection](
        listIssueChangeSelection: SelectionBuilder[
          IssueChange,
          ListIssueChangeSelection
        ]
    ): ViewSelection[ListIssueChangeSelection] =
      (total ~ listIssueChange(listIssueChangeSelection)).map {
        case (total, listIssueChange) =>
          IssueChangePaginationView(total, listIssueChange)
      }

    def total: SelectionBuilder[IssueChangePagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listIssueChange[A](
        innerSelection: SelectionBuilder[IssueChange, A]
    ): SelectionBuilder[IssueChangePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listIssueChange", ListOf(Obj(innerSelection)))
  }

  type IssueInfo
  object IssueInfo {

    final case class IssueInfoView[
        ExecutorSelection,
        ListConceptSelection,
        ListDocumentSelection,
        ListIssueSelection
    ](
        topic: scala.Option[String],
        description: scala.Option[String],
        status: scala.Option[IssueStatus],
        priority: scala.Option[IssuePriority],
        executionTimeLimit: scala.Option[UnixTime],
        markers: scala.Option[List[String]],
        executor: scala.Option[ExecutorSelection],
        listConcept: scala.Option[List[ListConceptSelection]],
        listDocument: scala.Option[List[ListDocumentSelection]],
        listIssue: scala.Option[List[ListIssueSelection]]
    )

    type ViewSelection[
        ExecutorSelection,
        ListConceptSelection,
        ListDocumentSelection,
        ListIssueSelection
    ] = SelectionBuilder[IssueInfo, IssueInfoView[
      ExecutorSelection,
      ListConceptSelection,
      ListDocumentSelection,
      ListIssueSelection
    ]]

    def view[
        ExecutorSelection,
        ListConceptSelection,
        ListDocumentSelection,
        ListIssueSelection
    ](
        executorSelection: SelectionBuilder[User, ExecutorSelection],
        listConceptSelection: SelectionBuilder[Concept, ListConceptSelection],
        listDocumentSelection: SelectionBuilder[
          Document,
          ListDocumentSelection
        ],
        listIssueSelection: SelectionBuilder[Issue, ListIssueSelection]
    ): ViewSelection[
      ExecutorSelection,
      ListConceptSelection,
      ListDocumentSelection,
      ListIssueSelection
    ] =
      (topic ~ description ~ status ~ priority ~ executionTimeLimit ~ markers ~ executor(
        executorSelection
      ) ~ listConcept(listConceptSelection) ~ listDocument(
        listDocumentSelection
      ) ~ listIssue(listIssueSelection)).map {
        case (
              topic,
              description,
              status,
              priority,
              executionTimeLimit,
              markers,
              executor,
              listConcept,
              listDocument,
              listIssue
            ) =>
          IssueInfoView(
            topic,
            description,
            status,
            priority,
            executionTimeLimit,
            markers,
            executor,
            listConcept,
            listDocument,
            listIssue
          )
      }

    def topic: SelectionBuilder[IssueInfo, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("topic", OptionOf(Scalar()))
    def description: SelectionBuilder[IssueInfo, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))
    def status: SelectionBuilder[IssueInfo, scala.Option[IssueStatus]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def priority: SelectionBuilder[IssueInfo, scala.Option[IssuePriority]] =
      _root_.caliban.client.SelectionBuilder
        .Field("priority", OptionOf(Scalar()))
    def executionTimeLimit
        : SelectionBuilder[IssueInfo, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("executionTimeLimit", OptionOf(Scalar()))
    def markers: SelectionBuilder[IssueInfo, scala.Option[List[String]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("markers", OptionOf(ListOf(Scalar())))
    def executor[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[IssueInfo, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("executor", OptionOf(Obj(innerSelection)))
    def listConcept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[IssueInfo, scala.Option[List[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConcept", OptionOf(ListOf(Obj(innerSelection))))
    def listDocument[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[IssueInfo, scala.Option[List[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listDocument", OptionOf(ListOf(Obj(innerSelection))))
    def listIssue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssueInfo, scala.Option[List[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listIssue", OptionOf(ListOf(Obj(innerSelection))))
  }

  type IssuePagination
  object IssuePagination {

    final case class IssuePaginationView[ListIssueSelection](
        listIssue: List[ListIssueSelection],
        total: Int
    )

    type ViewSelection[ListIssueSelection] =
      SelectionBuilder[IssuePagination, IssuePaginationView[ListIssueSelection]]

    def view[ListIssueSelection](
        listIssueSelection: SelectionBuilder[Issue, ListIssueSelection]
    ): ViewSelection[ListIssueSelection] =
      (listIssue(listIssueSelection) ~ total).map { case (listIssue, total) =>
        IssuePaginationView(listIssue, total)
      }

    def listIssue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssuePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listIssue", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[IssuePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type IssueStatistics
  object IssueStatistics {

    final case class IssueStatisticsView(
        countConcept: Int,
        countDoc: Int,
        countIssue: Int
    )

    type ViewSelection = SelectionBuilder[IssueStatistics, IssueStatisticsView]

    def view: ViewSelection = (countConcept ~ countDoc ~ countIssue).map {
      case (countConcept, countDoc, countIssue) =>
        IssueStatisticsView(countConcept, countDoc, countIssue)
    }

    def countConcept: SelectionBuilder[IssueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countConcept", Scalar())
    def countDoc: SelectionBuilder[IssueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDoc", Scalar())
    def countIssue: SelectionBuilder[IssueStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countIssue", Scalar())
  }

  type Language
  object Language {

    final case class LanguageView(id: String)

    type ViewSelection = SelectionBuilder[Language, LanguageView]

    def view: ViewSelection = id.map(id => LanguageView(id))

    def id: SelectionBuilder[Language, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type LanguagePagination
  object LanguagePagination {

    final case class LanguagePaginationView(
        listLanguage: List[String],
        total: Int
    )

    type ViewSelection =
      SelectionBuilder[LanguagePagination, LanguagePaginationView]

    def view: ViewSelection = (listLanguage ~ total).map {
      case (listLanguage, total) => LanguagePaginationView(listLanguage, total)
    }

    def listLanguage: SelectionBuilder[LanguagePagination, List[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listLanguage", ListOf(Scalar()))
    def total: SelectionBuilder[LanguagePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type LinkValue
  object LinkValue {

    final case class LinkValueView(link: String)

    type ViewSelection = SelectionBuilder[LinkValue, LinkValueView]

    def view: ViewSelection = link.map(link => LinkValueView(link))

    def link: SelectionBuilder[LinkValue, String] =
      _root_.caliban.client.SelectionBuilder.Field("link", Scalar())
  }

  type MapEdge
  object MapEdge {

    final case class MapEdgeView[LinkSelection](
        fromID: String,
        toID: String,
        linkType: MapEdgeType,
        id: String,
        link: LinkSelection
    )

    type ViewSelection[LinkSelection] =
      SelectionBuilder[MapEdge, MapEdgeView[LinkSelection]]

    def view[LinkSelection](
        linkSelectionOnConceptCandidateFactMention: SelectionBuilder[
          ConceptCandidateFactMention,
          LinkSelection
        ],
        linkSelectionOnConceptFactLink: SelectionBuilder[
          ConceptFactLink,
          LinkSelection
        ],
        linkSelectionOnConceptImplicitLink: SelectionBuilder[
          ConceptImplicitLink,
          LinkSelection
        ],
        linkSelectionOnConceptLink: SelectionBuilder[
          ConceptLink,
          LinkSelection
        ],
        linkSelectionOnConceptLinkCandidateFact: SelectionBuilder[
          ConceptLinkCandidateFact,
          LinkSelection
        ],
        linkSelectionOnConceptLinkType: SelectionBuilder[
          ConceptLinkType,
          LinkSelection
        ],
        linkSelectionOnConceptMention: SelectionBuilder[
          ConceptMention,
          LinkSelection
        ],
        linkSelectionOnDocumentLink: SelectionBuilder[
          DocumentLink,
          LinkSelection
        ]
    ): ViewSelection[LinkSelection] = (fromID ~ toID ~ linkType ~ id ~ link(
      linkSelectionOnConceptCandidateFactMention,
      linkSelectionOnConceptFactLink,
      linkSelectionOnConceptImplicitLink,
      linkSelectionOnConceptLink,
      linkSelectionOnConceptLinkCandidateFact,
      linkSelectionOnConceptLinkType,
      linkSelectionOnConceptMention,
      linkSelectionOnDocumentLink
    )).map { case (fromID, toID, linkType, id, link) =>
      MapEdgeView(fromID, toID, linkType, id, link)
    }

    def fromID: SelectionBuilder[MapEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("fromID", Scalar())
    def toID: SelectionBuilder[MapEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("toID", Scalar())
    def linkType: SelectionBuilder[MapEdge, MapEdgeType] =
      _root_.caliban.client.SelectionBuilder.Field("linkType", Scalar())
    def id: SelectionBuilder[MapEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def link[A](
        onConceptCandidateFactMention: SelectionBuilder[
          ConceptCandidateFactMention,
          A
        ],
        onConceptFactLink: SelectionBuilder[ConceptFactLink, A],
        onConceptImplicitLink: SelectionBuilder[ConceptImplicitLink, A],
        onConceptLink: SelectionBuilder[ConceptLink, A],
        onConceptLinkCandidateFact: SelectionBuilder[
          ConceptLinkCandidateFact,
          A
        ],
        onConceptLinkType: SelectionBuilder[ConceptLinkType, A],
        onConceptMention: SelectionBuilder[ConceptMention, A],
        onDocumentLink: SelectionBuilder[DocumentLink, A]
    ): SelectionBuilder[MapEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "link",
        ChoiceOf(
          Map(
            "ConceptCandidateFactMention" -> Obj(onConceptCandidateFactMention),
            "ConceptFactLink" -> Obj(onConceptFactLink),
            "ConceptImplicitLink" -> Obj(onConceptImplicitLink),
            "ConceptLink" -> Obj(onConceptLink),
            "ConceptLinkCandidateFact" -> Obj(onConceptLinkCandidateFact),
            "ConceptLinkType" -> Obj(onConceptLinkType),
            "ConceptMention" -> Obj(onConceptMention),
            "DocumentLink" -> Obj(onDocumentLink)
          )
        )
      )
    def linkOption[A](
        onConceptCandidateFactMention: scala.Option[
          SelectionBuilder[ConceptCandidateFactMention, A]
        ] = None,
        onConceptFactLink: scala.Option[SelectionBuilder[ConceptFactLink, A]] =
          None,
        onConceptImplicitLink: scala.Option[
          SelectionBuilder[ConceptImplicitLink, A]
        ] = None,
        onConceptLink: scala.Option[SelectionBuilder[ConceptLink, A]] = None,
        onConceptLinkCandidateFact: scala.Option[
          SelectionBuilder[ConceptLinkCandidateFact, A]
        ] = None,
        onConceptLinkType: scala.Option[SelectionBuilder[ConceptLinkType, A]] =
          None,
        onConceptMention: scala.Option[SelectionBuilder[ConceptMention, A]] =
          None,
        onDocumentLink: scala.Option[SelectionBuilder[DocumentLink, A]] = None
    ): SelectionBuilder[MapEdge, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "link",
        ChoiceOf(
          Map(
            "ConceptCandidateFactMention" -> onConceptCandidateFactMention
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptFactLink" -> onConceptFactLink
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptImplicitLink" -> onConceptImplicitLink
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptLink" -> onConceptLink.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "ConceptLinkCandidateFact" -> onConceptLinkCandidateFact
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptLinkType" -> onConceptLinkType
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptMention" -> onConceptMention
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "DocumentLink" -> onDocumentLink
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              )
          )
        )
      )
  }

  type MapNode
  object MapNode {

    final case class MapNodeView[EntitySelection](
        id: String,
        groupId: scala.Option[String],
        xCoordinate: Double,
        yCoordinate: Double,
        nodeType: MapNodeType,
        entity: EntitySelection
    )

    type ViewSelection[EntitySelection] =
      SelectionBuilder[MapNode, MapNodeView[EntitySelection]]

    def view[EntitySelection](
        entitySelectionOnConcept: SelectionBuilder[Concept, EntitySelection],
        entitySelectionOnConceptCandidateFact: SelectionBuilder[
          ConceptCandidateFact,
          EntitySelection
        ],
        entitySelectionOnConceptType: SelectionBuilder[
          ConceptType,
          EntitySelection
        ],
        entitySelectionOnDocument: SelectionBuilder[Document, EntitySelection]
    ): ViewSelection[EntitySelection] =
      (id ~ groupId ~ xCoordinate ~ yCoordinate ~ nodeType ~ entity(
        entitySelectionOnConcept,
        entitySelectionOnConceptCandidateFact,
        entitySelectionOnConceptType,
        entitySelectionOnDocument
      )).map { case (id, groupId, xCoordinate, yCoordinate, nodeType, entity) =>
        MapNodeView(id, groupId, xCoordinate, yCoordinate, nodeType, entity)
      }

    def id: SelectionBuilder[MapNode, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def groupId: SelectionBuilder[MapNode, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("groupId", OptionOf(Scalar()))
    def xCoordinate: SelectionBuilder[MapNode, Double] =
      _root_.caliban.client.SelectionBuilder.Field("xCoordinate", Scalar())
    def yCoordinate: SelectionBuilder[MapNode, Double] =
      _root_.caliban.client.SelectionBuilder.Field("yCoordinate", Scalar())
    def nodeType: SelectionBuilder[MapNode, MapNodeType] =
      _root_.caliban.client.SelectionBuilder.Field("nodeType", Scalar())
    def entity[A](
        onConcept: SelectionBuilder[Concept, A],
        onConceptCandidateFact: SelectionBuilder[ConceptCandidateFact, A],
        onConceptType: SelectionBuilder[ConceptType, A],
        onDocument: SelectionBuilder[Document, A]
    ): SelectionBuilder[MapNode, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "entity",
        ChoiceOf(
          Map(
            "Concept" -> Obj(onConcept),
            "ConceptCandidateFact" -> Obj(onConceptCandidateFact),
            "ConceptType" -> Obj(onConceptType),
            "Document" -> Obj(onDocument)
          )
        )
      )
    def entityOption[A](
        onConcept: scala.Option[SelectionBuilder[Concept, A]] = None,
        onConceptCandidateFact: scala.Option[
          SelectionBuilder[ConceptCandidateFact, A]
        ] = None,
        onConceptType: scala.Option[SelectionBuilder[ConceptType, A]] = None,
        onDocument: scala.Option[SelectionBuilder[Document, A]] = None
    ): SelectionBuilder[MapNode, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "entity",
        ChoiceOf(
          Map(
            "Concept" -> onConcept.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "ConceptCandidateFact" -> onConceptCandidateFact
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "ConceptType" -> onConceptType.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "Document" -> onDocument.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a)))
          )
        )
      )
  }

  type Markers
  object Markers {

    final case class MarkersView(markers: List[String])

    type ViewSelection = SelectionBuilder[Markers, MarkersView]

    def view: ViewSelection = markers.map(markers => MarkersView(markers))

    def markers: SelectionBuilder[Markers, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
  }

  type Mention
  object Mention {

    final case class MentionView[
        TextBoundingSelection,
        VerifierSelection,
        AccessLevelSelection
    ](
        id: String,
        documentId: String,
        textBounding: List[TextBoundingSelection],
        verifier: VerifierSelection,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        accessLevel: AccessLevelSelection
    )

    type ViewSelection[
        TextBoundingSelection,
        VerifierSelection,
        AccessLevelSelection
    ] = SelectionBuilder[Mention, MentionView[
      TextBoundingSelection,
      VerifierSelection,
      AccessLevelSelection
    ]]

    def view[TextBoundingSelection, VerifierSelection, AccessLevelSelection](
        textBoundingSelection: SelectionBuilder[
          TextBounding,
          TextBoundingSelection
        ],
        verifierSelection: SelectionBuilder[User, VerifierSelection],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ]
    ): ViewSelection[
      TextBoundingSelection,
      VerifierSelection,
      AccessLevelSelection
    ] = (id ~ documentId ~ textBounding(textBoundingSelection) ~ verifier(
      verifierSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ accessLevel(
      accessLevelSelection
    )).map {
      case (
            id,
            documentId,
            textBounding,
            verifier,
            systemRegistrationDate,
            systemUpdateDate,
            accessLevel
          ) =>
        MentionView(
          id,
          documentId,
          textBounding,
          verifier,
          systemRegistrationDate,
          systemUpdateDate,
          accessLevel
        )
    }

    def id: SelectionBuilder[Mention, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def documentId: SelectionBuilder[Mention, String] =
      _root_.caliban.client.SelectionBuilder.Field("documentId", Scalar())
    def textBounding[A](
        innerSelection: SelectionBuilder[TextBounding, A]
    ): SelectionBuilder[Mention, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("textBounding", ListOf(Obj(innerSelection)))
    def verifier[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Mention, A] = _root_.caliban.client.SelectionBuilder
      .Field("verifier", Obj(innerSelection))
    def systemRegistrationDate: SelectionBuilder[Mention, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Mention, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[Mention, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
  }

  type MergedConcept
  object MergedConcept {

    final case class MergedConceptView[ConceptSelection, MergeAuthorSelection](
        concept: ConceptSelection,
        mergeAuthor: MergeAuthorSelection,
        mergeDate: UnixTime
    )

    type ViewSelection[ConceptSelection, MergeAuthorSelection] =
      SelectionBuilder[
        MergedConcept,
        MergedConceptView[ConceptSelection, MergeAuthorSelection]
      ]

    def view[ConceptSelection, MergeAuthorSelection](
        conceptSelection: SelectionBuilder[Concept, ConceptSelection],
        mergeAuthorSelection: SelectionBuilder[User, MergeAuthorSelection]
    ): ViewSelection[ConceptSelection, MergeAuthorSelection] = (concept(
      conceptSelection
    ) ~ mergeAuthor(mergeAuthorSelection) ~ mergeDate).map {
      case (concept, mergeAuthor, mergeDate) =>
        MergedConceptView(concept, mergeAuthor, mergeDate)
    }

    def concept[A](
        innerSelection: SelectionBuilder[Concept, A]
    ): SelectionBuilder[MergedConcept, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("concept", Obj(innerSelection))
    def mergeAuthor[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MergedConcept, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("mergeAuthor", Obj(innerSelection))
    def mergeDate: SelectionBuilder[MergedConcept, UnixTime] =
      _root_.caliban.client.SelectionBuilder.Field("mergeDate", Scalar())
  }

  type MergedConceptPagination
  object MergedConceptPagination {

    final case class MergedConceptPaginationView[ListMergedConceptSelection](
        total: Long,
        listMergedConcept: List[ListMergedConceptSelection]
    )

    type ViewSelection[ListMergedConceptSelection] =
      SelectionBuilder[MergedConceptPagination, MergedConceptPaginationView[
        ListMergedConceptSelection
      ]]

    def view[ListMergedConceptSelection](
        listMergedConceptSelection: SelectionBuilder[
          MergedConcept,
          ListMergedConceptSelection
        ]
    ): ViewSelection[ListMergedConceptSelection] =
      (total ~ listMergedConcept(listMergedConceptSelection)).map {
        case (total, listMergedConcept) =>
          MergedConceptPaginationView(total, listMergedConcept)
      }

    def total: SelectionBuilder[MergedConceptPagination, Long] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listMergedConcept[A](
        innerSelection: SelectionBuilder[MergedConcept, A]
    ): SelectionBuilder[MergedConceptPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listMergedConcept", ListOf(Obj(innerSelection)))
  }

  type Metrics
  object Metrics {

    final case class MetricsView(
        countObjects: Int,
        countEvents: Int,
        countNamedEntities: Int,
        countDisambiguatedEntities: Int,
        countPropertyCandidates: Int,
        countLinks: Int,
        countResearchMaps: Int,
        countChildDocs: Int,
        countTasks: Int,
        countConcepts: Int,
        countEntities: Int
    )

    type ViewSelection = SelectionBuilder[Metrics, MetricsView]

    def view: ViewSelection =
      (countObjects ~ countEvents ~ countNamedEntities ~ countDisambiguatedEntities ~ countPropertyCandidates ~ countLinks ~ countResearchMaps ~ countChildDocs ~ countTasks ~ countConcepts ~ countEntities)
        .map {
          case (
                countObjects,
                countEvents,
                countNamedEntities,
                countDisambiguatedEntities,
                countPropertyCandidates,
                countLinks,
                countResearchMaps,
                countChildDocs,
                countTasks,
                countConcepts,
                countEntities
              ) =>
            MetricsView(
              countObjects,
              countEvents,
              countNamedEntities,
              countDisambiguatedEntities,
              countPropertyCandidates,
              countLinks,
              countResearchMaps,
              countChildDocs,
              countTasks,
              countConcepts,
              countEntities
            )
        }

    def countObjects: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countObjects", Scalar())
    def countEvents: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countEvents", Scalar())
    def countNamedEntities: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countNamedEntities", Scalar())
    def countDisambiguatedEntities: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countDisambiguatedEntities", Scalar())
    def countPropertyCandidates: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countPropertyCandidates", Scalar())
    def countLinks: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countLinks", Scalar())
    def countResearchMaps: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("countResearchMaps", Scalar())
    def countChildDocs: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countChildDocs", Scalar())
    def countTasks: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countTasks", Scalar())
    def countConcepts: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countConcepts", Scalar())
    def countEntities: SelectionBuilder[Metrics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countEntities", Scalar())
  }

  type NamedValue
  object NamedValue {

    final case class NamedValueView[PropertyValueTypeSelection, ValueSelection](
        id: String,
        propertyValueType: PropertyValueTypeSelection,
        value: ValueSelection
    )

    type ViewSelection[PropertyValueTypeSelection, ValueSelection] =
      SelectionBuilder[
        NamedValue,
        NamedValueView[PropertyValueTypeSelection, ValueSelection]
      ]

    def view[PropertyValueTypeSelection, ValueSelection](
        propertyValueTypeSelection: SelectionBuilder[
          CompositePropertyValueType,
          PropertyValueTypeSelection
        ],
        valueSelectionOnDateTimeValue: SelectionBuilder[
          DateTimeValue,
          ValueSelection
        ],
        valueSelectionOnDoubleValue: SelectionBuilder[
          DoubleValue,
          ValueSelection
        ],
        valueSelectionOnGeoPointValue: SelectionBuilder[
          GeoPointValue,
          ValueSelection
        ],
        valueSelectionOnIntValue: SelectionBuilder[IntValue, ValueSelection],
        valueSelectionOnLinkValue: SelectionBuilder[LinkValue, ValueSelection],
        valueSelectionOnStringLocaleValue: SelectionBuilder[
          StringLocaleValue,
          ValueSelection
        ],
        valueSelectionOnStringValue: SelectionBuilder[
          StringValue,
          ValueSelection
        ]
    ): ViewSelection[PropertyValueTypeSelection, ValueSelection] =
      (id ~ propertyValueType(propertyValueTypeSelection) ~ value(
        valueSelectionOnDateTimeValue,
        valueSelectionOnDoubleValue,
        valueSelectionOnGeoPointValue,
        valueSelectionOnIntValue,
        valueSelectionOnLinkValue,
        valueSelectionOnStringLocaleValue,
        valueSelectionOnStringValue
      )).map { case (id, propertyValueType, value) =>
        NamedValueView(id, propertyValueType, value)
      }

    def id: SelectionBuilder[NamedValue, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def propertyValueType[A](
        innerSelection: SelectionBuilder[CompositePropertyValueType, A]
    ): SelectionBuilder[NamedValue, A] = _root_.caliban.client.SelectionBuilder
      .Field("propertyValueType", Obj(innerSelection))
    def value[A](
        onDateTimeValue: SelectionBuilder[DateTimeValue, A],
        onDoubleValue: SelectionBuilder[DoubleValue, A],
        onGeoPointValue: SelectionBuilder[GeoPointValue, A],
        onIntValue: SelectionBuilder[IntValue, A],
        onLinkValue: SelectionBuilder[LinkValue, A],
        onStringLocaleValue: SelectionBuilder[StringLocaleValue, A],
        onStringValue: SelectionBuilder[StringValue, A]
    ): SelectionBuilder[NamedValue, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "value",
        ChoiceOf(
          Map(
            "DateTimeValue" -> Obj(onDateTimeValue),
            "DoubleValue" -> Obj(onDoubleValue),
            "GeoPointValue" -> Obj(onGeoPointValue),
            "IntValue" -> Obj(onIntValue),
            "LinkValue" -> Obj(onLinkValue),
            "StringLocaleValue" -> Obj(onStringLocaleValue),
            "StringValue" -> Obj(onStringValue)
          )
        )
      )
    def valueOption[A](
        onDateTimeValue: scala.Option[SelectionBuilder[DateTimeValue, A]] =
          None,
        onDoubleValue: scala.Option[SelectionBuilder[DoubleValue, A]] = None,
        onGeoPointValue: scala.Option[SelectionBuilder[GeoPointValue, A]] =
          None,
        onIntValue: scala.Option[SelectionBuilder[IntValue, A]] = None,
        onLinkValue: scala.Option[SelectionBuilder[LinkValue, A]] = None,
        onStringLocaleValue: scala.Option[
          SelectionBuilder[StringLocaleValue, A]
        ] = None,
        onStringValue: scala.Option[SelectionBuilder[StringValue, A]] = None
    ): SelectionBuilder[NamedValue, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "value",
        ChoiceOf(
          Map(
            "DateTimeValue" -> onDateTimeValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "DoubleValue" -> onDoubleValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "GeoPointValue" -> onGeoPointValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "IntValue" -> onIntValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "LinkValue" -> onLinkValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a))),
            "StringLocaleValue" -> onStringLocaleValue
              .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                OptionOf(Obj(a))
              ),
            "StringValue" -> onStringValue.fold[FieldBuilder[scala.Option[A]]](
              NullField
            )(a => OptionOf(Obj(a)))
          )
        )
      )
  }

  type NERCRegexp
  object NERCRegexp {

    final case class NERCRegexpView(
        regexp: String,
        contextRegexp: scala.Option[String],
        autoCreate: scala.Option[Boolean]
    )

    type ViewSelection = SelectionBuilder[NERCRegexp, NERCRegexpView]

    def view: ViewSelection = (regexp ~ contextRegexp ~ autoCreate).map {
      case (regexp, contextRegexp, autoCreate) =>
        NERCRegexpView(regexp, contextRegexp, autoCreate)
    }

    def regexp: SelectionBuilder[NERCRegexp, String] =
      _root_.caliban.client.SelectionBuilder.Field("regexp", Scalar())
    def contextRegexp: SelectionBuilder[NERCRegexp, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("contextRegexp", OptionOf(Scalar()))
    def autoCreate: SelectionBuilder[NERCRegexp, scala.Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("autoCreate", OptionOf(Scalar()))
  }

  type OutputLimiter
  object OutputLimiter {

    final case class OutputLimiterView(
        maximumPoints: scala.Option[Long],
        minimumNumber: scala.Option[Long]
    )

    type ViewSelection = SelectionBuilder[OutputLimiter, OutputLimiterView]

    def view: ViewSelection = (maximumPoints ~ minimumNumber).map {
      case (maximumPoints, minimumNumber) =>
        OutputLimiterView(maximumPoints, minimumNumber)
    }

    def maximumPoints: SelectionBuilder[OutputLimiter, scala.Option[Long]] =
      _root_.caliban.client.SelectionBuilder
        .Field("maximumPoints", OptionOf(Scalar()))
    def minimumNumber: SelectionBuilder[OutputLimiter, scala.Option[Long]] =
      _root_.caliban.client.SelectionBuilder
        .Field("minimumNumber", OptionOf(Scalar()))
  }

  type ParagraphMetadata
  object ParagraphMetadata {

    final case class ParagraphMetadataView[TextTranslationsSelection](
        pageId: scala.Option[Int],
        lineId: scala.Option[Int],
        originalText: scala.Option[String],
        hidden: scala.Option[Boolean],
        textTranslations: scala.Option[List[TextTranslationsSelection]],
        paragraphType: NodeType
    )

    type ViewSelection[TextTranslationsSelection] =
      SelectionBuilder[ParagraphMetadata, ParagraphMetadataView[
        TextTranslationsSelection
      ]]

    def view[TextTranslationsSelection](
        textTranslationsSelection: SelectionBuilder[
          Translation,
          TextTranslationsSelection
        ]
    ): ViewSelection[TextTranslationsSelection] =
      (pageId ~ lineId ~ originalText ~ hidden ~ textTranslations(
        textTranslationsSelection
      ) ~ paragraphType).map {
        case (
              pageId,
              lineId,
              originalText,
              hidden,
              textTranslations,
              paragraphType
            ) =>
          ParagraphMetadataView(
            pageId,
            lineId,
            originalText,
            hidden,
            textTranslations,
            paragraphType
          )
      }

    def pageId: SelectionBuilder[ParagraphMetadata, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("pageId", OptionOf(Scalar()))
    def lineId: SelectionBuilder[ParagraphMetadata, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("lineId", OptionOf(Scalar()))
    def originalText
        : SelectionBuilder[ParagraphMetadata, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("originalText", OptionOf(Scalar()))
    def hidden: SelectionBuilder[ParagraphMetadata, scala.Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("hidden", OptionOf(Scalar()))
    def textTranslations[A](
        innerSelection: SelectionBuilder[Translation, A]
    ): SelectionBuilder[ParagraphMetadata, scala.Option[List[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("textTranslations", OptionOf(ListOf(Obj(innerSelection))))
    def paragraphType: SelectionBuilder[ParagraphMetadata, NodeType] =
      _root_.caliban.client.SelectionBuilder.Field("paragraphType", Scalar())
  }

  type Parameter
  object Parameter {

    final case class ParameterView(key: String, value: String)

    type ViewSelection = SelectionBuilder[Parameter, ParameterView]

    def view: ViewSelection = (key ~ value).map { case (key, value) =>
      ParameterView(key, value)
    }

    def key: SelectionBuilder[Parameter, String] =
      _root_.caliban.client.SelectionBuilder.Field("key", Scalar())
    def value: SelectionBuilder[Parameter, String] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
  }

  type PdfSpecificMetadataGQL
  object PdfSpecificMetadataGQL {

    final case class PdfSpecificMetadataGQLView(
        author: scala.Option[String],
        creationDate: scala.Option[UnixTime]
    )

    type ViewSelection =
      SelectionBuilder[PdfSpecificMetadataGQL, PdfSpecificMetadataGQLView]

    def view: ViewSelection = (author ~ creationDate).map {
      case (author, creationDate) =>
        PdfSpecificMetadataGQLView(author, creationDate)
    }

    /** Автор
      */
    def author: SelectionBuilder[PdfSpecificMetadataGQL, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("author", OptionOf(Scalar()))

    /** Дата создания
      */
    def creationDate
        : SelectionBuilder[PdfSpecificMetadataGQL, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("creationDate", OptionOf(Scalar()))
  }

  type Platform
  object Platform {

    final case class PlatformView[
        ParamsSelection,
        ImageSelection,
        MetricSelection,
        PeriodSelection,
        AccountsSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        platformType: PlatformType,
        url: String,
        country: scala.Option[String],
        language: scala.Option[String],
        markers: List[String],
        params: List[ParamsSelection],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        image: scala.Option[ImageSelection],
        metric: MetricSelection,
        period: PeriodSelection,
        accounts: AccountsSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    type ViewSelection[
        ParamsSelection,
        ImageSelection,
        MetricSelection,
        PeriodSelection,
        AccountsSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[Platform, PlatformView[
      ParamsSelection,
      ImageSelection,
      MetricSelection,
      PeriodSelection,
      AccountsSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ParamsSelection,
        ImageSelection,
        MetricSelection,
        PeriodSelection,
        AccountsSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        accountsOffset: scala.Option[Int] = None,
        accountsLimit: scala.Option[Int] = None,
        accountsFilterSettings: AccountFilterSettings,
        accountsSortDirection: scala.Option[SortDirection] = None,
        accountsSorting: scala.Option[AccountSorting] = None
    )(
        paramsSelection: SelectionBuilder[Parameter, ParamsSelection],
        imageSelection: SelectionBuilder[Image, ImageSelection],
        metricSelection: SelectionBuilder[PlatformStatistics, MetricSelection],
        periodSelection: SelectionBuilder[DateTimeInterval, PeriodSelection],
        accountsSelection: SelectionBuilder[
          AccountPagination,
          AccountsSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ParamsSelection,
      ImageSelection,
      MetricSelection,
      PeriodSelection,
      AccountsSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] = (id ~ name ~ platformType ~ url ~ country ~ language ~ markers ~ params(
      paramsSelection
    ) ~ systemRegistrationDate ~ systemUpdateDate ~ image(
      imageSelection
    ) ~ metric(metricSelection) ~ period(periodSelection) ~ accounts(
      accountsOffset,
      accountsLimit,
      accountsFilterSettings,
      accountsSortDirection,
      accountsSorting
    )(accountsSelection) ~ creator(creatorSelection) ~ lastUpdater(
      lastUpdaterSelection
    )).map {
      case (
            id,
            name,
            platformType,
            url,
            country,
            language,
            markers,
            params,
            systemRegistrationDate,
            systemUpdateDate,
            image,
            metric,
            period,
            accounts,
            creator,
            lastUpdater
          ) =>
        PlatformView(
          id,
          name,
          platformType,
          url,
          country,
          language,
          markers,
          params,
          systemRegistrationDate,
          systemUpdateDate,
          image,
          metric,
          period,
          accounts,
          creator,
          lastUpdater
        )
    }

    /** key
      */
    def id: SelectionBuilder[Platform, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[Platform, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def platformType: SelectionBuilder[Platform, PlatformType] =
      _root_.caliban.client.SelectionBuilder.Field("platformType", Scalar())
    def url: SelectionBuilder[Platform, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())
    def country: SelectionBuilder[Platform, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("country", OptionOf(Scalar()))
    def language: SelectionBuilder[Platform, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("language", OptionOf(Scalar()))
    def markers: SelectionBuilder[Platform, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
    def params[A](
        innerSelection: SelectionBuilder[Parameter, A]
    ): SelectionBuilder[Platform, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("params", ListOf(Obj(innerSelection)))
    def systemRegistrationDate: SelectionBuilder[Platform, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Platform, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def image[A](
        innerSelection: SelectionBuilder[Image, A]
    ): SelectionBuilder[Platform, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("image", OptionOf(Obj(innerSelection)))
    def metric[A](
        innerSelection: SelectionBuilder[PlatformStatistics, A]
    ): SelectionBuilder[Platform, A] = _root_.caliban.client.SelectionBuilder
      .Field("metric", Obj(innerSelection))
    def period[A](
        innerSelection: SelectionBuilder[DateTimeInterval, A]
    ): SelectionBuilder[Platform, A] = _root_.caliban.client.SelectionBuilder
      .Field("period", Obj(innerSelection))
    def accounts[A](
        offset: scala.Option[Int] = None,
        limit: scala.Option[Int] = None,
        filterSettings: AccountFilterSettings,
        sortDirection: scala.Option[SortDirection] = None,
        sorting: scala.Option[AccountSorting] = None
    )(innerSelection: SelectionBuilder[AccountPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[AccountFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[AccountSorting]]
    ): SelectionBuilder[Platform, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "accounts",
        Obj(innerSelection),
        arguments = List(
          Argument("offset", offset, "Int")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("filterSettings", filterSettings, "AccountFilterSettings!")(
            encoder2
          ),
          Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
          Argument("sorting", sorting, "AccountSorting")(encoder4)
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Platform, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Platform, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type PlatformFacet
  object PlatformFacet {

    final case class PlatformFacetView[ValueSelection](
        value: ValueSelection,
        count: Long
    )

    type ViewSelection[ValueSelection] =
      SelectionBuilder[PlatformFacet, PlatformFacetView[ValueSelection]]

    def view[ValueSelection](
        valueSelection: SelectionBuilder[Platform, ValueSelection]
    ): ViewSelection[ValueSelection] = (value(valueSelection) ~ count).map {
      case (value, count) => PlatformFacetView(value, count)
    }

    def value[A](
        innerSelection: SelectionBuilder[Platform, A]
    ): SelectionBuilder[PlatformFacet, A] =
      _root_.caliban.client.SelectionBuilder.Field("value", Obj(innerSelection))
    def count: SelectionBuilder[PlatformFacet, Long] =
      _root_.caliban.client.SelectionBuilder.Field("count", Scalar())
  }

  type PlatformPagination
  object PlatformPagination {

    final case class PlatformPaginationView[ListPlatformSelection](
        listPlatform: List[ListPlatformSelection],
        total: Int
    )

    type ViewSelection[ListPlatformSelection] =
      SelectionBuilder[PlatformPagination, PlatformPaginationView[
        ListPlatformSelection
      ]]

    def view[ListPlatformSelection](
        listPlatformSelection: SelectionBuilder[Platform, ListPlatformSelection]
    ): ViewSelection[ListPlatformSelection] =
      (listPlatform(listPlatformSelection) ~ total).map {
        case (listPlatform, total) =>
          PlatformPaginationView(listPlatform, total)
      }

    def listPlatform[A](
        innerSelection: SelectionBuilder[Platform, A]
    ): SelectionBuilder[PlatformPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listPlatform", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[PlatformPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type PlatformStatistics
  object PlatformStatistics {

    final case class PlatformStatisticsView(
        countAccount: Int,
        countDoc: Int,
        countDocToday: Int,
        countDocWeek: Int,
        countDocMonth: Int,
        recallDocToday: DocumentRecall,
        recallDocWeek: DocumentRecall,
        recallDocMonth: DocumentRecall
    )

    type ViewSelection =
      SelectionBuilder[PlatformStatistics, PlatformStatisticsView]

    def view: ViewSelection =
      (countAccount ~ countDoc ~ countDocToday ~ countDocWeek ~ countDocMonth ~ recallDocToday ~ recallDocWeek ~ recallDocMonth)
        .map {
          case (
                countAccount,
                countDoc,
                countDocToday,
                countDocWeek,
                countDocMonth,
                recallDocToday,
                recallDocWeek,
                recallDocMonth
              ) =>
            PlatformStatisticsView(
              countAccount,
              countDoc,
              countDocToday,
              countDocWeek,
              countDocMonth,
              recallDocToday,
              recallDocWeek,
              recallDocMonth
            )
        }

    def countAccount: SelectionBuilder[PlatformStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countAccount", Scalar())
    def countDoc: SelectionBuilder[PlatformStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDoc", Scalar())
    def countDocToday: SelectionBuilder[PlatformStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDocToday", Scalar())
    def countDocWeek: SelectionBuilder[PlatformStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDocWeek", Scalar())
    def countDocMonth: SelectionBuilder[PlatformStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDocMonth", Scalar())
    def recallDocToday: SelectionBuilder[PlatformStatistics, DocumentRecall] =
      _root_.caliban.client.SelectionBuilder.Field("recallDocToday", Scalar())
    def recallDocWeek: SelectionBuilder[PlatformStatistics, DocumentRecall] =
      _root_.caliban.client.SelectionBuilder.Field("recallDocWeek", Scalar())
    def recallDocMonth: SelectionBuilder[PlatformStatistics, DocumentRecall] =
      _root_.caliban.client.SelectionBuilder.Field("recallDocMonth", Scalar())
  }

  type RedmineIssue
  object RedmineIssue {

    final case class RedmineIssueView[
        TrackerSelection,
        StatusSelection,
        PrioritySelection
    ](
        id: String,
        subject: String,
        tracker: TrackerSelection,
        status: StatusSelection,
        priority: PrioritySelection,
        author: String,
        assignee: String,
        creationDate: Long
    )

    type ViewSelection[TrackerSelection, StatusSelection, PrioritySelection] =
      SelectionBuilder[
        RedmineIssue,
        RedmineIssueView[TrackerSelection, StatusSelection, PrioritySelection]
      ]

    def view[TrackerSelection, StatusSelection, PrioritySelection](
        trackerSelection: SelectionBuilder[RedmineTracker, TrackerSelection],
        statusSelection: SelectionBuilder[RedmineStatus, StatusSelection],
        prioritySelection: SelectionBuilder[RedminePriority, PrioritySelection]
    ): ViewSelection[TrackerSelection, StatusSelection, PrioritySelection] =
      (id ~ subject ~ tracker(trackerSelection) ~ status(
        statusSelection
      ) ~ priority(prioritySelection) ~ author ~ assignee ~ creationDate).map {
        case (
              id,
              subject,
              tracker,
              status,
              priority,
              author,
              assignee,
              creationDate
            ) =>
          RedmineIssueView(
            id,
            subject,
            tracker,
            status,
            priority,
            author,
            assignee,
            creationDate
          )
      }

    def id: SelectionBuilder[RedmineIssue, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def subject: SelectionBuilder[RedmineIssue, String] =
      _root_.caliban.client.SelectionBuilder.Field("subject", Scalar())
    def tracker[A](
        innerSelection: SelectionBuilder[RedmineTracker, A]
    ): SelectionBuilder[RedmineIssue, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("tracker", Obj(innerSelection))
    def status[A](
        innerSelection: SelectionBuilder[RedmineStatus, A]
    ): SelectionBuilder[RedmineIssue, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("status", Obj(innerSelection))
    def priority[A](
        innerSelection: SelectionBuilder[RedminePriority, A]
    ): SelectionBuilder[RedmineIssue, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("priority", Obj(innerSelection))
    def author: SelectionBuilder[RedmineIssue, String] =
      _root_.caliban.client.SelectionBuilder.Field("author", Scalar())
    def assignee: SelectionBuilder[RedmineIssue, String] =
      _root_.caliban.client.SelectionBuilder.Field("assignee", Scalar())
    def creationDate: SelectionBuilder[RedmineIssue, Long] =
      _root_.caliban.client.SelectionBuilder.Field("creationDate", Scalar())
  }

  type RedmineIssueCreationDefaultParameters
  object RedmineIssueCreationDefaultParameters {

    final case class RedmineIssueCreationDefaultParametersView[
        UsersSelection,
        TrackersSelection,
        StatusesSelection,
        PrioritiesSelection
    ](
        subject: String,
        description: String,
        users: List[UsersSelection],
        trackers: List[TrackersSelection],
        statuses: List[StatusesSelection],
        priorities: List[PrioritiesSelection]
    )

    type ViewSelection[
        UsersSelection,
        TrackersSelection,
        StatusesSelection,
        PrioritiesSelection
    ] = SelectionBuilder[
      RedmineIssueCreationDefaultParameters,
      RedmineIssueCreationDefaultParametersView[
        UsersSelection,
        TrackersSelection,
        StatusesSelection,
        PrioritiesSelection
      ]
    ]

    def view[
        UsersSelection,
        TrackersSelection,
        StatusesSelection,
        PrioritiesSelection
    ](
        usersSelection: SelectionBuilder[RedmineUser, UsersSelection],
        trackersSelection: SelectionBuilder[RedmineTracker, TrackersSelection],
        statusesSelection: SelectionBuilder[RedmineStatus, StatusesSelection],
        prioritiesSelection: SelectionBuilder[
          RedminePriority,
          PrioritiesSelection
        ]
    ): ViewSelection[
      UsersSelection,
      TrackersSelection,
      StatusesSelection,
      PrioritiesSelection
    ] = (subject ~ description ~ users(usersSelection) ~ trackers(
      trackersSelection
    ) ~ statuses(statusesSelection) ~ priorities(prioritiesSelection)).map {
      case (subject, description, users, trackers, statuses, priorities) =>
        RedmineIssueCreationDefaultParametersView(
          subject,
          description,
          users,
          trackers,
          statuses,
          priorities
        )
    }

    def subject
        : SelectionBuilder[RedmineIssueCreationDefaultParameters, String] =
      _root_.caliban.client.SelectionBuilder.Field("subject", Scalar())
    def description
        : SelectionBuilder[RedmineIssueCreationDefaultParameters, String] =
      _root_.caliban.client.SelectionBuilder.Field("description", Scalar())
    def users[A](
        innerSelection: SelectionBuilder[RedmineUser, A]
    ): SelectionBuilder[RedmineIssueCreationDefaultParameters, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("users", ListOf(Obj(innerSelection)))
    def trackers[A](
        innerSelection: SelectionBuilder[RedmineTracker, A]
    ): SelectionBuilder[RedmineIssueCreationDefaultParameters, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("trackers", ListOf(Obj(innerSelection)))

    /** all statuses; workflow restricted statuses are included
      */
    def statuses[A](
        innerSelection: SelectionBuilder[RedmineStatus, A]
    ): SelectionBuilder[RedmineIssueCreationDefaultParameters, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("statuses", ListOf(Obj(innerSelection)))
    def priorities[A](
        innerSelection: SelectionBuilder[RedminePriority, A]
    ): SelectionBuilder[RedmineIssueCreationDefaultParameters, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("priorities", ListOf(Obj(innerSelection)))
  }

  type RedmineIssuePagination
  object RedmineIssuePagination {

    final case class RedmineIssuePaginationView[ListRedmineIssueSelection](
        listRedmineIssue: List[ListRedmineIssueSelection],
        total: Int
    )

    type ViewSelection[ListRedmineIssueSelection] =
      SelectionBuilder[RedmineIssuePagination, RedmineIssuePaginationView[
        ListRedmineIssueSelection
      ]]

    def view[ListRedmineIssueSelection](
        listRedmineIssueSelection: SelectionBuilder[
          RedmineIssue,
          ListRedmineIssueSelection
        ]
    ): ViewSelection[ListRedmineIssueSelection] =
      (listRedmineIssue(listRedmineIssueSelection) ~ total).map {
        case (listRedmineIssue, total) =>
          RedmineIssuePaginationView(listRedmineIssue, total)
      }

    def listRedmineIssue[A](
        innerSelection: SelectionBuilder[RedmineIssue, A]
    ): SelectionBuilder[RedmineIssuePagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listRedmineIssue", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[RedmineIssuePagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
  }

  type RedminePriority
  object RedminePriority {

    final case class RedminePriorityView(id: String, name: String)

    type ViewSelection = SelectionBuilder[RedminePriority, RedminePriorityView]

    def view: ViewSelection = (id ~ name).map { case (id, name) =>
      RedminePriorityView(id, name)
    }

    def id: SelectionBuilder[RedminePriority, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[RedminePriority, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type RedmineStatus
  object RedmineStatus {

    final case class RedmineStatusView(id: String, name: String)

    type ViewSelection = SelectionBuilder[RedmineStatus, RedmineStatusView]

    def view: ViewSelection = (id ~ name).map { case (id, name) =>
      RedmineStatusView(id, name)
    }

    def id: SelectionBuilder[RedmineStatus, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[RedmineStatus, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type RedmineTracker
  object RedmineTracker {

    final case class RedmineTrackerView(id: String, name: String)

    type ViewSelection = SelectionBuilder[RedmineTracker, RedmineTrackerView]

    def view: ViewSelection = (id ~ name).map { case (id, name) =>
      RedmineTrackerView(id, name)
    }

    def id: SelectionBuilder[RedmineTracker, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[RedmineTracker, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type RedmineUser
  object RedmineUser {

    final case class RedmineUserView(id: String, fullName: String)

    type ViewSelection = SelectionBuilder[RedmineUser, RedmineUserView]

    def view: ViewSelection = (id ~ fullName).map { case (id, fullName) =>
      RedmineUserView(id, fullName)
    }

    def id: SelectionBuilder[RedmineUser, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def fullName: SelectionBuilder[RedmineUser, String] =
      _root_.caliban.client.SelectionBuilder.Field("fullName", Scalar())
  }

  type RelExtModel
  object RelExtModel {

    final case class RelExtModelView(
        sourceAnnotationType: String,
        targetAnnotationType: String,
        relationType: String,
        invertDirection: Boolean
    )

    type ViewSelection = SelectionBuilder[RelExtModel, RelExtModelView]

    def view: ViewSelection =
      (sourceAnnotationType ~ targetAnnotationType ~ relationType ~ invertDirection)
        .map {
          case (
                sourceAnnotationType,
                targetAnnotationType,
                relationType,
                invertDirection
              ) =>
            RelExtModelView(
              sourceAnnotationType,
              targetAnnotationType,
              relationType,
              invertDirection
            )
        }

    def sourceAnnotationType: SelectionBuilder[RelExtModel, String] =
      _root_.caliban.client.SelectionBuilder
        .Field("sourceAnnotationType", Scalar())
    def targetAnnotationType: SelectionBuilder[RelExtModel, String] =
      _root_.caliban.client.SelectionBuilder
        .Field("targetAnnotationType", Scalar())
    def relationType: SelectionBuilder[RelExtModel, String] =
      _root_.caliban.client.SelectionBuilder.Field("relationType", Scalar())
    def invertDirection: SelectionBuilder[RelExtModel, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("invertDirection", Scalar())
  }

  type ResearchMap
  object ResearchMap {

    final case class ResearchMapView[
        ListNodeSelection,
        ListEdgeSelection,
        ResearchMapStatisticsSelection,
        ListGroupSelection,
        AccessLevelSelection,
        PaginationConceptSelection,
        PaginationStorySelection,
        PaginationResearchMapSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](
        id: String,
        name: String,
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        description: scala.Option[String],
        isTemporary: Boolean,
        markers: List[String],
        listNode: List[ListNodeSelection],
        listEdge: List[ListEdgeSelection],
        researchMapStatistics: ResearchMapStatisticsSelection,
        listGroup: List[ListGroupSelection],
        isActive: Boolean,
        accessLevel: AccessLevelSelection,
        paginationConcept: PaginationConceptSelection,
        paginationStory: PaginationStorySelection,
        paginationResearchMap: PaginationResearchMapSelection,
        creator: CreatorSelection,
        lastUpdater: scala.Option[LastUpdaterSelection]
    )

    final case class ResearchMapViewArgs(
        listNodeFilterSettings: scala.Option[MapNodeFilterSettings] = None,
        listNodeDefaultView: scala.Option[Boolean] = None,
        listEdgeFilterSettings: scala.Option[MapEdgeFilterSettings] = None,
        listEdgeDefaultView: scala.Option[Boolean] = None,
        paginationConceptLimit: scala.Option[Int] = None,
        paginationConceptOffset: scala.Option[Int] = None,
        paginationConceptQuery: scala.Option[String] = None,
        paginationConceptFilterSettings: scala.Option[ConceptFilterSettings] =
          None,
        paginationConceptDirection: scala.Option[SortDirection] = None,
        paginationConceptSortField: scala.Option[ConceptSorting] = None,
        paginationConceptExtraSettings: ConceptExtraSettings,
        paginationStoryLimit: scala.Option[Int] = None,
        paginationStoryOffset: scala.Option[Int] = None,
        paginationStoryGrouping: scala.Option[DocumentGrouping] = None,
        paginationStoryQuery: scala.Option[String] = None,
        paginationStoryFilterSettings: scala.Option[DocumentFilterSettings] =
          None,
        paginationStoryDirection: scala.Option[SortDirection] = None,
        paginationStorySortField: scala.Option[DocumentSorting] = None,
        paginationStoryExtraSettings: ExtraSettings,
        paginationResearchMapLimit: scala.Option[Int] = None,
        paginationResearchMapOffset: scala.Option[Int] = None,
        paginationResearchMapFilterSettings: ResearchMapFilterSettings,
        paginationResearchMapDirection: scala.Option[SortDirection] = None,
        paginationResearchMapSortField: scala.Option[ResearchMapSorting] = None,
        paginationResearchMapResearchMapContentSelectInput: scala.Option[
          ResearchMapContentUpdateInput
        ] = None
    )

    type ViewSelection[
        ListNodeSelection,
        ListEdgeSelection,
        ResearchMapStatisticsSelection,
        ListGroupSelection,
        AccessLevelSelection,
        PaginationConceptSelection,
        PaginationStorySelection,
        PaginationResearchMapSelection,
        CreatorSelection,
        LastUpdaterSelection
    ] = SelectionBuilder[ResearchMap, ResearchMapView[
      ListNodeSelection,
      ListEdgeSelection,
      ResearchMapStatisticsSelection,
      ListGroupSelection,
      AccessLevelSelection,
      PaginationConceptSelection,
      PaginationStorySelection,
      PaginationResearchMapSelection,
      CreatorSelection,
      LastUpdaterSelection
    ]]

    def view[
        ListNodeSelection,
        ListEdgeSelection,
        ResearchMapStatisticsSelection,
        ListGroupSelection,
        AccessLevelSelection,
        PaginationConceptSelection,
        PaginationStorySelection,
        PaginationResearchMapSelection,
        CreatorSelection,
        LastUpdaterSelection
    ](args: ResearchMapViewArgs)(
        listNodeSelection: SelectionBuilder[MapNode, ListNodeSelection],
        listEdgeSelection: SelectionBuilder[MapEdge, ListEdgeSelection],
        researchMapStatisticsSelection: SelectionBuilder[
          ResearchMapStatistics,
          ResearchMapStatisticsSelection
        ],
        listGroupSelection: SelectionBuilder[Group, ListGroupSelection],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ],
        paginationConceptSelection: SelectionBuilder[
          ConceptPagination,
          PaginationConceptSelection
        ],
        paginationStorySelection: SelectionBuilder[
          StoryPagination,
          PaginationStorySelection
        ],
        paginationResearchMapSelection: SelectionBuilder[
          ResearchMapPagination,
          PaginationResearchMapSelection
        ],
        creatorSelection: SelectionBuilder[User, CreatorSelection],
        lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
    ): ViewSelection[
      ListNodeSelection,
      ListEdgeSelection,
      ResearchMapStatisticsSelection,
      ListGroupSelection,
      AccessLevelSelection,
      PaginationConceptSelection,
      PaginationStorySelection,
      PaginationResearchMapSelection,
      CreatorSelection,
      LastUpdaterSelection
    ] =
      (id ~ name ~ systemRegistrationDate ~ systemUpdateDate ~ description ~ isTemporary ~ markers ~ listNode(
        args.listNodeFilterSettings,
        args.listNodeDefaultView
      )(listNodeSelection) ~ listEdge(
        args.listEdgeFilterSettings,
        args.listEdgeDefaultView
      )(listEdgeSelection) ~ researchMapStatistics(
        researchMapStatisticsSelection
      ) ~ listGroup(listGroupSelection) ~ isActive ~ accessLevel(
        accessLevelSelection
      ) ~ paginationConcept(
        args.paginationConceptLimit,
        args.paginationConceptOffset,
        args.paginationConceptQuery,
        args.paginationConceptFilterSettings,
        args.paginationConceptDirection,
        args.paginationConceptSortField,
        args.paginationConceptExtraSettings
      )(paginationConceptSelection) ~ paginationStory(
        args.paginationStoryLimit,
        args.paginationStoryOffset,
        args.paginationStoryGrouping,
        args.paginationStoryQuery,
        args.paginationStoryFilterSettings,
        args.paginationStoryDirection,
        args.paginationStorySortField,
        args.paginationStoryExtraSettings
      )(paginationStorySelection) ~ paginationResearchMap(
        args.paginationResearchMapLimit,
        args.paginationResearchMapOffset,
        args.paginationResearchMapFilterSettings,
        args.paginationResearchMapDirection,
        args.paginationResearchMapSortField,
        args.paginationResearchMapResearchMapContentSelectInput
      )(paginationResearchMapSelection) ~ creator(
        creatorSelection
      ) ~ lastUpdater(lastUpdaterSelection)).map {
        case (
              id,
              name,
              systemRegistrationDate,
              systemUpdateDate,
              description,
              isTemporary,
              markers,
              listNode,
              listEdge,
              researchMapStatistics,
              listGroup,
              isActive,
              accessLevel,
              paginationConcept,
              paginationStory,
              paginationResearchMap,
              creator,
              lastUpdater
            ) =>
          ResearchMapView(
            id,
            name,
            systemRegistrationDate,
            systemUpdateDate,
            description,
            isTemporary,
            markers,
            listNode,
            listEdge,
            researchMapStatistics,
            listGroup,
            isActive,
            accessLevel,
            paginationConcept,
            paginationStory,
            paginationResearchMap,
            creator,
            lastUpdater
          )
      }

    def id: SelectionBuilder[ResearchMap, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[ResearchMap, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
    def systemRegistrationDate: SelectionBuilder[ResearchMap, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate
        : SelectionBuilder[ResearchMap, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def description: SelectionBuilder[ResearchMap, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))
    def isTemporary: SelectionBuilder[ResearchMap, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isTemporary", Scalar())
    def markers: SelectionBuilder[ResearchMap, List[String]] =
      _root_.caliban.client.SelectionBuilder.Field("markers", ListOf(Scalar()))
    def listNode[A](
        filterSettings: scala.Option[MapNodeFilterSettings] = None,
        defaultView: scala.Option[Boolean] = None
    )(innerSelection: SelectionBuilder[MapNode, A])(implicit
        encoder0: ArgEncoder[scala.Option[MapNodeFilterSettings]],
        encoder1: ArgEncoder[scala.Option[Boolean]]
    ): SelectionBuilder[ResearchMap, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listNode",
        ListOf(Obj(innerSelection)),
        arguments = List(
          Argument("filterSettings", filterSettings, "MapNodeFilterSettings")(
            encoder0
          ),
          Argument("defaultView", defaultView, "Boolean")(encoder1)
        )
      )
    def listEdge[A](
        filterSettings: scala.Option[MapEdgeFilterSettings] = None,
        defaultView: scala.Option[Boolean] = None
    )(innerSelection: SelectionBuilder[MapEdge, A])(implicit
        encoder0: ArgEncoder[scala.Option[MapEdgeFilterSettings]],
        encoder1: ArgEncoder[scala.Option[Boolean]]
    ): SelectionBuilder[ResearchMap, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listEdge",
        ListOf(Obj(innerSelection)),
        arguments = List(
          Argument("filterSettings", filterSettings, "MapEdgeFilterSettings")(
            encoder0
          ),
          Argument("defaultView", defaultView, "Boolean")(encoder1)
        )
      )
    def researchMapStatistics[A](
        innerSelection: SelectionBuilder[ResearchMapStatistics, A]
    ): SelectionBuilder[ResearchMap, A] = _root_.caliban.client.SelectionBuilder
      .Field("researchMapStatistics", Obj(innerSelection))
    def listGroup[A](
        innerSelection: SelectionBuilder[Group, A]
    ): SelectionBuilder[ResearchMap, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listGroup", ListOf(Obj(innerSelection)))
    def isActive: SelectionBuilder[ResearchMap, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isActive", Scalar())
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[ResearchMap, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
    def paginationConcept[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        query: scala.Option[String] = None,
        filterSettings: scala.Option[ConceptFilterSettings] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptSorting] = None,
        extraSettings: ConceptExtraSettings
    )(innerSelection: SelectionBuilder[ConceptPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[String]],
        encoder3: ArgEncoder[scala.Option[ConceptFilterSettings]],
        encoder4: ArgEncoder[scala.Option[SortDirection]],
        encoder5: ArgEncoder[scala.Option[ConceptSorting]],
        encoder6: ArgEncoder[ConceptExtraSettings]
    ): SelectionBuilder[ResearchMap, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("query", query, "String")(encoder2),
          Argument("filterSettings", filterSettings, "ConceptFilterSettings")(
            encoder3
          ),
          Argument("direction", direction, "SortDirection")(encoder4),
          Argument("sortField", sortField, "ConceptSorting")(encoder5),
          Argument("extraSettings", extraSettings, "ConceptExtraSettings!")(
            encoder6
          )
        )
      )
    def paginationStory[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        grouping: scala.Option[DocumentGrouping] = None,
        query: scala.Option[String] = None,
        filterSettings: scala.Option[DocumentFilterSettings] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[DocumentSorting] = None,
        extraSettings: ExtraSettings
    )(innerSelection: SelectionBuilder[StoryPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[DocumentGrouping]],
        encoder3: ArgEncoder[scala.Option[String]],
        encoder4: ArgEncoder[scala.Option[DocumentFilterSettings]],
        encoder5: ArgEncoder[scala.Option[SortDirection]],
        encoder6: ArgEncoder[scala.Option[DocumentSorting]],
        encoder7: ArgEncoder[ExtraSettings]
    ): SelectionBuilder[ResearchMap, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationStory",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("grouping", grouping, "DocumentGrouping")(encoder2),
          Argument("query", query, "String")(encoder3),
          Argument("filterSettings", filterSettings, "DocumentFilterSettings")(
            encoder4
          ),
          Argument("direction", direction, "SortDirection")(encoder5),
          Argument("sortField", sortField, "DocumentSorting")(encoder6),
          Argument("extraSettings", extraSettings, "ExtraSettings!")(encoder7)
        )
      )
    def paginationResearchMap[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ResearchMapFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ResearchMapSorting] = None,
        ResearchMapContentSelectInput: scala.Option[
          ResearchMapContentUpdateInput
        ] = None
    )(innerSelection: SelectionBuilder[ResearchMapPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ResearchMapFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ResearchMapSorting]],
        encoder5: ArgEncoder[scala.Option[ResearchMapContentUpdateInput]]
    ): SelectionBuilder[ResearchMap, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationResearchMap",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ResearchMapFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ResearchMapSorting")(encoder4),
          Argument(
            "ResearchMapContentSelectInput",
            ResearchMapContentSelectInput,
            "ResearchMapContentUpdateInput"
          )(encoder5)
        )
      )
    def creator[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ResearchMap, A] = _root_.caliban.client.SelectionBuilder
      .Field("creator", Obj(innerSelection))
    def lastUpdater[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ResearchMap, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lastUpdater", OptionOf(Obj(innerSelection)))
  }

  type ResearchMapChangedEvent
  object ResearchMapChangedEvent {

    final case class ResearchMapChangedEventView[ResearchMapSelection](
        eventName: String,
        researchMap: ResearchMapSelection
    )

    type ViewSelection[ResearchMapSelection] =
      SelectionBuilder[ResearchMapChangedEvent, ResearchMapChangedEventView[
        ResearchMapSelection
      ]]

    def view[ResearchMapSelection](
        researchMapSelection: SelectionBuilder[
          ResearchMap,
          ResearchMapSelection
        ]
    ): ViewSelection[ResearchMapSelection] =
      (eventName ~ researchMap(researchMapSelection)).map {
        case (eventName, researchMap) =>
          ResearchMapChangedEventView(eventName, researchMap)
      }

    def eventName: SelectionBuilder[ResearchMapChangedEvent, String] =
      _root_.caliban.client.SelectionBuilder.Field("eventName", Scalar())
    def researchMap[A](
        innerSelection: SelectionBuilder[ResearchMap, A]
    ): SelectionBuilder[ResearchMapChangedEvent, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("researchMap", Obj(innerSelection))
  }

  type ResearchMapFromFilesType
  object ResearchMapFromFilesType {

    final case class ResearchMapFromFilesTypeView[
        ResearchMapsSelection,
        InfoSelection
    ](
        researchMaps: List[ResearchMapsSelection],
        info: List[scala.Option[InfoSelection]]
    )

    type ViewSelection[ResearchMapsSelection, InfoSelection] = SelectionBuilder[
      ResearchMapFromFilesType,
      ResearchMapFromFilesTypeView[ResearchMapsSelection, InfoSelection]
    ]

    def view[ResearchMapsSelection, InfoSelection](
        researchMapsSelection: SelectionBuilder[
          ResearchMap,
          ResearchMapsSelection
        ],
        infoSelection: SelectionBuilder[State, InfoSelection]
    ): ViewSelection[ResearchMapsSelection, InfoSelection] =
      (researchMaps(researchMapsSelection) ~ info(infoSelection)).map {
        case (researchMaps, info) =>
          ResearchMapFromFilesTypeView(researchMaps, info)
      }

    def researchMaps[A](
        innerSelection: SelectionBuilder[ResearchMap, A]
    ): SelectionBuilder[ResearchMapFromFilesType, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("researchMaps", ListOf(Obj(innerSelection)))
    def info[A](
        innerSelection: SelectionBuilder[State, A]
    ): SelectionBuilder[ResearchMapFromFilesType, List[scala.Option[A]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("info", ListOf(OptionOf(Obj(innerSelection))))
  }

  type ResearchMapPagination
  object ResearchMapPagination {

    final case class ResearchMapPaginationView[ListResearchMapSelection](
        total: Int,
        listResearchMap: List[ListResearchMapSelection]
    )

    type ViewSelection[ListResearchMapSelection] =
      SelectionBuilder[ResearchMapPagination, ResearchMapPaginationView[
        ListResearchMapSelection
      ]]

    def view[ListResearchMapSelection](
        listResearchMapSelection: SelectionBuilder[
          ResearchMap,
          ListResearchMapSelection
        ]
    ): ViewSelection[ListResearchMapSelection] =
      (total ~ listResearchMap(listResearchMapSelection)).map {
        case (total, listResearchMap) =>
          ResearchMapPaginationView(total, listResearchMap)
      }

    def total: SelectionBuilder[ResearchMapPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def listResearchMap[A](
        innerSelection: SelectionBuilder[ResearchMap, A]
    ): SelectionBuilder[ResearchMapPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listResearchMap", ListOf(Obj(innerSelection)))
  }

  type ResearchMapStatistics
  object ResearchMapStatistics {

    final case class ResearchMapStatisticsView(
        objectNum: Int,
        eventNum: Int,
        documentNum: Int,
        conceptNum: Int,
        conceptAndDocumentNum: Int
    )

    type ViewSelection =
      SelectionBuilder[ResearchMapStatistics, ResearchMapStatisticsView]

    def view: ViewSelection =
      (objectNum ~ eventNum ~ documentNum ~ conceptNum ~ conceptAndDocumentNum)
        .map {
          case (
                objectNum,
                eventNum,
                documentNum,
                conceptNum,
                conceptAndDocumentNum
              ) =>
            ResearchMapStatisticsView(
              objectNum,
              eventNum,
              documentNum,
              conceptNum,
              conceptAndDocumentNum
            )
        }

    def objectNum: SelectionBuilder[ResearchMapStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("objectNum", Scalar())
    def eventNum: SelectionBuilder[ResearchMapStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("eventNum", Scalar())
    def documentNum: SelectionBuilder[ResearchMapStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("documentNum", Scalar())
    def conceptNum: SelectionBuilder[ResearchMapStatistics, Int] =
      _root_.caliban.client.SelectionBuilder.Field("conceptNum", Scalar())
    def conceptAndDocumentNum: SelectionBuilder[ResearchMapStatistics, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptAndDocumentNum", Scalar())
  }

  type State
  object State {

    final case class StateView(isSuccess: Boolean)

    type ViewSelection = SelectionBuilder[State, StateView]

    def view: ViewSelection = isSuccess.map(isSuccess => StateView(isSuccess))

    def isSuccess: SelectionBuilder[State, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isSuccess", Scalar())
  }

  type Story
  object Story {

    final case class StoryView[
        MainSelection,
        ListDocumentSelection,
        HighlightingSelection,
        AccessLevelSelection
    ](
        id: String,
        title: scala.Option[String],
        systemRegistrationDate: UnixTime,
        systemUpdateDate: scala.Option[UnixTime],
        main: MainSelection,
        listDocument: List[ListDocumentSelection],
        highlighting: scala.Option[HighlightingSelection],
        countDoc: Int,
        preview: String,
        accessLevel: AccessLevelSelection
    )

    type ViewSelection[
        MainSelection,
        ListDocumentSelection,
        HighlightingSelection,
        AccessLevelSelection
    ] = SelectionBuilder[Story, StoryView[
      MainSelection,
      ListDocumentSelection,
      HighlightingSelection,
      AccessLevelSelection
    ]]

    def view[
        MainSelection,
        ListDocumentSelection,
        HighlightingSelection,
        AccessLevelSelection
    ](
        mainSelection: SelectionBuilder[Document, MainSelection],
        listDocumentSelection: SelectionBuilder[
          Document,
          ListDocumentSelection
        ],
        highlightingSelection: SelectionBuilder[
          Highlighting,
          HighlightingSelection
        ],
        accessLevelSelection: SelectionBuilder[
          AccessLevel,
          AccessLevelSelection
        ]
    ): ViewSelection[
      MainSelection,
      ListDocumentSelection,
      HighlightingSelection,
      AccessLevelSelection
    ] = (id ~ title ~ systemRegistrationDate ~ systemUpdateDate ~ main(
      mainSelection
    ) ~ listDocument(listDocumentSelection) ~ highlighting(
      highlightingSelection
    ) ~ countDoc ~ preview ~ accessLevel(accessLevelSelection)).map {
      case (
            id,
            title,
            systemRegistrationDate,
            systemUpdateDate,
            main,
            listDocument,
            highlighting,
            countDoc,
            preview,
            accessLevel
          ) =>
        StoryView(
          id,
          title,
          systemRegistrationDate,
          systemUpdateDate,
          main,
          listDocument,
          highlighting,
          countDoc,
          preview,
          accessLevel
        )
    }

    def id: SelectionBuilder[Story, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def title: SelectionBuilder[Story, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("title", OptionOf(Scalar()))
    def systemRegistrationDate: SelectionBuilder[Story, UnixTime] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemRegistrationDate", Scalar())
    def systemUpdateDate: SelectionBuilder[Story, scala.Option[UnixTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("systemUpdateDate", OptionOf(Scalar()))
    def main[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[Story, A] =
      _root_.caliban.client.SelectionBuilder.Field("main", Obj(innerSelection))
    def listDocument[A](
        innerSelection: SelectionBuilder[Document, A]
    ): SelectionBuilder[Story, List[A]] = _root_.caliban.client.SelectionBuilder
      .Field("listDocument", ListOf(Obj(innerSelection)))
    def highlighting[A](
        innerSelection: SelectionBuilder[Highlighting, A]
    ): SelectionBuilder[Story, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("highlighting", OptionOf(Obj(innerSelection)))
    def countDoc: SelectionBuilder[Story, Int] =
      _root_.caliban.client.SelectionBuilder.Field("countDoc", Scalar())
    def preview: SelectionBuilder[Story, String] =
      _root_.caliban.client.SelectionBuilder.Field("preview", Scalar())
    def accessLevel[A](
        innerSelection: SelectionBuilder[AccessLevel, A]
    ): SelectionBuilder[Story, A] = _root_.caliban.client.SelectionBuilder
      .Field("accessLevel", Obj(innerSelection))
  }

  type StoryPagination
  object StoryPagination {

    final case class StoryPaginationView[
        ListStorySelection,
        ListNamedEntityCountFacetSelection,
        ListConceptCountFacetSelection,
        ListAccountCountFacetSelection,
        ListPlatformCountFacetSelection,
        ListMarkersSelection
    ](
        listStory: List[ListStorySelection],
        total: Int,
        showTotal: Int,
        listNamedEntityCountFacet: List[ListNamedEntityCountFacetSelection],
        listConceptCountFacet: List[ListConceptCountFacetSelection],
        listAccountCountFacet: List[ListAccountCountFacetSelection],
        listPlatformCountFacet: List[ListPlatformCountFacetSelection],
        listMarkers: List[ListMarkersSelection],
        sources: Int,
        newDocumentsToday: Int
    )

    type ViewSelection[
        ListStorySelection,
        ListNamedEntityCountFacetSelection,
        ListConceptCountFacetSelection,
        ListAccountCountFacetSelection,
        ListPlatformCountFacetSelection,
        ListMarkersSelection
    ] = SelectionBuilder[StoryPagination, StoryPaginationView[
      ListStorySelection,
      ListNamedEntityCountFacetSelection,
      ListConceptCountFacetSelection,
      ListAccountCountFacetSelection,
      ListPlatformCountFacetSelection,
      ListMarkersSelection
    ]]

    def view[
        ListStorySelection,
        ListNamedEntityCountFacetSelection,
        ListConceptCountFacetSelection,
        ListAccountCountFacetSelection,
        ListPlatformCountFacetSelection,
        ListMarkersSelection
    ](
        listStorySelection: SelectionBuilder[Story, ListStorySelection],
        listNamedEntityCountFacetSelection: SelectionBuilder[
          Facet,
          ListNamedEntityCountFacetSelection
        ],
        listConceptCountFacetSelection: SelectionBuilder[
          Facet,
          ListConceptCountFacetSelection
        ],
        listAccountCountFacetSelection: SelectionBuilder[
          AccountFacet,
          ListAccountCountFacetSelection
        ],
        listPlatformCountFacetSelection: SelectionBuilder[
          PlatformFacet,
          ListPlatformCountFacetSelection
        ],
        listMarkersSelection: SelectionBuilder[Facet, ListMarkersSelection]
    ): ViewSelection[
      ListStorySelection,
      ListNamedEntityCountFacetSelection,
      ListConceptCountFacetSelection,
      ListAccountCountFacetSelection,
      ListPlatformCountFacetSelection,
      ListMarkersSelection
    ] = (listStory(
      listStorySelection
    ) ~ total ~ showTotal ~ listNamedEntityCountFacet(
      listNamedEntityCountFacetSelection
    ) ~ listConceptCountFacet(
      listConceptCountFacetSelection
    ) ~ listAccountCountFacet(
      listAccountCountFacetSelection
    ) ~ listPlatformCountFacet(listPlatformCountFacetSelection) ~ listMarkers(
      listMarkersSelection
    ) ~ sources ~ newDocumentsToday).map {
      case (
            listStory,
            total,
            showTotal,
            listNamedEntityCountFacet,
            listConceptCountFacet,
            listAccountCountFacet,
            listPlatformCountFacet,
            listMarkers,
            sources,
            newDocumentsToday
          ) =>
        StoryPaginationView(
          listStory,
          total,
          showTotal,
          listNamedEntityCountFacet,
          listConceptCountFacet,
          listAccountCountFacet,
          listPlatformCountFacet,
          listMarkers,
          sources,
          newDocumentsToday
        )
    }

    def listStory[A](
        innerSelection: SelectionBuilder[Story, A]
    ): SelectionBuilder[StoryPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listStory", ListOf(Obj(innerSelection)))
    def total: SelectionBuilder[StoryPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    def showTotal: SelectionBuilder[StoryPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("showTotal", Scalar())
    def listNamedEntityCountFacet[A](
        innerSelection: SelectionBuilder[Facet, A]
    ): SelectionBuilder[StoryPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listNamedEntityCountFacet", ListOf(Obj(innerSelection)))
    def listConceptCountFacet[A](
        innerSelection: SelectionBuilder[Facet, A]
    ): SelectionBuilder[StoryPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptCountFacet", ListOf(Obj(innerSelection)))
    def listAccountCountFacet[A](
        innerSelection: SelectionBuilder[AccountFacet, A]
    ): SelectionBuilder[StoryPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listAccountCountFacet", ListOf(Obj(innerSelection)))
    def listPlatformCountFacet[A](
        innerSelection: SelectionBuilder[PlatformFacet, A]
    ): SelectionBuilder[StoryPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listPlatformCountFacet", ListOf(Obj(innerSelection)))
    def listMarkers[A](
        innerSelection: SelectionBuilder[Facet, A]
    ): SelectionBuilder[StoryPagination, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listMarkers", ListOf(Obj(innerSelection)))
    def sources: SelectionBuilder[StoryPagination, Int] =
      _root_.caliban.client.SelectionBuilder.Field("sources", Scalar())
    def newDocumentsToday: SelectionBuilder[StoryPagination, Int] =
      _root_.caliban.client.SelectionBuilder
        .Field("newDocumentsToday", Scalar())
  }

  type StringLocaleValue
  object StringLocaleValue {

    final case class StringLocaleValueView(value: String, locale: Locale)

    type ViewSelection =
      SelectionBuilder[StringLocaleValue, StringLocaleValueView]

    def view: ViewSelection = (value ~ locale).map { case (value, locale) =>
      StringLocaleValueView(value, locale)
    }

    def value: SelectionBuilder[StringLocaleValue, String] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
    def locale: SelectionBuilder[StringLocaleValue, Locale] =
      _root_.caliban.client.SelectionBuilder.Field("locale", Scalar())
  }

  type StringValue
  object StringValue {

    final case class StringValueView(value: String)

    type ViewSelection = SelectionBuilder[StringValue, StringValueView]

    def view: ViewSelection = value.map(value => StringValueView(value))

    def value: SelectionBuilder[StringValue, String] =
      _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
  }

  type Table
  object Table {

    final case class TableView[MetadataSelection](
        cells: List[List[String]],
        metadata: MetadataSelection
    )

    type ViewSelection[MetadataSelection] =
      SelectionBuilder[Table, TableView[MetadataSelection]]

    def view[MetadataSelection](
        metadataSelection: SelectionBuilder[TableMetadata, MetadataSelection]
    ): ViewSelection[MetadataSelection] =
      (cells ~ metadata(metadataSelection)).map { case (cells, metadata) =>
        TableView(cells, metadata)
      }

    def cells: SelectionBuilder[Table, List[List[String]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cells", ListOf(ListOf(Scalar())))
    def metadata[A](
        innerSelection: SelectionBuilder[TableMetadata, A]
    ): SelectionBuilder[Table, A] = _root_.caliban.client.SelectionBuilder
      .Field("metadata", Obj(innerSelection))
  }

  type TableMetadata
  object TableMetadata {

    final case class TableMetadataView(pageId: scala.Option[Int])

    type ViewSelection = SelectionBuilder[TableMetadata, TableMetadataView]

    def view: ViewSelection = pageId.map(pageId => TableMetadataView(pageId))

    def pageId: SelectionBuilder[TableMetadata, scala.Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("pageId", OptionOf(Scalar()))
  }

  type TextBounding
  object TextBounding {

    final case class TextBoundingView(start: Int, end: Int, nodeId: String)

    type ViewSelection = SelectionBuilder[TextBounding, TextBoundingView]

    def view: ViewSelection = (start ~ end ~ nodeId).map {
      case (start, end, nodeId) => TextBoundingView(start, end, nodeId)
    }

    def start: SelectionBuilder[TextBounding, Int] =
      _root_.caliban.client.SelectionBuilder.Field("start", Scalar())
    def end: SelectionBuilder[TextBounding, Int] =
      _root_.caliban.client.SelectionBuilder.Field("end", Scalar())
    def nodeId: SelectionBuilder[TextBounding, String] =
      _root_.caliban.client.SelectionBuilder.Field("nodeId", Scalar())
  }

  type Time
  object Time {

    final case class TimeView(hour: Int, minute: Int, second: Int)

    type ViewSelection = SelectionBuilder[Time, TimeView]

    def view: ViewSelection = (hour ~ minute ~ second).map {
      case (hour, minute, second) => TimeView(hour, minute, second)
    }

    def hour: SelectionBuilder[Time, Int] =
      _root_.caliban.client.SelectionBuilder.Field("hour", Scalar())
    def minute: SelectionBuilder[Time, Int] =
      _root_.caliban.client.SelectionBuilder.Field("minute", Scalar())
    def second: SelectionBuilder[Time, Int] =
      _root_.caliban.client.SelectionBuilder.Field("second", Scalar())
  }

  type Translation
  object Translation {

    final case class TranslationView[LanguageSelection](
        text: String,
        language: LanguageSelection
    )

    type ViewSelection[LanguageSelection] =
      SelectionBuilder[Translation, TranslationView[LanguageSelection]]

    def view[LanguageSelection](
        languageSelection: SelectionBuilder[Language, LanguageSelection]
    ): ViewSelection[LanguageSelection] =
      (text ~ language(languageSelection)).map { case (text, language) =>
        TranslationView(text, language)
      }

    def text: SelectionBuilder[Translation, String] =
      _root_.caliban.client.SelectionBuilder.Field("text", Scalar())
    def language[A](
        innerSelection: SelectionBuilder[Language, A]
    ): SelectionBuilder[Translation, A] = _root_.caliban.client.SelectionBuilder
      .Field("language", Obj(innerSelection))
  }

  type User
  object User {

    final case class UserView(id: String)

    type ViewSelection = SelectionBuilder[User, UserView]

    def view: ViewSelection = id.map(id => UserView(id))

    def id: SelectionBuilder[User, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  final case class AccessLevelCreationInput(
      name: String,
      order: scala.Option[Long] = None
  )
  object AccessLevelCreationInput {
    implicit val encoder: ArgEncoder[AccessLevelCreationInput] =
      new ArgEncoder[AccessLevelCreationInput] {
        override def encode(value: AccessLevelCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "order" -> value.order.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Long]].encode(value)
              )
            )
          )
      }
  }
  final case class AccessLevelUpdateInput(name: String)
  object AccessLevelUpdateInput {
    implicit val encoder: ArgEncoder[AccessLevelUpdateInput] =
      new ArgEncoder[AccessLevelUpdateInput] {
        override def encode(value: AccessLevelUpdateInput): __Value =
          __ObjectValue(
            List("name" -> implicitly[ArgEncoder[String]].encode(value.name))
          )
      }
  }
  final case class AccountCreationInput(
      platformId: String,
      name: String,
      id: String,
      url: String,
      country: scala.Option[String] = None,
      markers: scala.Option[List[String]] = None,
      params: scala.Option[List[ParameterInput]] = None
  )
  object AccountCreationInput {
    implicit val encoder: ArgEncoder[AccountCreationInput] =
      new ArgEncoder[AccountCreationInput] {
        override def encode(value: AccountCreationInput): __Value =
          __ObjectValue(
            List(
              "platformId" -> implicitly[ArgEncoder[String]]
                .encode(value.platformId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "url" -> implicitly[ArgEncoder[String]].encode(value.url),
              "country" -> value.country.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "params" -> value.params.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ParameterInput]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class AccountFilterSettings(
      searchString: scala.Option[String] = None,
      platformId: scala.Option[List[String]] = None,
      id: scala.Option[List[String]] = None,
      country: scala.Option[List[String]] = None,
      markers: scala.Option[List[String]] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object AccountFilterSettings {
    implicit val encoder: ArgEncoder[AccountFilterSettings] =
      new ArgEncoder[AccountFilterSettings] {
        override def encode(value: AccountFilterSettings): __Value =
          __ObjectValue(
            List(
              "searchString" -> value.searchString.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "platformId" -> value.platformId.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "country" -> value.country.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class AccountUpdateInput(
      accountId: String,
      platformId: String,
      name: String,
      newId: String,
      url: String,
      country: scala.Option[String] = None,
      markers: List[String] = Nil,
      params: List[ParameterInput] = Nil
  )
  object AccountUpdateInput {
    implicit val encoder: ArgEncoder[AccountUpdateInput] =
      new ArgEncoder[AccountUpdateInput] {
        override def encode(value: AccountUpdateInput): __Value =
          __ObjectValue(
            List(
              "accountId" -> implicitly[ArgEncoder[String]]
                .encode(value.accountId),
              "platformId" -> implicitly[ArgEncoder[String]]
                .encode(value.platformId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "newId" -> implicitly[ArgEncoder[String]].encode(value.newId),
              "url" -> implicitly[ArgEncoder[String]].encode(value.url),
              "country" -> value.country.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "markers" -> __ListValue(
                value.markers.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "params" -> __ListValue(
                value.params.map(value =>
                  implicitly[ArgEncoder[ParameterInput]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class BulkMarkersInput(ids: List[String] = Nil, bulkType: BulkType)
  object BulkMarkersInput {
    implicit val encoder: ArgEncoder[BulkMarkersInput] =
      new ArgEncoder[BulkMarkersInput] {
        override def encode(value: BulkMarkersInput): __Value =
          __ObjectValue(
            List(
              "ids" -> __ListValue(
                value.ids.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "bulkType" -> implicitly[ArgEncoder[BulkType]].encode(
                value.bulkType
              )
            )
          )
      }
  }
  final case class BulkMarkersUpdateInput(
      ids: List[String] = Nil,
      bulkType: BulkType,
      markersToDelete: List[String] = Nil,
      markersToAdd: List[String] = Nil
  )
  object BulkMarkersUpdateInput {
    implicit val encoder: ArgEncoder[BulkMarkersUpdateInput] =
      new ArgEncoder[BulkMarkersUpdateInput] {
        override def encode(value: BulkMarkersUpdateInput): __Value =
          __ObjectValue(
            List(
              "ids" -> __ListValue(
                value.ids.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "bulkType" -> implicitly[ArgEncoder[BulkType]]
                .encode(value.bulkType),
              "markersToDelete" -> __ListValue(
                value.markersToDelete.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "markersToAdd" -> __ListValue(
                value.markersToAdd.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class ChartDescriptionInput(
      chartType: ChartType,
      target: ChartTarget,
      query: String,
      aggregationField: String,
      aggregationFunction: scala.Option[AggregationFunction] = None,
      outputLimiter: OutputLimiterInput
  )
  object ChartDescriptionInput {
    implicit val encoder: ArgEncoder[ChartDescriptionInput] =
      new ArgEncoder[ChartDescriptionInput] {
        override def encode(value: ChartDescriptionInput): __Value =
          __ObjectValue(
            List(
              "chartType" -> implicitly[ArgEncoder[ChartType]]
                .encode(value.chartType),
              "target" -> implicitly[ArgEncoder[ChartTarget]]
                .encode(value.target),
              "query" -> implicitly[ArgEncoder[String]].encode(value.query),
              "aggregationField" -> implicitly[ArgEncoder[String]]
                .encode(value.aggregationField),
              "aggregationFunction" -> value.aggregationFunction.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[AggregationFunction]].encode(value)
              ),
              "outputLimiter" -> implicitly[ArgEncoder[OutputLimiterInput]]
                .encode(value.outputLimiter)
            )
          )
      }
  }
  final case class Comment2IssueInput(idIssue: String, comment: String)
  object Comment2IssueInput {
    implicit val encoder: ArgEncoder[Comment2IssueInput] =
      new ArgEncoder[Comment2IssueInput] {
        override def encode(value: Comment2IssueInput): __Value =
          __ObjectValue(
            List(
              "idIssue" -> implicitly[ArgEncoder[String]].encode(value.idIssue),
              "comment" -> implicitly[ArgEncoder[String]].encode(value.comment)
            )
          )
      }
  }
  final case class ComponentValueInput(
      id: scala.Option[String] = None,
      value: ValueInput
  )
  object ComponentValueInput {
    implicit val encoder: ArgEncoder[ComponentValueInput] =
      new ArgEncoder[ComponentValueInput] {
        override def encode(value: ComponentValueInput): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "value" -> implicitly[ArgEncoder[ValueInput]].encode(value.value)
            )
          )
      }
  }
  final case class CompositeConceptFilterSettings(
      propertyFilterSettings: scala.Option[List[PropertyFilterSettings]] = None,
      linkFilterSettings: scala.Option[List[LinkFilterSettings]] = None,
      conceptVariant: scala.Option[List[ConceptVariant]] = None,
      name: scala.Option[String] = None,
      exactName: scala.Option[String] = None,
      substring: scala.Option[String] = None,
      accessLevelId: scala.Option[String] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      creationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      markers: scala.Option[List[String]] = None,
      hasLinkedIssues: scala.Option[Boolean] = None,
      compositeConceptTypeIds: List[String] = Nil
  )
  object CompositeConceptFilterSettings {
    implicit val encoder: ArgEncoder[CompositeConceptFilterSettings] =
      new ArgEncoder[CompositeConceptFilterSettings] {
        override def encode(value: CompositeConceptFilterSettings): __Value =
          __ObjectValue(
            List(
              "propertyFilterSettings" -> value.propertyFilterSettings.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[PropertyFilterSettings]].encode(value)
                  )
                )
              ),
              "linkFilterSettings" -> value.linkFilterSettings.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[LinkFilterSettings]].encode(value)
                  )
                )
              ),
              "conceptVariant" -> value.conceptVariant.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptVariant]].encode(value)
                  )
                )
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "exactName" -> value.exactName.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "substring" -> value.substring.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "creationDate" -> value.creationDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "hasLinkedIssues" -> value.hasLinkedIssues.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "compositeConceptTypeIds" -> __ListValue(
                value.compositeConceptTypeIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeCreationInput(
      name: String,
      rootConceptTypeId: String,
      isDefault: scala.Option[Boolean] = None,
      layout: scala.Option[String] = None,
      hasSupportingDocuments: scala.Option[Boolean] = None,
      hasHeaderInformation: scala.Option[Boolean] = None,
      showInMenu: scala.Option[Boolean] = None
  )
  object CompositeConceptTypeCreationInput {
    implicit val encoder: ArgEncoder[CompositeConceptTypeCreationInput] =
      new ArgEncoder[CompositeConceptTypeCreationInput] {
        override def encode(value: CompositeConceptTypeCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "rootConceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.rootConceptTypeId),
              "isDefault" -> value.isDefault.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "layout" -> value.layout.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "hasSupportingDocuments" -> value.hasSupportingDocuments.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "hasHeaderInformation" -> value.hasHeaderInformation.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "showInMenu" -> value.showInMenu.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeFilterSettings(
      name: scala.Option[String] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object CompositeConceptTypeFilterSettings {
    implicit val encoder: ArgEncoder[CompositeConceptTypeFilterSettings] =
      new ArgEncoder[CompositeConceptTypeFilterSettings] {
        override def encode(
            value: CompositeConceptTypeFilterSettings
        ): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeUpdateInput(
      id: String,
      name: String,
      isDefault: scala.Option[Boolean] = None,
      layout: scala.Option[String] = None,
      hasSupportingDocuments: scala.Option[Boolean] = None,
      hasHeaderInformation: scala.Option[Boolean] = None,
      showInMenu: scala.Option[Boolean] = None
  )
  object CompositeConceptTypeUpdateInput {
    implicit val encoder: ArgEncoder[CompositeConceptTypeUpdateInput] =
      new ArgEncoder[CompositeConceptTypeUpdateInput] {
        override def encode(value: CompositeConceptTypeUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "isDefault" -> value.isDefault.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "layout" -> value.layout.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "hasSupportingDocuments" -> value.hasSupportingDocuments.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "hasHeaderInformation" -> value.hasHeaderInformation.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "showInMenu" -> value.showInMenu.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeViewInput(
      conceptTypeId: String,
      compositeConceptTypeId: scala.Option[String] = None
  )
  object CompositeConceptTypeViewInput {
    implicit val encoder: ArgEncoder[CompositeConceptTypeViewInput] =
      new ArgEncoder[CompositeConceptTypeViewInput] {
        override def encode(value: CompositeConceptTypeViewInput): __Value =
          __ObjectValue(
            List(
              "conceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptTypeId),
              "compositeConceptTypeId" -> value.compositeConceptTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value))
            )
          )
      }
  }
  final case class CompositeConceptTypeWidgetTypeColumnInput(
      name: String,
      isMainProperties: scala.Option[Boolean] = None,
      listValues: scala.Option[Boolean] = None,
      conceptLinkTypeIdsPath: scala.Option[List[ConceptLinkTypePathInput]] =
        None,
      sortByColumn: scala.Option[Boolean] = None,
      sortDirection: scala.Option[SortDirection] = None,
      valueInfo: CompositeConceptTypeWidgetTypeColumnValueInfoInput
  )
  object CompositeConceptTypeWidgetTypeColumnInput {
    implicit val encoder
        : ArgEncoder[CompositeConceptTypeWidgetTypeColumnInput] =
      new ArgEncoder[CompositeConceptTypeWidgetTypeColumnInput] {
        override def encode(
            value: CompositeConceptTypeWidgetTypeColumnInput
        ): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "isMainProperties" -> value.isMainProperties.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "listValues" -> value.listValues.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "conceptLinkTypeIdsPath" -> value.conceptLinkTypeIdsPath.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptLinkTypePathInput]]
                      .encode(value)
                  )
                )
              ),
              "sortByColumn" -> value.sortByColumn.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "sortDirection" -> value.sortDirection.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[SortDirection]].encode(value)
              ),
              "valueInfo" -> implicitly[ArgEncoder[
                CompositeConceptTypeWidgetTypeColumnValueInfoInput
              ]].encode(value.valueInfo)
            )
          )
      }
  }
  final case class CompositeConceptTypeWidgetTypeColumnValueInfoInput(
      propertyTypeId: scala.Option[String] = None,
      metadata: scala.Option[ConceptTypeMetadata] = None,
      linkPropertyTypeId: scala.Option[String] = None,
      linkMetadata: scala.Option[ConceptTypeLinkMetadata] = None
  )
  object CompositeConceptTypeWidgetTypeColumnValueInfoInput {
    implicit val encoder
        : ArgEncoder[CompositeConceptTypeWidgetTypeColumnValueInfoInput] =
      new ArgEncoder[CompositeConceptTypeWidgetTypeColumnValueInfoInput] {
        override def encode(
            value: CompositeConceptTypeWidgetTypeColumnValueInfoInput
        ): __Value =
          __ObjectValue(
            List(
              "propertyTypeId" -> value.propertyTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "metadata" -> value.metadata.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[ConceptTypeMetadata]].encode(value)
              ),
              "linkPropertyTypeId" -> value.linkPropertyTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "linkMetadata" -> value.linkMetadata.fold(__NullValue: __Value)(
                value =>
                  implicitly[ArgEncoder[ConceptTypeLinkMetadata]].encode(value)
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeWidgetTypeCreationInput(
      name: String,
      tableType: WidgetTypeTableType,
      compositeConceptTypeId: String,
      columns: List[CompositeConceptTypeWidgetTypeColumnInput] = Nil
  )
  object CompositeConceptTypeWidgetTypeCreationInput {
    implicit val encoder
        : ArgEncoder[CompositeConceptTypeWidgetTypeCreationInput] =
      new ArgEncoder[CompositeConceptTypeWidgetTypeCreationInput] {
        override def encode(
            value: CompositeConceptTypeWidgetTypeCreationInput
        ): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "tableType" -> implicitly[ArgEncoder[WidgetTypeTableType]]
                .encode(value.tableType),
              "compositeConceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.compositeConceptTypeId),
              "columns" -> __ListValue(
                value.columns.map(value =>
                  implicitly[ArgEncoder[
                    CompositeConceptTypeWidgetTypeColumnInput
                  ]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeWidgetTypeUpdateInput(
      id: String,
      name: String,
      tableType: WidgetTypeTableType,
      columns: List[CompositeConceptTypeWidgetTypeColumnInput] = Nil
  )
  object CompositeConceptTypeWidgetTypeUpdateInput {
    implicit val encoder
        : ArgEncoder[CompositeConceptTypeWidgetTypeUpdateInput] =
      new ArgEncoder[CompositeConceptTypeWidgetTypeUpdateInput] {
        override def encode(
            value: CompositeConceptTypeWidgetTypeUpdateInput
        ): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "tableType" -> implicitly[ArgEncoder[WidgetTypeTableType]]
                .encode(value.tableType),
              "columns" -> __ListValue(
                value.columns.map(value =>
                  implicitly[ArgEncoder[
                    CompositeConceptTypeWidgetTypeColumnInput
                  ]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class CompositeConceptTypeWidgetTypeUpdateOrderInput(
      compositeConceptTypeId: String,
      ids: List[String] = Nil
  )
  object CompositeConceptTypeWidgetTypeUpdateOrderInput {
    implicit val encoder
        : ArgEncoder[CompositeConceptTypeWidgetTypeUpdateOrderInput] =
      new ArgEncoder[CompositeConceptTypeWidgetTypeUpdateOrderInput] {
        override def encode(
            value: CompositeConceptTypeWidgetTypeUpdateOrderInput
        ): __Value =
          __ObjectValue(
            List(
              "compositeConceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.compositeConceptTypeId),
              "ids" -> __ListValue(
                value.ids.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class CompositePropertyTypeFilterSettings(
      name: scala.Option[String] = None,
      conceptTypeId: scala.Option[String] = None,
      linkTypeId: scala.Option[String] = None
  )
  object CompositePropertyTypeFilterSettings {
    implicit val encoder: ArgEncoder[CompositePropertyTypeFilterSettings] =
      new ArgEncoder[CompositePropertyTypeFilterSettings] {
        override def encode(
            value: CompositePropertyTypeFilterSettings
        ): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "conceptTypeId" -> value.conceptTypeId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "linkTypeId" -> value.linkTypeId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class CompositePropertyValueTemplateCreateInput(
      id: scala.Option[String] = None,
      name: String,
      componentValueTypes: List[NamedValueType] = Nil
  )
  object CompositePropertyValueTemplateCreateInput {
    implicit val encoder
        : ArgEncoder[CompositePropertyValueTemplateCreateInput] =
      new ArgEncoder[CompositePropertyValueTemplateCreateInput] {
        override def encode(
            value: CompositePropertyValueTemplateCreateInput
        ): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "componentValueTypes" -> __ListValue(
                value.componentValueTypes.map(value =>
                  implicitly[ArgEncoder[NamedValueType]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class CompositePropertyValueTemplateFilterSettings(
      name: scala.Option[String] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object CompositePropertyValueTemplateFilterSettings {
    implicit val encoder
        : ArgEncoder[CompositePropertyValueTemplateFilterSettings] =
      new ArgEncoder[CompositePropertyValueTemplateFilterSettings] {
        override def encode(
            value: CompositePropertyValueTemplateFilterSettings
        ): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class Concept2IssueInput(
      idIssue: String,
      conceptIds: List[String] = Nil,
      comment: scala.Option[String] = None
  )
  object Concept2IssueInput {
    implicit val encoder: ArgEncoder[Concept2IssueInput] =
      new ArgEncoder[Concept2IssueInput] {
        override def encode(value: Concept2IssueInput): __Value =
          __ObjectValue(
            List(
              "idIssue" -> implicitly[ArgEncoder[String]].encode(value.idIssue),
              "conceptIds" -> __ListValue(
                value.conceptIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "comment" -> value.comment.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptAddImplicitLinkInput(
      firstNodeId: String,
      secondNodeId: String
  )
  object ConceptAddImplicitLinkInput {
    implicit val encoder: ArgEncoder[ConceptAddImplicitLinkInput] =
      new ArgEncoder[ConceptAddImplicitLinkInput] {
        override def encode(value: ConceptAddImplicitLinkInput): __Value =
          __ObjectValue(
            List(
              "firstNodeId" -> implicitly[ArgEncoder[String]]
                .encode(value.firstNodeId),
              "secondNodeId" -> implicitly[ArgEncoder[String]].encode(
                value.secondNodeId
              )
            )
          )
      }
  }
  final case class ConceptAddInputInput(
      conceptId: String,
      xCoordinate: scala.Option[Double] = None,
      yCoordinate: scala.Option[Double] = None,
      groupId: scala.Option[String] = None
  )
  object ConceptAddInputInput {
    implicit val encoder: ArgEncoder[ConceptAddInputInput] =
      new ArgEncoder[ConceptAddInputInput] {
        override def encode(value: ConceptAddInputInput): __Value =
          __ObjectValue(
            List(
              "conceptId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptId),
              "xCoordinate" -> value.xCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "yCoordinate" -> value.yCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "groupId" -> value.groupId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptCandidateAddInputInput(
      documentId: String,
      groupId: scala.Option[String] = None
  )
  object ConceptCandidateAddInputInput {
    implicit val encoder: ArgEncoder[ConceptCandidateAddInputInput] =
      new ArgEncoder[ConceptCandidateAddInputInput] {
        override def encode(value: ConceptCandidateAddInputInput): __Value =
          __ObjectValue(
            List(
              "documentId" -> implicitly[ArgEncoder[String]]
                .encode(value.documentId),
              "groupId" -> value.groupId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptExtraSettings(
      searchOnMap: Boolean,
      selectedContent: scala.Option[ResearchMapContentSelectInput] = None
  )
  object ConceptExtraSettings {
    implicit val encoder: ArgEncoder[ConceptExtraSettings] =
      new ArgEncoder[ConceptExtraSettings] {
        override def encode(value: ConceptExtraSettings): __Value =
          __ObjectValue(
            List(
              "searchOnMap" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.searchOnMap),
              "selectedContent" -> value.selectedContent.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[ResearchMapContentSelectInput]].encode(
                  value
                )
              )
            )
          )
      }
  }
  final case class ConceptFilterSettings(
      propertyFilterSettings: scala.Option[List[PropertyFilterSettings]] = None,
      linkFilterSettings: scala.Option[List[LinkFilterSettings]] = None,
      conceptTypeIds: scala.Option[List[String]] = None,
      conceptVariant: scala.Option[List[ConceptVariant]] = None,
      name: scala.Option[String] = None,
      exactName: scala.Option[String] = None,
      substring: scala.Option[String] = None,
      accessLevelId: scala.Option[String] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      creationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      markers: scala.Option[List[String]] = None,
      hasLinkedIssues: scala.Option[Boolean] = None
  )
  object ConceptFilterSettings {
    implicit val encoder: ArgEncoder[ConceptFilterSettings] =
      new ArgEncoder[ConceptFilterSettings] {
        override def encode(value: ConceptFilterSettings): __Value =
          __ObjectValue(
            List(
              "propertyFilterSettings" -> value.propertyFilterSettings.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[PropertyFilterSettings]].encode(value)
                  )
                )
              ),
              "linkFilterSettings" -> value.linkFilterSettings.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[LinkFilterSettings]].encode(value)
                  )
                )
              ),
              "conceptTypeIds" -> value.conceptTypeIds.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "conceptVariant" -> value.conceptVariant.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptVariant]].encode(value)
                  )
                )
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "exactName" -> value.exactName.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "substring" -> value.substring.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "creationDate" -> value.creationDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "hasLinkedIssues" -> value.hasLinkedIssues.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptLinkCreationMutationInput(
      conceptFromId: String,
      conceptToId: String,
      linkTypeId: String,
      notes: scala.Option[String] = None,
      factInfo: scala.Option[FactInput] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None,
      accessLevelId: scala.Option[String] = None
  )
  object ConceptLinkCreationMutationInput {
    implicit val encoder: ArgEncoder[ConceptLinkCreationMutationInput] =
      new ArgEncoder[ConceptLinkCreationMutationInput] {
        override def encode(value: ConceptLinkCreationMutationInput): __Value =
          __ObjectValue(
            List(
              "conceptFromId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptFromId),
              "conceptToId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptToId),
              "linkTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.linkTypeId),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "factInfo" -> value.factInfo.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[FactInput]].encode(value)
              ),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptLinkFilterSettings(
      isEvent: scala.Option[Boolean] = None,
      conceptLinkType: scala.Option[List[String]] = None,
      documentId: scala.Option[String] = None,
      creationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object ConceptLinkFilterSettings {
    implicit val encoder: ArgEncoder[ConceptLinkFilterSettings] =
      new ArgEncoder[ConceptLinkFilterSettings] {
        override def encode(value: ConceptLinkFilterSettings): __Value =
          __ObjectValue(
            List(
              "isEvent" -> value.isEvent.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "conceptLinkType" -> value.conceptLinkType.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "documentId" -> value.documentId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "creationDate" -> value.creationDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptLinkPropertyInput(
      propertyTypeId: String,
      factInfo: scala.Option[FactInput] = None,
      notes: scala.Option[String] = None,
      valueInput: List[ComponentValueInput] = Nil,
      computableValue: scala.Option[String] = None,
      linkId: String,
      isMain: scala.Option[Boolean] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None,
      accessLevelId: scala.Option[String] = None
  )
  object ConceptLinkPropertyInput {
    implicit val encoder: ArgEncoder[ConceptLinkPropertyInput] =
      new ArgEncoder[ConceptLinkPropertyInput] {
        override def encode(value: ConceptLinkPropertyInput): __Value =
          __ObjectValue(
            List(
              "propertyTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.propertyTypeId),
              "factInfo" -> value.factInfo.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[FactInput]].encode(value)
              ),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "valueInput" -> __ListValue(
                value.valueInput.map(value =>
                  implicitly[ArgEncoder[ComponentValueInput]].encode(value)
                )
              ),
              "computableValue" -> value.computableValue.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "linkId" -> implicitly[ArgEncoder[String]].encode(value.linkId),
              "isMain" -> value.isMain.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptLinkPropertyTypeCreationInput(
      linkTypeId: String,
      name: String,
      valueTypeId: String,
      computableFormula: scala.Option[String] = None,
      pretrainedRelExtModels: scala.Option[List[RelExtModelInput]] = None,
      notifyOnUpdate: scala.Option[Boolean] = None
  )
  object ConceptLinkPropertyTypeCreationInput {
    implicit val encoder: ArgEncoder[ConceptLinkPropertyTypeCreationInput] =
      new ArgEncoder[ConceptLinkPropertyTypeCreationInput] {
        override def encode(
            value: ConceptLinkPropertyTypeCreationInput
        ): __Value =
          __ObjectValue(
            List(
              "linkTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.linkTypeId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.valueTypeId),
              "computableFormula" -> value.computableFormula.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "pretrainedRelExtModels" -> value.pretrainedRelExtModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[RelExtModelInput]].encode(value)
                  )
                )
              ),
              "notifyOnUpdate" -> value.notifyOnUpdate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptLinkPropertyTypeUpdateInput(
      id: String,
      name: String,
      valueTypeId: String,
      computableFormula: scala.Option[String] = None,
      pretrainedRelExtModels: scala.Option[List[RelExtModelInput]] = None,
      notifyOnUpdate: scala.Option[Boolean] = None
  )
  object ConceptLinkPropertyTypeUpdateInput {
    implicit val encoder: ArgEncoder[ConceptLinkPropertyTypeUpdateInput] =
      new ArgEncoder[ConceptLinkPropertyTypeUpdateInput] {
        override def encode(
            value: ConceptLinkPropertyTypeUpdateInput
        ): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.valueTypeId),
              "computableFormula" -> value.computableFormula.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "pretrainedRelExtModels" -> value.pretrainedRelExtModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[RelExtModelInput]].encode(value)
                  )
                )
              ),
              "notifyOnUpdate" -> value.notifyOnUpdate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptLinkTypeCreationInput(
      name: String,
      isDirected: scala.Option[Boolean] = None,
      isHierarchical: scala.Option[Boolean] = None,
      conceptFromTypeId: String,
      conceptToTypeId: String,
      pretrainedRelExtModels: scala.Option[List[RelExtModelInput]] = None,
      notifyOnUpdate: scala.Option[Boolean] = None
  )
  object ConceptLinkTypeCreationInput {
    implicit val encoder: ArgEncoder[ConceptLinkTypeCreationInput] =
      new ArgEncoder[ConceptLinkTypeCreationInput] {
        override def encode(value: ConceptLinkTypeCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "isDirected" -> value.isDirected.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "isHierarchical" -> value.isHierarchical.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "conceptFromTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptFromTypeId),
              "conceptToTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptToTypeId),
              "pretrainedRelExtModels" -> value.pretrainedRelExtModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[RelExtModelInput]].encode(value)
                  )
                )
              ),
              "notifyOnUpdate" -> value.notifyOnUpdate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptLinkTypeFilterSettings(
      name: scala.Option[String] = None,
      conceptFromTypeId: scala.Option[String] = None,
      conceptToTypeId: scala.Option[String] = None,
      conceptTypeAndEventFilter: scala.Option[conceptTypeAndEventFilter] = None,
      isDirected: scala.Option[Boolean] = None,
      isHierarchical: scala.Option[Boolean] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      hasRelExtModels: scala.Option[Boolean] = None
  )
  object ConceptLinkTypeFilterSettings {
    implicit val encoder: ArgEncoder[ConceptLinkTypeFilterSettings] =
      new ArgEncoder[ConceptLinkTypeFilterSettings] {
        override def encode(value: ConceptLinkTypeFilterSettings): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "conceptFromTypeId" -> value.conceptFromTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "conceptToTypeId" -> value.conceptToTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "conceptTypeAndEventFilter" -> value.conceptTypeAndEventFilter
                .fold(__NullValue: __Value)(value =>
                  implicitly[ArgEncoder[conceptTypeAndEventFilter]]
                    .encode(value)
                ),
              "isDirected" -> value.isDirected.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "isHierarchical" -> value.isHierarchical.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "hasRelExtModels" -> value.hasRelExtModels.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptLinkTypePathInput(
      linkTypeId: String,
      fixed: scala.Option[ConceptLinkDirection] = None
  )
  object ConceptLinkTypePathInput {
    implicit val encoder: ArgEncoder[ConceptLinkTypePathInput] =
      new ArgEncoder[ConceptLinkTypePathInput] {
        override def encode(value: ConceptLinkTypePathInput): __Value =
          __ObjectValue(
            List(
              "linkTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.linkTypeId),
              "fixed" -> value.fixed.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[ConceptLinkDirection]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptLinkTypeUpdateInput(
      id: String,
      name: String,
      conceptFromTypeId: String,
      conceptToTypeId: String,
      pretrainedRelExtModels: scala.Option[List[RelExtModelInput]] = None,
      isDirected: Boolean,
      isHierarchical: Boolean,
      notifyOnUpdate: scala.Option[Boolean] = None
  )
  object ConceptLinkTypeUpdateInput {
    implicit val encoder: ArgEncoder[ConceptLinkTypeUpdateInput] =
      new ArgEncoder[ConceptLinkTypeUpdateInput] {
        override def encode(value: ConceptLinkTypeUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "conceptFromTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptFromTypeId),
              "conceptToTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptToTypeId),
              "pretrainedRelExtModels" -> value.pretrainedRelExtModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[RelExtModelInput]].encode(value)
                  )
                )
              ),
              "isDirected" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.isDirected),
              "isHierarchical" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.isHierarchical),
              "notifyOnUpdate" -> value.notifyOnUpdate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptLinkUpdateMutationInput(
      id: String,
      notes: scala.Option[String] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None,
      accessLevelId: scala.Option[String] = None
  )
  object ConceptLinkUpdateMutationInput {
    implicit val encoder: ArgEncoder[ConceptLinkUpdateMutationInput] =
      new ArgEncoder[ConceptLinkUpdateMutationInput] {
        override def encode(value: ConceptLinkUpdateMutationInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptMergeInput(
      mainConceptId: String,
      mergedConceptId: String
  )
  object ConceptMergeInput {
    implicit val encoder: ArgEncoder[ConceptMergeInput] =
      new ArgEncoder[ConceptMergeInput] {
        override def encode(value: ConceptMergeInput): __Value =
          __ObjectValue(
            List(
              "mainConceptId" -> implicitly[ArgEncoder[String]]
                .encode(value.mainConceptId),
              "mergedConceptId" -> implicitly[ArgEncoder[String]].encode(
                value.mergedConceptId
              )
            )
          )
      }
  }
  final case class ConceptMutationInput(
      name: String,
      conceptTypeId: String,
      notes: scala.Option[String] = None,
      factInfo: scala.Option[FactInput] = None,
      markers: scala.Option[List[String]] = None,
      accessLevelId: scala.Option[String] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None
  )
  object ConceptMutationInput {
    implicit val encoder: ArgEncoder[ConceptMutationInput] =
      new ArgEncoder[ConceptMutationInput] {
        override def encode(value: ConceptMutationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "conceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptTypeId),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "factInfo" -> value.factInfo.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[FactInput]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptPropertyCreateInput(
      propertyTypeId: String,
      conceptId: String,
      valueInput: List[ComponentValueInput] = Nil,
      computableValue: scala.Option[String] = None,
      factInfo: scala.Option[FactInput] = None,
      notes: scala.Option[String] = None,
      isMain: scala.Option[Boolean] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None,
      accessLevelId: scala.Option[String] = None
  )
  object ConceptPropertyCreateInput {
    implicit val encoder: ArgEncoder[ConceptPropertyCreateInput] =
      new ArgEncoder[ConceptPropertyCreateInput] {
        override def encode(value: ConceptPropertyCreateInput): __Value =
          __ObjectValue(
            List(
              "propertyTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.propertyTypeId),
              "conceptId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptId),
              "valueInput" -> __ListValue(
                value.valueInput.map(value =>
                  implicitly[ArgEncoder[ComponentValueInput]].encode(value)
                )
              ),
              "computableValue" -> value.computableValue.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "factInfo" -> value.factInfo.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[FactInput]].encode(value)
              ),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "isMain" -> value.isMain.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptPropertyFilterSettings(
      onlyMain: scala.Option[Boolean] = None,
      documentId: scala.Option[String] = None
  )
  object ConceptPropertyFilterSettings {
    implicit val encoder: ArgEncoder[ConceptPropertyFilterSettings] =
      new ArgEncoder[ConceptPropertyFilterSettings] {
        override def encode(value: ConceptPropertyFilterSettings): __Value =
          __ObjectValue(
            List(
              "onlyMain" -> value.onlyMain.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "documentId" -> value.documentId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptPropertyTypeCreationInput(
      conceptTypeId: String,
      name: String,
      valueTypeId: String,
      computableFormula: scala.Option[String] = None,
      pretrainedRelExtModels: scala.Option[List[RelExtModelInput]] = None,
      notifyOnUpdate: scala.Option[Boolean] = None
  )
  object ConceptPropertyTypeCreationInput {
    implicit val encoder: ArgEncoder[ConceptPropertyTypeCreationInput] =
      new ArgEncoder[ConceptPropertyTypeCreationInput] {
        override def encode(value: ConceptPropertyTypeCreationInput): __Value =
          __ObjectValue(
            List(
              "conceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptTypeId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.valueTypeId),
              "computableFormula" -> value.computableFormula.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "pretrainedRelExtModels" -> value.pretrainedRelExtModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[RelExtModelInput]].encode(value)
                  )
                )
              ),
              "notifyOnUpdate" -> value.notifyOnUpdate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptPropertyTypeFilterSettings(
      name: scala.Option[String] = None,
      conceptTypeId: scala.Option[String] = None,
      conceptLinkTypeId: scala.Option[String] = None,
      conceptValueTypeId: scala.Option[String] = None,
      valueType: scala.Option[ValueType] = None,
      conceptTypeFromLinkTypeId: scala.Option[String] = None
  )
  object ConceptPropertyTypeFilterSettings {
    implicit val encoder: ArgEncoder[ConceptPropertyTypeFilterSettings] =
      new ArgEncoder[ConceptPropertyTypeFilterSettings] {
        override def encode(value: ConceptPropertyTypeFilterSettings): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "conceptTypeId" -> value.conceptTypeId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "conceptLinkTypeId" -> value.conceptLinkTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "conceptValueTypeId" -> value.conceptValueTypeId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "valueType" -> value.valueType.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[ValueType]].encode(value)
              ),
              "conceptTypeFromLinkTypeId" -> value.conceptTypeFromLinkTypeId
                .fold(__NullValue: __Value)(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
            )
          )
      }
  }
  final case class ConceptPropertyTypeUpdateInput(
      id: String,
      name: String,
      valueTypeId: String,
      computableFormula: scala.Option[String] = None,
      pretrainedRelExtModels: scala.Option[List[RelExtModelInput]] = None,
      notifyOnUpdate: scala.Option[Boolean] = None
  )
  object ConceptPropertyTypeUpdateInput {
    implicit val encoder: ArgEncoder[ConceptPropertyTypeUpdateInput] =
      new ArgEncoder[ConceptPropertyTypeUpdateInput] {
        override def encode(value: ConceptPropertyTypeUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.valueTypeId),
              "computableFormula" -> value.computableFormula.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "pretrainedRelExtModels" -> value.pretrainedRelExtModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[RelExtModelInput]].encode(value)
                  )
                )
              ),
              "notifyOnUpdate" -> value.notifyOnUpdate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class ConceptPropertyUpdateInput(
      propertyId: String,
      isMain: Boolean,
      notes: scala.Option[String] = None,
      computableValue: scala.Option[String] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None,
      valueInput: List[ComponentValueInput] = Nil,
      accessLevelId: scala.Option[String] = None
  )
  object ConceptPropertyUpdateInput {
    implicit val encoder: ArgEncoder[ConceptPropertyUpdateInput] =
      new ArgEncoder[ConceptPropertyUpdateInput] {
        override def encode(value: ConceptPropertyUpdateInput): __Value =
          __ObjectValue(
            List(
              "propertyId" -> implicitly[ArgEncoder[String]]
                .encode(value.propertyId),
              "isMain" -> implicitly[ArgEncoder[Boolean]].encode(value.isMain),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "computableValue" -> value.computableValue.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "valueInput" -> __ListValue(
                value.valueInput.map(value =>
                  implicitly[ArgEncoder[ComponentValueInput]].encode(value)
                )
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptPropertyValueTypeCreationInput(
      name: String,
      valueType: ValueType,
      pretrainedNERCModels: scala.Option[List[String]] = None,
      valueRestriction: scala.Option[List[String]] = None
  )
  object ConceptPropertyValueTypeCreationInput {
    implicit val encoder: ArgEncoder[ConceptPropertyValueTypeCreationInput] =
      new ArgEncoder[ConceptPropertyValueTypeCreationInput] {
        override def encode(
            value: ConceptPropertyValueTypeCreationInput
        ): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueType" -> implicitly[ArgEncoder[ValueType]]
                .encode(value.valueType),
              "pretrainedNERCModels" -> value.pretrainedNERCModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "valueRestriction" -> value.valueRestriction.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ConceptPropertyValueTypeFilterSettings(
      name: scala.Option[String] = None,
      valueType: scala.Option[ValueType] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      regexpExists: scala.Option[Boolean] = None,
      dictionaryExists: scala.Option[Boolean] = None,
      pretrainedNERCModels: scala.Option[List[String]] = None
  )
  object ConceptPropertyValueTypeFilterSettings {
    implicit val encoder: ArgEncoder[ConceptPropertyValueTypeFilterSettings] =
      new ArgEncoder[ConceptPropertyValueTypeFilterSettings] {
        override def encode(
            value: ConceptPropertyValueTypeFilterSettings
        ): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "valueType" -> value.valueType.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[ValueType]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "regexpExists" -> value.regexpExists.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "dictionaryExists" -> value.dictionaryExists.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "pretrainedNERCModels" -> value.pretrainedNERCModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ConceptPropertyValueTypeUpdateInput(
      id: String,
      name: String,
      valueType: ValueType,
      pretrainedNERCModels: List[String] = Nil,
      valueRestriction: List[String] = Nil
  )
  object ConceptPropertyValueTypeUpdateInput {
    implicit val encoder: ArgEncoder[ConceptPropertyValueTypeUpdateInput] =
      new ArgEncoder[ConceptPropertyValueTypeUpdateInput] {
        override def encode(
            value: ConceptPropertyValueTypeUpdateInput
        ): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueType" -> implicitly[ArgEncoder[ValueType]]
                .encode(value.valueType),
              "pretrainedNERCModels" -> __ListValue(
                value.pretrainedNERCModels.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "valueRestriction" -> __ListValue(
                value.valueRestriction.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class ConceptRegistryViewInput(
      columns: scala.Option[List[ConceptViewColumnType]] = None,
      metrics: scala.Option[List[ConceptViewMetricType]] = None,
      sorting: scala.Option[ConceptRegistryViewSortingInput] = None
  )
  object ConceptRegistryViewInput {
    implicit val encoder: ArgEncoder[ConceptRegistryViewInput] =
      new ArgEncoder[ConceptRegistryViewInput] {
        override def encode(value: ConceptRegistryViewInput): __Value =
          __ObjectValue(
            List(
              "columns" -> value.columns.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptViewColumnType]].encode(value)
                  )
                )
              ),
              "metrics" -> value.metrics.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptViewMetricType]].encode(value)
                  )
                )
              ),
              "sorting" -> value.sorting.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[ConceptRegistryViewSortingInput]].encode(
                  value
                )
              )
            )
          )
      }
  }
  final case class ConceptRegistryViewSortingInput(
      sortingType: ConceptSorting,
      sortDirection: SortDirection
  )
  object ConceptRegistryViewSortingInput {
    implicit val encoder: ArgEncoder[ConceptRegistryViewSortingInput] =
      new ArgEncoder[ConceptRegistryViewSortingInput] {
        override def encode(value: ConceptRegistryViewSortingInput): __Value =
          __ObjectValue(
            List(
              "sortingType" -> implicitly[ArgEncoder[ConceptSorting]]
                .encode(value.sortingType),
              "sortDirection" -> implicitly[ArgEncoder[SortDirection]].encode(
                value.sortDirection
              )
            )
          )
      }
  }
  final case class conceptTypeAndEventFilter(fullType: String, isEvent: Boolean)
  object conceptTypeAndEventFilter {
    implicit val encoder: ArgEncoder[conceptTypeAndEventFilter] =
      new ArgEncoder[conceptTypeAndEventFilter] {
        override def encode(value: conceptTypeAndEventFilter): __Value =
          __ObjectValue(
            List(
              "fullType" -> implicitly[ArgEncoder[String]]
                .encode(value.fullType),
              "isEvent" -> implicitly[ArgEncoder[Boolean]].encode(value.isEvent)
            )
          )
      }
  }
  final case class ConceptTypeCreationInput(
      name: String,
      xCoordinate: Double,
      yCoordinate: Double,
      pretrainedNERCModels: scala.Option[List[String]] = None,
      isEvent: scala.Option[Boolean] = None,
      showInMenu: scala.Option[Boolean] = None
  )
  object ConceptTypeCreationInput {
    implicit val encoder: ArgEncoder[ConceptTypeCreationInput] =
      new ArgEncoder[ConceptTypeCreationInput] {
        override def encode(value: ConceptTypeCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "xCoordinate" -> implicitly[ArgEncoder[Double]]
                .encode(value.xCoordinate),
              "yCoordinate" -> implicitly[ArgEncoder[Double]]
                .encode(value.yCoordinate),
              "pretrainedNERCModels" -> value.pretrainedNERCModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "isEvent" -> value.isEvent.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "showInMenu" -> value.showInMenu.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptTypeFilterSettings(
      name: scala.Option[String] = None,
      isEvent: scala.Option[Boolean] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      regexpExists: scala.Option[Boolean] = None,
      dictionaryExists: scala.Option[Boolean] = None,
      pretrainedNERCModels: scala.Option[List[String]] = None
  )
  object ConceptTypeFilterSettings {
    implicit val encoder: ArgEncoder[ConceptTypeFilterSettings] =
      new ArgEncoder[ConceptTypeFilterSettings] {
        override def encode(value: ConceptTypeFilterSettings): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "isEvent" -> value.isEvent.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "regexpExists" -> value.regexpExists.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "dictionaryExists" -> value.dictionaryExists.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "pretrainedNERCModels" -> value.pretrainedNERCModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ConceptTypeUpdateInput(
      id: String,
      xCoordinate: Double,
      yCoordinate: Double,
      name: String,
      pretrainedNERCModels: scala.Option[List[String]] = None,
      isEvent: Boolean,
      showInMenu: scala.Option[Boolean] = None
  )
  object ConceptTypeUpdateInput {
    implicit val encoder: ArgEncoder[ConceptTypeUpdateInput] =
      new ArgEncoder[ConceptTypeUpdateInput] {
        override def encode(value: ConceptTypeUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "xCoordinate" -> implicitly[ArgEncoder[Double]]
                .encode(value.xCoordinate),
              "yCoordinate" -> implicitly[ArgEncoder[Double]]
                .encode(value.yCoordinate),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "pretrainedNERCModels" -> value.pretrainedNERCModels.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "isEvent" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.isEvent),
              "showInMenu" -> value.showInMenu.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              )
            )
          )
      }
  }
  final case class ConceptTypeViewCreationInput(
      conceptTypeId: String,
      name: String,
      showInMenu: Boolean,
      columns: List[CompositeConceptTypeWidgetTypeColumnInput] = Nil
  )
  object ConceptTypeViewCreationInput {
    implicit val encoder: ArgEncoder[ConceptTypeViewCreationInput] =
      new ArgEncoder[ConceptTypeViewCreationInput] {
        override def encode(value: ConceptTypeViewCreationInput): __Value =
          __ObjectValue(
            List(
              "conceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptTypeId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "showInMenu" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.showInMenu),
              "columns" -> __ListValue(
                value.columns.map(value =>
                  implicitly[ArgEncoder[
                    CompositeConceptTypeWidgetTypeColumnInput
                  ]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class ConceptTypeViewUpdateInput(
      id: String,
      name: String,
      showInMenu: Boolean,
      columns: List[CompositeConceptTypeWidgetTypeColumnInput] = Nil
  )
  object ConceptTypeViewUpdateInput {
    implicit val encoder: ArgEncoder[ConceptTypeViewUpdateInput] =
      new ArgEncoder[ConceptTypeViewUpdateInput] {
        override def encode(value: ConceptTypeViewUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "showInMenu" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.showInMenu),
              "columns" -> __ListValue(
                value.columns.map(value =>
                  implicitly[ArgEncoder[
                    CompositeConceptTypeWidgetTypeColumnInput
                  ]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class ConceptUnmergeInput(
      mainConceptId: String,
      mergedConceptId: List[String] = Nil
  )
  object ConceptUnmergeInput {
    implicit val encoder: ArgEncoder[ConceptUnmergeInput] =
      new ArgEncoder[ConceptUnmergeInput] {
        override def encode(value: ConceptUnmergeInput): __Value =
          __ObjectValue(
            List(
              "mainConceptId" -> implicitly[ArgEncoder[String]]
                .encode(value.mainConceptId),
              "mergedConceptId" -> __ListValue(
                value.mergedConceptId.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class ConceptUpdateInput(
      conceptId: String,
      name: String,
      conceptTypeId: String,
      notes: scala.Option[String] = None,
      documentInput: scala.Option[FactInput] = None,
      markers: scala.Option[List[String]] = None,
      accessLevelId: scala.Option[String] = None,
      startDate: scala.Option[DateTimeValueInput] = None,
      endDate: scala.Option[DateTimeValueInput] = None
  )
  object ConceptUpdateInput {
    implicit val encoder: ArgEncoder[ConceptUpdateInput] =
      new ArgEncoder[ConceptUpdateInput] {
        override def encode(value: ConceptUpdateInput): __Value =
          __ObjectValue(
            List(
              "conceptId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "conceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptTypeId),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "documentInput" -> value.documentInput.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[FactInput]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "startDate" -> value.startDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "endDate" -> value.endDate.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              )
            )
          )
      }
  }
  final case class Coordinate(x: Double, y: Double)
  object Coordinate {
    implicit val encoder: ArgEncoder[Coordinate] = new ArgEncoder[Coordinate] {
      override def encode(value: Coordinate): __Value =
        __ObjectValue(
          List(
            "x" -> implicitly[ArgEncoder[Double]].encode(value.x),
            "y" -> implicitly[ArgEncoder[Double]].encode(value.y)
          )
        )
    }
  }
  final case class CoordinatesInput(latitude: Double, longitude: Double)
  object CoordinatesInput {
    implicit val encoder: ArgEncoder[CoordinatesInput] =
      new ArgEncoder[CoordinatesInput] {
        override def encode(value: CoordinatesInput): __Value =
          __ObjectValue(
            List(
              "latitude" -> implicitly[ArgEncoder[Double]]
                .encode(value.latitude),
              "longitude" -> implicitly[ArgEncoder[Double]].encode(
                value.longitude
              )
            )
          )
      }
  }
  final case class CountryFilterSettings(
      searchString: scala.Option[String] = None,
      target: scala.Option[CountryTarget] = None
  )
  object CountryFilterSettings {
    implicit val encoder: ArgEncoder[CountryFilterSettings] =
      new ArgEncoder[CountryFilterSettings] {
        override def encode(value: CountryFilterSettings): __Value =
          __ObjectValue(
            List(
              "searchString" -> value.searchString.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "target" -> value.target.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[CountryTarget]].encode(value)
              )
            )
          )
      }
  }
  final case class DateInput(
      year: scala.Option[Int] = None,
      month: scala.Option[Int] = None,
      day: scala.Option[Int] = None
  )
  object DateInput {
    implicit val encoder: ArgEncoder[DateInput] = new ArgEncoder[DateInput] {
      override def encode(value: DateInput): __Value =
        __ObjectValue(
          List(
            "year" -> value.year.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "month" -> value.month.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "day" -> value.day.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            )
          )
        )
    }
  }
  final case class DateTimeIntervalInput(
      start: scala.Option[DateTimeValueInput] = None,
      end: scala.Option[DateTimeValueInput] = None
  )
  object DateTimeIntervalInput {
    implicit val encoder: ArgEncoder[DateTimeIntervalInput] =
      new ArgEncoder[DateTimeIntervalInput] {
        override def encode(value: DateTimeIntervalInput): __Value =
          __ObjectValue(
            List(
              "start" -> value.start.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              ),
              "end" -> value.end.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
              )
            )
          )
      }
  }
  final case class DateTimeIntervalPairInput(
      start: DateTimeIntervalInput,
      end: DateTimeIntervalInput
  )
  object DateTimeIntervalPairInput {
    implicit val encoder: ArgEncoder[DateTimeIntervalPairInput] =
      new ArgEncoder[DateTimeIntervalPairInput] {
        override def encode(value: DateTimeIntervalPairInput): __Value =
          __ObjectValue(
            List(
              "start" -> implicitly[ArgEncoder[DateTimeIntervalInput]]
                .encode(value.start),
              "end" -> implicitly[ArgEncoder[DateTimeIntervalInput]].encode(
                value.end
              )
            )
          )
      }
  }
  final case class DateTimeValueInput(
      date: DateInput,
      time: scala.Option[TimeInput] = None
  )
  object DateTimeValueInput {
    implicit val encoder: ArgEncoder[DateTimeValueInput] =
      new ArgEncoder[DateTimeValueInput] {
        override def encode(value: DateTimeValueInput): __Value =
          __ObjectValue(
            List(
              "date" -> implicitly[ArgEncoder[DateInput]].encode(value.date),
              "time" -> value.time.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[TimeInput]].encode(value)
              )
            )
          )
      }
  }
  final case class Document2IssueInput(
      idIssue: String,
      documentIds: List[String] = Nil,
      comment: scala.Option[String] = None
  )
  object Document2IssueInput {
    implicit val encoder: ArgEncoder[Document2IssueInput] =
      new ArgEncoder[Document2IssueInput] {
        override def encode(value: Document2IssueInput): __Value =
          __ObjectValue(
            List(
              "idIssue" -> implicitly[ArgEncoder[String]].encode(value.idIssue),
              "documentIds" -> __ListValue(
                value.documentIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "comment" -> value.comment.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentAddInputInput(
      documentId: String,
      xCoordinate: scala.Option[Double] = None,
      yCoordinate: scala.Option[Double] = None,
      groupId: scala.Option[String] = None
  )
  object DocumentAddInputInput {
    implicit val encoder: ArgEncoder[DocumentAddInputInput] =
      new ArgEncoder[DocumentAddInputInput] {
        override def encode(value: DocumentAddInputInput): __Value =
          __ObjectValue(
            List(
              "documentId" -> implicitly[ArgEncoder[String]]
                .encode(value.documentId),
              "xCoordinate" -> value.xCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "yCoordinate" -> value.yCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "groupId" -> value.groupId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentAllKBFactsRemoveInput(
      documentId: String,
      kbEntityId: String
  )
  object DocumentAllKBFactsRemoveInput {
    implicit val encoder: ArgEncoder[DocumentAllKBFactsRemoveInput] =
      new ArgEncoder[DocumentAllKBFactsRemoveInput] {
        override def encode(value: DocumentAllKBFactsRemoveInput): __Value =
          __ObjectValue(
            List(
              "documentId" -> implicitly[ArgEncoder[String]]
                .encode(value.documentId),
              "kbEntityId" -> implicitly[ArgEncoder[String]].encode(
                value.kbEntityId
              )
            )
          )
      }
  }
  final case class DocumentAvatarUpdateInput(
      id: String,
      childrenDocumentId: scala.Option[String] = None
  )
  object DocumentAvatarUpdateInput {
    implicit val encoder: ArgEncoder[DocumentAvatarUpdateInput] =
      new ArgEncoder[DocumentAvatarUpdateInput] {
        override def encode(value: DocumentAvatarUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "childrenDocumentId" -> value.childrenDocumentId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value))
            )
          )
      }
  }
  final case class DocumentCardViewInput(
      columns: scala.Option[List[DocumentViewColumnType]] = None,
      metrics: scala.Option[List[DocumentViewMetricType]] = None
  )
  object DocumentCardViewInput {
    implicit val encoder: ArgEncoder[DocumentCardViewInput] =
      new ArgEncoder[DocumentCardViewInput] {
        override def encode(value: DocumentCardViewInput): __Value =
          __ObjectValue(
            List(
              "columns" -> value.columns.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[DocumentViewColumnType]].encode(value)
                  )
                )
              ),
              "metrics" -> value.metrics.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[DocumentViewMetricType]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class DocumentDeleteCandidateFactInput(
      documentId: String,
      factId: String
  )
  object DocumentDeleteCandidateFactInput {
    implicit val encoder: ArgEncoder[DocumentDeleteCandidateFactInput] =
      new ArgEncoder[DocumentDeleteCandidateFactInput] {
        override def encode(value: DocumentDeleteCandidateFactInput): __Value =
          __ObjectValue(
            List(
              "documentId" -> implicitly[ArgEncoder[String]]
                .encode(value.documentId),
              "factId" -> implicitly[ArgEncoder[String]].encode(value.factId)
            )
          )
      }
  }
  final case class DocumentDoubleCreationInput(
      uuid: String,
      doubleUuid: String,
      parentUuid: scala.Option[String] = None,
      conceptId: scala.Option[String] = None
  )
  object DocumentDoubleCreationInput {
    implicit val encoder: ArgEncoder[DocumentDoubleCreationInput] =
      new ArgEncoder[DocumentDoubleCreationInput] {
        override def encode(value: DocumentDoubleCreationInput): __Value =
          __ObjectValue(
            List(
              "uuid" -> implicitly[ArgEncoder[String]].encode(value.uuid),
              "doubleUuid" -> implicitly[ArgEncoder[String]]
                .encode(value.doubleUuid),
              "parentUuid" -> value.parentUuid.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "conceptId" -> value.conceptId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentFeedCreationInput(
      name: String,
      query: scala.Option[String] = None,
      filterSettings: scala.Option[DocumentFilterSettings] = None
  )
  object DocumentFeedCreationInput {
    implicit val encoder: ArgEncoder[DocumentFeedCreationInput] =
      new ArgEncoder[DocumentFeedCreationInput] {
        override def encode(value: DocumentFeedCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "query" -> value.query.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "filterSettings" -> value.filterSettings.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[DocumentFilterSettings]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentFeedFilterSettings(
      id: scala.Option[String] = None,
      searchString: scala.Option[String] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object DocumentFeedFilterSettings {
    implicit val encoder: ArgEncoder[DocumentFeedFilterSettings] =
      new ArgEncoder[DocumentFeedFilterSettings] {
        override def encode(value: DocumentFeedFilterSettings): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "searchString" -> value.searchString.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentFeedUpdateDocumentsInput(
      documentIds: List[String] = Nil
  )
  object DocumentFeedUpdateDocumentsInput {
    implicit val encoder: ArgEncoder[DocumentFeedUpdateDocumentsInput] =
      new ArgEncoder[DocumentFeedUpdateDocumentsInput] {
        override def encode(value: DocumentFeedUpdateDocumentsInput): __Value =
          __ObjectValue(
            List(
              "documentIds" -> __ListValue(
                value.documentIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class DocumentFeedUpdateInput(
      name: String,
      query: scala.Option[String] = None,
      filterSettings: scala.Option[DocumentFilterSettings] = None
  )
  object DocumentFeedUpdateInput {
    implicit val encoder: ArgEncoder[DocumentFeedUpdateInput] =
      new ArgEncoder[DocumentFeedUpdateInput] {
        override def encode(value: DocumentFeedUpdateInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "query" -> value.query.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "filterSettings" -> value.filterSettings.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[DocumentFilterSettings]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentFilterSettings(
      searchString: scala.Option[String] = None,
      substring: scala.Option[String] = None,
      namedEntities: scala.Option[List[String]] = None,
      concepts: scala.Option[List[String]] = None,
      platforms: scala.Option[List[String]] = None,
      accounts: scala.Option[List[String]] = None,
      nercNum: scala.Option[IntervalInt] = None,
      conceptsNum: scala.Option[IntervalInt] = None,
      childDocsNum: scala.Option[IntervalInt] = None,
      publicationDate: scala.Option[TimestampInterval] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      lastUpdate: scala.Option[TimestampInterval] = None,
      creator: scala.Option[List[String]] = None,
      publicationAuthor: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      accessLevelId: scala.Option[String] = None,
      links: scala.Option[List[String]] = None,
      markers: scala.Option[List[String]] = None,
      documentType: scala.Option[List[DocumentType]] = None,
      sourceType: scala.Option[List[DocumentSourceType]] = None,
      trustLevel: scala.Option[List[TrustLevel]] = None,
      hasLinkedIssues: scala.Option[Boolean] = None,
      nestedIds: scala.Option[List[String]] = None,
      factTypes: scala.Option[List[String]] = None,
      story: scala.Option[String] = None,
      showRead: scala.Option[Boolean] = None,
      jobIds: scala.Option[List[String]] = None,
      periodicJobIds: scala.Option[List[String]] = None,
      taskIds: scala.Option[List[String]] = None,
      periodicTaskIds: scala.Option[List[String]] = None
  )
  object DocumentFilterSettings {
    implicit val encoder: ArgEncoder[DocumentFilterSettings] =
      new ArgEncoder[DocumentFilterSettings] {
        override def encode(value: DocumentFilterSettings): __Value =
          __ObjectValue(
            List(
              "searchString" -> value.searchString.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "substring" -> value.substring.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "namedEntities" -> value.namedEntities.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "concepts" -> value.concepts.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "platforms" -> value.platforms.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "accounts" -> value.accounts.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "nercNum" -> value.nercNum.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[IntervalInt]].encode(value)
              ),
              "conceptsNum" -> value.conceptsNum.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[IntervalInt]].encode(value)
              ),
              "childDocsNum" -> value.childDocsNum.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[IntervalInt]].encode(value)
              ),
              "publicationDate" -> value.publicationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "lastUpdate" -> value.lastUpdate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "publicationAuthor" -> value.publicationAuthor.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "links" -> value.links.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "documentType" -> value.documentType.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[DocumentType]].encode(value)
                    )
                  )
              ),
              "sourceType" -> value.sourceType.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[DocumentSourceType]].encode(value)
                    )
                  )
              ),
              "trustLevel" -> value.trustLevel.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[TrustLevel]].encode(value)
                    )
                  )
              ),
              "hasLinkedIssues" -> value.hasLinkedIssues.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "nestedIds" -> value.nestedIds.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "factTypes" -> value.factTypes.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "story" -> value.story.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "showRead" -> value.showRead.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "jobIds" -> value.jobIds.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "periodicJobIds" -> value.periodicJobIds.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "taskIds" -> value.taskIds.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "periodicTaskIds" -> value.periodicTaskIds.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class DocumentLinkFilterSetting(
      documentType: scala.Option[DocumentType] = None
  )
  object DocumentLinkFilterSetting {
    implicit val encoder: ArgEncoder[DocumentLinkFilterSetting] =
      new ArgEncoder[DocumentLinkFilterSetting] {
        override def encode(value: DocumentLinkFilterSetting): __Value =
          __ObjectValue(
            List(
              "documentType" -> value.documentType.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[DocumentType]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentNodeUpdateInput(
      id: String,
      nodeId: String,
      language: scala.Option[LanguageUpdateInput] = None,
      translation: scala.Option[TranslationInput] = None
  )
  object DocumentNodeUpdateInput {
    implicit val encoder: ArgEncoder[DocumentNodeUpdateInput] =
      new ArgEncoder[DocumentNodeUpdateInput] {
        override def encode(value: DocumentNodeUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "nodeId" -> implicitly[ArgEncoder[String]].encode(value.nodeId),
              "language" -> value.language.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[LanguageUpdateInput]].encode(value)
              ),
              "translation" -> value.translation.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TranslationInput]].encode(value)
              )
            )
          )
      }
  }
  final case class DocumentRegistryViewInput(
      columns: scala.Option[List[DocumentViewColumnType]] = None,
      metrics: scala.Option[List[DocumentViewMetricType]] = None,
      sorting: scala.Option[DocumentRegistryViewSortingInput] = None
  )
  object DocumentRegistryViewInput {
    implicit val encoder: ArgEncoder[DocumentRegistryViewInput] =
      new ArgEncoder[DocumentRegistryViewInput] {
        override def encode(value: DocumentRegistryViewInput): __Value =
          __ObjectValue(
            List(
              "columns" -> value.columns.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[DocumentViewColumnType]].encode(value)
                  )
                )
              ),
              "metrics" -> value.metrics.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[DocumentViewMetricType]].encode(value)
                  )
                )
              ),
              "sorting" -> value.sorting.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DocumentRegistryViewSortingInput]].encode(
                  value
                )
              )
            )
          )
      }
  }
  final case class DocumentRegistryViewSortingInput(
      sortingType: DocumentSorting,
      sortDirection: SortDirection
  )
  object DocumentRegistryViewSortingInput {
    implicit val encoder: ArgEncoder[DocumentRegistryViewSortingInput] =
      new ArgEncoder[DocumentRegistryViewSortingInput] {
        override def encode(value: DocumentRegistryViewSortingInput): __Value =
          __ObjectValue(
            List(
              "sortingType" -> implicitly[ArgEncoder[DocumentSorting]]
                .encode(value.sortingType),
              "sortDirection" -> implicitly[ArgEncoder[SortDirection]].encode(
                value.sortDirection
              )
            )
          )
      }
  }
  final case class DocumentUpdateInput(
      id: String,
      notes: scala.Option[String] = None,
      title: scala.Option[String] = None,
      previewText: scala.Option[String] = None,
      externalUrl: scala.Option[String] = None,
      publicationDate: scala.Option[Long] = None,
      publicationAuthor: scala.Option[String] = None,
      markers: scala.Option[List[String]] = None,
      trustLevel: scala.Option[TrustLevel] = None,
      platform: scala.Option[String] = None,
      account: scala.Option[List[String]] = None,
      language: scala.Option[String] = None
  )
  object DocumentUpdateInput {
    implicit val encoder: ArgEncoder[DocumentUpdateInput] =
      new ArgEncoder[DocumentUpdateInput] {
        override def encode(value: DocumentUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "notes" -> value.notes.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "title" -> value.title.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "previewText" -> value.previewText.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "externalUrl" -> value.externalUrl.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "publicationDate" -> value.publicationDate.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Long]].encode(value)),
              "publicationAuthor" -> value.publicationAuthor.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "trustLevel" -> value.trustLevel.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TrustLevel]].encode(value)
              ),
              "platform" -> value.platform.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "account" -> value.account.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "language" -> value.language.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class DoubleValueInput(value: Double)
  object DoubleValueInput {
    implicit val encoder: ArgEncoder[DoubleValueInput] =
      new ArgEncoder[DoubleValueInput] {
        override def encode(value: DoubleValueInput): __Value =
          __ObjectValue(
            List("value" -> implicitly[ArgEncoder[Double]].encode(value.value))
          )
      }
  }
  final case class ExtraSettings(
      hideChild: scala.Option[Boolean] = None,
      searchOnMap: scala.Option[Boolean] = None,
      rankingScript: scala.Option[String] = None,
      selectedContent: scala.Option[ResearchMapContentSelectInput] = None
  )
  object ExtraSettings {
    implicit val encoder: ArgEncoder[ExtraSettings] =
      new ArgEncoder[ExtraSettings] {
        override def encode(value: ExtraSettings): __Value =
          __ObjectValue(
            List(
              "hideChild" -> value.hideChild.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "searchOnMap" -> value.searchOnMap.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "rankingScript" -> value.rankingScript.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "selectedContent" -> value.selectedContent.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[ResearchMapContentSelectInput]].encode(
                  value
                )
              )
            )
          )
      }
  }
  final case class FactInput(
      documentId: String,
      annotations: scala.Option[List[TextBoundingInput]] = None,
      factId: scala.Option[String] = None
  )
  object FactInput {
    implicit val encoder: ArgEncoder[FactInput] = new ArgEncoder[FactInput] {
      override def encode(value: FactInput): __Value =
        __ObjectValue(
          List(
            "documentId" -> implicitly[ArgEncoder[String]]
              .encode(value.documentId),
            "annotations" -> value.annotations.fold(__NullValue: __Value)(
              value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[TextBoundingInput]].encode(value)
                  )
                )
            ),
            "factId" -> value.factId.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            )
          )
        )
    }
  }
  final case class GeoPointFormInput(latitude: Double, longitude: Double)
  object GeoPointFormInput {
    implicit val encoder: ArgEncoder[GeoPointFormInput] =
      new ArgEncoder[GeoPointFormInput] {
        override def encode(value: GeoPointFormInput): __Value =
          __ObjectValue(
            List(
              "latitude" -> implicitly[ArgEncoder[Double]]
                .encode(value.latitude),
              "longitude" -> implicitly[ArgEncoder[Double]].encode(
                value.longitude
              )
            )
          )
      }
  }
  final case class GeoPointInput(
      point: scala.Option[CoordinatesInput] = None,
      name: scala.Option[String] = None
  )
  object GeoPointInput {
    implicit val encoder: ArgEncoder[GeoPointInput] =
      new ArgEncoder[GeoPointInput] {
        override def encode(value: GeoPointInput): __Value =
          __ObjectValue(
            List(
              "point" -> value.point.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[CoordinatesInput]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class GeoPointWithNameFormInput(
      point: scala.Option[GeoPointFormInput] = None,
      name: scala.Option[String] = None,
      radius: Double
  )
  object GeoPointWithNameFormInput {
    implicit val encoder: ArgEncoder[GeoPointWithNameFormInput] =
      new ArgEncoder[GeoPointWithNameFormInput] {
        override def encode(value: GeoPointWithNameFormInput): __Value =
          __ObjectValue(
            List(
              "point" -> value.point.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[GeoPointFormInput]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "radius" -> implicitly[ArgEncoder[Double]].encode(value.radius)
            )
          )
      }
  }
  final case class GroupCreationInput(
      researchMapId: String,
      name: String,
      xCoordinate: scala.Option[Double] = None,
      yCoordinate: scala.Option[Double] = None,
      collapsed: Boolean,
      layout: scala.Option[String] = None
  )
  object GroupCreationInput {
    implicit val encoder: ArgEncoder[GroupCreationInput] =
      new ArgEncoder[GroupCreationInput] {
        override def encode(value: GroupCreationInput): __Value =
          __ObjectValue(
            List(
              "researchMapId" -> implicitly[ArgEncoder[String]]
                .encode(value.researchMapId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "xCoordinate" -> value.xCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "yCoordinate" -> value.yCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "collapsed" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.collapsed),
              "layout" -> value.layout.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class GroupUpdateInput(
      name: String,
      xCoordinate: scala.Option[Double] = None,
      yCoordinate: scala.Option[Double] = None,
      collapsed: Boolean,
      layout: scala.Option[String] = None
  )
  object GroupUpdateInput {
    implicit val encoder: ArgEncoder[GroupUpdateInput] =
      new ArgEncoder[GroupUpdateInput] {
        override def encode(value: GroupUpdateInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "xCoordinate" -> value.xCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "yCoordinate" -> value.yCoordinate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "collapsed" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.collapsed),
              "layout" -> value.layout.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class InterestObjectMainPropertiesOrderUpdateInput(
      conceptTypeId: String,
      orderedMainPropertyTypeIds: scala.Option[List[String]] = None
  )
  object InterestObjectMainPropertiesOrderUpdateInput {
    implicit val encoder
        : ArgEncoder[InterestObjectMainPropertiesOrderUpdateInput] =
      new ArgEncoder[InterestObjectMainPropertiesOrderUpdateInput] {
        override def encode(
            value: InterestObjectMainPropertiesOrderUpdateInput
        ): __Value =
          __ObjectValue(
            List(
              "conceptTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.conceptTypeId),
              "orderedMainPropertyTypeIds" -> value.orderedMainPropertyTypeIds
                .fold(__NullValue: __Value)(value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
                )
            )
          )
      }
  }
  final case class IntervalDouble(
      start: scala.Option[Double] = None,
      end: scala.Option[Double] = None
  )
  object IntervalDouble {
    implicit val encoder: ArgEncoder[IntervalDouble] =
      new ArgEncoder[IntervalDouble] {
        override def encode(value: IntervalDouble): __Value =
          __ObjectValue(
            List(
              "start" -> value.start.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Double]].encode(value)
              ),
              "end" -> value.end.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Double]].encode(value)
              )
            )
          )
      }
  }
  final case class IntervalInt(
      start: scala.Option[Int] = None,
      end: scala.Option[Int] = None
  )
  object IntervalInt {
    implicit val encoder: ArgEncoder[IntervalInt] =
      new ArgEncoder[IntervalInt] {
        override def encode(value: IntervalInt): __Value =
          __ObjectValue(
            List(
              "start" -> value.start.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "end" -> value.end.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              )
            )
          )
      }
  }
  final case class IntValueInput(value: Int)
  object IntValueInput {
    implicit val encoder: ArgEncoder[IntValueInput] =
      new ArgEncoder[IntValueInput] {
        override def encode(value: IntValueInput): __Value =
          __ObjectValue(
            List("value" -> implicitly[ArgEncoder[Int]].encode(value.value))
          )
      }
  }
  final case class Issue2TaskInput(
      idIssue: String,
      taskIds: List[String] = Nil,
      comment: scala.Option[String] = None
  )
  object Issue2TaskInput {
    implicit val encoder: ArgEncoder[Issue2TaskInput] =
      new ArgEncoder[Issue2TaskInput] {
        override def encode(value: Issue2TaskInput): __Value =
          __ObjectValue(
            List(
              "idIssue" -> implicitly[ArgEncoder[String]].encode(value.idIssue),
              "taskIds" -> __ListValue(
                value.taskIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "comment" -> value.comment.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class IssueCreationInput(
      topic: String,
      description: scala.Option[String] = None,
      status: IssueStatus,
      priority: IssuePriority,
      executorId: String,
      executionTimeLimit: scala.Option[UnixTime] = None,
      documents: List[String] = Nil,
      concepts: List[String] = Nil,
      issues: List[String] = Nil,
      markers: List[String] = Nil
  )
  object IssueCreationInput {
    implicit val encoder: ArgEncoder[IssueCreationInput] =
      new ArgEncoder[IssueCreationInput] {
        override def encode(value: IssueCreationInput): __Value =
          __ObjectValue(
            List(
              "topic" -> implicitly[ArgEncoder[String]].encode(value.topic),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "status" -> implicitly[ArgEncoder[IssueStatus]]
                .encode(value.status),
              "priority" -> implicitly[ArgEncoder[IssuePriority]]
                .encode(value.priority),
              "executorId" -> implicitly[ArgEncoder[String]]
                .encode(value.executorId),
              "executionTimeLimit" -> value.executionTimeLimit.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[UnixTime]].encode(value)),
              "documents" -> __ListValue(
                value.documents.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "concepts" -> __ListValue(
                value.concepts.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "issues" -> __ListValue(
                value.issues.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "markers" -> __ListValue(
                value.markers.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class IssueEditFieldsInput(
      id: String,
      topic: String,
      description: scala.Option[String] = None,
      status: IssueStatus,
      priority: IssuePriority,
      executorId: String,
      executionTimeLimit: scala.Option[UnixTime] = None,
      markers: List[String] = Nil,
      comment: scala.Option[String] = None
  )
  object IssueEditFieldsInput {
    implicit val encoder: ArgEncoder[IssueEditFieldsInput] =
      new ArgEncoder[IssueEditFieldsInput] {
        override def encode(value: IssueEditFieldsInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "topic" -> implicitly[ArgEncoder[String]].encode(value.topic),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "status" -> implicitly[ArgEncoder[IssueStatus]]
                .encode(value.status),
              "priority" -> implicitly[ArgEncoder[IssuePriority]]
                .encode(value.priority),
              "executorId" -> implicitly[ArgEncoder[String]]
                .encode(value.executorId),
              "executionTimeLimit" -> value.executionTimeLimit.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[UnixTime]].encode(value)),
              "markers" -> __ListValue(
                value.markers.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "comment" -> value.comment.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class IssueFilterSettings(
      executor: scala.Option[List[String]] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      status: scala.Option[List[IssueStatus]] = None,
      priority: scala.Option[List[IssuePriority]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      issueForDocument: scala.Option[Boolean] = None,
      issueForConcept: scala.Option[Boolean] = None,
      onlyMy: scala.Option[Boolean] = None,
      issue: scala.Option[String] = None,
      concept: scala.Option[String] = None,
      document: scala.Option[String] = None,
      name: scala.Option[String] = None,
      description: scala.Option[String] = None,
      executionTimeLimit: scala.Option[TimestampInterval] = None,
      markers: scala.Option[List[String]] = None
  )
  object IssueFilterSettings {
    implicit val encoder: ArgEncoder[IssueFilterSettings] =
      new ArgEncoder[IssueFilterSettings] {
        override def encode(value: IssueFilterSettings): __Value =
          __ObjectValue(
            List(
              "executor" -> value.executor.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "status" -> value.status.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[IssueStatus]].encode(value)
                  )
                )
              ),
              "priority" -> value.priority.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[IssuePriority]].encode(value)
                  )
                )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "issueForDocument" -> value.issueForDocument.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "issueForConcept" -> value.issueForConcept.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "onlyMy" -> value.onlyMy.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "issue" -> value.issue.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "concept" -> value.concept.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "document" -> value.document.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "executionTimeLimit" -> value.executionTimeLimit.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class LanguageFilterSettings(
      searchString: scala.Option[String] = None
  )
  object LanguageFilterSettings {
    implicit val encoder: ArgEncoder[LanguageFilterSettings] =
      new ArgEncoder[LanguageFilterSettings] {
        override def encode(value: LanguageFilterSettings): __Value =
          __ObjectValue(
            List(
              "searchString" -> value.searchString.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class LanguageInput(id: String)
  object LanguageInput {
    implicit val encoder: ArgEncoder[LanguageInput] =
      new ArgEncoder[LanguageInput] {
        override def encode(value: LanguageInput): __Value =
          __ObjectValue(
            List("id" -> implicitly[ArgEncoder[String]].encode(value.id))
          )
      }
  }
  final case class LanguageUpdateInput(id: scala.Option[String] = None)
  object LanguageUpdateInput {
    implicit val encoder: ArgEncoder[LanguageUpdateInput] =
      new ArgEncoder[LanguageUpdateInput] {
        override def encode(value: LanguageUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class LinkFilterSettings(
      linkTypeId: scala.Option[String] = None,
      linkDirection: scala.Option[LinkDirection] = None,
      otherConceptId: scala.Option[List[String]] = None
  )
  object LinkFilterSettings {
    implicit val encoder: ArgEncoder[LinkFilterSettings] =
      new ArgEncoder[LinkFilterSettings] {
        override def encode(value: LinkFilterSettings): __Value =
          __ObjectValue(
            List(
              "linkTypeId" -> value.linkTypeId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "linkDirection" -> value.linkDirection.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[LinkDirection]].encode(value)
              ),
              "otherConceptId" -> value.otherConceptId.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class LinkValueInput(link: String)
  object LinkValueInput {
    implicit val encoder: ArgEncoder[LinkValueInput] =
      new ArgEncoder[LinkValueInput] {
        override def encode(value: LinkValueInput): __Value =
          __ObjectValue(
            List("link" -> implicitly[ArgEncoder[String]].encode(value.link))
          )
      }
  }
  final case class MapEdgeFilterSettings(
      edgeType: scala.Option[List[MapEdgeType]] = None
  )
  object MapEdgeFilterSettings {
    implicit val encoder: ArgEncoder[MapEdgeFilterSettings] =
      new ArgEncoder[MapEdgeFilterSettings] {
        override def encode(value: MapEdgeFilterSettings): __Value =
          __ObjectValue(
            List(
              "edgeType" -> value.edgeType.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[MapEdgeType]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class MapNodeFilterSettings(
      nodeType: scala.Option[List[MapNodeType]] = None
  )
  object MapNodeFilterSettings {
    implicit val encoder: ArgEncoder[MapNodeFilterSettings] =
      new ArgEncoder[MapNodeFilterSettings] {
        override def encode(value: MapNodeFilterSettings): __Value =
          __ObjectValue(
            List(
              "nodeType" -> value.nodeType.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[MapNodeType]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class MassUpdateIssueInput(
      ids: List[String] = Nil,
      status: scala.Option[IssueStatus] = None,
      priority: scala.Option[IssuePriority] = None,
      executor: scala.Option[String] = None,
      executionTimeLimit: scala.Option[UnixTime] = None,
      comment: scala.Option[String] = None
  )
  object MassUpdateIssueInput {
    implicit val encoder: ArgEncoder[MassUpdateIssueInput] =
      new ArgEncoder[MassUpdateIssueInput] {
        override def encode(value: MassUpdateIssueInput): __Value =
          __ObjectValue(
            List(
              "ids" -> __ListValue(
                value.ids.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "status" -> value.status.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[IssueStatus]].encode(value)
              ),
              "priority" -> value.priority.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[IssuePriority]].encode(value)
              ),
              "executor" -> value.executor.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "executionTimeLimit" -> value.executionTimeLimit.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[UnixTime]].encode(value)),
              "comment" -> value.comment.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class NamedValueType(
      name: String,
      valueTypeId: String,
      view: scala.Option[ComponentView] = None,
      isRequired: scala.Option[Boolean] = None
  )
  object NamedValueType {
    implicit val encoder: ArgEncoder[NamedValueType] =
      new ArgEncoder[NamedValueType] {
        override def encode(value: NamedValueType): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "valueTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.valueTypeId),
              "view" -> value.view.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[ComponentView]].encode(value)
              ),
              "isRequired" -> value.isRequired.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              )
            )
          )
      }
  }
  final case class NERCRegexpInput(
      regexp: String,
      contextRegexp: scala.Option[String] = None,
      autoCreate: scala.Option[Boolean] = None
  )
  object NERCRegexpInput {
    implicit val encoder: ArgEncoder[NERCRegexpInput] =
      new ArgEncoder[NERCRegexpInput] {
        override def encode(value: NERCRegexpInput): __Value =
          __ObjectValue(
            List(
              "regexp" -> implicitly[ArgEncoder[String]].encode(value.regexp),
              "contextRegexp" -> value.contextRegexp.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "autoCreate" -> value.autoCreate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              )
            )
          )
      }
  }
  final case class NodeMoveInput(
      id: String,
      xCoordinate: Double,
      yCoordinate: Double
  )
  object NodeMoveInput {
    implicit val encoder: ArgEncoder[NodeMoveInput] =
      new ArgEncoder[NodeMoveInput] {
        override def encode(value: NodeMoveInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "xCoordinate" -> implicitly[ArgEncoder[Double]]
                .encode(value.xCoordinate),
              "yCoordinate" -> implicitly[ArgEncoder[Double]].encode(
                value.yCoordinate
              )
            )
          )
      }
  }
  final case class NormalizationInput(typeId: String, value: String)
  object NormalizationInput {
    implicit val encoder: ArgEncoder[NormalizationInput] =
      new ArgEncoder[NormalizationInput] {
        override def encode(value: NormalizationInput): __Value =
          __ObjectValue(
            List(
              "typeId" -> implicitly[ArgEncoder[String]].encode(value.typeId),
              "value" -> implicitly[ArgEncoder[String]].encode(value.value)
            )
          )
      }
  }
  final case class OutputLimiterInput(
      maximumPoints: scala.Option[Long] = None,
      minimumNumber: scala.Option[Long] = None
  )
  object OutputLimiterInput {
    implicit val encoder: ArgEncoder[OutputLimiterInput] =
      new ArgEncoder[OutputLimiterInput] {
        override def encode(value: OutputLimiterInput): __Value =
          __ObjectValue(
            List(
              "maximumPoints" -> value.maximumPoints.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Long]].encode(value)
              ),
              "minimumNumber" -> value.minimumNumber.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Long]].encode(value)
              )
            )
          )
      }
  }
  final case class ParameterInput(key: String, value: String)
  object ParameterInput {
    implicit val encoder: ArgEncoder[ParameterInput] =
      new ArgEncoder[ParameterInput] {
        override def encode(value: ParameterInput): __Value =
          __ObjectValue(
            List(
              "key" -> implicitly[ArgEncoder[String]].encode(value.key),
              "value" -> implicitly[ArgEncoder[String]].encode(value.value)
            )
          )
      }
  }
  final case class PerformSynchronously(
      performSynchronously: scala.Option[Boolean] = None
  )
  object PerformSynchronously {
    implicit val encoder: ArgEncoder[PerformSynchronously] =
      new ArgEncoder[PerformSynchronously] {
        override def encode(value: PerformSynchronously): __Value =
          __ObjectValue(
            List(
              "performSynchronously" -> value.performSynchronously.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value))
            )
          )
      }
  }
  final case class PlatformCreationInput(
      name: String,
      id: String,
      platformType: PlatformType,
      url: String,
      country: scala.Option[String] = None,
      language: scala.Option[String] = None,
      markers: scala.Option[List[String]] = None,
      params: scala.Option[List[ParameterInput]] = None
  )
  object PlatformCreationInput {
    implicit val encoder: ArgEncoder[PlatformCreationInput] =
      new ArgEncoder[PlatformCreationInput] {
        override def encode(value: PlatformCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "platformType" -> implicitly[ArgEncoder[PlatformType]]
                .encode(value.platformType),
              "url" -> implicitly[ArgEncoder[String]].encode(value.url),
              "country" -> value.country.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "language" -> value.language.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "params" -> value.params.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ParameterInput]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class PlatformFilterSettings(
      searchString: scala.Option[String] = None,
      id: scala.Option[List[String]] = None,
      platformType: scala.Option[PlatformType] = None,
      markers: scala.Option[List[String]] = None,
      country: scala.Option[List[String]] = None,
      language: scala.Option[List[String]] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object PlatformFilterSettings {
    implicit val encoder: ArgEncoder[PlatformFilterSettings] =
      new ArgEncoder[PlatformFilterSettings] {
        override def encode(value: PlatformFilterSettings): __Value =
          __ObjectValue(
            List(
              "searchString" -> value.searchString.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "platformType" -> value.platformType.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[PlatformType]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "country" -> value.country.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "language" -> value.language.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class PlatformUpdateInput(
      platformId: String,
      name: String,
      newId: String,
      platformType: PlatformType,
      url: String,
      country: scala.Option[String] = None,
      language: scala.Option[String] = None,
      markers: List[String] = Nil,
      params: List[ParameterInput] = Nil
  )
  object PlatformUpdateInput {
    implicit val encoder: ArgEncoder[PlatformUpdateInput] =
      new ArgEncoder[PlatformUpdateInput] {
        override def encode(value: PlatformUpdateInput): __Value =
          __ObjectValue(
            List(
              "platformId" -> implicitly[ArgEncoder[String]]
                .encode(value.platformId),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "newId" -> implicitly[ArgEncoder[String]].encode(value.newId),
              "platformType" -> implicitly[ArgEncoder[PlatformType]]
                .encode(value.platformType),
              "url" -> implicitly[ArgEncoder[String]].encode(value.url),
              "country" -> value.country.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "language" -> value.language.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "markers" -> __ListValue(
                value.markers.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "params" -> __ListValue(
                value.params.map(value =>
                  implicitly[ArgEncoder[ParameterInput]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class PostSorting(
      nercs: scala.Option[Int] = None,
      facts: scala.Option[Int] = None,
      researchMap: scala.Option[PostSortingMetric] = None,
      concept: scala.Option[PostSortingMetric] = None
  )
  object PostSorting {
    implicit val encoder: ArgEncoder[PostSorting] =
      new ArgEncoder[PostSorting] {
        override def encode(value: PostSorting): __Value =
          __ObjectValue(
            List(
              "nercs" -> value.nercs.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "facts" -> value.facts.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "researchMap" -> value.researchMap.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[PostSortingMetric]].encode(value)
              ),
              "concept" -> value.concept.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[PostSortingMetric]].encode(value)
              )
            )
          )
      }
  }
  final case class PostSortingMetric(id: String, multiplier: Int)
  object PostSortingMetric {
    implicit val encoder: ArgEncoder[PostSortingMetric] =
      new ArgEncoder[PostSortingMetric] {
        override def encode(value: PostSortingMetric): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "multiplier" -> implicitly[ArgEncoder[Int]].encode(
                value.multiplier
              )
            )
          )
      }
  }
  final case class PropertyFilterSettings(
      propertyTypeId: String,
      componentId: scala.Option[String] = None,
      propertyType: PropLinkOrConcept,
      stringFilter: scala.Option[StringFilter] = None,
      intFilter: scala.Option[IntervalInt] = None,
      doubleFilter: scala.Option[IntervalDouble] = None,
      dateTimeFilter: scala.Option[DateTimeIntervalInput] = None,
      dateTimeIntervalFilter: scala.Option[DateTimeIntervalPairInput] = None,
      geoFilter: scala.Option[GeoPointWithNameFormInput] = None
  )
  object PropertyFilterSettings {
    implicit val encoder: ArgEncoder[PropertyFilterSettings] =
      new ArgEncoder[PropertyFilterSettings] {
        override def encode(value: PropertyFilterSettings): __Value =
          __ObjectValue(
            List(
              "propertyTypeId" -> implicitly[ArgEncoder[String]]
                .encode(value.propertyTypeId),
              "componentId" -> value.componentId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "propertyType" -> implicitly[ArgEncoder[PropLinkOrConcept]]
                .encode(value.propertyType),
              "stringFilter" -> value.stringFilter.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[StringFilter]].encode(value)
              ),
              "intFilter" -> value.intFilter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[IntervalInt]].encode(value)
              ),
              "doubleFilter" -> value.doubleFilter.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[IntervalDouble]].encode(value)
              ),
              "dateTimeFilter" -> value.dateTimeFilter.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[DateTimeIntervalInput]].encode(value)
              ),
              "dateTimeIntervalFilter" -> value.dateTimeIntervalFilter.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[DateTimeIntervalPairInput]].encode(value)
              ),
              "geoFilter" -> value.geoFilter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[GeoPointWithNameFormInput]].encode(value)
              )
            )
          )
      }
  }
  final case class RedmineIssueCreationInput(
      objIds: List[String] = Nil,
      issueType: RedmineIssueType,
      subject: String,
      assigneeId: String,
      trackerId: String,
      statusId: String,
      priorityId: String,
      dueTo: scala.Option[Long] = None,
      description: scala.Option[String] = None,
      relatedIssues: scala.Option[List[String]] = None
  )
  object RedmineIssueCreationInput {
    implicit val encoder: ArgEncoder[RedmineIssueCreationInput] =
      new ArgEncoder[RedmineIssueCreationInput] {
        override def encode(value: RedmineIssueCreationInput): __Value =
          __ObjectValue(
            List(
              "objIds" -> __ListValue(
                value.objIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "issueType" -> implicitly[ArgEncoder[RedmineIssueType]]
                .encode(value.issueType),
              "subject" -> implicitly[ArgEncoder[String]].encode(value.subject),
              "assigneeId" -> implicitly[ArgEncoder[String]]
                .encode(value.assigneeId),
              "trackerId" -> implicitly[ArgEncoder[String]]
                .encode(value.trackerId),
              "statusId" -> implicitly[ArgEncoder[String]]
                .encode(value.statusId),
              "priorityId" -> implicitly[ArgEncoder[String]]
                .encode(value.priorityId),
              "dueTo" -> value.dueTo.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Long]].encode(value)
              ),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "relatedIssues" -> value.relatedIssues.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              )
            )
          )
      }
  }
  final case class RedmineIssueDefaultParametersInput(
      objIds: List[String] = Nil,
      issueType: RedmineIssueType
  )
  object RedmineIssueDefaultParametersInput {
    implicit val encoder: ArgEncoder[RedmineIssueDefaultParametersInput] =
      new ArgEncoder[RedmineIssueDefaultParametersInput] {
        override def encode(
            value: RedmineIssueDefaultParametersInput
        ): __Value =
          __ObjectValue(
            List(
              "objIds" -> __ListValue(
                value.objIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "issueType" -> implicitly[ArgEncoder[RedmineIssueType]].encode(
                value.issueType
              )
            )
          )
      }
  }
  final case class RedmineIssueUnlinkInput(
      objectId: String,
      issueType: RedmineIssueType,
      issueIds: List[String] = Nil
  )
  object RedmineIssueUnlinkInput {
    implicit val encoder: ArgEncoder[RedmineIssueUnlinkInput] =
      new ArgEncoder[RedmineIssueUnlinkInput] {
        override def encode(value: RedmineIssueUnlinkInput): __Value =
          __ObjectValue(
            List(
              "objectId" -> implicitly[ArgEncoder[String]]
                .encode(value.objectId),
              "issueType" -> implicitly[ArgEncoder[RedmineIssueType]]
                .encode(value.issueType),
              "issueIds" -> __ListValue(
                value.issueIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class RedmineIssueUpdateInput(
      objIds: List[String] = Nil,
      issueType: RedmineIssueType,
      issueIds: List[String] = Nil,
      description: String
  )
  object RedmineIssueUpdateInput {
    implicit val encoder: ArgEncoder[RedmineIssueUpdateInput] =
      new ArgEncoder[RedmineIssueUpdateInput] {
        override def encode(value: RedmineIssueUpdateInput): __Value =
          __ObjectValue(
            List(
              "objIds" -> __ListValue(
                value.objIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "issueType" -> implicitly[ArgEncoder[RedmineIssueType]]
                .encode(value.issueType),
              "issueIds" -> __ListValue(
                value.issueIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "description" -> implicitly[ArgEncoder[String]].encode(
                value.description
              )
            )
          )
      }
  }
  final case class RegexpToUpdate(
      regexpToReplace: scala.Option[NERCRegexpInput] = None,
      regexpToInsert: scala.Option[NERCRegexpInput] = None
  )
  object RegexpToUpdate {
    implicit val encoder: ArgEncoder[RegexpToUpdate] =
      new ArgEncoder[RegexpToUpdate] {
        override def encode(value: RegexpToUpdate): __Value =
          __ObjectValue(
            List(
              "regexpToReplace" -> value.regexpToReplace.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[NERCRegexpInput]].encode(value)),
              "regexpToInsert" -> value.regexpToInsert.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[NERCRegexpInput]].encode(value))
            )
          )
      }
  }
  final case class RelatedDocumentFilterSettings(
      documentType: scala.Option[DocumentType] = None,
      publicationDate: scala.Option[TimestampInterval] = None,
      registrationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None
  )
  object RelatedDocumentFilterSettings {
    implicit val encoder: ArgEncoder[RelatedDocumentFilterSettings] =
      new ArgEncoder[RelatedDocumentFilterSettings] {
        override def encode(value: RelatedDocumentFilterSettings): __Value =
          __ObjectValue(
            List(
              "documentType" -> value.documentType.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[DocumentType]].encode(value)
              ),
              "publicationDate" -> value.publicationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "registrationDate" -> value.registrationDate.fold(
                __NullValue: __Value
              )(value =>
                implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              )
            )
          )
      }
  }
  final case class RelExtModelInput(
      sourceAnnotationType: String,
      targetAnnotationType: String,
      relationType: String,
      invertDirection: Boolean
  )
  object RelExtModelInput {
    implicit val encoder: ArgEncoder[RelExtModelInput] =
      new ArgEncoder[RelExtModelInput] {
        override def encode(value: RelExtModelInput): __Value =
          __ObjectValue(
            List(
              "sourceAnnotationType" -> implicitly[ArgEncoder[String]]
                .encode(value.sourceAnnotationType),
              "targetAnnotationType" -> implicitly[ArgEncoder[String]]
                .encode(value.targetAnnotationType),
              "relationType" -> implicitly[ArgEncoder[String]]
                .encode(value.relationType),
              "invertDirection" -> implicitly[ArgEncoder[Boolean]].encode(
                value.invertDirection
              )
            )
          )
      }
  }
  final case class ResearchMapBatchMoveInput(
      nodeMoveInput: List[NodeMoveInput] = Nil
  )
  object ResearchMapBatchMoveInput {
    implicit val encoder: ArgEncoder[ResearchMapBatchMoveInput] =
      new ArgEncoder[ResearchMapBatchMoveInput] {
        override def encode(value: ResearchMapBatchMoveInput): __Value =
          __ObjectValue(
            List(
              "nodeMoveInput" -> __ListValue(
                value.nodeMoveInput.map(value =>
                  implicitly[ArgEncoder[NodeMoveInput]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class ResearchMapBatchUpdateGroupInput(
      nodeIds: scala.Option[List[String]] = None,
      groupId: scala.Option[String] = None
  )
  object ResearchMapBatchUpdateGroupInput {
    implicit val encoder: ArgEncoder[ResearchMapBatchUpdateGroupInput] =
      new ArgEncoder[ResearchMapBatchUpdateGroupInput] {
        override def encode(value: ResearchMapBatchUpdateGroupInput): __Value =
          __ObjectValue(
            List(
              "nodeIds" -> value.nodeIds.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "groupId" -> value.groupId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ResearchMapContentAddInput(
      documents: scala.Option[List[DocumentAddInputInput]] = None,
      concepts: scala.Option[List[ConceptAddInputInput]] = None,
      conceptCandidates: scala.Option[List[ConceptCandidateAddInputInput]] =
        None
  )
  object ResearchMapContentAddInput {
    implicit val encoder: ArgEncoder[ResearchMapContentAddInput] =
      new ArgEncoder[ResearchMapContentAddInput] {
        override def encode(value: ResearchMapContentAddInput): __Value =
          __ObjectValue(
            List(
              "documents" -> value.documents.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[DocumentAddInputInput]].encode(value)
                  )
                )
              ),
              "concepts" -> value.concepts.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptAddInputInput]].encode(value)
                  )
                )
              ),
              "conceptCandidates" -> value.conceptCandidates.fold(
                __NullValue: __Value
              )(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[ConceptCandidateAddInputInput]]
                      .encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ResearchMapContentSelectInput(
      nodes: scala.Option[List[String]] = None
  )
  object ResearchMapContentSelectInput {
    implicit val encoder: ArgEncoder[ResearchMapContentSelectInput] =
      new ArgEncoder[ResearchMapContentSelectInput] {
        override def encode(value: ResearchMapContentSelectInput): __Value =
          __ObjectValue(
            List(
              "nodes" -> value.nodes.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ResearchMapContentUpdateInput(
      nodes: scala.Option[List[String]] = None
  )
  object ResearchMapContentUpdateInput {
    implicit val encoder: ArgEncoder[ResearchMapContentUpdateInput] =
      new ArgEncoder[ResearchMapContentUpdateInput] {
        override def encode(value: ResearchMapContentUpdateInput): __Value =
          __ObjectValue(
            List(
              "nodes" -> value.nodes.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ResearchMapCreationInput(
      name: scala.Option[String] = None,
      concepts: scala.Option[List[String]] = None,
      documents: scala.Option[List[String]] = None,
      description: scala.Option[String] = None,
      accessLevelId: scala.Option[String] = None,
      markers: scala.Option[List[String]] = None
  )
  object ResearchMapCreationInput {
    implicit val encoder: ArgEncoder[ResearchMapCreationInput] =
      new ArgEncoder[ResearchMapCreationInput] {
        override def encode(value: ResearchMapCreationInput): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "concepts" -> value.concepts.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "documents" -> value.documents.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class ResearchMapFilterSettings(
      name: scala.Option[String] = None,
      description: scala.Option[String] = None,
      accessLevelId: scala.Option[String] = None,
      creator: scala.Option[List[String]] = None,
      lastUpdater: scala.Option[List[String]] = None,
      markers: scala.Option[List[String]] = None,
      creationDate: scala.Option[TimestampInterval] = None,
      updateDate: scala.Option[TimestampInterval] = None,
      conceptId: scala.Option[String] = None
  )
  object ResearchMapFilterSettings {
    implicit val encoder: ArgEncoder[ResearchMapFilterSettings] =
      new ArgEncoder[ResearchMapFilterSettings] {
        override def encode(value: ResearchMapFilterSettings): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "accessLevelId" -> value.accessLevelId.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "creator" -> value.creator.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "lastUpdater" -> value.lastUpdater.fold(__NullValue: __Value)(
                value =>
                  __ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "creationDate" -> value.creationDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "updateDate" -> value.updateDate.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[TimestampInterval]].encode(value)
              ),
              "conceptId" -> value.conceptId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class ResearchMapUpdateInput(
      name: String,
      description: scala.Option[String] = None,
      accessLevelId: String,
      markers: scala.Option[List[String]] = None
  )
  object ResearchMapUpdateInput {
    implicit val encoder: ArgEncoder[ResearchMapUpdateInput] =
      new ArgEncoder[ResearchMapUpdateInput] {
        override def encode(value: ResearchMapUpdateInput): __Value =
          __ObjectValue(
            List(
              "name" -> implicitly[ArgEncoder[String]].encode(value.name),
              "description" -> value.description.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "accessLevelId" -> implicitly[ArgEncoder[String]]
                .encode(value.accessLevelId),
              "markers" -> value.markers.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class SearchElementToUpdate(
      dict: scala.Option[WordsToUpdate] = None,
      regexp: scala.Option[RegexpToUpdate] = None
  )
  object SearchElementToUpdate {
    implicit val encoder: ArgEncoder[SearchElementToUpdate] =
      new ArgEncoder[SearchElementToUpdate] {
        override def encode(value: SearchElementToUpdate): __Value =
          __ObjectValue(
            List(
              "dict" -> value.dict.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[WordsToUpdate]].encode(value)
              ),
              "regexp" -> value.regexp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[RegexpToUpdate]].encode(value)
              )
            )
          )
      }
  }
  final case class StringFilter(str: String)
  object StringFilter {
    implicit val encoder: ArgEncoder[StringFilter] =
      new ArgEncoder[StringFilter] {
        override def encode(value: StringFilter): __Value =
          __ObjectValue(
            List("str" -> implicitly[ArgEncoder[String]].encode(value.str))
          )
      }
  }
  final case class StringLocaleValueInput(value: String, locale: Locale)
  object StringLocaleValueInput {
    implicit val encoder: ArgEncoder[StringLocaleValueInput] =
      new ArgEncoder[StringLocaleValueInput] {
        override def encode(value: StringLocaleValueInput): __Value =
          __ObjectValue(
            List(
              "value" -> implicitly[ArgEncoder[String]].encode(value.value),
              "locale" -> implicitly[ArgEncoder[Locale]].encode(value.locale)
            )
          )
      }
  }
  final case class StringValueInput(value: String)
  object StringValueInput {
    implicit val encoder: ArgEncoder[StringValueInput] =
      new ArgEncoder[StringValueInput] {
        override def encode(value: StringValueInput): __Value =
          __ObjectValue(
            List("value" -> implicitly[ArgEncoder[String]].encode(value.value))
          )
      }
  }
  final case class TextBoundingInput(start: Int, end: Int, nodeId: String)
  object TextBoundingInput {
    implicit val encoder: ArgEncoder[TextBoundingInput] =
      new ArgEncoder[TextBoundingInput] {
        override def encode(value: TextBoundingInput): __Value =
          __ObjectValue(
            List(
              "start" -> implicitly[ArgEncoder[Int]].encode(value.start),
              "end" -> implicitly[ArgEncoder[Int]].encode(value.end),
              "nodeId" -> implicitly[ArgEncoder[String]].encode(value.nodeId)
            )
          )
      }
  }
  final case class TimeInput(hour: Int, minute: Int, second: Int)
  object TimeInput {
    implicit val encoder: ArgEncoder[TimeInput] = new ArgEncoder[TimeInput] {
      override def encode(value: TimeInput): __Value =
        __ObjectValue(
          List(
            "hour" -> implicitly[ArgEncoder[Int]].encode(value.hour),
            "minute" -> implicitly[ArgEncoder[Int]].encode(value.minute),
            "second" -> implicitly[ArgEncoder[Int]].encode(value.second)
          )
        )
    }
  }
  final case class TimestampInterval(
      start: scala.Option[UnixTime] = None,
      end: scala.Option[UnixTime] = None
  )
  object TimestampInterval {
    implicit val encoder: ArgEncoder[TimestampInterval] =
      new ArgEncoder[TimestampInterval] {
        override def encode(value: TimestampInterval): __Value =
          __ObjectValue(
            List(
              "start" -> value.start.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[UnixTime]].encode(value)
              ),
              "end" -> value.end.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[UnixTime]].encode(value)
              )
            )
          )
      }
  }
  final case class TranslationInput(language: LanguageInput, text: String)
  object TranslationInput {
    implicit val encoder: ArgEncoder[TranslationInput] =
      new ArgEncoder[TranslationInput] {
        override def encode(value: TranslationInput): __Value =
          __ObjectValue(
            List(
              "language" -> implicitly[ArgEncoder[LanguageInput]]
                .encode(value.language),
              "text" -> implicitly[ArgEncoder[String]].encode(value.text)
            )
          )
      }
  }
  final case class TypeSearchElementUpdateInput(
      id: String,
      elementsType: ElementType,
      searchElementToUpdate: List[SearchElementToUpdate] = Nil
  )
  object TypeSearchElementUpdateInput {
    implicit val encoder: ArgEncoder[TypeSearchElementUpdateInput] =
      new ArgEncoder[TypeSearchElementUpdateInput] {
        override def encode(value: TypeSearchElementUpdateInput): __Value =
          __ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "elementsType" -> implicitly[ArgEncoder[ElementType]]
                .encode(value.elementsType),
              "searchElementToUpdate" -> __ListValue(
                value.searchElementToUpdate.map(value =>
                  implicitly[ArgEncoder[SearchElementToUpdate]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class UpdateCommentInput(taskChangeId: String, comment: String)
  object UpdateCommentInput {
    implicit val encoder: ArgEncoder[UpdateCommentInput] =
      new ArgEncoder[UpdateCommentInput] {
        override def encode(value: UpdateCommentInput): __Value =
          __ObjectValue(
            List(
              "taskChangeId" -> implicitly[ArgEncoder[String]]
                .encode(value.taskChangeId),
              "comment" -> implicitly[ArgEncoder[String]].encode(value.comment)
            )
          )
      }
  }
  final case class ValueInput(
      stringValueInput: scala.Option[StringValueInput] = None,
      stringLocaleValueInput: scala.Option[StringLocaleValueInput] = None,
      intValueInput: scala.Option[IntValueInput] = None,
      doubleValueInput: scala.Option[DoubleValueInput] = None,
      geoPointValueInput: scala.Option[GeoPointInput] = None,
      dateTimeValueInput: scala.Option[DateTimeValueInput] = None,
      linkValueInput: scala.Option[LinkValueInput] = None
  )
  object ValueInput {
    implicit val encoder: ArgEncoder[ValueInput] = new ArgEncoder[ValueInput] {
      override def encode(value: ValueInput): __Value =
        __ObjectValue(
          List(
            "stringValueInput" -> value.stringValueInput.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[StringValueInput]].encode(value)),
            "stringLocaleValueInput" -> value.stringLocaleValueInput.fold(
              __NullValue: __Value
            )(value =>
              implicitly[ArgEncoder[StringLocaleValueInput]].encode(value)
            ),
            "intValueInput" -> value.intValueInput.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[IntValueInput]].encode(value)
            ),
            "doubleValueInput" -> value.doubleValueInput.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[DoubleValueInput]].encode(value)),
            "geoPointValueInput" -> value.geoPointValueInput.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[GeoPointInput]].encode(value)),
            "dateTimeValueInput" -> value.dateTimeValueInput.fold(
              __NullValue: __Value
            )(value =>
              implicitly[ArgEncoder[DateTimeValueInput]].encode(value)
            ),
            "linkValueInput" -> value.linkValueInput.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[LinkValueInput]].encode(value)
            )
          )
        )
    }
  }
  final case class WordsToUpdate(
      wordToReplace: scala.Option[String] = None,
      wordToInsert: scala.Option[String] = None
  )
  object WordsToUpdate {
    implicit val encoder: ArgEncoder[WordsToUpdate] =
      new ArgEncoder[WordsToUpdate] {
        override def encode(value: WordsToUpdate): __Value =
          __ObjectValue(
            List(
              "wordToReplace" -> value.wordToReplace.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "wordToInsert" -> value.wordToInsert.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  type Query = _root_.caliban.client.Operations.RootQuery
  object Query {
    def document[A](id: String)(
        innerSelection: SelectionBuilder[Document, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "document",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )
    def story[A](ids: List[String] = Nil)(
        innerSelection: SelectionBuilder[Story, A]
    )(implicit encoder0: ArgEncoder[List[String]]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "story",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
    )
    def paginationStory[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        grouping: scala.Option[DocumentGrouping] = None,
        query: scala.Option[String] = None,
        filterSettings: scala.Option[DocumentFilterSettings] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[DocumentSorting] = None,
        extraSettings: ExtraSettings,
        postSorting: scala.Option[PostSorting] = None
    )(innerSelection: SelectionBuilder[StoryPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[DocumentGrouping]],
        encoder3: ArgEncoder[scala.Option[String]],
        encoder4: ArgEncoder[scala.Option[DocumentFilterSettings]],
        encoder5: ArgEncoder[scala.Option[SortDirection]],
        encoder6: ArgEncoder[scala.Option[DocumentSorting]],
        encoder7: ArgEncoder[ExtraSettings],
        encoder8: ArgEncoder[scala.Option[PostSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationStory",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("grouping", grouping, "DocumentGrouping")(encoder2),
          Argument("query", query, "String")(encoder3),
          Argument("filterSettings", filterSettings, "DocumentFilterSettings")(
            encoder4
          ),
          Argument("direction", direction, "SortDirection")(encoder5),
          Argument("sortField", sortField, "DocumentSorting")(encoder6),
          Argument("extraSettings", extraSettings, "ExtraSettings!")(encoder7),
          Argument("postSorting", postSorting, "PostSorting")(encoder8)
        )
      )
    def paginationDocumentMarkers[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        direction: scala.Option[SortDirection] = None
    )(innerSelection: SelectionBuilder[CommonStringPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[SortDirection]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationDocumentMarkers",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("direction", direction, "SortDirection")(encoder2)
        )
      )
    def conceptType[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def compositeConceptType[A](
        id: String
    )(innerSelection: SelectionBuilder[CompositeConceptType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "compositeConceptType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def paginationCompositeConceptType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: CompositeConceptTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[CompositeConceptTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[CompositeConceptTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[CompositeConceptTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[CompositeConceptTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationCompositeConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "CompositeConceptTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "CompositeConceptTypeSorting")(
            encoder4
          )
        )
      )
    def conceptPropertyType[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptPropertyType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def conceptLinkType[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptLinkType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptLinkType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def conceptPropertyValueType[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptPropertyValueType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptPropertyValueType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def listConceptType[A](
        innerSelection: SelectionBuilder[ConceptType, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptType", ListOf(Obj(innerSelection)))
    def listUserMenuType[A](
        onCompositeConceptType: SelectionBuilder[CompositeConceptType, A],
        onConceptType: SelectionBuilder[ConceptType, A],
        onConceptTypeView: SelectionBuilder[ConceptTypeView, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listUserMenuType",
        ListOf(
          ChoiceOf(
            Map(
              "CompositeConceptType" -> Obj(onCompositeConceptType),
              "ConceptType" -> Obj(onConceptType),
              "ConceptTypeView" -> Obj(onConceptTypeView)
            )
          )
        )
      )
    def listConceptPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptPropertyType", ListOf(Obj(innerSelection)))
    def listConceptPropertyTypeById[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "listConceptPropertyTypeById",
      ListOf(OptionOf(Obj(innerSelection))),
      arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
    )
    def listConceptLinkType[A](
        innerSelection: SelectionBuilder[ConceptLinkType, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptLinkType", ListOf(Obj(innerSelection)))
    def listConceptPropertyValueType[A](
        innerSelection: SelectionBuilder[ConceptPropertyValueType, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listConceptPropertyValueType", ListOf(Obj(innerSelection)))
    def paginationConceptType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptTypeSorting] = None
    )(innerSelection: SelectionBuilder[ConceptTypePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ConceptTypeSorting")(encoder4)
        )
      )
    def paginationConceptPropertyType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptPropertyTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptPropertyTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[ConceptPropertyTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptPropertyTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ConceptPropertyTypeSorting")(
            encoder4
          )
        )
      )
    def paginationConceptLinkPropertyType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptPropertyTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptPropertyTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[ConceptPropertyTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptPropertyTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ConceptPropertyTypeSorting")(
            encoder4
          )
        )
      )
    def paginationConceptLinkType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptLinkTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptLinkTypeSorting] = None
    )(innerSelection: SelectionBuilder[ConceptLinkTypePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptLinkTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptLinkTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLinkType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptLinkTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ConceptLinkTypeSorting")(encoder4)
        )
      )
    def paginationConceptPropertyValueType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptPropertyValueTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptPropertyValueTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[ConceptPropertyValueTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptPropertyValueTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ConceptPropertyValueTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptPropertyValueType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptPropertyValueTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ConceptPropertyValueTypeSorting")(
            encoder4
          )
        )
      )
    def compositeConceptPropertyType[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "compositeConceptPropertyType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def compositeLinkPropertyType[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "compositeLinkPropertyType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def listCompositeConceptPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCompositeConceptPropertyType", ListOf(Obj(innerSelection)))
    def listCompositeLinkPropertyType[A](
        innerSelection: SelectionBuilder[ConceptPropertyType, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listCompositeLinkPropertyType", ListOf(Obj(innerSelection)))
    def paginationCompositeConceptPropertyType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: CompositePropertyTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[CompositePropertyTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[ConceptPropertyTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[CompositePropertyTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[CompositePropertyTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationCompositeConceptPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "CompositePropertyTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "CompositePropertyTypeSorting")(
            encoder4
          )
        )
      )
    def paginationCompositeLinkPropertyType[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: CompositePropertyTypeFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[CompositePropertyTypeSorting] = None
    )(
        innerSelection: SelectionBuilder[ConceptPropertyTypePagination, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[CompositePropertyTypeFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[CompositePropertyTypeSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationCompositeLinkPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "CompositePropertyTypeFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "CompositePropertyTypeSorting")(
            encoder4
          )
        )
      )
    def compositePropertyValueTemplate[A](id: String)(
        innerSelection: SelectionBuilder[CompositePropertyValueTemplate, A]
    )(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "compositePropertyValueTemplate",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def listCompositePropertyValueTemplate[A](
        innerSelection: SelectionBuilder[CompositePropertyValueTemplate, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listCompositePropertyValueTemplate",
        ListOf(Obj(innerSelection))
      )
    def paginationCompositePropertyValueTemplate[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: CompositePropertyValueTemplateFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[CompositePropertyValueTemplateSorting] = None
    )(
        innerSelection: SelectionBuilder[
          CompositePropertyValueTemplatePagination,
          A
        ]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[CompositePropertyValueTemplateFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[
          scala.Option[CompositePropertyValueTemplateSorting]
        ]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationCompositePropertyValueTemplate",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "CompositePropertyValueTemplateFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument(
            "sortField",
            sortField,
            "CompositePropertyValueTemplateSorting"
          )(encoder4)
        )
      )
    def conceptTypeView[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptTypeView, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptTypeView",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def domainMap[A](
        innerSelection: SelectionBuilder[DomainMap, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("domainMap", Obj(innerSelection))
    def concept[A](id: String)(
        innerSelection: SelectionBuilder[Concept, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "concept",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )
    def listConceptById[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[Concept, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "listConceptById",
      ListOf(OptionOf(Obj(innerSelection))),
      arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
    )
    def paginationConcept[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        query: scala.Option[String] = None,
        filterSettings: scala.Option[ConceptFilterSettings] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptSorting] = None
    )(innerSelection: SelectionBuilder[ConceptPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[String]],
        encoder3: ArgEncoder[scala.Option[ConceptFilterSettings]],
        encoder4: ArgEncoder[scala.Option[SortDirection]],
        encoder5: ArgEncoder[scala.Option[ConceptSorting]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "paginationConcept",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("limit", limit, "Int")(encoder0),
        Argument("offset", offset, "Int")(encoder1),
        Argument("query", query, "String")(encoder2),
        Argument("filterSettings", filterSettings, "ConceptFilterSettings")(
          encoder3
        ),
        Argument("direction", direction, "SortDirection")(encoder4),
        Argument("sortField", sortField, "ConceptSorting")(encoder5)
      )
    )
    def compositeConcept[A](
        compositeConceptTypeId: String,
        rootConceptId: String
    )(innerSelection: SelectionBuilder[CompositeConcept, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "compositeConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("compositeConceptTypeId", compositeConceptTypeId, "ID!")(
            encoder0
          ),
          Argument("rootConceptId", rootConceptId, "ID!")(encoder1)
        )
      )
    def paginationCompositeConcept[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        query: scala.Option[String] = None,
        compositeConceptFilterSettings: scala.Option[
          CompositeConceptFilterSettings
        ] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ConceptSorting] = None
    )(innerSelection: SelectionBuilder[CompositeConceptPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[String]],
        encoder3: ArgEncoder[scala.Option[CompositeConceptFilterSettings]],
        encoder4: ArgEncoder[scala.Option[SortDirection]],
        encoder5: ArgEncoder[scala.Option[ConceptSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationCompositeConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("query", query, "String")(encoder2),
          Argument(
            "compositeConceptFilterSettings",
            compositeConceptFilterSettings,
            "CompositeConceptFilterSettings"
          )(encoder3),
          Argument("direction", direction, "SortDirection")(encoder4),
          Argument("sortField", sortField, "ConceptSorting")(encoder5)
        )
      )
    def listConceptLinkBetweenFixedConcepts[A](
        ids: List[String] = Nil,
        filterSettings: ConceptLinkFilterSettings
    )(innerSelection: SelectionBuilder[ConceptLink, A])(implicit
        encoder0: ArgEncoder[List[String]],
        encoder1: ArgEncoder[ConceptLinkFilterSettings]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listConceptLinkBetweenFixedConcepts",
        ListOf(Obj(innerSelection)),
        arguments = List(
          Argument("ids", ids, "[ID!]!")(encoder0),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptLinkFilterSettings!"
          )(encoder1)
        )
      )
    def conceptProperty[A](id: String)(
        innerSelection: SelectionBuilder[ConceptProperty, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "conceptProperty",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )
    def conceptLink[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptLink, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptLink",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def paginationConceptLink[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ConceptLinkFilterSettings
    )(innerSelection: SelectionBuilder[ConceptLinkPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ConceptLinkFilterSettings]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationConceptLink",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ConceptLinkFilterSettings!"
          )(encoder2)
        )
      )
    def paginationKBRelatedDocument[A](
        id: String,
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: RelatedDocumentFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[RelatedDocumentSorting] = None
    )(innerSelection: SelectionBuilder[DocumentPagination, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[RelatedDocumentFilterSettings],
        encoder4: ArgEncoder[scala.Option[SortDirection]],
        encoder5: ArgEncoder[scala.Option[RelatedDocumentSorting]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "paginationKBRelatedDocument",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("id", id, "ID!")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument(
          "filterSettings",
          filterSettings,
          "RelatedDocumentFilterSettings!"
        )(encoder3),
        Argument("direction", direction, "SortDirection")(encoder4),
        Argument("sortField", sortField, "RelatedDocumentSorting")(encoder5)
      )
    )
    def issue[A](id: String)(
        innerSelection: SelectionBuilder[Issue, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "issue",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )
    def paginationIssue[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: IssueFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[IssueSorting] = None
    )(innerSelection: SelectionBuilder[IssuePagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[IssueFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[IssueSorting]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "paginationIssue",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("limit", limit, "Int")(encoder0),
        Argument("offset", offset, "Int")(encoder1),
        Argument("filterSettings", filterSettings, "IssueFilterSettings!")(
          encoder2
        ),
        Argument("direction", direction, "SortDirection")(encoder3),
        Argument("sortField", sortField, "IssueSorting")(encoder4)
      )
    )
    def paginationIssueChange[A](
        id: String,
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[IssueChangePagination, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationIssueChange",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2)
        )
      )
    def researchMap[A](
        id: String
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "researchMap",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def paginationResearchMap[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: ResearchMapFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[ResearchMapSorting] = None
    )(innerSelection: SelectionBuilder[ResearchMapPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ResearchMapFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[ResearchMapSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationResearchMap",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "ResearchMapFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "ResearchMapSorting")(encoder4)
        )
      )
    def activeResearchMap[A](
        innerSelection: SelectionBuilder[ResearchMap, A]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("activeResearchMap", OptionOf(Obj(innerSelection)))
    def listTopNeighborsOnMap[A](
        id: String,
        form: ResearchMapContentSelectInput,
        quantity: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[ConceptWithNeighbors, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ResearchMapContentSelectInput],
        encoder2: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listTopNeighborsOnMap",
        ListOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ResearchMapContentSelectInput!")(encoder1),
          Argument("quantity", quantity, "Int")(encoder2)
        )
      )
    def listLastResearchMap[A](
        innerSelection: SelectionBuilder[ResearchMap, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("listLastResearchMap", ListOf(Obj(innerSelection)))
    def documentAutocomplete[A](
        destination: AutocompleteDocumentDestination,
        query: String
    )(innerSelection: SelectionBuilder[Autocomplete, A])(implicit
        encoder0: ArgEncoder[AutocompleteDocumentDestination],
        encoder1: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "documentAutocomplete",
        Obj(innerSelection),
        arguments = List(
          Argument(
            "destination",
            destination,
            "AutocompleteDocumentDestination!"
          )(encoder0),
          Argument("query", query, "String!")(encoder1)
        )
      )
    def conceptAutocomplete[A](
        destination: AutocompleteConceptDestination,
        query: String
    )(innerSelection: SelectionBuilder[Autocomplete, A])(implicit
        encoder0: ArgEncoder[AutocompleteConceptDestination],
        encoder1: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptAutocomplete",
        Obj(innerSelection),
        arguments = List(
          Argument(
            "destination",
            destination,
            "AutocompleteConceptDestination!"
          )(encoder0),
          Argument("query", query, "String!")(encoder1)
        )
      )
    def getOsmPlaceName[A](latitude: Double, longitude: Double)(
        innerSelection: SelectionBuilder[GeoPointValue, A]
    )(implicit
        encoder0: ArgEncoder[Double],
        encoder1: ArgEncoder[Double]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "getOsmPlaceName",
        Obj(innerSelection),
        arguments = List(
          Argument("latitude", latitude, "Float!")(encoder0),
          Argument("longitude", longitude, "Float!")(encoder1)
        )
      )
    def getOsmCoordinates[A](
        name: String
    )(innerSelection: SelectionBuilder[GeoPointValue, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "getOsmCoordinates",
        Obj(innerSelection),
        arguments = List(Argument("name", name, "String!")(encoder0))
      )
    def getRedmineIssueCreationDefaultParameters[A](
        form: RedmineIssueDefaultParametersInput
    )(
        innerSelection: SelectionBuilder[
          RedmineIssueCreationDefaultParameters,
          A
        ]
    )(implicit
        encoder0: ArgEncoder[RedmineIssueDefaultParametersInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "getRedmineIssueCreationDefaultParameters",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "RedmineIssueDefaultParametersInput!")(
            encoder0
          )
        )
      )
    def getRedmineIssueUpdateDefaultDescription(
        form: RedmineIssueDefaultParametersInput
    )(implicit
        encoder0: ArgEncoder[RedmineIssueDefaultParametersInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, String] =
      _root_.caliban.client.SelectionBuilder.Field(
        "getRedmineIssueUpdateDefaultDescription",
        Scalar(),
        arguments = List(
          Argument("form", form, "RedmineIssueDefaultParametersInput!")(
            encoder0
          )
        )
      )
    def searchSimilarRedmineIssues[A](
        id: String
    )(innerSelection: SelectionBuilder[RedmineIssuePagination, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "searchSimilarRedmineIssues",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def accessLevel[A](
        id: String
    )(innerSelection: SelectionBuilder[AccessLevel, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "accessLevel",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def paginationAccessLevel[A](
        query: scala.Option[String] = None,
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[AccessLevelSorting] = None
    )(innerSelection: SelectionBuilder[AccessLevelPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[AccessLevelSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationAccessLevel",
        Obj(innerSelection),
        arguments = List(
          Argument("query", query, "String")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "AccessLevelSorting")(encoder4)
        )
      )
    def storyFs2Query(
        filterSettings: DocumentFilterSettings,
        extraSettings: ExtraSettings
    )(implicit
        encoder0: ArgEncoder[DocumentFilterSettings],
        encoder1: ArgEncoder[ExtraSettings]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, String] =
      _root_.caliban.client.SelectionBuilder.Field(
        "storyFs2Query",
        Scalar(),
        arguments = List(
          Argument("filterSettings", filterSettings, "DocumentFilterSettings!")(
            encoder0
          ),
          Argument("extraSettings", extraSettings, "ExtraSettings!")(encoder1)
        )
      )
    def conceptFs2Query(filterSettings: ConceptFilterSettings)(implicit
        encoder0: ArgEncoder[ConceptFilterSettings]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, String] =
      _root_.caliban.client.SelectionBuilder.Field(
        "conceptFs2Query",
        Scalar(),
        arguments = List(
          Argument("filterSettings", filterSettings, "ConceptFilterSettings!")(
            encoder0
          )
        )
      )
    def markersBulk[A](
        form: BulkMarkersInput
    )(innerSelection: SelectionBuilder[Markers, A])(implicit
        encoder0: ArgEncoder[BulkMarkersInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "markersBulk",
      ListOf(OptionOf(Obj(innerSelection))),
      arguments = List(Argument("form", form, "BulkMarkersInput!")(encoder0))
    )
    def platform[A](id: String)(innerSelection: SelectionBuilder[Platform, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "platform",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def listPlatformById[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[Platform, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listPlatformById",
        ListOf(Obj(innerSelection)),
        arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
      )
    def paginationPlatform[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: PlatformFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[PlatformSorting] = None
    )(innerSelection: SelectionBuilder[PlatformPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[PlatformFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[PlatformSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationPlatform",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("filterSettings", filterSettings, "PlatformFilterSettings!")(
            encoder2
          ),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "PlatformSorting")(encoder4)
        )
      )
    def account[A](id: String)(innerSelection: SelectionBuilder[Account, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "account",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def listAccountById[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[Account, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "listAccountById",
        ListOf(Obj(innerSelection)),
        arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
      )
    def paginationAccount[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: AccountFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[AccountSorting] = None
    )(innerSelection: SelectionBuilder[AccountPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[AccountFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[AccountSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationAccount",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument("filterSettings", filterSettings, "AccountFilterSettings!")(
            encoder2
          ),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "AccountSorting")(encoder4)
        )
      )
    def paginationCountry[A](
        filterSettings: CountryFilterSettings,
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[CountryPagination, A])(implicit
        encoder0: ArgEncoder[CountryFilterSettings],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationCountry",
        Obj(innerSelection),
        arguments = List(
          Argument("filterSettings", filterSettings, "CountryFilterSettings!")(
            encoder0
          ),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2)
        )
      )
    def paginationLanguage[A](
        filterSettings: LanguageFilterSettings,
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[LanguagePagination, A])(implicit
        encoder0: ArgEncoder[LanguageFilterSettings],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationLanguage",
        Obj(innerSelection),
        arguments = List(
          Argument("filterSettings", filterSettings, "LanguageFilterSettings!")(
            encoder0
          ),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2)
        )
      )
    def documentFeed[A](
        id: String
    )(innerSelection: SelectionBuilder[DocumentFeed, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "documentFeed",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def paginationDocumentFeed[A](
        limit: scala.Option[Int] = None,
        offset: scala.Option[Int] = None,
        filterSettings: DocumentFeedFilterSettings,
        direction: scala.Option[SortDirection] = None,
        sortField: scala.Option[DocumentFeedSorting] = None
    )(innerSelection: SelectionBuilder[DocumentFeedPagination, A])(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[DocumentFeedFilterSettings],
        encoder3: ArgEncoder[scala.Option[SortDirection]],
        encoder4: ArgEncoder[scala.Option[DocumentFeedSorting]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "paginationDocumentFeed",
        Obj(innerSelection),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1),
          Argument(
            "filterSettings",
            filterSettings,
            "DocumentFeedFilterSettings!"
          )(encoder2),
          Argument("direction", direction, "SortDirection")(encoder3),
          Argument("sortField", sortField, "DocumentFeedSorting")(encoder4)
        )
      )
    def conceptRegistryView[A](
        innerSelection: SelectionBuilder[ConceptRegistryView, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("conceptRegistryView", Obj(innerSelection))
    def documentRegistryView[A](
        innerSelection: SelectionBuilder[DocumentRegistryView, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("documentRegistryView", Obj(innerSelection))
    def documentCardView[A](
        innerSelection: SelectionBuilder[DocumentCardView, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("documentCardView", Obj(innerSelection))
    def chart[A](id: String)(innerSelection: SelectionBuilder[Chart, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "chart",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def previewChart[A](
        form: ChartDescriptionInput
    )(innerSelection: SelectionBuilder[Chart, A])(implicit
        encoder0: ArgEncoder[ChartDescriptionInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "previewChart",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ChartDescriptionInput!")(encoder0))
      )
  }

  type Mutation = _root_.caliban.client.Operations.RootMutation
  object Mutation {
    def addConcept[A](
        form: ConceptMutationInput,
        performanceControl: scala.Option[PerformSynchronously] = None,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[Concept, A])(implicit
        encoder0: ArgEncoder[ConceptMutationInput],
        encoder1: ArgEncoder[scala.Option[PerformSynchronously]],
        encoder2: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptMutationInput!")(encoder0),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder1),
          Argument("file", file, "Upload")(encoder2)
        )
      )
    def addConceptLink[A](
        form: ConceptLinkCreationMutationInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[ConceptLink, A])(implicit
        encoder0: ArgEncoder[ConceptLinkCreationMutationInput],
        encoder1: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptLink",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptLinkCreationMutationInput!")(encoder0),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder1)
        )
      )
    def updateConceptLink[A](
        form: ConceptLinkUpdateMutationInput
    )(innerSelection: SelectionBuilder[ConceptLink, A])(implicit
        encoder0: ArgEncoder[ConceptLinkUpdateMutationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptLink",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptLinkUpdateMutationInput!")(encoder0)
        )
      )
    def addConceptProperty[A](
        form: ConceptPropertyCreateInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[ConceptProperty, A])(implicit
        encoder0: ArgEncoder[ConceptPropertyCreateInput],
        encoder1: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptProperty",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptPropertyCreateInput!")(encoder0),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder1)
        )
      )
    def addConceptLinkProperty[A](
        form: ConceptLinkPropertyInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[ConceptProperty, A])(implicit
        encoder0: ArgEncoder[ConceptLinkPropertyInput],
        encoder1: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptLinkProperty",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptLinkPropertyInput!")(encoder0),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder1)
        )
      )
    def addConceptFact[A](
        id: String,
        fact: FactInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[FactInput],
        encoder2: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptFact",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("fact", fact, "FactInput!")(encoder1),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder2)
        )
      )
    def deleteConceptFact[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptFact",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addConceptLinkPropertyFact[A](
        id: String,
        fact: FactInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[FactInput],
        encoder2: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptLinkPropertyFact",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("fact", fact, "FactInput!")(encoder1),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder2)
        )
      )
    def deleteConceptLinkPropertyFact[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptLinkPropertyFact",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addConceptPropertyFact[A](
        id: String,
        fact: FactInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[FactInput],
        encoder2: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptPropertyFact",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("fact", fact, "FactInput!")(encoder1),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder2)
        )
      )
    def deleteConceptPropertyFact[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptPropertyFact",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addConceptLinkFact[A](
        id: String,
        fact: FactInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[FactInput],
        encoder2: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptLinkFact",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("fact", fact, "FactInput!")(encoder1),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder2)
        )
      )
    def deleteConceptLinkFact[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptLinkFact",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def updateConcept[A](
        form: ConceptUpdateInput,
        performanceControl: scala.Option[PerformSynchronously] = None
    )(innerSelection: SelectionBuilder[Concept, A])(implicit
        encoder0: ArgEncoder[ConceptUpdateInput],
        encoder1: ArgEncoder[scala.Option[PerformSynchronously]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConcept",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptUpdateInput!")(encoder0),
          Argument(
            "performanceControl",
            performanceControl,
            "PerformSynchronously"
          )(encoder1)
        )
      )
    def updateConceptAvatar[A](id: String, documentId: String)(
        innerSelection: SelectionBuilder[Concept, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptAvatar",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("documentId", documentId, "ID!")(encoder1)
        )
      )
    def updateConceptProperty[A](
        form: ConceptPropertyUpdateInput
    )(innerSelection: SelectionBuilder[ConceptProperty, A])(implicit
        encoder0: ArgEncoder[ConceptPropertyUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptProperty",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ConceptPropertyUpdateInput!")(encoder0))
      )
    def deleteConceptProperty[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptProperty",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptLink[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptLink",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConcept[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConcept",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptLinkProperty[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptLinkProperty",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def mergeConcepts[A](
        form: ConceptMergeInput
    )(innerSelection: SelectionBuilder[Concept, A])(implicit
        encoder0: ArgEncoder[ConceptMergeInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "mergeConcepts",
        Obj(innerSelection),
        arguments = List(Argument("form", form, "ConceptMergeInput!")(encoder0))
      )
    def unmergeConcepts[A](
        form: ConceptUnmergeInput
    )(innerSelection: SelectionBuilder[Concept, A])(implicit
        encoder0: ArgEncoder[ConceptUnmergeInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "unmergeConcepts",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ConceptUnmergeInput!")(encoder0))
      )
    def deleteFact[A](id: String)(innerSelection: SelectionBuilder[State, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteFact",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def normalizeValue[A](input: NormalizationInput)(
        onDateTimeValue: SelectionBuilder[DateTimeValue, A],
        onDoubleValue: SelectionBuilder[DoubleValue, A],
        onGeoPointValue: SelectionBuilder[GeoPointValue, A],
        onIntValue: SelectionBuilder[IntValue, A],
        onLinkValue: SelectionBuilder[LinkValue, A],
        onStringLocaleValue: SelectionBuilder[StringLocaleValue, A],
        onStringValue: SelectionBuilder[StringValue, A]
    )(implicit
        encoder0: ArgEncoder[NormalizationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, List[
      A
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "normalizeValue",
      ListOf(
        ChoiceOf(
          Map(
            "DateTimeValue" -> Obj(onDateTimeValue),
            "DoubleValue" -> Obj(onDoubleValue),
            "GeoPointValue" -> Obj(onGeoPointValue),
            "IntValue" -> Obj(onIntValue),
            "LinkValue" -> Obj(onLinkValue),
            "StringLocaleValue" -> Obj(onStringLocaleValue),
            "StringValue" -> Obj(onStringValue)
          )
        )
      ),
      arguments =
        List(Argument("input", input, "NormalizationInput!")(encoder0))
    )
    def updateConceptSubscriptions[A](
        id: String,
        events: List[ConceptUpdate] = Nil
    )(innerSelection: SelectionBuilder[Concept, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[List[ConceptUpdate]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptSubscriptions",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("events", events, "[ConceptUpdate!]!")(encoder1)
        )
      )
    def addConceptType[A](
        form: ConceptTypeCreationInput,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[ConceptType, A])(implicit
        encoder0: ArgEncoder[ConceptTypeCreationInput],
        encoder1: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptTypeCreationInput!")(encoder0),
          Argument("file", file, "Upload")(encoder1)
        )
      )
    def addCompositeConceptType[A](
        form: CompositeConceptTypeCreationInput
    )(innerSelection: SelectionBuilder[CompositeConceptType, A])(implicit
        encoder0: ArgEncoder[CompositeConceptTypeCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addCompositeConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "CompositeConceptTypeCreationInput!")(encoder0)
        )
      )
    def addCompositeConceptTypeTemplate[A](
        id: String,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addCompositeConceptTypeTemplate",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("file", file, "Upload")(encoder1)
        )
      )
    def addCompositeConceptTypeWidgetType[A](
        form: CompositeConceptTypeWidgetTypeCreationInput
    )(innerSelection: SelectionBuilder[CompositeConceptTypeWidgetType, A])(
        implicit
        encoder0: ArgEncoder[CompositeConceptTypeWidgetTypeCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addCompositeConceptTypeWidgetType",
        Obj(innerSelection),
        arguments = List(
          Argument(
            "form",
            form,
            "CompositeConceptTypeWidgetTypeCreationInput!"
          )(encoder0)
        )
      )
    def setConceptTypeDefaultView[A](
        form: CompositeConceptTypeViewInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[CompositeConceptTypeViewInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "setConceptTypeDefaultView",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "CompositeConceptTypeViewInput!")(encoder0)
        )
      )
    def addConceptPropertyType[A](
        form: ConceptPropertyTypeCreationInput
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[ConceptPropertyTypeCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptPropertyTypeCreationInput!")(encoder0)
        )
      )
    def addConceptLinkPropertyType[A](
        form: ConceptLinkPropertyTypeCreationInput
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[ConceptLinkPropertyTypeCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptLinkPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptLinkPropertyTypeCreationInput!")(
            encoder0
          )
        )
      )
    def addConceptLinkType[A](
        form: ConceptLinkTypeCreationInput
    )(innerSelection: SelectionBuilder[ConceptLinkType, A])(implicit
        encoder0: ArgEncoder[ConceptLinkTypeCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptLinkType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptLinkTypeCreationInput!")(encoder0)
        )
      )
    def addConceptPropertyValueType[A](
        form: ConceptPropertyValueTypeCreationInput
    )(innerSelection: SelectionBuilder[ConceptPropertyValueType, A])(implicit
        encoder0: ArgEncoder[ConceptPropertyValueTypeCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptPropertyValueType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptPropertyValueTypeCreationInput!")(
            encoder0
          )
        )
      )
    def addConceptTypeView[A](
        form: ConceptTypeViewCreationInput
    )(innerSelection: SelectionBuilder[ConceptTypeView, A])(implicit
        encoder0: ArgEncoder[ConceptTypeViewCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptTypeView",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptTypeViewCreationInput!")(encoder0)
        )
      )
    def updateConceptType[A](
        form: ConceptTypeUpdateInput,
        file: scala.Option[Upload] = None,
        deleteImage: scala.Option[Boolean] = None
    )(innerSelection: SelectionBuilder[ConceptType, A])(implicit
        encoder0: ArgEncoder[ConceptTypeUpdateInput],
        encoder1: ArgEncoder[scala.Option[Upload]],
        encoder2: ArgEncoder[scala.Option[Boolean]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptTypeUpdateInput!")(encoder0),
          Argument("file", file, "Upload")(encoder1),
          Argument("deleteImage", deleteImage, "Boolean")(encoder2)
        )
      )
    def updateCompositeConceptType[A](
        form: CompositeConceptTypeUpdateInput
    )(innerSelection: SelectionBuilder[CompositeConceptType, A])(implicit
        encoder0: ArgEncoder[CompositeConceptTypeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateCompositeConceptType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "CompositeConceptTypeUpdateInput!")(encoder0)
        )
      )
    def updateCompositeConceptTypeWidgetType[A](
        form: CompositeConceptTypeWidgetTypeUpdateInput
    )(innerSelection: SelectionBuilder[CompositeConceptTypeWidgetType, A])(
        implicit encoder0: ArgEncoder[CompositeConceptTypeWidgetTypeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateCompositeConceptTypeWidgetType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "CompositeConceptTypeWidgetTypeUpdateInput!")(
            encoder0
          )
        )
      )
    def updateCompositeConceptTypeWidgetTypesOrder[A](
        form: CompositeConceptTypeWidgetTypeUpdateOrderInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[CompositeConceptTypeWidgetTypeUpdateOrderInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateCompositeConceptTypeWidgetTypesOrder",
        Obj(innerSelection),
        arguments = List(
          Argument(
            "form",
            form,
            "CompositeConceptTypeWidgetTypeUpdateOrderInput!"
          )(encoder0)
        )
      )
    def updateConceptPropertyType[A](
        form: ConceptPropertyTypeUpdateInput
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[ConceptPropertyTypeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptPropertyTypeUpdateInput!")(encoder0)
        )
      )
    def updateConceptMainPropertyTypeOrder[A](
        form: InterestObjectMainPropertiesOrderUpdateInput
    )(innerSelection: SelectionBuilder[ConceptType, A])(implicit
        encoder0: ArgEncoder[InterestObjectMainPropertiesOrderUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptMainPropertyTypeOrder",
        Obj(innerSelection),
        arguments = List(
          Argument(
            "form",
            form,
            "InterestObjectMainPropertiesOrderUpdateInput!"
          )(encoder0)
        )
      )
    def updateConceptLinkPropertyType[A](
        form: ConceptLinkPropertyTypeUpdateInput
    )(innerSelection: SelectionBuilder[ConceptPropertyType, A])(implicit
        encoder0: ArgEncoder[ConceptLinkPropertyTypeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptLinkPropertyType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptLinkPropertyTypeUpdateInput!")(
            encoder0
          )
        )
      )
    def updateConceptLinkType[A](
        form: ConceptLinkTypeUpdateInput
    )(innerSelection: SelectionBuilder[ConceptLinkType, A])(implicit
        encoder0: ArgEncoder[ConceptLinkTypeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptLinkType",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ConceptLinkTypeUpdateInput!")(encoder0))
      )
    def updateConceptPropertyValueType[A](
        form: ConceptPropertyValueTypeUpdateInput
    )(innerSelection: SelectionBuilder[ConceptPropertyValueType, A])(implicit
        encoder0: ArgEncoder[ConceptPropertyValueTypeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptPropertyValueType",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "ConceptPropertyValueTypeUpdateInput!")(
            encoder0
          )
        )
      )
    def updateConceptTypeView[A](
        form: ConceptTypeViewUpdateInput
    )(innerSelection: SelectionBuilder[ConceptTypeView, A])(implicit
        encoder0: ArgEncoder[ConceptTypeViewUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptTypeView",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ConceptTypeViewUpdateInput!")(encoder0))
      )
    def deleteConceptTypeAvatar[A](
        id: String
    )(innerSelection: SelectionBuilder[ConceptType, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptTypeAvatar",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteCompositeConceptType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteCompositeConceptType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteCompositeConceptTypeWidgetType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteCompositeConceptTypeWidgetType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptPropertyType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptPropertyType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptLinkPropertyType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptLinkPropertyType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptLinkType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptLinkType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptPropertyValueType[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptPropertyValueType",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteConceptTypeView[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptTypeView",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteBulk[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, List[
      scala.Option[A]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "deleteBulk",
      ListOf(OptionOf(Obj(innerSelection))),
      arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
    )
    def moveBulk[A](ids: List[String] = Nil, form: List[Coordinate] = Nil)(
        innerSelection: SelectionBuilder[ConceptType, A]
    )(implicit
        encoder0: ArgEncoder[List[String]],
        encoder1: ArgEncoder[List[Coordinate]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, List[
      A
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "moveBulk",
      ListOf(Obj(innerSelection)),
      arguments = List(
        Argument("ids", ids, "[ID!]!")(encoder0),
        Argument("form", form, "[Coordinate!]!")(encoder1)
      )
    )
    def updateTypeSearchElement[A](
        form: TypeSearchElementUpdateInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[TypeSearchElementUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateTypeSearchElement",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "TypeSearchElementUpdateInput!")(encoder0)
        )
      )
    def addCompositePropertyValueTemplate[A](
        form: CompositePropertyValueTemplateCreateInput
    )(innerSelection: SelectionBuilder[CompositePropertyValueTemplate, A])(
        implicit encoder0: ArgEncoder[CompositePropertyValueTemplateCreateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addCompositePropertyValueTemplate",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "CompositePropertyValueTemplateCreateInput!")(
            encoder0
          )
        )
      )
    def updateCompositePropertyValueTemplate[A](
        form: CompositePropertyValueTemplateCreateInput
    )(innerSelection: SelectionBuilder[CompositePropertyValueTemplate, A])(
        implicit encoder0: ArgEncoder[CompositePropertyValueTemplateCreateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateCompositePropertyValueTemplate",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "CompositePropertyValueTemplateCreateInput!")(
            encoder0
          )
        )
      )
    def deleteCompositePropertyValueTemplate[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteCompositePropertyValueTemplate",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addIssue[A](
        form: IssueCreationInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[IssueCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "IssueCreationInput!")(encoder0))
      )
    def deleteIssue[A](id: String)(innerSelection: SelectionBuilder[State, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteIssue",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addConceptToIssue[A](
        form: Concept2IssueInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[Concept2IssueInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptToIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "Concept2IssueInput!")(encoder0))
      )
    def addDocumentToIssue[A](
        form: Document2IssueInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[Document2IssueInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addDocumentToIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "Document2IssueInput!")(encoder0))
      )
    def addIssueToIssue[A](
        form: Issue2TaskInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[Issue2TaskInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addIssueToIssue",
        Obj(innerSelection),
        arguments = List(Argument("form", form, "Issue2TaskInput!")(encoder0))
      )
    def deleteDocumentFromIssue[A](
        form: Document2IssueInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[Document2IssueInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteDocumentFromIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "Document2IssueInput!")(encoder0))
      )
    def deleteConceptFromIssue[A](
        form: Concept2IssueInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[Concept2IssueInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteConceptFromIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "Concept2IssueInput!")(encoder0))
      )
    def deleteIssueFromIssue[A](
        form: Issue2TaskInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[Issue2TaskInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteIssueFromIssue",
        Obj(innerSelection),
        arguments = List(Argument("form", form, "Issue2TaskInput!")(encoder0))
      )
    def updateIssue[A](
        form: IssueEditFieldsInput
    )(innerSelection: SelectionBuilder[Issue, A])(implicit
        encoder0: ArgEncoder[IssueEditFieldsInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "IssueEditFieldsInput!")(encoder0))
      )
    def updateIssueMassive[A](
        form: MassUpdateIssueInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[MassUpdateIssueInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateIssueMassive",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "MassUpdateIssueInput!")(encoder0))
      )
    def addCommentToIssue[A](
        form: Comment2IssueInput
    )(innerSelection: SelectionBuilder[IssueChange, A])(implicit
        encoder0: ArgEncoder[Comment2IssueInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addCommentToIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "Comment2IssueInput!")(encoder0))
      )
    def updateIssueComment[A](
        form: UpdateCommentInput
    )(innerSelection: SelectionBuilder[IssueChange, A])(implicit
        encoder0: ArgEncoder[UpdateCommentInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateIssueComment",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "UpdateCommentInput!")(encoder0))
      )
    def deleteIssueComment[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteIssueComment",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def updateDocument[A](
        form: DocumentUpdateInput
    )(innerSelection: SelectionBuilder[Document, A])(implicit
        encoder0: ArgEncoder[DocumentUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocument",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentUpdateInput!")(encoder0))
      )
    def updateDocumentAvatar[A](
        form: DocumentAvatarUpdateInput
    )(innerSelection: SelectionBuilder[Document, A])(implicit
        encoder0: ArgEncoder[DocumentAvatarUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocumentAvatar",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentAvatarUpdateInput!")(encoder0))
      )
    def removeCandidateFactFromDocument[A](
        form: DocumentDeleteCandidateFactInput
    )(innerSelection: SelectionBuilder[Document, A])(implicit
        encoder0: ArgEncoder[DocumentDeleteCandidateFactInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "removeCandidateFactFromDocument",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "DocumentDeleteCandidateFactInput!")(encoder0)
        )
      )
    def removeAllKBFactsFromDocument[A](
        form: DocumentAllKBFactsRemoveInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[DocumentAllKBFactsRemoveInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "removeAllKBFactsFromDocument",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "DocumentAllKBFactsRemoveInput!")(encoder0)
        )
      )
    def deleteDocuments[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteDocuments",
        Obj(innerSelection),
        arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
      )
    def addDocumentDouble[A](
        form: DocumentDoubleCreationInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[DocumentDoubleCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addDocumentDouble",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentDoubleCreationInput!")(encoder0))
      )
    def updateDocumentNode[A](
        form: DocumentNodeUpdateInput
    )(innerSelection: SelectionBuilder[Document, A])(implicit
        encoder0: ArgEncoder[DocumentNodeUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocumentNode",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentNodeUpdateInput!")(encoder0))
      )
    def updateDocumentSubscriptions[A](
        id: String,
        events: List[DocumentUpdate] = Nil
    )(innerSelection: SelectionBuilder[Document, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[List[DocumentUpdate]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocumentSubscriptions",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("events", events, "[DocumentUpdate!]!")(encoder1)
        )
      )
    def markDocumentAsRead[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "markDocumentAsRead",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def markDocumentAsUnread[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "markDocumentAsUnread",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def deleteResearchMap[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteResearchMap",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def bulkDeleteResearchMap[A](
        ids: List[String] = Nil
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[List[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "bulkDeleteResearchMap",
        Obj(innerSelection),
        arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
      )
    def addResearchMap[A](
        form: ResearchMapCreationInput
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[ResearchMapCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addResearchMap",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ResearchMapCreationInput!")(encoder0))
      )
    def addResearchMapFromFiles[A](
        files: List[scala.Option[Upload]] = Nil
    )(innerSelection: SelectionBuilder[ResearchMapFromFilesType, A])(implicit
        encoder0: ArgEncoder[List[scala.Option[Upload]]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addResearchMapFromFiles",
        Obj(innerSelection),
        arguments = List(Argument("files", files, "[Upload]!")(encoder0))
      )
    def updateResearchMap[A](id: String, form: ResearchMapUpdateInput)(
        innerSelection: SelectionBuilder[ResearchMap, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ResearchMapUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateResearchMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ResearchMapUpdateInput!")(encoder1)
        )
      )
    def addContentOnResearchMap[A](
        id: String,
        form: ResearchMapContentAddInput
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ResearchMapContentAddInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addContentOnResearchMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ResearchMapContentAddInput!")(encoder1)
        )
      )
    def deleteContentFromResearchMap[A](
        id: String,
        form: ResearchMapContentUpdateInput
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ResearchMapContentUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteContentFromResearchMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ResearchMapContentUpdateInput!")(encoder1)
        )
      )
    def batchMoveNodesOnMap[A](id: String, form: ResearchMapBatchMoveInput)(
        innerSelection: SelectionBuilder[ResearchMap, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ResearchMapBatchMoveInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "batchMoveNodesOnMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ResearchMapBatchMoveInput!")(encoder1)
        )
      )
    def batchUpdateGroupOnMap[A](
        id: String,
        form: ResearchMapBatchUpdateGroupInput
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ResearchMapBatchUpdateGroupInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "batchUpdateGroupOnMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ResearchMapBatchUpdateGroupInput!")(encoder1)
        )
      )
    def addTopNeighborsOnMap[A](
        id: String,
        quantity: scala.Option[Int] = None,
        form: ResearchMapContentSelectInput
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[scala.Option[Int]],
        encoder2: ArgEncoder[ResearchMapContentSelectInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addTopNeighborsOnMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("quantity", quantity, "Int")(encoder1),
          Argument("form", form, "ResearchMapContentSelectInput!")(encoder2)
        )
      )
    def addConceptFactNeighborsOnMap[A](id: String, conceptId: String)(
        innerSelection: SelectionBuilder[ResearchMap, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addConceptFactNeighborsOnMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("conceptId", conceptId, "ID!")(encoder1)
        )
      )
    def setResearchMapActive[A](
        id: String
    )(innerSelection: SelectionBuilder[ResearchMap, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "setResearchMapActive",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def findShortestPathOnMap[A](
        id: String,
        conceptNodeIds: ConceptAddImplicitLinkInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ConceptAddImplicitLinkInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "findShortestPathOnMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument(
            "conceptNodeIds",
            conceptNodeIds,
            "ConceptAddImplicitLinkInput!"
          )(encoder1)
        )
      )
    def findShortestImplicitPathOnMap[A](
        id: String,
        conceptNodeIds: ConceptAddImplicitLinkInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ConceptAddImplicitLinkInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "findShortestImplicitPathOnMap",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument(
            "conceptNodeIds",
            conceptNodeIds,
            "ConceptAddImplicitLinkInput!"
          )(encoder1)
        )
      )
    def addGroup[A](
        form: GroupCreationInput
    )(innerSelection: SelectionBuilder[Group, A])(implicit
        encoder0: ArgEncoder[GroupCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addGroup",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "GroupCreationInput!")(encoder0))
      )
    def updateGroup[A](id: String, form: GroupUpdateInput)(
        innerSelection: SelectionBuilder[Group, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[GroupUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateGroup",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "GroupUpdateInput!")(encoder1)
        )
      )
    def deleteGroup[A](id: String)(innerSelection: SelectionBuilder[State, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteGroup",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def createRedmineIssue[A](
        form: RedmineIssueCreationInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[RedmineIssueCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createRedmineIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "RedmineIssueCreationInput!")(encoder0))
      )
    def updateRedmineIssue[A](
        form: RedmineIssueUpdateInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[RedmineIssueUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateRedmineIssue",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "RedmineIssueUpdateInput!")(encoder0))
      )
    def unlinkIssues[A](
        form: RedmineIssueUnlinkInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[RedmineIssueUnlinkInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "unlinkIssues",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "RedmineIssueUnlinkInput!")(encoder0))
      )
    def addAccessLevel[A](
        form: AccessLevelCreationInput
    )(innerSelection: SelectionBuilder[AccessLevel, A])(implicit
        encoder0: ArgEncoder[AccessLevelCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addAccessLevel",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "AccessLevelCreationInput!")(encoder0))
      )
    def updateAccessLevel[A](id: String, form: AccessLevelUpdateInput)(
        innerSelection: SelectionBuilder[AccessLevel, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[AccessLevelUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateAccessLevel",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "AccessLevelUpdateInput!")(encoder1)
        )
      )
    def deleteAccessLevel[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteAccessLevel",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addTemplateDocx[A](
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addTemplateDocx",
        Obj(innerSelection),
        arguments = List(Argument("file", file, "Upload")(encoder0))
      )
    def updateMarkersBulk[A](
        form: BulkMarkersUpdateInput
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[BulkMarkersUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateMarkersBulk",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "BulkMarkersUpdateInput!")(encoder0))
      )
    def addPlatform[A](
        form: PlatformCreationInput,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[Platform, A])(implicit
        encoder0: ArgEncoder[PlatformCreationInput],
        encoder1: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addPlatform",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "PlatformCreationInput!")(encoder0),
          Argument("file", file, "Upload")(encoder1)
        )
      )
    def updatePlatform[A](
        form: PlatformUpdateInput,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[Platform, A])(implicit
        encoder0: ArgEncoder[PlatformUpdateInput],
        encoder1: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updatePlatform",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "PlatformUpdateInput!")(encoder0),
          Argument("file", file, "Upload")(encoder1)
        )
      )
    def deletePlatform[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deletePlatform",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addAccount[A](
        form: AccountCreationInput,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[Account, A])(implicit
        encoder0: ArgEncoder[AccountCreationInput],
        encoder1: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addAccount",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "AccountCreationInput!")(encoder0),
          Argument("file", file, "Upload")(encoder1)
        )
      )
    def updateAccount[A](
        form: AccountUpdateInput,
        file: scala.Option[Upload] = None
    )(innerSelection: SelectionBuilder[Account, A])(implicit
        encoder0: ArgEncoder[AccountUpdateInput],
        encoder1: ArgEncoder[scala.Option[Upload]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateAccount",
        Obj(innerSelection),
        arguments = List(
          Argument("form", form, "AccountUpdateInput!")(encoder0),
          Argument("file", file, "Upload")(encoder1)
        )
      )
    def deleteAccount[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteAccount",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def addDocumentFeed[A](
        form: DocumentFeedCreationInput
    )(innerSelection: SelectionBuilder[DocumentFeed, A])(implicit
        encoder0: ArgEncoder[DocumentFeedCreationInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addDocumentFeed",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentFeedCreationInput!")(encoder0))
      )
    def updateDocumentFeed[A](id: String, form: DocumentFeedUpdateInput)(
        innerSelection: SelectionBuilder[DocumentFeed, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[DocumentFeedUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocumentFeed",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "DocumentFeedUpdateInput!")(encoder1)
        )
      )
    def addDocumentToDocumentFeedFavorites[A](
        documentFeedId: String,
        form: DocumentFeedUpdateDocumentsInput
    )(innerSelection: SelectionBuilder[DocumentFeed, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[DocumentFeedUpdateDocumentsInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addDocumentToDocumentFeedFavorites",
        Obj(innerSelection),
        arguments = List(
          Argument("documentFeedId", documentFeedId, "ID!")(encoder0),
          Argument("form", form, "DocumentFeedUpdateDocumentsInput!")(encoder1)
        )
      )
    def deleteDocumentFromDocumentFeedFavorites[A](
        documentFeedId: String,
        form: DocumentFeedUpdateDocumentsInput
    )(innerSelection: SelectionBuilder[DocumentFeed, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[DocumentFeedUpdateDocumentsInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteDocumentFromDocumentFeedFavorites",
        Obj(innerSelection),
        arguments = List(
          Argument("documentFeedId", documentFeedId, "ID!")(encoder0),
          Argument("form", form, "DocumentFeedUpdateDocumentsInput!")(encoder1)
        )
      )
    def deleteDocumentFromDocumentFeed[A](
        documentFeedId: String,
        form: DocumentFeedUpdateDocumentsInput
    )(innerSelection: SelectionBuilder[DocumentFeed, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[DocumentFeedUpdateDocumentsInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteDocumentFromDocumentFeed",
        Obj(innerSelection),
        arguments = List(
          Argument("documentFeedId", documentFeedId, "ID!")(encoder0),
          Argument("form", form, "DocumentFeedUpdateDocumentsInput!")(encoder1)
        )
      )
    def restoreDocumentToDocumentFeed[A](
        documentFeedId: String,
        form: DocumentFeedUpdateDocumentsInput
    )(innerSelection: SelectionBuilder[DocumentFeed, A])(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[DocumentFeedUpdateDocumentsInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "restoreDocumentToDocumentFeed",
        Obj(innerSelection),
        arguments = List(
          Argument("documentFeedId", documentFeedId, "ID!")(encoder0),
          Argument("form", form, "DocumentFeedUpdateDocumentsInput!")(encoder1)
        )
      )
    def deleteDocumentFeed[A](
        id: String
    )(innerSelection: SelectionBuilder[State, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteDocumentFeed",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def updateConceptRegistryView[A](
        form: ConceptRegistryViewInput
    )(innerSelection: SelectionBuilder[ConceptRegistryView, A])(implicit
        encoder0: ArgEncoder[ConceptRegistryViewInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateConceptRegistryView",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ConceptRegistryViewInput!")(encoder0))
      )
    def updateDocumentRegistryView[A](
        form: DocumentRegistryViewInput
    )(innerSelection: SelectionBuilder[DocumentRegistryView, A])(implicit
        encoder0: ArgEncoder[DocumentRegistryViewInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocumentRegistryView",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentRegistryViewInput!")(encoder0))
      )
    def updateDocumentCardView[A](
        form: DocumentCardViewInput
    )(innerSelection: SelectionBuilder[DocumentCardView, A])(implicit
        encoder0: ArgEncoder[DocumentCardViewInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateDocumentCardView",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "DocumentCardViewInput!")(encoder0))
      )
    def addChart[A](
        form: ChartDescriptionInput
    )(innerSelection: SelectionBuilder[Chart, A])(implicit
        encoder0: ArgEncoder[ChartDescriptionInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "addChart",
        Obj(innerSelection),
        arguments =
          List(Argument("form", form, "ChartDescriptionInput!")(encoder0))
      )
    def updateChart[A](id: String, form: ChartDescriptionInput)(
        innerSelection: SelectionBuilder[Chart, A]
    )(implicit
        encoder0: ArgEncoder[String],
        encoder1: ArgEncoder[ChartDescriptionInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "updateChart",
        Obj(innerSelection),
        arguments = List(
          Argument("id", id, "ID!")(encoder0),
          Argument("form", form, "ChartDescriptionInput!")(encoder1)
        )
      )
    def deleteChart[A](id: String)(innerSelection: SelectionBuilder[State, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "deleteChart",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
  }

  type Subscription = _root_.caliban.client.Operations.RootSubscription
  object Subscription {
    def researchMapChanged[A](
        id: String
    )(innerSelection: SelectionBuilder[ResearchMapChangedEvent, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootSubscription, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "researchMapChanged",
        Obj(innerSelection),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
  }

}

