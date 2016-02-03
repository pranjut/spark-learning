//
// http://spark.apache.org/docs/latest/quick-start.html#a-standalone-app-in-scala
//
name := """spark-activator"""

// 2.11 doesn't seem to work
scalaVersion := "2.11.7"

libraryDependencies ++= Dependencies.sparkHadoop


