package cn.itcast

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object Demo03 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("Demo03")
      .master("local[*]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
      sc.setLogLevel("WARN")
import spark.implicits._
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\people1.txt")
    val rowRDD: RDD[Row] = fileRDD.map(_.split(" ")).map(x => Row(x(0).toInt,x(1),x(2).toInt))
    val structType = StructType(
      Seq(
        StructField("id", IntegerType, true),
        StructField("name", StringType, true),
        StructField("age", IntegerType, true)
      )
    )
    val structType2: StructType = (new StructType())
      .add("id", IntegerType, true)
      .add("name", StringType, true)
      .add("age", IntegerType, true)

    val resultDF1: DataFrame = spark.createDataFrame(rowRDD,structType)
    resultDF1.show()
    val resultDF2: DataFrame = spark.createDataFrame(rowRDD,structType2)
    resultDF2.show()
  }

}
