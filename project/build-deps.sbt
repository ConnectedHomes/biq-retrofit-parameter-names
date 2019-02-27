libraryDependencies ++= Seq(
  "com.nrinaudo" %% "kantan.csv" % "0.5.0", 
  "uk.co.bgch" %% "retrofit-parameter-templates" % sys.env.getOrElse("BUILD_NUMBER", "999-SNAPSHOT")
)