package flinkbatch;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*	步骤:
       获取批处理运行环境
       分别创建两个数据集
       使用 RichMapFunction 对 成绩 数据集进行map转换
       在数据集调用 map 方法后，调用 withBroadcastSet 将 学生 数据集创建广播
       实现 RichMapFunction
       将成绩数据(学生ID，学科，成绩) -> (学生姓名，学科，成绩)
       重写 open 方法中，获取广播数据
       在 map 方法中使用广播进行转换
       打印测试
*/
public class FlinkBoardcastDemo {
    public static void main(String[] args) throws Exception {
        //1.获取批处理运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //2.分别创建两个数据集
        DataSource<Tuple2<Integer, String>> studentInfoDataSet  = env.fromElements(
                Tuple2.of(1, "王大锤"),
                Tuple2.of(2, "潇潇"),
                Tuple2.of(3, "甜甜")
        );

        DataSource<Tuple3<Integer, String, Integer>> scoreInfoDataSet  = env.fromElements(
                Tuple3.of(1, "数据结构", 99),
                Tuple3.of(2, "英语", 100),
                Tuple3.of(3, "C++", 96),
                Tuple3.of(5, "Java", 97),
                Tuple3.of(3, "Scala", 100)
        );

        //3. 在数据集调用 map 方法后，调用 withBroadcastSet 将 学生 数据集创建广播
        //       实现 RichMapFunction
        //       将成绩数据(学生ID，学科，成绩) -> (学生姓名，学科，成绩)
        //       重写 open 方法中，获取广播数据
        //       在 map 方法中使用广播进行转换

        MapOperator<Tuple3<Integer, String, Integer>, Tuple3<String, String, Integer>> tuple3MapOperator = scoreInfoDataSet
                .map(new RichMapFunction<Tuple3<Integer, String, Integer>, Tuple3<String, String, Integer>>() {
                    // 定义一个map用来存储从广播变量中取得的学生信息
                    Map<Integer, String> map = new HashMap<Integer, String>();

                    /*
                    open 方法在实例化的开始, 会执行一次
                     */
                    @Override
                    public void open(Configuration parameters) throws Exception {
                        // 在open方法内将广播变量中的学生信息写入到map中
                        List<Tuple2<Integer, String>> broadcastVariable = getRuntimeContext().getBroadcastVariable("student");
                        for (Tuple2<Integer, String> stu : broadcastVariable) {
                            map.put(stu.f0, stu.f1);
                        }
                    }
            @Override
            public Tuple3<String, String, Integer> map(Tuple3<Integer, String, Integer> in) throws Exception {
                return Tuple3.of(map.getOrDefault(in.f0,"未知学生"),in.f1,in.f2);
            }
        }).withBroadcastSet(studentInfoDataSet, "student");


        //4.打印结果
        tuple3MapOperator.print();

        //5.结果sink到文件中
        tuple3MapOperator.writeAsText("data/output/joinResult.txt", FileSystem.WriteMode.OVERWRITE);
        tuple3MapOperator.writeAsCsv("data/output/joinResult2.csv", FileSystem.WriteMode.OVERWRITE);

        env.execute();
    }
}
