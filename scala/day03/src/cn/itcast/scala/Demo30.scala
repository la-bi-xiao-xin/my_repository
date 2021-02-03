package cn.itcast.scala

/*需求说明
	创建一个Trait，表示性别Sex枚举，
	定义它的两个实例，样例对象（男性——Male、女性——Female）
	创建一个Person样例类，它有两个成员（姓名、性别）
	创建两个Person对象（"张三"、男性）、（"李四"、"女"）
*/
object Demo30 {

  trait Sex

  case object Male extends Sex

  case object Female extends Sex

  case class Person(name: String, sex: Sex)

  def main(args: Array[String]): Unit = {
    val 张三 = new Person("张三", Male)
    val 李四 = new Person("李四", Female)
    println(张三)
    println(李四)
  }
}
