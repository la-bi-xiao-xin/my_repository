package cn.itcast.scala
/*示例说明
	定义一个正则表达式，来匹配邮箱是否合法
	合法邮箱测试：qq12344@163.com
	不合法邮箱测试：qq12344@.com
*/
object Demo14 {
  def main(args: Array[String]): Unit = {
    val r = """.+@.+\..+""".r
    val eml1 = "qq12344@163.com"
    val eml2 = "qq12344@.com"
    if(r.findAllMatchIn(eml1).size>0){
      println(eml1+"是合法邮件格式")
    }else{
      println(eml1+"不是合法邮件格式")
    }
    if(r.findAllMatchIn(eml2).size>0){
      println(eml2+"是合法邮件格式")
    }else{
      println(eml2+"不是合法邮件格式")
    }

  }
}
