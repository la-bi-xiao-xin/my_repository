package sort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortReduce extends Reducer<SortPojo, NullWritable,SortPojo,NullWritable> {
    @Override
    protected void reduce(SortPojo key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        for (NullWritable value : values) {
            context.write(key,value);

        }
    }
}
