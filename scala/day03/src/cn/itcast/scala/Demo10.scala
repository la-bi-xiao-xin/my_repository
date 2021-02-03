package cn.itcast.scala
/*示例说明
	定义一个Person类
	定义一个Student类继承自Person类
	创建一个Student类对象
	判断该对象是否为Student类型，如果是，将其转换为Student类型并打印该对象
*/
object Demo10 {
  class Person
  class Student extends  Person

  def main(args: Array[String]): Unit = {
    val student:Person = new Student
    if(student.isInstanceOf[Person]){
      student.asInstanceOf[Student]
      println(student)
    }
  }

}
