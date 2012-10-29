
name := "ssf4s"

organization := "com.github.ssf4s"

version := "0.2.0-SNAPSHOT"

scalaVersion := "2.10.0-RC1"

crossScalaVersions := Seq("2.9.2", "2.10.0-RC1")

libraryDependencies ++= Seq (
  "org.scala-tools.time" %  "time_2.9.1" % "0.5",
  "org.specs2"           %% "specs2"     % "1.12.2" % "test" cross CrossVersion.full
)

initialCommands += """
  import scalax.ssf4s._
"""

