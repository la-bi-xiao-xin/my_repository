package cn.itcast.scala



/*示例说明
1.	创建一个Logger特质，添加一个log抽象方法
2.	创建一个ConsoleLogger的object，继承Logger特质，实现log方法，打印消息
3.	编写main方法，调用ConsoleLogger的log方法
*/
object Demo18 {
  trait Logger {
    def log(msg:String)
  }
  object ConsoleLogger extends Logger{
    override def log(msg: String): Unit = println(msg)
  }

  def main(args: Array[String]): Unit = {
    //
   ConsoleLogger.log("宕机中")
  }

}
