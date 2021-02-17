package flinkbatch;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.*;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class batchWordCount {
    public static void main(String[] args) throws Exception {
        //获取批处理运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //	指定读取文件路径，获取数据
        DataSource<String> stringDataSource = env.readTextFile("./data/input/wordcount.txt");
        
        //	对获取到的数据进行空格拆分
        FlatMapOperator<String, String> flatMap = stringDataSource.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String line, Collector<String> collector) throws Exception {
                String[] strings = line.split(" ");
                for (String string : strings) {
                    collector.collect(string);
                }
            }
        });

        //	对拆分后的单词，每个单词记一次数
        MapOperator<String, Tuple2<String, Integer>> map = flatMap.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {

                return Tuple2.of(s, 1);
            }
        });

        //	对拆分后的单词进行分组
        UnsortedGrouping<Tuple2<String, Integer>> grouping = map.groupBy(0);

        //	根据单词的次数进行聚合
        AggregateOperator<Tuple2<String, Integer>> sum = grouping.sum(1);

        //	打印输出
            sum.print();

        //	启动执行

    }
}
