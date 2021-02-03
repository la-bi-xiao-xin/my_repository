package cn.itcast.scala

/*示例
示例说明
	定义一个Person类
	定义一个Student类，继承Person类
	定义一个demo泛型方法，该方法接收一个Array参数，
	限定demo方法的Array元素类型只能是Person或者Person的子类
	测试调用demo，传入不同元素类型的Array
*/
object Demo20 {

  class Person

  class Student extends Person

  def demo[T <: Person](arr: Array[T]): Unit = {
    arr.foreach(println(_))
  }

  def main(args: Array[String]): Unit = {
    var array = Array(new Person,new Student)
      demo(array)
  }
}
