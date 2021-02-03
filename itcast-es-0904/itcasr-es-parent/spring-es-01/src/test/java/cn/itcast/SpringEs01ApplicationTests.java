package cn.itcast;

import cn.itcast.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringEs01ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() {
        boolean flag = template.createIndex(Goods.class);
        System.out.println("创建索引是否成功: " + flag);
    }

    @Test
    public void testPutMapping() {
        boolean flag = template.putMapping(Goods.class);
        System.out.println("创建类型是否成功: " + flag);
    }

    @Test
    public void testDeleteIndex(){
        boolean flag = template.deleteIndex("goods");
        System.out.println("删除库是否成功"+flag);
    }
}
