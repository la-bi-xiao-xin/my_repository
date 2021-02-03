package cn.itcast.sparkdemo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object test {
  def main(args: Array[String]): Unit = {
    //准备SparkConf
    val conf: SparkConf = new SparkConf().setAppName("ipLocation").setMaster("local[*]")
    //1-准备Spark的环境
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")

    val sca: RDD[Int] = sc.parallelize(1 to 100)

    val seq1 = Array(1,2,3,4,5)
    println(seq1(1))
  }
}
