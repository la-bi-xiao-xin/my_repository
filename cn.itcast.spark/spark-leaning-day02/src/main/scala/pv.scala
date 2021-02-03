import org.apache.spark.{SparkConf, SparkContext}

object pv {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("pv").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARM")
    sc.textFile("/datas/")
  }

}
