package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

// 需求 创建一个文件,输入相关的内容
public class Demo4 {
    public static void main(String[] args) throws Exception {
        //1.创建文件系统对象
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://node1:8020");
        FileSystem fileSystem = FileSystem.get(uri, conf);

        //2.执行操作
        FSDataOutputStream outputStream = fileSystem.create(new Path("/123/1.txt"));
        byte[] bytes = "我爱你".getBytes();
        outputStream.write(bytes);
        outputStream.flush();
        //3.释放资源
        fileSystem.close();

    }
}
