package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    // 根据用户名和密码查询用户信息
    @Select("select * from user where username=#{uname} and password=#{upwd}")
    User findUserByUsernameAndPassword(@Param("uname") String username,
                                       @Param("upwd") String password);

    //根据id查询用户
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") int id);

    //查询所有
   @Select("select * from user")
    List<User> findAll();

   //增加数据
    @Insert("insert into user(id, username, password, name, birthday, sex, address) values(null, #{username},#{password},#{name},#{birthday},#{sex},#{address})")
    int insertUser(User user);

    //修改数据
    @Update("update user set username=#{username},password=#{password},name=#{name}, birthday=#{birthday}, sex=#{sex}, address=#{address} where id = #{id}")
    int updateUser(User user);

   /* //删除数据
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);*/

    // 删
    @Delete("delete from user where id = #{id}")
    int delById(@Param("id") int id);


}