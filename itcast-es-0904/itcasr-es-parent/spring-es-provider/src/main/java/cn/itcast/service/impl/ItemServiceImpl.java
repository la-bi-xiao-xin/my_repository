package cn.itcast.service.impl;

import cn.itcast.pojo.Item;
import cn.itcast.service.ItemService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<Item> highlightSearch(String keyword, Integer pageNum, Integer pageSize) {
        // 准备搜索查询器
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withHighlightFields(new HighlightBuilder.Field("title").preTags("<span style='color:red'>").postTags(
                "</span>"));
        builder.withQuery(QueryBuilders.matchQuery("title", keyword));
        builder.withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));
        builder.withPageable(PageRequest.of(pageNum, pageSize));
        NativeSearchQuery searchQuery = builder.build();

        // 执行 且 封装数据
        AggregatedPage<Item> page = elasticsearchTemplate.queryForPage(searchQuery, Item.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                List<Item> items = new ArrayList<>();

                SearchHits hits = response.getHits();

                if (hits.getHits().length <= 0) {
                    return null;
                }

                for (SearchHit hit : hits) {
                    Item item = new Item();

                    if (hit.getHighlightFields().size() > 0) {
                        String title = hit.getHighlightFields().get("title").fragments()[0].toString();
                        item.setTitle(title);
                    }

                    item.setId(Long.parseLong(hit.getId()));

                    if (hit.getSourceAsMap().get("spu") != null) {
                        item.setSku(Long.parseLong(hit.getSourceAsMap().get("spu").toString()));
                    }

                    item.setSku(Long.parseLong(hit.getSourceAsMap().get("sku").toString()));
                    item.setPrice(Double.parseDouble(hit.getSourceAsMap().get("price").toString()));
                    String pic = hit.getSourceAsMap().get("pic").toString();
                    String newPic = pic.substring(pic.indexOf("/"));
                    item.setPic(newPic);
                    item.setUrl(hit.getSourceAsMap().get("url").toString());

                    items.add(item);
                }

                return new AggregatedPageImpl<>((List<T>) items);
            }
        });

        // 3 返回结果
        List<Item> itemList = page.getContent();
        return itemList;
    }
}
