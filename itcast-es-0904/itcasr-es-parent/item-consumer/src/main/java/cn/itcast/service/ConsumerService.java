package cn.itcast.service;

import cn.itcast.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient("item-provider")
public interface ConsumerService {
    @GetMapping("/item/search/{keyword}")
    List<Item> search(@PathVariable("keyword") String keyword);

}
