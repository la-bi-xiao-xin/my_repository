package cn.itcast.scala
/*
2.	特质
1.	新建一个object类型的scala文件。
2.	定义一个特质,动物Animal，包含动物名name，和腿的条数leg_num，和方法say()
3.	定义普通类鸡Hen、狗Dog继承Animal。自定义重写name、leg_num、say()
4.	在Main方法中创建鸡、狗的实例对象。调用他们的say()方法。
*/
object HomeWork1 {
  trait Animal {
    val name:String
    val leg_num:Int
    def say
  }
  class Hen extends Animal{
    override val name: String = "鸡"
    override val leg_num: Int = 2

    override def say: Unit = println("鸡会咯咯叫")
  }
  class Dog extends Animal{
    override val name: String = "狗"
    override val leg_num: Int = 4

    override def say: Unit = println(s"${name}会汪汪叫")
  }

  def main(args: Array[String]): Unit = {
    val hen = new Hen
    hen.say
    val dog = new Dog
    dog.say
  }
}
