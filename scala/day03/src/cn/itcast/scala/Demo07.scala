package cn.itcast.scala



/*示例说明
	定义一个Person类，它包含两个字段：姓名和年龄
	定义伴生对象，重写apply方法，使用Person类名就可以创建对象
	在main方法中创建该类的对象，并打印姓名和年龄
*/
object Demo07 {
  class Person(var name:String = "", var age:Int = 0)

  object Person {
    // 定义apply方法，接收两个参数
    def apply(name:String, age:Int) = new Person(name, age)
  }

  def main(args: Array[String]): Unit = {
    // 使用伴生对象名称来创建对象
    val zhangsan = Person("张三", 20)
    println(zhangsan.name)
    println(zhangsan.age)
  }

}
