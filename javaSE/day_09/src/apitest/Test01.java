package apitest;

public class Test01 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        String s = "abcabcabc";
        String s2 = "efcabvsss";
        // String s=new String();
        System.out.println(s);
        System.out.println(s.regionMatches(true, 2, s2, 2, 3));
    }
}
