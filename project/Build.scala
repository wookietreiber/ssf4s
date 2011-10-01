import sbt._
import Keys._

import Dependencies._
import BuildSettings._

object BuildSettings {
  val buildOrganization = "com.github.wookietreiber.ssf4s"
  val buildVersion      = "0.0.1"
  val buildScalaVersion = "2.9.1"
  val latest            = "latest.integration"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization         := buildOrganization,
    version              := buildVersion,
    scalaVersion         := buildScalaVersion,
    libraryDependencies ++= Seq ( specs2 )
  )
}

object ssf4sBuild extends Build {
  lazy val root = Project ( "ssf4s", file ("."), settings = buildSettings )
}

object Dependencies {
  lazy val specs2 = "org.specs2" %% "specs2" % "1.6.1" % "test"
}