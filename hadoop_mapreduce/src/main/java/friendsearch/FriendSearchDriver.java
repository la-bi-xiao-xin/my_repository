package friendsearch;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FriendSearchDriver {
    public static void main(String[] args) throws Exception {
        //1.创建job对象
        Job job = Job.getInstance(new Configuration(), "FriendSearchDriver");
        //设置hadoop运行
        job.setJarByClass(FriendSearchDriver.class);

        //2.设置8步
        //2.1设置输入
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("file:///F:\\大数据就业班资料\\lesion2\\day14_MapReduce与yarn\\资料\\共同好友\\input"));

        //2.2设置map 和 K2,V2类型
        job.setMapperClass(FriendSearchMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        //2.3-6设置分区,排序,规约,分组

        //2.7设置reduce 和K3,V3的类型
        job.setReducerClass(FriendSearchReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //2.8设置数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("file:///F:\\大数据就业班资料\\lesion2\\day14_MapReduce与yarn\\资料\\共同好友\\output5"));

        //3.提交任务
        boolean b = job.waitForCompletion(true);

        //4.退出系统
        System.exit(b ? 0 : 1);
    }
}
