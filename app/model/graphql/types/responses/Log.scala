//package model.graphql.types.responses
//
//import caliban.schema.Schema
//import model.common.enums.LogLevel
//import model.graphql.types.UnixTime
//
//object Log {
//    implicit val logSchema: Schema[Any, Log] = Schema.genMacro[Log].schema
//}
//
//case class Log(taskId: Option[String],
//               periodicTaskId: Option[String],
//               timestamp: UnixTime,
//               level: LogLevel,
//               message: String,
//               loggerName: String,
//               stackTrace: Option[String])
//
//object LogPagination {
//    implicit val schema: Schema[Any, LogPagination] = Schema.genMacro[LogPagination].schema
//}
//
//case class LogPagination(total: Long, listLog: Seq[Log])
