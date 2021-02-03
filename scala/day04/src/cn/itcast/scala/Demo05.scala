package cn.itcast.scala

/*	依次修改代码定义以下三个数组
Array(1,x,y)   // 以1开头，后续的两个元素不固定
Array(0)       // 只匹配一个0元素的元素
Array(0, ...)  // 可以任意数量，但是以0开头
	使用模式匹配上述数组
*/

object Demo05 {

  def main(args: Array[String]): Unit = {
    var array1 = Array(1, 34, 4)
    var array2 = Array(0)
    var array3 = Array(0, 34, 4)
    val result = array1 match {
      case Array(1,x,y) => println(s"获取x的值${x}和y的值为${y}")
      case Array(0) => println(s"匹配上数组元素为0")
      case Array(1,_*) => println(s"匹配上该数组元素是以0开头")
      case _ => println("无匹配")
    }
    println(result)
  }
}
