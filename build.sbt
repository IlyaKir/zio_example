import Dependencies._

name := "tconnector"

version := "0.1"

Global / resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

lazy val scala212 = "2.12.17"
lazy val scala213 = "2.13.10"
ThisBuild / scalaVersion := scala213
lazy val supportedScalaVersions = List(scala212, scala213)

lazy val common = (project in file("modules/common"))
  .settings(name := "common")
  .settings(organization := "tconnector")
  .settings(libraryDependencies ++= coreDeps)
  .settings(crossScalaVersions := supportedScalaVersions)

lazy val report_main = (project in file("modules/report_main"))
  .settings(name := "report_main")
  .settings(organization := "tconnector")
  .settings(libraryDependencies ++= reportDeps)
  .settings(crossScalaVersions := supportedScalaVersions)
  .dependsOn(common)

lazy val report_test = (project in file("modules/report_test"))
  .settings(name := "report_test")
  .settings(organization := "report_test")
  .settings(crossScalaVersions := Nil)
  .dependsOn(report_main, common)
  .aggregate(report_main, common)

lazy val `tconnector` = (project in file("."))
  .settings(libraryDependencies ++= talismanConnectorDeps)
  .settings(dependencyOverrides ++= playOverrideDependencies)
  .settings(testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"))
  .enablePlugins(PlayScala)
  .enablePlugins(CalibanPlugin)
  .settings(crossScalaVersions := Nil)
  .dependsOn(report_main, common)
  .aggregate(report_main, common)
