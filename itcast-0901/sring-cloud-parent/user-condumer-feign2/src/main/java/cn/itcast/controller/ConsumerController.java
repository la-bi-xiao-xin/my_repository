package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    // 增加熔断处理
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id) {
        // 调用service方法 获取用户信息
        return consumerService.findById(id);
    }

    /*
        @Autowired
        private RestTemplate restTemplate;

        // 增加熔断处理
        @GetMapping("/findById/{id}")
        public User findById(@PathVariable("id") int id) {
            String url = "http://user-provider/user/findById/" + id;
            User user = restTemplate.getForObject(url, User.class);
            return user;
        }
     */
}