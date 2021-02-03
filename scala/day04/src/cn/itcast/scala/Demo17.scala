package cn.itcast.scala
/*示例说明
	创建一个Student类，包含姓名年龄两个字段
	定义半生对象，重写unapply方法，实现一个类的解构器，并使用match表达式进行模式匹配，提取类中的字段。。
*/
object Demo17 {
class Student(var naem:String,var age:Int)
object Student{
  def apply(name:String,age:Int): Unit ={
    new Student(name,age)
  }
  def unapply(arg: Student): Option[(String, Int)] = {
    val tuple = (arg.naem,arg.age)
    Some(tuple)
  }
}

   def main(args: Array[String]): Unit = {
    val student = new Student("张三",20)
    val result = student match {
      case Student(name:String,age:Int) => println(s"获取姓名为${name}年龄为${age}")
    }
  }
}
