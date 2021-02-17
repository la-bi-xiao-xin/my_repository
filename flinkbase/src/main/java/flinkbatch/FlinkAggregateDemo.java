package flinkbatch;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.aggregation.Aggregations;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;

/*	示例
读取apache.log日志，统计ip地址访问pv数量，使用 aggregate 操作进行PV访问量统计
	步骤
	获取 ExecutionEnvironment 运行环境
	使用 readTextFile 构建数据源
	使用 groupBy 按照单词进行分组
	使用 aggregate 对每个分组进行 SUM 统计
	打印测试

*/
public class FlinkAggregateDemo {
    public static void main(String[] args) throws Exception {
        //1.获取 ExecutionEnvironment 运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //2.使用 readTextFile 构建数据源
        DataSource<String> dataSource = env.readTextFile("./data/input/test.txt");

        //3.使用 groupBy 按照单词进行分组
        MapOperator<String, Tuple2<String, Integer>> mapOperator = dataSource.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String line) throws Exception {
                return Tuple2.of(line.split(" ")[0], 1);
            }
        });

        UnsortedGrouping<Tuple2<String, Integer>> grouping = mapOperator.groupBy(0);

        //4.使用 aggregate 对每个分组进行 SUM 统计
        AggregateOperator<Tuple2<String, Integer>> aggregate = grouping.aggregate(Aggregations.SUM, 1);
        AggregateOperator<Tuple2<String, Integer>> aggregate1 = grouping.aggregate(Aggregations.MAX, 1);
        AggregateOperator<Tuple2<String, Integer>> aggregate2 = grouping.aggregate(Aggregations.MIN, 1);

        //5.打印测试结果
        aggregate.print();
        System.out.println("********************");
        aggregate1.print();
        System.out.println("********************");
        aggregate2.print();

    }
}
