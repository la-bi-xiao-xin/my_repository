import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object socketScourceApp {
  def main(args: Array[String]): Unit = {

    //1-首先启动nc -lk 9999指定端口号发送数据
    //2-初始化SparkSession作为结构化流数据的入口
    val spark: SparkSession = SparkSession.builder().appName("socketScourceApp").master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._
    //3-spark.readStream.format("console").option().optiom().load()
    val df1: DataFrame = spark.readStream.format("socket").option("host", "node1.itcast.cn").option("port", 9999).load()
    //4-执行Query计算：通过SparkSQL的算子实现Query的计算
    df1.printSchema() //value: string (nullable = true) 字段的类型，对于df来讲数据是没有泛型的，需要使用as[String]转换、
    val flatMapDS: Dataset[String] = df1.as[String].flatMap(_.split(" "))
    //flatMapDS:
    val resultDS: Dataset[Row] = flatMapDS.groupBy("value").count().orderBy($"count".desc)
    //sql
    //5-将结果写出到console:df.writeStream.format("console").save(path)
    val query: StreamingQuery = resultDS.writeStream
      .format("console") //输出的格式
      .outputMode("Complete") //数据的输出模式
      .trigger(Trigger.ProcessingTime(0)) //代表的是按照数据处理时间也就是结构化流的微批次处理的引擎，还有一个引擎是连续数据处理
      //6-spark.start开启应用程序的执行
      .start()
    //7-spark.awaitTermination结束应用程序，等待异常发生程序结束
    query.awaitTermination()
    //8-停止spark的上下文环境
    spark.stop()
  }
}
