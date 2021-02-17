package flinkbatch;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FilterOperator;

/*读取apache.log文件中的访问日志数据，过滤出来以下访问IP是83.149.9.216的访问日志。
	步骤
    获取ExecutionEnvironment运行环境
    读取文件
    使用filter操作执行过滤
    打印测试
*/
public class FlinkFilterDemo {
    public static void main(String[] args) {
        try {
            //1.获取ExecutionEnvironment运行环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            //2.读取文件获取数据
            DataSource<String> dataSource = env.readTextFile("./data/input/test.txt");

            //3.使用filter操作执行过滤
            FilterOperator<String> filterOperator = dataSource.filter(new FilterFunction<String>() {
                @Override
                public boolean filter(String line) throws Exception {
                    String[] strings = line.split(" ");
                    Boolean result = strings[0].equals("83.149.9.216");
                    return result;
                }
            });

            filterOperator.print();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序执行完成!!");
        }
    }
}
