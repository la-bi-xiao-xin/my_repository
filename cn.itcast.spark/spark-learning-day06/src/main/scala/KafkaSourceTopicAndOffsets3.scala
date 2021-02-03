import java.lang

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext, TaskContext}

//需求：需要获取kafka的数据和数据包含的offset在提交默认的checkpoint中

object KafkaSourceTopicAndOffsets3 {

  val kafkaParams =Map[String, Object](
    //这里指的是broker的地址，如果是单台启动kafka使用单个节点即可，如果是分布式指定多台
    "bootstrap.servers" -> "node1.itcast.cn:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "sparkkafkagroup",
    //这里的auto.offset.reset代表的是自动重置offset为latest就表示的是最新的偏移量，如果没有偏移从最新的位置开始
    "auto.offset.reset" -> "latest",
    //false表示的是手动提交offset，如果为true代表的是自动提交offset
    //这里如果是false手动提交，默认由SparkStreaming提交到checkpoint中，在这里也可以根据用户或程序员将offset偏移量提交到mysql或redis中
    "enable.auto.commit" -> (false: lang.Boolean)
  )

  def updateFunc (currentvalue:Seq[Int], historyvalue:Option[Int]) : Option[Int] = {
    var sum= currentvalue.sum+historyvalue.getOrElse(0)
    Option(sum)
  }


  def main(args: Array[String]): Unit = {

    // * 1-准备SparkStreaming环境
    val conf: SparkConf = new SparkConf()
      .setAppName("KafkaSourceTopicAndOffsets3")
      .setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc,Seconds(5))

    ssc.checkpoint("./datas/ouput/checkpointdir1")
      //将主要业务逻辑抽取成一个方法
    process(ssc)
    // * 7-ssc,start
    ssc.start()
    // * 8-ssc.awiatTermination
    ssc.awaitTermination()
    // * 9-ssc.stop(true,true)
    ssc.stop(true,true)
  }


  private def process(ssc: StreamingContext) = {
    // * 2-使用KafkaUtils方法调用createDirectStream配置三个参数得到CusumerRecord
    val inputDS: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams))

    // * 3-获取kafka得到的数据的内容和value值
    //官方获取offset的代码
    /*stream.foreachRDD { rdd =>
  val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
  rdd.foreachPartition { iter =>
    val o: OffsetRange = offsetRanges(TaskContext.get.partitionId)
    println(s"${o.topic} ${o.partition} ${o.fromOffset} ${o.untilOffset}")
  }
}*/
    inputDS.foreachRDD(rdd => {
      //获取offset
      val offsetRanges: Array[OffsetRange] = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      rdd.foreachPartition { iter =>
        val o: OffsetRange = offsetRanges(TaskContext.get.partitionId)
        println("-----------------------------offset信息-----------------------------")
        println(s"${o.topic} ${o.partition} ${o.fromOffset} ${o.untilOffset}")
      }
      println("------------------------------------------------------------------")
      //获取消费记录
      println(rdd)
      //遍历看看rdd里面有什么
      rdd.foreach(data => {
        //消费记录
        println("topic data is:", data)
        //(topic data is:,ConsumerRecord(topic = sparkafka, partition = 0, offset = 99, CreateTime = 1602764049228, serialized key size = -1, serialized value size = 6, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = >nihao))
        println("data value is:", data.value())
        //(data value is:,>nihao)
        println("------------------------------------------------------------------")
      })


      // * 5-提交offset到默认的checkpont
      //官方代码
      /*stream.foreachRDD { rdd =>
    val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges

    stream.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
  }*/
      inputDS.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
    })

    //6.wordCount逻辑实现
    val resultDS: DStream[(String, Int)] = inputDS.flatMap(_.value()
      .split(" "))
      .map(x => (x, 1))
      .updateStateByKey(updateFunc)
    resultDS.print()
  }
}
