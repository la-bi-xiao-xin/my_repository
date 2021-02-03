package cn.itcast.scala.wordcount

import java.io.File

import cn.itcast.scala.wordcount.MessagePackage.{WordCountResult, WordCountTask}

// * 3. 在wordcount包下新建MainActor单例对象
object MainActor {
  def main(args: Array[String]): Unit = {
    //* 实现步骤
    // * 1. 新建一个wordcount包
    // * 2.	在工程根目录下创建/data/用于测试的数据文件
    // * 4.	加载工程根目录，获取到所有文件
    val file: File = new File("F:\\idea_project\\scala\\day04\\data\\")
    val file_arr:Array[String] = file.listFiles().map(_.toString)
    //5.	打印所有文件名
    println("5、所有的文件名为："+file_arr.mkString(","))
    // * 7.	为每个文件关联创建一个WordCountActor实例，得到新列表。
    val tuples: Array[(String, WordCountActor)] = file_arr.map((x)=>{(x -> new WordCountActor)})
    // * 8.	打印测试
    tuples.foreach(println(_))
    //    *41.7.3 启动Actor/发送/接收任务消息
    // * 实现思路
    // * Main线程将任务发给各个WordCountActor，他们接收到消息并打印消息。
    // * 实现步骤
    // * 10.	main线程将每个文件名封装为消息（!!方式）发送给对应的WordCountActor，并（等待）获取异步返回结果
        val future_arr= tuples.map((x) => {
          val filename: String = x._1
          val wordCountActor: WordCountActor = x._2
          wordCountActor.start()
          wordCountActor !! WordCountTask(filename)
        })
    // * 18.	MainActor中检测所有WordActor是否均已返回，如果均已返回，则获取并转换结果
    while(future_arr.filter(!_.isSet).size>0){}
    val wordcount_arr: Array[Map[String, Int]] = future_arr.map(_.apply().asInstanceOf[WordCountResult].map)
    // * 19.	MainActor打印从各WordCountActor接收到的结果
    println("**********")
    //20.	在MainActor调用该合并方法，计算得到最终结果，并打印.需要拆分成一步一步来。
    val wordcount_final: Map[String, Int] = wordcount_arr.flatten.groupBy(_._1).map(x=>x._1->x._2.map(_._2).sum)
    println("20、MainActor聚合统计后的最终结果"+wordcount_final)


  }

}
