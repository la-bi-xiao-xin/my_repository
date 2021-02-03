package cn.itcast.sparkdemo

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MyipLocation {

  def ipToLong(ip: String): Long = {
    //将IP地址转为Long，这里有固定的算法
    val ips: Array[String] = ip.split("\\.")
    var ipNum: Long = 0L
    for (i <- ips) {
      ipNum = i.toLong | ipNum << 8L
    }
    ipNum
  }


  def binarySerach(ipLong: Long, ipRangeValue: Array[(String, String, String, String)]): Int = {
      //1-定义start位置
      var start: Int = 0
      //2-定义end位置
      var end: Int = ipRangeValue.length - 1
      while (start <= end) {
        //3-寻找middle
        var middle = (start + end) / 2
        //4-如果当前的currentIp=ipLong位于start和end之间，直接赋值
        if (ipLong >= ipRangeValue(middle)._1.toLong && ipLong <= ipRangeValue(middle)._2.toLong) {
          return middle
        }
        //5-如果当前的currentIp=ipLong<start，end=middle-1
        if (ipLong < ipRangeValue(middle)._1.toLong) {
          end = middle - 1
        }
        //6-如果当前的currentIp=ipLong>end之间，start=midlle+!
        if (ipLong > ipRangeValue(middle)._2.toLong) {
          start = middle + 1
        }
      }
      -1
    }

  def main(args: Array[String]): Unit = {
    //1.创建连接spark的客户端
    val conf: SparkConf = new SparkConf().setAppName("MyipLocation").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    //2.读取IP 文件并将其转换为 IP RDD
    val ipLineRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\20190121000132.394251.http.format")
    val ipRDD: RDD[String] = ipLineRDD.map(line => {
      val lineWordsArray: Array[String] = line.split("\\|")
      lineWordsArray(1)
    })
    ipRDD.take(3).foreach(println(_)) //测试 ==> 正常
    //3.读取 IP range 文件并将 其转换为 IP range RDD
    val ipRangeLineRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\ip.txt")
    val ipRangeRDD: RDD[(String, String, String, String)] = ipRangeLineRDD.map(line => {
      val ipRangeLienWordsArray: Array[String] = line.split("\\|")
      (ipRangeLienWordsArray(2), ipRangeLienWordsArray(3), ipRangeLienWordsArray(ipRangeLienWordsArray.length - 2), ipRangeLienWordsArray(ipRangeLienWordsArray.length - 1))
    })
    ipRangeRDD.take(3).foreach(println(_)) //测试 ==>正常
    val ipRangeBrodcast: Broadcast[Array[(String, String, String, String)]] = sc.broadcast(ipRangeRDD.collect())
    val ipRangeValue: Array[(String, String, String, String)] = ipRangeBrodcast.value
    //4.将IP 与 IP range 进行匹配 获取 IP 与 IP range 匹配成功的结果 RDD
    val resultRDD: RDD[((String, String), Int)] = ipRDD.mapPartitions(iter => {
      iter.map(ip => {
        val ipLong: Long = ipToLong(ip)
        val index: Int = binarySerach(ipLong, ipRangeValue)
        ((ipRangeValue(index)._3, ipRangeValue(index)._4), 1)
      })
    })

    //5.对匹配结果进行统计
    val countRDD: RDD[((String, String), Int)] = resultRDD.reduceByKey(_ + _)
    //6.打印结果
    countRDD.sortBy(x => x._2).collect().foreach(println(_))
    //7.关闭客户端
    sc.stop()
  }

}
