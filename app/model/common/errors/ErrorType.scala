package model.common.errors

sealed trait ErrorType {

    private val projectErrorPrefix = "TalismanConnectorErrors"

    def formMessage(field: Option[String]): String = {
        field match {
            case None => s"$projectErrorPrefix.${this.toString}"
            case Some(value) => s"$projectErrorPrefix.$value.${this.toString}"
        }
    }
}

object ErrorType {
    case object InvalidName extends ErrorType
}
