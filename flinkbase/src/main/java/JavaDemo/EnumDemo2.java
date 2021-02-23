package JavaDemo;

public enum EnumDemo2 {
    TABLE(1, "表"),

    COLUMN(2, "字段"),

    VIEW(3, "视图");

    int code;
    String name;

    EnumDemo2(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}

class EnumUser2{
    public static void main(String[] args) {
        EnumDemo2 table = EnumDemo2.TABLE;
        System.out.println(table);

    }
}