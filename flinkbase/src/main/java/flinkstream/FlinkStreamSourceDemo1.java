package flinkstream;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

public class FlinkStreamSourceDemo1 {
    public static void main(String[] args) throws Exception {
        //1.获取流数据执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //2.构建本地数据源
        DataStreamSource<String> dataStreamSource = env.fromElements("hadoop", "hive", "spark", "flink");

        ArrayList<String> list = new ArrayList<>();
        list.add("hbase");
        list.add("kafka");
        list.add("hdfs");
        DataStreamSource<String> stringDataStreamSource = env.fromCollection(list);

        //3.打印结果
        dataStreamSource.print();
        stringDataStreamSource.print();

        //4.触发执行
        env.execute();
    }
}
