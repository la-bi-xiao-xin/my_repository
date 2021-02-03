package cn.itcast.scala
/*示例说明
	定义一个两个数相除的方法，使用Option类型来封装结果
	然后使用模式匹配来打印结果
	不是除零，打印结果
	除零打印异常错误
*/
object Demo10 {
def math(a:Int,b:Int): Option[Double] ={
  if(b != 0){
    Some(a/b)
  }else {
    None
  }
}
  def main(args: Array[String]): Unit = {
    val resul = math(9,3)
    val result = resul match {
      case Some(x) => println(x)
      case None => println("底数不可以为0")
    }
    result
  }
}
