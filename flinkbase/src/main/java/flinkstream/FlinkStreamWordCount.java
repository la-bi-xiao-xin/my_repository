package flinkstream;


import org.apache.calcite.sql.advise.SqlSimpleParser;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class FlinkStreamWordCount {
    public static void main(String[] args) throws Exception {
        //1、设置运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
       //2、配置数据源读取数据
        DataStream<String> text = env.readTextFile("F:\\idea_project\\flinkbase\\data\\input\\wordcount.txt");
       //3、进行一系列转换
        SingleOutputStreamOperator<String> flatMap = text.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String line, Collector<String> collector) throws Exception {
                String[] strings = line.split(" ");
                for (String string : strings) {
                    collector.collect(string);

                }

                //return null;
            }
        });
        SingleOutputStreamOperator<Tuple2<String, Integer>> map = flatMap.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {
                return Tuple2.of(s, 1);
            }
        });
        SingleOutputStreamOperator<Tuple2<String, Integer>> counts = map.keyBy(0).sum(1);
//4、配置数据汇写出数据
        counts.writeAsText("./data/output/WordCount.txt", FileSystem.WriteMode.OVERWRITE);
//5、提交执行
        env.execute("Streaming WordCount");


        //执行结果是和预期的不同,中间结果也被保存到文件中去了


    }


}
