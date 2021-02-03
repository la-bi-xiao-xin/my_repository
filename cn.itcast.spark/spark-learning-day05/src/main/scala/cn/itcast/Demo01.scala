package cn.itcast

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object Demo01 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("Demo01")
      .master("local[*]")
      .getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._
    val fileDS: Dataset[String] = spark.read.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\people1.txt")
    val num: Long = fileDS.count()
    print(num)
    fileDS.show()
    val value1: Dataset[String] = fileDS.flatMap(_.split(" "))
    value1.show()
    fileDS.printSchema()
    val frame: DataFrame = fileDS.select("value")
    frame.show()
  }

}
