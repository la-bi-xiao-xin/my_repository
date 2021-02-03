package cn.itcast.scala

import cn.itcast.scala.Demo01.MsgActor.{loop, react, sender}

import scala.actors.{Actor, Future}

object Demo02 {
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
    val future: Future[Any] = MsgActor !! SendMsg("主线程呼叫","主线程id-01")

    while(!future.isSet){}
    val unit: Any = future.apply()
    println(unit.asInstanceOf[ReciveMsg])

  }
}
