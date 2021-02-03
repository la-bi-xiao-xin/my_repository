package cn.itcast.scala.wordcount

object MessagePackage {
  // * 9.	定义一个样例类，描述单词统计的任务消息，包含文件名fileName属性。
  case class WordCountTask(fileName:String)
  // * 16.	定义一个样例类封装单词计数结果
  case class WordCountResult(map:Map[String,Int])

}
