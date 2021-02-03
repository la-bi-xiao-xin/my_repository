package cn.itcast.scala
/*	定义一个两个数相除的方法，使用Option类型来封装结果
	然后使用模式匹配来打印结果
	不是除零，打印结果
	除零打印异常错误

	重写上述案例，使用getOrElse方法，当除零时，或者默认值为0
*/
object Demo11 {
def math(a:Int,b:Int): Option[Double] ={
  if(b!=0){
    Some(a/b)
  }else{
    None
  }
}

  def main(args: Array[String]): Unit = {
    val d = math(4,0).getOrElse(-1)
    val b = math(4,2).getOrElse(-1)
    println(d)
    println(b)
  }
}
