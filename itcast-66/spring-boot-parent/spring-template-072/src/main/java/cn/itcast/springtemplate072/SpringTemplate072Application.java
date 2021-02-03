package cn.itcast.springtemplate072;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTemplate072Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTemplate072Application.class, args);
    }



    //创建restTemplate 类并提交给spring
    public RestTemplate createRestTemplate() {
        return new RestTemplate();

    }
}
