package flinkstream;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.util.UUID;

/**
 * 自定义一个RichParallelSourceFunction的实现
 */
public class CustomerRichSourceWithParallelDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> mySource = env.addSource(new MySource()).setParallelism(6);
        mySource.print();

        env.execute();
    }

    /*
    Rich 类型的Source可以比非Rich的多出有：
    - open方法，实例化的时候会执行一次，多个并行度会执行多次的哦（因为是多个实例了）
    - close方法，销毁实例的时候会执行一次，多个并行度会执行多次的哦
    - getRuntime方法可以获得当前的Runtime对象（底层API）
     */
    public static class MySource extends RichParallelSourceFunction<String> {
        private static boolean isRun = true;
        //private static int count=0;
        @Override
        public void open(Configuration parameters) throws Exception {
            super.open(parameters);
            System.out.println("open......");
        }

        @Override
        public void close() throws Exception {
            super.close();
            System.out.println("close......");
        }

        @Override
        public void run(SourceContext<String> ctx) throws Exception {
            while (isRun){
                ctx.collect(UUID.randomUUID().toString());
              //  count++;
            }

        }

        @Override
        public void cancel() {
            this.isRun = false;
           /* if(this.count==100){
                this.isRun = false;
            }*/

        }
    }
}

