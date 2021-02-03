package flowcop;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducerTask extends Reducer<Text, FlowBean, Text, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        //1. 遍历,每组的数据, 将每个数据进行累加
        Integer upFlow = 0;
        Integer downFlow = 0;
        Integer upTotalFlow = 0;
        Integer downTotalFlow = 0;

        for (FlowBean value : values) {
            upFlow += value.getUpFlow();
            downFlow += value.getDownFlow();
            upTotalFlow += value.getUpTotalFlow();
            downTotalFlow += value.getDownTotalFlow();
        }

        // 2. 写出去
        String k3 = key.toString() +"\t"+ upFlow +"\t"+ downFlow +"\t"+ upTotalFlow +"\t"+ downTotalFlow ;
        context.write(new Text(k3),NullWritable.get());




    }
}
