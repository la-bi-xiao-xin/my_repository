import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount2 {
  def main(args: Array[String]): Unit = {
    //1.获取conf
    val conf = new SparkConf()
    conf.setMaster("local[*]").setAppName(getClass.getSimpleName)

    //2.获取sparks上下文对象
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //3.使用spark读取文件获取RDD
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\jdbc_demo\\spark_demo\\data\\wordcount.txt")

    //4.转换RDD
    val valueRRDD: RDD[String] = fileRDD.flatMap(line => {
      line.split("\\s+")
    })
    val value2RDD: RDD[(String, Int)] = valueRRDD.map(word => {
      (word, 1)
    })
    val resultRDD: RDD[(String, Int)] = value2RDD.reduceByKey(_ + _)

    //5.打印计算结果,保存结果
    //println(resultRDD)
    //  resultRDD.foreach(println(_))
    // resultRDD.saveAsTextFile("F:\\idea_project\\jdbc_demo\\spark_demo\\data\\out\\wordCountResult")

    //用spark读取数据只需要saveAsTextFile指定结果目录
    val partitions: Int = resultRDD.getNumPartitions
    println(partitions)
    val resultRDD2: RDD[String] = sc.textFile("F:\\idea_project\\jdbc_demo\\spark_demo\\data\\out\\wordCountResult")
    resultRDD2.foreach(println(_))

    //6.释放资源
    sc.stop()
  }


}
