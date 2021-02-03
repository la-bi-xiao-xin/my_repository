package flowcop;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements Writable {

    private  Integer upFlow;  // 上行流量
    private  Integer downFlow; // 下行流量
    private  Integer upTotalFlow; // 上行总流量
    private  Integer downTotalFlow;  // 下行总流量

    public FlowBean() {
    }

    public FlowBean(Integer upFlow, Integer downFlow, Integer upTotalFlow, Integer downTotalFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.upTotalFlow = upTotalFlow;
        this.downTotalFlow = downTotalFlow;
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

    public Integer getUpTotalFlow() {
        return upTotalFlow;
    }

    public void setUpTotalFlow(Integer upTotalFlow) {
        this.upTotalFlow = upTotalFlow;
    }

    public Integer getDownTotalFlow() {
        return downTotalFlow;
    }

    public void setDownTotalFlow(Integer downTotalFlow) {
        this.downTotalFlow = downTotalFlow;
    }

    @Override
    public String toString() {
        return upFlow +"\t"+downFlow+"\t"+upTotalFlow+"\t"+downTotalFlow;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(upFlow);
        out.writeInt(downFlow);
        out.writeInt(upTotalFlow);
        out.writeInt(downTotalFlow);

    }

    @Override
    public void readFields(DataInput in) throws IOException {

       this.upFlow = in.readInt();
       this.downFlow =  in.readInt();
       this.upTotalFlow = in.readInt();
       this.downTotalFlow = in.readInt();

    }
}
