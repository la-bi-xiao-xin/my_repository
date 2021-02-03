package cn.itcast.controller;

import cn.itcast.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private Integer port;

    // 增加熔断处理
    @HystrixCommand(fallbackMethod = "myFallbackMethod")
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id) {
        String url = "http://user-provider/user/findById/" + id;
        User user = restTemplate.getForObject(url, User.class);
        user.setNote("**"+user.getNote()+"消费者服务端口号为"+port);
        return user;

    }

    // 熔断处理逻辑
    public User myFallbackMethod(int id){
        User user = new User();
        user.setId(id);
        user.setNote("熔断方法 ... ..." + new Date().toLocaleString()); // 设置备注
        return user;
    }

}
