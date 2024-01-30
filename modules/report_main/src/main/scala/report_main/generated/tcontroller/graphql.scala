package report_main.generated.tcontroller

import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client._
import caliban.client.__Value._

object graphql {

    type JSON = String

    type UnixTime = String

    type Upload = String

    sealed trait ConceptTransformConfigSort
        extends scala.Product
            with scala.Serializable {
        def value: String
    }
    object ConceptTransformConfigSort {
        case object systemUpdateDate extends ConceptTransformConfigSort {
            val value: String = "systemUpdateDate"
        }
        case object systemRegistrationDate extends ConceptTransformConfigSort {
            val value: String = "systemRegistrationDate"
        }
        case object description extends ConceptTransformConfigSort {
            val value: String = "description"
        }
        case object id extends ConceptTransformConfigSort {
            val value: String = "id"
        }

        implicit val decoder: ScalarDecoder[ConceptTransformConfigSort] = {
            case __StringValue("systemUpdateDate") =>
                Right(ConceptTransformConfigSort.systemUpdateDate)
            case __StringValue("systemRegistrationDate") =>
                Right(ConceptTransformConfigSort.systemRegistrationDate)
            case __StringValue("description") =>
                Right(ConceptTransformConfigSort.description)
            case __StringValue("id") => Right(ConceptTransformConfigSort.id)
            case other =>
                Left(
                    DecodingError(
                        s"Can't build ConceptTransformConfigSort from input $other"
                    )
                )
        }
        implicit val encoder: ArgEncoder[ConceptTransformConfigSort] = {
            case ConceptTransformConfigSort.systemUpdateDate =>
                __EnumValue("systemUpdateDate")
            case ConceptTransformConfigSort.systemRegistrationDate =>
                __EnumValue("systemRegistrationDate")
            case ConceptTransformConfigSort.description => __EnumValue("description")
            case ConceptTransformConfigSort.id          => __EnumValue("id")
        }

        val values: scala.collection.immutable.Vector[ConceptTransformConfigSort] =
            scala.collection.immutable.Vector(
                systemUpdateDate,
                systemRegistrationDate,
                description,
                id
            )
    }

    sealed trait ConceptTransformTaskSort
        extends scala.Product
            with scala.Serializable {
        def value: String
    }
    object ConceptTransformTaskSort {
        case object state extends ConceptTransformTaskSort {
            val value: String = "state"
        }
        case object config extends ConceptTransformTaskSort {
            val value: String = "config"
        }
        case object createTime extends ConceptTransformTaskSort {
            val value: String = "createTime"
        }

        implicit val decoder: ScalarDecoder[ConceptTransformTaskSort] = {
            case __StringValue("state")  => Right(ConceptTransformTaskSort.state)
            case __StringValue("config") => Right(ConceptTransformTaskSort.config)
            case __StringValue("createTime") =>
                Right(ConceptTransformTaskSort.createTime)
            case other =>
                Left(
                    DecodingError(
                        s"Can't build ConceptTransformTaskSort from input $other"
                    )
                )
        }
        implicit val encoder: ArgEncoder[ConceptTransformTaskSort] = {
            case ConceptTransformTaskSort.state      => __EnumValue("state")
            case ConceptTransformTaskSort.config     => __EnumValue("config")
            case ConceptTransformTaskSort.createTime => __EnumValue("createTime")
        }

        val values: scala.collection.immutable.Vector[ConceptTransformTaskSort] =
            scala.collection.immutable.Vector(state, config, createTime)
    }

    sealed trait ConceptTransformTaskState
        extends scala.Product
            with scala.Serializable {
        def value: String
    }
    object ConceptTransformTaskState {
        case object failed extends ConceptTransformTaskState {
            val value: String = "failed"
        }
        case object ok extends ConceptTransformTaskState {
            val value: String = "ok"
        }
        case object pending extends ConceptTransformTaskState {
            val value: String = "pending"
        }

        implicit val decoder: ScalarDecoder[ConceptTransformTaskState] = {
            case __StringValue("failed")  => Right(ConceptTransformTaskState.failed)
            case __StringValue("ok")      => Right(ConceptTransformTaskState.ok)
            case __StringValue("pending") => Right(ConceptTransformTaskState.pending)
            case other =>
                Left(
                    DecodingError(
                        s"Can't build ConceptTransformTaskState from input $other"
                    )
                )
        }
        implicit val encoder: ArgEncoder[ConceptTransformTaskState] = {
            case ConceptTransformTaskState.failed  => __EnumValue("failed")
            case ConceptTransformTaskState.ok      => __EnumValue("ok")
            case ConceptTransformTaskState.pending => __EnumValue("pending")
        }

        val values: scala.collection.immutable.Vector[ConceptTransformTaskState] =
            scala.collection.immutable.Vector(failed, ok, pending)
    }

    sealed trait ExportEntityType extends scala.Product with scala.Serializable {
        def value: String
    }
    object ExportEntityType {
        case object document extends ExportEntityType {
            val value: String = "document"
        }
        case object concept extends ExportEntityType {
            val value: String = "concept"
        }

        implicit val decoder: ScalarDecoder[ExportEntityType] = {
            case __StringValue("document") => Right(ExportEntityType.document)
            case __StringValue("concept")  => Right(ExportEntityType.concept)
            case other =>
                Left(DecodingError(s"Can't build ExportEntityType from input $other"))
        }
        implicit val encoder: ArgEncoder[ExportEntityType] = {
            case ExportEntityType.document => __EnumValue("document")
            case ExportEntityType.concept  => __EnumValue("concept")
        }

        val values: scala.collection.immutable.Vector[ExportEntityType] =
            scala.collection.immutable.Vector(document, concept)
    }

    sealed trait ExporterSort extends scala.Product with scala.Serializable {
        def value: String
    }
    object ExporterSort {
        case object id extends ExporterSort { val value: String = "id" }

        implicit val decoder: ScalarDecoder[ExporterSort] = {
            case __StringValue("id") => Right(ExporterSort.id)
            case other =>
                Left(DecodingError(s"Can't build ExporterSort from input $other"))
        }
        implicit val encoder: ArgEncoder[ExporterSort] = { case ExporterSort.id =>
            __EnumValue("id")
        }

        val values: scala.collection.immutable.Vector[ExporterSort] =
            scala.collection.immutable.Vector(id)
    }

    sealed trait ExportTaskSort extends scala.Product with scala.Serializable {
        def value: String
    }
    object ExportTaskSort {
        case object state extends ExportTaskSort { val value: String = "state" }
        case object exporter extends ExportTaskSort {
            val value: String = "exporter"
        }
        case object createTime extends ExportTaskSort {
            val value: String = "createTime"
        }

        implicit val decoder: ScalarDecoder[ExportTaskSort] = {
            case __StringValue("state")      => Right(ExportTaskSort.state)
            case __StringValue("exporter")   => Right(ExportTaskSort.exporter)
            case __StringValue("createTime") => Right(ExportTaskSort.createTime)
            case other =>
                Left(DecodingError(s"Can't build ExportTaskSort from input $other"))
        }
        implicit val encoder: ArgEncoder[ExportTaskSort] = {
            case ExportTaskSort.state      => __EnumValue("state")
            case ExportTaskSort.exporter   => __EnumValue("exporter")
            case ExportTaskSort.createTime => __EnumValue("createTime")
        }

        val values: scala.collection.immutable.Vector[ExportTaskSort] =
            scala.collection.immutable.Vector(state, exporter, createTime)
    }

    sealed trait ExportTaskState extends scala.Product with scala.Serializable {
        def value: String
    }
    object ExportTaskState {
        case object failed extends ExportTaskState { val value: String = "failed" }
        case object ok extends ExportTaskState { val value: String = "ok" }
        case object pending extends ExportTaskState {
            val value: String = "pending"
        }

        implicit val decoder: ScalarDecoder[ExportTaskState] = {
            case __StringValue("failed")  => Right(ExportTaskState.failed)
            case __StringValue("ok")      => Right(ExportTaskState.ok)
            case __StringValue("pending") => Right(ExportTaskState.pending)
            case other =>
                Left(DecodingError(s"Can't build ExportTaskState from input $other"))
        }
        implicit val encoder: ArgEncoder[ExportTaskState] = {
            case ExportTaskState.failed  => __EnumValue("failed")
            case ExportTaskState.ok      => __EnumValue("ok")
            case ExportTaskState.pending => __EnumValue("pending")
        }

        val values: scala.collection.immutable.Vector[ExportTaskState] =
            scala.collection.immutable.Vector(failed, ok, pending)
    }

    sealed trait ItemsSort extends scala.Product with scala.Serializable {
        def value: String
    }
    object ItemsSort {
        case object topic extends ItemsSort { val value: String = "topic" }
        case object timestamp extends ItemsSort { val value: String = "timestamp" }

        implicit val decoder: ScalarDecoder[ItemsSort] = {
            case __StringValue("topic")     => Right(ItemsSort.topic)
            case __StringValue("timestamp") => Right(ItemsSort.timestamp)
            case other =>
                Left(DecodingError(s"Can't build ItemsSort from input $other"))
        }
        implicit val encoder: ArgEncoder[ItemsSort] = {
            case ItemsSort.topic     => __EnumValue("topic")
            case ItemsSort.timestamp => __EnumValue("timestamp")
        }

        val values: scala.collection.immutable.Vector[ItemsSort] =
            scala.collection.immutable.Vector(topic, timestamp)
    }

    sealed trait KafkaTopicSort extends scala.Product with scala.Serializable {
        def value: String
    }
    object KafkaTopicSort {
        case object systemUpdateDate extends KafkaTopicSort {
            val value: String = "systemUpdateDate"
        }
        case object systemRegistrationDate extends KafkaTopicSort {
            val value: String = "systemRegistrationDate"
        }
        case object duplicateMessages extends KafkaTopicSort {
            val value: String = "duplicateMessages"
        }
        case object failedMessages extends KafkaTopicSort {
            val value: String = "failedMessages"
        }
        case object okMessages extends KafkaTopicSort {
            val value: String = "okMessages"
        }
        case object activeMessages extends KafkaTopicSort {
            val value: String = "activeMessages"
        }
        case object pendingMessages extends KafkaTopicSort {
            val value: String = "pendingMessages"
        }
        case object priority extends KafkaTopicSort {
            val value: String = "priority"
        }
        case object configDescription extends KafkaTopicSort {
            val value: String = "configDescription"
        }
        case object configId extends KafkaTopicSort {
            val value: String = "configId"
        }
        case object description extends KafkaTopicSort {
            val value: String = "description"
        }
        case object topic extends KafkaTopicSort { val value: String = "topic" }

        implicit val decoder: ScalarDecoder[KafkaTopicSort] = {
            case __StringValue("systemUpdateDate") =>
                Right(KafkaTopicSort.systemUpdateDate)
            case __StringValue("systemRegistrationDate") =>
                Right(KafkaTopicSort.systemRegistrationDate)
            case __StringValue("duplicateMessages") =>
                Right(KafkaTopicSort.duplicateMessages)
            case __StringValue("failedMessages") =>
                Right(KafkaTopicSort.failedMessages)
            case __StringValue("okMessages") => Right(KafkaTopicSort.okMessages)
            case __StringValue("activeMessages") =>
                Right(KafkaTopicSort.activeMessages)
            case __StringValue("pendingMessages") =>
                Right(KafkaTopicSort.pendingMessages)
            case __StringValue("priority") => Right(KafkaTopicSort.priority)
            case __StringValue("configDescription") =>
                Right(KafkaTopicSort.configDescription)
            case __StringValue("configId")    => Right(KafkaTopicSort.configId)
            case __StringValue("description") => Right(KafkaTopicSort.description)
            case __StringValue("topic")       => Right(KafkaTopicSort.topic)
            case other =>
                Left(DecodingError(s"Can't build KafkaTopicSort from input $other"))
        }
        implicit val encoder: ArgEncoder[KafkaTopicSort] = {
            case KafkaTopicSort.systemUpdateDate => __EnumValue("systemUpdateDate")
            case KafkaTopicSort.systemRegistrationDate =>
                __EnumValue("systemRegistrationDate")
            case KafkaTopicSort.duplicateMessages => __EnumValue("duplicateMessages")
            case KafkaTopicSort.failedMessages    => __EnumValue("failedMessages")
            case KafkaTopicSort.okMessages        => __EnumValue("okMessages")
            case KafkaTopicSort.activeMessages    => __EnumValue("activeMessages")
            case KafkaTopicSort.pendingMessages   => __EnumValue("pendingMessages")
            case KafkaTopicSort.priority          => __EnumValue("priority")
            case KafkaTopicSort.configDescription => __EnumValue("configDescription")
            case KafkaTopicSort.configId          => __EnumValue("configId")
            case KafkaTopicSort.description       => __EnumValue("description")
            case KafkaTopicSort.topic             => __EnumValue("topic")
        }

        val values: scala.collection.immutable.Vector[KafkaTopicSort] =
            scala.collection.immutable.Vector(
                systemUpdateDate,
                systemRegistrationDate,
                duplicateMessages,
                failedMessages,
                okMessages,
                activeMessages,
                pendingMessages,
                priority,
                configDescription,
                configId,
                description,
                topic
            )
    }

    sealed trait MessageSort extends scala.Product with scala.Serializable {
        def value: String
    }
    object MessageSort {
        case object timestamp extends MessageSort {
            val value: String = "timestamp"
        }

        implicit val decoder: ScalarDecoder[MessageSort] = {
            case __StringValue("timestamp") => Right(MessageSort.timestamp)
            case other =>
                Left(DecodingError(s"Can't build MessageSort from input $other"))
        }
        implicit val encoder: ArgEncoder[MessageSort] = {
            case MessageSort.timestamp => __EnumValue("timestamp")
        }

        val values: scala.collection.immutable.Vector[MessageSort] =
            scala.collection.immutable.Vector(timestamp)
    }

    sealed trait PipelineConfigSort
        extends scala.Product
            with scala.Serializable {
        def value: String
    }
    object PipelineConfigSort {
        case object systemUpdateDate extends PipelineConfigSort {
            val value: String = "systemUpdateDate"
        }
        case object systemRegistrationDate extends PipelineConfigSort {
            val value: String = "systemRegistrationDate"
        }
        case object description extends PipelineConfigSort {
            val value: String = "description"
        }
        case object id extends PipelineConfigSort { val value: String = "id" }

        implicit val decoder: ScalarDecoder[PipelineConfigSort] = {
            case __StringValue("systemUpdateDate") =>
                Right(PipelineConfigSort.systemUpdateDate)
            case __StringValue("systemRegistrationDate") =>
                Right(PipelineConfigSort.systemRegistrationDate)
            case __StringValue("description") => Right(PipelineConfigSort.description)
            case __StringValue("id")          => Right(PipelineConfigSort.id)
            case other =>
                Left(DecodingError(s"Can't build PipelineConfigSort from input $other"))
        }
        implicit val encoder: ArgEncoder[PipelineConfigSort] = {
            case PipelineConfigSort.systemUpdateDate =>
                __EnumValue("systemUpdateDate")
            case PipelineConfigSort.systemRegistrationDate =>
                __EnumValue("systemRegistrationDate")
            case PipelineConfigSort.description => __EnumValue("description")
            case PipelineConfigSort.id          => __EnumValue("id")
        }

