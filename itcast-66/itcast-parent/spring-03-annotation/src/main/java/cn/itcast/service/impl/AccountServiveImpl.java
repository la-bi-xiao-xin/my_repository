package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("accountServiveImpl")
public class AccountServiveImpl implements AccountService {

    @Value("#{accountDao}")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void zhuanzhang(String outAccount, String inAccount, Double money) {
        System.out.println("=========== 调用业务层 进行转账!!!");
        accountDao.out(outAccount, money);

        accountDao.in(inAccount, money);

    }
}
