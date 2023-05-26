package org.apache.spark.sql

import org.apache.spark.connect.proto.Plan
import org.apache.spark.sql.catalyst.encoders.AgnosticEncoders.UnboundRowEncoder

import java.io.FileInputStream

object PlanDeserializer {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().remote("sc://localhost").build()

    //read the plan from file and convert
    val serializedFile = "filterdef.ser"
    val inputStream = new FileInputStream(serializedFile)
    val parsedPlan = Plan.parseFrom(inputStream)

    //use the plan in creating new dataset
    val dataset = new Dataset(sparkSession, parsedPlan, UnboundRowEncoder)
    println(dataset.explain(true))

    //get the data
    println(dataset.show())
  }

}
