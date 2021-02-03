package cn.itcast.scala

import cn.itcast.scala.Demo23.MsgActor.{loop, react}

import scala.actors.Actor

object Demo24 {
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
    val relyMsg: Any = MsgActor !? msg
    val str = relyMsg.asInstanceOf[String]
    println(str)

  }
}
