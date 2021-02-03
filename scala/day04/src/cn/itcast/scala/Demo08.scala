package cn.itcast.scala
/*需求说明
	生成包含0-10数字的数组，使用模式匹配分别获取第二个、第三个、第四个元素
*/
object Demo08 {
  def main(args: Array[String]): Unit = {
    val array = (0 to 10).toArray
    val Array(_,x,y,z,_*) = array
    println(x,y,z)
  }

}
