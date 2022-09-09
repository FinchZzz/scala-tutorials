ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

val scalaTestVersion = "3.2.12"

val commonSetting = Seq(
  addCompilerPlugin(("org.typelevel" %% "kind-projector" % "0.13.2").cross(CrossVersion.full)),
  scalafmtOnCompile := true,
  idePackagePrefix := Some("org.finch"),
  libraryDependencies ++= Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.2.11",
    "org.scalatest" %% "scalatest" % scalaTestVersion % Test
  )
)

lazy val algorithm = (project in file("algorithm"))
  .settings(commonSetting)
  .settings(
    scalacOptions --= Seq(
      "-Xfatal-warnings"
    )
  )
