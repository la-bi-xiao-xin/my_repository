package cn.itcast.scala
/*需求说明
	定义一个变量为Any类型，然后分别给其赋值为"hadoop"、1、1.0
	定义模式匹配，然后分别打印类型的名称
*/
object Demo02 {
  def main(args: Array[String]): Unit = {
    var name:Any ="hadoop"
    val result = name match {
      case a:String => "String"
      case a:Int => "Int"
      case a:Double => "Double"
    }
    println(result)
  }

}
