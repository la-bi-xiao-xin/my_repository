import java.util.Date

import MessagePackage.{RegisterSuccessMessage, WorkerHeartbeatMessage, WorkerInfo, WorkerRegisterMessage}
import akka.actor.Actor
import com.typesafe.config.ConfigFactory

import scala.collection.mutable

object MasterActor extends Actor{
  //19	在MasterActor中定义私有成员变量regWorkerMap，用来存储活着的Worker信息
  private val regWorkerMap = scala.collection.mutable.Map[String, WorkerInfo]()
  //32 重写MasterActor的preStart()方法
  override def preStart(){
    //33 读取配置的检测心跳发送时间间隔
    val `master.heartbeat.interval`: Int = ConfigFactory.load().getInt("master.heartbeat.interval")
    val `master.check.heartbeat.timeout`: Int = ConfigFactory.load().getInt("master.check.heartbeat.timeout")
    //34 定时检查心跳，过滤出来大于超时时间的Worker
    //35 如果有，则移除超时的Worker，打印它们
    //36 如果有，对现有Worker按照内存进行降序排序，打印可用Worker
    import scala.concurrent.duration._
    import context.dispatcher
    context.system.scheduler.schedule(0.seconds,`master.heartbeat.interval`.seconds){
      val stayWorkInfo: mutable.Map[String, WorkerInfo] = regWorkerMap.filter((x) => {
        if (new Date().getTime - x._2.lastHeartBeatTime > `master.check.heartbeat.timeout` * 1000) false
        else true
      })
      stayWorkInfo.values.toList.sortBy(_.mem).foreach(println(_))

    }
  }


  override def receive: Receive = {

    //二.	MasterActor中匹配到注册信息，保存Worker信息，并给Worker回复注册成功消息
    //17	MasterActor中匹配到注册信息，打印收到的信息
    case WorkerRegisterMessage(workerId:String,cpu:Int,mem:Int)  => {

      println(s"注册消息接收成功workerId:${workerId}  cpu:${cpu}  mem:${mem}"  )
      //22	向发送者回复成功注册的消息。
      sender ! RegisterSuccessMessage
      //20	将接收到的注册信息，封装到WorkerInfo样例类中，保存到regWorkerMap中
      regWorkerMap += (workerId -> WorkerInfo(workerId,cpu,mem,new Date().getTime))
    }
    //28 MasterActor收到心跳消息，打印一句话，
    //29 更新Worker最后心跳时间
    //30.	启动测试
    case WorkerHeartbeatMessage(workId, cpu, mem) => {
      println("心跳消息接收成功")
      regWorkerMap += (workId -> WorkerInfo(workId,cpu,mem,new Date().getTime))
    }
  }
}
