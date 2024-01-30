package model.common.errors

case class TalismanConnectorError(
                                     errorType: ErrorType,
                                     params: Seq[(String, String)] = Seq(),
                                     field: Option[String] = None
                                 ) extends UserFacingErrorWithParams {

    override def getMessage: String = errorType.formMessage(field)

    override def getParams: Seq[(String, String)] = params

    override def getField: Option[String] = field.map(_.split("\\.").last)
}
