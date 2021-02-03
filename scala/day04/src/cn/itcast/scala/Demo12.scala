package cn.itcast.scala
/*定义一个偏函数，根据以下方式返回
输入	返回值
1	  一
2	  二
3	  三
其他	其他
*/
object Demo12 {
val func1:PartialFunction[Int,String]={
  case 1 => "一"
  case 2 => "二"
  case 3 => "三"
  case _ => "未匹配"
}

  def main(args: Array[String]): Unit = {
    println(func1(1))
  }
}
