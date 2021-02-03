package cn.itcast.scala

import scala.actors.Actor

/*示例说明
	1 定义发送消息样例类该消息包含两个字段（id、message）和回复消息样例类包含两个字段（message、name）
	2 定义MsgActor，他可以接收消息，并回复一个消息
	3 启动MsgActor
	4 main线程向MsgActor发送一个同步消息，并等待接收回复的消息
	5 将回复的消息转换成精确的类型
	6 打印回复消息
*/
object Demo01 {
  case class SendMsg(id:String,message:String)
  case class ReciveMsg(message:String,name:String)
  object MsgActor extends Actor{
    override def act(): Unit = {
      loop{
        react{
          case SendMsg(id:String,message:String) => {
            println(s"MsgActor接收到来自${id}的消息${message}")
            sender ! ReciveMsg("消息已经收到","MsgActor")
          }
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    MsgActor.start()
    val replayMsg: Any = MsgActor !? SendMsg("主线程呼叫","主线程id-01")
    val msg = replayMsg.asInstanceOf[ReciveMsg]
    println(msg)
  }
}
