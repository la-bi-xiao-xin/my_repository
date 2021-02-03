package friendsearch;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FriendSearchReduce extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String v3 = "";
        for (Text value : values) {
           v3+=value+"-";
        }
        context.write(key, new Text(v3));
    }
}
