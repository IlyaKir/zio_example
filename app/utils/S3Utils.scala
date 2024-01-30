package utils

import com.amazonaws.ClientConfiguration
import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import com.typesafe.config.ConfigFactory
import model.common.errors.{ErrorType, TalismanConnectorError}
import play.api.libs.json.Json.JsValueWrapper
import play.api.libs.json.{JsNumber, JsObject, Json}
import common.types.ID
import zio.ZIO
import zio.logging.Logging

import java.io.ByteArrayInputStream
import java.math.BigInteger
import java.security.MessageDigest
import java.util.UUID
import scala.collection.mutable
import scala.util.{Failure, Success, Try}

object S3Utils {

    private val publicKey = ConfigFactory.load().getString("s3.access_key")
    private val secretLey = ConfigFactory.load().getString("s3.secret_key")
    private val url = ConfigFactory.load().getString("s3.url")

    private val credentials = new BasicAWSCredentials(publicKey, secretLey)
    private val clientConfiguration = new ClientConfiguration()
    clientConfiguration.setSignerOverride("AWSS3V4SignerType")

    final val bucketName = ConfigFactory.load().getString("s3.documents_bucket")

    val s3Client: AmazonS3 = AmazonS3ClientBuilder
        .standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(url, Regions.EU_CENTRAL_1.name()))
        .withPathStyleAccessEnabled(true)
        .withClientConfiguration(clientConfiguration)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build()

    initBucket(bucketName)

    def initBucket(bucketName: String): Unit = {
        if (!s3Client.doesBucketExistV2(bucketName)) {
            s3Client.createBucket(bucketName)
        }
    }

    def getFilePath(fileUUID: String, fileName: String): String =
        fileUUID.substring(0, 4) + "/" + fileUUID.substring(4, 8) + "/" + fileName

    def saveToS3(
                    docBytes: Array[Byte],
                    fileName: String,
                    userId: String,
                    url: Option[String],
                    accessLevel: Option[ID],
                    trustLevel: Option[Float],
                    contentType: Option[String] = None
                ): ZIO[Logging, Throwable, JsObject] = {
        val checksum = new BigInteger(1, MessageDigest.getInstance("md5").digest(docBytes)).toString(16)
        val fileUUID = UUID.randomUUID().toString
        val maxFileNameLength = 63

        val fixedFileName = if (fileName.length > maxFileNameLength) {
            val regex = """\.[A-Za-z0-9]+$""".r
            val extension = regex.findFirstIn(fileName).getOrElse("")
            val newFileName = fileName.substring(0, maxFileNameLength - extension.length)
            s"$newFileName$extension"
        } else fileName
        val filePath = getFilePath(fileUUID, fixedFileName)

        saveFileToS3(bucketName, filePath, docBytes, contentType) match {
            case Failure(exception) => Logging.error(s"S3Utils. Cannot save file $fixedFileName. Reason: ${exception.getMessage}") *> ZIO.fail(exception)
            case Success(path) =>
                val fields: mutable.Buffer[(String, JsValueWrapper)] = scala.collection.mutable.Buffer(
                    "path" -> path,
                    "checksum" -> checksum,
                    "filename" -> fixedFileName,
                    "uuid" -> fileUUID,
                    "user" -> userId
                )

                if (url.isDefined) {
                    fields += ("url" -> url.get)
                }
                if (accessLevel.isDefined) {
                    fields += ("access_level" -> accessLevel.get.toString)
                }
                if (trustLevel.isDefined) {
                    fields += ("trust_level" -> JsNumber(trustLevel.get))
                }

                ZIO.succeed(Json.obj(fields.toSeq: _*))
        }
    }

    private def saveFileToS3(
                                bucketName: String,
                                filePath: String,
                                docBytes: Array[Byte],
                                contentType: Option[String]
                            ): Try[String] = {
        val path = "s3://" + bucketName + "/" + filePath

        val inputStream = new ByteArrayInputStream(docBytes)
        val metadata = new ObjectMetadata()
        metadata.setContentLength(inputStream.available())
        contentType.foreach(metadata.setContentType)
        Try(s3Client.putObject(bucketName, filePath, inputStream, metadata)).fold(
            _ => {
                inputStream.close()
                Failure(TalismanConnectorError(errorType = ErrorType.InvalidName))
            },
            _ => {
                inputStream.close()
                Success(path)
            }
        )
    }
}
