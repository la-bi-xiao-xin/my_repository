package cn.itcast.repository;

import cn.itcast.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}
