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

@RestController  //注解 标记此类为web mvc controller类

//  <a href="/consumer/find1">测试</a>
@RequestMapping("/consumer")    //注解  将此类与web首页url的方法名映射
public class ConsumerController {

    @Autowired   //注解  根据创建对象语句自动从spring库中找寻对应对象注入
    private RestTemplate restTemplate;  //创建远程调度对象

    //创建于web 首页相映射的方法
    @GetMapping("find1")  //注解 将此方法于web url 的方法映射
    public List<User> findAll() {

        String url = "http://localhost:8011/user/findAll";
        User[] userArr = restTemplate.getForObject(url, User[].class);
        List<User> users = Arrays.asList(userArr);
        return users;
    }

    //<a href="/consumer/find2/2">测试</a>
    @GetMapping("find2/{id}")
    public User findById(@PathVariable("id") Integer id) {
        String url = "http://localhost:8011/user/findById/2";

        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
