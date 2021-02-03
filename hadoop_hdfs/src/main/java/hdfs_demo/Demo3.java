package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

//需求: 创建一个文件夹
public class Demo3 {
    public static void main(String[] args) throws Exception{
        //1.创建文件系统对象
        URI uri = new URI("hdfs://node1:8020");
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.newInstance(uri, conf, "root");

        //2.具体操作
        boolean mkdirs = fileSystem.mkdirs(new Path("/123/1234"));
        System.out.println(mkdirs);

        //3.释放资源
        fileSystem.close();
    }
}
