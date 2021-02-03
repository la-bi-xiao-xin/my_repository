package cn.itcast.scala
/*示例说明
1.	创建一个Person抽象类，并添加一个sayHello抽象方法
2.	添加main方法，通过创建匿名内部类的方式来实现Person
3.	调用匿名内部类对象的sayHello方法
*/
object Demo15 {
abstract  class Person{
  def sayHello
}

  def main(args: Array[String]): Unit = {
   val  person = new Person {
      override def sayHello: Unit = println("你好 ,我是匿名内部类创建的对象")
    }
    person.sayHello
  }
}
