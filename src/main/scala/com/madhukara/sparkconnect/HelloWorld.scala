package com.madhukara.sparkconnect

import org.apache.spark.sql.SparkSession

object HelloWorld {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().remote("sc://localhost").build()
    val df = sparkSession.range(500)
    println(df.count())
  }

}
