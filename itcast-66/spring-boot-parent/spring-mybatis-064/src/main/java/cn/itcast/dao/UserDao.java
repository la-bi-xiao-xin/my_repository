package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //注解 标记此类为mybatis 的mapper类
@Repository //
public interface UserDao {

    //使用注解 编写mybatis的mapper方法
    @Select("select * from user")
    List<User> findAll();

    //使用xml配置文件编写mybatis的mapper方法  在resources目录下创建dao目录dao目录下创建mapper类的xml配置文件
    //使用配置文件映射方法,需要在springboot总配置文件中配置mapper配置文件的地址
    User findById(@Param("uid") Integer id);
}
