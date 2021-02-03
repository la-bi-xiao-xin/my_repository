package cn.itcast

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .appName("test")
      .master("local[5]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    //2.读取文件数据
    val fileDS: Dataset[String] = spark.read.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\hello.txt")
    val valueDS: Dataset[String] = fileDS.flatMap(_.split(" "))
    valueDS.show()
    val resultDF: DataFrame = valueDS.groupBy("value").count()
    resultDF.orderBy($"count".desc).show()
    resultDF.orderBy('count.desc).show()
  }

}
