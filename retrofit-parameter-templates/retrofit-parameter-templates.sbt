
lazy val templates =
  (project in file("."))
    .enablePlugins(SbtTwirl)
  .settings(
    scalaVersion := "2.12.6",
    crossScalaVersions := Seq("2.11.12", "2.12.6"),
    organization := "uk.co.bgch",
    name := "retrofit-parameter-templates",
    version := sys.env.getOrElse("BUILD_NUMBER", "999-SNAPSHOT")
  )
