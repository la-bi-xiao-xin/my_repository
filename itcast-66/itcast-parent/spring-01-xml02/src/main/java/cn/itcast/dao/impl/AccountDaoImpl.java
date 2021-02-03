package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    private String bankName;

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void in(String inCount, Double money) {
        System.out.println("数据层操作2: " + inCount + " 在 " + bankName + " 进账" + money  +"元");

    }

    @Override
    public void out(String outCount, Double money) {
        System.out.println("数据层操作2: " + outCount + " 在 " + bankName + " 出账" + money  +"元");

    }
}