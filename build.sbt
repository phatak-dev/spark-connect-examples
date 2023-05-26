ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.17"



lazy val root = (project in file("."))
  .settings(
    name := "SparkConnectExperiments"
  )

libraryDependencies += "org.apache.spark"%  "spark-connect_2.12"%"3.4.0"
libraryDependencies += "org.apache.spark"%  "spark-connect-client-jvm_2.12"%"3.4.0"
libraryDependencies += "org.apache.spark"%  "spark-catalyst_2.12"%"3.4.0"





