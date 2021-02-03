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

    // 因为一个用户对应一个用户扩展信息, 所以讲userinfo设置为对象
    private Userinfo userinfo;

    // 因为一个用户 可能对应 多个订单, 所以讲 订单设计成 集合
    List<Orderform> orders;

}