package cn.itcast.repository;

import cn.itcast.pojo.Goods;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsEsRepositoryTest {
    @Autowired
    private GoodsEsRepository goodsEsRepository;

    @Test
    public void demo1() {
        Goods goods1 = new Goods(1L, "华为手机1", "手机", "华为", 1999.0, "http://wwww.baidu.com");
        Goods goods = goodsEsRepository.save(goods1);

    }

    @Test
    public void demo2() {

        List<Goods> goodsList = new ArrayList<Goods>();
        for (long i = 2; i < 10; i++) {
            if (i % 2 == 1) {
                Goods goods1 = new Goods(i, "华为手机" + i, "手机", "华为", 1999.0 + i * 1000, "http://wwww.baidu.com");
                boolean add = goodsList.add(goods1);
            } else {
                Goods goods1 = new Goods(i, "华为手机" + i, "手机", "小米", 1999.0 + i * 1000, "http://wwww.baidu.com");
                boolean add = goodsList.add(goods1);
            }
        }
        Iterable<Goods> goodsList1 = goodsEsRepository.saveAll(goodsList);
    }

    @Test
    public void demo3() {
        Iterable<Goods> allGoods = goodsEsRepository.findAll();
        int count = 0;
        for (Goods goods : allGoods) {
            System.out.println("------------------------------------------------");
            System.out.println(goods);
            count++;
        }
        System.out.println("统计数据条数为:" + count);
    }

    @Test
    public void demo4() {
        Optional<Goods> goods = goodsEsRepository.findById(2L);
        if (goods.isPresent()) {
            Goods goods1 = goods.get();
            System.out.println("*********************************************");
            System.out.println(goods1);
        }

    }

    @Test
    public void demo5() {
        Optional<Goods> goods = goodsEsRepository.findById(1L);
        if (goods.isPresent()) {
            Goods good = goods.get();
            good.setId(1L);
            good.setPrice(99999999D);
            Goods saveGood = goodsEsRepository.save(good);
        }
    }

    @Test
    public void demo6() {
        goodsEsRepository.deleteById(9L);
    }

    @Test
    public void demo7() {
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("brand", "小米");

        Iterable<Goods> goods = goodsEsRepository.search(queryBuilder);
        int count = 0;
        for (Goods good : goods) {
            System.out.println("*****************");
            System.out.println(good);
            count++;
        }
        System.out.println("查询到的数据有" + count + "条");
    }

    @Test
    public void demo8() {
        // 需求: 查询所有 且 按照id排序
        // 1. 构建Sort排序对象,指定排序字段和排序方式
        Sort sort = new Sort(Sort.Direction.ASC, "id");

        // 2. 使用PageRequest构建Pageable分页对象,指定分页参数,并将排序对象设置到分页对象中
        PageRequest pageRequest = PageRequest.of(0, 5, sort);

        // 3. 调用goods仓库search方法进行查询
        Page<Goods> goodsPage = goodsEsRepository.search(QueryBuilders.matchAllQuery(), pageRequest);

        // 4 解析结果
        // 4.1 获取总记录数
        long totalElements = goodsPage.getTotalElements();
        System.out.println("总数据量为" + totalElements);

        // 4.2 获取总页数
        int totalPages = goodsPage.getTotalPages();
        System.out.println("总页数为" + totalPages);


        // 4.2 获取当前页的数据
        List<Goods> content = goodsPage.getContent();
        for (Goods goods : content) {
            System.out.println("*********************");
            System.out.println(goods);
        }


    }
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void nativeSearchQuery() {
        //1.构建NativeSearchQueryBuilder查询对象
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        //2.使用QueryBuilders指定查询类型和查询条件
        searchQueryBuilder.withQuery(QueryBuilders.matchQuery("title", "华为"));
        //3.使用SortBuilders指定排序字段和排序方式
        searchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        //4.使用PageRequest对象指定分页参数
        searchQueryBuilder.withPageable(PageRequest.of(0, 2));
        //5.调用NativeSearchQueryBuilder的build方法完成构建
        NativeSearchQuery searchQuery = searchQueryBuilder.build();
        //6.使用ElasticsearchTemplate完成查询
        AggregatedPage<Goods> page = elasticsearchTemplate.queryForPage(searchQuery, Goods.class);
        //7.解析结果
        //7.1获取总记录数
        long totalElements = page.getTotalElements();
        System.out.println("totalElements: " + totalElements);
        //7.2获取页总数
        int totalPages = page.getTotalPages();
        System.out.println("totalPages: " + totalPages);
        //7.3遍历查询结果
        for (Goods goods : page) {
            System.out.println("结果 ： " + goods);
        }
    }
    @Test
    public void demo09() {
        // 增加高亮显示
        //1. 构建NativeSearchQueryBuilder查询对象
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        // 8 高亮显示的效果
        nativeSearchQueryBuilder.withHighlightFields(new HighlightBuilder.Field("title").preTags("<span style='color:blue;'>").postTags("</span>"));
        //2. 使用QueryBuilders指定查询类型和查询条件
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("title", "华为"));
        //3. 使用SortBuilders指定排序字段和排序方式
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));
        //4. 使用PageRequest对象指定分页参数
        nativeSearchQueryBuilder.withPageable(PageRequest.of(1,3));
        //5. 调用NativeSearchQueryBuilder的build方法完成构建
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        //6. 使用ElasticsearchTemplate完成查询
        // 为了高亮显示 改造第6步
        AggregatedPage<Goods> page = elasticsearchTemplate.queryForPage(searchQuery, Goods.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                // 封装数据的对象
                List<Goods> goodsList = new ArrayList<Goods>();

                // 1 获取命中对象
                SearchHits hits = response.getHits();
                // 2 判断 校验是否为空,
                // 2.1 如果为空, 直接返回null; 否则 继续执行
                if(hits.getHits().length<=0) {
                    return null;
                }
                // 2.2 遍历
                for (SearchHit hit : hits) {
                    // 目标: 将查询结果封装goods对象中 再放到集合中
                    // 1 创建goods对象
                    Goods goods = new Goods();
                    // 2 设置内容
                    // 设置id
                    String id = hit.getId();
                    goods.setId(Long.parseLong(id));
                    // 设置分类属性
                    String category = hit.getSourceAsMap().get("category").toString();
                    if(category != null) {
                        goods.setCategory(category);
                    }
                    // 设置 brand 品牌属性
                    String brand = hit.getSourceAsMap().get("brand").toString();
                    if(brand != null) {
                        goods.setBrand(brand);
                    }

                    // 设置 brand 品牌属性
                    String images = hit.getSourceAsMap().get("images").toString();
                    if(images != null) {
                        goods.setImages(images);
                    }

                    // 设置价格
                    String price = hit.getSourceAsMap().get("price").toString();
                    if(price != null) {
                        goods.setPrice(Double.parseDouble(price));
                    }

                    // 设置高亮字段
                    if(hit.getHighlightFields().size()>0) {
                        String title = hit.getHighlightFields().get("title").fragments()[0].toString();
                        goods.setTitle(title);
                    }


                    // 3 将goods对象放到 集合中
                    goodsList.add(goods);

                }

                return new AggregatedPageImpl<>((List<T>) goodsList);
            }
        });
        //7. 解析结果
        // 7.1 获取总记录数
        System.out.println("总记录数 ====" + page.getTotalElements());
        // 7.2 获取总页数
        System.out.println("总页数 ====" + page.getTotalPages());
        // 7.3 获取每条记录信息
        // List<Goods> goodsList = page.getContent();
        for (Goods goods : page) {
            System.out.println("=====================");
            System.out.println(goods);
        }
    }

}