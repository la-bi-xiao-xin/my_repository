package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Value;

public class AccountServiceImpl {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    // 转账
    public void zhuanzhang(String outAccount, String inAccount, Double money) {
        System.out.println("=========== 调用业务层 进行转账!!!");
        accountDao.out(outAccount,money);
        accountDao.in(inAccount,money);

    }


}
