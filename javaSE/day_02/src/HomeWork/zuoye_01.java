package HomeWork;
/*
1. 身高是具有遗传性的，子女的身高和父母的身高有一定的关系。
         假定，父母和子女的身高遗传关系如下：
        儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
        女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
        现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？
*/

import java.util.Scanner;

public class zuoye_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入父亲身高(cm)");
        double a = sc.nextInt();
        System.out.println("请输入母亲的身高(cm)");
        double b = sc.nextInt();
        System.out.println("儿女身高如下:");
        double arry[] = getHeight(a, b);
        getArr(arry);

    }

    /**
     * 此方法功能为求出数a数b经过公式(a+b)×1.08÷2和公式(a×0.923+b)÷2计算后的结果,并存入数组中
     *
     * @param a 父亲的身高
     * @param b 母亲的身高
     * @return 返回存储了儿女身高数据的数组
     */
    public static double[] getHeight(double a, double b) {
        double girl = (a + b) * 1.08 / 2;
        double boy = (a * 0.923 + b) / 2;
        double[] arr = {girl, boy};
        return arr;
    }

    /**
     * 此方法用于数组遍历
     *
     * @param arr
     */
    public static void getArr(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((int) arr[i]);

        }
    }
}
