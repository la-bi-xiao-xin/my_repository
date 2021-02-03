package cn.itcast.springboot_mybatis_mvc.mapper;

import cn.itcast.springboot_mybatis_mvc.entity.ActivityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GetdataMapper {


//使用mapper配置文件
    public ActivityEntity findByPlayer_id(int player_id);


}
