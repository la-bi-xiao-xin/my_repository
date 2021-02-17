package test;
//  1.递归案例,帮做我理解递归思维

public class RecursionDemo {
    //创建递归求和的方法
    public static int sum(int a){
        int result = 0;

            if(a==1){
                return 1;
            }else {
                result = a+sum(a-1);
            }

        return result;
    }
    //创建主方法
    public static void main(String[] args) {
        int sum = RecursionDemo.sum(5);
        System.out.println(sum);


    }
}
