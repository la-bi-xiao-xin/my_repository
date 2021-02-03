package cn.itcast.scala
/*案例
	定义一个样例类CasePerson，属性包括姓名name，年龄age。
	用免new的方式直接创建一个对象
*/
object Demo28 {
case class CasePerson(name:String,age:Int)

  def main(args: Array[String]): Unit = {
    val per = CasePerson("张三",20)
    println(per)
  }
}
