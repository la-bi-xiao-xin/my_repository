package cn.itcast.mapper;

import cn.itcast.pojo.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {
    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void findAll() {
        List<Item> itemList = itemMapper.findAll();

        for (Item item : itemList) {
            System.out.println(item);

        }
        System.out.println("查询数据条数"+itemList.size());
    }
}