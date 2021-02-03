package cn.itcast.scala
/*示例说明
	在main方法中抛出一个异常
*/
object Demo16 {
  def main(args: Array[String]): Unit = {
    try {
      val a = 1 / 0
    } catch {
      case e : Exception => throw e

    }

  }

}
