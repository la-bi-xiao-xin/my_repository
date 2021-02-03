package cn.itcast

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.api.java.UDF1
import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.{DataFrame, SparkSession}


case class SmallWord(word: String)

object UDFDemo {
  def main(args: Array[String]): Unit = {
    //1.获取执行环境
    val spark: SparkSession = SparkSession.builder()
      .appName("UDFDemo")
      .master("local[3]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    //2.读取文件形成RDD
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\udftestdata.txt")

    //3.将RDD结合样例类转换为DF
    val valueRDD: RDD[SmallWord] = fileRDD.map(x => new SmallWord(x))
    val valueDF: DataFrame = valueRDD.toDF("smallword")
    //4.创建映射表
    valueDF.createOrReplaceTempView("table")

    //5.注册UDF方法
    //方式一
    spark.udf.register("smallToBigger", new UDF1[String,String]() {
      @throws[Exception]
      override def call(t1: String): String = {
        t1.toUpperCase()
      }
    }, DataTypes.StringType)

    //方式二(推荐)
    spark.udf.register("smalltobig",(x:String)=>{x.toUpperCase})

    //6.使用UDF方法查询表数据
    spark.sql("select * from table").show()
    spark.sql("select smallword ,smallToBigger(smallword) as bigword from table").show()
    spark.sql("select smallword ,smalltobig(smallword) as bigword from table").show()

    //7.关闭执行环境
    spark.stop()


  }

}
