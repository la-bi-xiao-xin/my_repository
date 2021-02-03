import java.lang

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext, TaskContext}
import util.OffsetUtil

import scala.collection.mutable

//需求：需要获取kafka的数据和数据包含的offset在提交默认的checkpoint中

object _05KafkaSourceOffsetToMySQL {

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

  val CHKDIR = "datas/output/checkDir7/"

  def main(args: Array[String]): Unit = {
    //使用驱动容错机制
    val ssc: StreamingContext = StreamingContext.getActiveOrCreate(CHKDIR, () => {
      // * 1-准备SparkStreaming环境
      val conf: SparkConf = new SparkConf()
        .setAppName("_05KafkaSourceOffsetToMySQL")
        .setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc.checkpoint(CHKDIR)

      //犯错的坑：process应该放在数据streamingcontext第一次初始化的地方，因为需要通过驱动器容错
      //而checkpoint中需要存放meta checkpoint和data checkpoint
      //3-处理接受的数据并统计以及打印offset的过程

      //将主要业务逻辑抽取成一个方法
      process(ssc)
      ssc
    })

    ssc.checkpoint(CHKDIR)
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
    // 1-首先从MySQL中获取Offset
    val offsetmap: mutable.Map[TopicPartition, Long] =
      OffsetUtil.getOffsetMap("sparkkafkagroup","sparkafka")
    // 2-如果offset在MySQL中存在，需要使用KafkaUtils.createDirectStream(需要传入mysql得到的offset)调用已经存在的Offset继续进行计算
    var inputDS: InputDStream[ConsumerRecord[String, String]]=null
    if(offsetmap.size>0){
      inputDS =  KafkaUtils.createDirectStream[String, String](ssc,
        LocationStrategies.PreferConsistent,
        //topics: ju.Collection[jl.String],
        //kafkaParams: ju.Map[String, Object]
        ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams,offsetmap))
    }else{
      // * 2-使用KafkaUtils方法调用createDirectStream配置三个参数得到CusumerRecord
       inputDS = KafkaUtils.createDirectStream[String, String](ssc,
        LocationStrategies.PreferConsistent,
        ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams))
    }
    // 3-如果offset在MySQL中不存在，直接使用KafkaUtils.createDirectStream默认的方法执行offset的提交


    // * 3-获取kafka得到的数据的内容和value值
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

      // * 5-提交offset到mysql中

      //inputDS.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
      OffsetUtil.saveOffsetRanges("sparkkafkagroup",offsetRanges)
    })

    //6.wordCount逻辑实现
    val resultDS: DStream[(String, Int)] = inputDS.flatMap(_.value()
      .split(" "))
      .map(x => (x, 1))
      .updateStateByKey(updateFunc)
    resultDS.print()
  }
}
