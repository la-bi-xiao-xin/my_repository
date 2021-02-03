package cn.itcast.scala

/*
匹配样例类
需求说明
	创建两个样例类Customer、Order
	Customer包含姓名、年龄字段
	Order包含id字段
	分别定义两个样例类的对象，并指定为Any类型，（必须声明类型，否则会报错。）
	使用模式匹配这两个对象，并分别打印它们的成员变量值
*/
object Demo04 {

  case class Customer(name: String, age: Int)

  case class Order(id: Int)

  def main(args: Array[String]): Unit = {
    val customer: Any = new Customer("张三", 20)
    val order: Any = new Order(1)

    val result = order match {
      case Customer(name: String, age: Int) => println(s"姓名为:${name},年龄为:${age}")
      case Order(id:Int) => println(s"订单号为:${id}")
      case _ => println("无匹配")
    }

  }
}
