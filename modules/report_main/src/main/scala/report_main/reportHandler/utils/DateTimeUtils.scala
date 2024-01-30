package report_main.reportHandler.utils

import report_main.generated.kb_api.graphql.DateInput

import java.util.Calendar

object DateTimeUtils {
    def convertDateInputToMillis(dateInput: DateInput): Option[Long] = {
        dateInput.year.map { year =>
            val month = dateInput.month.map(_ - 1).getOrElse(0)
            val day = dateInput.day.getOrElse(1)
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            calendar.getTime.getTime / 1000
        }
    }
}
