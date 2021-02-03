package cn.itcast.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. 创建用于连接Kafka的Properties配置
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "node1:9092");
        props.setProperty("group.id", "test1");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
//        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

           //* 2.创建Kafka消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        //* 3.订阅要消费的主题
        consumer.subscribe(Arrays.asList("test"));
           //* 4.使用一个while循环，不断从Kafka的topic中拉取消息
       while (true){
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(5));
        //* 5.将将记录（record）的offset、key、value都打印出来
        for (ConsumerRecord<String, String> record : poll) {
            String key = record.key();
            long offset = record.offset();
            String value = record.value();
            System.out.println("消费"+"offset"+offset+"  key值:"+key+"  value值:"+value);
        }
    }
       // Thread.sleep(10 * 10000);
    }
}
