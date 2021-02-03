package kaoshi_wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建jobd对象
        Job job = Job.getInstance(new Configuration(), "WordCountDriver");
        //job.setJarByClass(WordCountDriver.class);  //如果运行在yarn平台上设置

        //2.设置八个步骤
        //2.1设置数据输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("file:///C:\\Users\\zff\\Desktop\\考试-周仁成\\24题资源"));

        //2.2设置map和k2,v2类型
        job.setMapperClass(WordCountMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //2.3-6 设置分区,排序,规约,分组  此题采用默认不设置

        //2.7设置reduce和k3,v3类型
        job.setReducerClass(WordCountReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //2.8设置数据输出

        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("file:///C:\\Users\\zff\\Desktop\\考试-周仁成\\24题资源\\output6"));

        //3.提交任务
        boolean b = job.waitForCompletion(true);

        //4.退出系统
        System.exit(b ? 0 : 1);

    }
}
