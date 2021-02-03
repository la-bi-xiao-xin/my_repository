package cn.itcast.controller;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("findAll")
    public List<User> findAll() {
        // 调用dao接口实现类 操作数据库
        // List<User> userList = userDao.findAll();
        return userDao.findAll();
    }

    @GetMapping("/findById/{uid}")
    public User findById(@PathVariable("uid") int id) {
        return userDao.findById(id);
    }

}
