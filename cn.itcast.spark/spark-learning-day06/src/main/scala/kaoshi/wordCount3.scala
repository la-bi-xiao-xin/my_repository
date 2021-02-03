package kaoshi

import java.lang

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object wordCount3 {

  val kafkaParams = Map[String, Object](
    //这里指的是broker的地址，如果是单台启动kafka使用单个节点即可，如果是分布式指定多台
    "bootstrap.servers" -> "node1.itcast.cn:9092,node2.itcast.cn:9092,node3.itcast.cn:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "sparkkafkagroup",
    //这里的auto.offset.reset代表的是自动重置offset为latest就表示的是最新的偏移量，如果没有偏移从最新的位置开始
    "auto.offset.reset" -> "latest",
    //false表示的是手动提交offset，如果为true代表的是自动提交offset
    //这里如果是false手动提交，默认由SparkStreaming提交到checkpoint中，在这里也可以根据用户或程序员将offset偏移量提交到mysql或redis中
    "enable.auto.commit" -> (false: lang.Boolean)
  )

  def main(args: Array[String]): Unit = {
    //1.获取sparkStreaming执行环境
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("KafkaSource").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }

    //2.从kafka中读取数据,统计
    val inputDS: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams))
    //.手动提交offset
    inputDS.foreachRDD(rdd=>{
      val offsetRanges: Array[OffsetRange] = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      inputDS.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
    })

    val lineDS: DStream[String] = inputDS.map(_.value())
    val resultDS: DStream[(String, Int)] = lineDS
      .flatMap(_.split("\\s+"))
      .map(x => (x, 1)).reduceByKey(_ + _)

    resultDS.print()
    //

    ssc.start()

    ssc.awaitTermination()

    ssc.stop(true,true)
  }

}
