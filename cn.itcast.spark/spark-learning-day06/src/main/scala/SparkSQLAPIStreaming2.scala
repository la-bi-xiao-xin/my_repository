package cn.itcast.spark.sparksql
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkSQLAPIStreaming2 {
  def main(args: Array[String]): Unit = {
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("WindowsOpreation2").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }
    //2-使用ssc(StreamingContext）接受node1.itcast.cn:9999的socket端口号对的数据
    val valueDS: ReceiverInputDStream[String] =
      ssc.socketTextStream("192.168.88.100", 9999)
    val wordsDS: DStream[String] = valueDS.flatMap(_.split("\\s+"))
    wordsDS.foreachRDD(rdd => {
      val spark = SparkSession.builder.config(rdd.sparkContext.getConf).getOrCreate()
      import spark.implicits._
      val wordDF: DataFrame = rdd.toDF("word") //用户自己指定scheme的名称，这里指定的是word
      wordDF.createOrReplaceTempView("t_table_view")
      val sql: String =
        """
          |select word,count(word) counts
          |from t_table_view
          |group by word
          |order by counts desc
          |""".stripMargin
      //DSL
      //wordDF.groupBy("word").count().orderBy($"count".desc).limit(10)
      spark.sql(sql).show()
    })
    //5-执行输出print
    //6-开启Streaming的接受数据
    //ssc.start
    ssc.start()
    //7-需要配置什么时候结束
    ssc.awaitTermination()
    //ssc.awaitTermination,等待程序停止(用户点击idea上的)
    ssc.stop(true, true)
  }
}