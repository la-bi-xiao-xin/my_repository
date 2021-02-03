package cn.itcast.scala

import cn.itcast.scala.Demo24.MsgActor.{loop, react, sender}

import scala.actors.{Actor, Future}

/*示例说明
	创建一个MsgActor，并向它发送一个异步有返回消息，该消息包含两个字段（id、message）
	MsgActor回复一个消息，该消息包含两个字段（message、name）
	打印回复消息
*/
object Demo25 {
  case class  Msg(message:String,company:String)
  object MsgActor extends Actor{
    override def act(): Unit = {
      loop{
        react{
          case Msg(message,company) => println(s"MsgActor接收到消息:${message}/${company}")
            sender ! "不想交"
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    MsgActor.start()
    val msg = Msg("中国联通", "大爷，快交话费")
    val future: Future[Any] = MsgActor !! msg
   if(!future.isSet){}
    val replyMsg: Any = future.apply()
    val str = replyMsg.asInstanceOf[String]
    println(str)
  }
}
