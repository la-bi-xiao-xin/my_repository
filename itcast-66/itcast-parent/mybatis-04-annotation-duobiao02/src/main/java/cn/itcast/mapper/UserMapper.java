package cn.itcast.mapper;

import cn.itcast.pojo.Orderform;
import cn.itcast.pojo.User;
import cn.itcast.pojo.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    // 根据id 查询用户扩展信
    @Select("select * from  user_info where id=#{id}")
    Userinfo findUserinfoById(@Param("id") int id);

    // 根据id 查询用户的订单信息
    @Select("select * from order_form where user_id=#{userid}")
    @Results({
            @Result(property = "userid",column = "user_id"),
            @Result(property = "createtime",column = "create_time")
    })
    List<Orderform> findOrdersByUserid(@Param("userid") int userid);

   /* // 根据id 查询用户信息
    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") int id);*/


   /* // 两表一对一,根据id 查询用户信息和扩展信息
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "userinfo" ,column = "id",one = @One(select="findUserinfoById"))
    })
    User findUserById(@Param("id") int id);*/

    /*// 两表一对多,根据id 查询用户信息和订单信息
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orders" ,column = "id",one = @One(select="findOrdersByUserid"))
    })
    User findUserById(@Param("id") int id);*/

    // 两表,一对一,两表一对多,根据id 查询用户信息和扩展,订单信息
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "userinfo" ,column = "id",one = @One(select="findUserinfoById")),
            @Result(property = "orders" ,column = "id",one = @One(select="findOrdersByUserid"))
    })
    User findUserById(@Param("id") int id);


}