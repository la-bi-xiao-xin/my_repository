package cn.itcast.redis.api_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;

public class RedisClusterTest {
    JedisCluster cluster;
    @BeforeTest
    public void getConnection(){
        // 1. 创建一个HashSet<HostAndPort>，用于保存集群中所有节点的机器名和端口号
        HashSet<HostAndPort> hashSet = new HashSet<>();
        hashSet.add(new HostAndPort("node1",7001));
        hashSet.add(new HostAndPort("node1",7002));
        hashSet.add(new HostAndPort("node2",7001));
        hashSet.add(new HostAndPort("node2",7002));
        hashSet.add(new HostAndPort("node3",7001));
        hashSet.add(new HostAndPort("node3",7002));
        // 2. 创建JedisPoolConfig对象，用于配置Redis连接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        config.setMinIdle(5);
        config.setMaxWaitMillis(10000);
        // 3. 创建JedisCluster对象
         cluster = new JedisCluster(hashSet);
    }
    @Test
    public void clusterTest(){
        cluster.set("pv","1");
        System.out.println(cluster.get("pv"));
    }
    @AfterTest
    public void closePool() throws IOException {
        cluster.close();

    }
}
