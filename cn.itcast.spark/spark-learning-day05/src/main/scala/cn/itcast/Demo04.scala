package cn.itcast

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object Demo04 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("Demo03")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")
    //spark.sql("show databases").show()
    spark.sql("create table if not exists student2(id int,name String,age int) row format delimited fields terminated by ','")
    spark.sql("load data local inpath './datas/input/student.csv' overwrite into table student2 ")
    spark.sql("select * from student2").show()

  }

}
