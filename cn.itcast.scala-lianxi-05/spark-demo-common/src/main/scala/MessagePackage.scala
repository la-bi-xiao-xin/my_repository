object MessagePackage {
  //9 在spark-common中创建MessagePackage类，用来定义公共的样例类
  //10 定义注册消息的样例类WorkerRegisterMessage（workerid、cpu核数、内存大小）
  case class WorkerRegisterMessage(var workerId:String,var cpu:Int,var mem:Int )
  //18	在公共包中定义Worker信息的样例类WorkerInfo
  case class WorkerInfo(workerId: String, cpu: Int, mem: Int, lastHeartBeatTime: Long)
  //21	在公共包中定义成功注册的消息样例对象RegisterSuccessMessage
  case object RegisterSuccessMessage
  //26 在公共包中定义心跳消息样例类
  case class WorkerHeartbeatMessage(workerId: String, cup: Int, mem: Int)
}
