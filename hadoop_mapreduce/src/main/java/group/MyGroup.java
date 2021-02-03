package group;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyGroup extends WritableComparator {
    public MyGroup() {
        super(GroupPojo.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        GroupPojo a1=(GroupPojo)a;
        GroupPojo b1=(GroupPojo)b;
        int i = a1.getOrderId().compareTo(b1.getOrderId());
        return i;
    }
}
