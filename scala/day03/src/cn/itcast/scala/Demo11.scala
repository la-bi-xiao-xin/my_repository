package cn.itcast.scala

/*	定义一个Person类
	定义一个Student类继承自Person类
	创建一个Student类对象，并指定它的类型为Person类型
	测试使用isInstanceOf判断该对象是否为Person类型
	测试使用getClass/classOf判断该对象是否为Person类型
	测试使用getClass/classOf判断该对象是否为Student类型
*/
object Demo11 {

  class Person

  class Student extends Person

  def main(args: Array[String]): Unit = {
    val student = new Student
    println(student.isInstanceOf[Person]) //true
    println(student.getClass==classOf[Person]) //false
    println(student.getClass==classOf[Student]) //true

  }
}
