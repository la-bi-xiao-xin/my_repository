package cn.itcast.scala
/*
3.1 	定义伴生对象
一个class和object具有同样的名字。这个object称为伴生对象，这个class称为伴生类
	伴生对象必须要和伴生类一样的名字
	伴生对象和伴生类在同一个scala源文件中
	伴生对象和伴生类可以互相访问private属性
示例
示例说明
	编写一个英雄Hero类，定义一个作战方法fight()，
	编写一个Hero伴生对象，定义一个私有变量WEAPON，用于保存作战武器的名称，比如方天画戟
	在Hero类的作战方法fight()中，引用Hero伴生对象的私有变量WEAPON，打印  "我要用【WEAPON】作战了"
*/
object Demo05 {
    class Hero{
      def fight: Unit ={
        println("我要用【"+Hero.EAPWON+"】作战了")
        println(s"我要用【${Hero.EAPWON}】作战了")
      }
    }
  object Hero{
    private val EAPWON:String = "方天画戟"
  }

  def main(args: Array[String]): Unit = {
    val hero = new Hero
    hero.fight
  }
}
