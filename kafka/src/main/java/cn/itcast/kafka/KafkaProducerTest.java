package cn.itcast.kafka;


import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaProducerTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建用于连接Kafka的Properties配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "node1:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 2. 传入配置对象创建一个生产者对象KafkaProducer
         KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        // 3. 调用send发送1-100消息到指定Topic test
        for (int i = 0; i <1000000 ; i++) {
            ProducerRecord<String, String> recod = new ProducerRecord<>("test_10m", null,  i+ "");
            Future<RecordMetadata> future = producer.send(recod);
            future.get();
            System.out.println("生产成功"+i);
            //Thread.sleep(3000);
        }
        // 5. 关闭生产者
        producer.close();
    }
}
