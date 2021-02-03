package wordcount;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
//创建WordCountMp类继承Mapper类
public class WordCountMp extends Mapper<LongWritable, Text,Text, IntWritable>{
    //重写Mapper类的map方法
    @Override
    //LongWritable是长整型的序列化数据类型,值名为key是行偏移量,Text是字符串序列化数据类型,值名value,是从文件中读取的一行数据
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString(); //将一行数据反序列化为字符串
        System.out.println(key.get());
        if(line !=null && !"".equals(line)){//判断这一行数据是否为空
            String[] strings = line.split(" "); //将一行数据按正则划分为一个一个的字符串,然后返回一个字符串数组
            for (String word : strings) { //遍历字符数组
                System.out.println(word);
                context.write(new Text(word),new IntWritable(1));//将字符序列化作为K2值输出,设置V2值为1的序列化值输出
            }
        }
    }
}
