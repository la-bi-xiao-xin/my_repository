package friendsearch;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FriendSearchMap extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {
            String[] split = line.split(":");
            String[] split1 = split[1].split(",");
            for (String s : split1) {
                context.write(new Text(split[0]),new Text(s));
            }
        }
    }
}
