import java.util.UUID

import MessagePackage.{RegisterSuccessMessage, WorkerHeartbeatMessage, WorkerRegisterMessage}
import akka.actor.{Actor, ActorSelection}
import com.typesafe.config.ConfigFactory

import scala.util.Random

object WorkerActor extends Actor {
  //workerActor ! "测试"
  //[akka.tcp://WorkerSystem@127.0.0.1:7100]
  //一.  在Worker中preStart()中向Master发送注册信息。
  //11	在WorkerActor中定义workerId cpu mem 私有变量
  private var workId:String =_
  private var cpu:Int =_
  private var mem:Int =_
  //12	随机生成workerId
  workId = UUID.randomUUID().hashCode().toString
  //13	随机生成CPU核（1、2、3、4、6、8 随机取一个）
   val cpu_list: List[Int] = (1 to 6).toList
   val random = new Random()
  cpu = random.nextInt(cpu_list.length)
  //14	随机生成内存大小（512、1024、2048、4096 随机取一个）（单位M）
  val mem_list = List(512,1024,2048,4096)
  val i: Int = random.nextInt(mem_list.length)
  mem = mem_list(i)
  //15	获得masterActor的引用（移至作为object成员变量）
  val masterActor: ActorSelection = context.system.actorSelection("akka.tcp://MasterSystem@127.0.0.1:7000/user/masterActor")
  //16	向masterActor发送注册信息
  masterActor ! WorkerRegisterMessage(workId,cpu,mem)

  override def receive: Receive = {
    case RegisterSuccessMessage => {
      println("注册成功!")
      //25 WorkerActor接收到注册成功消息后，读取配置的心跳发送时间间隔
      val `worker.heartbeat.interval`: Int = ConfigFactory.load().getInt("worker.heartbeat.interval")
      //27 定时发送心跳消息
      import scala.concurrent.duration._
      import context.dispatcher
      context.system.scheduler.schedule(0.seconds, `worker.heartbeat.interval`.seconds) {
        masterActor ! WorkerHeartbeatMessage(workId, cpu, mem)

      }

    }
  }
}
