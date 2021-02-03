import org.apache.spark.mllib.linalg
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object Demo01 {
  def main(args: Array[String]): Unit = {
    //LocalVector  本地向量创建
    val vd: linalg.Vector = Vectors.dense(1,23,24,25)
    vd //建立密集向量
   // println(vd(2)) //打印稀疏向量第3个值
   // println(vd)
    val vs: linalg.Vector = Vectors.sparse(5,Array(0,4),Array(0,4))
    vs //建立稀疏向量
    //第一个参数4代表输入数据的大小，一般要求大于等于输入的数据值，第二个参数是数据下标，第三个参数是数据值
    //println(vs(2)) //打印稀疏向量第3个值
    //println(vs(4))
    //println(vs)
    //结果
    //24.0
    //[1.0,23.0,24.0,25.0]
    //0.0
    //4.0
    //(5,[0,4],[0.0,4.0])

    //LabelPoint标签向量创建
    val vd2: linalg.Vector = Vectors.dense(2, 0, 6)
    //建立密集向量
    val pos = LabeledPoint(1, vd2)                         //对密集向量建立标记点
    println(pos.features)                               //打印标记点内容数据
    println(pos.label)                                  //打印既定标记
    val vs2: linalg.Vector = Vectors.sparse(4, Array(0, 1, 2, 3), Array(9, 5, 2, 7))
     //建立稀疏向量
    val neg = LabeledPoint(2, vs2)   //对密集向量建立标记点
    println(neg.features) //打印标记点内容数据
    println(neg.label)

  }

}
