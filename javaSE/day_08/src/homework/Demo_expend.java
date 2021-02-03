package homework;
/*
扩展题:
        已知有1, 2, 3, 4 这四个数字, 问它们能组合成的四位数字形式有哪些,
        并将结果打印到控制台上.
        要求: 该四位数字必须包含1, 2, 3, 4 这四个数字.

        需求1: 将满足上述条件的数字, 按照3个一行的顺序打印到控制台上, 例如:
        //这里只是模拟打印格式, 不一定非得是这种打印顺序
        1234	1243	1324
        1432	...

        需求2: 基于上述的要求, 加入如下的条件
        1. 数字4不能开头.
        2. 数字1和3不能挨着, 即: 2134 和 2314都不行.
        3. 将满足条件的数据按照 5 个一行的顺序, 打印到控制台上.

        需求3: 要求5行以内搞定.
        */
public class Demo_expend {
    public static void main(String[] args) {
        //需求1: 将满足上述条件的数字, 按照3个一行的顺序打印到控制台上
        math1();
        System.out.println("******************************************");
        // 需求2:
        math2();
    }

    public static void math2() {
        for (int i = 1111,ge=0,shi=0,bai=0,qian=0,count=0; i <=4444 ; i++) {
            ge=i%10;
            shi=i/10%10;
            bai=i/100%10;
            qian=i/1000%10;
            if(ge!=shi && ge!=bai && ge!=qian && shi!=bai && shi!=qian && bai!=qian &&
                    ge>=1 && ge<=4 && shi>=1 && shi<=4 && bai>=1 &&bai<=4 && qian>=1 &&qian<4 &&
                    ge+shi!=4 &&shi+bai!=4&&bai+qian!=4){
                System.out.print(i+"   ");
                count++;
                if(count%5==0)
                    System.out.println();
            }
        }
    }

    public static void math1() {
        for (int i = 1111,ge=0,shi=0,bai=0,qian=0,count=0; i <=4444 ; i++) {
            ge=i%10;
            shi=i/10%10;
            bai=i/100%10;
            qian=i/1000%10;
            if(ge!=shi && ge!=bai && ge!=qian && shi!=bai && shi!=qian && bai!=qian &&
                    ge>=1 && ge<=4 && shi>=1 && shi<=4 && bai>=1 &&bai<=4 && qian>=1 &&qian<=4){
                System.out.print(i+"   ");
                count++;
                if(count%3==0)
                    System.out.println();
            }
        }
    }
}
