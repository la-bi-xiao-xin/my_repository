package cn.itcast.dao.impl;

import cn.itcast.config.SpringConfig;
import cn.itcast.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//指定运行环境
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 applicationContext.xml 配置文件
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountDaoImplTest {

@Value("#{accountDao}")
   private AccountDao accountDao;

    @Test
    public void out() {
        accountDao.out("张三",500D);
    }

    @Test
    public void in() {
        accountDao.in("李四",500D);
    }
}