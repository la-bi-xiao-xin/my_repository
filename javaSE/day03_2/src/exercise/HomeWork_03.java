package exercise;
//3. 把1~100之间的奇数, 按照6个一行的格式进行输出.
//	核心点: 统计遍历, 输出一个就++,  标记变量: 几个一行.
public class HomeWork_03 {
    public static void main(String[] args) {
        int count=0;
        for (int i = 1; i <=100 ; i=i+2) {
            System.out.print(i+"\t");
            count++;
            if(count%6==0){
                System.out.println();

            }


        }
    }
}
