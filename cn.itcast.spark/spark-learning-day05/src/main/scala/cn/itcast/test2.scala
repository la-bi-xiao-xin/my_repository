package cn.itcast
package com.itcast.spark.dataframe

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object test2 {
  def main(args: Array[String]): Unit = {

    //1-获取SparkSeesion的环境
    //1-准备SparkSesssion
    val spark: SparkSession = {
      val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("_02SchemeType")
      val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
      spark
    }
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    //2-读取数据
    val dataRDD: RDD[String] = sc.textFile("datas/input/people1.txt")
    val dataRDDRow: RDD[Row] = dataRDD.map(_.split("\\s+")).map(x => Row(x(0).toInt, x(1), x(2).toInt))
    //3-动态增加Schema
    //3-2
    val schema: StructType = new StructType()
      .add("id", IntegerType, true)
      .add("name", StringType, true)
      .add("age", IntegerType, true)
    val peopleDF1: DataFrame = spark.createDataFrame(dataRDDRow, schema)
    peopleDF1.printSchema()
    peopleDF1.show()
    //root
    //|-- id: integer (nullable = true)
    //|-- name: string (nullable = true)
    //|-- age: integer (nullable = true)


    //4-使用DSL或SQL风格查看数据
  }

}
