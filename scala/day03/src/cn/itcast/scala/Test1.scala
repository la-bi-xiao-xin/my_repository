package cn.itcast.scala

object Test1 {
  class Person(name:String,age:Int) {
    def eat()={
      Person.noeat()
    }
  }
  object Person{
    val sex:String="nv"
    def noeat(): Unit ={
      println("吃的不是饭")
    }
  }

  def main(args: Array[String]): Unit = {
    val person = new Person("张三",20)
    person.eat()
  }
}
