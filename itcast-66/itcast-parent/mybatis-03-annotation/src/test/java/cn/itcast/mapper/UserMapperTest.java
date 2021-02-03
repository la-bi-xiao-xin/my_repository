package cn.itcast.mapper;

import cn.itcast.pojo.User;
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
    public void findUserByUsernameAndPassword() throws Exception {
        // 4 执行sql
        User user = userMapper.findUserByUsernameAndPassword("zhangsan", "123456");
        System.out.println("============ 查询结果: " + user);
    }

    @Test
    public void findById(){
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void insertInto(){
        User user = new User(null, "liuyifei", "123", "刘亦菲", new Date(), "女", "上海市");
        int i = userMapper.insertUser(user);
        System.out.println("影响数据条数"+i);
    }

    @Test
    public void update(){
        //先查
        User user = userMapper.findById(6);
        user.setUsername("dapeng");
        user.setName("大鹏");
        user.setSex("男");
        //后改
        int i = userMapper.updateUser(user);
        System.out.println("影响数据条数"+i);
    }

   /* @Test
    public void delete(){
        int i = userMapper.insertUser(6);
    }*/

    @Test
    public void delById() throws Exception {
        userMapper.delById(6);
    }
}