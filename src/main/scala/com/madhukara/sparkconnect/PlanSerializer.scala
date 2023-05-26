package com.madhukara.sparkconnect

import org.apache.spark.sql.SparkSession

import java.io.{File, FileOutputStream}

object PlanSerializer {

  case class Employee(name:String, age:Int, salary:Double)

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().remote("sc://localhost").build()
    import sparkSession.implicits._

    val data = List (
      Employee("madhav",26,60000),
      Employee("Raju",30, 80000)
    )

    val sourceDf = sparkSession.createDataset(data)
    val filteredDf = sourceDf.filter("salary > 60000")

    //print the plan

    println(filteredDf.explain(true))

    //get the protofub plan object
    val plan = sourceDf.plan
    // write the protofub plan object to the file
    val file = new File("filterdef.ser")
    val fileOutputStream = new FileOutputStream(file)
    plan.writeTo(fileOutputStream)
    fileOutputStream.close()
  }

}
