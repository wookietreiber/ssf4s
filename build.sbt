
name := "ssf4s"

organization := "com.github.ssf4s"

description := "Simple Syndication Facade for Scala"

version := "0.2.0-SNAPSHOT"

scalaVersion := "2.10.0-RC1"

crossScalaVersions := Seq("2.9.2", "2.10.0-RC1")

libraryDependencies ++= Seq (
  "org.specs2"           %% "specs2"     % "1.12.2" % "test" cross CrossVersion.full
)

initialCommands += """
  import scalax.ssf4s._
"""

startYear := Some(2011)

licenses := Seq("WTFPL" → url("http://sam.zoy.org/wtfpl/COPYING"))

homepage := Some(url("https://github.com/wookietreiber/ssf4s"))

scmInfo := Some(ScmInfo(
  browseUrl     = url("https://github.com/wookietreiber/ssf4s"),
  connection    = "scm:git:git://github.com/wookietreiber/ssf4s.git",
  devConnection = Some("scm:git:https://github.com/wookietreiber/ssf4s.git")
))

