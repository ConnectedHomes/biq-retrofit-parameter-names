import sbt.Keys.{publishTo, _}
import sbt._

object BoilerIqPublishPlugin extends AutoPlugin {

  override def trigger = allRequirements

  override lazy val projectSettings = Seq(
    credentials += Credentials("Artifactory Realm", "bgchops.jfrog.io", "boilers-rw", sys.env.getOrElse("JFROG_PASSWORD", "")),
      publishTo := Some ("BGCHOPS repo" at "https://bgchops.jfrog.io/bgchops/libs-snapshot-local/"),
      publishTo := {
      val jfrog = "https://bgchops.jfrog.io/bgchops/"
      if (isSnapshot.value)
        Some("BGCHOPS snapshots" at jfrog + "libs-snapshot-local")
      else
        Some("BGCHOPS releases" at jfrog + "libs-release-local")
    }
  )
}