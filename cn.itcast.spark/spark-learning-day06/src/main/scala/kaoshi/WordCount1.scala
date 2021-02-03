package kaoshi

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
//使用IDEA编程实现SparkCore的WordCount单词统计基础，并保存在HDFS中
//注意：新建文件为words.txt，文件路径在./datas/input下面，内容如下
//Spark Flink flume hadoop
//Flink spark flume hadoop

object WordCount1 {
  def main(args: Array[String]): Unit = {

    //1.或获取sparkCore执行环境sc
    val conf: SparkConf = new SparkConf().setAppName("WordCount1").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //2.读取数据源,进行单词统计
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\words.txt")
    val reultRDD: RDD[(String, Int)] = fileRDD
      .flatMap(_.split(" "))
      .map(x => (x, 1))
      .reduceByKey(_ + _)
    reultRDD.foreach(println(_)) //测试结果是否统计
    reultRDD.saveAsTextFile("hdfs://node1.itcast.cn:8020/export/servers/data/")

    sc.stop()
  }

}
