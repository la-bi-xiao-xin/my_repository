package cn.itcast.controller;

import cn.itcast.pojo.Item;
import cn.itcast.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/search/{keyword}")
    public List<Item> search(@PathVariable("keyword") String keyword) {
        List<Item> items = itemService.highlightSearch(keyword, 1, 3);
        return items;

    }
}
