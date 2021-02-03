package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
//创建WordCountReduce类继承Reducer类指定参数K2,V2,序列化数据类型,K3,V3序列化数据类型
public class WordCountReduce extends Reducer<Text, IntWritable, Text,IntWritable> {
//重写reduce方法
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
       int count=0;
       //经过默认分区,排序,规约,分组后,K2值相同的V2值放到一个集合中,变成K2,[V2]
        for (IntWritable value : values) {//遍历V2的集合
            count+=value.get();//将集合中的值累加就得到K2出现的次数
        }
        context.write(key,new IntWritable(count));//将输出K3,V3的序列化形式的值
    }
}

