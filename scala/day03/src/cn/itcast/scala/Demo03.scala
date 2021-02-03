package cn.itcast.scala


import java.text.SimpleDateFormat
import java.util.Date

/*1.3 	工具类案例
需求
	编写一个DateUtil工具类专门用来格式化日期时间
	定义一个方法，用于将日期（Date）转换为年月日字符串，例如：2030-10-05
步骤
	定义一个DateUtil单例对象，定义日期格式化方法（format）
	使用SimpleDateFormat将日期转换为字符串

*/
object Demo03 {

  object Times {
    val value = "yyyy-MM-dd"
    val format = new SimpleDateFormat(value)

    def changeTime(time: Date) = {
    format.format(time)
    }
  }

  def main(args: Array[String]): Unit = {

    println(Times.changeTime(new Date()))
  }
 /* object DateUtils {
    // 在object中定义的成员变量，相当于Java中定义一个静态变量
    // 定义一个SimpleDateFormat日期时间格式化对象
    val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm")

    // 相当于Java中定义一个静态方法
    def format(date: Date) = {simpleDateFormat.format(date)}
  }

  // main是一个静态方法，所以必须要写在object中
  def main(args: Array[String]): Unit = {
    println(DateUtils.format(new Date()))
  }*/

}
