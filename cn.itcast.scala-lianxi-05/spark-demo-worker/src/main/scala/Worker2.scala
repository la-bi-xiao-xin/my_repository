import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Worker2 {
  def main(args: Array[String]): Unit = {
    val workerSystem = ActorSystem("WorkerSystem", ConfigFactory.load("application2.conf"))
    val workerActor = workerSystem.actorOf(Props(WorkerActor),"workerActor")
    //测试用

  }

}
