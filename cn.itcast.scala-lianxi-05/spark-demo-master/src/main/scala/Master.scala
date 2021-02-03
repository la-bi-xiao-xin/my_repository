import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Master {
  def main(args: Array[String]): Unit = {

    val masterSystem = ActorSystem("MasterSystem",ConfigFactory.load())
    val masterActor = masterSystem.actorOf(Props(MasterActor),"masterActor")
    println(masterActor)
    masterActor ! "测试"
    //[akka.tcp://MasterSystem@127.0.0.1:7000]
  }

}
