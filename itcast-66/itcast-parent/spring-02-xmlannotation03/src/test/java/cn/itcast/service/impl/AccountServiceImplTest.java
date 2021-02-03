package cn.itcast.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountServiceImplTest {

    @Value("#{AS}")
    AccountServiceImpl as;
    @Test
    public void zhuanzhuang() {
        as.zhuanzhuang("王五","李九",1000D);
    }
}