package cn.itcast.redis.api_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisTest {
    private JedisPool jedisPool;
    private JedisPoolConfig config;

    @BeforeTest
    public void redisConnectionPool() {

        config = new JedisPoolConfig();
        config.setMaxIdle(20);
        config.setMaxWaitMillis(3000);
        config.setMaxTotal(50);
        config.setMinIdle(5);
        jedisPool = new JedisPool(config, "192.168.52.150", 6379);
    }

    @Test
    public void testConnect() {
        Jedis jedis = jedisPool.getResource();
        Set<String> keySet = jedis.keys("*");
        for (String s : keySet) {
            System.out.print(s + " ");
        }
    }

    @Test
    public void StringTest() {

        Jedis resource = jedisPool.getResource();
        //i.	添加一个string类型数据，key为pv，用于保存pv的值，初始值为0
        resource.set("pv", "0");
        //ii.	查询该key对应的数据
        String pv = resource.get("pv");
        System.out.println("pv的对应值为" + pv);
        //iii.	修改pv为1000
        String pv1 = resource.set("pv", "1000");
        System.out.println("pv修改后的对应值为" + resource.get("pv"));
        //iv.	实现整形数据原子自增操作 +1
        Long pv2 = resource.incr("pv");
        System.out.println("pv自增修改后的对应值为" + resource.get("pv"));
        //v.	实现整形该数据原子自增操作 +1000
        Long pv3 = resource.incrBy("pv", 1000);
        System.out.println("pv第三次修改后的对应值为" + resource.get("pv"));

    }

    @Test
    public void hashTest() {
        Jedis resource = jedisPool.getResource();
        /*i.	往Hash结构中添加以下商品库存
        1.	iphone11 => 10000
        2.	macbookpro => 9000*/
        resource.hset("goods", "iphone11", "10000");
        resource.hset("goods", "macbookpro", "9000");

        //  ii.	获取Hash中所有的商品
        Map<String, String> goods = resource.hgetAll("goods");
        for (String good : goods.keySet()) {
            System.out.println(good + " => " + goods.get(good));
        }
        // iii.	新增3000个macbookpro库存
        resource.hincrBy("goods", "macbookpro", 3000);
        System.out.println("macbookpro修改后的库存为" + resource.hget("goods", "macbookpro"));

        //iv.	删除整个Hash的数据
        resource.del("goods");
    }

    @Test
    public void listTest() {
        Jedis resource = jedisPool.getResource();
        /*c)	list类型
         */
        //i.	向list的左边插入以下三个手机号码：18511310001、18912301231、18123123312
        resource.lpush("phone", "18511310001", "18912301231", "18123123312");
        //  ii.	从右边移除一个手机号码
        resource.rpop("phone");
        //  iii.	获取list所有的值
        List<String> phone = resource.lrange("phone", 0, -1);
        for (String s : phone) {
            System.out.println(s);
        }
    }

    @Test
    public void setTest() {
        /*a)	set类型
*/
        Jedis resource = jedisPool.getResource();
        //i.	往一个set中添加页面 page1 的uv，用户user1访问一次该页面
        resource.sadd("page1","user1");
        // ii.	user2访问一次该页面
        resource.sadd("page1","user2");
        //iii.	user1再次访问一次该页面
        resource.sadd("page1","user1");
        // iv.	最后获取 page1的uv值
        Long page1 = resource.scard("page1");
        System.out.println("page1页面的访问uv量为"+page1);


    }

    @AfterTest
    public void closePool() {
        jedisPool.close();
    }
}

