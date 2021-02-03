package homeworkextend;


public class Student {
    private String name;
    private int scoreChinese;
    private int scoreMath;
    private int scoreEnglish;

    public Student() {

    }

    public Student(String name, int scoreChinese, int scoreMath, int scoreEnglish) {
        this.name = name;
        this.scoreChinese = scoreChinese;
        this.scoreMath = scoreMath;
        this.scoreEnglish = scoreEnglish;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoreChinese() {
        return scoreChinese;
    }

    public void setScoreChinese(int scoreChinese) {
        this.scoreChinese = scoreChinese;
    }

    public int getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(int scoreMath) {
        this.scoreMath = scoreMath;
    }

    public int getScoreEnglish() {
        return scoreEnglish;
    }

    public void setScoreEnglish(int scoreEnglish) {
        this.scoreEnglish = scoreEnglish;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scoreChinese=" + scoreChinese +
                ", scoreMath=" + scoreMath +
                ", scoreEnglish=" + scoreEnglish +
                '}';
    }

public int getSum(){
        int sum=scoreChinese+scoreEnglish+scoreMath;
    System.out.println(sum);
    return sum;
}
public void eat(){
    System.out.println("有吃饭功能");
}
public void sleep(){
    System.out.println("有睡觉能力");

}


}
