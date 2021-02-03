import java.lang

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KakaResource2 {

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
    //1.准备SparkStreaming 环境
    val conf: SparkConf = new SparkConf().setAppName("KafkaSourcrMyTest").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc, Seconds(5))

    //2.连接Kafka获取数据
    // def createDirectStream[K, V](
    //      ssc: StreamingContext,
    //      locationStrategy: LocationStrategy,
    //      consumerStrategy: ConsumerStrategy[K, V]
    val kafkaInput: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](ssc,
      LocationStrategies.PreferConsistent,
      //def Subscribe[K, V](
      //      topics: Iterable[jl.String],
      //      kafkaParams: collection.Map[String, Object]): ConsumerStrategy[K, V]
      ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams))
    val valueDS: DStream[String] = kafkaInput.map(_.value())
    val wordsDS: DStream[String] = valueDS.flatMap(x=>(x.split(" ")))
    val resultDS: DStream[(String, Int)] = wordsDS.map(x=>(x,1)).reduceByKey(_+_)
    resultDS.print()

    //3.开启,和停止ssc
    ssc.start()
    ssc.awaitTermination()
    ssc.stop(true,true)

  }

}
