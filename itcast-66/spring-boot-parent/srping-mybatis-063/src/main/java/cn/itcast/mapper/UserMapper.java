package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper   //标记为mapper类
@Repository //
public interface UserMapper {
    @Select("select * from user")    //注解  将mapper方法与查询语句映射
    public List<User> findAll();

    // 需求2: 根据id查询用户信息
    User findById(@Param("uid") Integer id);
}
