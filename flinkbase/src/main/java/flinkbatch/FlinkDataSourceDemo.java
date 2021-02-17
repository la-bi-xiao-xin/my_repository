package flinkbatch;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;

import java.util.ArrayList;

/*	使用env.fromElements()
 * 	使用env.fromCollection()
 * 	使用env.generateSequence()*/
public class FlinkDataSourceDemo {
    public static void main(String[] args) {

        //1.获取执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        int ErrorNumber = 0;
        //设置全局并行度12
        env.setParallelism(12);
        System.out.println(env.getParallelism());
        try {
            //2.构建本地数据源
            //2.1使用env.fromElements()
            DataSource<String> fromElements = env.fromElements("hadoop", "spark", "flinkbatch");
            // DataSource<? extends Serializable> fromElements1 = env.fromElements(1, "hadoop");

            //2.2使用env.fromCollection()  list set queue
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("大数据");
            arrayList.add("时代");
            arrayList.add("来临");
            DataSource<String> fromCollection = env.fromCollection(arrayList);

            //2.3使用env.generateSequence()
            DataSource<Long> generateSequence = env.generateSequence(1, 10);

            // 3.打印数据集
            //fromElements.print();
            // fromElements1.print();
            //fromCollection.print();
            generateSequence.print();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("执行打印出错");
            ErrorNumber++;
        } finally {
            System.out.println("错误数量为:" + ErrorNumber);
        }


    }
}
