package cn.itcast.spark.socketsource

import org.apache.spark.streaming.dstream.{DStream, MapWithStateDStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, State, StateSpec, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * DESC:
  * 1-准备SparkStreaming上下文环境
  * 2-使用ssc接受socket一个数据源
  * 5-使用flatMap扁平化
  * 6-使用map转换操作
  * 7-使用updateStateByKey操作
  * 8-ssc.print触发任务的执行
  * 使用ssc.start开启程序运行
  * 9-ssc.awaitTernimation等待程序结束
  * 10-ssc.stop()直接停止---------调整优雅停止
  */
object MapWithStateOperator {

  def main(args: Array[String]): Unit = {
    //1-准备SparkStreaming上下文环境
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("MapWithStateOperator").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }
    ssc.checkpoint("datas/output/checkDir3/")
    //2-使用ssc接受socket一个数据源
    val valueDS: ReceiverInputDStream[String] = ssc.socketTextStream("node1.itcast.cn", 9999)
    //5-使用flatMap扁平化
    val flatMapDS: DStream[String] = valueDS.flatMap(_.split("\\s+"))
    //6-使用map转换操作
    val mapDS: DStream[(String, Int)] = flatMapDS.map(x => (x, 1))
    //7-使用updateStateByKey操作
    //updateFunc: (Seq[V], Option[S]) => Option[S]
    //在scala中option的返回值是some和none
   // val result: MapWithStateDStream[String, Int, Int, Any] = mapDS
     // .mapWithState(StateSpec.function(spec).timeout(Seconds(30)))
    val result: MapWithStateDStream[String, Int, Int, Any] = mapDS.mapWithState(StateSpec.function(spec).timeout(Seconds(30)))
    //8-ssc.print触发任务的执行
    result.print()
    //使用ssc.start开启程序运行
    ssc.start()
    //9-ssc.awaitTernimation等待程序结束
    ssc.awaitTermination()
    //10-ssc.stop()直接停止---------调整优雅停止
    ssc.stop(true, true)
  }

  //定义一个函数，该函数有三个类型word: String, option: Option[Int], state: State[Int]
  //其中word代表统计的单词，
  // option代表的是历史数据（使用option是因为历史数据可能有，也可能没有，如第一次进来的数据就没有历史记录），
  // state代表的是返回的状态
  val spec = (word: String, option: Option[Int], state: State[Int]) => {
    //这里需要判断状态是否可用，超时
    if (state.isTimingOut()) {
      println(word + "is time out!")
    } else {
      //这里需要将option代表的历史值和state(保存当前的变化状态)进行累加得到sum
      //当前的状态有值的直接获取，如果没有值的就赋值为0，这里适合于用getOrElse方法
      val sum: Int = option.getOrElse(0) + state.getOption().getOrElse(0)
      // 单词和该单词出现的频率/ 获取历史数据，当前值加上上一个批次的该状态的值
      val result: (String, Int) = (word, sum)
      state.update(sum)
      //最后以单词和出现的次数返回
      result
    }
  }
}