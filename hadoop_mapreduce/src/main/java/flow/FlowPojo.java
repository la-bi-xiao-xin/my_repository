package flow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowPojo implements Writable {
    //定义变量
    private Integer upFlow;
    private Integer downFlow;
    private Integer upFlowTotal;
    private Integer downFlowTotal;
   //空参构造
    public FlowPojo() {
    }
    //全参构造
    public FlowPojo(Integer upFlow, Integer downFlow, Integer upFlowTotal, Integer downFlowTotal) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.upFlowTotal = upFlowTotal;
        this.downFlowTotal = downFlowTotal;
    }
  //set和get方法
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
//toString方法重写
    @Override
    public String toString() {
        return upFlow +"\t"+ downFlow + "\t"+ upFlowTotal + "\t"+ downFlowTotal;
    }
//序列化方法重写
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(upFlow);
        out.writeInt(downFlow);
        out.writeInt(upFlowTotal);
        out.writeInt(downFlowTotal);
    }
//反序列化方法重写  与上面序列发顺序一致
    @Override
    public void readFields(DataInput in) throws IOException {
        this.upFlow=in.readInt();
        this.downFlow=in.readInt();
        this.upFlowTotal=in.readInt();
        this.downFlowTotal=in.readInt();

    }
}
