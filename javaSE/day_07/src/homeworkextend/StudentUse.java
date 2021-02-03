package homeworkextend;

import java.util.Scanner;

public class StudentUse {
    public static void main(String[] args) {

       Student[] studentArry= getStudentArr();
        outStudentArry(studentArry);
        //getSum(studentArry);
        System.out.println("***************");
        getSum2(studentArry);
        System.out.println("***************");

        getMax(studentArry);
    }

    public static void getMax(Student[] studentArry) {
        for (int i = 0; i < studentArry.length-1; i++) {
            if(studentArry[i].getSum()>studentArry[i+1].getSum()){
                Student temp=studentArry[i];
                studentArry[i]=studentArry[i+1];
                studentArry[i+1]=temp;
            }
            Student a=studentArry[studentArry.length-1];
            System.out.println("分数最高的是"+a.getName()+"总分为"+a.getSum()+"语文成绩为"+
                    a.getScoreChinese()+"英语成绩为"+a.getScoreEnglish()+"数学成绩为"+a.getScoreMath());


        }
    }


    public static void getSum2(Student[] studentArry) {

        for (int i = 0; i <studentArry.length; i++) {
            System.out.println(studentArry[i].getName()+"同学的总分为:"+studentArry[i].getSum());

        }

    }

    public static void outStudentArry(Student[] studentArry) {
        for (int i = 0; i < studentArry.length; i++) {
            System.out.println(studentArry[i]);
        }
    }

    /*public static void getSum(Student[] studentArry) {
        for (int i = 0; i <studentArry.length ; i++) {
            int sum=studentArry[i].getScoreChinese()+studentArry[i].getScoreEnglish()+studentArry[i].getScoreMath();
            System.out.println(studentArry[i].getName()+"同学的总分为:"+sum);
        }
    }*/

    public static Student[] getStudentArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生人数");
        int number = sc.nextInt();
        Student[] studentArr = new Student[number];
        for (int i = 0; i < studentArr.length; i++) {
            studentArr[i]=new Student();
            System.out.println("请输入第" + (i + 1) + "个学生姓名");
            studentArr[i].setName(sc.next());
            System.out.println("请输入第" + (i + 1) + "个学生语文成绩");
            studentArr[i].setScoreChinese(sc.nextInt());
            System.out.println("请输入第" + (i + 1) + "个学生数学成绩");
            studentArr[i].setScoreMath(sc.nextInt());
            System.out.println("请输入第" + (i + 1) + "个学生英语成绩");
            studentArr[i].setScoreEnglish(sc.nextInt());

        }
        return studentArr;
    }

}
