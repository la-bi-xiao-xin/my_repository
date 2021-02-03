package cn.itcast.scala
/*示例说明
	定义一个Person类，包含
	姓名字段（不可重新赋值）
	获取姓名方法
	定义一个Student类，继承Person类
	重写姓名字段
	重写获取姓名方法，返回"hello, " + 姓名
	在main方法中创建Student类的对象示例，调用它的getName方法
*/
object Demo09 {
  class Person{
    val name:String ="张三"
    def getName(person:Person):String ={ person.name }
  }
  class Student extends Person {
    override def getName(person: Person): String = "hello"+super.getName(person)
  }

  def main(args: Array[String]): Unit = {
    val student = new Student
   println(student.getName(new Person))
  }


}
