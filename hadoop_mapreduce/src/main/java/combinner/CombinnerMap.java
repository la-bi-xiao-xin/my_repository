package combinner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CombinnerMap extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {
           if(line.contains("入门")){
            context.write(new Text("计算机类"),new IntWritable(1));
           }else if(line.contains("史记")||line.contains("论清王朝的腐败")){
               context.write(new Text("历史类"),new IntWritable(1));
           }else
               context.write(new Text("武侠类"),new IntWritable(1));
        }
    }
}
