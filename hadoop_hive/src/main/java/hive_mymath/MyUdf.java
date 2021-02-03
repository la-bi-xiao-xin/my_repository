package hive_mymath;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;


public class MyUdf extends UDF {
    public Text evaluate(final Text s){
        if(s==null){
            return null;
        }
        Text text = new Text(s.toString().toUpperCase());
        return text;
    }
}

