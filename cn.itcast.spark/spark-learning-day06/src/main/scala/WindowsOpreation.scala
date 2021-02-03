import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object WindowsOpreation {
  def main(args: Array[String]): Unit = {
    //1.准备Sparkstream的环境
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("MapWithStateOperator").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }
    ssc.checkpoint("datas/output/checkDir3/")

    //2.读取socket源的数据,进行窗口窗口处理
    val valueDS: ReceiverInputDStream[String] =
      ssc.socketTextStream("node1.itcast.cn", 9999)
    val flatMapDS: DStream[String] = valueDS.flatMap(_.split("\\s+"))
    val mapDS: DStream[(String, Int)] = flatMapDS.map(x => (x, 1))

    val resultDD: DStream[(String, Int)] =
      mapDS.reduceByKeyAndWindow((x:Int,y:Int)=>x+y,Seconds(10),Seconds(10))

    resultDD.print()

    //3.开启,关闭ssc
    ssc.start()
    ssc.awaitTermination()
    ssc.stop(true,true)
  }

}
