import KafkaSource.kafkaParams
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}

object HDFSSourceReceiver {
  def main(args: Array[String]): Unit = {

    //1-首先需要初始化StreamingContext，在Streamingcontext中需要制定spark
    val ssc: StreamingContext = {
      val conf: SparkConf = new SparkConf().setAppName("KafkaSource").setMaster("local[*]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      val ssc = new StreamingContext(sc, Seconds(5))
      ssc
    }

    //2-使用hdfs的source
    val valueInput: DStream[String] = ssc.textFileStream("hdfs://node1.itcast.cn:8020/datas/wordcount.data")

    //3-将得到DStreami的数据通过flatmap算子进行转换
    //4-将得到DStreami的数据通过map算子进行转换
    //4-将DStream经过reduceBykey的操作进行累加
    val resultDS: DStream[(String, Int)] = valueInput.flatMap(_.split("\\s+")).map(x => (x, 1)).reduceByKey(_ + _)
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
