package cn.itcast.scala

import scala.actors.Actor

/*示例说明
	创建两个Actor（ActorSender、ActorReceiver）
	ActorSender发送一个异步字符串消息给ActorReceiver
	ActorReceive接收到该消息后，打印出来
*/
object Demo22 {

  object ActorSender extends Actor{
    override def act(): Unit = {
      ActorReceiver ! "消息"
    }
  }
  object ActorReceiver extends Actor{
    override def act(): Unit = {
      receive{
        case msg:String => println(s"接收线性接收${msg}")
      }

    }
  }

  def main(args: Array[String]): Unit = {
    ActorSender.start()
    ActorReceiver.start()
  }

}
