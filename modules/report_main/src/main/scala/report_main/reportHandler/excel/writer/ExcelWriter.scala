package report_main.reportHandler.excel.writer

import me.tongfei.progressbar.{ProgressBar, ProgressBarBuilder, ProgressBarStyle}
import report_main.reportHandler.types.mainFiles.ExcelWorkbook
import zio.logging._
import zio.{RIO, ZIO, ZManaged}

import java.io.{ByteArrayOutputStream, FileOutputStream}
import scala.util.Try

case class ExcelWriter(excelWorkbook: ExcelWorkbook) {
    import report_main.reportHandler.sideEffects.{ExcelWriterSE => SE}

    def write: RIO[Logging, (String, Array[Byte])] = {
        val progressBar = new ProgressBarBuilder()
            .setTaskName(s"${excelWorkbook.fileName} writer")
            .setInitialMax(0)
            .setStyle(ProgressBarStyle.ASCII)
        val outputStreamEffect = ZIO.effect(ProgressBar.wrap(new FileOutputStream(s"${excelWorkbook.fileName}"), progressBar))

        for {
            _ <- SE.writingEnrichedExcel(excelWorkbook.fileName)
            _ <- ZManaged.fromAutoCloseable(outputStreamEffect).use(outputStream => ZIO.fromTry(Try(excelWorkbook.workbook.write(outputStream))))
                .tapError(_ => SE.enrichedExcelWritingFailed(excelWorkbook.fileName))
            _ <- SE.enrichedExcelWritingSucceed(excelWorkbook.fileName)
            result <- {
                val out = new ByteArrayOutputStream()
                ZIO.effect(excelWorkbook.workbook.write(out)).as((excelWorkbook.fileName, out.toByteArray))
            }
        } yield result
    }
}
