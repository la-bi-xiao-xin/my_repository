package flow2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Flow2Pojo implements WritableComparable<Flow2Pojo> {
    //定义变量
    private String phone;
    private Integer upFlow;
    private Integer downFlow;
    private Integer upFlowTotal;
    private Integer downFlowTotal;

    //定义空参构造
    public Flow2Pojo() {
    }

    //定义全参构造
    public Flow2Pojo(String phone, Integer upFlow, Integer downFlow, Integer upFlowTotal, Integer downFlowTotal) {
        this.phone = phone;
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.upFlowTotal = upFlowTotal;
        this.downFlowTotal = downFlowTotal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Integer upFlow) {
        this.upFlow = upFlow;
    }

    public Integer getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(Integer downFlow) {
        this.downFlow = downFlow;
    }

    public Integer getUpFlowTotal() {
        return upFlowTotal;
    }

    public void setUpFlowTotal(Integer upFlowTotal) {
        this.upFlowTotal = upFlowTotal;
    }

    public Integer getDownFlowTotal() {
        return downFlowTotal;
    }

    public void setDownFlowTotal(Integer downFlowTotal) {
        this.downFlowTotal = downFlowTotal;
    }

    //重写toString方法
    @Override
    public String toString() {
        return phone + "\t" + upFlow + "\t" + downFlow + "\t" + upFlowTotal + "\t" + downFlowTotal;
    }


    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(phone);
        out.writeInt(upFlow);
        out.writeInt(downFlow);
        out.writeInt(upFlowTotal);
        out.writeInt(downFlowTotal);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.phone=in.readUTF();
        this.upFlow=in.readInt();
        this.downFlow=in.readInt();
        this.upFlowTotal=in.readInt();
        this.downFlowTotal=in.readInt();

    }

    @Override
    public int compareTo(Flow2Pojo o) {
        int i = o.upFlow.compareTo(this.upFlow);//倒序
        return i;
    }
}
