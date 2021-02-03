package sort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class SortDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建job对象
        Job job = Job.getInstance(new Configuration(),"sortDriver");
        job.setJarByClass(SortDriver.class);//Hadoop运行需设置
        //2.设置8步
        //2.1设置数据输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day12_MapReduce\\资料\\排序\\input\\sort.txt"));

        //2.2设置map
        job.setMapperClass(SortMap.class);
        job.setMapOutputKeyClass(SortPojo.class);
        job.setMapOutputValueClass(NullWritable.class);

        //2.3-6设置分区,排序,规约,分组,自定义的pojo类中定义了排序方法,因此此步不设置

        //2.7设置ruduce
        job.setReducerClass(SortReduce.class);
        job.setOutputKeyClass(SortPojo.class);
        job.setOutputValueClass(NullWritable.class);

        //2.8设置数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day12_MapReduce\\资料\\排序\\output"));

        //3.提交任务
        boolean b = job.waitForCompletion(true);

        //4.退出系统
        System.exit(b ? 0 : 1);

    }

}
