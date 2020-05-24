import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile
import sbt.Keys._
import sbt.{Tests, _}

object Configuration {
  val settings = Seq(
    organization := "com.roberthuaman",
    scalaVersion := "2.12.7",
    // Custom folders path (/src/main/scala and /src/test/scala by default)
    mainClass in Compile := Some("com.roberthuaman.api.entry_point.ScalaHttpApi"),
    scalaSource in Compile := baseDirectory.value / "/src/main",
    scalaSource in Test := baseDirectory.value / "/src/test",
    resourceDirectory in Compile := baseDirectory.value / "conf",
    scalafmtOnCompile := true,
    // Compiler options
    scalacOptions ++= Seq(
      "-deprecation", // Warnings deprecation
      "-feature", // Advise features
      "-unchecked", // More warnings. Strict
      "-Xlint", // More warnings when compiling
      "-Ywarn-dead-code",
      "-Ywarn-unused",
      "-Xcheckinit" // Check against early initialization
    ),
    scalacOptions in run in Compile -= "-Xcheckinit", // Remove it in production because it's expensive
    javaOptions += "-Duser.timezone=UTC",
    // Test options
    parallelExecution in Test := false,
    testForkedParallel in Test := false,
    fork in Test := true,
    testOptions in Test ++= Seq(
      Tests.Argument(
        TestFrameworks.ScalaTest,
        "-u",
        "target/test-reports"
      ), // Save test reports
      Tests.Argument(
        "-oDF"
      ) // Show full stack traces and time spent in each test
    )
  )
}
