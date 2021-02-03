package partition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class partitionDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建job类
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(partitionDriver.class);

        //2.设置八步
        //2.1设置数据输入类
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day12_MapReduce\\资料\\自定义分区\\input"));

        //2.2设置map类 K2和V3的类型
        job.setMapperClass(PartitionMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        //2.3设置分区
       // job.setPartitionerClass(CaiPiaoPartition.class);
        job.setPartitionerClass(CaiPiaoPartition .class);
        //System.out.println("1111111111");
        //2.4-6 排序,规约,分组 不设置,使用默认设置

        //2.7设置reduc  和k3,v3的类型
        job.setReducerClass(PatitionReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        //2.8设置数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day12_MapReduce\\资料\\自定义分区\\output1"));

        //3. 由于使用分区, 而且自定义分区使用2个分区, 故 reduceTask必须为 2
        job.setNumReduceTasks(2);


        //4.提交任务
        boolean b = job.waitForCompletion(true);

        //5.退出系统
        System.exit(b?0:1);
    }
}
