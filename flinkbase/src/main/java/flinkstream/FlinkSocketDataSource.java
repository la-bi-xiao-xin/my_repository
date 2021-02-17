package flinkstream;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkSocketDataSource {
    public static void main(String[] args) throws Exception {
        //1.获取流处理执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //2.读取socket数据源
        String host = "192.168.88.20";
        int port = 9999;

        DataStreamSource<String> socketTextStream = env.socketTextStream(host, port);

        //3.打印结果
        socketTextStream.print();

        //4.触发执行
        env.execute();
    }
}
