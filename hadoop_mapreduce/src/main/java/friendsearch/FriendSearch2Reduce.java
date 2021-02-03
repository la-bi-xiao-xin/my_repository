package friendsearch;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FriendSearch2Reduce extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
       String v3="";
        for (Text value : values) {
            v3+=value+",";
        }
        v3 = v3.substring(0,v3.lastIndexOf(","));
        context.write(key,new Text(v3));
    }
}
