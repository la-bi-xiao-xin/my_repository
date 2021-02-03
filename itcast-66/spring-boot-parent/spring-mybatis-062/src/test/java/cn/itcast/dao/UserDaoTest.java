package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// 指定springboot的运行环境, 注意这是固定的
@RunWith(SpringRunner.class)
// 跟springboot相关的
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAll() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findById() {
        User user = userDao.findById(1);

        System.out.println(user);
    }
}