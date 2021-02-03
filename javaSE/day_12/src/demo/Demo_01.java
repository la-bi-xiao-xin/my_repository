package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo_01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day_12\\dat2\\1.txt");
        System.out.println(fis.read());

    }
}
