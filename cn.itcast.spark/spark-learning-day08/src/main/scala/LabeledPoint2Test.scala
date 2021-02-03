import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object LabeledPoint2Test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("testLabeledPoint2") //建立本地环境变量
    val sc = new SparkContext(conf) //建立Spark处理
    val mu: RDD[LabeledPoint] = MLUtils.loadLibSVMFile(sc, "F:\\idea_project\\cn.itcast.spark\\datas\\input\\a.txt") //读取文件
    mu.foreach(println)
    //文件内容
    //2 1:5 2:8 3:9
    //1 1:7 2:6 3:7
    //1 1:3 2:2 3:1
    //打印内容
    //(2.0,(3,[0,1,2],[5.0,8.0,9.0]))
    //(1.0,(3,[0,1,2],[7.0,6.0,7.0]))
    //(1.0,(3,[0,1,2],[3.0,2.0,1.0]))

  }

}
