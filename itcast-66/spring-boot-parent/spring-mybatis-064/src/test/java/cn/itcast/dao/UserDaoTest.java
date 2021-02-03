package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//固定写法
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired  //注解 自动注入mybatis 实现mapper接口的对象
    private UserDao userDao;
    @Test
    public void findAll() {

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println("************");
            System.out.println(user);
        }
    }
    @Test
    public void findById(){
        User user = userDao.findById(1);
        System.out.println("************");
        System.out.println(user);
    }
}