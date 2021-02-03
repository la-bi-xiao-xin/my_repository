package flow11;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Flow11Reduce extends Reducer<Flow11Pojo, NullWritable,Flow11Pojo, NullWritable> {
    @Override
    protected void reduce(Flow11Pojo key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        Integer upFlow=0;
        Integer downFlow=0;
        Integer upFlowTotal=0;
        Integer downFlowTotal=0;
        for (NullWritable value : values) {
            upFlow+=key.getUpFlow();
            downFlow+=key.getDownFlow();
            upFlowTotal+=key.getUpFlowTotal();
            downFlowTotal+=key.getDownFlowTotal();
        }
        Flow11Pojo flow11Pojo = new Flow11Pojo(key.getPhone(),upFlow,downFlow,upFlowTotal,downFlowTotal);
        context.write(flow11Pojo,NullWritable.get());

        }
    }

