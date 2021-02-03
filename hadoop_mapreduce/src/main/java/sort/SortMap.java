package sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortMap extends Mapper <LongWritable,Text,SortPojo, NullWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if(line!=null && !"".equals(line)){//判断读入数据是否为空
            String[] lines = line.split("\t");//将数据按照tab分割
            SortPojo sortPojo = new SortPojo(lines[0], lines[1]);//将word , num封装成k2
            context.write(sortPojo,NullWritable.get());//输出K2,V2

        }

    }
}
