package cn.itcast.controller;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //注解  标记此类为controller类
@RequestMapping("user")  //注解  indx中的类名与此类映射
public class UserController {

    @Autowired  //注解  自动注入mybatis的mapper实体对象
    private UserDao userDao;

    //  <a href="/user/findAll">测试</a>
    @GetMapping("findAll")  // 注解  index中的方法名与此方法映射
    public List<User> find1() {
        return userDao.findAll();

    }

    //<a href="/user/findById/2">测试</a>
    @GetMapping("findById/{id}")
    public User find2(@PathVariable("id") Integer id) {
        return userDao.findById(id);
    }
}
