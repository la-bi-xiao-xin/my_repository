package cn.itcast.scala

object Demo29 {
  case class CasePerson(name:String,age:Int)

  def main(args: Array[String]): Unit = {
    val per = CasePerson("张三",20)
    println(per)
    println(per.toString)
    val per2 = CasePerson("张三",20)
    println(per equals(per2))
    val per3 = CasePerson("李四",23)
    val per4 =per3.copy(age=24)

    println(per.hashCode())
    println(per2.hashCode())
    println(per3.hashCode())
  }
}
