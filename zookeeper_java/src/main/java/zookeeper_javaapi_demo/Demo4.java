package zookeeper_javaapi_demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        //1.创建客户端对象
        String path="192.168.88.161:2181,192.168.88.162:2181,192.168.88.163:2181";
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 1);
        CuratorFramework client =  CuratorFrameworkFactory.newClient(path,retry);

        //2.开启客户端
        client.start();
        //3.执行数据操作
       client.delete().forPath("/hello2");
        //4.释放资源
        client.close();

    }

}
