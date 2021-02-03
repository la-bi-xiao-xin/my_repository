package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient //开启euraka注册服务
@EnableFeignClients  //开启feigan服务
public class UserConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerFeignApplication.class, args);
    }

}
