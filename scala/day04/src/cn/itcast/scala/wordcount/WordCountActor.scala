package cn.itcast.scala.wordcount
import cn.itcast.scala.wordcount.MessagePackage.{WordCountResult, WordCountTask}

import scala.actors.Actor
import scala.io.Source
//41.7.2 创建WordCountActor
// * 实现思路
// * 根据文件数量创建WordCountActor，为了方便后续发送消息给Actor，将每个Actor与文件名关联在一起
// * 实现步骤
// * 6. 定义WordCountActor类
class WordCountActor extends Actor{
  override def act(): Unit = {
    // * 11.	WordCountActor接收单词统计任务消息 ，打印接收到的消息。
    loop{
      react{
        case WordCountTask(fileName:String) =>{
          println(s"${fileName}文件的统计线程启动成功")
          // 41.7.4 消息统计文件单词计数
          // * 实现思路
          // * 读取文件文本，并统计出来单词的数量。例如：
          // * (hadoop, 3), (spark, 1)...
          // * 实现步骤
          // * 12.	读取文件内容，并转换为列表
          // * 13.	按照空格切割文本，并转换为一个一个的单词
          val lines: Iterator[String] = Source.fromFile(fileName).getLines()
          val linesList: List[String] = lines.toList
          val wordsList: List[String] = linesList.flatMap(_.split(" "))
          // *   14.2.1.	为了方便进行计数，将单词转换为元组
          val wordGroup: Map[String, List[String]] = wordsList.groupBy((x)=>{x})
          // *   14.2.2.	按照单词进行分组，然后再进行聚合统计
          val wordsCuntedMap: Map[String, Int] = wordGroup.map((x)=>{x._1 -> x._2.length})
          // * 15.	打印聚合统计结果
          wordsCuntedMap.foreach(println(_))
          // 41.7.5 封装单词计数结果回复给MainActor
          // * 实现思路
          // * 	将单词计数的结果封装为一个样例类消息，并发送给MainActor
          // * 	MainActor等待所有WordCount均已返回后获取到每个WordCountActor单词计算后的结果
          // * 实现步骤
          // * 17.	将单词计数结果发送给MainActor
          sender ! WordCountResult(wordsCuntedMap)

        }
      }
    }
  }
}
