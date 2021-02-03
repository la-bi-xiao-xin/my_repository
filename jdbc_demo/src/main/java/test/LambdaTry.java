package test;

import mapper.Action;
import mapper.Eatable;
import mapperImpl.EatableImpl;
import org.junit.Test;

public class LambdaTry {
    public static void main(String[] args) {
       /* //在主方法中调用useEatable方法
        Eatable e = new EatableImpl();
        useEatable(e);
        */
        //使用匿名内部类的方法
       /* useEatable(new Eatable() {
            public void eat() {
                System.out.println("吃饭的方式是匿名内部类");
            }
        });
*/

        //用lambda表达式
        useEatable(() -> {
            System.out.println("吃饭用lambda表达式");
        });


        useAction((String a)->{
            System.out.println(a);
            return a;
        });
    }


    private static void useEatable(Eatable e) {
        e.eat();
    }

    private static void useAction(Action a) {
        String s = a.speak("小明你好");
        System.out.println(s);

    }
}
