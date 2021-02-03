package cn.itcast.scalcea

import cn.itcast.scalcea.Demo19.Logger

/*示例说明
1.	定义一个Logger特质，添加具体的log方法
2.	定义一个UserServi类，继承Logger特质
	添加add方法，在add方法中调用log方法，打印"添加用户"
3.	添加main方法
	创建UserService对象实例
	调用add方法
*/
object Demo19 {

  trait Logger {
    def log(msg: String): Unit ={
      println("打印:"+ msg)
    }
  }
class UserServer extends Logger {
 def add: Unit ={
   super.log("死机")
 }
}
  def main(args: Array[String]): Unit = {
    val server = new UserServer
    server.add
  }
}
