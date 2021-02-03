package cn.itcast.sparkSQL

object Demo01 {
  def main(args: Array[String]): Unit = {
    // TODO: 构建SparkSession实例对象，读取数据
    val spark = SparkSession.builder()
      // 设置应用名称和运行模式
      .appName(this.getClass.getSimpleName.stripSuffix("$"))
      .master("local[2]")
      // 通过装饰模式获取实例对象，此种方式为线程安全的
      .getOrCreate()

  }

}
