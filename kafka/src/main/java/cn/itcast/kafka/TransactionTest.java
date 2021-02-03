package cn.itcast.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.ProducerFencedException;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.Future;

/*我们需要编写程序，将用户的性别转换为男、女（1-男，0-女），
转换后将数据写入到topic 「dwd_user」中。要求使用事务保障，
要么消费了数据同时写入数据到 topic，提交offset。要么全部失败。*/
public class TransactionTest {
    public static void main(String[] args) {
        KafkaConsumer<String, String> consumer = createConsumer();
        Producer<String, String> producer = createProduceer();
        // 初始化事务
        producer.initTransactions();
        while(true){
        try {
            // 1. 开启事务
            producer.beginTransaction();
            // 2. 定义Map结构，用于保存分区对应的offset
            Map<TopicPartition, OffsetAndMetadata> offset = new HashMap<>();
            // 2. 订阅并拉取消息
            consumer.subscribe(Arrays.asList("ods_user"));
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            for (ConsumerRecord<String, String> record : records) {
                // 3. 保存偏移量
                offset.put(new TopicPartition(record.topic(),record.partition()),new OffsetAndMetadata(record.offset()+1));
                // 4. 进行转换处理
                String value = record.value();
                String[] strings = value.split(",");
                if("1".equals(strings[1])){
                    strings[1]="男";

                }else if ("0".equals(strings[1])){
                    strings[1]="女";
                }
                String masg=strings[0]+","+strings[1]+","+strings[2];
                // 5. 生产消息到dwd_user
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>("dwd_user", null, masg);
                Future<RecordMetadata> send = producer.send(producerRecord);

                // 模拟异常
               //int i = 1/0;


            }
            // 6. 提交偏移量到事务
            producer.sendOffsetsToTransaction(offset,"ods_consumer");

            // 7. 提交事务
            producer.commitTransaction();
        } catch (ProducerFencedException e) {
            e.printStackTrace();
            producer.abortTransaction();
        }

        }
    }

    //创建向ods层消费消息的对象
    public static KafkaConsumer<String, String> createConsumer() {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "node1:9092");
        props.setProperty("group.id", "ods_consumer");
        props.put("isolation.level", "read_committed");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        return consumer;

    }

    //创建从dwd生产消息的对象
    public static Producer<String, String> createProduceer() {
        // 1. 创建生产者配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "node1:9092");
        props.put("transactional.id", "ods_dwd");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 2. 创建生产者
        Producer<String, String> producer = new KafkaProducer<>(props);
        return producer;
    }

}
