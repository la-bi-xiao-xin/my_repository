package sort;


import org.apache.hadoop.io.WritableComparable;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SortPojo implements WritableComparable<SortPojo> {
//定义成员变量
    private String word;
    private String num;
//定义空参构造    如果不定义运行不了,底层需要
    public SortPojo() {
    }

    //定义构造方法,全参
    public SortPojo(String word, String num) {
        this.word = word;
        this.num = num;
    }
//定义成员变量设置和获取方法
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
//toString方法重写
    @Override
    public String toString() {
        return word + "\t" + num;
    }
//排序方式重写
    @Override
    public int compareTo(SortPojo o) {
        int i = o.word.compareTo(this.word);//对word排序,字典倒叙this在内
        if (i == 0) {
            int i1 = this.num.compareTo(o.num);//word相同时,排序,字典升序,this在外
            return i1;
        }
        return i;
    }
//序列化方法重写
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(word);
        out.writeUTF(num);

    }
//反序列化方法重写
    @Override
    public void readFields(DataInput in) throws IOException {
        this.word = in.readUTF();
        this.num = in.readUTF();
    }
}
