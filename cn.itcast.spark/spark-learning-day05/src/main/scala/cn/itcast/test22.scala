package cn.itcast

import org.apache.commons.lang3.StringUtils
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.{DataFrame, SparkSession}

object test22 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("Demo02")
      .master("local[*]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    val fileRDD: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\testdata.txt")
    val mapRDD: RDD[Array[String]] = fileRDD.map(_.split(" "))
    val value1: RDD[(String, String)] = mapRDD.map(array => {
      (array(0), array(1))
    })


    val newDF: DataFrame = value1.toDF("id","co1")

    val fileRDD2: RDD[String] = sc.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\testdata2.txt")
    val mapRDD2: RDD[Array[String]] = fileRDD2.map(_.split(" "))
    val value2: RDD[(String, String)] = mapRDD2.map(array => {
      (array(0), array(1))
    })

    //

    val oldDF: DataFrame = value2.toDF("id","co2")


    newDF.show()
    oldDF.show()


    val merge: UserDefinedFunction = spark.udf.register("merge", (newDF: String, oldDF: String) => {
      if (StringUtils.isBlank(newDF)) {
        oldDF
      } else if (StringUtils.isBlank(oldDF)) {
        newDF
      } else {
        //将新的newdf和olddf进行集合的合并，转化为set的数据结构可以实现一个userid打上相同tagsid，可以对tagsid进行去重
        (newDF.split(",") ++ oldDF.split(",")).toSet.mkString(",")
      }
    })


    val resultDF: DataFrame = newDF.join(
      oldDF, //和谁join
      newDF.col("id") === oldDF.col("id"), //join条件
      "left " //join的类型,默认是inner
    ).select(
      newDF.col("id"),
      merge(newDF.col("co1"), oldDF.col("co2")) as "tagsId"
    )
    resultDF.show(false)
     //+---+---+
    //| id|co1|
    //+---+---+
    //|  1|111|
    //|  2|222|
    //|  4|444|
    //+---+---+
    //
    //+---+---+
    //| id|co2|
    //+---+---+
    //|  1|100|
    //|  2|200|
    //|  3|300|
    //+---+---+
    //
    //+---+-------+
    //| id| tagsid|
    //+---+-------+
    //|  1|111,100|
    //|  4|    444|
    //|  2|222,200|
    //+---+-------+




    //+---+---+
    //| id|co1|
    //+---+---+
    //|  1|111|
    //|  2|222|
    //|  4|444|
    //+---+---+
    //
    //+---+---+
    //| id|co2|
    //+---+---+
    //|  1|100|
    //|  2|200|
    //|  4|300|
    //+---+---+
    //
    //+---+-------+
    //| id| tagsid|
    //+---+-------+
    //|  1|111,100|
    //|  4|444,300|
    //|  2|222,200|
    //+---+-------+

    spark.stop()
  }


}
