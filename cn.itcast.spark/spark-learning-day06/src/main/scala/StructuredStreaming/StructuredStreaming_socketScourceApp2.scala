package StructuredStreaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object StructuredStreaming_socketScourceApp2 {
  def main(args: Array[String]): Unit = {
    //1.准备环境
    val conf: SparkConf = new SparkConf()
      .setAppName("StructuredStreaming_socketScourceApp")
      .setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder()
      .config(conf)
      .config("spark.sql.shuffle.partitions", "2") // 设置Shuffle分区数目
      .getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._

    //2.从socketScource中获取数据
    val inputDF: DataFrame = spark.readStream
      .format("socket")
      .option("host", "node1.itcast.cn")
      .option("port", "9999")
      .load()
    inputDF.printSchema()
    //root
    // |-- value: string (nullable = true)
    //3.统计  query
   inputDF.createOrReplaceTempView("table_view")
    val sql: String =
      """
        |select value,count(value) as counts
        |from table_view
        |group by value
        |order by counts desc
        |""".stripMargin
    val resultDF: DataFrame = spark.sql(sql)

    //4.结果output
    val query: StreamingQuery = resultDF.writeStream
      .format("console")
      .outputMode("Complete")
      .trigger(Trigger.ProcessingTime(0))
      .start()

    query.awaitTermination()
    // query.stop()

    //5.环境停止
    spark.stop()


  }

}
