package cn.itcast.elasticsearch.service.impl;

import cn.itcast.elasticsearch.entity.JobDetail;
import cn.itcast.elasticsearch.service.JobFullTextService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.http.HttpHost;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobFullTextServiceImpl implements JobFullTextService {


    private RestHighLevelClient restHighLevelClient;
    private static final String JOB_IDX_NAME = "job_idx";
//构造器

    public JobFullTextServiceImpl() {
         /*1. 使用RestHighLevelClient构建客户端连接。
2. 基于RestClient.builder方法来构建RestClientBuilder
3. 用HttpHost来添加ES的节点
*/
      /*  RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http")
        ));*/
      /*  RestClientBuilder builder = RestClient.builder(new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http"));
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);*/
    }

    //实现新增职位数据
    @Override
    public void add(JobDetail jobDetail) throws IOException {


        RestClientBuilder builder = RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http"));
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);


        //  1.传入索引名称,构建IndexRequest对象，用来描述ES发起请求的数据。
        IndexRequest indexRequest = new IndexRequest(JOB_IDX_NAME);
        //  2.	设置索引文档ID。
        //指出要将jobDetial数据映射到job_idx中的id位置
        //ES中一条数据用一个json来表示,每个json都有一个id,添加数据时要指定id
        indexRequest.id(jobDetail.getId() + "");
        //3.	使用FastJSON将实体类对象转换为JSON格式字符串。
        String jsonString = JSON.toJSONString(jobDetail);
        //  4.	使用IndexRequest.source方法设置文档数据，并设置请求的数据为JSON格式。
        indexRequest.source(jsonString, XContentType.JSON);
        //  5.	使用ES High level client调用index方法发起请求，将一个文档添加到索引中。
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("添加数据成功********************************");
        System.out.println(indexResponse);


    }


    //根据id查询数据
    @Override
    public JobDetail findById(long id) throws IOException {
        /*



            5.	记得：单独设置ID
*/
        //1.	构建GetRequest请求。
        GetRequest getRequest = new GetRequest(JOB_IDX_NAME, id + "");
        // 2.	使用RestHighLevelClient.get发送GetRequest请求，并获取到ES服务器的响应。
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http"));
        restHighLevelClient = new RestHighLevelClient(builder);

        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        //  3.	将ES响应的数据转换为JSON格式字符串
        String sourceAsString = documentFields.getSourceAsString();
        // 4.	并使用FastJSON将JSON格式字符串转换为JobDetail类对象
        JobDetail jobDetail = JSONObject.parseObject(sourceAsString, JobDetail.class);
        jobDetail.setId(id);

        return jobDetail;
    }

    //更新索引库中某条数据(文档)
    @Override
    public void update(JobDetail jobDetail) throws IOException {
        //获取于ES库连接的客户端对象
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node1", 9200, "http")
        );
        restHighLevelClient = new RestHighLevelClient(builder);

        //1.	判断对应ID的文档是否存在
        // a) 构建GetRequest
        GetRequest getRequest = new GetRequest(JOB_IDX_NAME, jobDetail.getId() + "");
        // b) 执行client的exists方法，发起请求，判断是否存在
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists) {
            return;
        }
        //2.	构建UpdateRequest请求
        UpdateRequest updateRequest = new UpdateRequest(JOB_IDX_NAME, jobDetail.getId() + "");
        //3.设置UpdateRequest的文档，并配置为JSON格式
        updateRequest.doc(JSON.toJSONString(jobDetail), XContentType.JSON);
        //4.	执行client发起update请求
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);


    }

    //删除指定id的索引数据(文档)
    @Override
    public void deleteById(long id) throws IOException {
        //创建连接ES的客户端
        RestClientBuilder builder = RestClient.builder(new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http")
        );
        restHighLevelClient = new RestHighLevelClient(builder);

        // 1. 构建delete请求
        DeleteRequest deleteRequest = new DeleteRequest(JOB_IDX_NAME, id + "");

        // 2. 使用client执行delete请求
        restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);

    }

    //根据关键字查询获取文档
    @Override
    public List<JobDetail> searchByKeywords(String keywords) throws IOException {
        ArrayList<JobDetail> jobDetails = new ArrayList<>();

        //创建连接ES的客户端
        RestClientBuilder builder = RestClient.builder(new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http")
        );
        restHighLevelClient = new RestHighLevelClient(builder);
        //1.构建SearchRequest检索请求
        SearchRequest searchRequest = new SearchRequest(JOB_IDX_NAME);
        //2.创建一个SearchSourceBuilder专门用于构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //3.使用QueryBuilders.multiMatchQuery构建一个查询条件（搜索title、jd），并配置到SearchSourceBuilder
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "jb", "title");
        searchSourceBuilder.query(multiMatchQueryBuilder);

        //4.调用SearchRequest.source将查询条件设置到检索请求
        searchRequest.source(searchSourceBuilder);
        //5.执行RestHighLevelClient.search发起请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //6.遍历结果
        SearchHits hits = searchResponse.getHits();

        for (SearchHit hit : hits) {
            //1)获取命中的结果JSON格式的字符串
            String sourceAsString = hit.getSourceAsString();
            //2)将JSON字符串转换为对象
            JobDetail jobDetail = JSON.parseObject(sourceAsString, JobDetail.class);
            //3)使用SearchHit.getId设置文档ID
            String id = hit.getId();
            jobDetail.setId(Long.parseLong(id));
            //将获取的jobDetail添加到集合中
            jobDetails.add(jobDetail);
        }

        return jobDetails;
    }

    //按照关键字查询,分页展示
    @Override
    public Map<String, Object> searchByPage(String keywords, int pageNum, int pageSize) throws IOException {

        //创建客户端
        RestClientBuilder restClientBuilder = RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node1", 9200, "http")
        );
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);


        //步骤和之前的关键字搜索类似，只不过构建查询条件的时候，需要加上分页的设置。
        //----------------------
        //1.	构建SearchRequest检索请求
        SearchRequest searchRequest = new SearchRequest(JOB_IDX_NAME);
        //2.	创建一个SearchSourceBuilder专门用于构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //3.	使用QueryBuilders.multiMatchQuery构建一个查询条件，并配置到SearchSourceBuilder
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "jb", "title");
        searchSourceBuilder.query(multiMatchQueryBuilder);
        //4.	设置SearchSourceBuilder的from和size参数，构建分页
        searchSourceBuilder.from((pageNum - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        //5.	调用SearchRequest.source将查询条件设置到检索请求
        searchRequest.source(searchSourceBuilder);

        //6.	执行RestHighLevelClient.search发起请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //7.	遍历结果,将结果放入集合
        SearchHits hits = searchResponse.getHits();
        ArrayList<JobDetail> jobDetails = new ArrayList<>();
        for (SearchHit hit : hits) {
            //4)	获取命中的结果,json
            String sourceAsString = hit.getSourceAsString();
            //5)	将JSON字符串转换为对象
            JobDetail jobDetail = JSON.parseObject(sourceAsString, JobDetail.class);
            //6)	使用SearchHit.getId设置文档ID
            jobDetail.setId(Long.parseLong(hit.getId()));
            jobDetails.add(jobDetail);

        }
        //8.	将结果封装到Map结构中（带有分页信息）
        Map<String, Object> result = new HashMap<>();
        //a)	total -> 使用SearchHits.getTotalHits().value获取到所有的记录数
        long value = hits.getTotalHits().value;
        //b)	content -> 当前分页中的数据
        //result.put(String.valueOf(value),jobDetails);
        result.put("total", hits.getTotalHits().value);
        result.put("content", jobDetails);

        return result;
    }


    //使用scroll检索分页展示
    @Override
    public Map<String, Object> searchByScrollPage(String keywords, String scrollId, int pageSize) throws IOException {
        //创建客户端
        RestClientBuilder restClientBuilder = RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node1", 9200, "http")

        );
      restHighLevelClient = new RestHighLevelClient(restClientBuilder);

        //判断scrollId是否为空
        //a)	如果为空，那么首次查询要发起scroll查询，设置滚动快照的有效时间
        //b)	如果不为空，就表示之前应发起了scroll，直接执行scroll查询就可以


        //步骤和之前的关键字搜索类似，只不过构建查询条件的时候，需要加上分页的设置。
        //----------------------
        SearchResponse searchResponse;
        if(scrollId==null){
            //        scrollId为空：
            //1.	指定索引库名构建SearchRequest检索请求,
            SearchRequest searchRequest = new SearchRequest(JOB_IDX_NAME);
            //2.	创建一个SearchSourceBuilder专门用于构建查询条件
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //3.	使用QueryBuilders.multiMatchQuery构建一个查询条件，并配置到SearchSourceBuilder
            MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "jb", "title");
           searchSourceBuilder.query(multiMatchQueryBuilder);
           //设置每页多少条记录，
           searchSourceBuilder.size(pageSize);
            //4.	调用SearchRequest.source将查询条件设置到检索请求
            searchRequest.source(searchSourceBuilder);
            //5.	调用SearchRequest.scroll设置滚动快照有效时间
            searchRequest.scroll(TimeValue.timeValueMinutes(5));
            //6.	执行RestHighLevelClient.search发起请求
             searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        }else{
            //scollId不为空：
            //1.	用之前查询出来的scrollId，构建SearchScrollRequest请求
            SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollId);
            //2.	设置scroll查询结果的有效时间
            searchScrollRequest.scroll(TimeValue.timeValueMinutes(5));
            //3.	使用RestHighLevelClient执行scroll请求
          searchResponse = restHighLevelClient.scroll(searchScrollRequest, RequestOptions.DEFAULT);
        }
        //创建list和map 集合
        ArrayList<JobDetail> jobDetails = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        //7.	遍历结果
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            //7)	获取命中的结果
            String sourceAsString = hit.getSourceAsString();
            //8)	将JSON字符串转换为对象
            JobDetail jobDetail = JSON.parseObject(sourceAsString, JobDetail.class);
            //9)	使用SearchHit.getId设置文档ID
            jobDetail.setId(Long.parseLong(hit.getId()));
            jobDetails.add(jobDetail);
        }
        //8.	将结果封装到Map结构中（带有分页信息）
        //a)	scroll_id -> 从SearchResponse中调用getScrollId()方法获取scrollId
        map.put("scroll_id",searchResponse.getScrollId());
        //b)	content -> 当前分页中的数据
        map.put("content",jobDetails);

        return map;
    }

    @Override
    public void close() throws IOException {
        restHighLevelClient.close();

    }
}
