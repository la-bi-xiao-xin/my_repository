import java.lang

import com.typesafe.scalalogging.Logger
import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Try

/*
* 1.分析csv文件格式,如何解析csv文件
*
* 2. 统计不同分类Youtube视频的喜欢人数、不喜欢人数
*
* */
object RddAnalysis {
  def main(args: Array[String]): Unit = {

    val logger = Logger(this.getClass)


    //1.获取sparkConf,配置运用名称,执行模式
    val conf: SparkConf = new SparkConf
    conf.setAppName(this.getClass.getSimpleName).setMaster("local[*]")

    //2.获取sparkcore上下文对象
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //3.读取csv文件,获取csv文件的RDD
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\jdbc_demo\\sparkSql\\data\\USvideos.csv")
    // fileRDD.take(10).foreach(println(_))

    //4.统计视频的喜欢人数和不喜欢人数
    //4.1创建计数器
    val accumulator: LongAccumulator = sc.longAccumulator("accumulator")
    //4.2过滤第一行,csv文件第一行是标题行,先为每行加上行号,然会过滤行号为1的行
    val fileFilterFirstLineRDD: RDD[(lang.Long, String)] = fileRDD.map(line => {
      accumulator.add(1)
      (accumulator.value, line)
    }).filter(x => {
      x._1 != 1
    })
    //fileFilterRDD.take(5).foreach(println(_))
    //4.3过滤非法的数据
    val unit: RDD[(lang.Long, String)] = fileFilterFirstLineRDD.filter(line => {
      val strings: Array[String] = line._2.split(",")
      val str7: Try[Long] = scala.util.Try(strings(8).toLong)
      val str8: Try[Long] = scala.util.Try(strings(9).toLong)
      if (str7.isFailure || str8.isFailure) {
        false
      } else {
        true

      }
    })

    //4.4 读取三个字段（视频分类、喜欢的人数、不喜欢的人数
    val resultRDD: RDD[(String, Long, Long)] = unit
      .map(_._2)
      .map(line => {
        val fileds: Array[String] = line.split(",")
        (fileds(3), fileds(8).toLong, fileds(9).toLong)
      })
      .groupBy(_._1)
      .map(t => {

        val result = t._2.reduce((r1, r2) => {
          (r1._1, r1._2 + r2._2, r1._3 + r2._3)
        })
        result
      })


    //resultRDD.take(5).foreach(println(_))
    resultRDD.saveAsTextFile("F:\\idea_project\\jdbc_demo\\sparkSql\\data\\out\\resultCount")

    logger.info("数据计算结果保存在F:\\idea_project\\jdbc_demo\\sparkSql\\data\\out\\resultCount")


    //5.关闭sparkcore上下文
    sc.stop()

  }
}
