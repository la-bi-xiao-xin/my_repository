package reverse;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class ReverseMap extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {
            String[] words = line.split(" ");
            for (String word : words) {
                //获取文件名,通过分片对象调用方法获取分片文件名
                //获取分片对象,togguo
               FileSplit fileSplit =(FileSplit) context.getInputSplit();
                String filename = fileSplit.getPath().getName();
                context.write(new Text(word+"-"+filename),new IntWritable(1));

            }
        }
    }
}
