package cn.itcast.usercondumerfeign2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserCondumerFeign2Application {

    public static void main(String[] args) {
        SpringApplication.run(UserCondumerFeign2Application.class, args);
    }

}
