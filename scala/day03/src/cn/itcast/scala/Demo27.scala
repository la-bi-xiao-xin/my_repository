package cn.itcast.scala
/*需求
	定义一个Person样例类，包含姓名和年龄(可变)成员变量
	创建样例类的对象实例（"张三"、20）
	修改张三的年龄为23岁，并打印
*/
object Demo27 {
case class Person(name:String,var age:Int)

  def main(args: Array[String]): Unit = {
    val per = new Person("张三",20)
    println(per)
    per.age=23
    println(per)
  }
}
