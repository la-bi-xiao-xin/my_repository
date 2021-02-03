package flow2;

import flow.FlowDriver;
import flow.FlowMap;
import flow.FlowPojo;
import flow.FlowReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class Flow2Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建 job对象
        Job job = Job.getInstance(new Configuration(), "Flow2Driver");
        job.setJarByClass(Flow2Driver.class);
        //2. 封装 天龙八部:
        //2.1: 封装 输出类
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\流量统计\\output5"));

        //2.2: 封装 mapper  以及k2 和 v2类型
        job.setMapperClass(Flow2Map.class);
        job.setMapOutputKeyClass(Flow2Pojo.class);
        job.setMapOutputValueClass(NullWritable.class);

        //2.3: 设置 分区
        //2.4: 设置排序:
        //2.5: 设置规约: 不需要
        //2.6: 设置分组

        //2.7: 设置 reduce类, 设置 k3 和 v3
        job.setReducerClass(Flow2Reduce.class);
        job.setOutputKeyClass(Flow2Pojo.class);
        job.setOutputValueClass(NullWritable.class);

        //2.8: 输出操作
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\流量统计\\output6"));

        //3. 提交任务
        boolean b = job.waitForCompletion(true);

        //4. 关闭程序
        System.exit(b?0:1);
    }
}
