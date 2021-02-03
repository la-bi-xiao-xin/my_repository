
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object TowSourceDataJoin {
  def main(args: Array[String]): Unit = {
    //1-准备SparkStreaming上下文环境
    val conf: SparkConf = new SparkConf().setAppName("TowSourceDataJoin").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc, Seconds(15))
    //2-使用ssc接受socket的第一个数据源
    val value1DS: ReceiverInputDStream[String] = ssc.socketTextStream("node1.itcast.cn",9999)
    //3-使用ssc接受socket的第二个数据源
    val value2DS: ReceiverInputDStream[String] = ssc.socketTextStream("node1.itcast.cn",9998)
    //4-使用union操作完成两个socket数据源的join操作
    val unionDS: DStream[String] = value1DS.union(value2DS)
    //5-使用flatMap扁平化
    //6-使用map转换操作
    //7-使用reduceByKey合并操作
    val resultDS: DStream[(String, Int)] = unionDS
      .flatMap(_.split("\\s+"))
      .map(x=>(x,1))
      .reduceByKey(_+_)
    resultDS.print()
    //8-ssc.print触发任务的执行
    //9-ssc.awaitTernimation等待程序结束
    ssc.start() // Start the streaming scheduler in a new thread
    ssc.awaitTermination()// Wait for the execution to stop. Any exceptions
    //10-ssc.stop()直接停止---------调整优雅停止
    ssc.stop()
  }

}
