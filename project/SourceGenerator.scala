import sbt._
import kantan.csv._
import kantan.csv.ops._
import sbt.io.IO

import uk.co.bgch.retrofit.templates.txt._

object SourceGenerator {
  def generateScalaParameterMetadata(parameterFile: File, targetDir: File): Seq[File] = {
    val allParameters = readAllParameters(parameterFile)
    
    val parameterNamesFile = targetDir / "uk/co/bgch/retrofit/parameters/RetrofitParameterNames.scala"
    IO.write(parameterNamesFile, ScalaParameterNameConstants(allParameters).toString)
    
    val parameterCodesFile = targetDir / "uk/co/bgch/retrofit/parameters/RetrofitParameterCodes.scala"
    IO.write(parameterCodesFile, ScalaParameterCodeConverter(allParameters).toString)
    
    Seq(parameterNamesFile, parameterCodesFile)
  }


  def generateJavascriptParameterMetadata(parameterFile: File, targetDir: File): Unit = {
    val allParameters = readAllParameters(parameterFile)

    val parameterNamesFile = targetDir / "parameter-codes.js"
    IO.write(parameterNamesFile, JavascriptParameterNameConstants(allParameters).toString)
  }

  private def readAllParameters(parameterFile: sbt.File) =
    parameterFile.asUnsafeCsvReader[(String, Int)](rfc.withHeader).toSeq
}
