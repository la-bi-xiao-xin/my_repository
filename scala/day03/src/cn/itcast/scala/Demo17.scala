package cn.itcast.scala
/*示例说明
1.	创建一个MessageSender特质，添加send方法
2.	创建一个MessageReceiver特质，添加receive方法
3.	创建一个MessageWorker实现这两个特质
4.	在main中调用，分别调用send方法、receive方法
*/
object Demo17 {
trait MessageSender{
  def send
}
  trait MessageReceiver{
    def receive
  }
  class MessageWorker extends MessageSender with MessageReceiver{
    override def send: Unit = println("我是消息发送方法")

    override def receive: Unit = println("我是消息接受方法")
  }

  def main(args: Array[String]): Unit = {
    val worker = new MessageWorker
    worker.send
    worker.receive
  }
}
