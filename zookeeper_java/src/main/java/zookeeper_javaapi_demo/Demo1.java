package zookeeper_javaapi_demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        //1.第一步创建zookeeper客户端对象
        String connectionStr="192.168.88.161:2181,192.168.88.162:2181,192.168.88.163:2181";
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 1);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectionStr, retryPolicy);

        //2.开启客户端
        client.start();

        //3.调用方法执行数据CUDR操作
        //client.create().forPath("/aaaaaaa","helloword".getBytes());
        client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/hello2","world".getBytes());
        //4.释放资源
        client.close();
    }
}
