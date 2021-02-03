import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount2 {
  //* 需求：如果基于当前的WordCount的统计结果完成TopK的选择
  //* 解决办法：

  //* 步骤：

  def main(args: Array[String]): Unit = {
    //  * 1-准备SparkContext环境
    val conf: SparkConf = new SparkConf().setAppName("WordCount2").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")
    //  * 2-读取文件
    val fileRdd: RDD[String] = sc.textFile("/datas/wordcount.data")
    //  * 3-对文件使用flatMap扁平化
    val flatMapRdd: RDD[String] = fileRdd.flatMap((x)=>{x.split("\\s+")})
    //  * 4-对数据进行map的转化(word,1)
    val mapRdd: RDD[(String, Int)] = flatMapRdd.map((x)=>{(x,1)})
    //  * 5-对数据进行reduceBykey(word,5)
    val reduceRdd: RDD[(String, Int)] = mapRdd.reduceByKey((x,y)=>{x+y})
    reduceRdd.foreach(println(_))
    println("*"*20)
    //  * 6-使用上述的方法进行排序
    //  * 1-sortBy----既可以根据Key也可以根据Value进行排序
   /* val resultRdd: RDD[(String, Int)] = reduceRdd.sortBy(x => x._2,ascending = false)
    resultRdd.foreach(println(_))
    println("1"*20)*/
    //  * 2-SortByKey---能够根据key
    val resultRdd1: RDD[(String, Int)] = reduceRdd.sortByKey(ascending = false)
    resultRdd1.foreach(println(_))

    val resultRdd3: RDD[(Int, String)] = reduceRdd.map(x => x.swap).sortByKey(ascending = false)
   // println("*"*20)
    //  * 3-top()
  /*  val resultRdd2: Array[(String, Int)] = reduceRdd.top(3)(Ordering.by((x)=>{x._2}))
   resultRdd2.foreach(println(_))*/
    //  * 7-得到结果打印或输出保存到其他路径
   // resultRdd3.saveAsTextFile("./datas/output/result3")
    resultRdd3.foreach(println(_))
    sc.stop()
  }
}
