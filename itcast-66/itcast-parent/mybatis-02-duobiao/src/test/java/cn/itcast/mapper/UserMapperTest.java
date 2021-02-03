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
    public void duobiaocaxun(){
      User userWithInfoById = userMapper.findUserWithInfoById(1);
      System.out.println(userWithInfoById);
  }
@Test
    public void duobiaocaxun2(){
    User userWithOrdersById = userMapper.findUserWithOrdersById(1);
    System.out.println(userWithOrdersById);
}
}