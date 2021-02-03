package cn.itcast

import cn.itcast
import cn.itcast.change01.Person
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
case class Person(id:Int,name:String,age:Int)
object Demo02 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("Demo02")
      .master("local[*]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\people1.txt")
    val mapRDD: RDD[Array[String]] = fileRDD.map(_.split(" "))
    val value: RDD[(Int, String, Int)] = mapRDD.map(array => {
      (array(0).toInt, array(1), array(2).toInt)
    })
    value
    val personDF: DataFrame = value.toDF("id","name","age")
    personDF.show()
  }

}
