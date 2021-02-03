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
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
@GetMapping("findAll")
    public List<User> findAll() {
        String url = "http://localhost:8011/user/findAll";
        User[] userArr = restTemplate.getForObject(url, User[].class);
        List<User> userList = Arrays.asList(userArr);
       return userList;
    }
    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") int id){
        String url="http://localhost:8011/user/findById/2";
        User user = restTemplate.getForObject(url, User.class);
       return user;
    }
}
