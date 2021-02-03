package group;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class GroupPartition extends Partitioner<GroupPojo, NullWritable> {

    @Override
    public int getPartition(GroupPojo groupPojo, NullWritable nullWritable, int i) {
       /* if(groupPojo.getOrderId()=="Order_0000002"){
            return 1;
        }else{
            return 0;
        }*/
        return (groupPojo.getOrderId().hashCode() & Integer.MAX_VALUE) %i;
    }
}
