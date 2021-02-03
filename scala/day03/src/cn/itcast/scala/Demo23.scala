package cn.itcast.scala
/*实现一个模拟支付过程的调用链
步骤
1.	定义一个HandlerTrait特质
	定义一个具体的handler方法，打印"处理数据..."
2.	定义一个DataValidHandlerTrait，继承HandlerTrait特质
	重写handler方法，打印"验证数据"
	调用父特质的handler方法
3.	定义一个SignatureValidHandlerTrait，继承HandlerTrait特质
	重写Handler方法
	打印"检查签名"
	调用父特质的handler方法
4.	创建一个PaymentService类
	继承DataValidHandlerTrait
	继承SignatureValidHandlerTrait
	定义pay方法
	打印"准备支付"
	调用父特质的handler方法
5.	添加main方法
	创建PaymentService对象实例
	调用pay方法
*/
object Demo23 {
trait HandlerTrait {
  def handler: Unit ={
    println("4处理数据步骤")
  }
}
  trait DataValidHandlerTrait extends HandlerTrait{
    override def handler: Unit ={

      println("2验证数据")
      super.handler
    }

  }
  trait SignatureValidHandlerTrait extends HandlerTrait{
    override def handler: Unit = {

      println("3校验签名")
      super.handler
    }

  }
  class PaymentService extends  SignatureValidHandlerTrait with DataValidHandlerTrait{
    def pay: Unit ={

      println("1准备支付")
      super.handler
    }
  }

  def main(args: Array[String]): Unit = {
    val service = new PaymentService
    service.pay
  }
}
/*类继承了多个trait后，可以依次调用多个trait中的同一个方法，
只要让多个trait中的同一个方法在最后都依次执行super关键字即可。
类中调用多个tait中都有这个方法时，首先会从最右边的trait方法开始执行，然后依次往左执行，形成一个调用链条。*/