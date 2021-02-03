package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient      // 开启eureka客户端
@EnableFeignClients         // 开启feign

public class ItemConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemConsumerApplication.class, args);
    }

}
