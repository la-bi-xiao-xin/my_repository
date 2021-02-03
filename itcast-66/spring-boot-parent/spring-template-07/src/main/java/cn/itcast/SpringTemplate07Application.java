package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTemplate07Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTemplate07Application.class, args);
    }


    // 创建RestTemplate对象 交给spring管理
    // <bean id="restTemplate" class="org.springframework.web.client.RestTemplate"/>
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
