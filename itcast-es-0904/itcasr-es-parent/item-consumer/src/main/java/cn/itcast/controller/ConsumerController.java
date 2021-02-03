package cn.itcast.controller;

import cn.itcast.pojo.Item;
import cn.itcast.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    @GetMapping("/search/{keyword}")
    public List<Item> search( @PathVariable("keyword") String keyword){
        List<Item> itemList = consumerService.search(keyword);
        return itemList;
    }
 }
