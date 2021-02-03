package cn.itcast.service;

import cn.itcast.pojo.Item;

import java.util.List;

public interface ItemService {
    // 高亮搜索
    List<Item> highlightSearch(String keyword, Integer pageNum, Integer pageSize);

}