        val values: scala.collection.immutable.Vector[PipelineConfigSort] =
            scala.collection.immutable.Vector(
                systemUpdateDate,
                systemRegistrationDate,
                description,
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

    sealed trait UserPipelineTransformSort
        extends scala.Product
            with scala.Serializable {
        def value: String
    }
    object UserPipelineTransformSort {
        case object state extends UserPipelineTransformSort {
            val value: String = "state"
        }
        case object systemUpdateDate extends UserPipelineTransformSort {
            val value: String = "systemUpdateDate"
        }
        case object systemRegistrationDate extends UserPipelineTransformSort {
            val value: String = "systemRegistrationDate"
        }
        case object description extends UserPipelineTransformSort {
            val value: String = "description"
        }
        case object id extends UserPipelineTransformSort {
            val value: String = "id"
        }

        implicit val decoder: ScalarDecoder[UserPipelineTransformSort] = {
            case __StringValue("state") => Right(UserPipelineTransformSort.state)
            case __StringValue("systemUpdateDate") =>
                Right(UserPipelineTransformSort.systemUpdateDate)
            case __StringValue("systemRegistrationDate") =>
                Right(UserPipelineTransformSort.systemRegistrationDate)
            case __StringValue("description") =>
                Right(UserPipelineTransformSort.description)
            case __StringValue("id") => Right(UserPipelineTransformSort.id)
            case other =>
                Left(
                    DecodingError(
                        s"Can't build UserPipelineTransformSort from input $other"
                    )
                )
        }
        implicit val encoder: ArgEncoder[UserPipelineTransformSort] = {
            case UserPipelineTransformSort.state => __EnumValue("state")
            case UserPipelineTransformSort.systemUpdateDate =>
                __EnumValue("systemUpdateDate")
            case UserPipelineTransformSort.systemRegistrationDate =>
                __EnumValue("systemRegistrationDate")
            case UserPipelineTransformSort.description => __EnumValue("description")
            case UserPipelineTransformSort.id          => __EnumValue("id")
        }

        val values: scala.collection.immutable.Vector[UserPipelineTransformSort] =
            scala.collection.immutable.Vector(
                state,
                systemUpdateDate,
                systemRegistrationDate,
                description,
                id
            )
    }

    sealed trait UserServiceState extends scala.Product with scala.Serializable {
        def value: String
    }
    object UserServiceState {
        case object buildFailed extends UserServiceState {
            val value: String = "buildFailed"
        }
        case object ready extends UserServiceState { val value: String = "ready" }
        case object imageNotReady extends UserServiceState {
            val value: String = "imageNotReady"
        }
        case object noImage extends UserServiceState {
            val value: String = "noImage"
        }

        implicit val decoder: ScalarDecoder[UserServiceState] = {
            case __StringValue("buildFailed") => Right(UserServiceState.buildFailed)
            case __StringValue("ready")       => Right(UserServiceState.ready)
            case __StringValue("imageNotReady") =>
                Right(UserServiceState.imageNotReady)
            case __StringValue("noImage") => Right(UserServiceState.noImage)
            case other =>
                Left(DecodingError(s"Can't build UserServiceState from input $other"))
        }
        implicit val encoder: ArgEncoder[UserServiceState] = {
            case UserServiceState.buildFailed   => __EnumValue("buildFailed")
            case UserServiceState.ready         => __EnumValue("ready")
            case UserServiceState.imageNotReady => __EnumValue("imageNotReady")
            case UserServiceState.noImage       => __EnumValue("noImage")
        }

        val values: scala.collection.immutable.Vector[UserServiceState] =
            scala.collection.immutable.Vector(
                buildFailed,
                ready,
                imageNotReady,
                noImage
            )
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

    type ActiveMessageList
    object ActiveMessageList {

        final case class ActiveMessageListView[MessagesSelection](
                                                                     messages: List[MessagesSelection],
                                                                     total: Int
                                                                 )

        type ViewSelection[MessagesSelection] =
            SelectionBuilder[ActiveMessageList, ActiveMessageListView[
                MessagesSelection
            ]]

        def view[MessagesSelection](
                                       messagesSelection: SelectionBuilder[
                                           ActiveMessageStatus,
                                           MessagesSelection
                                       ]
                                   ): ViewSelection[MessagesSelection] =
            (messages(messagesSelection) ~ total).map { case (messages, total) =>
                ActiveMessageListView(messages, total)
            }

        def messages[A](
                           innerSelection: SelectionBuilder[ActiveMessageStatus, A]
                       ): SelectionBuilder[ActiveMessageList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("messages", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[ActiveMessageList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type ActiveMessageStatus
    object ActiveMessageStatus {

        final case class ActiveMessageStatusView[InfoSelection](
                                                                   id: String,
                                                                   info: InfoSelection
                                                               )

        type ViewSelection[InfoSelection] =
            SelectionBuilder[ActiveMessageStatus, ActiveMessageStatusView[
                InfoSelection
            ]]

        def view[InfoSelection](
                                   infoSelection: SelectionBuilder[MessageInProgress, InfoSelection]
                               ): ViewSelection[InfoSelection] = (id ~ info(infoSelection)).map {
            case (id, info) => ActiveMessageStatusView(id, info)
        }

        def id: SelectionBuilder[ActiveMessageStatus, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def info[A](
                       innerSelection: SelectionBuilder[MessageInProgress, A]
                   ): SelectionBuilder[ActiveMessageStatus, A] =
            _root_.caliban.client.SelectionBuilder.Field("info", Obj(innerSelection))
    }

    type CompletedOkMessageList
    object CompletedOkMessageList {

        final case class CompletedOkMessageListView[MessagesSelection](
                                                                          messages: List[MessagesSelection],
                                                                          total: Int
                                                                      )

        type ViewSelection[MessagesSelection] =
            SelectionBuilder[CompletedOkMessageList, CompletedOkMessageListView[
                MessagesSelection
            ]]

        def view[MessagesSelection](
                                       messagesSelection: SelectionBuilder[
                                           CompletedOkMessageStatus,
                                           MessagesSelection
                                       ]
                                   ): ViewSelection[MessagesSelection] =
            (messages(messagesSelection) ~ total).map { case (messages, total) =>
                CompletedOkMessageListView(messages, total)
            }

        def messages[A](
                           innerSelection: SelectionBuilder[CompletedOkMessageStatus, A]
                       ): SelectionBuilder[CompletedOkMessageList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("messages", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[CompletedOkMessageList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type CompletedOkMessageStatus
    object CompletedOkMessageStatus {

        final case class CompletedOkMessageStatusView[InfoSelection](
                                                                        id: String,
                                                                        info: InfoSelection
                                                                    )

        type ViewSelection[InfoSelection] =
            SelectionBuilder[CompletedOkMessageStatus, CompletedOkMessageStatusView[
                InfoSelection
            ]]

        def view[InfoSelection](
                                   infoSelection: SelectionBuilder[MessageOk, InfoSelection]
                               ): ViewSelection[InfoSelection] = (id ~ info(infoSelection)).map {
            case (id, info) => CompletedOkMessageStatusView(id, info)
        }

        def id: SelectionBuilder[CompletedOkMessageStatus, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def info[A](
                       innerSelection: SelectionBuilder[MessageOk, A]
                   ): SelectionBuilder[CompletedOkMessageStatus, A] =
            _root_.caliban.client.SelectionBuilder.Field("info", Obj(innerSelection))
    }

    type ConceptTransformConfig
    object ConceptTransformConfig {

        final case class ConceptTransformConfigView[
            TransformsSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             id: String,
             title: String,
             description: scala.Option[String],
             conceptTypeIds: scala.Option[List[String]],
             canTransformOneEntity: Boolean,
             canTransformMultipleEntities: Boolean,
             transforms: List[TransformsSelection],
             lastTaskTime: scala.Option[UnixTime],
             metrics: MetricsSelection,
             priority: Int,
             deleted: Boolean,
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            TransformsSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[ConceptTransformConfig, ConceptTransformConfigView[
            TransformsSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[
            TransformsSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             transformsSelection: SelectionBuilder[
                 PipelineTransformSetup,
                 TransformsSelection
             ],
             metricsSelection: SelectionBuilder[KafkaTopicMetrics, MetricsSelection],
             creatorSelection: SelectionBuilder[User, CreatorSelection],
             lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
         ): ViewSelection[
            TransformsSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = (id ~ title ~ description ~ conceptTypeIds ~ canTransformOneEntity ~ canTransformMultipleEntities ~ transforms(
            transformsSelection
        ) ~ lastTaskTime ~ metrics(
            metricsSelection
        ) ~ priority ~ deleted ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
            creatorSelection
        ) ~ lastUpdater(lastUpdaterSelection)).map {
            case (
                id,
                title,
                description,
                conceptTypeIds,
                canTransformOneEntity,
                canTransformMultipleEntities,
                transforms,
                lastTaskTime,
                metrics,
                priority,
                deleted,
                systemRegistrationDate,
                systemUpdateDate,
                creator,
                lastUpdater
                ) =>
                ConceptTransformConfigView(
                    id,
                    title,
                    description,
                    conceptTypeIds,
                    canTransformOneEntity,
                    canTransformMultipleEntities,
                    transforms,
                    lastTaskTime,
                    metrics,
                    priority,
                    deleted,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                )
        }

        def id: SelectionBuilder[ConceptTransformConfig, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def title: SelectionBuilder[ConceptTransformConfig, String] =
            _root_.caliban.client.SelectionBuilder.Field("title", Scalar())
        def description
        : SelectionBuilder[ConceptTransformConfig, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("description", OptionOf(Scalar()))
        def conceptTypeIds
        : SelectionBuilder[ConceptTransformConfig, scala.Option[List[String]]] =
            _root_.caliban.client.SelectionBuilder
                .Field("conceptTypeIds", OptionOf(ListOf(Scalar())))
        def canTransformOneEntity
        : SelectionBuilder[ConceptTransformConfig, Boolean] =
            _root_.caliban.client.SelectionBuilder
                .Field("canTransformOneEntity", Scalar())
        def canTransformMultipleEntities
        : SelectionBuilder[ConceptTransformConfig, Boolean] =
            _root_.caliban.client.SelectionBuilder
                .Field("canTransformMultipleEntities", Scalar())
        def transforms[A](
                             innerSelection: SelectionBuilder[PipelineTransformSetup, A]
                         ): SelectionBuilder[ConceptTransformConfig, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("transforms", ListOf(Obj(innerSelection)))
        def lastTaskTime
        : SelectionBuilder[ConceptTransformConfig, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastTaskTime", OptionOf(Scalar()))
        def metrics[A](
                          innerSelection: SelectionBuilder[KafkaTopicMetrics, A]
                      ): SelectionBuilder[ConceptTransformConfig, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("metrics", Obj(innerSelection))
        def priority: SelectionBuilder[ConceptTransformConfig, Int] =
            _root_.caliban.client.SelectionBuilder.Field("priority", Scalar())
        def deleted: SelectionBuilder[ConceptTransformConfig, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("deleted", Scalar())
        def systemRegistrationDate
        : SelectionBuilder[ConceptTransformConfig, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate
        : SelectionBuilder[ConceptTransformConfig, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[ConceptTransformConfig, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[ConceptTransformConfig, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type ConceptTransformConfigList
    object ConceptTransformConfigList {

        final case class ConceptTransformConfigListView[ConfigsSelection](
                                                                             configs: List[ConfigsSelection],
                                                                             total: Int
                                                                         )

        type ViewSelection[ConfigsSelection] = SelectionBuilder[
            ConceptTransformConfigList,
            ConceptTransformConfigListView[ConfigsSelection]
        ]

        def view[ConfigsSelection](
                                      configsSelection: SelectionBuilder[
                                          ConceptTransformConfig,
                                          ConfigsSelection
                                      ]
                                  ): ViewSelection[ConfigsSelection] =
            (configs(configsSelection) ~ total).map { case (configs, total) =>
                ConceptTransformConfigListView(configs, total)
            }

        def configs[A](
                          innerSelection: SelectionBuilder[ConceptTransformConfig, A]
                      ): SelectionBuilder[ConceptTransformConfigList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("configs", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[ConceptTransformConfigList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type ConceptTransformResults
    object ConceptTransformResults {

        final case class ConceptTransformResultsView(
                                                        concepts: scala.Option[List[String]],
                                                        error: scala.Option[String]
                                                    )

        type ViewSelection =
            SelectionBuilder[ConceptTransformResults, ConceptTransformResultsView]

        def view: ViewSelection = (concepts ~ error).map { case (concepts, error) =>
            ConceptTransformResultsView(concepts, error)
        }

        def concepts: SelectionBuilder[ConceptTransformResults, scala.Option[List[
            String
        ]]] = _root_.caliban.client.SelectionBuilder
            .Field("concepts", OptionOf(ListOf(Scalar())))
        def error: SelectionBuilder[ConceptTransformResults, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("error", OptionOf(Scalar()))
    }

    type ConceptTransformTask
    object ConceptTransformTask {

        final case class ConceptTransformTaskView[
            ResultSelection,
            ConfigSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             id: String,
             conceptIds: List[String],
             state: ConceptTransformTaskState,
             active: Boolean,
             result: scala.Option[ResultSelection],
             config: scala.Option[ConfigSelection],
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            ResultSelection,
            ConfigSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[ConceptTransformTask, ConceptTransformTaskView[
            ResultSelection,
            ConfigSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[
            ResultSelection,
            ConfigSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             resultSelection: SelectionBuilder[
                 ConceptTransformResults,
                 ResultSelection
             ],
             configSelection: SelectionBuilder[
                 ConceptTransformConfig,
                 ConfigSelection
             ],
             creatorSelection: SelectionBuilder[User, CreatorSelection],
             lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
         ): ViewSelection[
            ResultSelection,
            ConfigSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = (id ~ conceptIds ~ state ~ active ~ result(resultSelection) ~ config(
            configSelection
        ) ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
            creatorSelection
        ) ~ lastUpdater(lastUpdaterSelection)).map {
            case (
                id,
                conceptIds,
                state,
                active,
                result,
                config,
                systemRegistrationDate,
                systemUpdateDate,
                creator,
                lastUpdater
                ) =>
                ConceptTransformTaskView(
                    id,
                    conceptIds,
                    state,
                    active,
                    result,
                    config,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                )
        }

        def id: SelectionBuilder[ConceptTransformTask, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def conceptIds: SelectionBuilder[ConceptTransformTask, List[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("conceptIds", ListOf(Scalar()))
        def state
        : SelectionBuilder[ConceptTransformTask, ConceptTransformTaskState] =
            _root_.caliban.client.SelectionBuilder.Field("state", Scalar())
        def active: SelectionBuilder[ConceptTransformTask, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("active", Scalar())
        def result[A](
                         innerSelection: SelectionBuilder[ConceptTransformResults, A]
                     ): SelectionBuilder[ConceptTransformTask, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("result", OptionOf(Obj(innerSelection)))
        def config[A](
                         innerSelection: SelectionBuilder[ConceptTransformConfig, A]
                     ): SelectionBuilder[ConceptTransformTask, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("config", OptionOf(Obj(innerSelection)))
        def systemRegistrationDate
        : SelectionBuilder[ConceptTransformTask, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate
        : SelectionBuilder[ConceptTransformTask, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[ConceptTransformTask, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[ConceptTransformTask, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type ConceptTransformTaskList
    object ConceptTransformTaskList {

        final case class ConceptTransformTaskListView[TasksSelection](
                                                                         tasks: List[TasksSelection],
                                                                         total: Int
                                                                     )

        type ViewSelection[TasksSelection] =
            SelectionBuilder[ConceptTransformTaskList, ConceptTransformTaskListView[
                TasksSelection
            ]]

        def view[TasksSelection](
                                    tasksSelection: SelectionBuilder[ConceptTransformTask, TasksSelection]
                                ): ViewSelection[TasksSelection] = (tasks(tasksSelection) ~ total).map {
            case (tasks, total) => ConceptTransformTaskListView(tasks, total)
        }

        def tasks[A](
                        innerSelection: SelectionBuilder[ConceptTransformTask, A]
                    ): SelectionBuilder[ConceptTransformTaskList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("tasks", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[ConceptTransformTaskList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type DuplicateMessageList
    object DuplicateMessageList {

        final case class DuplicateMessageListView[MessagesSelection](
                                                                        messages: List[MessagesSelection],
                                                                        total: Int
                                                                    )

        type ViewSelection[MessagesSelection] =
            SelectionBuilder[DuplicateMessageList, DuplicateMessageListView[
                MessagesSelection
            ]]

        def view[MessagesSelection](
                                       messagesSelection: SelectionBuilder[
                                           DuplicateMessageStatus,
                                           MessagesSelection
                                       ]
                                   ): ViewSelection[MessagesSelection] =
            (messages(messagesSelection) ~ total).map { case (messages, total) =>
                DuplicateMessageListView(messages, total)
            }

        def messages[A](
                           innerSelection: SelectionBuilder[DuplicateMessageStatus, A]
                       ): SelectionBuilder[DuplicateMessageList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("messages", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[DuplicateMessageList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type DuplicateMessageStatus
    object DuplicateMessageStatus {

        final case class DuplicateMessageStatusView[InfoSelection](
                                                                      id: String,
                                                                      info: InfoSelection
                                                                  )

        type ViewSelection[InfoSelection] =
            SelectionBuilder[DuplicateMessageStatus, DuplicateMessageStatusView[
                InfoSelection
            ]]

        def view[InfoSelection](
                                   infoSelection: SelectionBuilder[MessageDuplicate, InfoSelection]
                               ): ViewSelection[InfoSelection] = (id ~ info(infoSelection)).map {
            case (id, info) => DuplicateMessageStatusView(id, info)
        }

        def id: SelectionBuilder[DuplicateMessageStatus, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def info[A](
                       innerSelection: SelectionBuilder[MessageDuplicate, A]
                   ): SelectionBuilder[DuplicateMessageStatus, A] =
            _root_.caliban.client.SelectionBuilder.Field("info", Obj(innerSelection))
    }

    type ExportEntity
    object ExportEntity {

        final case class ExportEntityView(`type`: ExportEntityType, id: String)

        type ViewSelection = SelectionBuilder[ExportEntity, ExportEntityView]

        def view: ViewSelection = (`type` ~ id).map { case (type$, id) =>
            ExportEntityView(type$, id)
        }

        def `type`: SelectionBuilder[ExportEntity, ExportEntityType] =
            _root_.caliban.client.SelectionBuilder.Field("type", Scalar())
        def id: SelectionBuilder[ExportEntity, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    }

    type Exporter
    object Exporter {

        final case class ExporterView[
            ParamsSchemaSelection,
            DefaultParamsSchemaSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             id: String,
             title: String,
             menuTitle: String,
             description: String,
             paramsSchema: ParamsSchemaSelection,
             defaultParamsSchema: DefaultParamsSchemaSelection,
             defaultParams: JSON,
             conceptTypeIds: scala.Option[List[String]],
             canExportDocument: Boolean,
             canExportConcept: Boolean,
             canExportOneEntity: Boolean,
             canExportMultipleEntities: Boolean,
             lastTaskTime: scala.Option[UnixTime],
             metrics: MetricsSelection,
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            ParamsSchemaSelection,
            DefaultParamsSchemaSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[Exporter, ExporterView[
            ParamsSchemaSelection,
            DefaultParamsSchemaSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[
            ParamsSchemaSelection,
            DefaultParamsSchemaSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             paramsSchemaSelection: SelectionBuilder[
                 ParamsSchema,
                 ParamsSchemaSelection
             ],
             defaultParamsSchemaSelection: SelectionBuilder[
                 ParamsSchema,
                 DefaultParamsSchemaSelection
             ],
             metricsSelection: SelectionBuilder[KafkaTopicMetrics, MetricsSelection],
             creatorSelection: SelectionBuilder[User, CreatorSelection],
             lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
         ): ViewSelection[
            ParamsSchemaSelection,
            DefaultParamsSchemaSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = (id ~ title ~ menuTitle ~ description ~ paramsSchema(
            paramsSchemaSelection
        ) ~ defaultParamsSchema(
            defaultParamsSchemaSelection
        ) ~ defaultParams ~ conceptTypeIds ~ canExportDocument ~ canExportConcept ~ canExportOneEntity ~ canExportMultipleEntities ~ lastTaskTime ~ metrics(
            metricsSelection
        ) ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
            creatorSelection
        ) ~ lastUpdater(lastUpdaterSelection)).map {
            case (
                id,
                title,
                menuTitle,
                description,
                paramsSchema,
                defaultParamsSchema,
                defaultParams,
                conceptTypeIds,
                canExportDocument,
                canExportConcept,
                canExportOneEntity,
                canExportMultipleEntities,
                lastTaskTime,
                metrics,
                systemRegistrationDate,
                systemUpdateDate,
                creator,
                lastUpdater
                ) =>
                ExporterView(
                    id,
                    title,
                    menuTitle,
                    description,
                    paramsSchema,
                    defaultParamsSchema,
                    defaultParams,
                    conceptTypeIds,
                    canExportDocument,
                    canExportConcept,
                    canExportOneEntity,
                    canExportMultipleEntities,
                    lastTaskTime,
                    metrics,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                )
        }

        def id: SelectionBuilder[Exporter, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def title: SelectionBuilder[Exporter, String] =
            _root_.caliban.client.SelectionBuilder.Field("title", Scalar())
        def menuTitle: SelectionBuilder[Exporter, String] =
            _root_.caliban.client.SelectionBuilder.Field("menuTitle", Scalar())
        def description: SelectionBuilder[Exporter, String] =
            _root_.caliban.client.SelectionBuilder.Field("description", Scalar())
        def paramsSchema[A](
                               innerSelection: SelectionBuilder[ParamsSchema, A]
                           ): SelectionBuilder[Exporter, A] = _root_.caliban.client.SelectionBuilder
            .Field("paramsSchema", Obj(innerSelection))
        def defaultParamsSchema[A](
                                      innerSelection: SelectionBuilder[ParamsSchema, A]
                                  ): SelectionBuilder[Exporter, A] = _root_.caliban.client.SelectionBuilder
            .Field("defaultParamsSchema", Obj(innerSelection))
        def defaultParams: SelectionBuilder[Exporter, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("defaultParams", Scalar())
        def conceptTypeIds: SelectionBuilder[Exporter, scala.Option[List[String]]] =
            _root_.caliban.client.SelectionBuilder
                .Field("conceptTypeIds", OptionOf(ListOf(Scalar())))
        def canExportDocument: SelectionBuilder[Exporter, Boolean] =
            _root_.caliban.client.SelectionBuilder
                .Field("canExportDocument", Scalar())
        def canExportConcept: SelectionBuilder[Exporter, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("canExportConcept", Scalar())
        def canExportOneEntity: SelectionBuilder[Exporter, Boolean] =
            _root_.caliban.client.SelectionBuilder
                .Field("canExportOneEntity", Scalar())
        def canExportMultipleEntities: SelectionBuilder[Exporter, Boolean] =
            _root_.caliban.client.SelectionBuilder
                .Field("canExportMultipleEntities", Scalar())
        def lastTaskTime: SelectionBuilder[Exporter, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastTaskTime", OptionOf(Scalar()))
        def metrics[A](
                          innerSelection: SelectionBuilder[KafkaTopicMetrics, A]
                      ): SelectionBuilder[Exporter, A] = _root_.caliban.client.SelectionBuilder
            .Field("metrics", Obj(innerSelection))
        def systemRegistrationDate: SelectionBuilder[Exporter, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate: SelectionBuilder[Exporter, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[Exporter, A] = _root_.caliban.client.SelectionBuilder
            .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[Exporter, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type ExporterList
    object ExporterList {

        final case class ExporterListView[ExportersSelection](
                                                                 exporters: List[ExportersSelection],
                                                                 total: Int
                                                             )

        type ViewSelection[ExportersSelection] =
            SelectionBuilder[ExporterList, ExporterListView[ExportersSelection]]

        def view[ExportersSelection](
                                        exportersSelection: SelectionBuilder[Exporter, ExportersSelection]
                                    ): ViewSelection[ExportersSelection] =
            (exporters(exportersSelection) ~ total).map { case (exporters, total) =>
                ExporterListView(exporters, total)
            }

        def exporters[A](
                            innerSelection: SelectionBuilder[Exporter, A]
                        ): SelectionBuilder[ExporterList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("exporters", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[ExporterList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type ExportResults
    object ExportResults {

        final case class ExportResultsView(
                                              file: scala.Option[String],
                                              message: scala.Option[String],
                                              error: scala.Option[String]
                                          )

        type ViewSelection = SelectionBuilder[ExportResults, ExportResultsView]

        def view: ViewSelection = (file ~ message ~ error).map {
            case (file, message, error) => ExportResultsView(file, message, error)
        }

        def file: SelectionBuilder[ExportResults, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("file", OptionOf(Scalar()))
        def message: SelectionBuilder[ExportResults, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("message", OptionOf(Scalar()))
        def error: SelectionBuilder[ExportResults, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("error", OptionOf(Scalar()))
    }

    type ExportTask
    object ExportTask {

        final case class ExportTaskView[
            EntitiesSelection,
            ResultSelection,
            ExporterSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             id: String,
             entities: List[EntitiesSelection],
             params: JSON,
             state: ExportTaskState,
             active: Boolean,
             result: scala.Option[ResultSelection],
             createTime: UnixTime,
             exporter: scala.Option[ExporterSelection],
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            EntitiesSelection,
            ResultSelection,
            ExporterSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[ExportTask, ExportTaskView[
            EntitiesSelection,
            ResultSelection,
            ExporterSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[
            EntitiesSelection,
            ResultSelection,
            ExporterSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             entitiesSelection: SelectionBuilder[ExportEntity, EntitiesSelection],
             resultSelection: SelectionBuilder[ExportResults, ResultSelection],
             exporterSelection: SelectionBuilder[Exporter, ExporterSelection],
             creatorSelection: SelectionBuilder[User, CreatorSelection],
             lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
         ): ViewSelection[
            EntitiesSelection,
            ResultSelection,
            ExporterSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = (id ~ entities(entitiesSelection) ~ params ~ state ~ active ~ result(
            resultSelection
        ) ~ createTime ~ exporter(
            exporterSelection
        ) ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
            creatorSelection
        ) ~ lastUpdater(lastUpdaterSelection)).map {
            case (
                id,
                entities,
                params,
                state,
                active,
                result,
                createTime,
                exporter,
                systemRegistrationDate,
                systemUpdateDate,
                creator,
                lastUpdater
                ) =>
                ExportTaskView(
                    id,
                    entities,
                    params,
                    state,
                    active,
                    result,
                    createTime,
                    exporter,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                )
        }

        def id: SelectionBuilder[ExportTask, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def entities[A](
                           innerSelection: SelectionBuilder[ExportEntity, A]
                       ): SelectionBuilder[ExportTask, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("entities", ListOf(Obj(innerSelection)))
        def params: SelectionBuilder[ExportTask, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("params", Scalar())
        def state: SelectionBuilder[ExportTask, ExportTaskState] =
            _root_.caliban.client.SelectionBuilder.Field("state", Scalar())
        def active: SelectionBuilder[ExportTask, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("active", Scalar())
        def result[A](
                         innerSelection: SelectionBuilder[ExportResults, A]
                     ): SelectionBuilder[ExportTask, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("result", OptionOf(Obj(innerSelection)))
        def createTime: SelectionBuilder[ExportTask, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("createTime", Scalar())
        def exporter[A](
                           innerSelection: SelectionBuilder[Exporter, A]
                       ): SelectionBuilder[ExportTask, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("exporter", OptionOf(Obj(innerSelection)))
        def systemRegistrationDate: SelectionBuilder[ExportTask, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate: SelectionBuilder[ExportTask, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[ExportTask, A] = _root_.caliban.client.SelectionBuilder
            .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[ExportTask, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type ExportTaskList
    object ExportTaskList {

        final case class ExportTaskListView[TasksSelection](
                                                               tasks: List[TasksSelection],
                                                               total: Int
                                                           )

        type ViewSelection[TasksSelection] =
            SelectionBuilder[ExportTaskList, ExportTaskListView[TasksSelection]]

        def view[TasksSelection](
                                    tasksSelection: SelectionBuilder[ExportTask, TasksSelection]
                                ): ViewSelection[TasksSelection] = (tasks(tasksSelection) ~ total).map {
            case (tasks, total) => ExportTaskListView(tasks, total)
        }

        def tasks[A](
                        innerSelection: SelectionBuilder[ExportTask, A]
                    ): SelectionBuilder[ExportTaskList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("tasks", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[ExportTaskList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type FailedMessageList
    object FailedMessageList {

        final case class FailedMessageListView[MessagesSelection](
                                                                     messages: List[MessagesSelection],
                                                                     total: Int
                                                                 )

        type ViewSelection[MessagesSelection] =
            SelectionBuilder[FailedMessageList, FailedMessageListView[
                MessagesSelection
            ]]

        def view[MessagesSelection](
                                       messagesSelection: SelectionBuilder[MessageStatus, MessagesSelection]
                                   ): ViewSelection[MessagesSelection] =
            (messages(messagesSelection) ~ total).map { case (messages, total) =>
                FailedMessageListView(messages, total)
            }

        def messages[A](
                           innerSelection: SelectionBuilder[MessageStatus, A]
                       ): SelectionBuilder[FailedMessageList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("messages", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[FailedMessageList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type Item
    object Item {

        final case class ItemView[StatusSelection](
                                                      job_id: String,
                                                      timestamp: UnixTime,
                                                      _uuid: String,
                                                      _url: scala.Option[String],
                                                      id: scala.Option[String],
                                                      attachmentsNum: Int,
                                                      status: StatusSelection,
                                                      item: JSON
                                                  )

        type ViewSelection[StatusSelection] =
            SelectionBuilder[Item, ItemView[StatusSelection]]

        def view[StatusSelection](
                                     statusSelection: SelectionBuilder[MessageStatus, StatusSelection]
                                 ): ViewSelection[StatusSelection] =
            (job_id ~ timestamp ~ _uuid ~ _url ~ id ~ attachmentsNum ~ status(
                statusSelection
            ) ~ item).map {
                case (
                    job_id,
                    timestamp,
                    _uuid,
                    _url,
                    id,
                    attachmentsNum,
                    status,
                    item
                    ) =>
                    ItemView(
                        job_id,
                        timestamp,
                        _uuid,
                        _url,
                        id,
                        attachmentsNum,
                        status,
                        item
                    )
            }

        def job_id: SelectionBuilder[Item, String] =
            _root_.caliban.client.SelectionBuilder.Field("job_id", Scalar())
        def timestamp: SelectionBuilder[Item, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("timestamp", Scalar())
        def _uuid: SelectionBuilder[Item, String] =
            _root_.caliban.client.SelectionBuilder.Field("_uuid", Scalar())
        def _url: SelectionBuilder[Item, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("_url", OptionOf(Scalar()))
        def id: SelectionBuilder[Item, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
        def attachmentsNum: SelectionBuilder[Item, Int] =
            _root_.caliban.client.SelectionBuilder.Field("attachmentsNum", Scalar())
        def status[A](
                         innerSelection: SelectionBuilder[MessageStatus, A]
                     ): SelectionBuilder[Item, A] = _root_.caliban.client.SelectionBuilder
            .Field("status", Obj(innerSelection))
        def item: SelectionBuilder[Item, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("item", Scalar())
    }

    type ItemsList
    object ItemsList {

        final case class ItemsListView[ItemsSelection](
                                                          total: Long,
                                                          items: List[ItemsSelection]
                                                      )

        type ViewSelection[ItemsSelection] =
            SelectionBuilder[ItemsList, ItemsListView[ItemsSelection]]

        def view[ItemsSelection](
                                    itemsSelection: SelectionBuilder[Item, ItemsSelection]
                                ): ViewSelection[ItemsSelection] = (total ~ items(itemsSelection)).map {
            case (total, items) => ItemsListView(total, items)
        }

        def total: SelectionBuilder[ItemsList, Long] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
        def items[A](
                        innerSelection: SelectionBuilder[Item, A]
                    ): SelectionBuilder[ItemsList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("items", ListOf(Obj(innerSelection)))
    }

    type JobIds
    object JobIds {

        final case class JobIdsView(
                                       jobId: scala.Option[String],
                                       taskId: scala.Option[String],
                                       periodicJobId: scala.Option[String],
                                       periodicTaskId: scala.Option[String]
                                   )

        type ViewSelection = SelectionBuilder[JobIds, JobIdsView]

        def view: ViewSelection =
            (jobId ~ taskId ~ periodicJobId ~ periodicTaskId).map {
                case (jobId, taskId, periodicJobId, periodicTaskId) =>
                    JobIdsView(jobId, taskId, periodicJobId, periodicTaskId)
            }

        def jobId: SelectionBuilder[JobIds, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("jobId", OptionOf(Scalar()))
        def taskId: SelectionBuilder[JobIds, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("taskId", OptionOf(Scalar()))
        def periodicJobId: SelectionBuilder[JobIds, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("periodicJobId", OptionOf(Scalar()))
        def periodicTaskId: SelectionBuilder[JobIds, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("periodicTaskId", OptionOf(Scalar()))
    }

    type JobMetrics
    object JobMetrics {

        final case class JobMetricsView[MetricsSelection](
                                                             jobId: String,
                                                             metrics: MetricsSelection
                                                         )

        type ViewSelection[MetricsSelection] =
            SelectionBuilder[JobMetrics, JobMetricsView[MetricsSelection]]

        def view[MetricsSelection](
                                      metricsSelection: SelectionBuilder[MessageMetrics, MetricsSelection]
                                  ): ViewSelection[MetricsSelection] =
            (jobId ~ metrics(metricsSelection)).map { case (jobId, metrics) =>
                JobMetricsView(jobId, metrics)
            }

        def jobId: SelectionBuilder[JobMetrics, String] =
            _root_.caliban.client.SelectionBuilder.Field("jobId", Scalar())
        def metrics[A](
                          innerSelection: SelectionBuilder[MessageMetrics, A]
                      ): SelectionBuilder[JobMetrics, A] = _root_.caliban.client.SelectionBuilder
            .Field("metrics", Obj(innerSelection))
    }

    type KafkaTopic
    object KafkaTopic {

        final case class KafkaTopicView[
            PipelineSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             topic: String,
             description: scala.Option[String],
             pipeline: scala.Option[PipelineSelection],
             metrics: MetricsSelection,
             priority: Int,
             requestTimeoutMs: scala.Option[Int],
             moveToOnTimeout: scala.Option[String],
             systemTopic: Boolean,
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            PipelineSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[KafkaTopic, KafkaTopicView[
            PipelineSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[
            PipelineSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             pipelineSelection: SelectionBuilder[PipelineSetup, PipelineSelection],
             metricsSelection: SelectionBuilder[KafkaTopicMetrics, MetricsSelection],
             creatorSelection: SelectionBuilder[User, CreatorSelection],
             lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
         ): ViewSelection[
            PipelineSelection,
            MetricsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = (topic ~ description ~ pipeline(pipelineSelection) ~ metrics(
            metricsSelection
        ) ~ priority ~ requestTimeoutMs ~ moveToOnTimeout ~ systemTopic ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
            creatorSelection
        ) ~ lastUpdater(lastUpdaterSelection)).map {
            case (
                topic,
                description,
                pipeline,
                metrics,
                priority,
                requestTimeoutMs,
                moveToOnTimeout,
                systemTopic,
                systemRegistrationDate,
                systemUpdateDate,
                creator,
                lastUpdater
                ) =>
                KafkaTopicView(
                    topic,
                    description,
                    pipeline,
                    metrics,
                    priority,
                    requestTimeoutMs,
                    moveToOnTimeout,
                    systemTopic,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                )
        }

        def topic: SelectionBuilder[KafkaTopic, String] =
            _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
        def description: SelectionBuilder[KafkaTopic, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("description", OptionOf(Scalar()))
        def pipeline[A](
                           innerSelection: SelectionBuilder[PipelineSetup, A]
                       ): SelectionBuilder[KafkaTopic, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("pipeline", OptionOf(Obj(innerSelection)))
        def metrics[A](
                          innerSelection: SelectionBuilder[KafkaTopicMetrics, A]
                      ): SelectionBuilder[KafkaTopic, A] = _root_.caliban.client.SelectionBuilder
            .Field("metrics", Obj(innerSelection))
        def priority: SelectionBuilder[KafkaTopic, Int] =
            _root_.caliban.client.SelectionBuilder.Field("priority", Scalar())
        def requestTimeoutMs: SelectionBuilder[KafkaTopic, scala.Option[Int]] =
            _root_.caliban.client.SelectionBuilder
                .Field("requestTimeoutMs", OptionOf(Scalar()))
        def moveToOnTimeout: SelectionBuilder[KafkaTopic, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("moveToOnTimeout", OptionOf(Scalar()))
        def systemTopic: SelectionBuilder[KafkaTopic, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("systemTopic", Scalar())
        def systemRegistrationDate: SelectionBuilder[KafkaTopic, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate: SelectionBuilder[KafkaTopic, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[KafkaTopic, A] = _root_.caliban.client.SelectionBuilder
            .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[KafkaTopic, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type KafkaTopicList
    object KafkaTopicList {

        final case class KafkaTopicListView[TopicsSelection](
                                                                topics: List[TopicsSelection],
                                                                total: Int
                                                            )

        type ViewSelection[TopicsSelection] =
            SelectionBuilder[KafkaTopicList, KafkaTopicListView[TopicsSelection]]

        def view[TopicsSelection](
                                     topicsSelection: SelectionBuilder[KafkaTopic, TopicsSelection]
                                 ): ViewSelection[TopicsSelection] = (topics(topicsSelection) ~ total).map {
            case (topics, total) => KafkaTopicListView(topics, total)
        }

        def topics[A](
                         innerSelection: SelectionBuilder[KafkaTopic, A]
                     ): SelectionBuilder[KafkaTopicList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("topics", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[KafkaTopicList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type KafkaTopicMetrics
    object KafkaTopicMetrics {

        final case class KafkaTopicMetricsView(
                                                  messages: Long,
                                                  lag: Long,
                                                  activeMessages: Long,
                                                  pipelineIsActive: Boolean,
                                                  failed: Int,
                                                  ok: Int,
                                                  okCumulative: Int,
                                                  duplicate: Int,
                                                  pending: Int
                                              )

        type ViewSelection =
            SelectionBuilder[KafkaTopicMetrics, KafkaTopicMetricsView]

        def view: ViewSelection =
            (messages ~ lag ~ activeMessages ~ pipelineIsActive ~ failed ~ ok ~ okCumulative ~ duplicate ~ pending)
                .map {
                    case (
                        messages,
                        lag,
                        activeMessages,
                        pipelineIsActive,
                        failed,
                        ok,
                        okCumulative,
                        duplicate,
                        pending
                        ) =>
                        KafkaTopicMetricsView(
                            messages,
                            lag,
                            activeMessages,
                            pipelineIsActive,
                            failed,
                            ok,
                            okCumulative,
                            duplicate,
                            pending
                        )
                }

        def messages: SelectionBuilder[KafkaTopicMetrics, Long] =
            _root_.caliban.client.SelectionBuilder.Field("messages", Scalar())
        @deprecated("use pending instead", "")
        def lag: SelectionBuilder[KafkaTopicMetrics, Long] =
            _root_.caliban.client.SelectionBuilder.Field("lag", Scalar())
        def activeMessages: SelectionBuilder[KafkaTopicMetrics, Long] =
            _root_.caliban.client.SelectionBuilder.Field("activeMessages", Scalar())
        def pipelineIsActive: SelectionBuilder[KafkaTopicMetrics, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("pipelineIsActive", Scalar())
        def failed: SelectionBuilder[KafkaTopicMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("failed", Scalar())
        def ok: SelectionBuilder[KafkaTopicMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("ok", Scalar())
        def okCumulative: SelectionBuilder[KafkaTopicMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("okCumulative", Scalar())
        def duplicate: SelectionBuilder[KafkaTopicMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("duplicate", Scalar())
        def pending: SelectionBuilder[KafkaTopicMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("pending", Scalar())
    }

    type MessageDuplicate
    object MessageDuplicate {

        final case class MessageDuplicateView(
                                                 createTime: UnixTime,
                                                 startTime: UnixTime,
                                                 finishTime: UnixTime,
                                                 topic: String,
                                                 result: scala.Option[String],
                                                 originalId: String,
                                                 deleted: Boolean,
                                                 message: JSON
                                             )

        type ViewSelection =
            SelectionBuilder[MessageDuplicate, MessageDuplicateView]

        def view: ViewSelection =
            (createTime ~ startTime ~ finishTime ~ topic ~ result ~ originalId ~ deleted ~ message)
                .map {
                    case (
                        createTime,
                        startTime,
                        finishTime,
                        topic,
                        result,
                        originalId,
                        deleted,
                        message
                        ) =>
                        MessageDuplicateView(
                            createTime,
                            startTime,
                            finishTime,
                            topic,
                            result,
                            originalId,
                            deleted,
                            message
                        )
                }

        def createTime: SelectionBuilder[MessageDuplicate, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("createTime", Scalar())
        def startTime: SelectionBuilder[MessageDuplicate, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("startTime", Scalar())
        def finishTime: SelectionBuilder[MessageDuplicate, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("finishTime", Scalar())
        def topic: SelectionBuilder[MessageDuplicate, String] =
            _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
        def result: SelectionBuilder[MessageDuplicate, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("result", OptionOf(Scalar()))
        def originalId: SelectionBuilder[MessageDuplicate, String] =
            _root_.caliban.client.SelectionBuilder.Field("originalId", Scalar())
        def deleted: SelectionBuilder[MessageDuplicate, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("deleted", Scalar())
        def message: SelectionBuilder[MessageDuplicate, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("message", Scalar())
    }

    type MessageError
    object MessageError {

        final case class MessageErrorView(description: String)

        type ViewSelection = SelectionBuilder[MessageError, MessageErrorView]

        def view: ViewSelection =
            description.map(description => MessageErrorView(description))

        def description: SelectionBuilder[MessageError, String] =
            _root_.caliban.client.SelectionBuilder.Field("description", Scalar())
    }

    type MessageFailed
    object MessageFailed {

        final case class MessageFailedView[StageSelection, ErrorSelection](
                                                                              createTime: UnixTime,
                                                                              startTime: UnixTime,
                                                                              finishTime: UnixTime,
                                                                              topic: String,
                                                                              stage: StageSelection,
                                                                              error: ErrorSelection,
                                                                              deleted: Boolean,
                                                                              duplicateOf: scala.Option[String],
                                                                              message: JSON
                                                                          )

        type ViewSelection[StageSelection, ErrorSelection] = SelectionBuilder[
            MessageFailed,
            MessageFailedView[StageSelection, ErrorSelection]
        ]

        def view[StageSelection, ErrorSelection](
                                                    stageSelection: SelectionBuilder[
                                                        PipelineTransformSetup,
                                                        StageSelection
                                                    ],
                                                    errorSelection: SelectionBuilder[MessageError, ErrorSelection]
                                                ): ViewSelection[StageSelection, ErrorSelection] =
            (createTime ~ startTime ~ finishTime ~ topic ~ stage(
                stageSelection
            ) ~ error(errorSelection) ~ deleted ~ duplicateOf ~ message).map {
                case (
                    createTime,
                    startTime,
                    finishTime,
                    topic,
                    stage,
                    error,
                    deleted,
                    duplicateOf,
                    message
                    ) =>
                    MessageFailedView(
                        createTime,
                        startTime,
                        finishTime,
                        topic,
                        stage,
                        error,
                        deleted,
                        duplicateOf,
                        message
                    )
            }

        def createTime: SelectionBuilder[MessageFailed, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("createTime", Scalar())
        def startTime: SelectionBuilder[MessageFailed, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("startTime", Scalar())
        def finishTime: SelectionBuilder[MessageFailed, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("finishTime", Scalar())
        def topic: SelectionBuilder[MessageFailed, String] =
            _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
        def stage[A](
                        innerSelection: SelectionBuilder[PipelineTransformSetup, A]
                    ): SelectionBuilder[MessageFailed, A] =
            _root_.caliban.client.SelectionBuilder.Field("stage", Obj(innerSelection))
        def error[A](
                        innerSelection: SelectionBuilder[MessageError, A]
                    ): SelectionBuilder[MessageFailed, A] =
            _root_.caliban.client.SelectionBuilder.Field("error", Obj(innerSelection))
        def deleted: SelectionBuilder[MessageFailed, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("deleted", Scalar())
        def duplicateOf: SelectionBuilder[MessageFailed, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("duplicateOf", OptionOf(Scalar()))
        def message: SelectionBuilder[MessageFailed, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("message", Scalar())
    }

    type MessageInProgress
    object MessageInProgress {

        final case class MessageInProgressView[StageSelection](
                                                                  createTime: UnixTime,
                                                                  startTime: UnixTime,
                                                                  topic: String,
                                                                  stage: StageSelection,
                                                                  message: JSON
                                                              )

        type ViewSelection[StageSelection] =
            SelectionBuilder[MessageInProgress, MessageInProgressView[StageSelection]]

        def view[StageSelection](
                                    stageSelection: SelectionBuilder[PipelineTransformSetup, StageSelection]
                                ): ViewSelection[StageSelection] =
            (createTime ~ startTime ~ topic ~ stage(stageSelection) ~ message).map {
                case (createTime, startTime, topic, stage, message) =>
                    MessageInProgressView(createTime, startTime, topic, stage, message)
            }

        def createTime: SelectionBuilder[MessageInProgress, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("createTime", Scalar())
        def startTime: SelectionBuilder[MessageInProgress, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("startTime", Scalar())
        def topic: SelectionBuilder[MessageInProgress, String] =
            _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
        def stage[A](
                        innerSelection: SelectionBuilder[PipelineTransformSetup, A]
                    ): SelectionBuilder[MessageInProgress, A] =
            _root_.caliban.client.SelectionBuilder.Field("stage", Obj(innerSelection))
        def message: SelectionBuilder[MessageInProgress, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("message", Scalar())
    }

    type MessageList
    object MessageList {

        final case class MessageListView[MessagesSelection](
                                                               messages: List[MessagesSelection],
                                                               total: Int
                                                           )

        type ViewSelection[MessagesSelection] =
            SelectionBuilder[MessageList, MessageListView[MessagesSelection]]

        def view[MessagesSelection](
                                       messagesSelection: SelectionBuilder[MessageStatus, MessagesSelection]
                                   ): ViewSelection[MessagesSelection] =
            (messages(messagesSelection) ~ total).map { case (messages, total) =>
                MessageListView(messages, total)
            }

        def messages[A](
                           innerSelection: SelectionBuilder[MessageStatus, A]
                       ): SelectionBuilder[MessageList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("messages", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[MessageList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type MessageMetrics
    object MessageMetrics {

        final case class MessageMetricsView(
                                               pending: Int,
                                               failed: Int,
                                               ok: Int,
                                               duplicate: Int
                                           )

        type ViewSelection = SelectionBuilder[MessageMetrics, MessageMetricsView]

        def view: ViewSelection = (pending ~ failed ~ ok ~ duplicate).map {
            case (pending, failed, ok, duplicate) =>
                MessageMetricsView(pending, failed, ok, duplicate)
        }

        def pending: SelectionBuilder[MessageMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("pending", Scalar())
        def failed: SelectionBuilder[MessageMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("failed", Scalar())
        def ok: SelectionBuilder[MessageMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("ok", Scalar())
        def duplicate: SelectionBuilder[MessageMetrics, Int] =
            _root_.caliban.client.SelectionBuilder.Field("duplicate", Scalar())
    }

    type MessageNotHandled
    object MessageNotHandled {

        final case class MessageNotHandledView(
                                                  createTime: UnixTime,
                                                  topic: String,
                                                  notHandled: Boolean,
                                                  message: JSON
                                              )

        type ViewSelection =
            SelectionBuilder[MessageNotHandled, MessageNotHandledView]

        def view: ViewSelection = (createTime ~ topic ~ notHandled ~ message).map {
            case (createTime, topic, notHandled, message) =>
                MessageNotHandledView(createTime, topic, notHandled, message)
        }

        def createTime: SelectionBuilder[MessageNotHandled, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("createTime", Scalar())
        def topic: SelectionBuilder[MessageNotHandled, String] =
            _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
        def notHandled: SelectionBuilder[MessageNotHandled, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("notHandled", Scalar())
        def message: SelectionBuilder[MessageNotHandled, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("message", Scalar())
    }

    type MessageOk
    object MessageOk {

        final case class MessageOkView(
                                          createTime: UnixTime,
                                          startTime: UnixTime,
                                          finishTime: UnixTime,
                                          topic: String,
                                          result: scala.Option[String],
                                          deleted: Boolean,
                                          message: JSON
                                      )

        type ViewSelection = SelectionBuilder[MessageOk, MessageOkView]

        def view: ViewSelection =
            (createTime ~ startTime ~ finishTime ~ topic ~ result ~ deleted ~ message)
                .map {
                    case (
                        createTime,
                        startTime,
                        finishTime,
                        topic,
                        result,
                        deleted,
                        message
                        ) =>
                        MessageOkView(
                            createTime,
                            startTime,
                            finishTime,
                            topic,
                            result,
                            deleted,
                            message
                        )
                }

        def createTime: SelectionBuilder[MessageOk, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("createTime", Scalar())
        def startTime: SelectionBuilder[MessageOk, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("startTime", Scalar())
        def finishTime: SelectionBuilder[MessageOk, UnixTime] =
            _root_.caliban.client.SelectionBuilder.Field("finishTime", Scalar())
        def topic: SelectionBuilder[MessageOk, String] =
            _root_.caliban.client.SelectionBuilder.Field("topic", Scalar())
        def result: SelectionBuilder[MessageOk, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder.Field("result", OptionOf(Scalar()))
        def deleted: SelectionBuilder[MessageOk, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("deleted", Scalar())
        def message: SelectionBuilder[MessageOk, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("message", Scalar())
    }

    type MessageStatus
    object MessageStatus {

        final case class MessageStatusView[InfoSelection](
                                                             id: String,
                                                             info: InfoSelection
                                                         )

        type ViewSelection[InfoSelection] =
            SelectionBuilder[MessageStatus, MessageStatusView[InfoSelection]]

        def view[InfoSelection](
                                   infoSelectionOnMessageDuplicate: SelectionBuilder[
                                       MessageDuplicate,
                                       InfoSelection
                                   ],
                                   infoSelectionOnMessageFailed: SelectionBuilder[
                                       MessageFailed,
                                       InfoSelection
                                   ],
                                   infoSelectionOnMessageInProgress: SelectionBuilder[
                                       MessageInProgress,
                                       InfoSelection
                                   ],
                                   infoSelectionOnMessageNotHandled: SelectionBuilder[
                                       MessageNotHandled,
                                       InfoSelection
                                   ],
                                   infoSelectionOnMessageOk: SelectionBuilder[MessageOk, InfoSelection],
                                   infoSelectionOnMessageUnknown: SelectionBuilder[
                                       MessageUnknown,
                                       InfoSelection
                                   ]
                               ): ViewSelection[InfoSelection] = (id ~ info(
            infoSelectionOnMessageDuplicate,
            infoSelectionOnMessageFailed,
            infoSelectionOnMessageInProgress,
            infoSelectionOnMessageNotHandled,
            infoSelectionOnMessageOk,
            infoSelectionOnMessageUnknown
        )).map { case (id, info) => MessageStatusView(id, info) }

        def id: SelectionBuilder[MessageStatus, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def info[A](
                       onMessageDuplicate: SelectionBuilder[MessageDuplicate, A],
                       onMessageFailed: SelectionBuilder[MessageFailed, A],
                       onMessageInProgress: SelectionBuilder[MessageInProgress, A],
                       onMessageNotHandled: SelectionBuilder[MessageNotHandled, A],
                       onMessageOk: SelectionBuilder[MessageOk, A],
                       onMessageUnknown: SelectionBuilder[MessageUnknown, A]
                   ): SelectionBuilder[MessageStatus, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "info",
                ChoiceOf(
                    Map(
                        "MessageDuplicate" -> Obj(onMessageDuplicate),
                        "MessageFailed" -> Obj(onMessageFailed),
                        "MessageInProgress" -> Obj(onMessageInProgress),
                        "MessageNotHandled" -> Obj(onMessageNotHandled),
                        "MessageOk" -> Obj(onMessageOk),
                        "MessageUnknown" -> Obj(onMessageUnknown)
                    )
                )
            )
        def infoOption[A](
                             onMessageDuplicate: scala.Option[
                                 SelectionBuilder[MessageDuplicate, A]
                             ] = None,
                             onMessageFailed: scala.Option[SelectionBuilder[MessageFailed, A]] =
                             None,
                             onMessageInProgress: scala.Option[
                                 SelectionBuilder[MessageInProgress, A]
                             ] = None,
                             onMessageNotHandled: scala.Option[
                                 SelectionBuilder[MessageNotHandled, A]
                             ] = None,
                             onMessageOk: scala.Option[SelectionBuilder[MessageOk, A]] = None,
                             onMessageUnknown: scala.Option[SelectionBuilder[MessageUnknown, A]] =
                             None
                         ): SelectionBuilder[MessageStatus, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "info",
                ChoiceOf(
                    Map(
                        "MessageDuplicate" -> onMessageDuplicate
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            ),
                        "MessageFailed" -> onMessageFailed
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            ),
                        "MessageInProgress" -> onMessageInProgress
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            ),
                        "MessageNotHandled" -> onMessageNotHandled
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            ),
                        "MessageOk" -> onMessageOk.fold[FieldBuilder[scala.Option[A]]](
                            NullField
                        )(a => OptionOf(Obj(a))),
                        "MessageUnknown" -> onMessageUnknown
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            )
                    )
                )
            )
    }

    type MessageUnknown
    object MessageUnknown {

        final case class MessageUnknownView(unknown: Boolean)

        type ViewSelection = SelectionBuilder[MessageUnknown, MessageUnknownView]

        def view: ViewSelection =
            unknown.map(unknown => MessageUnknownView(unknown))

        def unknown: SelectionBuilder[MessageUnknown, Boolean] =
            _root_.caliban.client.SelectionBuilder.Field("unknown", Scalar())
    }

    type ParamsSchema
    object ParamsSchema {

        final case class ParamsSchemaView(
                                             schema: JSON,
                                             uiSchema: scala.Option[JSON]
                                         )

        type ViewSelection = SelectionBuilder[ParamsSchema, ParamsSchemaView]

        def view: ViewSelection = (schema ~ uiSchema).map {
            case (schema, uiSchema) => ParamsSchemaView(schema, uiSchema)
        }

        def schema: SelectionBuilder[ParamsSchema, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("schema", Scalar())
        def uiSchema: SelectionBuilder[ParamsSchema, scala.Option[JSON]] =
            _root_.caliban.client.SelectionBuilder
                .Field("uiSchema", OptionOf(Scalar()))
    }

    type PendingMessageList
    object PendingMessageList {

        final case class PendingMessageListView[MessagesSelection](
                                                                      messages: List[MessagesSelection],
                                                                      total: Int
                                                                  )

        type ViewSelection[MessagesSelection] =
            SelectionBuilder[PendingMessageList, PendingMessageListView[
                MessagesSelection
            ]]

        def view[MessagesSelection](
                                       messagesSelection: SelectionBuilder[
                                           PendingMessageStatus,
                                           MessagesSelection
                                       ]
                                   ): ViewSelection[MessagesSelection] =
            (messages(messagesSelection) ~ total).map { case (messages, total) =>
                PendingMessageListView(messages, total)
            }

        def messages[A](
                           innerSelection: SelectionBuilder[PendingMessageStatus, A]
                       ): SelectionBuilder[PendingMessageList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("messages", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[PendingMessageList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type PendingMessageStatus
    object PendingMessageStatus {

        final case class PendingMessageStatusView[InfoSelection](
                                                                    id: String,
                                                                    info: InfoSelection
                                                                )

        type ViewSelection[InfoSelection] =
            SelectionBuilder[PendingMessageStatus, PendingMessageStatusView[
                InfoSelection
            ]]

        def view[InfoSelection](
                                   infoSelectionOnMessageInProgress: SelectionBuilder[
                                       MessageInProgress,
                                       InfoSelection
                                   ],
                                   infoSelectionOnMessageNotHandled: SelectionBuilder[
                                       MessageNotHandled,
                                       InfoSelection
                                   ]
                               ): ViewSelection[InfoSelection] = (id ~ info(
            infoSelectionOnMessageInProgress,
            infoSelectionOnMessageNotHandled
        )).map { case (id, info) => PendingMessageStatusView(id, info) }

        def id: SelectionBuilder[PendingMessageStatus, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def info[A](
                       onMessageInProgress: SelectionBuilder[MessageInProgress, A],
                       onMessageNotHandled: SelectionBuilder[MessageNotHandled, A]
                   ): SelectionBuilder[PendingMessageStatus, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "info",
                ChoiceOf(
                    Map(
                        "MessageInProgress" -> Obj(onMessageInProgress),
                        "MessageNotHandled" -> Obj(onMessageNotHandled)
                    )
                )
            )
        def infoOption[A](
                             onMessageInProgress: scala.Option[
                                 SelectionBuilder[MessageInProgress, A]
                             ] = None,
                             onMessageNotHandled: scala.Option[
                                 SelectionBuilder[MessageNotHandled, A]
                             ] = None
                         ): SelectionBuilder[PendingMessageStatus, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "info",
                ChoiceOf(
                    Map(
                        "MessageInProgress" -> onMessageInProgress
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            ),
                        "MessageNotHandled" -> onMessageNotHandled
                            .fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
                                OptionOf(Obj(a))
                            )
                    )
                )
            )
    }

    type PeriodicJobMetrics
    object PeriodicJobMetrics {

        final case class PeriodicJobMetricsView[MetricsSelection](
                                                                     periodicJobId: String,
                                                                     metrics: MetricsSelection
                                                                 )

        type ViewSelection[MetricsSelection] =
            SelectionBuilder[PeriodicJobMetrics, PeriodicJobMetricsView[
                MetricsSelection
            ]]

        def view[MetricsSelection](
                                      metricsSelection: SelectionBuilder[MessageMetrics, MetricsSelection]
                                  ): ViewSelection[MetricsSelection] =
            (periodicJobId ~ metrics(metricsSelection)).map {
                case (periodicJobId, metrics) =>
                    PeriodicJobMetricsView(periodicJobId, metrics)
            }

        def periodicJobId: SelectionBuilder[PeriodicJobMetrics, String] =
            _root_.caliban.client.SelectionBuilder.Field("periodicJobId", Scalar())
        def metrics[A](
                          innerSelection: SelectionBuilder[MessageMetrics, A]
                      ): SelectionBuilder[PeriodicJobMetrics, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("metrics", Obj(innerSelection))
    }

    type PeriodicTaskMetrics
    object PeriodicTaskMetrics {

        final case class PeriodicTaskMetricsView[MetricsSelection](
                                                                      periodicTaskId: String,
                                                                      metrics: MetricsSelection
                                                                  )

        type ViewSelection[MetricsSelection] =
            SelectionBuilder[PeriodicTaskMetrics, PeriodicTaskMetricsView[
                MetricsSelection
            ]]

        def view[MetricsSelection](
                                      metricsSelection: SelectionBuilder[MessageMetrics, MetricsSelection]
                                  ): ViewSelection[MetricsSelection] =
            (periodicTaskId ~ metrics(metricsSelection)).map {
                case (periodicTaskId, metrics) =>
                    PeriodicTaskMetricsView(periodicTaskId, metrics)
            }

        def periodicTaskId: SelectionBuilder[PeriodicTaskMetrics, String] =
            _root_.caliban.client.SelectionBuilder.Field("periodicTaskId", Scalar())
        def metrics[A](
                          innerSelection: SelectionBuilder[MessageMetrics, A]
                      ): SelectionBuilder[PeriodicTaskMetrics, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("metrics", Obj(innerSelection))
    }

    type PipelineConfig
    object PipelineConfig {

        final case class PipelineConfigView[
            TransformsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             id: String,
             description: String,
             transforms: List[TransformsSelection],
             transformCount: Int,
             usedInTopics: Int,
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            TransformsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[PipelineConfig, PipelineConfigView[
            TransformsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[TransformsSelection, CreatorSelection, LastUpdaterSelection](
                                                                                 transformsSelection: SelectionBuilder[
                                                                                     PipelineTransformSetup,
                                                                                     TransformsSelection
                                                                                 ],
                                                                                 creatorSelection: SelectionBuilder[User, CreatorSelection],
                                                                                 lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
                                                                             ): ViewSelection[
            TransformsSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = (id ~ description ~ transforms(
            transformsSelection
        ) ~ transformCount ~ usedInTopics ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
            creatorSelection
        ) ~ lastUpdater(lastUpdaterSelection)).map {
            case (
                id,
                description,
                transforms,
                transformCount,
                usedInTopics,
                systemRegistrationDate,
                systemUpdateDate,
                creator,
                lastUpdater
                ) =>
                PipelineConfigView(
                    id,
                    description,
                    transforms,
                    transformCount,
                    usedInTopics,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                )
        }

        def id: SelectionBuilder[PipelineConfig, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def description: SelectionBuilder[PipelineConfig, String] =
            _root_.caliban.client.SelectionBuilder.Field("description", Scalar())
        def transforms[A](
                             innerSelection: SelectionBuilder[PipelineTransformSetup, A]
                         ): SelectionBuilder[PipelineConfig, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("transforms", ListOf(Obj(innerSelection)))
        def transformCount: SelectionBuilder[PipelineConfig, Int] =
            _root_.caliban.client.SelectionBuilder.Field("transformCount", Scalar())
        def usedInTopics: SelectionBuilder[PipelineConfig, Int] =
            _root_.caliban.client.SelectionBuilder.Field("usedInTopics", Scalar())
        def systemRegistrationDate: SelectionBuilder[PipelineConfig, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate
        : SelectionBuilder[PipelineConfig, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[PipelineConfig, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[PipelineConfig, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type PipelineConfigList
    object PipelineConfigList {

        final case class PipelineConfigListView[PipelineConfigsSelection](
                                                                             pipelineConfigs: List[PipelineConfigsSelection],
                                                                             total: Int
                                                                         )

        type ViewSelection[PipelineConfigsSelection] =
            SelectionBuilder[PipelineConfigList, PipelineConfigListView[
                PipelineConfigsSelection
            ]]

        def view[PipelineConfigsSelection](
                                              pipelineConfigsSelection: SelectionBuilder[
                                                  PipelineConfig,
                                                  PipelineConfigsSelection
                                              ]
                                          ): ViewSelection[PipelineConfigsSelection] =
            (pipelineConfigs(pipelineConfigsSelection) ~ total).map {
                case (pipelineConfigs, total) =>
                    PipelineConfigListView(pipelineConfigs, total)
            }

        def pipelineConfigs[A](
                                  innerSelection: SelectionBuilder[PipelineConfig, A]
                              ): SelectionBuilder[PipelineConfigList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("pipelineConfigs", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[PipelineConfigList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type PipelineSetup
    object PipelineSetup {

        final case class PipelineSetupView[PipelineConfigSelection](
                                                                       pipelineConfig: PipelineConfigSelection
                                                                   )

        type ViewSelection[PipelineConfigSelection] =
            SelectionBuilder[PipelineSetup, PipelineSetupView[
                PipelineConfigSelection
            ]]

        def view[PipelineConfigSelection](
                                             pipelineConfigSelection: SelectionBuilder[
                                                 PipelineConfig,
                                                 PipelineConfigSelection
                                             ]
                                         ): ViewSelection[PipelineConfigSelection] = pipelineConfig(
            pipelineConfigSelection
        ).map(pipelineConfig => PipelineSetupView(pipelineConfig))

        def pipelineConfig[A](
                                 innerSelection: SelectionBuilder[PipelineConfig, A]
                             ): SelectionBuilder[PipelineSetup, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("pipelineConfig", Obj(innerSelection))
    }

    type PipelineTransform
    object PipelineTransform {

        final case class PipelineTransformView[ParamsSchemaSelection](
                                                                         id: String,
                                                                         description: String,
                                                                         inType: String,
                                                                         outType: String,
                                                                         paramsSchema: ParamsSchemaSelection,
                                                                         version: scala.Option[String]
                                                                     )

        type ViewSelection[ParamsSchemaSelection] =
            SelectionBuilder[PipelineTransform, PipelineTransformView[
                ParamsSchemaSelection
            ]]

        def view[ParamsSchemaSelection](
                                           paramsSchemaSelection: SelectionBuilder[
                                               ParamsSchema,
                                               ParamsSchemaSelection
                                           ]
                                       ): ViewSelection[ParamsSchemaSelection] =
            (id ~ description ~ inType ~ outType ~ paramsSchema(
                paramsSchemaSelection
            ) ~ version).map {
                case (id, description, inType, outType, paramsSchema, version) =>
                    PipelineTransformView(
                        id,
                        description,
                        inType,
                        outType,
                        paramsSchema,
                        version
                    )
            }

        def id: SelectionBuilder[PipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def description: SelectionBuilder[PipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("description", Scalar())
        def inType: SelectionBuilder[PipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("inType", Scalar())
        def outType: SelectionBuilder[PipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("outType", Scalar())
        def paramsSchema[A](
                               innerSelection: SelectionBuilder[ParamsSchema, A]
                           ): SelectionBuilder[PipelineTransform, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("paramsSchema", Obj(innerSelection))
        def version: SelectionBuilder[PipelineTransform, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("version", OptionOf(Scalar()))
    }

    type PipelineTransformList
    object PipelineTransformList {

        final case class PipelineTransformListView[TransformsSelection](
                                                                           transforms: List[TransformsSelection],
                                                                           total: Int
                                                                       )

        type ViewSelection[TransformsSelection] =
            SelectionBuilder[PipelineTransformList, PipelineTransformListView[
                TransformsSelection
            ]]

        def view[TransformsSelection](
                                         transformsSelection: SelectionBuilder[
                                             PipelineTransform,
                                             TransformsSelection
                                         ]
                                     ): ViewSelection[TransformsSelection] =
            (transforms(transformsSelection) ~ total).map {
                case (transforms, total) => PipelineTransformListView(transforms, total)
            }

        def transforms[A](
                             innerSelection: SelectionBuilder[PipelineTransform, A]
                         ): SelectionBuilder[PipelineTransformList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("transforms", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[PipelineTransformList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type PipelineTransformSetup
    object PipelineTransformSetup {

        final case class PipelineTransformSetupView[TransformSelection](
                                                                           id: String,
                                                                           params: JSON,
                                                                           transform: TransformSelection
                                                                       )

        type ViewSelection[TransformSelection] =
            SelectionBuilder[PipelineTransformSetup, PipelineTransformSetupView[
                TransformSelection
            ]]

        def view[TransformSelection](
                                        transformSelection: SelectionBuilder[
                                            PipelineTransform,
                                            TransformSelection
                                        ]
                                    ): ViewSelection[TransformSelection] =
            (id ~ params ~ transform(transformSelection)).map {
                case (id, params, transform) =>
                    PipelineTransformSetupView(id, params, transform)
            }

        def id: SelectionBuilder[PipelineTransformSetup, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

        /** JSON as string
         */
        def params: SelectionBuilder[PipelineTransformSetup, JSON] =
            _root_.caliban.client.SelectionBuilder.Field("params", Scalar())
        def transform[A](
                            innerSelection: SelectionBuilder[PipelineTransform, A]
                        ): SelectionBuilder[PipelineTransformSetup, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("transform", Obj(innerSelection))
    }

    type ServiceStats
    object ServiceStats {

        final case class ServiceStatsView(
                                             name: String,
                                             duration: Double,
                                             load: Double,
                                             okRequests: Int,
                                             failedRequests: Int
                                         )

        type ViewSelection = SelectionBuilder[ServiceStats, ServiceStatsView]

        def view: ViewSelection =
            (name ~ duration ~ load ~ okRequests ~ failedRequests).map {
                case (name, duration, load, okRequests, failedRequests) =>
                    ServiceStatsView(name, duration, load, okRequests, failedRequests)
            }

        def name: SelectionBuilder[ServiceStats, String] =
            _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

        /** duration in seconds
         */
        def duration: SelectionBuilder[ServiceStats, Double] =
            _root_.caliban.client.SelectionBuilder.Field("duration", Scalar())

        /** total load in seconds for the duration
         */
        def load: SelectionBuilder[ServiceStats, Double] =
            _root_.caliban.client.SelectionBuilder.Field("load", Scalar())
        def okRequests: SelectionBuilder[ServiceStats, Int] =
            _root_.caliban.client.SelectionBuilder.Field("okRequests", Scalar())
        def failedRequests: SelectionBuilder[ServiceStats, Int] =
            _root_.caliban.client.SelectionBuilder.Field("failedRequests", Scalar())
    }

    type TaskMetrics
    object TaskMetrics {

        final case class TaskMetricsView[MetricsSelection](
                                                              taskId: String,
                                                              metrics: MetricsSelection
                                                          )

        type ViewSelection[MetricsSelection] =
            SelectionBuilder[TaskMetrics, TaskMetricsView[MetricsSelection]]

        def view[MetricsSelection](
                                      metricsSelection: SelectionBuilder[MessageMetrics, MetricsSelection]
                                  ): ViewSelection[MetricsSelection] =
            (taskId ~ metrics(metricsSelection)).map { case (taskId, metrics) =>
                TaskMetricsView(taskId, metrics)
            }

        def taskId: SelectionBuilder[TaskMetrics, String] =
            _root_.caliban.client.SelectionBuilder.Field("taskId", Scalar())
        def metrics[A](
                          innerSelection: SelectionBuilder[MessageMetrics, A]
                      ): SelectionBuilder[TaskMetrics, A] = _root_.caliban.client.SelectionBuilder
            .Field("metrics", Obj(innerSelection))
    }

    type User
    object User {

        final case class UserView(id: String)

        type ViewSelection = SelectionBuilder[User, UserView]

        def view: ViewSelection = id.map(id => UserView(id))

        def id: SelectionBuilder[User, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    }

    type UserPipelineTransform
    object UserPipelineTransform {

        final case class UserPipelineTransformView[
            ServiceSelection,
            CreatorSelection,
            LastUpdaterSelection
        ](
             id: String,
             description: scala.Option[String],
             inType: String,
             outType: String,
             usedInPipelineConfigs: Int,
             version: scala.Option[String],
             service: ServiceSelection,
             systemRegistrationDate: UnixTime,
             systemUpdateDate: scala.Option[UnixTime],
             creator: CreatorSelection,
             lastUpdater: scala.Option[LastUpdaterSelection]
         )

        type ViewSelection[
            ServiceSelection,
            CreatorSelection,
            LastUpdaterSelection
        ] = SelectionBuilder[UserPipelineTransform, UserPipelineTransformView[
            ServiceSelection,
            CreatorSelection,
            LastUpdaterSelection
        ]]

        def view[ServiceSelection, CreatorSelection, LastUpdaterSelection](
                                                                              serviceSelection: SelectionBuilder[UserService, ServiceSelection],
                                                                              creatorSelection: SelectionBuilder[User, CreatorSelection],
                                                                              lastUpdaterSelection: SelectionBuilder[User, LastUpdaterSelection]
                                                                          ): ViewSelection[ServiceSelection, CreatorSelection, LastUpdaterSelection] =
            (id ~ description ~ inType ~ outType ~ usedInPipelineConfigs ~ version ~ service(
                serviceSelection
            ) ~ systemRegistrationDate ~ systemUpdateDate ~ creator(
                creatorSelection
            ) ~ lastUpdater(lastUpdaterSelection)).map {
                case (
                    id,
                    description,
                    inType,
                    outType,
                    usedInPipelineConfigs,
                    version,
                    service,
                    systemRegistrationDate,
                    systemUpdateDate,
                    creator,
                    lastUpdater
                    ) =>
                    UserPipelineTransformView(
                        id,
                        description,
                        inType,
                        outType,
                        usedInPipelineConfigs,
                        version,
                        service,
                        systemRegistrationDate,
                        systemUpdateDate,
                        creator,
                        lastUpdater
                    )
            }

        def id: SelectionBuilder[UserPipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
        def description
        : SelectionBuilder[UserPipelineTransform, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("description", OptionOf(Scalar()))
        def inType: SelectionBuilder[UserPipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("inType", Scalar())
        def outType: SelectionBuilder[UserPipelineTransform, String] =
            _root_.caliban.client.SelectionBuilder.Field("outType", Scalar())
        def usedInPipelineConfigs: SelectionBuilder[UserPipelineTransform, Int] =
            _root_.caliban.client.SelectionBuilder
                .Field("usedInPipelineConfigs", Scalar())
        def version: SelectionBuilder[UserPipelineTransform, scala.Option[String]] =
            _root_.caliban.client.SelectionBuilder
                .Field("version", OptionOf(Scalar()))
        def service[A](
                          innerSelection: SelectionBuilder[UserService, A]
                      ): SelectionBuilder[UserPipelineTransform, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("service", Obj(innerSelection))
        def systemRegistrationDate
        : SelectionBuilder[UserPipelineTransform, UnixTime] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemRegistrationDate", Scalar())
        def systemUpdateDate
        : SelectionBuilder[UserPipelineTransform, scala.Option[UnixTime]] =
            _root_.caliban.client.SelectionBuilder
                .Field("systemUpdateDate", OptionOf(Scalar()))
        def creator[A](
                          innerSelection: SelectionBuilder[User, A]
                      ): SelectionBuilder[UserPipelineTransform, A] =
            _root_.caliban.client.SelectionBuilder
                .Field("creator", Obj(innerSelection))
        def lastUpdater[A](
                              innerSelection: SelectionBuilder[User, A]
                          ): SelectionBuilder[UserPipelineTransform, scala.Option[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("lastUpdater", OptionOf(Obj(innerSelection)))
    }

    type UserPipelineTransformList
    object UserPipelineTransformList {

        final case class UserPipelineTransformListView[TransformsSelection](
                                                                               transforms: List[TransformsSelection],
                                                                               total: Int
                                                                           )

        type ViewSelection[TransformsSelection] =
            SelectionBuilder[UserPipelineTransformList, UserPipelineTransformListView[
                TransformsSelection
            ]]

        def view[TransformsSelection](
                                         transformsSelection: SelectionBuilder[
                                             UserPipelineTransform,
                                             TransformsSelection
                                         ]
                                     ): ViewSelection[TransformsSelection] =
            (transforms(transformsSelection) ~ total).map {
                case (transforms, total) =>
                    UserPipelineTransformListView(transforms, total)
            }

        def transforms[A](
                             innerSelection: SelectionBuilder[UserPipelineTransform, A]
                         ): SelectionBuilder[UserPipelineTransformList, List[A]] =
            _root_.caliban.client.SelectionBuilder
                .Field("transforms", ListOf(Obj(innerSelection)))
        def total: SelectionBuilder[UserPipelineTransformList, Int] =
            _root_.caliban.client.SelectionBuilder.Field("total", Scalar())
    }

    type UserService
    object UserService {

        final case class UserServiceView[EnvironmentSelection](
                                                                  memLimit: scala.Option[Int],
                                                                  memRequest: scala.Option[Int],
                                                                  cpuLimit: scala.Option[Int],
                                                                  cpuRequest: scala.Option[Int],
                                                                  maxPods: Int,
                                                                  state: UserServiceState,
                                                                  environment: scala.Option[List[EnvironmentSelection]]
                                                              )

        type ViewSelection[EnvironmentSelection] =
            SelectionBuilder[UserService, UserServiceView[EnvironmentSelection]]

        def view[EnvironmentSelection](
                                          environmentSelection: SelectionBuilder[
                                              UserServiceEnvironmentVariable,
                                              EnvironmentSelection
                                          ]
                                      ): ViewSelection[EnvironmentSelection] =
            (memLimit ~ memRequest ~ cpuLimit ~ cpuRequest ~ maxPods ~ state ~ environment(
                environmentSelection
            )).map {
                case (
                    memLimit,
                    memRequest,
                    cpuLimit,
                    cpuRequest,
                    maxPods,
                    state,
                    environment
                    ) =>
                    UserServiceView(
                        memLimit,
                        memRequest,
                        cpuLimit,
                        cpuRequest,
                        maxPods,
                        state,
                        environment
                    )
            }

        /** memory limit in MB
         */
        def memLimit: SelectionBuilder[UserService, scala.Option[Int]] =
            _root_.caliban.client.SelectionBuilder
                .Field("memLimit", OptionOf(Scalar()))

        /** memory request in MB
         */
        def memRequest: SelectionBuilder[UserService, scala.Option[Int]] =
            _root_.caliban.client.SelectionBuilder
                .Field("memRequest", OptionOf(Scalar()))

        /** cpu limit in millicores
         */
        def cpuLimit: SelectionBuilder[UserService, scala.Option[Int]] =
            _root_.caliban.client.SelectionBuilder
                .Field("cpuLimit", OptionOf(Scalar()))

        /** cpu request in millicores
         */
        def cpuRequest: SelectionBuilder[UserService, scala.Option[Int]] =
            _root_.caliban.client.SelectionBuilder
                .Field("cpuRequest", OptionOf(Scalar()))
        def maxPods: SelectionBuilder[UserService, Int] =
            _root_.caliban.client.SelectionBuilder.Field("maxPods", Scalar())
        def state: SelectionBuilder[UserService, UserServiceState] =
            _root_.caliban.client.SelectionBuilder.Field("state", Scalar())
        def environment[A](
                              innerSelection: SelectionBuilder[UserServiceEnvironmentVariable, A]
                          ): SelectionBuilder[UserService, scala.Option[List[A]]] =
            _root_.caliban.client.SelectionBuilder
                .Field("environment", OptionOf(ListOf(Obj(innerSelection))))
    }

    type UserServiceEnvironmentVariable
    object UserServiceEnvironmentVariable {

        final case class UserServiceEnvironmentVariableView(
                                                               name: String,
                                                               value: String
                                                           )

        type ViewSelection = SelectionBuilder[
            UserServiceEnvironmentVariable,
            UserServiceEnvironmentVariableView
        ]

        def view: ViewSelection = (name ~ value).map { case (name, value) =>
            UserServiceEnvironmentVariableView(name, value)
        }

        def name: SelectionBuilder[UserServiceEnvironmentVariable, String] =
            _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
        def value: SelectionBuilder[UserServiceEnvironmentVariable, String] =
            _root_.caliban.client.SelectionBuilder.Field("value", Scalar())
    }

    final case class ConceptTransformConfigFilter(
                                                     systemRegistrationDate: scala.Option[TimestampInterval] = None,
                                                     systemUpdateDate: scala.Option[TimestampInterval] = None,
                                                     creatorId: scala.Option[String] = None,
                                                     lastUpdaterId: scala.Option[String] = None,
                                                     description: scala.Option[String] = None,
                                                     canTransformOneEntity: scala.Option[Boolean] = None,
                                                     canTransformMultipleEntities: scala.Option[Boolean] = None,
                                                     canTransformConceptTypeIds: scala.Option[List[String]] = None,
                                                     canBeUsed: scala.Option[Boolean] = None
                                                 )
    object ConceptTransformConfigFilter {
        implicit val encoder: ArgEncoder[ConceptTransformConfigFilter] =
            new ArgEncoder[ConceptTransformConfigFilter] {
                override def encode(value: ConceptTransformConfigFilter): __Value =
                    __ObjectValue(
                        List(
                            "systemRegistrationDate" -> value.systemRegistrationDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "systemUpdateDate" -> value.systemUpdateDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "creatorId" -> value.creatorId.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "lastUpdaterId" -> value.lastUpdaterId.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "description" -> value.description.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "canTransformOneEntity" -> value.canTransformOneEntity.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
                            "canTransformMultipleEntities" -> value.canTransformMultipleEntities
                                .fold(__NullValue: __Value)(value =>
                                    implicitly[ArgEncoder[Boolean]].encode(value)
                                ),
                            "canTransformConceptTypeIds" -> value.canTransformConceptTypeIds
                                .fold(__NullValue: __Value)(value =>
                                    __ListValue(
                                        value.map(value =>
                                            implicitly[ArgEncoder[String]].encode(value)
                                        )
                                    )
                                ),
                            "canBeUsed" -> value.canBeUsed.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[Boolean]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class ConceptTransformConfigInput(
                                                    title: String,
                                                    description: scala.Option[String] = None,
                                                    conceptTypeIds: scala.Option[List[String]] = None,
                                                    canTransformOneEntity: Boolean,
                                                    canTransformMultipleEntities: Boolean,
                                                    priority: scala.Option[Int] = None
                                                )
    object ConceptTransformConfigInput {
        implicit val encoder: ArgEncoder[ConceptTransformConfigInput] =
            new ArgEncoder[ConceptTransformConfigInput] {
                override def encode(value: ConceptTransformConfigInput): __Value =
                    __ObjectValue(
                        List(
                            "title" -> implicitly[ArgEncoder[String]].encode(value.title),
                            "description" -> value.description.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
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
                            "canTransformOneEntity" -> implicitly[ArgEncoder[Boolean]]
                                .encode(value.canTransformOneEntity),
                            "canTransformMultipleEntities" -> implicitly[ArgEncoder[Boolean]]
                                .encode(value.canTransformMultipleEntities),
                            "priority" -> value.priority.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[Int]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class ConceptTransformTaskFilter(
                                                   config: scala.Option[String] = None,
                                                   creatorId: scala.Option[String] = None,
                                                   state: scala.Option[ConceptTransformTaskState] = None,
                                                   id: scala.Option[String] = None,
                                                   systemRegistrationDate: scala.Option[TimestampInterval] = None
                                               )
    object ConceptTransformTaskFilter {
        implicit val encoder: ArgEncoder[ConceptTransformTaskFilter] =
            new ArgEncoder[ConceptTransformTaskFilter] {
                override def encode(value: ConceptTransformTaskFilter): __Value =
                    __ObjectValue(
                        List(
                            "config" -> value.config.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "creatorId" -> value.creatorId.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "state" -> value.state.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[ConceptTransformTaskState]].encode(value)
                            ),
                            "id" -> value.id.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "systemRegistrationDate" -> value.systemRegistrationDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class ConceptTransformTaskInput(
                                                  config: String,
                                                  conceptIds: List[String] = Nil
                                              )
    object ConceptTransformTaskInput {
        implicit val encoder: ArgEncoder[ConceptTransformTaskInput] =
            new ArgEncoder[ConceptTransformTaskInput] {
                override def encode(value: ConceptTransformTaskInput): __Value =
                    __ObjectValue(
                        List(
                            "config" -> implicitly[ArgEncoder[String]].encode(value.config),
                            "conceptIds" -> __ListValue(
                                value.conceptIds.map(value =>
                                    implicitly[ArgEncoder[String]].encode(value)
                                )
                            )
                        )
                    )
            }
    }
    final case class ExportEntityInput(`type`: ExportEntityType, id: String)
    object ExportEntityInput {
        implicit val encoder: ArgEncoder[ExportEntityInput] =
            new ArgEncoder[ExportEntityInput] {
                override def encode(value: ExportEntityInput): __Value =
                    __ObjectValue(
                        List(
                            "type" -> implicitly[ArgEncoder[ExportEntityType]]
                                .encode(value.`type`),
                            "id" -> implicitly[ArgEncoder[String]].encode(value.id)
                        )
                    )
            }
    }
    final case class ExporterFilter(
                                       canExportDocument: scala.Option[Boolean] = None,
                                       canExportConcept: scala.Option[Boolean] = None,
                                       canExportOneEntity: scala.Option[Boolean] = None,
                                       canExportMultipleEntities: scala.Option[Boolean] = None,
                                       canExportConceptTypeIds: scala.Option[List[String]] = None
                                   )
    object ExporterFilter {
        implicit val encoder: ArgEncoder[ExporterFilter] =
            new ArgEncoder[ExporterFilter] {
                override def encode(value: ExporterFilter): __Value =
                    __ObjectValue(
                        List(
                            "canExportDocument" -> value.canExportDocument.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
                            "canExportConcept" -> value.canExportConcept.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
                            "canExportOneEntity" -> value.canExportOneEntity.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
                            "canExportMultipleEntities" -> value.canExportMultipleEntities
                                .fold(__NullValue: __Value)(value =>
                                    implicitly[ArgEncoder[Boolean]].encode(value)
                                ),
                            "canExportConceptTypeIds" -> value.canExportConceptTypeIds.fold(
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
    final case class ExporterInput(
                                      menuTitle: String,
                                      description: String,
                                      defaultParams: scala.Option[JSON] = None,
                                      canExportOneEntity: Boolean,
                                      canExportMultipleEntities: Boolean,
                                      conceptTypeIds: scala.Option[List[String]] = None
                                  )
    object ExporterInput {
        implicit val encoder: ArgEncoder[ExporterInput] =
            new ArgEncoder[ExporterInput] {
                override def encode(value: ExporterInput): __Value =
                    __ObjectValue(
                        List(
                            "menuTitle" -> implicitly[ArgEncoder[String]]
                                .encode(value.menuTitle),
                            "description" -> implicitly[ArgEncoder[String]]
                                .encode(value.description),
                            "defaultParams" -> value.defaultParams.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[JSON]].encode(value)
                            ),
                            "canExportOneEntity" -> implicitly[ArgEncoder[Boolean]]
                                .encode(value.canExportOneEntity),
                            "canExportMultipleEntities" -> implicitly[ArgEncoder[Boolean]]
                                .encode(value.canExportMultipleEntities),
                            "conceptTypeIds" -> value.conceptTypeIds.fold(
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
    final case class ExportTaskFilter(
                                         exporter: scala.Option[String] = None,
                                         creatorId: scala.Option[String] = None,
                                         state: scala.Option[ExportTaskState] = None,
                                         id: scala.Option[String] = None,
                                         systemRegistrationDate: scala.Option[TimestampInterval] = None
                                     )
    object ExportTaskFilter {
        implicit val encoder: ArgEncoder[ExportTaskFilter] =
            new ArgEncoder[ExportTaskFilter] {
                override def encode(value: ExportTaskFilter): __Value =
                    __ObjectValue(
                        List(
                            "exporter" -> value.exporter.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "creatorId" -> value.creatorId.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "state" -> value.state.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[ExportTaskState]].encode(value)
                            ),
                            "id" -> value.id.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "systemRegistrationDate" -> value.systemRegistrationDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class ExportTaskInput(
                                        entities: List[ExportEntityInput] = Nil,
                                        params: JSON
                                    )
    object ExportTaskInput {
        implicit val encoder: ArgEncoder[ExportTaskInput] =
            new ArgEncoder[ExportTaskInput] {
                override def encode(value: ExportTaskInput): __Value =
                    __ObjectValue(
                        List(
                            "entities" -> __ListValue(
                                value.entities.map(value =>
                                    implicitly[ArgEncoder[ExportEntityInput]].encode(value)
                                )
                            ),
                            "params" -> implicitly[ArgEncoder[JSON]].encode(value.params)
                        )
                    )
            }
    }
    final case class ItemsFilter(
                                    inputText: scala.Option[String] = None,
                                    interval: scala.Option[TimestampInterval] = None,
                                    topic: scala.Option[String] = None
                                )
    object ItemsFilter {
        implicit val encoder: ArgEncoder[ItemsFilter] =
            new ArgEncoder[ItemsFilter] {
                override def encode(value: ItemsFilter): __Value =
                    __ObjectValue(
                        List(
                            "inputText" -> value.inputText.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "interval" -> value.interval.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "topic" -> value.topic.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class KafkaTopicFilter(
                                         name: scala.Option[String] = None,
                                         systemRegistrationDate: scala.Option[TimestampInterval] = None,
                                         systemUpdateDate: scala.Option[TimestampInterval] = None,
                                         creatorId: scala.Option[String] = None,
                                         lastUpdaterId: scala.Option[String] = None,
                                         description: scala.Option[String] = None,
                                         pipelineConfig: scala.Option[String] = None,
                                         pipelineConfigDescription: scala.Option[String] = None
                                     )
    object KafkaTopicFilter {
        implicit val encoder: ArgEncoder[KafkaTopicFilter] =
            new ArgEncoder[KafkaTopicFilter] {
                override def encode(value: KafkaTopicFilter): __Value =
                    __ObjectValue(
                        List(
                            "name" -> value.name.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "systemRegistrationDate" -> value.systemRegistrationDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "systemUpdateDate" -> value.systemUpdateDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "creatorId" -> value.creatorId.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "lastUpdaterId" -> value.lastUpdaterId.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "description" -> value.description.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "pipelineConfig" -> value.pipelineConfig.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[String]].encode(value)),
                            "pipelineConfigDescription" -> value.pipelineConfigDescription
                                .fold(__NullValue: __Value)(value =>
                                    implicitly[ArgEncoder[String]].encode(value)
                                )
                        )
                    )
            }
    }
    final case class KafkaTopicUpdate(
                                         description: scala.Option[String] = None,
                                         clearDescription: scala.Option[Boolean] = None,
                                         pipeline: scala.Option[PipelineSetupInput] = None,
                                         clearPipeline: scala.Option[Boolean] = None,
                                         priority: scala.Option[Int] = None,
                                         requestTimeoutMs: scala.Option[Int] = None,
                                         clearRequestTimeoutMs: scala.Option[Boolean] = None,
                                         moveToOnTimeout: scala.Option[String] = None,
                                         clearMoveToOnTimeout: scala.Option[Boolean] = None
                                     )
    object KafkaTopicUpdate {
        implicit val encoder: ArgEncoder[KafkaTopicUpdate] =
            new ArgEncoder[KafkaTopicUpdate] {
                override def encode(value: KafkaTopicUpdate): __Value =
                    __ObjectValue(
                        List(
                            "description" -> value.description.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "clearDescription" -> value.clearDescription.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
                            "pipeline" -> value.pipeline.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[PipelineSetupInput]].encode(value)
                            ),
                            "clearPipeline" -> value.clearPipeline.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[Boolean]].encode(value)
                            ),
                            "priority" -> value.priority.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[Int]].encode(value)
                            ),
                            "requestTimeoutMs" -> value.requestTimeoutMs.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Int]].encode(value)),
                            "clearRequestTimeoutMs" -> value.clearRequestTimeoutMs.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
                            "moveToOnTimeout" -> value.moveToOnTimeout.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[String]].encode(value)),
                            "clearMoveToOnTimeout" -> value.clearMoveToOnTimeout.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[Boolean]].encode(value))
                        )
                    )
            }
    }
    final case class MessageFilter(
                                      id: scala.Option[String] = None,
                                      inputText: scala.Option[String] = None,
                                      parentId: scala.Option[String] = None,
                                      parentOrSelfId: scala.Option[String] = None
                                  )
    object MessageFilter {
        implicit val encoder: ArgEncoder[MessageFilter] =
            new ArgEncoder[MessageFilter] {
                override def encode(value: MessageFilter): __Value =
                    __ObjectValue(
                        List(
                            "id" -> value.id.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "inputText" -> value.inputText.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "parentId" -> value.parentId.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "parentOrSelfId" -> value.parentOrSelfId.fold(
                                __NullValue: __Value
                            )(value => implicitly[ArgEncoder[String]].encode(value))
                        )
                    )
            }
    }
    final case class PipelineConfigFilter(
                                             inType: scala.Option[String] = None,
                                             systemRegistrationDate: scala.Option[TimestampInterval] = None,
                                             systemUpdateDate: scala.Option[TimestampInterval] = None,
                                             creatorId: scala.Option[String] = None,
                                             lastUpdaterId: scala.Option[String] = None,
                                             description: scala.Option[String] = None,
                                             hasTransform: scala.Option[String] = None,
                                             hasTransforms: scala.Option[List[String]] = None
                                         )
    object PipelineConfigFilter {
        implicit val encoder: ArgEncoder[PipelineConfigFilter] =
            new ArgEncoder[PipelineConfigFilter] {
                override def encode(value: PipelineConfigFilter): __Value =
                    __ObjectValue(
                        List(
                            "inType" -> value.inType.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "systemRegistrationDate" -> value.systemRegistrationDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "systemUpdateDate" -> value.systemUpdateDate.fold(
                                __NullValue: __Value
                            )(value =>
                                implicitly[ArgEncoder[TimestampInterval]].encode(value)
                            ),
                            "creatorId" -> value.creatorId.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "lastUpdaterId" -> value.lastUpdaterId.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "description" -> value.description.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "hasTransform" -> value.hasTransform.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[String]].encode(value)
                            ),
                            "hasTransforms" -> value.hasTransforms.fold(__NullValue: __Value)(
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
    final case class PipelineConfigInput(
                                            id: String,
                                            description: String,
                                            transforms: List[PipelineTransformSetupInput] = Nil
                                        )
    object PipelineConfigInput {
        implicit val encoder: ArgEncoder[PipelineConfigInput] =
            new ArgEncoder[PipelineConfigInput] {
                override def encode(value: PipelineConfigInput): __Value =
                    __ObjectValue(
                        List(
                            "id" -> implicitly[ArgEncoder[String]].encode(value.id),
                            "description" -> implicitly[ArgEncoder[String]]
                                .encode(value.description),
                            "transforms" -> __ListValue(
                                value.transforms.map(value =>
                                    implicitly[ArgEncoder[PipelineTransformSetupInput]].encode(
                                        value
                                    )
                                )
                            )
                        )
                    )
            }
    }
    final case class PipelineSetupInput(pipelineConfig: String)
    object PipelineSetupInput {
        implicit val encoder: ArgEncoder[PipelineSetupInput] =
            new ArgEncoder[PipelineSetupInput] {
                override def encode(value: PipelineSetupInput): __Value =
                    __ObjectValue(
                        List(
                            "pipelineConfig" -> implicitly[ArgEncoder[String]].encode(
                                value.pipelineConfig
                            )
                        )
                    )
            }
    }
    final case class PipelineTransformFilter(inType: scala.Option[String] = None)
    object PipelineTransformFilter {
        implicit val encoder: ArgEncoder[PipelineTransformFilter] =
            new ArgEncoder[PipelineTransformFilter] {
                override def encode(value: PipelineTransformFilter): __Value =
                    __ObjectValue(
                        List(
                            "inType" -> value.inType.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class PipelineTransformSetupInput(id: String, params: JSON)
    object PipelineTransformSetupInput {
        implicit val encoder: ArgEncoder[PipelineTransformSetupInput] =
            new ArgEncoder[PipelineTransformSetupInput] {
                override def encode(value: PipelineTransformSetupInput): __Value =
                    __ObjectValue(
                        List(
                            "id" -> implicitly[ArgEncoder[String]].encode(value.id),
                            "params" -> implicitly[ArgEncoder[JSON]].encode(value.params)
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
    final case class UserPipelineTransformFilter(
                                                    inType: scala.Option[String] = None
                                                )
    object UserPipelineTransformFilter {
        implicit val encoder: ArgEncoder[UserPipelineTransformFilter] =
            new ArgEncoder[UserPipelineTransformFilter] {
                override def encode(value: UserPipelineTransformFilter): __Value =
                    __ObjectValue(
                        List(
                            "inType" -> value.inType.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[String]].encode(value)
                            )
                        )
                    )
            }
    }
    final case class UserServiceEnvironmentVariableInput(
                                                            name: String,
                                                            value: String
                                                        )
    object UserServiceEnvironmentVariableInput {
        implicit val encoder: ArgEncoder[UserServiceEnvironmentVariableInput] =
            new ArgEncoder[UserServiceEnvironmentVariableInput] {
                override def encode(
                                       value: UserServiceEnvironmentVariableInput
                                   ): __Value =
                    __ObjectValue(
                        List(
                            "name" -> implicitly[ArgEncoder[String]].encode(value.name),
                            "value" -> implicitly[ArgEncoder[String]].encode(value.value)
                        )
                    )
            }
    }
    final case class UserServiceInput(
                                         memLimit: scala.Option[Int] = None,
                                         memRequest: scala.Option[Int] = None,
                                         cpuLimit: scala.Option[Int] = None,
                                         cpuRequest: scala.Option[Int] = None,
                                         maxPods: scala.Option[Int] = None,
                                         environment: scala.Option[List[UserServiceEnvironmentVariableInput]] =
                                         None
                                     )
    object UserServiceInput {
        implicit val encoder: ArgEncoder[UserServiceInput] =
            new ArgEncoder[UserServiceInput] {
                override def encode(value: UserServiceInput): __Value =
                    __ObjectValue(
                        List(
                            "memLimit" -> value.memLimit.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[Int]].encode(value)
                            ),
                            "memRequest" -> value.memRequest.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[Int]].encode(value)
                            ),
                            "cpuLimit" -> value.cpuLimit.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[Int]].encode(value)
                            ),
                            "cpuRequest" -> value.cpuRequest.fold(__NullValue: __Value)(
                                value => implicitly[ArgEncoder[Int]].encode(value)
                            ),
                            "maxPods" -> value.maxPods.fold(__NullValue: __Value)(value =>
                                implicitly[ArgEncoder[Int]].encode(value)
                            ),
                            "environment" -> value.environment.fold(__NullValue: __Value)(
                                value =>
                                    __ListValue(
                                        value.map(value =>
                                            implicitly[ArgEncoder[
                                                UserServiceEnvironmentVariableInput
                                            ]].encode(value)
                                        )
                                    )
                            )
                        )
                    )
            }
    }
    type Query = _root_.caliban.client.Operations.RootQuery
    object Query {
        def pipelineTransforms[A](
                                     offset: scala.Option[Int] = None,
                                     limit: scala.Option[Int] = None,
                                     filter: scala.Option[PipelineTransformFilter] = None
                                 )(innerSelection: SelectionBuilder[PipelineTransformList, A])(implicit
                                                                                               encoder0: ArgEncoder[scala.Option[Int]],
                                                                                               encoder1: ArgEncoder[scala.Option[Int]],
                                                                                               encoder2: ArgEncoder[scala.Option[PipelineTransformFilter]]
                                 ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "pipelineTransforms",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("filter", filter, "PipelineTransformFilter")(encoder2)
                )
            )
        def pipelineTransform[A](
                                    id: String
                                )(innerSelection: SelectionBuilder[PipelineTransform, A])(implicit
                                                                                          encoder0: ArgEncoder[String]
                                ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "pipelineTransform",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def pipelineConfigs[A](
                                  offset: scala.Option[Int] = None,
                                  limit: scala.Option[Int] = None,
                                  filter: scala.Option[PipelineConfigFilter] = None,
                                  sortBy: scala.Option[PipelineConfigSort] = None,
                                  sortDirection: scala.Option[SortDirection] = None
                              )(innerSelection: SelectionBuilder[PipelineConfigList, A])(implicit
                                                                                         encoder0: ArgEncoder[scala.Option[Int]],
                                                                                         encoder1: ArgEncoder[scala.Option[Int]],
                                                                                         encoder2: ArgEncoder[scala.Option[PipelineConfigFilter]],
                                                                                         encoder3: ArgEncoder[scala.Option[PipelineConfigSort]],
                                                                                         encoder4: ArgEncoder[scala.Option[SortDirection]]
                              ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "pipelineConfigs",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("filter", filter, "PipelineConfigFilter")(encoder2),
                    Argument("sortBy", sortBy, "PipelineConfigSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4)
                )
            )
        def pipelineConfig[A](
                                 id: String
                             )(innerSelection: SelectionBuilder[PipelineConfig, A])(implicit
                                                                                    encoder0: ArgEncoder[String]
                             ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "pipelineConfig",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def exportPipelineConfig(id: String)(implicit
                                             encoder0: ArgEncoder[String]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, JSON] =
            _root_.caliban.client.SelectionBuilder.Field(
                "exportPipelineConfig",
                Scalar(),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def kafkaPipelineStartType
        : SelectionBuilder[_root_.caliban.client.Operations.RootQuery, String] =
            _root_.caliban.client.SelectionBuilder
                .Field("kafkaPipelineStartType", Scalar())
        def kafkaTopics[A](
                              offset: scala.Option[Int] = None,
                              limit: scala.Option[Int] = None,
                              filter: scala.Option[KafkaTopicFilter] = None,
                              sortBy: scala.Option[KafkaTopicSort] = None,
                              sortDirection: scala.Option[SortDirection] = None
                          )(innerSelection: SelectionBuilder[KafkaTopicList, A])(implicit
                                                                                 encoder0: ArgEncoder[scala.Option[Int]],
                                                                                 encoder1: ArgEncoder[scala.Option[Int]],
                                                                                 encoder2: ArgEncoder[scala.Option[KafkaTopicFilter]],
                                                                                 encoder3: ArgEncoder[scala.Option[KafkaTopicSort]],
                                                                                 encoder4: ArgEncoder[scala.Option[SortDirection]]
                          ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "kafkaTopics",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("filter", filter, "KafkaTopicFilter")(encoder2),
                    Argument("sortBy", sortBy, "KafkaTopicSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4)
                )
            )
        def kafkaTopic[A](
                             topic: String
                         )(innerSelection: SelectionBuilder[KafkaTopic, A])(implicit
                                                                            encoder0: ArgEncoder[String]
                         ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "kafkaTopic",
                Obj(innerSelection),
                arguments = List(Argument("topic", topic, "ID!")(encoder0))
            )
        def messageStatus[A](
                                id: String
                            )(innerSelection: SelectionBuilder[MessageStatus, A])(implicit
                                                                                  encoder0: ArgEncoder[String]
                            ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "messageStatus",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def messageTopic(
                            id: String
                        )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
            _root_.caliban.client.Operations.RootQuery,
            scala.Option[String]
        ] = _root_.caliban.client.SelectionBuilder.Field(
            "messageTopic",
            OptionOf(Scalar()),
            arguments = List(Argument("id", id, "ID!")(encoder0))
        )
        def messageStatuses[A](
                                  ids: List[String] = Nil
                              )(innerSelection: SelectionBuilder[MessageStatus, A])(implicit
                                                                                    encoder0: ArgEncoder[List[String]]
                              ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "messageStatuses",
                ListOf(Obj(innerSelection)),
                arguments = List(Argument("ids", ids, "[ID!]!")(encoder0))
            )
        def failedMessages[A](
                                 topic: String,
                                 offset: scala.Option[Int] = None,
                                 limit: scala.Option[Int] = None,
                                 sortBy: scala.Option[MessageSort] = None,
                                 sortDirection: scala.Option[SortDirection] = None,
                                 filter: scala.Option[MessageFilter] = None
                             )(innerSelection: SelectionBuilder[FailedMessageList, A])(implicit
                                                                                       encoder0: ArgEncoder[String],
                                                                                       encoder1: ArgEncoder[scala.Option[Int]],
                                                                                       encoder2: ArgEncoder[scala.Option[Int]],
                                                                                       encoder3: ArgEncoder[scala.Option[MessageSort]],
                                                                                       encoder4: ArgEncoder[scala.Option[SortDirection]],
                                                                                       encoder5: ArgEncoder[scala.Option[MessageFilter]]
                             ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "failedMessages",
                Obj(innerSelection),
                arguments = List(
                    Argument("topic", topic, "ID!")(encoder0),
                    Argument("offset", offset, "Int")(encoder1),
                    Argument("limit", limit, "Int")(encoder2),
                    Argument("sortBy", sortBy, "MessageSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4),
                    Argument("filter", filter, "MessageFilter")(encoder5)
                )
            )
        def pendingMessages[A](
                                  topic: String,
                                  offset: scala.Option[Int] = None,
                                  limit: scala.Option[Int] = None,
                                  sortBy: scala.Option[ItemsSort] = None,
                                  sortDirection: scala.Option[SortDirection] = None,
                                  filter: scala.Option[MessageFilter] = None
                              )(innerSelection: SelectionBuilder[PendingMessageList, A])(implicit
                                                                                         encoder0: ArgEncoder[String],
                                                                                         encoder1: ArgEncoder[scala.Option[Int]],
                                                                                         encoder2: ArgEncoder[scala.Option[Int]],
                                                                                         encoder3: ArgEncoder[scala.Option[ItemsSort]],
                                                                                         encoder4: ArgEncoder[scala.Option[SortDirection]],
                                                                                         encoder5: ArgEncoder[scala.Option[MessageFilter]]
                              ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "pendingMessages",
                Obj(innerSelection),
                arguments = List(
                    Argument("topic", topic, "ID!")(encoder0),
                    Argument("offset", offset, "Int")(encoder1),
                    Argument("limit", limit, "Int")(encoder2),
                    Argument("sortBy", sortBy, "ItemsSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4),
                    Argument("filter", filter, "MessageFilter")(encoder5)
                )
            )
        def activeMessages[A](
                                 topic: scala.Option[String] = None,
                                 offset: scala.Option[Int] = None,
                                 limit: scala.Option[Int] = None,
                                 sortBy: scala.Option[ItemsSort] = None,
                                 sortDirection: scala.Option[SortDirection] = None,
                                 filter: scala.Option[MessageFilter] = None
                             )(innerSelection: SelectionBuilder[ActiveMessageList, A])(implicit
                                                                                       encoder0: ArgEncoder[scala.Option[String]],
                                                                                       encoder1: ArgEncoder[scala.Option[Int]],
                                                                                       encoder2: ArgEncoder[scala.Option[Int]],
                                                                                       encoder3: ArgEncoder[scala.Option[ItemsSort]],
                                                                                       encoder4: ArgEncoder[scala.Option[SortDirection]],
                                                                                       encoder5: ArgEncoder[scala.Option[MessageFilter]]
                             ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "activeMessages",
                Obj(innerSelection),
                arguments = List(
                    Argument("topic", topic, "ID")(encoder0),
                    Argument("offset", offset, "Int")(encoder1),
                    Argument("limit", limit, "Int")(encoder2),
                    Argument("sortBy", sortBy, "ItemsSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4),
                    Argument("filter", filter, "MessageFilter")(encoder5)
                )
            )
        def completedOkMessages[A](
                                      topic: String,
                                      offset: scala.Option[Int] = None,
                                      limit: scala.Option[Int] = None,
                                      sortBy: scala.Option[MessageSort] = None,
                                      sortDirection: scala.Option[SortDirection] = None,
                                      filter: scala.Option[MessageFilter] = None
                                  )(innerSelection: SelectionBuilder[CompletedOkMessageList, A])(implicit
                                                                                                 encoder0: ArgEncoder[String],
                                                                                                 encoder1: ArgEncoder[scala.Option[Int]],
                                                                                                 encoder2: ArgEncoder[scala.Option[Int]],
                                                                                                 encoder3: ArgEncoder[scala.Option[MessageSort]],
                                                                                                 encoder4: ArgEncoder[scala.Option[SortDirection]],
                                                                                                 encoder5: ArgEncoder[scala.Option[MessageFilter]]
                                  ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "completedOkMessages",
                Obj(innerSelection),
                arguments = List(
                    Argument("topic", topic, "ID!")(encoder0),
                    Argument("offset", offset, "Int")(encoder1),
                    Argument("limit", limit, "Int")(encoder2),
                    Argument("sortBy", sortBy, "MessageSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4),
                    Argument("filter", filter, "MessageFilter")(encoder5)
                )
            )
        def duplicateMessages[A](
                                    topic: String,
                                    offset: scala.Option[Int] = None,
                                    limit: scala.Option[Int] = None,
                                    sortBy: scala.Option[MessageSort] = None,
                                    sortDirection: scala.Option[SortDirection] = None,
                                    filter: scala.Option[MessageFilter] = None
                                )(innerSelection: SelectionBuilder[DuplicateMessageList, A])(implicit
                                                                                             encoder0: ArgEncoder[String],
                                                                                             encoder1: ArgEncoder[scala.Option[Int]],
                                                                                             encoder2: ArgEncoder[scala.Option[Int]],
                                                                                             encoder3: ArgEncoder[scala.Option[MessageSort]],
                                                                                             encoder4: ArgEncoder[scala.Option[SortDirection]],
                                                                                             encoder5: ArgEncoder[scala.Option[MessageFilter]]
                                ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "duplicateMessages",
                Obj(innerSelection),
                arguments = List(
                    Argument("topic", topic, "ID!")(encoder0),
                    Argument("offset", offset, "Int")(encoder1),
                    Argument("limit", limit, "Int")(encoder2),
                    Argument("sortBy", sortBy, "MessageSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4),
                    Argument("filter", filter, "MessageFilter")(encoder5)
                )
            )
        def messagesByParentId[A](
                                     parentId: String,
                                     offset: scala.Option[Int] = None,
                                     limit: scala.Option[Int] = None,
                                     sortBy: scala.Option[ItemsSort] = None,
                                     sortDirection: scala.Option[SortDirection] = None,
                                     filter: scala.Option[MessageFilter] = None
                                 )(innerSelection: SelectionBuilder[MessageList, A])(implicit
                                                                                     encoder0: ArgEncoder[String],
                                                                                     encoder1: ArgEncoder[scala.Option[Int]],
                                                                                     encoder2: ArgEncoder[scala.Option[Int]],
                                                                                     encoder3: ArgEncoder[scala.Option[ItemsSort]],
                                                                                     encoder4: ArgEncoder[scala.Option[SortDirection]],
                                                                                     encoder5: ArgEncoder[scala.Option[MessageFilter]]
                                 ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "messagesByParentId",
                Obj(innerSelection),
                arguments = List(
                    Argument("parentId", parentId, "ID!")(encoder0),
                    Argument("offset", offset, "Int")(encoder1),
                    Argument("limit", limit, "Int")(encoder2),
                    Argument("sortBy", sortBy, "ItemsSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4),
                    Argument("filter", filter, "MessageFilter")(encoder5)
                )
            )
        def exporter[A](id: String)(innerSelection: SelectionBuilder[Exporter, A])(
            implicit encoder0: ArgEncoder[String]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "exporter",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def exporters[A](
                            offset: scala.Option[Int] = None,
                            limit: scala.Option[Int] = None,
                            sortBy: scala.Option[ExporterSort] = None,
                            sortDirection: scala.Option[SortDirection] = None,
                            filter: scala.Option[ExporterFilter] = None
                        )(innerSelection: SelectionBuilder[ExporterList, A])(implicit
                                                                             encoder0: ArgEncoder[scala.Option[Int]],
                                                                             encoder1: ArgEncoder[scala.Option[Int]],
                                                                             encoder2: ArgEncoder[scala.Option[ExporterSort]],
                                                                             encoder3: ArgEncoder[scala.Option[SortDirection]],
                                                                             encoder4: ArgEncoder[scala.Option[ExporterFilter]]
                        ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "exporters",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("sortBy", sortBy, "ExporterSort")(encoder2),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
                    Argument("filter", filter, "ExporterFilter")(encoder4)
                )
            )
        def exportTask[A](
                             id: String
                         )(innerSelection: SelectionBuilder[ExportTask, A])(implicit
                                                                            encoder0: ArgEncoder[String]
                         ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "exportTask",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def exportTasks[A](
                              offset: scala.Option[Int] = None,
                              limit: scala.Option[Int] = None,
                              sortBy: scala.Option[ExportTaskSort] = None,
                              sortDirection: scala.Option[SortDirection] = None,
                              filter: scala.Option[ExportTaskFilter] = None
                          )(innerSelection: SelectionBuilder[ExportTaskList, A])(implicit
                                                                                 encoder0: ArgEncoder[scala.Option[Int]],
                                                                                 encoder1: ArgEncoder[scala.Option[Int]],
                                                                                 encoder2: ArgEncoder[scala.Option[ExportTaskSort]],
                                                                                 encoder3: ArgEncoder[scala.Option[SortDirection]],
                                                                                 encoder4: ArgEncoder[scala.Option[ExportTaskFilter]]
                          ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "exportTasks",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("sortBy", sortBy, "ExportTaskSort")(encoder2),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
                    Argument("filter", filter, "ExportTaskFilter")(encoder4)
                )
            )
        def jobItems2[A](
                            id: String,
                            itemsFilter: scala.Option[ItemsFilter] = None,
                            itemsSort: scala.Option[ItemsSort] = None,
                            limit: scala.Option[Int] = None,
                            offset: scala.Option[Int] = None,
                            sortDirection: scala.Option[SortDirection] = None
                        )(innerSelection: SelectionBuilder[ItemsList, A])(implicit
                                                                          encoder0: ArgEncoder[String],
                                                                          encoder1: ArgEncoder[scala.Option[ItemsFilter]],
                                                                          encoder2: ArgEncoder[scala.Option[ItemsSort]],
                                                                          encoder3: ArgEncoder[scala.Option[Int]],
                                                                          encoder4: ArgEncoder[scala.Option[Int]],
                                                                          encoder5: ArgEncoder[scala.Option[SortDirection]]
                        ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "jobItems2",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("itemsFilter", itemsFilter, "ItemsFilter")(encoder1),
                    Argument("itemsSort", itemsSort, "ItemsSort")(encoder2),
                    Argument("limit", limit, "Int")(encoder3),
                    Argument("offset", offset, "Int")(encoder4),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder5)
                )
            )
        def periodicJobItems2[A](
                                    id: String,
                                    itemsFilter: scala.Option[ItemsFilter] = None,
                                    itemsSort: scala.Option[ItemsSort] = None,
                                    limit: scala.Option[Int] = None,
                                    offset: scala.Option[Int] = None,
                                    sortDirection: scala.Option[SortDirection] = None
                                )(innerSelection: SelectionBuilder[ItemsList, A])(implicit
                                                                                  encoder0: ArgEncoder[String],
                                                                                  encoder1: ArgEncoder[scala.Option[ItemsFilter]],
                                                                                  encoder2: ArgEncoder[scala.Option[ItemsSort]],
                                                                                  encoder3: ArgEncoder[scala.Option[Int]],
                                                                                  encoder4: ArgEncoder[scala.Option[Int]],
                                                                                  encoder5: ArgEncoder[scala.Option[SortDirection]]
                                ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "periodicJobItems2",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("itemsFilter", itemsFilter, "ItemsFilter")(encoder1),
                    Argument("itemsSort", itemsSort, "ItemsSort")(encoder2),
                    Argument("limit", limit, "Int")(encoder3),
                    Argument("offset", offset, "Int")(encoder4),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder5)
                )
            )
        def taskItems2[A](
                             id: String,
                             itemsFilter: scala.Option[ItemsFilter] = None,
                             itemsSort: scala.Option[ItemsSort] = None,
                             limit: scala.Option[Int] = None,
                             offset: scala.Option[Int] = None,
                             sortDirection: scala.Option[SortDirection] = None
                         )(innerSelection: SelectionBuilder[ItemsList, A])(implicit
                                                                           encoder0: ArgEncoder[String],
                                                                           encoder1: ArgEncoder[scala.Option[ItemsFilter]],
                                                                           encoder2: ArgEncoder[scala.Option[ItemsSort]],
                                                                           encoder3: ArgEncoder[scala.Option[Int]],
                                                                           encoder4: ArgEncoder[scala.Option[Int]],
                                                                           encoder5: ArgEncoder[scala.Option[SortDirection]]
                         ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "taskItems2",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("itemsFilter", itemsFilter, "ItemsFilter")(encoder1),
                    Argument("itemsSort", itemsSort, "ItemsSort")(encoder2),
                    Argument("limit", limit, "Int")(encoder3),
                    Argument("offset", offset, "Int")(encoder4),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder5)
                )
            )
        def periodicTaskItems2[A](
                                     id: String,
                                     itemsFilter: scala.Option[ItemsFilter] = None,
                                     itemsSort: scala.Option[ItemsSort] = None,
                                     limit: scala.Option[Int] = None,
                                     offset: scala.Option[Int] = None,
                                     sortDirection: scala.Option[SortDirection] = None
                                 )(innerSelection: SelectionBuilder[ItemsList, A])(implicit
                                                                                   encoder0: ArgEncoder[String],
                                                                                   encoder1: ArgEncoder[scala.Option[ItemsFilter]],
                                                                                   encoder2: ArgEncoder[scala.Option[ItemsSort]],
                                                                                   encoder3: ArgEncoder[scala.Option[Int]],
                                                                                   encoder4: ArgEncoder[scala.Option[Int]],
                                                                                   encoder5: ArgEncoder[scala.Option[SortDirection]]
                                 ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "periodicTaskItems2",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("itemsFilter", itemsFilter, "ItemsFilter")(encoder1),
                    Argument("itemsSort", itemsSort, "ItemsSort")(encoder2),
                    Argument("limit", limit, "Int")(encoder3),
                    Argument("offset", offset, "Int")(encoder4),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder5)
                )
            )
        def jobIdsByMessageUUID2[A](messageUUID: String)(
            innerSelection: SelectionBuilder[JobIds, A]
        )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
            _root_.caliban.client.Operations.RootQuery,
            scala.Option[A]
        ] = _root_.caliban.client.SelectionBuilder.Field(
            "jobIdsByMessageUUID2",
            OptionOf(Obj(innerSelection)),
            arguments = List(Argument("messageUUID", messageUUID, "ID!")(encoder0))
        )
        def jobMetrics2[A](
                              jobIds: List[String] = Nil
                          )(innerSelection: SelectionBuilder[JobMetrics, A])(implicit
                                                                             encoder0: ArgEncoder[List[String]]
                          ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "jobMetrics2",
                ListOf(Obj(innerSelection)),
                arguments = List(Argument("jobIds", jobIds, "[ID!]!")(encoder0))
            )
        def periodicJobMetrics2[A](
                                      periodicJobIds: List[String] = Nil
                                  )(innerSelection: SelectionBuilder[PeriodicJobMetrics, A])(implicit
                                                                                             encoder0: ArgEncoder[List[String]]
                                  ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "periodicJobMetrics2",
                ListOf(Obj(innerSelection)),
                arguments =
                    List(Argument("periodicJobIds", periodicJobIds, "[ID!]!")(encoder0))
            )
        def taskMetrics2[A](
                               taskIds: List[String] = Nil
                           )(innerSelection: SelectionBuilder[TaskMetrics, A])(implicit
                                                                               encoder0: ArgEncoder[List[String]]
                           ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "taskMetrics2",
                ListOf(Obj(innerSelection)),
                arguments = List(Argument("taskIds", taskIds, "[ID!]!")(encoder0))
            )
        def periodicTaskMetrics2[A](
                                       periodicTaskIds: List[String] = Nil
                                   )(innerSelection: SelectionBuilder[PeriodicTaskMetrics, A])(implicit
                                                                                               encoder0: ArgEncoder[List[String]]
                                   ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
            _root_.caliban.client.SelectionBuilder.Field(
                "periodicTaskMetrics2",
                ListOf(Obj(innerSelection)),
                arguments =
                    List(Argument("periodicTaskIds", periodicTaskIds, "[ID!]!")(encoder0))
            )
        def conceptTransformConfigs[A](
                                          offset: scala.Option[Int] = None,
                                          limit: scala.Option[Int] = None,
                                          filter: scala.Option[ConceptTransformConfigFilter] = None,
                                          sortBy: scala.Option[ConceptTransformConfigSort] = None,
                                          sortDirection: scala.Option[SortDirection] = None
                                      )(innerSelection: SelectionBuilder[ConceptTransformConfigList, A])(implicit
                                                                                                         encoder0: ArgEncoder[scala.Option[Int]],
                                                                                                         encoder1: ArgEncoder[scala.Option[Int]],
                                                                                                         encoder2: ArgEncoder[scala.Option[ConceptTransformConfigFilter]],
                                                                                                         encoder3: ArgEncoder[scala.Option[ConceptTransformConfigSort]],
                                                                                                         encoder4: ArgEncoder[scala.Option[SortDirection]]
                                      ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "conceptTransformConfigs",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("filter", filter, "ConceptTransformConfigFilter")(encoder2),
                    Argument("sortBy", sortBy, "ConceptTransformConfigSort")(encoder3),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder4)
                )
            )
        def conceptTransformConfig[A](
                                         id: String
                                     )(innerSelection: SelectionBuilder[ConceptTransformConfig, A])(implicit
                                                                                                    encoder0: ArgEncoder[String]
                                     ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "conceptTransformConfig",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def conceptTransformMessageType
        : SelectionBuilder[_root_.caliban.client.Operations.RootQuery, String] =
            _root_.caliban.client.SelectionBuilder
                .Field("conceptTransformMessageType", Scalar())
        def conceptTransformTask[A](
                                       id: String
                                   )(innerSelection: SelectionBuilder[ConceptTransformTask, A])(implicit
                                                                                                encoder0: ArgEncoder[String]
                                   ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "conceptTransformTask",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def conceptTransformTasks[A](
                                        offset: scala.Option[Int] = None,
                                        limit: scala.Option[Int] = None,
                                        sortBy: scala.Option[ConceptTransformTaskSort] = None,
                                        sortDirection: scala.Option[SortDirection] = None,
                                        filter: scala.Option[ConceptTransformTaskFilter] = None
                                    )(innerSelection: SelectionBuilder[ConceptTransformTaskList, A])(implicit
                                                                                                     encoder0: ArgEncoder[scala.Option[Int]],
                                                                                                     encoder1: ArgEncoder[scala.Option[Int]],
                                                                                                     encoder2: ArgEncoder[scala.Option[ConceptTransformTaskSort]],
                                                                                                     encoder3: ArgEncoder[scala.Option[SortDirection]],
                                                                                                     encoder4: ArgEncoder[scala.Option[ConceptTransformTaskFilter]]
                                    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "conceptTransformTasks",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("sortBy", sortBy, "ConceptTransformTaskSort")(encoder2),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
                    Argument("filter", filter, "ConceptTransformTaskFilter")(encoder4)
                )
            )
        def userPipelineTransforms[A](
                                         offset: scala.Option[Int] = None,
                                         limit: scala.Option[Int] = None,
                                         sortBy: scala.Option[UserPipelineTransformSort] = None,
                                         sortDirection: scala.Option[SortDirection] = None,
                                         filter: scala.Option[UserPipelineTransformFilter] = None
                                     )(innerSelection: SelectionBuilder[UserPipelineTransformList, A])(implicit
                                                                                                       encoder0: ArgEncoder[scala.Option[Int]],
                                                                                                       encoder1: ArgEncoder[scala.Option[Int]],
                                                                                                       encoder2: ArgEncoder[scala.Option[UserPipelineTransformSort]],
                                                                                                       encoder3: ArgEncoder[scala.Option[SortDirection]],
                                                                                                       encoder4: ArgEncoder[scala.Option[UserPipelineTransformFilter]]
                                     ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "userPipelineTransforms",
                Obj(innerSelection),
                arguments = List(
                    Argument("offset", offset, "Int")(encoder0),
                    Argument("limit", limit, "Int")(encoder1),
                    Argument("sortBy", sortBy, "UserPipelineTransformSort")(encoder2),
                    Argument("sortDirection", sortDirection, "SortDirection")(encoder3),
                    Argument("filter", filter, "UserPipelineTransformFilter")(encoder4)
                )
            )
        def userPipelineTransform[A](
                                        id: String
                                    )(innerSelection: SelectionBuilder[UserPipelineTransform, A])(implicit
                                                                                                  encoder0: ArgEncoder[String]
                                    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "userPipelineTransform",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
    }

    type Mutation = _root_.caliban.client.Operations.RootMutation
    object Mutation {
        def addPipelineConfig[A](
                                    description: String,
                                    transforms: List[PipelineTransformSetupInput] = Nil
                                )(innerSelection: SelectionBuilder[PipelineConfig, A])(implicit
                                                                                       encoder0: ArgEncoder[String],
                                                                                       encoder1: ArgEncoder[List[PipelineTransformSetupInput]]
                                ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "addPipelineConfig",
                Obj(innerSelection),
                arguments = List(
                    Argument("description", description, "String!")(encoder0),
                    Argument("transforms", transforms, "[PipelineTransformSetupInput!]!")(
                        encoder1
                    )
                )
            )
        def copyPipelineConfig[A](
                                     sourceId: String,
                                     description: scala.Option[String] = None
                                 )(innerSelection: SelectionBuilder[PipelineConfig, A])(implicit
                                                                                        encoder0: ArgEncoder[String],
                                                                                        encoder1: ArgEncoder[scala.Option[String]]
                                 ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "copyPipelineConfig",
                Obj(innerSelection),
                arguments = List(
                    Argument("sourceId", sourceId, "ID!")(encoder0),
                    Argument("description", description, "String")(encoder1)
                )
            )
        def importPipelineConfig[A](
                                       `export`: Upload
                                   )(innerSelection: SelectionBuilder[PipelineConfig, A])(implicit
                                                                                          encoder0: ArgEncoder[Upload]
                                   ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "importPipelineConfig",
                Obj(innerSelection),
                arguments = List(Argument("export", `export`, "Upload!")(encoder0))
            )
        def updatePipelineConfig[A](
                                       pipelineConfig: PipelineConfigInput
                                   )(innerSelection: SelectionBuilder[PipelineConfig, A])(implicit
                                                                                          encoder0: ArgEncoder[PipelineConfigInput]
                                   ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "updatePipelineConfig",
                Obj(innerSelection),
                arguments = List(
                    Argument("pipelineConfig", pipelineConfig, "PipelineConfigInput!")(
                        encoder0
                    )
                )
            )
        def deletePipelineConfig[A](
                                       id: String
                                   )(innerSelection: SelectionBuilder[PipelineConfig, A])(implicit
                                                                                          encoder0: ArgEncoder[String]
                                   ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "deletePipelineConfig",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def putKafkaTopic[A](
                                topic: String,
                                description: scala.Option[String] = None,
                                pipeline: scala.Option[PipelineSetupInput] = None,
                                priority: scala.Option[Int] = None,
                                requestTimeoutMs: scala.Option[Int] = None,
                                moveToOnTimeout: scala.Option[String] = None
                            )(innerSelection: SelectionBuilder[KafkaTopic, A])(implicit
                                                                               encoder0: ArgEncoder[String],
                                                                               encoder1: ArgEncoder[scala.Option[String]],
                                                                               encoder2: ArgEncoder[scala.Option[PipelineSetupInput]],
                                                                               encoder3: ArgEncoder[scala.Option[Int]],
                                                                               encoder4: ArgEncoder[scala.Option[Int]],
                                                                               encoder5: ArgEncoder[scala.Option[String]]
                            ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "putKafkaTopic",
                Obj(innerSelection),
                arguments = List(
                    Argument("topic", topic, "ID!")(encoder0),
                    Argument("description", description, "String")(encoder1),
                    Argument("pipeline", pipeline, "PipelineSetupInput")(encoder2),
                    Argument("priority", priority, "Int")(encoder3),
                    Argument("requestTimeoutMs", requestTimeoutMs, "Int")(encoder4),
                    Argument("moveToOnTimeout", moveToOnTimeout, "String")(encoder5)
                )
            )
        def updateKafkaTopics(topics: List[String] = Nil, update: KafkaTopicUpdate)(
            implicit
            encoder0: ArgEncoder[List[String]],
            encoder1: ArgEncoder[KafkaTopicUpdate]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Int] =
            _root_.caliban.client.SelectionBuilder.Field(
                "updateKafkaTopics",
                Scalar(),
                arguments = List(
                    Argument("topics", topics, "[ID!]!")(encoder0),
                    Argument("update", update, "KafkaTopicUpdate!")(encoder1)
                )
            )
        def deleteKafkaTopic[A](
                                   topic: String
                               )(innerSelection: SelectionBuilder[KafkaTopic, A])(implicit
                                                                                  encoder0: ArgEncoder[String]
                               ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "deleteKafkaTopic",
                Obj(innerSelection),
                arguments = List(Argument("topic", topic, "ID!")(encoder0))
            )
        def retryFailedInTopic(topic: String)(implicit
                                              encoder0: ArgEncoder[String]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Int] =
            _root_.caliban.client.SelectionBuilder.Field(
                "retryFailedInTopic",
                Scalar(),
                arguments = List(Argument("topic", topic, "ID!")(encoder0))
            )
        def retryFailedMessage(id: String)(implicit
                                           encoder0: ArgEncoder[String]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Int] =
            _root_.caliban.client.SelectionBuilder.Field(
                "retryFailedMessage",
                Scalar(),
                arguments = List(Argument("id", id, "String!")(encoder0))
            )
        def copyPendingToKafka(topic: String)(implicit
                                              encoder0: ArgEncoder[String]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Int] =
            _root_.caliban.client.SelectionBuilder.Field(
                "copyPendingToKafka",
                Scalar(),
                arguments = List(Argument("topic", topic, "ID!")(encoder0))
            )
        def reprocessMessage(messageId: String, topic: scala.Option[String] = None)(
            implicit
            encoder0: ArgEncoder[String],
            encoder1: ArgEncoder[scala.Option[String]]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, String] =
            _root_.caliban.client.SelectionBuilder.Field(
                "reprocessMessage",
                Scalar(),
                arguments = List(
                    Argument("messageId", messageId, "ID!")(encoder0),
                    Argument("topic", topic, "ID")(encoder1)
                )
            )
        def reprocessMessages(
                                 messageIds: List[String] = Nil,
                                 topic: scala.Option[String] = None
                             )(implicit
                               encoder0: ArgEncoder[List[String]],
                               encoder1: ArgEncoder[scala.Option[String]]
                             ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, List[
            String
        ]] = _root_.caliban.client.SelectionBuilder.Field(
            "reprocessMessages",
            ListOf(Scalar()),
            arguments = List(
                Argument("messageIds", messageIds, "[ID!]!")(encoder0),
                Argument("topic", topic, "ID")(encoder1)
            )
        )
        def updateExporter[A](id: String, data: ExporterInput)(
            innerSelection: SelectionBuilder[Exporter, A]
        )(implicit
          encoder0: ArgEncoder[String],
          encoder1: ArgEncoder[ExporterInput]
                             ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "updateExporter",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("data", data, "ExporterInput!")(encoder1)
                )
            )
        def addExporterTask(exporter: String, task: ExportTaskInput)(implicit
                                                                     encoder0: ArgEncoder[String],
                                                                     encoder1: ArgEncoder[ExportTaskInput]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, String] =
            _root_.caliban.client.SelectionBuilder.Field(
                "addExporterTask",
                Scalar(),
                arguments = List(
                    Argument("exporter", exporter, "ID!")(encoder0),
                    Argument("task", task, "ExportTaskInput!")(encoder1)
                )
            )
        def cancelExportTask[A](
                                   taskId: String
                               )(innerSelection: SelectionBuilder[ExportTask, A])(implicit
                                                                                  encoder0: ArgEncoder[String]
                               ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "cancelExportTask",
                Obj(innerSelection),
                arguments = List(Argument("taskId", taskId, "ID!")(encoder0))
            )
        def addConceptTransformConfig[A](
                                            conceptTransform: ConceptTransformConfigInput
                                        )(innerSelection: SelectionBuilder[ConceptTransformConfig, A])(implicit
                                                                                                       encoder0: ArgEncoder[ConceptTransformConfigInput]
                                        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "addConceptTransformConfig",
                Obj(innerSelection),
                arguments = List(
                    Argument(
                        "conceptTransform",
                        conceptTransform,
                        "ConceptTransformConfigInput!"
                    )(encoder0)
                )
            )
        def copyConceptTransformConfig[A](
                                             sourceId: String,
                                             title: scala.Option[String] = None
                                         )(innerSelection: SelectionBuilder[ConceptTransformConfig, A])(implicit
                                                                                                        encoder0: ArgEncoder[String],
                                                                                                        encoder1: ArgEncoder[scala.Option[String]]
                                         ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "copyConceptTransformConfig",
                Obj(innerSelection),
                arguments = List(
                    Argument("sourceId", sourceId, "ID!")(encoder0),
                    Argument("title", title, "String")(encoder1)
                )
            )
        def updateConceptTransformConfig[A](
                                               id: String,
                                               conceptTransform: ConceptTransformConfigInput
                                           )(innerSelection: SelectionBuilder[ConceptTransformConfig, A])(implicit
                                                                                                          encoder0: ArgEncoder[String],
                                                                                                          encoder1: ArgEncoder[ConceptTransformConfigInput]
                                           ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "updateConceptTransformConfig",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument(
                        "conceptTransform",
                        conceptTransform,
                        "ConceptTransformConfigInput!"
                    )(encoder1)
                )
            )
        def updateConceptTransformConfigTransforms[A](
                                                         id: String,
                                                         transforms: List[PipelineTransformSetupInput] = Nil
                                                     )(innerSelection: SelectionBuilder[ConceptTransformConfig, A])(implicit
                                                                                                                    encoder0: ArgEncoder[String],
                                                                                                                    encoder1: ArgEncoder[List[PipelineTransformSetupInput]]
                                                     ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "updateConceptTransformConfigTransforms",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("transforms", transforms, "[PipelineTransformSetupInput!]!")(
                        encoder1
                    )
                )
            )
        def deleteConceptTransformConfig[A](
                                               id: String
                                           )(innerSelection: SelectionBuilder[ConceptTransformConfig, A])(implicit
                                                                                                          encoder0: ArgEncoder[String]
                                           ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "deleteConceptTransformConfig",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def addConceptTransformTask(task: ConceptTransformTaskInput)(implicit
                                                                     encoder0: ArgEncoder[ConceptTransformTaskInput]
        ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, String] =
            _root_.caliban.client.SelectionBuilder.Field(
                "addConceptTransformTask",
                Scalar(),
                arguments =
                    List(Argument("task", task, "ConceptTransformTaskInput!")(encoder0))
            )
        def cancelConceptTransformTask[A](
                                             id: String
                                         )(innerSelection: SelectionBuilder[ConceptTransformTask, A])(implicit
                                                                                                      encoder0: ArgEncoder[String]
                                         ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "cancelConceptTransformTask",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def addUserPipelineTransform[A](
                                           description: scala.Option[String] = None,
                                           serviceImage: scala.Option[Upload] = None,
                                           service: scala.Option[UserServiceInput] = None
                                       )(innerSelection: SelectionBuilder[UserPipelineTransform, A])(implicit
                                                                                                     encoder0: ArgEncoder[scala.Option[String]],
                                                                                                     encoder1: ArgEncoder[scala.Option[Upload]],
                                                                                                     encoder2: ArgEncoder[scala.Option[UserServiceInput]]
                                       ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "addUserPipelineTransform",
                Obj(innerSelection),
                arguments = List(
                    Argument("description", description, "String")(encoder0),
                    Argument("serviceImage", serviceImage, "Upload")(encoder1),
                    Argument("service", service, "UserServiceInput")(encoder2)
                )
            )
        def updateUserPipelineTransform[A](
                                              id: String,
                                              description: scala.Option[String] = None,
                                              serviceImage: scala.Option[Upload] = None,
                                              service: scala.Option[UserServiceInput] = None
                                          )(innerSelection: SelectionBuilder[UserPipelineTransform, A])(implicit
                                                                                                        encoder0: ArgEncoder[String],
                                                                                                        encoder1: ArgEncoder[scala.Option[String]],
                                                                                                        encoder2: ArgEncoder[scala.Option[Upload]],
                                                                                                        encoder3: ArgEncoder[scala.Option[UserServiceInput]]
                                          ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "updateUserPipelineTransform",
                Obj(innerSelection),
                arguments = List(
                    Argument("id", id, "ID!")(encoder0),
                    Argument("description", description, "String")(encoder1),
                    Argument("serviceImage", serviceImage, "Upload")(encoder2),
                    Argument("service", service, "UserServiceInput")(encoder3)
                )
            )
        def deleteUserPipelineTransform[A](
                                              id: String
                                          )(innerSelection: SelectionBuilder[UserPipelineTransform, A])(implicit
                                                                                                        encoder0: ArgEncoder[String]
                                          ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
            _root_.caliban.client.SelectionBuilder.Field(
                "deleteUserPipelineTransform",
                Obj(innerSelection),
                arguments = List(Argument("id", id, "ID!")(encoder0))
            )
        def serviceStats[A](
                               reset: scala.Option[Boolean] = None
                           )(innerSelection: SelectionBuilder[ServiceStats, A])(implicit
                                                                                encoder0: ArgEncoder[scala.Option[Boolean]]
                           ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, List[
            A
        ]] = _root_.caliban.client.SelectionBuilder.Field(
            "serviceStats",
            ListOf(Obj(innerSelection)),
            arguments = List(Argument("reset", reset, "Boolean")(encoder0))
        )
    }

}
