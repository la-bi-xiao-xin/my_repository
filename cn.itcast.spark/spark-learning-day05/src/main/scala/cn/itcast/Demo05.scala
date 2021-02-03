package cn.itcast

import java.util.Properties

import org.apache.spark.SparkContext
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
object Demo05 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("Demo05")
      .master("local[*]")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    import spark.implicits._
    val ratingsDS: Dataset[String] = spark.read.textFile("F:\\idea_project\\cn.itcast.spark\\datas\\input\\ml-1m\\ratings.dat")
    //ratingsDS.show() //测试 ==获取数据完成
    val ratingDF: DataFrame = ratingsDS
      .filter(x => {
        null != x && x.trim().split("::").length == 4
      })
      .mapPartitions(iter => {
        iter.map(x => {
          val Array(userId, movieId, rating, timestamp) = x.split("::")
          (userId, movieId, rating.toDouble, timestamp.toLong)
        })
      }).toDF("userId", "movieId", "rating", "timestamp")
  // ratingDF.show() //数据转换完成
//DSL方式查找
    val resultDF: Dataset[Row] = ratingDF.select($"movieId", $"rating")
      // 分组：按照电影ID，获取平均评分和评分次数
      .groupBy($"movieId")
      .agg( //
        round(avg($"rating"), 2).as("avg_rating"), //
        count($"movieId").as("cnt_rating") //
      )
      // 过滤：评分次数大于2000
      .filter($"cnt_rating" > 2000)
      // 排序：先按照评分降序，再按照次数降序
      .orderBy($"avg_rating".desc, $"cnt_rating".desc)
      // 获取前10
      .limit(10)
    //resultDF.printSchema()
    //resultDF.show(10)
    //使用SQL方式查找
     ratingDF.createOrReplaceTempView("table_view")
    val sql: String =
      """
SELECT
  movieId, ROUND(AVG(rating), 2) AS avg_rating, COUNT(movieId) AS cnt_rating
FROM
  |table_view
GROUP BY
  movieId
HAVING
  cnt_rating > 2000
ORDER BY
  avg_rating DESC, cnt_rating DESC
LIMIT
  10
    """.stripMargin

    val resultDF2: DataFrame = spark.sql(sql)
    resultDF2.show()
    resultDF2
      .write
      .mode(SaveMode.Overwrite)
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      //url: String, table: String, connectionProperties: Properties
      .jdbc("jdbc:mysql://localhost:3306/db_test", "tb_top10_movies", new Properties())

println("*"*30)
    val resultDF3: DataFrame = spark
      .read
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      //url: String, table: String, connectionProperties: Properties
      .jdbc("jdbc:mysql://localhost:3306/db_test", "tb_top10_movies", new Properties())
    resultDF3.show()

  }

}
