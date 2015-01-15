name := """play-slick-sample"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "0.8.0"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
