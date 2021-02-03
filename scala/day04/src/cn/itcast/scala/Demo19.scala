package cn.itcast.scala
/*示例说明
	定义一个Pair泛型类
	Pair类包含两个字段，而且两个字段的类型不固定
	创建不同类型泛型类对象，并打印
*/
object Demo19 {
class Pair[T](var name:T,var age:T)

  def main(args: Array[String]): Unit = {
    val pairList = List(
      Pair("Hadoop", "Storm"),
      Pair("Hadoop", 2008),
      Pair(1.0, 2.0),
      Pair("Hadoop", Some(1.9))
    )
    pairList.foreach(println(_))
    pairList.foreach((x:Any)=>{println(x)})
    val func = (x:Any) => { println(x)}
    println("*"*20)
    pairList.foreach(func)
  }
}
