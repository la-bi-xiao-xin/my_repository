package cn.itcast.scala

/*示例说明
	用一个方法来获取任意类型数组的中间的元素
	不考虑泛型直接实现（基于Array[Int]实现）。缺点是集合的元素类型只能局限是String或者Int
	加入泛型支持。优点是，支持所有数据类型，在运行时才指定数据类型。
*/
object Demo18 {
  def getMiddle(array: Array[Int]) = {
    val result = array(array.length / 2)
    println(result)
  }
  def getMiddle2[T](array:Array[T])={
    val result = array(array.length / 2)
    println(result)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array("1", "2","3","4","5")
    getMiddle2(arr)
  }
}
