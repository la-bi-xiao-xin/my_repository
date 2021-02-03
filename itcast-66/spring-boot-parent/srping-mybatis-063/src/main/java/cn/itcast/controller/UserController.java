package cn.itcast.controller;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController   //固定注解 标记为controller类
@RequestMapping("user")  //固定注解  映射idex中的类名
public class UserController {

    @Autowired  //自动注入
    private UserMapper userMapper;

@GetMapping("findAll") //注解  映射idex中的方法名
    public List<User> findAll(){

        return userMapper.findAll();

    }
    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") int id){
    return userMapper.findById(2);

    }
}
