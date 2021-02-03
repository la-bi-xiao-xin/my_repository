package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
第1题: 模拟斗地主发牌.
        版本2: 有序的牌.
*/
public class Extend_01_2 {
    public static void main(String[] args) {
        //1.制造扑克牌
        String[] color = {"♠", "♦", "♣", "♥"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //2.创建HashMap集和存放扑扑克牌所以和扑克牌
        HashMap<Integer, String> hm = new HashMap<>();

        //3.创建Arraylist集合存放扑克索引
        ArrayList<Integer> al = new ArrayList<>();

        //4.存放扑克和扑克索引
        Integer count = 0;
        for (int i = 0; i < number.length; i++) {
            String a = number[i];
            for (int j = 0; j < color.length; j++) {
                String b = color[j];
                hm.put(count, a + b);
                al.add(count);
                count++;

            }
        }
        hm.put(52, "小王");
        hm.put(53, "大王");
        al.add(52);
        al.add(53);
        System.out.println(hm);
        System.out.println(al);
        //5.洗牌
        Collections.shuffle(al);
        //6.创建集合接收发的牌索引
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        //7.发放扑克索引
        for (int i = 0; i < al.size(); i++) {
            if (i < 51) {
                if (i % 3 == 0)
                    player1.add(al.get(i));
                else if (i % 3 == 1)
                    player2.add(al.get(i));
                else if (i % 3 == 2)
                    player3.add(al.get(i));
            } else
                dipai.add(al.get(i));
        }
        //8.看牌
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dipai);
        lookPoker(hm, player1);
        lookPoker(hm, player2);
        lookPoker(hm, player3);
        lookPoker(hm, dipai);
    }

    //创建看牌方法
    public static void lookPoker(HashMap<Integer, String> hm, ArrayList<Integer> al) {
        for (Integer key : al) {
            System.out.print(hm.get(key) + "  ");
        }
        System.out.println();
    }
}
