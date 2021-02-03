package cn.itcast.redis.api_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;

public class RedisSentinelTest {
    JedisSentinelPool sentinelPool;

    @BeforeTest
    public void getConnection() {
        //1. 构建JedisPoolConfig配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMinIdle(5);
        config.setMaxTotal(50);
        config.setMaxWaitMillis(10000);
        // 2. 创建一个HashSet，用来保存哨兵节点配置信息
        HashSet<String> sentinelNodeSet = new HashSet<>(Arrays.asList("node1:26379", "node2:26379", "node3:26379"));
        // 3. 构建JedisSentinelPool连接池
        sentinelPool = new JedisSentinelPool("mymaster", sentinelNodeSet, config);

    }
    @Test
    public void sentinelTest(){
        Jedis resource = sentinelPool.getResource();
        String liaoleiying = resource.set("pv", "1");
        System.out.println(resource.get("pv"));
    }

    @AfterTest
    public void closePool() {
        sentinelPool.close();
    }
}
