package cn.itcast.scala
/*示例
	给一个对象添加一些额外的行为
步骤
1.	创建一个Logger特质
	添加一个log实现方法，打印参数
2.	定义一个UserService类
3.	添加main方法
	创建UserService对象，混入Logger特质
	调用log方法
*/
object Demo22 {
trait Logger{
  def log(msg:String): Unit ={
    println("[控制台]"+msg)
  }
}
  class UserService extends Logger{

  }

  def main(args: Array[String]): Unit = {
    val service = new UserService with Logger
    service.log("运行正常")
  }
}
