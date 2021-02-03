import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串.");
        String str=sc.nextLine();
        char[] charArray = str.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i <charArray.length ; i++) {
            if (charArray[i]>='0' && charArray[i]<='9'){
                sb1.append(charArray[i]);
            }else if(charArray[i]>='A' && charArray[i]<='z') {
                sb2.append(charArray[i]);
            }
        }
        System.out.println(sb1.toString()+sb2.toString());

    }
}
