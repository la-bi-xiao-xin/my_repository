package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;
import java.net.URISyntaxException;

// 需求: 上传文件至hdfs文件系统中
public class Demo6 {
    public static void main(String[] args) throws Exception {
        //1.创建文件系统对象
        URI uri = new URI("hdfs://node1:8020");
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.newInstance(uri, conf);

        //2.具体操作
fileSystem.copyFromLocalFile(new Path("F:\\大数据就业班资料\\lesion2\\day11_HDFS\\今日作业.docx"),
        new Path("/123"));
        //3.释放资源
        fileSystem.close();
    }
}
