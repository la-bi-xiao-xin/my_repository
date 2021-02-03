package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${server.port}")
    private Integer port;
    @Autowired
    private UserService userService;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        user.setNote("用户服务提供者端口号: " + port);
        return user;


    }

}