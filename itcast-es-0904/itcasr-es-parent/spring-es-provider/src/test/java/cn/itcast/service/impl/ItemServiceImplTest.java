package cn.itcast.service.impl;

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
public class ItemServiceImplTest {
    @Autowired
    private ItemServiceImpl itemService;
    @Test
    public void demo(){
        List<Item> itemList = itemService.highlightSearch("华为", 0, 5);
        for (Item item : itemList) {
            System.out.println(item);
        }
    }
}