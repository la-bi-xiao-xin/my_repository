package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户编号 查询用户信息和用户扩展信息
     * @param id
     * @return
     */
    User findUserWithInfoById(@Param("id") int id);

    /**
     * 根据用户编号 查询用户信息和用户的订单信息
     */
    User findUserWithOrdersById(@Param("id") int id);
}