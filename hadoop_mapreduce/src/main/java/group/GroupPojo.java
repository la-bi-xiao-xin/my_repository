package group;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class GroupPojo implements WritableComparable<GroupPojo> {
    private String orderId;
    private String pdtId;
    private Double price;

    public GroupPojo() {
    }

    public GroupPojo(String orderId, String pdtId, Double price) {
        this.orderId = orderId;
        this.pdtId = pdtId;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPdtId() {
        return pdtId;
    }

    public void setPdtId(String pdtId) {
        this.pdtId = pdtId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return orderId + "\t"+ pdtId +"\t"+ price;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(orderId);
        out.writeUTF(pdtId);
        out.writeDouble(price);

    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.orderId=in.readUTF();
        this.pdtId=in.readUTF();
        this.price=in.readDouble();

    }
//排序方法重写,按照price降序排序  this在括号里面为降序
    @Override
    public int compareTo(GroupPojo o) {
        int i = o.price.compareTo(this.price);
        return i;
    }
}
