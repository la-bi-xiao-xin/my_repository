package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *     <bean id="accountDao" class="cn.itcast.dao.impl.AccountDaoImpl">
 *         <property name="bankName" value="农业银行"/>
 *     </bean>
 */
// @Component("accountDao") 代替 <bean id="accountDao" class="cn.itcast.dao.impl.AccountDaoImpl">
@Component("accountDao")
public class AccountDaoImpl implements AccountDao {

    // 银行变量
    // @Value("招商银行") 代替 <property name="bankName" value="农业银行"/>
    @Value("招商银行")
    private String bankName;

    @Override
    public void out(String outAccount, Double money) {
        System.out.println("数据层操作1: " + outAccount + " 在 " + bankName + " 出账" + money  +"元");
    }

    @Override
    public void in(String inAccount, Double money) {
        System.out.println("数据层操作2: " + inAccount + " 在 " + bankName + " 出账" + money  +"元");
    }
}