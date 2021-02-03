package cn.itcast.scala
//	定义一个Person类定义一个Person类包含name属性, getName()方法，再定义一个Student类，继承自Person类
//	创建一个Student类对象实例，并设置name为“张三”
//	打印姓名
object Demo08 {
  class Person{
    var name ="父类名"
    def getName(): String ={
      this.name
    }
  }
  class Student(val age:Int) extends Person{

  }

  def main(args: Array[String]): Unit = {
    val student = new Student(20)
    println(student.getName())
  }
}
