package cn.itcast.mapper;

import cn.itcast.pojo.Orderform;
import cn.itcast.pojo.User;
import cn.itcast.pojo.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {  // 根据id 查询用户信息
    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") int id);

    // 根据id 查询用户扩展信息
    @Select("select * from user_info where id = #{id}")
    Userinfo findUserinfoById(@Param("id")int id);

    // 根据id 查询用户的订单信息
    @Select("select * from order_form where user_id = #{userid}")
    // @Results(value={})
    @Results({
            @Result(property = "userid", column = "user_id"),
            @Result(property = "createtime", column = "create_time")
    })
    List<Orderform> findOrdersByUserid(@Param("userid") int userid);

}