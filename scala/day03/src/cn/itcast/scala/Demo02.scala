package cn.itcast.scala
/*1.2 	在单例对象中定义成员方法
	在object中定义的成员方法类似于Java的静态方法
示例
示例说明
	设计一个单例对象，定义一个能够打印分割线（15个减号）的方法
	在main方法调用该方法，打印分割线
*/
object Demo02 {
  object Print{
  def print()={println("-"*15)}
}

  def main(args: Array[String]): Unit = {
    Print.print()
  }
}
