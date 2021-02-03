package cn.itcast.scala

import scala.actors.Actor

/*示例说明
示例一
示例说明
	创建一个MsgActor，并向它发送一个异步无返回消息，该消息包含两个字段（message, company）
例
*/
object Demo23 {
  case class  Msg(message:String,company:String)
object MsgActor extends Actor{
  override def act(): Unit = {
    loop{
      react{
        case Msg(message,company) => println(s"MsgActor接收到消息:${message}/${company}")
      }
    }
  }
}

  def main(args: Array[String]): Unit = {
    MsgActor.start()
    MsgActor ! Msg("中国联通", "大爷，快交话费！")
  }
}
