package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;

//数据层数据操作接口实现类
public class AccountDaoImpl implements AccountDao {


    //成员变量银行
    private String bankName;

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void in(String inCount, Double money) {
        System.out.println("数据层操作1: " + inCount + " 在 " + bankName + " 进账" + money  +"元");

    }

    @Override
    public void out(String outCount, Double money) {
        System.out.println("数据层操作1: " + outCount + " 在 " + bankName + " 出账" + money  +"元");


    }
}
