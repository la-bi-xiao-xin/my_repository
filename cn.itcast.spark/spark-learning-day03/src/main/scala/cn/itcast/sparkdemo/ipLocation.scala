package cn.itcast.sparkdemo

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * DESC:1-IP地址查询
 * 1-准备Spark的环境
 * 2-读取用户IP地址的数据(用户IP地址需要转化为Long类型，这里使用scala)
 * 3-读取基站的IP地址段数据，获取经度纬度起始ip和结束的ip
 * 4-将用户ip使用rdd的相关的操作将ip通过二分查找方法进行对比分析
 * 5-得到经度和维度的数据
 * 6-通过相同的经纬度的数据进行累加统计
 * 7-得到结果展示或保存
 */
object ipLocation {

  def ipToLong(ip: String): Long= {
    //将IP地址转为Long，这里有固定的算法
    val ips: Array[String] = ip.split("\\.")
    var ipNum: Long = 0L
    for (i <- ips) {
      ipNum = i.toLong | ipNum << 8L
    }
    ipNum
  }

  def binarySerach(ipLong: Long, ipValue: Array[(String, String, String, String)]): Long = {
    //1-定义start位置
    var start: Int = 0
    //2-定义end位置
    var end: Int = ipValue.length - 1
    while (start <= end) {
      //3-寻找middle
      var middle = (start + end) / 2
      //4-如果当前的currentIp=ipLong位于start和end之间，直接赋值
      if (ipLong >= ipValue(middle)._1.toLong && ipLong <= ipValue(middle)._2.toLong) {
        return middle
      }
      //5-如果当前的currentIp=ipLong<start，end=middle-1
      if (ipLong < ipValue(middle)._1.toLong) {
        end = middle - 1
      }
      //6-如果当前的currentIp=ipLong>end之间，start=midlle+!
      if (ipLong > ipValue(middle)._2.toLong) {
        start = middle + 1
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    //准备SparkConf
    val conf: SparkConf = new SparkConf().setAppName("ipLocation").setMaster("local[*]")
    //1-准备Spark的环境
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    sc.setCheckpointDir("datas/output/ipCheckDir1/")
    //2-读取用户IP地址的数据(用户IP地址需要转化为Long类型，这里使用scala)
    val ipRDD: RDD[String] = sc.textFile("datas/input/20190121000132.394251.http.format")
    val ipPersonRDD: RDD[String] = ipRDD.map(x => x.split("\\|")).map(x => x(1))
    //println(ipRDD.count())
    //ipValueRDD.foreach(println(_)) //125.213.101.130
    //3-读取基站的IP地址段数据，获取经度纬度起始ip和结束的ip
    val ipRangeRDD: RDD[String] = sc.textFile("datas/input/ip.txt")
    //这里需要选择的是ip.txt的2和3下标以及倒数第1和倒数第二字段进行选择，得到数据之后使用ip转化为long类型后在和当前的ip进行对比
    //也就是说每一个IP都应该和当前的ip.txt选择的数据进行对比
    //在driver中定义的ip.txt真正参与计算需要在exexutor中执行，需要将deriver端的ip.txt的数据的副本通过网络拷贝到worker的executor中
    //这里大家应该知道真正执行计算的地方是executor端
    val ipLocationRDD: RDD[(String, String, String, String)] = ipRangeRDD.map(x => x.split("\\|")).map(x => (x(2), x(3), x(x.length - 2), x(x.length - 1)))
    ipLocationRDD.checkpoint()
    //ipLocationRDD.foreach(println(_))//(3721097486,3721097486,123.81746,41.30827)
    //在广播的时候将常用的rdd转换为array，使用collect转换
    //四个参数代表的含义是：起始ip的long，结束ip的long，经度，维度
    val ipRangeBroadcast: Broadcast[Array[(String, String, String, String)]] = sc.broadcast(ipLocationRDD.collect())
    //4-将用户ip使用rdd的相关的操作将ip通过二分查找方法进行对比分析
    //ipPersonRDD是一个ip地址，通过将这个ip地址和刚才广播变量广播的ipRange进行对比二分查找
    val countRDD= ipPersonRDD.mapPartitions(iter => {
      val ipValue: Array[(String, String, String, String)] = ipRangeBroadcast.value
      iter.map(ip => {
        //1-将当前的ip转化为long类型
        val ipLong: Long = ipToLong(ip)
        //2-将long类型的ip和广播变量的ip.txt进行二分查找
        val ipIndex = binarySerach(ipLong, ipValue)
        //得到的是经度和维度，以及计数为1
        ((ipValue(ipIndex.toInt)._3, ipValue(ipIndex.toInt)._4), 1)
      }
      )
    })
    //对于比较昂贵的RDD或计算时间比较长的RDD可以先缓存起来---缓存在内存中，使用的时候直接拿过来
    countRDD.cache()
    //5-得到经度和维度的数据
    val resultRDD: RDD[((String, String), Int)] = countRDD.reduceByKey(_ + _)
    //6-通过相同的经纬度的数据进行累加统计
    //resultRDD.foreach(println(_))
    resultRDD.sortBy(_._2,ascending = false).take(5).foreach(println(_))
    //7-得到结果展示或保存
    sc.stop()
  }
}
