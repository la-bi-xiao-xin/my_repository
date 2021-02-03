package cn.itcast.controller;

import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("consumer")  //注解 将此类与首页url的类名映射
public class ConsumerController {

    @Autowired //注解  依据创建对象语句进行自动注入spring对象,前提是该类已经交由spring管理
    private RestTemplate restTemplate;

// <a href="/consumer/findAll">测试</a>
    @GetMapping("findAll") //注解 将此方法与首页url的方法名映射
    public List<User> findAll() {
        String url = "http://localhost:8011/user/findAll";
        User[] userArr = restTemplate.getForObject(url, User[].class);
        List<User> userList = Arrays.asList(userArr);
        return userList;

    }
// <a href="/consumer/findById/2">测试</a>
    @GetMapping("findById/{id}")
    public User findById( @PathVariable("id") Integer id) {
        String url = "http://localhost:8011/user/findById/2";
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
