package cn.itcast.scala
/*示例说明
	定义一个列表，包含1-10的数字
	请将1-3的数字都转换为[1-3]
	请将4-8的数字都转换为[4-8]
	将其他的数字转换为(8-*]
*/
object Demo13 {
   val list = (1 to 10).toList
  val fun:PartialFunction[Int,String] ={
    case x if x>=1 && x<3 => "[1-3]"
    case x if x>=4 && x<8 => "[4-8]"
    case _ => "[8-*]"
  }

  def main(args: Array[String]): Unit = {
    println(list.map(fun))
  }
}
