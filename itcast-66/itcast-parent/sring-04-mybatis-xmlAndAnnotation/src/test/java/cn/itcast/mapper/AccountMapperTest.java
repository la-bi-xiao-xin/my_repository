package cn.itcast.mapper;

import cn.itcast.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void findAll() {
        List<Account> accountList = accountMapper.findAll();
        for (Account account : accountList) {
            System.out.println("===========================");
            System.out.println(account);
        }
    }


    @Test
    public void out() {
        accountMapper.out("aaa", 300D);
    }

    @Test
    public void in() {
        accountMapper.in("aaa", 300D);
    }
}