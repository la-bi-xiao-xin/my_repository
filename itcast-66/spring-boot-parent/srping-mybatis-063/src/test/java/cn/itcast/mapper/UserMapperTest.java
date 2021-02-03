package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)  //指定指定springboot的运行环境, 这是固定的
@SpringBootTest    //在springbootz中的测试方法的标记
public class UserMapperTest {


    //获取mapper对象
    @Autowired   //注解    自动注入
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user );
        }

    }
    @Test
    public  void findById(){
        User user = userMapper.findById(1);
        System.out.println(user);
    }
}