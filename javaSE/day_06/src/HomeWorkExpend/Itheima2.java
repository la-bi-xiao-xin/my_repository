package HomeWorkExpend;

public class Itheima2 {
    private int a;
    private int b;
    private int c;

    public Itheima2() {
    }

    public Itheima2(int a, int b, int c) {
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
     * 此方法判断a*1+b*5==c || a*5+b*1==c,输入大小砖顺序不限定
     * @return 判断结果,拼接成功为true,不成功为false
     */
    public boolean makeBricks(){
        boolean result=false;
       /* if(a*1+b*5==c || a*5+b*1==c ){
             result=true;
        }else {
            result=false;
        }*/
       result=(a*1+b*5==c || a*5+b*1==c )?true:false;
        return result;
    }
}
