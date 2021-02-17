package flinkbatch;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.GroupReduceOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/*	示例
读取apache.log日志，统计ip地址访问pv数量，使用 reduceGroup 操作聚合成一个最终结果

	步骤
	获取 ExecutionEnvironment 运行环境
	使用 readTextFile 构建数据源
	使用 groupBy 按照单词进行分组
	使用 reduceGroup 对每个分组进行统计
	打印测试
*/
public class FlinkReduceGroupDemo {
    public static void main(String[] args) {

        try {
            //1.获取 ExecutionEnvironment 运行环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            //2.使用 readTextFile 构建数据源
            DataSource<String> dataSource = env.readTextFile("./data/input/test.txt");
            dataSource.print();

            //3.使用 groupBy 按照单词进行分组
            //3.1使用map对数据源进行转换(value,1)
            MapOperator<String, Tuple2<String, Integer>> mapOperator = dataSource.map(new MapFunction<String, Tuple2<String, Integer>>() {
                @Override
                public Tuple2<String, Integer> map(String line) throws Exception {
                    String[] strings = line.split(" ");
                    return Tuple2.of(strings[0], 1);
                }
            });
            //4.对(value,1)进行分组,并使用reduceGroup进行分组统计
            UnsortedGrouping<Tuple2<String, Integer>> grouping = mapOperator.groupBy(0);
            GroupReduceOperator<Tuple2<String, Integer>, Tuple2<String, Integer>> groupReduceOperator = grouping.reduceGroup(new GroupReduceFunction<Tuple2<String, Integer>, Tuple2<String, Integer>>() {
                @Override
                public void reduce(Iterable<Tuple2<String, Integer>> in, Collector<Tuple2<String, Integer>> out) throws Exception {
                    String key = "";
                    int count = 0;
                    for (Tuple2<String, Integer> t2 : in) {
                        key = t2.f0;
                        count += t2.f1;
                    }
                    out.collect(Tuple2.of(key, count));
                }
            });

            //5.打印测试
            groupReduceOperator.print();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println("程序执行完了!!");
        }

    }
}
