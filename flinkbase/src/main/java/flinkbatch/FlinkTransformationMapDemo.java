package flinkbatch;

import Pojo.ApacheLogEvent;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;

/*
* 	步骤
    获取ExecutionEnvironment运行环境
    使用readTextFile读取数据构建数据源
    创建一个ApacheLogEvent类
    使用map操作执行转换
    打印测试
*/
public class FlinkTransformationMapDemo {
    public static void main(String[] args) {
        try {
            //1.获取ExecutionEnvironment运行环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();


            //2.使用readTextFile读取数据构建数据源
            DataSource<String> logData = env.readTextFile("./data/input/apache.log");

            //3. 创建一个ApacheLogEvent类
           // logData.print();

            //4.使用map操作执行转换
            MapOperator<String, ApacheLogEvent> mapOperator = logData.map(new MapFunction<String, ApacheLogEvent>() {
                @Override
                public ApacheLogEvent map(String line) throws Exception {
                    String[] strings = line.split(" ");
                    return new ApacheLogEvent(strings[0], Integer.parseInt(strings[1]), strings[2], strings[3], strings[4]);
                }
            });
            mapOperator.print();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序执行结束!!!!");
        }
    }
}
