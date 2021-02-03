package cn.itcast.scala

/*	依次修改代码定义以下三个列表
List(0)             // 只保存0一个元素的列表
List(0,...)         // 以0开头的列表，数量不固定
List(x,y)           // 只包含两个元素的列表
	使用模式匹配上述列表
*/
object Demo06 {
  def main(args: Array[String]): Unit = {
    val list1 = List(0)
    val list2 = List(0,43,6,7,7,4)
    val list3 = List(1,3)

    val result = list3 match {
      case List(0) => println("list3该列表与元素只有0的集合匹配")
      case List(0,_*) => println("list3该列表与元素以0的集合匹配")
      case List(x,y) => println(s"list3该列表与元素只有2个的集合匹配获取元素值x和y分别为${x},${y}")
    }
    println(result)
  }
}
