package hdfs_demo;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.net.URI;

public class Demo7_2 {
    public static void main(String[] args) throws Exception{
        //1. 创建 HDFS的客户端对象
        FileSystem hdfsFileSystem = FileSystem.get(new URI("hdfs://node1:8020"), new Configuration());

        //2. 执行相关操作: 创建一个文件, 获取这个文件的输出流
        FSDataOutputStream outputStream = hdfsFileSystem.create(new Path("/123/22.txt"));


        //3. 获取本地的文件系统

        LocalFileSystem localFileSystem = FileSystem.getLocal(new Configuration());

        //4. 获取某个路径下所有的小文件
        RemoteIterator<LocatedFileStatus> listFiles = localFileSystem.listFiles(new Path("F:\\大数据就业班资料\\lesion2\\day11_HDFS\\需要合并的文件"), false);

        while(listFiles.hasNext()){

            LocatedFileStatus fileStatus = listFiles.next();

            Path path = fileStatus.getPath();
            //System.out.println(path.toUri().getPath()); file:/
            //FileInputStream inputStream = new FileInputStream(path.toString());

            FSDataInputStream inputStream = localFileSystem.open(path);

            IOUtils.copy(inputStream,outputStream);

            IOUtils.closeQuietly(inputStream);

        }

        outputStream.flush();

        //5. 释放资源
        localFileSystem.close();
        hdfsFileSystem.close();

    }
}
