package cn.itcast.scala
/*示例说明
	编写一个日志输出工具，分别有info、warn、error三个级别的日志输出
	日志输出的方式要求设计为可扩展的，例如：可以输出到控制台、将来也可以扩展输出到文件、数据库等
实现步骤
1.	添加一个Logger特质
	添加一个log抽象方法
	添加一个info、warn、error具体方法，这几个方法调用log抽象方法。就像信用卡提前透支，此处提前使用log方法，log()的具体内容留给以后再去实现。
2.	创建ConsoleLogger类，继承Logger特质，实现log方法，打印入参即可
3.	添加main方法
	创建ConsoleLogger类对象
	分别调用info、warn、error方法输出日志
*/
object Demo21 {
trait Logger {
  def log(msg:String):String
  def info(msg:String): Unit ={
    println("[INFO]"+log(msg))
  }
  def warn(msg:String): Unit ={
    println("[WARN]"+log(msg))
  }
  def error(msg:String): Unit ={
    println("[ERROR]"+log(msg))
  }

}
  class ConsoleLogger extends Logger{
    override def log(msg: String): String = msg
  }

  def main(args: Array[String]): Unit = {
    val logger = new ConsoleLogger
    logger.error("出错了")
    logger.warn("警告")
    logger.info("运行中")
  }
}
