package cn.itcast.scala

import scala.io.StdIn

/*需求说明
1.	从控制台输入一个单词（使用StdIn.readLine方法）
2.	判断该单词是否能够匹配以下单词，如果能匹配，返回一句话
3.	打印这句话
*/
object Demo01 {
  def main(args: Array[String]): Unit = {
    println("请输入一个单词进行匹配")
    val str = StdIn.readLine()
   val result = str match {
      case "hadoop" => "大数据分布式框架"
      case "zookeeper" => "大数据分布式协调服务框架"
      case "spark" => "大数据分布式内存计算框架"
      case _ => "未匹配"

    }
    println(result)
  }
}
