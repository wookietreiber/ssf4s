import sbt._
import Keys._

object ssf4sBuild extends Build {
  lazy val root = Project (
    id        = "ssf4s",
    base      = file ("."),
    settings  = Defaults.defaultSettings ++ Seq (
      organization         := "com.github.ssf4s",
      version              := "0.2.0-SNAPSHOT",
      scalaVersion         := "2.9.1",
      libraryDependencies ++= Seq (
        "org.scala-tools.time" %% "time"   % "0.5",
        "org.specs2"           %% "specs2" % "1.9" % "test"
      ),
      initialCommands in Compile in console += """
        import scalax.ssf4s._
      """
    )
  )
}
