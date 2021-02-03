package flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReduce extends Reducer<Text,FlowPojo,Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<FlowPojo> values, Context context) throws IOException, InterruptedException {
        Integer upFlow=0;
        Integer downFlow=0;
        Integer upFlowTotal=0;
        Integer downFlowTotal=0;
        for (FlowPojo value : values) {
            upFlow+=value.getUpFlow();
            downFlow+=value.getDownFlow();
            upFlowTotal+=value.getUpFlowTotal();
            downFlowTotal+=value.getDownFlowTotal();
        }
        String k3= upFlow+"\t"+downFlow+"\t"+upFlowTotal+"\t"+downFlowTotal;
        context.write(key,new Text(k3));
    }
}
