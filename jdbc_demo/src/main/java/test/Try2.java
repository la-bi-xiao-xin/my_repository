package test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class Try2 {
    @Test
    public void joinerListTest() {
        List<String> lists = Lists.newArrayList("a","b","g","8","9");
        String result = Joiner.on(",").join(lists);
        System.out.println(result);
    }
}
