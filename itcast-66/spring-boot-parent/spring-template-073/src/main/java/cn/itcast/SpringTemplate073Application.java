package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTemplate073Application {  //项目驱动类 springboot框架自动生成

    public static void main(String[] args) {
        SpringApplication.run(SpringTemplate073Application.class, args);
    }


    @Bean   //提交给spring管理此类
    //改造驱动类,增加Reattemplate 驱动函数
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
