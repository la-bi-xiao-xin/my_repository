import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Demo01 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("sc").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val rdd1: RDD[Int] = sc.parallelize(Seq(1, 2, 3, 4, 5, 6), 2)
    rdd1.mapPartitions((iter) => {
      iter.foreach(item => println(item))
      iter
    }).collect()
    println("*"*30)
    /*rdd1.mapPartitions((x)=>{x.foreach(y=>{y*2})
    x
    }).collect().foreach(y=>println(y))*/
    sc.parallelize(Seq(1, 2, 3, 4, 5, 6), 2)
      .mapPartitions(iter => {
        // 遍历 iter 其中每一条数据进行转换, 转换完成以后, 返回这个 iter
        // iter 是 scala 中的集合类型
        //两个分区是并行计算的，打印结果区分不出来
        iter.map(item => item * 10)
      })
      .collect()
      .foreach(item => println(item))


  }

}
