package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    // 需求1: 根据id 查询用户信息
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Integer id);

    // 需求2: 查询所有用户
    @Select("select * from tb_user")
    List<User> findAll();
}

