package cn.itcast.service.impl;

import cn.itcast.dao.impl.AccountDaoImpl;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Value;

public class AccountServiceImpl implements AccountService {

    private AccountDaoImpl a;

    public void setAccountDao(AccountDaoImpl a) {
        this.a = a;
    }

    @Override
    public void zhuanzhuang(String outCount, String inCount, Double money) {
        System.out.println("=========== 调用业务层 进行转账!!!");
        a.out(outCount, money);

        a.in(inCount, money);

    }
}
