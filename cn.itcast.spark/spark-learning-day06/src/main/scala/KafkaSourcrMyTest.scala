import java.lang

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


object KafkaSourcrMyTest {

  def main(args: Array[String]): Unit = {
    //1.准备SparkStreaming 环境
    val conf: SparkConf = new SparkConf().setAppName("KafkaSourcrMyTest").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc, Seconds(5))

    //2.连接kafka,获取数据
    val kafkaResource: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams))

    val valueDS: DStream[String] = kafkaResource.map(_.value())

    val wordsDS: DStream[String] = valueDS.flatMap(_.split("_"))
    val countDS: DStream[(String, Int)] = wordsDS.map(x => (x, 1))
    val resultDS: DStream[(String, Int)] = countDS.reduceByKey(_ + _)
    resultDS.print()

    //3.启动,关闭
    ssc.start()
    ssc.awaitTermination()
    ssc.stop(true, true)
  }

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
}
