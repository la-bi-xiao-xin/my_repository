package cn.itcast.elasticsearch.service.impl;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class HighLightSearch {
    private RestHighLevelClient restHighLevelClient;
    private static final String JOB_IDX_NAME = "job_idx";

    public static void main(String[] args) {
        //创建客户端对象连接ES
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("node1",9200,"http"),
                new HttpHost("node1",9200,"http"),
                new HttpHost("node1",9200,"http"));
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        //c
    }
    //创建客户端
}
