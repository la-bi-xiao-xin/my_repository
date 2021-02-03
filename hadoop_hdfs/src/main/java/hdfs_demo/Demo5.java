package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

// 需求: 从hdfs系统中下载文件
public class Demo5 {
    public static void main(String[] args) throws IOException {
        //1.创建文件系统对象
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://node1:8020");
        FileSystem fileSystem = FileSystem.get(conf);

        //2.具体操作
        fileSystem.copyToLocalFile(new Path("/123/1.txt"),new Path("F:\\大数据就业班资料\\lesion2\\day11_HDFS\\11.txt"));

        //3.释放资源
        fileSystem.close();

    }
}
