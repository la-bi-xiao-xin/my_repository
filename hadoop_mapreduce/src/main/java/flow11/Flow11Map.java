package flow11;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.io.IOException;

public class Flow11Map extends Mapper<LongWritable, Text, Flow11Pojo, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {

            String[] split = line.split("\t");
            Flow11Pojo flow11Pojo = new Flow11Pojo(
                    split[1],
                    Integer.parseInt(split[6]),
                    Integer.parseInt(split[7]),
                    Integer.parseInt(split[8]),
                    Integer.parseInt(split[9]));
            context.write(flow11Pojo, NullWritable.get());
        }
    }
}
