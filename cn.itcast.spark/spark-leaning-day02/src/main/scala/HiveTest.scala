import org.apache.spark.sql.SparkSession

object HiveTest {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .appName("SparkRemoteHiveTable")
      .master("local[*]")
      // 指定Hive MetaStore服务地址--hive-site.xml中配置
      .config("hive.metastore.uris", "thrift://node1.itcast.cn:9083")
      // TODO: 表示集成Hive，读取Hive表的数据
      .enableHiveSupport()
      .getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    //执行SQL
      spark.sql("show databases").show()
    spark.sql("use  lianxi").show()
   spark.sql("show tables").show()

  }

}
