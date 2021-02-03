package cn.itcast.scala
/*3.	样例类
1、新建一个object类型的scala文件。
2、定义一个样例类Person，包含姓名、年龄（可变）成员变量。
3、在Main方法中创建样例类的对象实例，使用自己的姓名和年龄。
4、修改自己的年龄+1，并打印。
*/
object HomeWork2 {
  case class Person(name:String,var age:Int){

  }

  def main(args: Array[String]): Unit = {
    val person = new Person("周仁成",25)
    println(person)

    person.age=26
    println(person)
  }

}
