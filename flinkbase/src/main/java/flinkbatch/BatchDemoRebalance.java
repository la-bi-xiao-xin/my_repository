package flinkbatch;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FilterOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.PartitionOperator;
import org.apache.flink.api.java.tuple.Tuple2;

/*	步骤:
       构建批处理运行环境
       使用 env.generateSequence 创建0-100的并行数据
       使用 fiter 过滤出来 大于8 的数字
       使用map操作传入 RichMapFunction ，将当前子任务的ID和数字构建成一个元组
       在RichMapFunction中可以使用 getRuntimeContext.getIndexOfThisSubtask 获取子任务序号
       打印测试
*/
public class BatchDemoRebalance {
    public static void main(String[] args) throws Exception {
        //1.构建批处理运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //2.使用 env.generateSequence 创建0-100的并行数据
        DataSource<Long> longDataSource = env.generateSequence(0, 100);

        //3.使用 fiter 过滤出来 大于8 的数字
        FilterOperator<Long> filter = longDataSource.filter(new FilterFunction<Long>() {
            @Override
            public boolean filter(Long aLong) throws Exception {
                return aLong > 8;
            }
        });


        //4.使用map操作传入 RichMapFunction ，将当前子任务的ID和数字构建成一个元组
        MapOperator<Long, Tuple2<Long, Integer>> mapOperator = filter.map(new RichMapFunction<Long, Tuple2<Long, Integer>>() {
            @Override
            public Tuple2<Long, Integer> map(Long aLong) throws Exception {
                return Tuple2.of(aLong, getRuntimeContext().getIndexOfThisSubtask());
            }
        });

        //5.打印未使用rebulance前的执行分配结果
        mapOperator.print();


        //6.使用reblance
        PartitionOperator<Long> rebalance = filter.rebalance();

        MapOperator<Long, Tuple2<Long, Integer>> mapOperator2 = rebalance.map(new RichMapFunction<Long, Tuple2<Long, Integer>>() {
            @Override
            public Tuple2<Long, Integer> map(Long aLong) throws Exception {
                return Tuple2.of(aLong, getRuntimeContext().getIndexOfThisSubtask());
            }
        });

        //7.打印reblance处理后的执行分配结果
        mapOperator.print();
    }
}
