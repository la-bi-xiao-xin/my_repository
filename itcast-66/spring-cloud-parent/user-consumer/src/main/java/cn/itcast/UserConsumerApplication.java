package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableEurekaClient   //开启eureka客户端 方式一
//@EnableDiscoveryClient  //开启eureka客户端 方式二, 不仅可以 eureka客户端, 还可以开通其他的eureka客户端

@SpringCloudApplication // 以一敌三
public class UserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);

    }
//创建远程调用类 并提交给spring管理
    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }



}
