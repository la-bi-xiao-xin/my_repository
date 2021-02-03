package cn.itcast.pojo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

// @ConfigurationProperties(prefix = "person") 将配置文件信息注入到这个pojo类中
@ConfigurationProperties(prefix = "person")
// 将当前类 放到spring容器中
@Component
// @Data 这是lombok注解, 帮助我们生成 get/set/toString等方法
@Data
public class Person {
    private String name;
    private int age;
    private String sex;
    private String[] likes;
    private List<Book> bookes;
}
