package cn.itcast.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//设置运行环境注解
@RunWith(SpringJUnit4ClassRunner.class)
//设置配置文件注解
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountDaoImplTest {

    //从spring中获取AccountDaoImpl类对象
    @Value("#{accontDaoImpl}")
    private  AccountDaoImpl a;

    @Test
    public void in() {

        a.in("张三",500D);
    }

    @Test
    public void out() {
        a.out("李四",500D);
    }
}