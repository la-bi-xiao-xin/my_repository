import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkSQLAPIStreaming {
  def main(args: Array[String]): Unit = {
    //1.准备SparkStreaming环境
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf()
        .setAppName("SparkSQLAPIStreaming")
        .setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }

    //2.读取Socket源数据,并整合SparkSQL统计数据
    val valueDS: ReceiverInputDStream[String] =
      ssc.socketTextStream("node1.itcast.cn", 9999)
    valueDS.foreachRDD(rdd => {
      val spark = SparkSession.builder.config(rdd.sparkContext.getConf).getOrCreate()
      import spark.implicits._
      val flatMapRDD: RDD[String] = rdd.flatMap(_.split(" "))
      val valueDF: DataFrame = flatMapRDD.toDF("word")
      valueDF.createOrReplaceTempView("table")
      val sql: String =
        """
select word,count(*) as counts from table
group by word
order by counts
        """.stripMargin
      val resultDF: DataFrame = spark.sql(sql)
      resultDF.show()
    })

    //3.关闭启动ssc
    ssc.start()
    ssc.awaitTermination()
    ssc.stop(true, true)
  }

}
