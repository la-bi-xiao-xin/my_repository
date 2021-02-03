package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("accountDao")
public class AccountDaoImpl implements AccountDao {


    //银行变量
    @Value("招商银行")
    private String bankName;

    //设置银行名称的方法
    public void setBankName(String bankName){
        this.bankName=bankName;
    }

    @Override
    public void out(String outCount, Double money) {
        System.out.println("数据层操作1: " + outCount + " 在 " + bankName + " 出账" + money  +"元");
    }

    @Override
    public void in(String inCount, Double money) {
        System.out.println("数据层操作2: " +inCount + " 在 " + bankName + " 进账" + money  +"元");
    }
}
