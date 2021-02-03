package cn.itcast.scala
/*示例说明
	定义一个特质，继承自一个class
步骤
1.	创建一个MyUtils类，定义printMsg方法，打印传入的信息
2.	创建一个Logger特质，继承自MyUtils，定义log方法, 打印Logger:传入的信息
3.	创建一个Person类，添加name字段
	继承Logger特质
	定义sayHello方法，调用log方法
4.	添加main方法，创建一个Person对象，调用sayHello方法
*/
object Demo25 {
 class MyUtils{
   def printMsg(msg:String): Unit ={
     println(msg)
   }
 }
  trait Logger extends MyUtils {
    def log(msg:String) = printMsg("Logger:" + msg)
  }
class Person extends Logger {
  def sayHello: Unit ={
    log("你好")
  }
}

  def main(args: Array[String]): Unit = {
    val person = new Person
    person.sayHello
  }
}
