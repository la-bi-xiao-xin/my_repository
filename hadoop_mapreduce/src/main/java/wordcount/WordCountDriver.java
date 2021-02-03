package wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class  WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建job对象
        Job job = Job.getInstance(new Configuration());

        //要想在yuar平台上运行需要一下代码
        job.setJarByClass(WordCountDriver.class);

        //2.设置核心八步
        //2.1设置数据输入类
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("hdfs://node1:8020/wordcount/input"));

        //2.2设置mapl类和k2,v2类型
        job.setMapperClass(WordCountMp.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //2.3-6设置分区,排序,规约,分组  此需求不去要另外编写分区,排序,规约,分组代码,不设置.使用默认分区,排序,规约,分组设置

        //2.7设置reduce类和K3,V3的类型
        job.setReducerClass(WordCountReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //2.8.设置输出数据类
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("hdfs://node1:8020/wordcount/output"));

        //3.提交任务
        boolean b = job.waitForCompletion(true);

        //4.结束任务
        System.exit(b ? 0 : 1);


    }
}
