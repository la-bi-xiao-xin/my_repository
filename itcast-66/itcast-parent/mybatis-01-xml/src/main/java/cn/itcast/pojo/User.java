package cn.itcast.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer id, String username, String password, String name, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }
}
