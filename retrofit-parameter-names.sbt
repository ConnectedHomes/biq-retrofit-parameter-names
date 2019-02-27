import sbt._
import sbt.Keys.{resourceDirectory, scalaVersion, _}
import SourceGenerator._

lazy val `retrofit-parameter-names` =
  (project in file("."))
    .settings(
      (sourceGenerators in Compile) += Def.task {
        val resources = (resourceDirectory in Compile).value
        val parameterFile = resources / "parameters.csv"
        generateJavascriptParameterMetadata(parameterFile, resources / "npm-package/lib")
        generateScalaParameterMetadata(parameterFile, (sourceManaged in Compile).value)

      }.taskValue,
      organization := "uk.co.bgch",
      scalaVersion := "2.12.6",
      version := sys.env.getOrElse("BUILD_NUMBER", "999-SNAPSHOT"),
      crossScalaVersions := Seq("2.11.12", "2.12.6")
    )