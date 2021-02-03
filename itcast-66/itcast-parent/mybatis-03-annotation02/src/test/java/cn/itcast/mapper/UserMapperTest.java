package cn.itcast.mapper;

import cn.itcast.pojo.User;
import cn.itcast.pojo.Userinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    SqlSession sqlSession;
    UserMapper userMapper;

    @Before
    public void init() throws Exception {
        // 1 获取sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2 获取SqlSession
        // true : 关闭事务
        // false : 开启事务, 默认
        sqlSession = sqlSessionFactory.openSession(true);
        // 3 获取接口的实现类: 反射 + 动态代理
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destory() {
        // 5 释放资源
        sqlSession.close();
    }

    @Test
    public void findUserByUsernameAndPassword() throws Exception {//代替main方法
        // 4 执行sql
        User user = userMapper.findUserByUsernameAndPassword("zhangsan", "123456");
        System.out.println("============ 查询结果: " + user);
    }

    @Test
    public void findUserById() {
        User user = userMapper.findById(2);
        System.out.println("########" + user);
    }
  /* @Test
   public void findById() throws Exception {
       User user = userMapper.findById(2);
       System.out.println(user);
   }*/

  @Test
    public void findAllTest(){
      List<User> all = userMapper.findAll();
      for (User user : all) {
          System.out.println("******");
          System.out.println(user);

      }
  }
  @Test
    public void insertIntoUserTableTest(){
      User user = new User(null, "liuyan", "123", "柳岩", new Date(), "女", "上海市");
      int i = userMapper.insertUser(user);
      System.out.println("影响"+i+"条数据");

  }
  @Test
    public void update(){
      User user = userMapper.findById(5);
      user.setUsername("dapeng");
      user.setName("大鹏");
      user.setSex("男");
      int i = userMapper.updateUser(user);
      System.out.println("影响"+i+"条数据");
  }


    @Test
    public void deleteUserTest() throws Exception {
        int i = userMapper.deleteUser(5);
        System.out.println("影响"+i+"条数据");
    }
}