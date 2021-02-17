package flinkbatch;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.ReduceOperator;
import org.apache.flink.api.java.tuple.Tuple2;

/*读取apache.log日志，统计ip地址访问pv数量，使用 reduce 操作聚合成一个最终结果
步骤
获取 ExecutionEnvironment 运行环境
使用 readTextFile 构建数据源
使用 reduce 执行聚合操作
打印测试
*/
public class FlinkReduceDemo {
    public static void main(String[] args) {

        try {
            //1.获取 ExecutionEnvironment 运行环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            //2.使用 readTextFile 构建数据源
            DataSource<String> dataSource = env.readTextFile("./data/input/test.txt");

            //3.使用 reduce 执行聚合操作
            MapOperator<String, Tuple2<String, Integer>> mapOperator = dataSource.map(new MapFunction<String, Tuple2<String, Integer>>() {
                @Override
                public Tuple2<String, Integer> map(String line) throws Exception {
                    String[] strings = line.split(" ");
                    return Tuple2.of(strings[0], 1);
                }
            });
            ReduceOperator<Tuple2<String, Integer>> reduceOperator = mapOperator.groupBy(0)
                    .reduce(new ReduceFunction<Tuple2<String, Integer>>() {
                        @Override
                        public Tuple2<String, Integer> reduce(Tuple2<String, Integer> t1, Tuple2<String, Integer> t2) throws Exception {
                            return Tuple2.of(t1.f0, t1.f1 + t2.f1);
                        }
                    });


            //4.打印测试
            mapOperator.print();
            reduceOperator.print();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序执行完成!!");
        }
    }
}
