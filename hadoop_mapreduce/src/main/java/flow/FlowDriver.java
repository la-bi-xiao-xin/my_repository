package flow;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FlowDriver {
    public static void main(String[] args) throws Exception {
        //1.创建 job对象
        Job job = Job.getInstance(new Configuration(), "FlowDriver");
        job.setJarByClass(FlowDriver.class);
        //2. 封装 天龙八部:
        //2.1: 封装 输出类
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\流量统计\\input"));

        //2.2: 封装 mapper  以及k2 和 v2类型
        job.setMapperClass(FlowMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowPojo.class);

        //2.3: 设置 分区
        //2.4: 设置排序:
        //2.5: 设置规约: 不需要
        //2.6: 设置分组

        //2.7: 设置 reduce类, 设置 k3 和 v3
        job.setReducerClass(FlowReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //2.8: 输出操作
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("file:///F:\\大数据就业班资料\\lesion2\\day13_MapReduce\\资料\\流量统计\\output6"));

        //3. 提交任务
        boolean b = job.waitForCompletion(true);

        //4. 关闭程序
        System.exit(b?0:1);
    }
}
