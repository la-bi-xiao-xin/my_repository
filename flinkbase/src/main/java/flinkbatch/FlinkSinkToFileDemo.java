package flinkbatch;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSink;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.core.fs.FileSystem;

public class FlinkSinkToFileDemo {
    public static void main(String[] args) throws Exception {
        //1.创建批处理环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //2.创建本地数据源
        DataSource<Long> longDataSource = env.generateSequence(1, 10);

        //3.sink到文件中
        DataSink<Long> longDataSink = longDataSource
                .writeAsText("./data/output/result.txt", FileSystem.WriteMode.OVERWRITE).setParallelism(1);

        //4.执行任务
        env.execute();
    }
}
