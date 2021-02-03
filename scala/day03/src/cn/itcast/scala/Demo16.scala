package cn.itcast.scala
/*示例说明
1.	创建一个Logger特质，添加一个接受一个String类型参数的log抽象方法
2.	创建一个ConsoleLogger类，继承Logger特质，实现log方法，打印消息
3.	添加main方法，创建ConsoleLogger对象，调用log方法
*/
object Demo16 {
trait  Logger{
    def log(a:String)
  }
  class ConsoleLogger extends Logger{
    override def log(msg: String): Unit = println("[INFO]:"+msg)
  }

  def main(args: Array[String]): Unit = {
    val logger = new ConsoleLogger
    logger.log("开机启动日志打印中")

  }
}
