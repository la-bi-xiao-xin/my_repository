package cn.itcast.scala
/*需求说明
	生成包含0-10数字的列表，使用模式匹配分别获取第一个、第二个元素
*/
object  Demo09 {
  def main(args: Array[String]): Unit = {
    val list = (1 to 10).toList
    val x :: y :: tail = list
    println(x,y)
  }
}
