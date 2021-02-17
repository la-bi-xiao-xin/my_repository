package flinkbatch;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;

import java.util.List;

public class FlinkSinkDemo {
    public static void main(String[] args) {
        //1.创建批处理环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //2.创建本地数据源
        DataSource<Long> longDataSource = env.generateSequence(1, 10);

        try {
            //3.sink到本地
            List<Long> collect = longDataSource.collect();

            //4.打印sink结果
            for (Long aLong : collect) {

                System.out.println(aLong);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据回收失败");
        } finally {
            System.out.println("程序执行结束");
        }
    }
}
