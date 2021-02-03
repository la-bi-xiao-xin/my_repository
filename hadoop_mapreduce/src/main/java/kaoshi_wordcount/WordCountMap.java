package kaoshi_wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMap extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {
            String[] split = line.split(" ");
            for (String word : split) {
                context.write(new Text(word),new IntWritable(1));
            }
        }
    }
}
