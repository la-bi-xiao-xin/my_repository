package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.ConsumerService;
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
    private ConsumerService consumerService;
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id) {
        // 调用service方法 获取用户信息
        User user = consumerService.findById(id);
        user.setNote(user.getNote()+"消费者服务端口号为:"+ port);
        return user;
    }

}
