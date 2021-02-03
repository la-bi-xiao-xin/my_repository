package cn.itcast.mapper;

import cn.itcast.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {

    // 查询所有
    @Select("select * from tb_account")
    List<Account> findAll();
    // 出账
    @Update("update tb_account set money = money - #{money} where name = #{name}")
    void out(@Param("name") String outAccount, @Param("money") Double money);

    // 入账
    @Update("update tb_account set money = money + #{money} where name = #{name}")
    void in(@Param("name") String inAccount, @Param("money") Double money);
}