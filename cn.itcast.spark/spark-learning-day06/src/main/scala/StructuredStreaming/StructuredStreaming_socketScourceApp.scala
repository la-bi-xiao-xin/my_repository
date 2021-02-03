package StructuredStreaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object StructuredStreaming_socketScourceApp {
  def main(args: Array[String]): Unit = {
    //1.准备环境
    val conf: SparkConf = new SparkConf()
      .setAppName("StructuredStreaming_socketScourceApp").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
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
    val valueDs: Dataset[String] = inputDF.as[String].flatMap(_.split(" "))
    val resultDS: Dataset[Row] = valueDs.groupBy("value").count().orderBy('count.desc)

    //4.结果output
    val query: StreamingQuery = resultDS.writeStream
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
