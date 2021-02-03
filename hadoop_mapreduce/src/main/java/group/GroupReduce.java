package group;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class GroupReduce extends Reducer<GroupPojo, NullWritable,GroupPojo, NullWritable> {
    @Override
    protected void reduce(GroupPojo key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        for (NullWritable value : values) {
            context.write(key,NullWritable.get());
            break;
        }
    }
}
