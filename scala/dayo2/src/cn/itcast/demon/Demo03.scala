package cn.itcast.demon
/*步骤
1.	定义一个元组列表来保存学生姓名和性别
2.	按照性别进行分组
3.	将分组后的Map转换为列表：List(("男" -> 2), ("女" -> 1))
*/
object Demo03 {
  def main(args: Array[String]): Unit = {
    val a = List("张三"->"男", "李四"->"女", "王五"->"男")
    val map1: Map[String, List[(String, String)]] = a.groupBy((x)=>{x._2})
    println(map1)
    val stringToInt: Map[String, Int] = map1.map((x)=>{x._1->x._2.length})
    println(stringToInt)
  }
}
