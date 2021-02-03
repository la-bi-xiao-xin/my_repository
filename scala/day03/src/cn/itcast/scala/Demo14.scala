package cn.itcast.scala
/*示例说明
1.	创建一个Person抽象类，它有一个String抽象字段WHO_AM_I
2.	创建一个Student类，继承自Person类，重写WHO_AM_I字段，初始化为学生
3.	创建一个Policeman类，继承自Person类，重写WHO_AM_I字段，初始化警察
4.	添加main方法，分别创建Student/Policeman的实例，然后分别打印WHO_AM_I
*/
object Demo14 {
  abstract class Person{
    val WHO_AM_I:String
  }
  class Student extends Person{
    override val WHO_AM_I: String = "学生"
  }
  class Policeman extends Person{
    override val WHO_AM_I: String = "警察"
  }

  def main(args: Array[String]): Unit = {
    val student = new Student
    println(student.WHO_AM_I)
    val policeman = new Policeman
    println(policeman.WHO_AM_I)
  }
}
