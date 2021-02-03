package cn.itcast.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
/**
  * DESC:Spark的WordCount案例分析
  * 1-准备SparkContext的环境，用于连接MasterURL申请资源
  * 2-使用sc的读取本地文件
  * 3-将本地文件使用flatMap将数据展平
  * 4-将数据使用map转化为（word，1）的形式
  * 5-使用reduceByKey将相同key的Value进行累加
  * 6-可以将结果写入外部介质中
  * 7-关闭sparkContext
  */
object SparkWordCount {
    def main(args: Array[String]): Unit = {
    //* DESC:Spark的WordCount案例分析
      //  * 1-准备SparkContext的环境，用于连接MasterURL申请资源
    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    //  * 2-使用sc的读取本地文件
    //val fileRdd = sc.textFile("./datas/input/hello.txt")
    val fileRdd = sc.textFile("hdfs://node1.itcast.cn:8020/datas/wordcount.data")
    //  * 3-将本地文件使用flatMap将数据展平
    val flatRdd = fileRdd.flatMap((x)=>{x.split(" ")})
    //  * 4-将数据使用map转化为（word，1）的形式
    val mapRdd = flatRdd.map((x)=>{(x,1)})
    mapRdd.foreach(println(_))
    //  * 5-使用reduceByKey将相同key的Value进行累加
    val reduceRDD: RDD[(String, Int)] = mapRdd.reduceByKey((x, y)=>{x+y})
    //  * 6-可以将结果写入外部介质中
    reduceRDD.foreach(println(_))
    reduceRDD.saveAsTextFile("./datas/output/result6/")
    //  * 7-关闭sparkContext

    sc.stop()
  }
}
