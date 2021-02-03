package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import java.net.URI;
/*3) 额外作业: 从HDFS中 根目录下读取所有的文件,将文件名称在控制台打印, 然后价格每个文件下载到本地,
下载完成后, 打出 ”已经全部下载完成, 开始进行上传:” ,
 最后读取下载到本地所有的文件, 将其上传到 HDFS的 /localSsystem/,(在上传前, 先去将这个目录创建好)*/
public class Demo8 {
    public static void main(String[] args) throws Exception {
        //将hdfs系统中的文件下载至本地
        //1.获取hdfs文件系统对象
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://node1:8020"), new Configuration());
        //2.获取目标目录下的文件集合并迭代器遍历集合下载至本地目录
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/"), true);
        while (iterator.hasNext()) {
            LocatedFileStatus fileStatus = iterator.next();
            Path path = fileStatus.getPath();
            fileSystem.copyToLocalFile(path, new Path("F:\\大数据就业班资料\\lesion2\\day11_HDFS\\从hdfs拷贝文的件"));
        }

        //将本地文件上传至hdfs系统中
        //1.创建本地文文件系统对象   Configuration不传参时默认为连接本地文件系统
        FileSystem localfileSystem = FileSystem.get(new Configuration());
        //2.获取本地文件系统目标目录下的文件集合迭代器,迭代器遍历上传文件
        RemoteIterator<LocatedFileStatus> iterator1 = localfileSystem.listFiles(new Path("F:\\大数据就业班资料\\lesion2\\day11_HDFS\\从hdfs拷贝文的件"), false);
        while (iterator1.hasNext()) {
            LocatedFileStatus fileStatus2 = iterator1.next();
            Path path2 = fileStatus2.getPath();
            // localfileSystem.copyFromLocalFile(path2, new Path("/localSsystem")); 错的原因,无论时上传还行下载,操作的对象都应该时hdfs文件系统
            fileSystem.copyFromLocalFile(path2, new Path("/localSsystem"));
        }
        //释放资源
        fileSystem.close();
        localfileSystem.close();
    }
}
