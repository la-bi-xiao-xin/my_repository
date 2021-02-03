package cn.itcast.repository;

import cn.itcast.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsEsRepository extends ElasticsearchRepository<Goods,Long> {

}
