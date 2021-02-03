
import java.lang

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, ConsumerStrategy, KafkaUtils, LocationStrategies, LocationStrategy}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaSource {

  var kafkaParams = Map[String, Object](
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
    //1-首先需要初始化StreamingContext，在Streamingcontext中需要制定spark
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("KafkaSource").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }

    //2-使用kafka010的source
    //ssc: StreamingContext,
    //locationStrategy: LocationStrategy,
    //consumerStrategy: ConsumerStrategy[K, V]
    //topics: Iterable[jl.String],
    //kafkaParams: collection.Map[String, Object]
    val valueInput: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Array("sparkafka"), kafkaParams))
    //valueInput这个算子不是DStream,通过value获取对应值
    val valueDS: DStream[String] = valueInput.map(_.value())
    //3-将得到DStreami的数据通过flatmap算子进行转换
    //4-将得到DStreami的数据通过map算子进行转换
    //4-将DStream经过reduceBykey的操作进行累加
    val resultDS: DStream[(String, Int)] = valueDS.flatMap(_.split("\\s+")).map(x => (x, 1)).reduceByKey(_ + _)
    //5-执行输出print
    resultDS.print()
    //6-开启Streaming的接受数据
    //ssc.start
    ssc.start()
    //7-需要配置什么时候结束
    ssc.awaitTermination()
    //ssc.awaitTermination,等待程序停止(用户点击idea上的)
    ssc.stop()
  }
}
