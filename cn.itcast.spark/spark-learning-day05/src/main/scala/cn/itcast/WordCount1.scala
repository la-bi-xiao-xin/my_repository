package cn.itcast

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object WordCount1 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .appName("WordCount1")
      .master("local[*]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._

    val fileDS: Dataset[String] = spark.read.textFile(
      "F:\\idea_project\\cn.itcast.spark\\datas\\input\\hello.txt")

    val valueDS: Dataset[String] = fileDS.flatMap(_.split(" "))
   valueDS.printSchema()
    //root
    // |-- value: string (nullable = true)
    val resultDS: Dataset[Row] = valueDS.groupBy("value").count().orderBy('count.desc)
    resultDS.show()
  }
}
