package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient // 开启eureka客户端
//@EnableCircuitBreaker // 开启熔断服务

@SpringCloudApplication // 以一敌三
public class UserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }

    // 将RestTemplate对象交给spring管理
    @Bean
    @LoadBalanced // 开启负载均衡
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }



}
