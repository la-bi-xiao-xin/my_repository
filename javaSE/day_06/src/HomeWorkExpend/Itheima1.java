package HomeWorkExpend;
/*
书写一个类，类名为Itheima;
        类中有一个方法，方法名lessBy10;
        给定三个int数，a、b、c，如果存在 任意两个参数的差值大于等于10就返回true，否则返回false。
        书写一个类，类名为Itheima;
        类中有一个方法，方法名lessBy10;
        给定三个int数，a、b、c，如果存在 任意两个参数的差值大于等于10就返回true，否则返回false。
*/

public class Itheima1 {
    private  int a;
    private  int b;
    private  int c;

    public Itheima1() {
    }

    public Itheima1(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }


    public void setC(int c) {
        this.c = c;
    }

    /**
     * 此方法用于判断三个数之间是否存在差值大于等于10的情况
     * @return 存在返回true 不存在返回false
     */
    public boolean judge(){

        boolean result=false;
        if(a>b && a-b>=10){
            result=true;
        }else if(a<b && b-a>=10){
            result=true;
        }else if(a>c && a-c>=10){
            result=true;
        }else if(a<c && c-a>=10){
            result=true;
        }else if(b>c && b-c>=10){
            result=true;
        }else if(b<c && c-b>=10){
            result=true;
        }else{
            result=false;

        }
        return result;
    }
}
