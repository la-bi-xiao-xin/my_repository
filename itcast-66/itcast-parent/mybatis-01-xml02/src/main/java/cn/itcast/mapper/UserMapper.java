package cn.itcast.mapper;

import cn.itcast.pojo.User;
import cn.itcast.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    // 根据用户名和密码查询用户信息
    User findUserByUsernameAndPassword(@Param("uname") String username,
                                       @Param("upwd") String password);

    // 查
    // 根据id查询用户信息
    User findById(@Param("id") int id);

  /*  // 根据id查询用户信息
    User findById(@Param("id") int id);
*/
    // 查询所有
    List<User> findAll();

    // 增
    int insertUser(User user);

    // 改
    int updateUser(User user);

    // 删

    int deleteUser(@Param("id") int id);
}