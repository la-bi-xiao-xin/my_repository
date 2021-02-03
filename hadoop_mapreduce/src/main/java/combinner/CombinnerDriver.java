package combinner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class CombinnerDriver {
    public static void main(String[] args) throws Exception{
        //1.创建job对象
        Job job = Job.getInstance(new Configuration(), " CombinnerDriver");
        //设置hadoop平台运行设置
        job.setJarByClass(CombinnerDriver.class);

        //2.设置mapreduce的八个步骤
        //2.1设置数据输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\combinner\\input"));

        //2.2设置map
        job.setMapperClass(CombinnerMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //2.3设置分区,排序,规约,分组,此处只设置规约,其它几项采用默认
        job.setCombinerClass(Mycombinner.class);

        //2.7设置reduce
        job.setReducerClass(CombinnerReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //2.8设置数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\combinner\\output"));

        //3.提交任务
        boolean b = job.waitForCompletion(true);

        //4.退出系统
        System.exit(b ? 0 : 1);

    }

}
