package flinkbatch;

import Pojo.Subject;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.CsvReader;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.configuration.Configuration;

/*读取本地文件数据
  读取HDFS文件数据
  读取CSV文件数据
  读取压缩文件
  遍历目录
*/
public class FlinkDataSourceFromFile {
    public static void main(String[] args) {
        int error = 0;
        try {
            //1.获取Flink执行环境
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

            //2.从文件中读取数据作为数据源
            //2.1从本地文件系统获取数据
            DataSource<String> textFile = env.readTextFile("./data/input/ab.txt");

            //2.2读取HDFS文件数据
            DataSource<String> hdfsFile = env.readTextFile("hdff//192.168.88.20:8020/input/license.txt");

            //2.3读取CSV文件数据
            CsvReader csvFile = env.readCsvFile("./data/input/subject.csv");
            DataSource<Subject> csvDataSource = csvFile.fieldDelimiter(",").includeFields(true, true).pojoType(Subject.class, "id", "subject");

            //2.4读取压缩文件
            DataSource<String> gzFile = env.readTextFile("./data/input/wordcount.txt.gz");

            //2.5遍历目录
            Configuration configuration = new Configuration();
            configuration.setBoolean("recursive.file.enumeration",true);
            DataSource<String>  source = env.readTextFile("./data").withParameters(configuration);

            //3.打印获取的数据
            //3.1打印从本地读取的txt文件
            // textFile.print();
            //System.out.println(textFile.getParallelism());

            //3.3打印从本地读取的csv文件
            // csvDataSource.print();

            //3.4打印读取到的压缩文件
           //gzFile.print();

            //3.5打印从目录中读取的数据  多种类型的数据会全部读取到么
            System.out.println("*****************************************");
            source.print();

        } catch (Exception e) {
            e.printStackTrace();
            error++;
        } finally {
            System.out.println("总共有:" + error + "个错误!");
        }


    }


}
