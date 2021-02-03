package cn.itcast.scala

object Demo13 {
  class Person {
    val name = "super"
    def getName = name
  }
  class Student extends Person {
    // 重写val字段
    //override val name: String = "child"
    // 重写getName方法
    override def getName: String = "hello, "  +  name
  }
    def main(args: Array[String]): Unit = {
      println(new Student().getName)
    }



}
