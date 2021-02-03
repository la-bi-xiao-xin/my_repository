package flow11;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Flow11Group extends WritableComparator {
    public Flow11Group() {
        super( Flow11Pojo.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        Flow11Pojo a1=(Flow11Pojo)a;
        Flow11Pojo b1=(Flow11Pojo)b;
        int i = a1.getPhone().compareTo(b1.getPhone());
        return i;
    }
}
