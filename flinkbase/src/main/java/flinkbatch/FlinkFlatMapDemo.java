package flinkbatch;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/*	步骤
    构建批处理运行环境
    构建本地集合数据源
    使用flatMap将一条数据经过处理转换为三条数据
    使用逗号分隔字段
    分别构建三条数据
    打印输出
*/
public class FlinkFlatMapDemo {
    public static void main(String[] args) {
        try {
            //1.构建批处理运行环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            //2.读取文件构建本地集合数据源
            DataSource<String> fileData = env.readTextFile("F:\\idea_project\\flinkbase\\data\\input\\flatmap.log");

            //3.使用flatMap将一条数据经过处理转换为三条数据
            FlatMapOperator<String, String> flatMapOperator = fileData.flatMap(new FlatMapFunction<String, String>() {
                @Override
                public void flatMap(String line, Collector<String> collector) throws Exception {
                    String[] strings = line.split(",");
                    collector.collect(strings[0] + "有" + strings[1]);
                    collector.collect(strings[0] + "有" + strings[2]);
                    collector.collect(strings[0] + "有" + strings[3]);
                }
            });
            flatMapOperator.print();

            MapOperator<String, Tuple2<String, Integer>> mapOperator = flatMapOperator.map(new MapFunction<String, Tuple2<String, Integer>>() {
                @Override
                public Tuple2<String, Integer> map(String string) throws Exception {

                    return Tuple2.of(string, 1);
                }
            });

            mapOperator.print();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序执行完成!!");
        }


    }
}
