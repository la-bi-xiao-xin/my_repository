import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkSQLAPIStreaming3 {
  def main(args: Array[String]): Unit = {
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("SparkSQLAPIStreaming").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }

    //2.读取Socket源数据,并整合SparkSQL统计数据
    val valueDS: ReceiverInputDStream[String] =
      ssc.socketTextStream("node1.itcast.cn", 9999)
    val flatMapDS: DStream[String] = valueDS.flatMap(_.split("_"))
    flatMapDS.foreachRDD(rdd => {
      val spark = SparkSession.builder.config(rdd.sparkContext.getConf).getOrCreate()
      import spark.implicits._
      val valueDF: DataFrame = rdd.toDF("word")
      valueDF.createOrReplaceTempView("table")
      val sql: String =
        """
          select word,count(*) as counts from table
          group by word
          order by counts desc
        """.stripMargin
      val resultDF: DataFrame = spark.sql(sql)
      resultDF.show()
     // resultDF.foreach(println(_))
    })

    //3.关闭启动ssc
    ssc.start()
    ssc.awaitTermination()
    ssc.stop(true, true)
  }

}
