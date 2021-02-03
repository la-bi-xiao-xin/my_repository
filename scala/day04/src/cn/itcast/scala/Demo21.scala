package cn.itcast.scala

import scala.actors.Actor

/*示例说明
创建两个Actor，一个Actor打印1-10，另一个Actor打印11-20
	使用class继承Actor创建（如果需要在程序中创建多个相同的Actor）
	使用object继承Actor创建（如果在程序中只创建一个Actor）
*/
object Demo21 {
class Actor1 extends Actor{
  override def act(): Unit = {
    val list = (1 to 10).toList
    list.foreach(println(_))
  }


}
  class Actor2 extends Actor{
    override def act(): Unit = {
      val list = (10 to 20).toList
      list.foreach(println(_))
    }
  }
  def main(args: Array[String]): Unit = {
    val actor1 = new Actor1
    actor1.start()
    val actor2 = new Actor2
    actor2.start()
    val list = (30 to 40).toList
    list.foreach(println(_))
  }
}
