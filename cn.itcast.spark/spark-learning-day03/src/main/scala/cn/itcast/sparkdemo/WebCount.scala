package cn.itcast.sparkdemo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/*4. 	第四章 通过Spark实现点击流日志分析案例
  4.1 	访问的pv
  4.2 	访问的uv
  4.3 	访问的topN
*/
object WebCount {
  def main(args: Array[String]): Unit = {
    //1.创建连接
    val conf: SparkConf = new SparkConf().setAppName("WebCount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    //2.读取文件获取RDD
    val lineRDD: RDD[String] = sc.textFile("./datas/input/access.log")
    //3.进行pv统计
    val pv: Long = lineRDD.count()
    //3.2.打印PV统计结果
    println(s"pv统计结果为${pv}")
    //4.进行UV统计
    val ipRDD: RDD[String] = lineRDD.map(line => {
      val linewords: Array[String] = line.split(" ")
      linewords(0)
    })
    val uv: Long = ipRDD.distinct().count()
    //4.2答应UV统计结果
    println(s"uv的统计结果为${uv}")
    println("*" * 20)
    //5.进行访问的topN的统计
    val sourceRDD: RDD[(String, Int)] = lineRDD.map(line => {
      val linewords2: Array[String] = line.split(" ")
      if(linewords2.length>10){(linewords2(10), 1)
      }else{
        (null,1)
      }
    })
    val resultRDD: RDD[(String, Int)] = sourceRDD.reduceByKey(_ + _)
    val tuples: Array[(String, Int)] = resultRDD.sortBy(_._2,ascending = false).take(5)
    //5.2topN统计结果的打印
    tuples.foreach(println(_))
    //6.关闭连接
    sc.stop()
  }

}
