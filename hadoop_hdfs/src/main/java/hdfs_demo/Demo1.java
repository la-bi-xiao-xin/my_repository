package hdfs_demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

//获取 HDFS的FileSsystem 对象(6种方式)
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //方式1:
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://node1:8020");
        FileSystem fileSystem = FileSystem.get(conf);
        System.out.println(fileSystem.toString());
        System.out.println("**********************");
        //方式2
        URI uri = new URI("hdfs://node1:8020");
        Configuration conf2 = new Configuration();
        FileSystem fileSystem1 = FileSystem.get(uri, conf2);
        System.out.println(fileSystem1);
        System.out.println("**************************");
        //方式3
        URI uri1 = new URI("hdfs://node1:8020");
        Configuration conf3 = new Configuration();
        FileSystem fileSystem2 = FileSystem.get(uri, conf3, "root");
        System.out.println(fileSystem2);
        System.out.println("******************************");
        //方式4
        Configuration conf4 = new Configuration();
        conf4.set("fs.defaultFS","hdfs://node1:8020");
        FileSystem fileSystem3 = FileSystem.newInstance(conf4);
        System.out.println(fileSystem3);
        System.out.println("***************************");
        //方式5
        URI uri2 = new URI("hdfs://node1:8020");
        Configuration conf5 = new Configuration();
        FileSystem fileSystem4 = FileSystem.newInstance(uri2, conf5);
        System.out.println(fileSystem4);
        System.out.println("*****************************");
        //方式6
        URI uri3 = new URI("hdfs://node1:8020");
        Configuration conf6 = new Configuration();
        FileSystem fileSystem5 = FileSystem.newInstance(uri3, conf6, "root");
        System.out.println(fileSystem5);
    }
}
