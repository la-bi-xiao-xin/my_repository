package hive_mymath;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;

public class My_Udtf extends GenericUDTF {
    private final transient Object[] forwardListObj = new Object[1];

    @Override
    public void process(Object[] objects) throws HiveException {
        //1:获取原始数据
        String line = objects[0].toString();
        //2:获取数据传入的第二个参数，此处为分隔符
        String splitKey = objects[1].toString();
        //3.将原始数据按照传入的分隔符进行切分
        String[] split = line.split(splitKey);

        //4:遍历切分后的结果，并写出
        for (String word : split) {
            //将每一个单词添加值对象数组
            forwardListObj[0] = word;
            //将对象数组内容写出
            forward(forwardListObj);

        }

    }

    @Override
    public void close() throws HiveException {

    }
}
