package cn.itcast.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DruidDataSourceTest {

    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void demo02() {
        System.out.println(druidDataSource);
    }

    @Test
    public void dmeo01() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///mybatis_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        System.out.println(druidDataSource);
    }
}
