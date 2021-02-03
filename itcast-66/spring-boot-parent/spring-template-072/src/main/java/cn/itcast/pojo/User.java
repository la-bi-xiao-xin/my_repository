package cn.itcast.pojo;

import lombok.Data;
//创建与表对应的实体类
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
}
