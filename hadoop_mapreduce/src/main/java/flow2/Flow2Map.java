package flow2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;

public class Flow2Map extends Mapper<LongWritable, Text, Flow2Pojo, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line != null && !"".equals(line)) {
            String[] split1 = line.split("\t");
            String s = Arrays.toString(split1);
            System.out.println(s);
            Flow2Pojo flow2Pojo = new Flow2Pojo(
                    split1[0],
                    Integer.parseInt(split1[1]),
                    Integer.parseInt(split1[2]),
                    Integer.parseInt(split1[3]),
                    Integer.parseInt(split1[4]));
            context.write(flow2Pojo, NullWritable.get());
        }

    }
}
