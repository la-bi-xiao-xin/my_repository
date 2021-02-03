package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTemplate074Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTemplate074Application.class, args);
    }


    //在驱动类中创建远程调用类,并提交给springboot管理
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
