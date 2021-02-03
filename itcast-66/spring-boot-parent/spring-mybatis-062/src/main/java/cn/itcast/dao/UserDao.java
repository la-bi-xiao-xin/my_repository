package cn.itcast.dao;


import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

// 因为一个项目中有很多接口, 通知spring当前接口是mapper接口
@Mapper
// 为了解决获取dao时不报错
@Repository
public interface UserDao {

    // 需求1: 查询查询所有用户
    @Select("select * from user")
    List<User> findAll();

    // 需求2: 根据id查询用户信息
    User findById(@Param("uid") Integer id);

}