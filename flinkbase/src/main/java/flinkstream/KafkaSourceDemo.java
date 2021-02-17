package flinkstream;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/*	开发步骤:
            创建流处理环境
            指定链接kafka相关信息
            创建kafka数据流
            添加Kafka数据源
            打印数据
            执行任务
*/
public class KafkaSourceDemo {
    public static void main(String[] args) throws Exception {

        //1.创建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //2.指定链接kafka相关信息
        Properties properties = new Properties();
        // Set broker
        properties.setProperty("bootstrap.servers", "192.168.88.20:9092");
        // Set group id
        properties.setProperty("group.id", "flinktest");
        // Set auto offset, 如果没有offset记录就默认从最早开始读取
        properties.setProperty("auto.offset.reset", "earliest");
        // 是否自动提交偏移量
//        properties.setProperty("enable.auto.commit", "false");
        // 这个可以通过属性设置, 不过建议通过如setStartFromEarliest这样的方法来设置更加方便和清晰, 下面代码有演示

        String topic = "kafkatopic";

        FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>(
                topic,
                new SimpleStringSchema(),
                properties
        );

        /*
            kafka的source对象可以指定从哪里开始消费
            如:
            kafkaConsumer.setStartFromEarliest();       // 从头开始消费
            kafkaConsumer.setStartFromTimestamp(System.currentTimeMillis()); // 从指定的时间戳开始消费
            kafkaConsumer.setStartFromGroupOffsets();   // 从group 中记录的offset开始消费
            kafkaConsumer.setStartFromLatest();         // 从最新开始消费

            以及指定每个从某个topic的某个分区的某个offset开始消费
            Map<KafkaTopicPartition, Long> offsets = new HashMap<>();
            offsets.put(new KafkaTopicPartition(topic, 0), 0L);
            offsets.put(new KafkaTopicPartition(topic, 1), 0L);
            offsets.put(new KafkaTopicPartition(topic, 2), 0L);
            kafkaConsumer.setStartFromSpecificOffsets(offsets);
            如上, 就指定了topic的分区0,1,2 都分别从offset 0 开始消费.
         */
        kafkaConsumer.setStartFromEarliest();   // 从最早开始消费

        // 通过KafkaConsumer对象, 得到kafka的source对象
        DataStreamSource<String> kafkaSource = env.addSource(kafkaConsumer);

        kafkaSource.print();

        env.execute("KafkaSourceDemo");
    }

}

