package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
第1题: 模拟斗地主发牌.
        版本1: 无序的牌.
 */
public class Extend_01_1 {
    public static void main(String[] args) {
        //1.制造扑克牌
        String[] color = {"♠", "♦", "♣", "♥"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //2创建Arraylist集合存放扑克
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < number.length; i++) {
            String a = number[i];
            for (int j = 0; j < color.length; j++) {
                String b = color[j];
                arrayList.add(a + b);

            }
        }
        arrayList.add("小王");
        arrayList.add("大王");
        System.out.println(arrayList);


        //2.洗牌
        Collections.shuffle(arrayList);

        //3.发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i < 51) {
                if (i % 3 == 0)
                    player1.add(arrayList.get(i));
                else if (i % 3 == 1)
                    player2.add(arrayList.get(i));
                else if (i % 3 == 2)
                    player3.add(arrayList.get(i));
            } else
                dipai.add(arrayList.get(i));
        }

        //4.看牌
        lookPoker(player1);
        lookPoker(player2);
        lookPoker(player3);
        lookPoker(dipai);

    }

    //创建看牌方法
    public static void lookPoker(ArrayList<String> al) {
        for (String s : al) {
            System.out.print(s + "  ");
        }
        System.out.println();
    }
}
