package cn.itcast.scala
/*示例说明
	定义多个特质，然后用一个类去实现它们
	测试trait的构造顺序
步骤
1.	创建一个Logger特质，在构造器中打印"执行Logger构造器!"
2.	创建一个MyLogger特质，继承自Logger特质，，在构造器中打印"执行MyLogger构造器!"
3.	创建一个TimeLogger特质，继承自Logger特质，在构造器中打印"执行TimeLogger构造器!"
4.	创建一个Person类，在构造器中打印"执行Person构造器!"
5.	创建一个Student类，继承自Person、MyLogger、TimeLogger特质，在构造器中打印"执行Student构造器!"
6.	添加main方法，实例化Student_One类，观察输出。
*/
object Demo24 {
  trait Logger{
    println("2执行Logger构造器!")
  }
  trait MyLogger extends Logger{
    println("3执行MyLogger构造器!")
  }
  trait TimeLogger extends Logger{
    println("4执行TimeLogger构造器!")
  }
  class Person{
    println("1 执行Person构造器!")
  }
  class Student extends Person with MyLogger with TimeLogger{
    println("5执行Student构造器!")
  }

  def main(args: Array[String]): Unit = {
    val student = new Student
  }
}
/*	trait也有构造代码，但和类不一样，特质不能有构造器参数
	每个特质只有一个无参数的构造器。
	一个类继承另一个父类A、以及多个trait，当创建该类的实例时，它的构造顺序如下：
1.	执行父类A的构造器
2.	从左到右依次执行trait的构造器
3.	如果trait有父trait，先构造父trait，如果多个trait有同样的父trait，则只初始化一次
4.	执行子类构造器
*/