package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor // 满参构造
@NoArgsConstructor // 无参构造
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private String sex;
    private String address;

    // 一对一
    private Userinfo userinfo;
    // 一对多
    private List<Orderform> orders;
}
