package cn.itcast.springboot_mybatis_mvc.mapper;

import cn.itcast.springboot_mybatis_mvc.entity.ActivityEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest


public class GetdataMapperTest {
    @Autowired
    private GetdataMapper getdataMapper;

    @Test
    public void findByPlayer_id() {
        ActivityEntity entity = getdataMapper.findByPlayer_id(2);
        System.out.println(entity);
    }
}