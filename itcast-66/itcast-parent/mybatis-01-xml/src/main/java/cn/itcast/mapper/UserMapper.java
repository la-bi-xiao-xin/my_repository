package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    // 根据用户名和密码查询用户信息
    User findUserByUsernameAndPassword(@Param("uname") String username,
                                       @Param("upwd") String password);

    User findById(@Param("id") int id);

    List<User> findAll();

    int insertUser(User user);

    int updateUser(User user);

    int deletUser(@Param("id") int id);
}