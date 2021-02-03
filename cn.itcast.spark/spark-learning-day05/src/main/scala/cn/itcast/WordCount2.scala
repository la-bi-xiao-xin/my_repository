package cn.itcast

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object WordCount2 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().appName("WordCount2").master("local[*]").getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._

    val fileDS: Dataset[String] = spark.read.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\hello.txt")
    val valueDS: Dataset[String] = fileDS.flatMap(_.split(" "))
    valueDS.createTempView("table_view")
    val sql="""
      |select value,count(*) counts from table_view
      |group by value
      |order by counts desc
    """.stripMargin
    val resultDF: DataFrame = spark.sql(sql)
    resultDF.show()
  }
}
