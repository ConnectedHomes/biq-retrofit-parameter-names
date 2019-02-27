import sbt._
import kantan.csv._
import kantan.csv.ops._
import sbt.io.IO

import uk.co.bgch.retrofit.templates.txt._

object GenerateScalaSources {
  def generateScalaParameterMetadata(sourceFile: File, targetDir: File): Seq[File] = {
    val allParameters = sourceFile.asUnsafeCsvReader[(String, Int)](rfc.withHeader).toSeq
    
    val parameterNamesFile = targetDir / "uk/co/bgch/retrofit/parameters/RetrofitParameterNames.scala"
    IO.write(parameterNamesFile, ParameterNameConstants(allParameters).toString)
    
    val parameterCodesFile = targetDir / "uk/co/bgch/retrofit/parameters/RetrofitParameterCodes.scala"
    IO.write(parameterCodesFile, ParameterCodeConverter(allParameters).toString)
    
    Seq(parameterNamesFile, parameterCodesFile)
  }

}
