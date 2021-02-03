package group;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class GroupDrive {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建job对象
        Job job = Job.getInstance(new Configuration(), "GroupDrive");
        //设置hadoop平台运行
        job.setJarByClass(GroupDrive.class);

        //2.设置8步
        //2.1设置数据输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\自定义groupingComparator\\input"));

        //2.2设置map
        job.setMapperClass(GroupMap.class);
        job.setMapOutputKeyClass(GroupPojo.class);
        job.setMapOutputValueClass(NullWritable.class);

        //2.3设置分区
        //job.setPartitionerClass(GroupPartition.class);

        //2.4设置排序,在包装类中已经排序

        //2.5.设置规约

        //2.6设置分组
        job.setGroupingComparatorClass(MyGroup.class);

        //2.7设置reduce
        job.setReducerClass(GroupReduce.class);
        job.setOutputKeyClass(GroupPojo.class);
        job.setOutputValueClass(NullWritable.class);

        //2.8设置数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\自定义groupingComparator\\output13"));

        //3.设置reducetask个数
        //job.setNumReduceTasks(2);

        //4.提交任务
        boolean b = job.waitForCompletion(true);

        //5.退出系统
        System.exit(b ? 0 : 1);
    }

}
