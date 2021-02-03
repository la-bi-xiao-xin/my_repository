package cn.itcast.scala

/*示例说明
	依次修改代码定义以下两个元组
(1, x, y)       // 以1开头的、一共三个元素的元组
(x, y, 5)   // 一共有三个元素，最后一个元素为5的元组
	使用模式匹配上述元素
*/
object Demo07 {
  def main(args: Array[String]): Unit = {
    var a = (1,"zhang",2)
    var b = (4,"zhang",5)
    val  result = a match {
      case (1,x,y) => println(s"该元组于以元素为1开头的元组匹配,获取x和的值为${x},${y}")
      case (x,y,5) => println(s"该元组于以元素为5结尾的元组匹配,获取x和的值为${x},${y}")
      case _ => println("未匹配")
    }
   result
  }
}
