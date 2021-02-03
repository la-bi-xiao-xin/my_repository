package group;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class GroupMap extends Mapper<LongWritable, Text, GroupPojo, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {
            String[] split = line.split("\t");
            GroupPojo groupPojo = new GroupPojo(split[0], split[1], Double.parseDouble(split[2]));
            context.write(groupPojo,NullWritable.get());//输出K2,V2
        }
    }
}
