package cn.itcast.scala

import java.text.SimpleDateFormat

/*示例说明
通过trait来实现一个日志输出工具，该日志工具可以自动添加日志的日期
步骤
1.	创建Logger特质
	定义一个具体的SimpleDateFormat字段，用来格式化日期（显示到时间）
	定义一个抽象字段TYPE，用于表示日志的级别
	创建一个log抽象方法，用于输出日志
2.	创建ConsoleLogger类，重写TYPE抽象字段（和log方法）
3.	添加main方法
	创建ConsoleLogger类对象
	调用log方法
*/
object Demo20 {
trait Logger{
  private val format = new SimpleDateFormat("yyyy-MM-dd")
  val TYPE:String
  def log(msg:String)
}
  class ConsoleLogger extends Logger{
    override val TYPE: String = "[ERROR]"
    override def log(msg: String): Unit = println(TYPE+ msg)

  }

  def main(args: Array[String]): Unit = {
    val logger = new ConsoleLogger
    logger.log("异常消息")
  }
}
