package flow11;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class Flow11Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建job对象
        Job job = Job.getInstance(new Configuration(), "Flow11Driver");
        //设置hadoop运行
        job.setJarByClass(Flow11Driver.class);

        //2.设置8步
        //2.1设置数据输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\流量统计\\input"));

        //2.设置map K2,V2
        job.setMapperClass(Flow11Map.class);
        job.setMapOutputKeyClass(Flow11Pojo.class);
        job.setMapOutputValueClass(NullWritable.class);

        //2.3-6设置分区,排序,规约,分组
        job.setGroupingComparatorClass(Flow11Group.class);

        //2.7设置reduce
        job.setReducerClass(Flow11Reduce.class);
        job.setOutputKeyClass(Flow11Pojo.class);
        job.setOutputValueClass(NullWritable.class);

        //2.8设置数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\流量统计\\output12"));

        //3.提交任务
        boolean b = job.waitForCompletion(true);

        //4.退出系统
        System.exit(b ? 0 : 1);

    }
}
