package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import javax.naming.CompositeName;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//需求: 完成获取某个目录下所有的文件
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //1,创建文件系统对象fileSystem
        URI uri = new URI("hdfs://node1:8020");
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(uri, conf, "root");

        //2.进行相应操作
        RemoteIterator<LocatedFileStatus> filesIterator = fileSystem.listFiles(new Path("/"), true);
               //得到一个包含文件的集合迭代器
                while (filesIterator.hasNext()){  //迭代器遍历集合获得文件对象
                    LocatedFileStatus fileStatus = filesIterator.next();
                    System.out.println(fileStatus.getPath().getName());//文件对象调用方法获取路径对象,路径对象调用方法获取文件名称
                }
        //3.释放资源
        fileSystem.close();
    }
}
