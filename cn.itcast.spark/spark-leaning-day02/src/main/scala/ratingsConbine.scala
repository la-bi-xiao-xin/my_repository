import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ratingsConbine {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("ratingsConbine").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    //sc.textFile("/datas/ratings-100/文件名")
    //val wholeFileRDD: RDD[(String, String)] = sc.wholeTextFiles("/datas/ratings-100",2)
    //wholeFileRDD.foreach(println(_))
    //val num: Long = wholeFileRDD.count()
    //println(num)
    val inputRDD: RDD[String] = sc
      .wholeTextFiles("/datas/ratings-100/", minPartitions = 2)
      .flatMap(tuple => tuple._2.split("\\n"))
    println(s"Partitions Number = ${inputRDD.getNumPartitions}")
    println(s"Count = ${inputRDD.count()}")

  }

}
