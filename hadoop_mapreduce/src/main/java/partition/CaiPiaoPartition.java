package partition;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;



public class CaiPiaoPartition extends Partitioner <Text, NullWritable>{


    @Override
    public int getPartition(Text text, NullWritable nullWritable, int i) {

        String string = text.toString();
        //System.out.println(string);
        String[] strings = string.split("\t");
        int i1 = Integer.parseInt(strings[5]);
        System.out.println(i1);
        if(i1<15){
            return 0;
        }else{
            return 1;
        }
    }
}
