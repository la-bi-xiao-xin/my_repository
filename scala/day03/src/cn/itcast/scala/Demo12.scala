package cn.itcast.scala
/*	设计4个类，表示上述图中的继承关系
	每一个形状都有自己求面积的方法，但是不同的形状计算面积的方法不同
步骤
1.	创建一个Shape抽象类，添加一个area抽象方法，用于计算面积
2.	创建一个Square正方形类，继承自Shape，它有一个边长的主构造器，并实现计算面积方法
3.	创建一个长方形类，继承自Shape，它有一个长、宽的主构造器，实现计算面积方法
4.	创建一个圆形类，继承自Shape，它有一个半径的主构造器，并实现计算面积方法
5.	编写main方法，分别创建正方形、长方形、圆形对象，并打印它们的面积
*/
object Demo12 {
 abstract class Shap {
   def getArea:Double
 }
  class Square(length:Double) extends Shap{
    override def getArea: Double = length*length
  }
  class Rectangle(var length:Double /*长*/, var width:Double /*宽*/) extends  Shap{
    override def getArea: Double = length*width
  }
  class Cirle(var radius:Double) extends Shap{
    override def getArea: Double = math.Pi*radius*radius
  }

  def main(args: Array[String]): Unit = {
    val square = new Square(4)
    println(square.getArea)
    val rectangle = new Rectangle(4,5)
    println(rectangle.getArea)
    val cirle = new Cirle(3)
    println(cirle.getArea)
  }
}
