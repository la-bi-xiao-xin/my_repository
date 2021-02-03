import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

//统计单词出现的次数
object Demo01 {
  def main(args: Array[String]): Unit = {
    //1.构建sparkStreaming环境
    val conf: SparkConf = new SparkConf().setAppName("Demo01").setMaster("local[3]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc, Seconds(5))

    //2.读取socket源数据
    val fileDS: ReceiverInputDStream[String] = ssc.socketTextStream("node1.itcast.cn", 9999)

    //3.统计单词出现的次数
    val wordDS: DStream[String] = fileDS.flatMap(_.split(" "))
    val valueDS: DStream[(String, Int)] = wordDS.map(x => (x, 1))
    val resultDS: DStream[(String, Int)] = valueDS.reduceByKey(_+_)
    resultDS.print()

    ssc.start()
    ssc.awaitTermination()

  }

}
