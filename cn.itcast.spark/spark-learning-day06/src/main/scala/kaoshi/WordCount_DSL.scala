package kaoshi

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object WordCount_DSL {
  def main(args: Array[String]): Unit = {
    //1.准备sparkSQL执行环境
    val spark: SparkSession = SparkSession.builder()
      .appName("WordCount_DSL")
      .master("local[*]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._

    //2.读取数据进行统计
    val fileDS: Dataset[String] = spark
      .read.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\words.txt")
    fileDS.printSchema()
    //root
    // |-- value: string (nullable = true)

    val valueDS: Dataset[String] = fileDS.flatMap(_.split(" "))
    val resultDS: DataFrame = valueDS
      .groupBy("value").count()
    resultDS.show()
    //+------+-----+
    //| value|count|
    //+------+-----+
    //| spark|    1|
    //| Flink|    2|
    //| flume|    2|
    //| Spark|    1|
    //|hadoop|    2|
    //+------+-----+

    valueDS.createOrReplaceTempView("table")
    val sql="""
              |select value,count(*) counts from table
              |group by value
              |order by counts desc
            """.stripMargin

    val resultDF2: DataFrame = spark.sql(sql)
    resultDF2.show()
    //+------+-----+
    //
    //+------+------+
    //| value|counts|
    //+------+------+
    //| Flink|     2|
    //| flume|     2|
    //|hadoop|     2|
    //| spark|     1|
    //| Spark|     1|
    //+------+------+

    spark.stop()

  }

}
