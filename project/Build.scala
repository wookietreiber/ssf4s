import sbt._
import Keys._

import Dependencies._
import BuildSettings._

object BuildSettings {
  val buildOrganization = "com.github.ssf4s"
  val buildVersion      = "nightly"
  val buildScalaVersion = "2.9.1"
  val latest            = "latest.integration"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization         := buildOrganization,
    version              := buildVersion,
    scalaVersion         := buildScalaVersion
  )
}

object ssf4sBuild extends Build {
  lazy val root = Project ( "ssf4s", file ("."),
    settings = buildSettings ++ Seq (
      libraryDependencies ++= Seq ( time, specs2 ),
      initialCommands in Compile in console := """import scalax.ssf4s._"""
    )
  )
}

object Dependencies {
  lazy val time   = "org.scala-tools.time" %% "time"   % "0.5"
  lazy val specs2 = "org.specs2"           %% "specs2" % "1.7.1" % "test"
}
