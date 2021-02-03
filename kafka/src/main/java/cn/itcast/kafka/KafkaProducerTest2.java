package cn.itcast.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerTest2 {
    public static void main(String[] args) throws InterruptedException {
        //1. 创建用于连接Kafka的Properties配置
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "node1:9092");
        properties.put("acks", "all");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 2. 传入配置参数
        // 创建一个生产者对象KafkaProducer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        // 3. 调用send发送1-100消息到指定Topic test
        // 4.带回调函数异步方式
        for (int i = 1100; i <11000 ; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("test", null, i + "");
            Future<RecordMetadata> future = producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e!=null){
                        System.out.println("消息发送异常");
                    }else {
                        String topic = recordMetadata.topic();
                        int partition = recordMetadata.partition();
                        long offset = recordMetadata.offset();
                        System.out.println("发送消息到Kafka中的名字为" + topic + "的主题，第" + partition + "分区，第" + offset + "条数据成功!");

                    }
                }
            });
            Thread.sleep(5000);
        }

        // 5. 关闭生产者
        producer.close();
    }
}
