name          := "spark-plug"
version       := "1.0"
scalaVersion  := "2.11.8"

import com.typesafe.sbt.packager.docker._


enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ywarn-unused-import",
  "-deprecation",
  "-feature",
  "-target:jvm-1.8",
  "-unchecked"
)

libraryDependencies ++= Seq(
  "org.apache.spark"  %% "spark-core" % "2.1.0",
  "org.scalatest"     %% "scalatest"  % "3.0.1" % "test"
)

// Required so that `sbt run` will work for Spark
fork := true

mappings in Universal += file("README.md") -> "README.md"