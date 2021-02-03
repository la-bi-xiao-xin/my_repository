package cn.itcast.scala
/*1.1 	定义单例对象
单例对象表示全局仅有一个对象（类似于Java static概念）
	定义单例对象和定义类很像，就是把class换成object
	在object中定义的成员变量类似于Java的静态变量
	可以使用object直接引用成员变量
示例
示例说明
	定义一个Dog单例对象，保存狗有几条腿
	在main方法中打印狗腿的数量
*/
object Demo01 {
  object Dog{
    val Legs=4
  }

  def main(args: Array[String]): Unit = {
    println("这只狗有"+Dog.Legs+"条腿")
  }

}
