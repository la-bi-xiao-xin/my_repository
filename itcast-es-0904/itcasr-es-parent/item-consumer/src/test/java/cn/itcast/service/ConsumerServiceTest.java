package cn.itcast.service;

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
public class ConsumerServiceTest {
@Autowired
private ConsumerService consumerService;
    @Test
    public void search() {
        List<Item> itemList = consumerService.search("小米");
        for (Item item : itemList) {
            System.out.println(item);
        }
    }
}