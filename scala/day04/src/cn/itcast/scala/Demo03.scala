package cn.itcast.scala

import scala.io.StdIn

/*示例
需求说明
	从控制台读入一个数字a（使用StdIn.readInt）
	如果 a >= 0 而且 a <= 3，打印[0-3]
	如果 a >= 4 而且 a <= 8，打印[4,8]
	否则，打印未匹配
*/
object Demo03 {
  def main(args: Array[String]): Unit = {
    println("请随机输入一个数字")
    val str = StdIn.readInt()
    val result= str match {
      case x if x>= 0 && x <= 3 => println("[0-3]")
      case x if x>= 4 && x <= 8 => println("[4-8]")
      case x => println("未匹配")
    }
    println(result)

  }
}
