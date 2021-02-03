import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object UpdateStateByKeyOperator {

  // def updateFunc(currentValue: Seq[Int], historyValue: Option[Int]): Option[Int] = {
  //    val result: Int = currentValue.sum + historyValue.getOrElse(0) //如果当前历史值有值直接获取，没有值赋值为0
  //    Option(result) //Some(result)
  //  }
  def updateFunc(currentValue: Seq[Int], historyValue: Option[Int]): Option[Int] = {
    val result = currentValue.sum + historyValue.getOrElse(0)
    Some(result)
  }

  def main(args: Array[String]): Unit = {
    //* 1-准备SparkStreaming上下文环境
    val conf: SparkConf = new SparkConf().setAppName("UpdateStateByKeyOperator").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc, Seconds(5))
    ssc.checkpoint("./datas/output/checkdir01")
    // * 2-使用ssc接受socket一个数据源
    val inputDS: ReceiverInputDStream[String] = ssc
      .socketTextStream("192.168.88.100", 9999)

    // * 5-使用flatMap扁平化
    val wordsDS: DStream[String] = inputDS.flatMap(_.split(" "))

    // * 6-使用map转换操作
    val valueDS: DStream[(String, Int)] = wordsDS.map(x => (x, 1))

    // * 7-使用updateStateByKey操作
    val resultDS: DStream[(String, Int)] = valueDS.updateStateByKey(updateFunc)

    // * 8-ssc.print触发任务的执行
    resultDS.print()

    // * 使用ssc.start开启程序运行
    // * 9-ssc.awaitTernimation等待程序结束
    // * 10-ssc.stop()直接停止---------调整优雅停止
    ssc.start()
    ssc.awaitTermination()
    ssc.stop(true, true)
  }

}
