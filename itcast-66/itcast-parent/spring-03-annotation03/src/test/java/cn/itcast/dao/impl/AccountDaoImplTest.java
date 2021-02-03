package cn.itcast.dao.impl;

import cn.itcast.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class )
public class AccountDaoImplTest {

    @Value("#{AD}")
    private AccountDaoImpl a;

    @Test
    public void in() {
        a.in("王五",600D);
    }

    @Test
    public void out() {
        a.out("李九",600D);
    }
}