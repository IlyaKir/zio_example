import play.sbt.PlayImport.{guice, ws}
import sbt._

object Dependencies {
    private lazy val playVersion = "2.8.18"
    private lazy val akkaVersion = "2.6.20"
    private lazy val zioActorsVersion = "0.0.9"
    private lazy val authCoreVersion = "0.1.25"
    private lazy val slickVersion = "5.1.0"
    private lazy val postgresVersion = "42.5.4"
    private lazy val notificationVersion = "0.1.9"
    private lazy val apachePoiVersion = "5.2.2"
    private lazy val loggingVersion = "0.5.14"
    private lazy val zioMagicVersion = "0.3.12"
    private lazy val logbackVersion = "1.4.5"
    private lazy val sentryLogbackVersion = "6.21.0"
    private lazy val calibanVersion = "1.4.3"
    private lazy val zioTestVersion = "1.0.17"

    private lazy val playInjectDeps = Seq(
        "javax.inject" % "javax.inject" % "1",
        guice,
        ws
    )

    private lazy val zioMagicDeps = Seq(
        "io.github.kitlangton" %% "zio-magic" % zioMagicVersion
    )

    //Akka
    private lazy val akkaDeps = Seq(
        "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-stream" % akkaVersion,
        "com.enragedginger" %% "akka-quartz-scheduler" % "1.8.5-akka-2.6.x",
        "dev.zio" %% "zio-actors-akka-interop" % zioActorsVersion,
        "dev.zio" %% "zio-actors" % zioActorsVersion,
        "dev.zio" %% "zio-actors-persistence" % zioActorsVersion,
        "dev.zio" %% "zio-actors-persistence" % zioActorsVersion,
        "com.github.tharwaninitin" %% "cron4zio" % "0.2.1"
    )

    //Play
    private lazy val playDeps = Seq(
        "com.typesafe.play" %% "play" % playVersion,
        "com.typesafe.play" %% "filters-helpers" % playVersion,
    )

    private lazy val playJsonDeps = Seq(
        "com.typesafe.play" %% "play-json" % "2.9.3",
        "ai.x" %% "play-json-extensions" % "0.42.0",
        "org.julienrf" %% "play-json-derived-codecs" % "10.1.0"
    )

    //Caliban
    private lazy val calibanDeps = Seq(
        "com.github.ghostdogpr" %% "caliban" % calibanVersion,
        "com.github.ghostdogpr" %% "caliban-play" % calibanVersion,
        "com.github.ghostdogpr" %% "caliban-client" % calibanVersion,
        "dev.zio" %% "caliban-deriving" % "0.0.1",
    )

    private lazy val calibanCoreDeps = Seq(
        "com.github.ghostdogpr" %% "caliban" % calibanVersion,
        "com.typesafe" % "config" % "1.4.2"
    )

    // s3
    private lazy val s3Deps = Seq("com.amazonaws" % "aws-java-sdk" % "1.12.352")

    // slick
    private lazy val slickDeps = Seq(
        "com.typesafe.slick" %% "slick" % "3.4.1",
        "org.postgresql" % "postgresql" % postgresVersion,
        "com.typesafe.play" %% "play-slick" % slickVersion,
        "com.typesafe.play" %% "play-slick-evolutions" % slickVersion,
        "com.github.tminglei" %% "slick-pg" % "0.21.1",
        "com.github.tminglei" %% "slick-pg_play-json" % "0.21.1",
        "io.scalac" %% "zio-slick-interop" % "0.4"
    )

    private lazy val smbDeps = Seq("com.hierynomus" % "smbj" % "0.11.5")

    private lazy val ftpDeps = Seq("dev.zio" %% "zio-ftp" % "0.3.5")

    private lazy val httpDeps = Seq(
        "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.3.18",
        "com.softwaremill.sttp.client3" %% "circe" % "3.3.18",
        "io.circe" %% "circe-generic" % "0.15.0-M1"
    )


    private lazy val apachePoiDeps = Seq(
        "org.apache.poi" % "poi" % apachePoiVersion,
        "org.apache.poi" % "poi-ooxml" % apachePoiVersion,
        "org.apache.poi" % "poi-ooxml-lite" % apachePoiVersion
    )

    private lazy val loggingDeps = Seq(
        "dev.zio" %% "zio-logging" % loggingVersion,
        "dev.zio" %% "zio-logging-slf4j" % loggingVersion
    )

    private lazy val charDetectorDeps = Seq(
        "com.github.albfernandez" % "juniversalchardet" % "2.4.0"
    )

    private lazy val progressBar = Seq(
        "me.tongfei" % "progressbar" % "0.9.5"
    )

    private lazy val zioTestDeps = Seq(
        "dev.zio" %% "zio-test" % zioTestVersion,
        "dev.zio" %% "zio-test-sbt" % zioTestVersion % Test,
        "dev.zio" %% "zio-test-magnolia" % zioTestVersion % Test
    )

    private lazy val zioJsonDeps = Seq(
        "dev.zio" %% "zio-json" % "0.2.0"
    )

    private lazy val keycloakDeps = Seq(
        "org.keycloak" % "keycloak-core" % "21.1.1"
    )

    private lazy val jwtDeps = Seq(
        "com.auth0" % "java-jwt" % "4.4.0"
    )

    private lazy val jacksonDeps = Seq(
        "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.4",
        "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.1"
    )

    lazy val reportDeps: Seq[ModuleID] = akkaDeps ++ apachePoiDeps ++ httpDeps ++
        calibanDeps ++ zioMagicDeps ++ s3Deps ++ loggingDeps ++ charDetectorDeps ++ progressBar ++ zioJsonDeps ++
        keycloakDeps ++ jwtDeps
    lazy val talismanConnectorDeps: Seq[ModuleID] = playDeps ++ playJsonDeps ++ playInjectDeps ++
        slickDeps ++ smbDeps ++ ftpDeps ++ zioTestDeps
    lazy val coreDeps: Seq[ModuleID] = playJsonDeps ++ calibanCoreDeps ++ reportDeps
    lazy val playOverrideDependencies: Seq[ModuleID] = jacksonDeps
}
