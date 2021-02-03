package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println("**************");
            System.out.println(user);
        }
    }

    @Test
    public void findById() {

        User usre = userMapper.findById(1);
        System.out.println(usre);
    }
}