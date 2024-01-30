package report_main.reportHandler.utils

import java.text.Normalizer

object StringNormalizer {
    def normalize(str: String): String = Normalizer.normalize(str, Normalizer.Form.NFC)
}
