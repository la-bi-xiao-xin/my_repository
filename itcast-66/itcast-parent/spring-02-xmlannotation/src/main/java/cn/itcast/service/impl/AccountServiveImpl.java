package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
    <bean id="accountService" class="cn.itcast.service.impl.AccountServiceImpl">
        <!--将dao注入业务层-->
        <!--ref 设置对象 英文翻译为引用这个单词 取了前三个字母-->
        <property name="accountDao" ref="accountDao"/>
    </bean>
 */
// @Component("accountService") 代替 <bean id="accountService" class="cn.itcast.service.impl.AccountServiceImpl">
@Component("accountService")
public class AccountServiveImpl implements AccountService {

    // @Value("#{accountDao}") 代替 <property name="accountDao" ref="accountDao"/>
    @Value("#{accountDao}")
    private AccountDao accountDao;

    @Override
    public void zhuanzhang(String outAccount, String inAccount, Double money) {
        System.out.println("=========== 调用业务层 进行转账!!!");
        accountDao.out(outAccount, money);

        accountDao.in(inAccount, money);
    }
}
