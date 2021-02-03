package cn.itcast.scala
/*需求
	定义一个Person样例类，包含姓名和年龄成员变量
	创建样例类的对象实例（"张三"、20），并打印它
*/
object Demo26 {
  case class Person(name:String,age:Int)

  def main(args: Array[String]): Unit = {
    val person = new Person("张三",25)
    println(person)
  }
}
