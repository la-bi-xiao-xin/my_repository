package flowcop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Flow1MapperTask extends Mapper<LongWritable,Text,Text,FlowBean> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1. 读取一行数据
        String line = value.toString();

        //2.判断操作
        if( line!=null && !"".equals(line)  ){

            //2.1: 对数据进行切割操作
            String[] split = line.split("\t");

            //2.2: 从中找 5个数据

           String iphone        =  split[1];
           String upFlow        =  split[6];
           String downFlow      =  split[7];
           String upTotalFlow   =  split[8];
           String downTotalFlow =  split[9];

            //2.3: 封装数据
            FlowBean flowBean = new FlowBean(
                    Integer.parseInt(upFlow),
                    Integer.parseInt(downFlow),
                    Integer.parseInt(upTotalFlow),
                    Integer.parseInt(downTotalFlow)
            );
            //3. 写出去
            context.write(new Text(iphone),flowBean);

        }


    }
}
