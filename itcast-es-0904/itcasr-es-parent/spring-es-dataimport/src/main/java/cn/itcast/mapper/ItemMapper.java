package cn.itcast.mapper;

import cn.itcast.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper {
@Select("select * from jd_item")
    public List<Item> findAll();
}
