import sbt._
import sbt.Keys.{scalaVersion, _}
import GenerateScalaSources._

lazy val `retrofit-parameter-names` =
  (project in file("."))
    .settings(
      (sourceGenerators in Compile) += Def.task {
        generateScalaParameterMetadata((resourceDirectory in Compile).value / "parameters.csv", (sourceManaged in Compile).value)
      }.taskValue,
      organization := "uk.co.bgch",
      scalaVersion := "2.12.6",
      version := sys.env.getOrElse("BUILD_NUMBER", "999-SNAPSHOT"),
      crossScalaVersions := Seq("2.11.12", "2.12.6")
    )