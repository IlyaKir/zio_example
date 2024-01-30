package model.common.errors

trait UserFacingErrorWithParams extends Throwable {
    def getParams: Seq[(String, String)]

    def getField: Option[String]
}

