package flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMap extends Mapper<LongWritable, Text, Text, FlowPojo> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {//判断line是否合法
            String[] split = line.split("\t");
            //封装V2
            FlowPojo flowPojo = new FlowPojo(Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]));

            context.write(new Text(split[1]), flowPojo);//输出K2,V2
        }
    }
}
