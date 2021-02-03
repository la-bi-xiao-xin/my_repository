import org.apache.spark.{SparkConf, SparkContext}

object test {
  def main(args: Array[String]): Unit = {
    //* DESC:Spark的WordCount案例分析
    //  * 1-准备SparkContext的环境，用于连接MasterURL申请资源
    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    //  * 2-使用sc的读取本地文件
    val fileRdd = sc.textFile("hdfs://192.168.10.20:8020/datas/wordcount.data")
    fileRdd.collect().foreach(println(_))
  }

}
