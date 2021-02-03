package exercise;
//4. 已知世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米).
//   假如我有一张足够大的纸，它的厚度是0.1毫米.
//   请问，我折叠多少次，可以折成珠穆朗玛峰的高度?
//   //即: 纸张的厚度 >= 珠穆朗玛峰的高度
public class HomeWork_04 {
    public static void main(String[] args) {
        double sangao=8844.43*1000;
        double zihou=0.1;
        int count=0;

        while(zihou<sangao){
            zihou=zihou*2;
            count++;
        }
        System.out.println("折叠"+count+"次后纸张厚度大于珠穆朗玛峰山高");

        }

    }

