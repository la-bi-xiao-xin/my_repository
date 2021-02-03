package flow2;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Flow2Reduce extends Reducer<Flow2Pojo, NullWritable,Flow2Pojo, NullWritable> {
    @Override
    protected void reduce(Flow2Pojo key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        for (NullWritable value : values) {
            context.write(key,NullWritable.get());
        }
    }
}
