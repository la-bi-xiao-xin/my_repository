package cn.itcast.service.impl;

import cn.itcast.config.SpringConfig;
import cn.itcast.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountServiveImplTest {

    @Value("#{accountServiveImpl}")
    private AccountService accountService;
    @Test
    public void zhuanzhang() {
        accountService.zhuanzhang("张三","李四",500D);



    }
}