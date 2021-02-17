package flinkbatch;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.DistinctOperator;
import org.apache.flink.api.java.operators.MapOperator;

public class FlinkDistinctDemo {
    public static void main(String[] args) {
        try {
            //1.获取环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            //2.读取文件数据
            DataSource<String> dataSource = env.readTextFile("./data/input/test.txt");

            //3.经行map转换
            MapOperator<String, String> mapOperator = dataSource.map(new MapFunction<String, String>() {
                @Override
                public String map(String line) throws Exception {
                    return line.split(" ")[0];
                }
            });

            //4.进行去重操作
            DistinctOperator<String> distinctOperator = mapOperator.distinct();

            //5.打印测试结果
            distinctOperator.print();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序执行结束");
        }
    }
}
