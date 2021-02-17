package flinkstream;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;
import java.util.UUID;

/*	示例:
自定义数据源, 每1秒钟随机生成一条订单信息(订单ID、用户ID、订单金额、时间戳)
	要求:
	随机生成订单ID（UUID）
	随机生成用户ID（0-2）
	随机生成订单金额（0-100）
	时间戳为当前系统时间

	开发步骤:
	创建订单实体类
	创建自定义数据源
	死循环生成订单
	随机构建订单信息
	上下文收集数据
	每隔一秒执行一次循环
	获取流处理环境
	使用自定义Source
	打印数据
	执行任务
*/
public class FlinkStreamDefineDataSource {
    public static void main(String[] args) throws Exception {
        //1.构建订单的pojo类
        //2.创建自定义数据源

        //3.获取流处理环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //4.使用自定义Source
        DataStreamSource<OrderInfo> addSource = env.addSource(new MyDataSource());

        //5.打印结果
        addSource.print();

        //6.触发执行
        env.execute();

    }
    public static class MyDataSource implements SourceFunction<OrderInfo> {
        private boolean isRun = true;   // 关闭循环标记
        @Override
        public void run(SourceContext<OrderInfo> sourceContext) throws Exception {
            Random random = new Random();
            while (isRun){
                String id = UUID.randomUUID().toString();
                int userID = random.nextInt(99) ;
                int money = random.nextInt(999);
                long time = System.currentTimeMillis();

                sourceContext.collect(new OrderInfo(id,userID, money, time));
                Thread.sleep(1000L);

            }
        }

        @Override
        public void cancel() {
            this.isRun = false;
        }
    }


    public static class OrderInfo{
        //随机生成订单ID（UUID）
        //	随机生成用户ID（0-2）
        //	随机生成订单金额（0-100）
        //	时间戳为当前系统时间

        String id;
        int userID;
        double money;
        long time;

        public OrderInfo() {
        }

        public OrderInfo(String id, int userID, double money, long time) {
            this.id = id;
            this.userID = userID;
            this.money = money;
            this.time = time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "OrderInfo{" +
                    "id=" + id +
                    ", userID=" + userID +
                    ", money=" + money +
                    ", time=" + time +
                    '}';
        }
    }
}
