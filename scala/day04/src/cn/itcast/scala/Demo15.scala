package cn.itcast.scala
/*示例说明
	使用try..catch来捕获除零异常
*/
object Demo15 {
  def main(args: Array[String]): Unit = {
    try {
      val a = 1 / 0
    } catch {
      case  ex : Exception  => println(ex.getMessage)
    } finally {
      println("无论如何都会执行")
    }
  }
}
