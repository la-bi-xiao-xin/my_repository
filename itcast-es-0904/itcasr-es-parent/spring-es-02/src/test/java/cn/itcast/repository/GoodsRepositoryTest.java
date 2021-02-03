package cn.itcast.repository;

import cn.itcast.pojo.Goods;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsRepositoryTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    //测试创建索引库
    public void demo1() {
        boolean flag = elasticsearchTemplate.createIndex(Goods.class);
        System.out.println("创建索引库是否成功" + flag);

    }

    @Test
    //测试创建type
    public void demo2() {
        boolean flag = elasticsearchTemplate.putMapping(Goods.class);
        System.out.println("创建表是否成功" + flag);

    }

    @Test
    //测试向type导入数据
    public void demo3() {
        // 需求: 批量新建
        List<Goods> goodsList = new ArrayList<Goods>();

        for (long i = 2; i < 10; i++) {
            Goods goods = new Goods(i, "小米手机" + i, "手机", "小米", 1999.0 + 1000, "http://wwww.baidu.com");
            goodsList.add(goods);
        }
        Iterable<Goods> goods = goodsRepository.saveAll(goodsList);
        for (Goods good : goods) {
            System.out.println("**************");
            System.out.println(good);
        }

    }

    @Test
    //测试查询所有
    public void demo4() {
        Iterable<Goods> goods = goodsRepository.findAll();
        for (Goods good : goods) {
            System.out.println("**************");
            System.out.println(good);
        }

    }

    @Test
    //测试根据id查询
    public void demo5() {
        Optional<Goods> good = goodsRepository.findById(2L);
        Goods goods = good.get();
        System.out.println(goods);
    }

    @Test
    //测试search方法查询
    public void demo6() {
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "手机");
        Iterable<Goods> goods = goodsRepository.search(queryBuilder);
        for (Goods good : goods) {
            System.out.println("***********************");
            System.out.println(good);
        }
    }

    @Test
    //测试查询所有
    public void demo7() {
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        Iterable<Goods> goods = goodsRepository.search(matchAllQueryBuilder);
        for (Goods good : goods) {
            System.out.println("***********************");
            System.out.println(good);
        }
    }

    @Test
    //测试分页排序查询
    public void demo8() {

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        PageRequest pageRequest = PageRequest.of(0, 3, sort);
        Page<Goods> goodsPage = goodsRepository.search(QueryBuilders.matchAllQuery(), pageRequest);
        int totalPages = goodsPage.getTotalPages();
        System.out.println("共计"+totalPages+"页");


    }
}