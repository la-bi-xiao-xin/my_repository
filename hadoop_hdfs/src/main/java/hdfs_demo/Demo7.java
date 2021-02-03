package hdfs_demo;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//需求: 将本地小文件合并至hdfs文件系统中  ,(合并流程)
public class Demo7 {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        //1.创建文件系统对象
        URI uri = new URI("hdfs://node1:8020");
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(uri,conf,"root");
        //2.对应操作
        //2.1在hdfs文件系统中创建文件,并得到文件的输出流(用于往文件里面写东西,这输出流名字面和实际有一点不符合,个人认为)
        FSDataOutputStream outputStream = fileSystem.create(new Path("/123/2.txt"));
        //2.2创建本地文件系统对象
        Configuration conf1 = new Configuration();
        FileSystem localfileSystem = FileSystem.newInstance(conf1);
        //2.3获取本地文件集合
        RemoteIterator<LocatedFileStatus> remoteIterator = localfileSystem.listFiles(new Path("F:\\大数据就业班资料\\lesion2\\day11_HDFS\\需要合并的文件"), false);
        //2.4遍历文件集合,并将文件写入hdfs文件输出流中
        while (remoteIterator.hasNext()) {
            LocatedFileStatus fileStatus = remoteIterator.next();
            Path path = fileStatus.getPath();
            FSDataInputStream inputStream = localfileSystem.open(path);
            int copy = IOUtils.copy(inputStream,outputStream);

            //inputStream.close();
            outputStream.flush();
        }
        //3.释放资源
        outputStream.close();
        fileSystem.close();
    }
}
