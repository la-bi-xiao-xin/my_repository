package cn.itcast.repository;

import cn.itcast.mapper.ItemMapper;
import cn.itcast.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void demo(){
        List<Item> itemList = itemMapper.findAll();

        Iterable<Item> items = itemRepository.saveAll(itemList);
    }

}