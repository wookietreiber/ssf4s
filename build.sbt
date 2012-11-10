
name := "ssf4s"

version := "0.2.0-SNAPSHOT"

scalaVersion := "2.10.0-RC2"

libraryDependencies ++= Seq (
  "org.specs2" %% "specs2" % "1.12.2" % "test" cross CrossVersion.full
)

initialCommands in (Compile, consoleQuick) <<= initialCommands in Compile

initialCommands in Compile in console += """
  import scalax.ssf4s._
"""

// -------------------------------------------------------------------------------------------------
// supplementary project information
// -------------------------------------------------------------------------------------------------

organization := "com.github.ssf4s"

description := "Simple Syndication Facade for Scala"

homepage := Some(url("https://github.com/wookietreiber/ssf4s"))

startYear := Some(2011)

licenses := Seq (
  "WTFPL" → url("http://sam.zoy.org/wtfpl/COPYING")
)

scmInfo := Some(ScmInfo(
  url("https://github.com/wookietreiber/ssf4s"),
  "scm:git:git://github.com/wookietreiber/ssf4s.git",
  Some("scm:git:https://github.com/wookietreiber/ssf4s.git")
))

pomExtra := (
  <developers>
    <developer>
      <id>wookietreiber</id>
      <name>Christian Krause</name>
      <url>https://github.com/wookietreiber</url>
    </developer>
  </developers>
)

// -------------------------------------------------------------------------------------------------
// publishing
// -------------------------------------------------------------------------------------------------

publishMavenStyle := true

publishTo <<= version { (version: String) ⇒
  val nexus = "https://oss.sonatype.org/"
  if (version.trim.endsWith("-SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ ⇒ false }

