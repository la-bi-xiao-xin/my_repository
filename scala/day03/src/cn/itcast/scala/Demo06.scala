package cn.itcast.scala
/*3.2 	private[this]访问权限
如果某个成员的权限设置为private[this]，表示只能在当前类中访问。伴生对象也不可以访问
示例
示例说明
	定义一个Person类，包含一个name字段
	定义Person类的伴生对象，定义printPerson方法
	测试伴生对象是否能访问private[this]权限的成员
步骤
	定义一个Person类，包含一个name字段，仅用private修饰（不带[this]）
	定义Person类的伴生对象，定义printPerson方法，访问Person类实例的name，是允许访问的
	在main方法中，创建Person类的对象，传入printPerson方法，看运行结果。
	另外将Person类的name字段，用private[this]修饰，此时printPerson方法无法访问name，编译报错。
*/
object Demo06 {
  class Person(private val neme:String)
  object Person{
    def printPerson(person:Person)= println(person.neme)
  }

  def main(args: Array[String]): Unit = {
    val person = new Person("张三")
    Person.printPerson(person)
  }

}
