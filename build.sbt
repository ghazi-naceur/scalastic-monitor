name := "scalastic-monitor"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.elasticsearch" % "elasticsearch" % "6.5.4",
  "org.elasticsearch.client" % "transport" % "6.5.4",
  "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % "6.5.4",
  "com.typesafe.play" %% "play" % "2.6.11",
  "com.typesafe" % "config" % "1.3.2",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.slf4j" % "slf4j-simple" % "1.7.25",
  "org.apache.logging.log4j" % "log4j-api" % "2.11.2",
  "org.apache.logging.log4j" % "log4j-core" % "2.11.2"
)