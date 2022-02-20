ThisBuild / scalaVersion := "2.10.2"

val openTelemetryVersion: String = "1.11.0"
libraryDependencies += "io.opentelemetry" % "opentelemetry-api" % openTelemetryVersion
libraryDependencies += "io.opentelemetry" % "opentelemetry-extension-annotations" % openTelemetryVersion
libraryDependencies += "com.google.code.findbugs" % "jsr305" % "3.0.+"
ThisBuild / mainClass  := Some("test.example.Hello")

lazy val root = project
  .in(file("."))
  .enablePlugins(JavaAgent, JavaAppPackaging)
  .settings(
    javaAgents += JavaAgent("io.opentelemetry.javaagent" % "opentelemetry-javaagent"  % "1.11.0" % "runtime"),
    Compile / run / javaOptions += "-Dotel.instrumentation.methods.include=example.Example$[main,fuga]",
  )
