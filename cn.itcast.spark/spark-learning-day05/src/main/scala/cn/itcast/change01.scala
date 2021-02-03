package cn.itcast
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, LongType, StringType, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.functions._
//RDD转DS  方式一配合样例类
object change01 {
  case class Person(id:Int,naem:String,age:Int)
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .appName("test")
      .master("local[5]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\people1.txt")
    val personRDD: RDD[Person] = fileRDD.map(_.split(" ")).map(x => {
      new Person(x(0).toInt, x(1), x(2).toInt)
    })
    val personDF: DataFrame = personRDD.toDF()
    personDF.show()
    println("*"*30)
    val rdd: RDD[Row] = personDF.rdd
    rdd.collect().foreach(println(_))
    println("*"*30)
val personDS: Dataset[Person] = personRDD.toDS()
    personDS.show()
    personDS.printSchema()

    println("*$"*30)
val personDS2: Dataset[Person] = personDF.as[Person]
    personDF.printSchema()
    personDS2.show(

    )
    personDS2.printSchema()
  }

}
