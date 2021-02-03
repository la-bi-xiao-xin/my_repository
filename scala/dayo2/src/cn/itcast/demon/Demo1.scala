package cn.itcast.demon

object Demo1 {
  class Person(){
    var sex = "男"
    var name:String="周仁成"
    var age:Int=25
    def sayHello(): Unit ={
      print("我要学好Scala")
    }
  }

  def main(args: Array[String]): Unit = {
    val person = new Person
    println(person.name,person.age)
    person.sayHello()
  }
}
